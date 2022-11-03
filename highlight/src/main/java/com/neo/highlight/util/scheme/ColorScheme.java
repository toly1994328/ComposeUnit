package com.neo.highlight.util.scheme;

import android.text.style.ForegroundColorSpan;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.neo.highlight.util.scheme.base.BaseColorScheme;

import java.util.regex.Pattern;

/**
 * Paint the text
 * @author Irineu A. Silva
 */
final public class ColorScheme extends BaseColorScheme {

    public ColorScheme(@NonNull Pattern pattern, @ColorInt int color) {
        super(pattern, color);
    }

    public ColorScheme(@ColorInt int color) {
        super(color);
    }

    @Override
    @NonNull
    public Object getSpan(@NonNull CharSequence text, int start, int end) {
        return new ForegroundColorSpan(color);
    }
}
