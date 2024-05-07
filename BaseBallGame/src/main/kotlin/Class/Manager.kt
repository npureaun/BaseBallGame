package org.example.Class

import org.example.Class.Dialog.Utile
import org.example.Class.Dialog.Logger.Logger
import org.example.Class.StringUtils.*

class Manager(private val handler: StringProcessor): Utile() {
    init { manual() }

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
                2->{ println("< 게임 로그를 봅니다. >\n");readLog(Logger.LogType.GAME_LOG) }
                3->{ println("< 타임 로그를 봅니다. >\n");readLog(Logger.LogType.TIME_LOG) }
                4->{ println("< 로그를 초기화 합니다. >\n");clearAll() }
                5->{ println("< 게임을 종료합니다 >\n");break }
            }
        }
    }
}