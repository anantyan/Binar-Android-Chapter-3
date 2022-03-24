package id.anantyan.utils

import com.google.android.material.textfield.TextInputLayout
import id.anantyan.utils.validator.Validation
import id.anantyan.utils.validator.rules.common.minimumLength
import id.anantyan.utils.validator.rules.common.notEmpty
import id.anantyan.utils.validator.rules.common.notNull
import id.anantyan.utils.validator.rules.regex.PasswordRule
import id.anantyan.utils.validator.rules.regex.email
import id.anantyan.utils.validator.rules.regex.withPassword
import id.anantyan.utils.validator.validation

object Validation {

    fun formValid(textInputLayout: TextInputLayout): Validation {
        return validation(textInputLayout) {
            rules {
                +notNull(R.string.txt_not_null)
                +notEmpty(R.string.txt_not_empty)
            }
        }
    }
}