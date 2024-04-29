package org.example.Class.StringUtils.StringOverride

import org.example.Class.StringUtils.StringInterface

class StringException() : Exception("!!! code:() 올바르지 않은 값입니다.")

class InputString:StringInterface {
    override var str: String = ""

    override fun setString() {
        while (true) {
            print("숫자를 입력하세요: ")
            val strInput = readln()
            when {
                strInput == "lapf" -> { this.str = "Cheat"; break }

                !strInput.all { it.isDigit() }-> throw StringException()
                strInput.length != 3 -> throw StringException()
                strInput.first() == '0' -> throw StringException()
                strInput.toSet().size != 3 -> throw StringException()

                else -> {
                    this.str = strInput
                    break
                }
            }
        }
    }

    override fun getString(): String {
        return this.str
    }
}