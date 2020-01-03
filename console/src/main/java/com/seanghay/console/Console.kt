package com.seanghay.console

import android.util.Log
import androidx.annotation.VisibleForTesting
import java.lang.StringBuilder
import java.util.concurrent.ConcurrentHashMap

inline val console: Console get() =  Console

object Console : ConsoleLoggger {

    private val counts = ConcurrentHashMap<String, Long>()
    private val timers = ConcurrentHashMap<String, Long>()

    @VisibleForTesting
    var _tag = "Console"
        internal set

    override fun log(vararg msg: Any) {
        l(Log.DEBUG, msg.mergeString())
    }

    override fun info(vararg msg: Any) {
        l(Log.INFO, msg.mergeString())
    }

    override fun warn(vararg msg: Any) {
        l(Log.WARN, msg.mergeString())
    }

    override fun debug(vararg msg: Any) {
        l(Log.DEBUG, msg.mergeString())
    }

    override fun error(vararg msg: Any) {
        l(Log.ERROR, msg.mergeString())
    }

    @VisibleForTesting
    internal fun Array<out Any>.mergeString(): String {
        val builder = StringBuilder()
        for ((index, any) in this.withIndex()) {
            builder.append(any.toString())
            if (index < size - 1) {
                builder.append(", ")
            }
        }
        return builder.toString()
    }

    override fun time(tag: String) {
        val currentTime = System.currentTimeMillis()
        timers[tag] = currentTime
    }

    override fun timeEnd(tag: String) {
        val lastTime = timers[tag] ?: return
        val currentTime = System.currentTimeMillis()
        val elapsed = currentTime - lastTime
        l(Log.INFO, "$tag: $elapsed millis")
    }

    override fun count(tag: String) {
        val current = counts[tag] ?: 0L
        counts[tag] = current + 1L

        val value = counts[tag]
        if (value != null) {
            l(Log.INFO, "$tag: $value")
        }
    }

    override fun countReset(tag: String) {
        val value = counts[tag]
        counts.remove(tag)

        if (value != null) {
            l(Log.INFO, "$tag: $value")
        }
    }

    override fun tag(tag: String) {
        synchronized(Console::class) {
            this._tag = tag
        }

    }

    override fun tagReset() {
        synchronized(Console::class) {
            _tag = "Console"
        }
    }

    inline fun <R> tag(tag: String, block: Console.() -> R): R {
        tag(tag)
        val result = this.block()
        tagReset()
        return result
    }

    private fun l(level: Int, message: String) {
        when (level) {
            Log.DEBUG -> Log.d(_tag, message)
            Log.WARN -> Log.w(_tag, message)
            Log.INFO -> Log.i(_tag, message)
            Log.ERROR -> Log.e(_tag, message)
            Log.VERBOSE -> Log.v(_tag, message)
            Log.ASSERT -> Log.wtf(_tag, message)
        }
    }
}