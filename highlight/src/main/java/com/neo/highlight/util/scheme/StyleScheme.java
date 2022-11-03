package com.neo.highlight.util.scheme;

import android.graphics.Typeface;
import android.text.style.StyleSpan;

import androidx.annotation.NonNull;

import com.neo.highlight.util.scheme.base.BaseScheme;

import java.util.regex.Pattern;

/**
 * Pain text style
 * @author Irineu A. Silva
 */
final public class StyleScheme extends BaseScheme {

    @NonNull
    private final STYLE style;

    public StyleScheme(@NonNull Pattern pattern, @NonNull STYLE style) {
        super(pattern);
        this.style = style;
    }

    public StyleScheme(@NonNull STYLE style) {
        super(null);
        this.style = style;
    }

    @NonNull
    @Override
    public Object getSpan(@NonNull CharSequence text, int start, int end) {
        return new StyleSpan(getType());
    }

    private int getType() {
        switch (style) {

            case NORMAL:
                return Typeface.NORMAL;
            case ITALIC:
                return Typeface.ITALIC;
            case BOLD:
                return Typeface.BOLD;
            case BOLD_ITALIC:
                return Typeface.BOLD_ITALIC;
        }

        return Typeface.NORMAL;
    }

    public enum STYLE {
        NORMAL,
        ITALIC,
        BOLD,
        BOLD_ITALIC
    }
}
