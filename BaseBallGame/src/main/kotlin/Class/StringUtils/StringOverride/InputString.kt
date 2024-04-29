package org.example.Class.StringUtils.StringOverride

import org.example.Class.StringUtils.StringInterface

class InputString:StringInterface {
    override var str: String=""
    private var check= IntArray(10)
    override fun exception() {
        println(check)
    }
    override fun input() {
        println(check)
    }
}