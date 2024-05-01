package org.example.Class

import org.example.Class.Logger.LogOverride.*
import org.example.Class.Logger.Logger
import org.example.Class.Referee.Referee

open class Dialog() {
    private var loopCnt=0

    private fun consoleClear() = repeat(10){println("")}
    protected fun doContinue() {
        println("계속하려면 엔터를 눌러주세요...")
        readln()
        consoleClear()
    }

    protected fun inputManu():Int {
        var choice: String
        while (true) {
            print("입력: ")
            choice = readln()
            if (!choice.all { it.isDigit() } ||
                choice.length != 1 || choice.toInt() !in (1..3))
                println("마 똑디 선택해라 숫자 모르나?")
            else break
        }
        consoleClear()
        return choice.toInt()
    }

    protected fun referee(com:String, user:String):Boolean {
        val result = Referee(com, user).referee()
        Logger(TimeTable).setLog(GameLog(++loopCnt,user,result.first))
        println("(Loop:$loopCnt) ${result.first}\n")
        if(result.second) {
            doContinue()
            loopCnt = 0
        }
        return result.second
    }
}