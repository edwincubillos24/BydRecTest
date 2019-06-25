package com.edwinacubillos.bydrectest.utils

import java.text.SimpleDateFormat

class DateConverter {

    fun extractDate(date: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date)
        return SimpleDateFormat("MMM dd, yyyy").format(dateFormat).capitalize()
    }

    fun extractTime(date: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date)
        return SimpleDateFormat("HH:mm").format(dateFormat).capitalize()
    }

    fun extractDay(date: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date)
        return SimpleDateFormat("EEE").format(dateFormat).capitalize()
    }

    fun extractDateOnly(date: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date)
        return SimpleDateFormat("dd").format(dateFormat).capitalize()
    }

    fun extractMonthOnly(date: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(date)
        return SimpleDateFormat("MMMM").format(dateFormat).capitalize()
    }
}
