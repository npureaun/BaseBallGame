package org.example.Class.StringUtils.StringOverride

import org.example.Class.StringUtils.StringInterface

class InputString:StringInterface {
    override var str: String=""

    override fun input() {
        val str= readln()
        try {
            if(str.length!=3) throw String
        }catch (e:NumberFormatException)
        {
            println("숫자를 입력하세요")
        }
        catch (e: StringSizeException)
        {

        }
        println("check")
    }

    override fun getString(): String {
        return this.str
    }
}