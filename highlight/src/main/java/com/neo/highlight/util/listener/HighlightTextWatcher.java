package com.neo.highlight.util.listener;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableString;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.neo.highlight.core.Highlight;
import com.neo.highlight.core.HighlightContract;
import com.neo.highlight.core.LinesTextWatcher;
import com.neo.highlight.core.Scheme;

import java.util.List;

/**
 * Apply schemes to EditText
 * @author Irineu A. Silva
 */
final public class HighlightTextWatcher extends LinesTextWatcher implements HighlightContract {

    @NonNull
    private RANGE range = RANGE.MODIFIED;

    @NonNull
    private Highlight highlight;

    public HighlightTextWatcher() {
        highlight = new Highlight();
    }

    public HighlightTextWatcher(@NonNull Highlight highlight) {
        this.highlight = highlight;
    }

    @Override
    protected void onLinesChange(
            @NonNull Editable editable,
            int start, int end,
            int firstLineStart, int lastLineEnd
    ) {

        if (range == RANGE.MODIFIED) {
            removeSpan(editable, firstLineStart, lastLineEnd);
            setSpan(editable, firstLineStart, lastLineEnd);
        } else {
            final Editable _editable = editable;
            new Handler(Looper.getMainLooper()).post(new Runnable() {

                @Override
                public void run() {
                    removeSpan(_editable);
                    setSpan(_editable);
                }
            });
        }
    }

    public void setRange(@NonNull RANGE range) {
        this.range = range;
    }

    @NonNull
    public RANGE getRange() {
        return range;
    }

    @NonNull
    public Highlight getHighlight() {
        return highlight;
    }

    public void setHighlight(@NonNull Highlight highlight) {
        this.highlight = highlight;
    }

    //override HighlightContract

    @Override
    public void setSpan(Editable editable, int start, int end) {
        this.highlight.setSpan(editable, start, end);
    }

    @Override
    public void setSpan(Editable editable) {
        this.highlight.setSpan(editable);
    }

    @Override
    public void setSpan(TextView textView, int start, int end) {
        this.highlight.setSpan(textView, start, end);
    }

    @Override
    public void setSpan(TextView textView) {
        this.highlight.setSpan(textView);
    }

    @Override
    public void setSpan(SpannableString spannableString, int start, int end) {
        this.highlight.setSpan(spannableString, start, end);
    }

    @Override
    public void setSpan(SpannableString spannableString) {
        this.setSpan(spannableString);
    }

    @Override
    public void removeSpan(Editable editable) {
        this.highlight.removeSpan(editable);
    }

    @Override
    public void removeSpan(Editable editable, int start, int end) {
        this.highlight.removeSpan(editable, start, end);
    }

    @Override
    public List<Scheme> getSchemes() {
        return highlight.getSchemes();
    }

    @Override
    public void setSchemes(@NonNull List<Scheme> schemes) {
        highlight.setSchemes(schemes);
    }

    @Override
    public void addScheme(@NonNull Scheme... schemes) {
        highlight.addScheme(schemes);
    }

    @Override
    public void clearScheme() {
        highlight.clearScheme();
    }

    @Override
    public List<Class<?>> getSpanTypes() {
        return highlight.getSpanTypes();
    }

    @Override
    public void setSpanTypes(@NonNull List<Class<?>> spanTypes) {
        highlight.setSpanTypes(spanTypes);
    }

    @Override
    public void addSpanType(Class<?> span) {
        highlight.addSpanType(span);
    }

    @Override
    public void clearSpanTypes() {
        highlight.clearSpanTypes();
    }

    public enum RANGE {
        MODIFIED,
        ALL
    }
}
