package org.example.Class

import org.example.Class.Logger.LogOverride.TimeTable
import org.example.Class.Logger.Logger
import org.example.Class.StringUtils.StringOverride.BuildString
import org.example.Class.StringUtils.StringOverride.InputString
import org.example.Class.StringUtils.StringProcessor

class Manager(private val handler: StringProcessor): Dialog() {
    init { manual() }

    private fun startGame() {
        handler.runProcess(BuildString())
        val com=handler.processGetting()

        do{
            handler.runProcess(InputString())
            val user = handler.processGetting()
        }while (!referee(com.toString(), user.toString()))
    }

    private fun readAllLog() {
        Logger(TimeTable).readAll()
        println()
        doContinue()
    }

    private fun manual()
    {
        while (true)
        {
            println("원하시는 번호를 입력해주세요")
            println("---------------")
            println("1. 게임 시작하기 \n2. 게임 기록 보기 \n3. 종료하기")
            println("---------------")

            val choice = inputManu()
            when(choice)
            {
                1->{ println("< 게임을 시작합니다 >\n");startGame() }
                2->{ println("< 게임을 로그를 봅니다. >\n");readAllLog() }
                3->{ println("< 게임을 종료합니다 >\n");break }
            }
        }
    }
}