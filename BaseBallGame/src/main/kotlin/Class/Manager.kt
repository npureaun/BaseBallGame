package org.example.Class

import org.example.Class.Dialog.Utile

object Manager:Utile(){

    fun manual()
    {
        while (true)
        {
            println("원하시는 번호를 입력해주세요")
            println("---------------")

            val menu= listOf("게임 시작하기","게임 기록 보기","시간 기록 보기","기록 초기화","종료하기")
            repeat(menu.size){println("${it+1}. ${menu[it]}")}

            println("---------------")

            val choice = inputManu(menu.indices)
            val select=Selector.fromValue(choice)
            if(select!=null){
                select.execute()
                continue
            }
            println("< 게임을 종료합니다 >\n")
            break
        }
    }
}