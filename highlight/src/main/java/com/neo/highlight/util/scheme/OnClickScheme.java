package com.neo.highlight.util.scheme;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.neo.highlight.util.scheme.base.BaseScheme;
import com.neo.highlight.util.scheme.contract.LinkSchemeContract;

import java.util.regex.Pattern;

/**
 * Pain and makes clickable any text
 * @author Irineu A. Silva
 */
final public class OnClickScheme extends BaseScheme implements LinkSchemeContract {

    @NonNull
    private final OnClickListener onClickListener;

    private boolean painText = false;

    @ColorInt
    private int painTextColor = -1;

    private boolean painTextUnderline = false;

    public OnClickScheme(@NonNull Pattern pattern, @NonNull OnClickListener onClickListener) {
        super(pattern);
        this.onClickListener = onClickListener;
    }

    public OnClickScheme(@NonNull OnClickListener onClickListener) {
        super(null);
        this.onClickListener = onClickListener;
    }

    @Override
    public Object getSpan(@NonNull final CharSequence text, final int start, final int end) {
        return new ClickableSpan() {

            @Override
            public void onClick(@NonNull View widget) {
                onClickListener.onClick(text, start, end);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {

                if (painText) {

                    if (painTextColor == -1) {
                        ds.setColor(ds.linkColor);
                    } else {
                        ds.setColor(painTextColor);
                    }

                    ds.setUnderlineText(painTextUnderline);
                }
            }
        };
    }

    //override LinkSchemeContract

    @Override
    public OnClickScheme setPainText(boolean painText) {
        this.painText = painText;
        return this;
    }

    @Override
    public OnClickScheme setPainTextColor(@ColorInt int painTextColor) {
        this.painTextColor = painTextColor;
        return setPainText(true);
    }

    @Override
    public OnClickScheme setPainTextUnderline(boolean painTextUnderline) {
        this.painTextUnderline = painTextUnderline;
        return this;
    }

    public interface OnClickListener {
        void onClick(CharSequence text, int start, int end);
    }
}
