/**
 * Designed and developed by Seanghay Yath (@seanghay)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.seanghay.console

import org.junit.Assert.assertEquals
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
