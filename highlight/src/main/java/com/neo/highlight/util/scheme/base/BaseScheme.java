package com.neo.highlight.util.scheme.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;
import com.neo.highlight.util.scheme.contract.SchemeScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Base to schemes
 * @author Irineu A. Silva
 */
abstract public class BaseScheme implements Scheme, SchemeScope {

    @Nullable
    private List<Scheme> scopeSchemes;

    @Nullable
    private final Pattern pattern;

    private boolean clearOldSpan = false;

    public BaseScheme(@Nullable Pattern pattern) {
        this.pattern = pattern;
    }

    //override Scheme

    @Nullable
    @Override
    public Pattern getRegex() {
        return pattern;
    }


    @Override
    public boolean getClearOldSpan() {
        return clearOldSpan;
    }

    @NonNull
    @Override
    public BaseScheme setClearOldSpan(boolean clearOldSpan) {
        this.clearOldSpan = clearOldSpan;
        return this;
    }

    //override ScopeSchemeContract

    @Nullable
    @Override
    public List<Scheme> getScopeSchemes() {
        return scopeSchemes;
    }

    @Override
    public void setScopeSchemes(@Nullable List<Scheme> schemes) {
        this.scopeSchemes = schemes;
    }

    @Override
    public BaseScheme addScopeScheme(@NonNull Scheme... schemes) {
        if (scopeSchemes == null) {
            scopeSchemes = new ArrayList<>();
        }

        scopeSchemes.addAll(Arrays.asList(schemes));
        return this;
    }

    @Override
    public BaseScheme clearScopeSchemes() {
        if (scopeSchemes != null) {
            scopeSchemes.clear();
        }
        return this;
    }
}
