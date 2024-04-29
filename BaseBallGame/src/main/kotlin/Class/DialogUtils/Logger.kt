package org.example.Class.DialogUtils

data class TimeTable(val loop: Int, val user: String, val result: String)

class Logger {
    private val log= mutableListOf<TimeTable>()

    fun setLog(loop : Int, user: String, result:String)
    {
        log.add(TimeTable(loop,user,result))
    }

    fun getLog(n: Int): TimeTable{
        return log[n]
    }

    fun indices()=log.indices
    fun isEmpty()=log.isEmpty()
}