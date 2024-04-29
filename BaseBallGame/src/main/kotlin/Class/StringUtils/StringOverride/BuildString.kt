package org.example.Class.StringUtils.StringOverride

import org.example.Class.StringUtils.StringInterface

class BuildString:StringInterface {
    override var str: String=""
    private var check= IntArray(10)
    override fun exception() {
        check.forEach { println(it) }
    }
    override fun input() {
        check.forEach { println(it) }
    }
}