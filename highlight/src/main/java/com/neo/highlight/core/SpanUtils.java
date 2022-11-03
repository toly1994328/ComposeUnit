package com.neo.highlight.core;

import android.text.Editable;
import android.text.Spanned;

/**
 * @author Irineu A. Silva
 */
final public class SpanUtils {

    private SpanUtils() {}

    public static void setSpan(Editable editable, Object span, int start, int end) {
        editable.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    public static <T> void removeSpans(Editable editable, Class<T> tClass, int start, int end) {
        Object[] spans = editable.getSpans(start, end, tClass);

        for (Object span : spans) {
            editable.removeSpan(span);
        }
    }
}
