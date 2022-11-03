package com.neo.highlight.core;

import android.text.Editable;
import android.text.SpannableString;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * @author Irineu A. Silva
 */
public interface HighlightContract {

    //setSpan EditText
    void setSpan(Editable editable, int start, int end);
    void setSpan(Editable editable);

    //setSpan TextView
    void setSpan(TextView textView, int start, int end);
    void setSpan(TextView textView);

    //setSpan Spannable
    void setSpan(SpannableString spannableString, int start, int end);
    void setSpan(SpannableString spannableString);

    //removeSpan EditText
    void removeSpan(Editable editable, int start, int end);
    void removeSpan(Editable editable);

    //schemes
    List<Scheme> getSchemes();
    void setSchemes(@NonNull List<Scheme> schemes);
    void addScheme(@NonNull Scheme... scheme);
    void clearScheme();

    //types
    List<Class<?>> getSpanTypes();
    void setSpanTypes(@NonNull List<Class<?>> spanTypes);
    void addSpanType(Class<?> span);
    void clearSpanTypes();
}
