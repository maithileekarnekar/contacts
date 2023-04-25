package com.androidwavelength.contacts.models

data class CallInfo(
    val ContactName : String?,
    val ContactNumber : String,
    val imageId : Int?,
    val dateTime : Long,
    val type : Byte
) {
    companion object {
        val TYPE_INCOMING = 1
        val TYPE_OUTGOING = 2
    }
}
