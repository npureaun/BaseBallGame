package org.example.Class.Dialog

import org.example.Class.Dialog.Logger.LogStrategy.LogOverride.GameLog
import org.example.Class.Dialog.Logger.LogStrategy.LogOverride.TimeLog
import org.example.Class.Dialog.Logger.Logger
import org.example.Class.Dialog.Referee.Referee

open class Utile() {
    private var loopCnt=0

    private fun consoleClear() = repeat(10){println("")}

    protected fun doContinue() {
        println("계속하려면 엔터를 눌러주세요...")
        readln()
        consoleClear()
    }

    protected fun inputManu(manuRange:IntRange):Int {
        var choice: String
        while (true) {
            print("입력: ")
            choice = readln()
            if (!choice.all { it.isDigit() } ||
                choice.length != 1 || choice.toInt()-1 !in manuRange)
                println("마 똑디 선택해라 숫자 모르나?")
            else break
        }
        consoleClear()
        return choice.toInt()
    }

    protected fun referee(com:String, user:String):Boolean {
        val result = Referee(com, user).referee()
        Logger.gameLog.setLog(GameLog(++loopCnt,user,result.first))
        println("(Loop:$loopCnt) ${result.first}\n")
        if(result.second) {
            doContinue()
        }
        return result.second
    }

    protected fun clearAll(){
        Logger.clearLog(Logger.LogType.GAME_LOG)
        Logger.clearLog(Logger.LogType.TIME_LOG)
    }

    protected fun readLog(type: Logger.LogType){
        Logger.readAll(type)
        println()
        doContinue()
    }

    protected fun gameClear(time:Long){
        Logger.timeLog.setLog(TimeLog(loopCnt,time))
        loopCnt=0
    }
}