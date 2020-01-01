package com.ganesh.data

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        fun getDateOn(day: Int): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, day)
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            return dateFormat.format(calendar.time)
        }
    }
}
