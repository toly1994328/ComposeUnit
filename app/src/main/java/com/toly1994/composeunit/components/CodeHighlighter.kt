package com.toly1994.composeunit.app.utils

import android.content.Context
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.neo.highlight.core.Highlight
import com.neo.highlight.core.Scheme
import com.neo.highlight.util.scheme.ColorScheme
import com.neo.highlight.util.scheme.Scope
import com.toly1994.composeunit.R
import java.util.regex.Pattern

@Composable
fun CodeHighlighter(code :String ) {
    AndroidView(factory = {
        val tv  =   TextView(it)
        val highlight = Highlight()
        highlight.schemes = getKotlinScheme(it)
        tv.text = code
        highlight.setSpan(tv)
        tv
    })
}


private fun getKotlinScheme(context: Context): List<Scheme> {
    val schemes: MutableList<Scheme> = ArrayList()
    //keywords

    schemes.add(
        ColorScheme(
            Pattern.compile("\\b(fun)|(val)|(var)|(sp)|(dp)|(private)\\b"),
            ContextCompat.getColor(context, R.color.keyword)
        )
    )

    // 数字
    schemes.add(
        Scope(
            Pattern.compile("\\w+")
        ).addScopeScheme(
            ColorScheme(
                Pattern.compile("^(\\d+\\.\\d+)|^(\\d+)"),
                ContextCompat.getColor(context, R.color.num)
            )
        )
    )
    // class
    schemes.add(
        Scope(
            Pattern.compile("\\w+")
        ).addScopeScheme(
            ColorScheme(
                Pattern.compile("^[A-Z](.*?)\\w+"),
                ContextCompat.getColor(context, R.color.clazz)
            )
        )
    )

    //function declaration
    schemes.add(
        Scope(
            Pattern.compile("\\b(fun)\\b\\s*\\b\\w+\\b\\([^()]*\\)")
        ).addScopeScheme(
            ColorScheme(
                Pattern.compile("\\w*(?=\\()"),
                ContextCompat.getColor(context, R.color.function)
            )
        )
    )



    //annotations
    schemes.add(
        ColorScheme(
            Pattern.compile("@.+"),
            ContextCompat.getColor(context, R.color.annotation)
        )
    )

    //strings
    schemes.add(
        ColorScheme(
            Pattern.compile("\"[^\"]*\""),
            ContextCompat.getColor(context, R.color.string)
        )
    )
    return schemes
}