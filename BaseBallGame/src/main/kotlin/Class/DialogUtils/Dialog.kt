package org.example.Class.DialogUtils

import org.example.Class.DialogUtils.Logger.LogOverride.GameLog
import org.example.Class.DialogUtils.Logger.Logger
import org.example.Class.DialogUtils.Logger.LogOverride.TimeTable


open class Dialog() {
    private var loopCnt=0
    private val timeTable=TimeTable()

    private fun choiceFilter(choice : String):Boolean =
        (choice.length != 1 || choice !in ("1".."3") || !choice.all { it.isDigit() })

    private fun consoleClear() = repeat(10){println("")}

    private fun choiceForText(n: Int):String=
        arrayOf("< 게임을 시작합니다 >\n", "< 게임을 로그를 봅니다. >\n", "< 게임을 종료합니다 >\n")[n-1]

    private fun doContinue() {
        println("계속하려면 엔터를 눌러주세요...")
        readln()
        consoleClear()
    }

    protected fun inputManu():Int
    {
        println("원하시는 번호를 입력해주세요")
        println("---------------")
        println("1. 게임 시작하기 \n2. 게임 기록 보기 \n3. 종료하기")
        println("---------------")

        var choice=""
        while (true) {
            print("입력: ")
            choice = readln()
            if (choiceFilter(choice))
                println("마 똑디 선택해라 숫자 모르나?")

            else break
        }
        consoleClear()
        println(choiceForText(choice.toInt()))
        return choice.toInt()
    }

    protected fun referee(com:String, user:String):Boolean {
        val result = Referee(com, user).referee()
        Logger(timeTable).setLog(GameLog(++loopCnt,user,result.first))

        println("(Loop:$loopCnt) ${result.first}\n")
        if(result.second) {
            doContinue()
            loopCnt = 0
        }
        return result.second
    }

    fun readAllLog() {
        Logger(timeTable).readAll()
        println()
        doContinue()
    }
}