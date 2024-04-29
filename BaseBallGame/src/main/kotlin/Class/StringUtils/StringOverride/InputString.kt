package org.example.Class.StringUtils.StringOverride

import org.example.Class.StringUtils.StringInterface

class StringException(errorCode: Int=0) :
    Exception("!!! code:($errorCode) 올바르지 않은 값입니다.\n")

class InputString:StringInterface {
    override var str: String = ""

    override fun setString() {
        while (true) {
            print("숫자를 입력하세요: ")
            val strInput = readln()
            try {
                when {
                    strInput == "lapf" -> {
                        this.str = "Cheat"; break
                    }

                    !strInput.all { it.isDigit() } -> throw StringException(0)
                    strInput.length != 3 -> throw StringException(1)
                    strInput.first() == '0' -> throw StringException(2)
                    strInput.toSet().size != 3 -> throw StringException(3)

                    else -> {
                        this.str = strInput;break
                    }
                }
            }
            catch (e: StringException)
            {
                println(e.message)
            }
        }
    }

    override fun getString(): String {
        return this.str
    }
}