package org.example.Class.Manager

import org.example.Class.Dialog.Logger.LogStrategy.LogOverride.GameLog
import org.example.Class.Dialog.Logger.LogStrategy.LogOverride.TimeLog
import org.example.Class.Dialog.Logger.Logger
import org.example.Class.StringUtils.StringOverride.BuildString
import org.example.Class.StringUtils.StringOverride.InputString
import org.example.Class.StringUtils.StringProcessor

class Game (private val handler: StringProcessor) {
    private var com:String=""
    private var user:String=""
    private var loopCnt=0

    private fun checkScore(): Pair<Int, Int> {
        var ball = 0
        var strike = 0

        for (i in com.indices) {
            for (j in user.indices) {
                if (com[i] == user[j]) {
                    if (i == j) strike++
                    else ball++
                }
            }
        }
        return Pair(strike, ball)
    }

   private fun referee(): Boolean {
        val result = checkScore()
        var endSignal = false
        var refereeResult = ""

        print("--> ")
        if (user == "Cheat") refereeResult = "치트 활성: 현재 정답= $com"
        else {
            if (result.first >= com.length) {
                refereeResult = "3 스트라이크! 정답입니다!! 정답 = $com"
                endSignal = true
            }
            else if (result.first == 0 && result.second == 0) refereeResult = "Nothing"
            else refereeResult = "${result.first} Strike / ${result.second} Ball"

        }
        Logger.gameLog.setLog(GameLog(++loopCnt,user,refereeResult))
        println("(Loop:$loopCnt) ${refereeResult}\n")
        return endSignal
    }

    fun startGame() {
        handler.runProcess(BuildString())
        com=handler.processGetting().toString()

        val startTime=System.currentTimeMillis()/1000
        while (true)
        {
            handler.runProcess(InputString())
            user = handler.processGetting().toString()
            if(referee())
            {
                val endTime=System.currentTimeMillis()/1000
                Logger.timeLog.setLog(TimeLog(loopCnt,endTime-startTime))
                loopCnt=0
                break
            }
        }
    }
}