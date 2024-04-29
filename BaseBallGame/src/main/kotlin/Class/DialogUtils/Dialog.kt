package org.example.Class.DialogUtils

import org.example.Class.Manager

open class Dialog(private val logger: Logger) {
    var loopCnt=0

    private fun choiceFilter(choice : String):Boolean =
        (choice.length != 1 || choice !in ("1".."3") || !choice.all { it.isDigit() })

    private fun consoleClear() = repeat(10){println("")}

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

        val choiceNumber=choice.toInt()

        consoleClear()
        println(choiceForText(choiceNumber))
        return choiceNumber
    }

    private fun choiceForText(n: Int):String
    {
        val text= arrayOf("< 게임을 시작합니다 >\n", "< 게임을 로그를 봅니다. >\n", "< 게임을 종료합니다 >\n")
        return text[n-1]
    }

    protected fun referee(com:String, user:String):Boolean {
        val result = Referee(com, user).referee()
        var endSignal = false
        var refereeResult = ""
        print("--> ")
        if (user == "Cheat") {
            println("치트 활성: 현재 정답= $com \n")
        }
        else {
            if (result.first >= com.length) {
                refereeResult = "3 스트라이크! 정답입니다!! 정답 = $com\n"
                println(refereeResult)

                doContinue()
                endSignal = true
            }
            else {
                refereeResult = "${result.first} 스트라이크 / ${result.second} 볼\n"
                println(refereeResult)
            }
            logger.setLog(loopCnt, user, refereeResult)
        }

        return endSignal
    }

    fun readAllLog(){


        val strLog=StringBuilder()
        if(logger.isEmpty()) println("진행된 게임이 없습니다.\n")
        else {
            for (i in logger.indices()) {
                strLog.append("(Loop): ${logger.getLog(i).loop} / ")
                strLog.append("(Input): ${logger.getLog(i).user} / ")
                strLog.append("(Result): ${logger.getLog(i).result} ")
                println(strLog)
                strLog.clear()
            }
        }
        doContinue()
    }
}