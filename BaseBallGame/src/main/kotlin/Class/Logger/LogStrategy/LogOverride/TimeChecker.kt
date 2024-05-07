package org.example.Class.Dialog.Logger.LogStrategy.LogOverride

import org.example.Class.Dialog.Logger.LogStrategy.LogInterface
data class TimeLog(val loop: Int, val time: Long)

class TimeChecker: LogInterface<TimeLog> {

    override var log= mutableListOf<TimeLog>()

    override fun isEmpty()=log.isEmpty()
    override fun indices()=log.indices
    override fun clear()=log.clear()
    override fun output(n: Int): TimeLog = log[n]

    override fun input(data: TimeLog){
        log.add(data)
    }

    override fun readAll() {
        if (isEmpty()) println("진행된 게임이 없습니다.\n")
        for(i in indices())
        {
            println("(${i+1})Game= (${log[i].loop})loop / (${log[i].time})sec")
        }
    }
}