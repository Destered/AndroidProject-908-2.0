package com.dester.androidproject_908_20.domain.util

fun getIdFromUrl(url:String):Int{
    return Integer.parseInt(url.substringAfterLast("/"))
}