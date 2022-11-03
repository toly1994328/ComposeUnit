package com.neo.highlight.util.scheme.contract;

import androidx.annotation.ColorInt;

import com.neo.highlight.core.Scheme;
import com.neo.highlight.util.scheme.LinkScheme;

public interface LinkSchemeContract {
    Scheme setPainText(boolean painText);
    Scheme setPainTextColor(@ColorInt int painTextColor);
    Scheme setPainTextUnderline(boolean painTextUnderline);
}
