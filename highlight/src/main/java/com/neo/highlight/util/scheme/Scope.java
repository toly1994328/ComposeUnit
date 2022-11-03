package com.neo.highlight.util.scheme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;
import com.neo.highlight.util.scheme.base.BaseScheme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Scope for schemes
 * @author Irineu A. Silva
 */
final public class Scope extends BaseScheme {

    public Scope(@NonNull Pattern pattern, @NonNull Scheme... scopeSchemes) {
        super(pattern);
        setScopeSchemes(new ArrayList<>(Arrays.asList(scopeSchemes)));
    }

    @Override
    @Nullable
    public Object getSpan(@NonNull CharSequence text, int start, int end) {
        return null;
    }

}
