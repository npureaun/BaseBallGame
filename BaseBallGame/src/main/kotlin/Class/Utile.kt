package org.example.Class.Dialog

import org.example.Class.Dialog.Logger.Logger
import org.example.Class.Game
import org.example.Class.StringUtils.StringProcessor

open class Utile() {

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

    protected fun clearAll(){
        Logger.clearLog(Logger.LogType.GAME_LOG)
        Logger.clearLog(Logger.LogType.TIME_LOG)
    }

    protected fun readLog(type: Logger.LogType){
        Logger.readAll(type)
        println()
        doContinue()
    }

    protected fun startGame(){
        Game(StringProcessor()).startGame()
        doContinue()
    }
}