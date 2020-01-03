package com.seanghay.console

interface ConsoleLoggger {
    fun log(vararg msg: Any)
    fun info(vararg msg: Any)
    fun warn(vararg msg: Any)
    fun debug(vararg msg: Any)
    fun error(vararg msg: Any)
    fun time(tag: String)
    fun timeEnd(tag: String)
    fun count(tag: String)
    fun countReset(tag: String)
    fun tag(tag: String)
    fun tagReset()

}

