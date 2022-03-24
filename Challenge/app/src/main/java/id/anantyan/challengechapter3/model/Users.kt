package id.anantyan.challengechapter3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    val name: String? = null,
    val age: Int? = null,
    val address: String? = null,
    val profession: String? = null
) : Parcelable
