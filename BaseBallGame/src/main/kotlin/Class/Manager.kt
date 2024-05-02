package org.example.Class

import org.example.Class.Logger.LogOverride.TimeChecker
import org.example.Class.Logger.LogOverride.TimeLog
import org.example.Class.Logger.LogOverride.TimeTable
import org.example.Class.Logger.LogType
import org.example.Class.Logger.Logger
import org.example.Class.StringUtils.StringOverride.BuildString
import org.example.Class.StringUtils.StringOverride.InputString
import org.example.Class.StringUtils.StringProcessor

class Manager(private val handler: StringProcessor): Dialog() {
    init { manual() }

    private fun startGame() {
        handler.runProcess(BuildString())
        val com=handler.processGetting()

        val startTime=System.currentTimeMillis()/1000
        while (true)
        {
            handler.runProcess(InputString())
            val user = handler.processGetting()
            if(referee(com.toString(), user.toString()))
            {
                val endTime=System.currentTimeMillis()/1000
                val loopCnt=clearLoopCnt()
                Logger(TimeChecker).setLog(TimeLog(loopCnt,(endTime-startTime).toString()))
                break
            }
        }
    }

    private fun readLog(type: LogType){
        when(type)
        {
            LogType.GAME_LOG->Logger(TimeTable).readAll()
            LogType.TIME_LOG->Logger(TimeChecker).readAll()
        }

        println()
        doContinue()
    }

    private  fun clearLog(){
        Logger(TimeTable).clear()
        Logger(TimeChecker).clear()
    }

    private fun manual()
    {
        while (true)
        {
            println("원하시는 번호를 입력해주세요")
            println("---------------")

            val menu= listOf("게임 시작하기","게임 기록 보기","시간 기록 보기","기록 초기화","종료하기")
            repeat(menu.size){println("${it+1}. ${menu[it]}")}

            println("---------------")

            val choice = inputManu(menu.indices)
            when(choice)
            {
                1->{ println("< 게임을 시작합니다 >\n");startGame() }
                2->{ println("< 게임 로그를 봅니다. >\n");readLog(LogType.GAME_LOG) }
                3->{ println("< 타임 로그를 봅니다. >\n");readLog(LogType.TIME_LOG) }
                4->{ println("< 로그를 초기화 합니다. >\n");clearLog() }
                5->{ println("< 게임을 종료합니다 >\n");break }
            }
        }
    }
}