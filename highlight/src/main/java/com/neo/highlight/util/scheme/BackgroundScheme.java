package com.neo.highlight.util.scheme;

import android.text.style.BackgroundColorSpan;

import androidx.annotation.NonNull;

import com.neo.highlight.util.scheme.base.BaseColorScheme;

import java.util.regex.Pattern;

/**
 * Paint the background
 * @author Irineu A. Silva
 */
final public class BackgroundScheme extends BaseColorScheme {

    public BackgroundScheme(@NonNull Pattern pattern, int color) {
        super(pattern, color);
    }

    public BackgroundScheme(int color) {
        super(color);
    }

    @NonNull
    @Override
    public Object getSpan(@NonNull CharSequence text, int start, int end) {
        return new BackgroundColorSpan(super.color);
    }
}
