package com.example.a06elementspersonalitzats

import android.content.Context
import android.graphics.PorterDuff
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.regex.Pattern

class EmailValidatorView(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs),
    TextWatcher{

    var successColor: Int
    var errorColor: Int
    val etDNI: EditText
    val tvErrorCode: TextView

    init {
        inflate(context, R.layout.dni_validator, this)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.MailValidator)

        tvErrorCode = findViewById(R.id.tvErrorCode)
        tvErrorCode.text = attributes.getString(R.styleable.MailValidator_textError)
        errorColor = attributes.getColor(R.styleable.MailValidator_underlineErrorColor, ContextCompat.getColor(context, R.color.colorAccent))
        successColor = attributes.getColor(R.styleable.MailValidator_underlineSuccessColor, ContextCompat.getColor(context, R.color.colorAccent))
        attributes.recycle()
        etDNI = findViewById(R.id.etDNI)
        etDNI.addTextChangedListener(this)
    }
    override fun afterTextChanged(s: Editable?) {
    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val pattern = Pattern.compile("\\b\\d{8}[A-HJ-NP-TV-Z]\\b")
        val matcher = pattern.matcher(s.toString())
        val valid = matcher.matches()
        if (valid) {
            tvErrorCode.visibility = View.INVISIBLE
            etDNI.background.setColorFilter(successColor, PorterDuff.Mode.SRC_IN)
        } else {
            tvErrorCode.visibility = View.VISIBLE
            etDNI.background.setColorFilter(errorColor, PorterDuff.Mode.SRC_IN)
        }
    }

}