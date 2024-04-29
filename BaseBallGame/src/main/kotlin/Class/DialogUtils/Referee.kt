package org.example.Class.DialogUtils

class Referee(private val com:String, private val user:String) {

    fun referee():Pair<Int,Int>
    {
        var ball=0
        var strike=0
        for(i in com.indices)
        {
            for(j in user.indices)
            {
                if(com[i]==user[j])
                {
                    if(i==j) strike++
                    else ball++
                }
            }
        }
        return Pair(strike,ball)
    }
}