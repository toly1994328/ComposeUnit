package com.neo.highlight.util.scheme;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.neo.highlight.util.scheme.base.BaseScheme;

import java.util.Objects;
import java.util.regex.Pattern;

final public class FontScheme extends BaseScheme {

    @NonNull
    private final Typeface typeface;

    private boolean keepStyle = true;

    public FontScheme(@Nullable Pattern pattern, @NonNull Typeface typeface) {
        super(pattern);
        this.typeface = typeface;
    }

    public FontScheme(@NonNull Typeface typeface) {
        super(null);
        this.typeface = typeface;
    }

    @NonNull
    @Override
    public Object getSpan(@NonNull CharSequence text, int start, int end) {
        return new TypefaceSpan("") {

            @Override
            public void updateDrawState(TextPaint paint) {

                if (keepStyle) {
                    applyTypeFace(paint);
                } else {
                    paint.setTypeface(typeface);
                }
            }

            private void applyTypeFace(Paint paint) {
                Typeface typefaceAnterior = paint.getTypeface();

                int styleAnterior;

                if (typefaceAnterior == null) {
                    styleAnterior = 0;
                } else {
                    styleAnterior = typefaceAnterior.getStyle();
                }

                int fake = styleAnterior & typeface.getStyle();

                if ((fake & Typeface.BOLD) != 0) {
                    paint.setFakeBoldText(true);
                }

                if ((fake & Typeface.ITALIC) != 0) {
                    paint.setTextSkewX(-0.25f);
                }

                paint.setTypeface(typeface);
            }
        };
    }

    public FontScheme setKeepStyle(boolean keepStyle) {
        this.keepStyle = keepStyle;
        return this;
    }

    @NonNull
    public static Typeface getFont(@NonNull Context context, @FontRes int fonResId) {
        return Objects.requireNonNull(ResourcesCompat.getFont(context, fonResId));
    }
}
