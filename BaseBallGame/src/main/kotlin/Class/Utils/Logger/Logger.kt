package org.example.Class.Dialog.Logger

import org.example.Class.Dialog.Logger.LogStrategy.LogOverride.TimeChecker
import org.example.Class.Dialog.Logger.LogStrategy.LogOverride.TimeTable
import org.example.Class.Dialog.Logger.LogStrategy.LogProcessor

object Logger {
    enum class LogType(private val value:Int) {
        GAME_LOG(0),
        TIME_LOG(1);
    }
    val gameLog = LogProcessor(TimeTable())
    val timeLog = LogProcessor(TimeChecker())

    fun clearLog(type: LogType){
        when(type)
        {
            LogType.GAME_LOG -> gameLog.clear()
            LogType.TIME_LOG -> timeLog.clear()
        }
    }

    fun readAll(type: LogType){
        when(type)
        {
            LogType.GAME_LOG -> gameLog.readAll()
            LogType.TIME_LOG -> timeLog.readAll()
        }
    }
}