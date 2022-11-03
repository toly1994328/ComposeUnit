package com.neo.highlight.util.scheme.base;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import java.util.regex.Pattern;

/**
 * Base to spannable colors
 * @author Irineu A. Silva
 */
abstract public class BaseColorScheme extends BaseScheme {

    @ColorInt
    protected final int color;

    public BaseColorScheme(@NonNull Pattern pattern, @ColorInt int color) {
        super(pattern);
        this.color = color;
    }

    public BaseColorScheme(@ColorInt int color) {
        super(null);
        this.color = color;
    }
}
