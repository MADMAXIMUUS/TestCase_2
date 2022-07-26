package ru.madmax.autodoctestcase.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun toDateFormat(date: String): String {
    val splitDate = date.split("T")
    val localDate = LocalDate.parse(splitDate[0])
    val dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return localDate.format(dateTimeFormatter)
}