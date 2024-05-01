package org.example.Class.StringUtils.StringOverride

import org.example.Class.Exception.*
import org.example.Class.StringUtils.StringInterface

class InputString: StringInterface {
    override var str: String = ""

    override fun getString(): String = this.str

    override fun setString() {
        while (true) {
            print("숫자를 입력하세요: ")
            val strInput = readln()
            try {
                when {
                    strInput == "lapf" -> {this.str = "Cheat"; break}

                    !strInput.all { it.isDigit() } -> throw NumberException()
                    strInput.length != 3 -> throw LengthException()
                    strInput.first() == '0' -> throw ZeroException()
                    strInput.toSet().size != 3 -> throw EqualException()

                    else -> {
                        this.str = strInput;break
                    }
                }
            }
            catch (e: InputException)
            {
                println(e.message)
            }
        }
    }
}