package com.seanghay.console

import org.junit.Assert.*
import org.junit.Test

class ConsoleTest {

    @Test
    fun mergeString() {
        with(Console) {
            val arr = arrayOf("a", "b", "c", "d")
            val result = arr.mergeString()
            assertEquals("a, b, c, d", result)
        }
    }

    @Test
    fun tag() {
        assertEquals(Console._tag, "Console")
    }

    @Test
    fun setTag() {
        Console.tag("a")
        assertEquals(Console._tag, "a")
    }


    @Test
    fun resetTag() {
        Console.tagReset()
        assertEquals(Console._tag, "Console")
    }

    @Test
    fun withTag() {
        assertEquals(Console._tag, "Console")
        Console.tag("b") {

        }
        assertEquals(Console._tag, "Console")
    }

}