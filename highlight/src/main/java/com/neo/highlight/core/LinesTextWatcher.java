package com.neo.highlight.core;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * Process edits in EdiText
 * @author Irineu A. Silva
 */
public abstract class LinesTextWatcher implements TextWatcher {

    private int start;
    private int end;

    private Editable editable;

    @Override
    public void beforeTextChanged(CharSequence actualText, int start, int count, int after) {
        int actualEnd = start + count;
        int newEnd = start + after;

        Log.d(TAG, "newChange");

        Log.d(TAG, "beforeTextChanged_start: " + start);
        Log.d(TAG, "beforeTextChanged_newEnd: " + newEnd);
        Log.d(TAG, "beforeTextChanged_actualEnd: " + actualEnd);

        this.start = start;
        this.end = newEnd;
    }

    @Override
    public void onTextChanged(CharSequence newText, int start, int before, int count) {
        int newEnd = start + count;
        int actualEnd = start + before;

        Log.d(TAG, "onTextChanged_start: " + start);
        Log.d(TAG, "onTextChanged_newEnd: " + newEnd);
        Log.d(TAG, "onTextChanged_actualEnd: " + actualEnd);

        this.start = start;
        this.end = newEnd;
    }

    @Override
    public void afterTextChanged(Editable editable) {
        this.editable = editable;

        int fastLineStart = getFastLineStart();
        int lastLineEnd = getLastLineEnd();

        Log.d(TAG, "afterTextChanged_lineStart: " + fastLineStart);
        Log.d(TAG, "afterTextChanged_lineEnd: " + lastLineEnd);

        onLinesChange(editable, start, end, fastLineStart, lastLineEnd);

    }

    protected abstract void onLinesChange(
            @NonNull Editable editable,
            int start, int end,
            int firstLineStart, int lastLineEnd
    );

    private int getLastLineEnd() {

        int lineEnd = end;

        while (lineEnd < editable.length()) {

            char c = editable.charAt(lineEnd);

            if (c == '\n') {
                break;
            }

            lineEnd++;
        }

        return lineEnd;
    }

    private int getFastLineStart() {
        int lineStart = start;

        while (lineStart > 0) {

            char c = editable.charAt(lineStart - 1);

            if (c == '\n') {
                break;
            }

            lineStart--;
        }

        return lineStart;
    }

    public static final String TAG = LinesTextWatcher.class.getSimpleName();
}

