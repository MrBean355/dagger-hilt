package com.github.mrbean355.android.daggerhilt

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.my_custom_view.view.*
import javax.inject.Inject

@AndroidEntryPoint
class MyCustomView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    @Inject
    lateinit var someRepository: SomeRepository

    init {
        inflate(context, R.layout.my_custom_view, this)
        custom_view_text.text = context.getString(R.string.label_custom_view, someRepository.loadData().joinToString(separator = " "))
    }
}