package org.example.Class.Dialog.Logger.LogStrategy.LogOverride

import org.example.Class.Dialog.Logger.LogStrategy.LogInterface
data class GameLog(val loop: Int, val user: String, val result: String)

class TimeTable: LogInterface<GameLog> {

    override var log= mutableListOf<GameLog>()

    override fun isEmpty()=log.isEmpty()
    override fun indices()=log.indices
    override fun clear()=log.clear()
    override fun output(n: Int): GameLog = log[n]as GameLog

    override fun input(data: GameLog){
        log.add(data)
    }

    override fun readAll() {
        val strLog = StringBuilder()
        if (isEmpty()) println("진행된 게임이 없습니다.\n")
        else {
            var gameCnt=0
            for (i in indices()) {
                if (output(i).loop == 1)
                    println("\n<Game:(${++gameCnt})>")

                strLog.append("(Loop): ${output(i).loop} || ")
                strLog.append("(Input): ${output(i).user} || ")
                strLog.append("{(Result): ${output(i).result}}")
                println(strLog)
                strLog.clear()
            }
        }
    }
}