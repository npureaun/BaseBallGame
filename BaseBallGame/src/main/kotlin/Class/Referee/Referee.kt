package org.example.Class.Referee

class Referee(private val com:String, private val user:String) {

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

    fun referee(): Pair<String, Boolean> {
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
        return Pair(refereeResult, endSignal)
    }
}