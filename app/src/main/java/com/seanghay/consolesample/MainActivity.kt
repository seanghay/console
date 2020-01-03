package com.seanghay.consolesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seanghay.console.Console
import com.seanghay.console.console
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        console.log("one", "two", "three")
        console.error("one", "two", "three")
        console.warn("one", "two", "three")
        console.info("one", "two", "three")

        repeat(100) {
            console.count("hi")
        }

        console.countReset("hi")

        thread {
            console.time("timer")
            Thread.sleep(1000)
            console.timeEnd("timer")
        }

        console.tag("newTag") {
            log("Hey there")
            info("Nice to see you")
            error("Ooops")
        }
    }
}
