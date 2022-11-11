package com.dagoras.osunolock

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object CurrentTime {

    private val current = LocalDateTime.now()
    private val formatter1 = DateTimeFormatter.ofPattern("MM-dd-yyyy")
    private val formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss")
    val date = current.format(formatter1)
    val time = current.format(formatter2)
}