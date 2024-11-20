package com.example.a06elementspersonalitzats

import android.util.AttributeSet
import android.graphics.PorterDuff
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.widget.AppCompatEditText
import android.content.Context
import android.text.InputType
import androidx.core.content.ContextCompat

class OddEvenEditText : AppCompatEditText {
    constructor(context: Context) : super(context)

    constructor(context : Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context : Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        inputType = InputType.TYPE_CLASS_NUMBER
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(!p0.isNullOrEmpty()){
                    var inputText =p0.toString()

                    if(inputText.contains("0")){
                        inputText = inputText.replace("0", "")
                        setText(inputText)
                        setSelection(inputText.length)
                        return

                    }
                    val number = inputText.toDouble()
                    if(number % 2 == 0.0){
                        background.setColorFilter(ContextCompat.getColor(context, R.color.green), PorterDuff.Mode.SRC_IN)
                    }else{
                        background.setColorFilter(ContextCompat.getColor(context, R.color.red), PorterDuff.Mode.SRC_IN)
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }
}
