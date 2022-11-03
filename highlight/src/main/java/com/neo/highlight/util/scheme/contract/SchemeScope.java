package com.neo.highlight.util.scheme.contract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neo.highlight.core.Scheme;

import java.util.List;

/**
 * @author Irineu A. Silva
 */
public interface SchemeScope {

    @Nullable
    List<Scheme> getScopeSchemes();
    void setScopeSchemes(List<Scheme> schemes);
    Scheme addScopeScheme(@NonNull Scheme... schemes);
    Scheme clearScopeSchemes();
}
