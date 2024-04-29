package org.example.Class.StringUtils.StringOverride

import org.example.Class.StringUtils.StringInterface
import kotlin.random.Random

class BuildString:StringInterface {
    override var str: String=""

    override fun input() {
        var cnt=0
        val strBuild=StringBuilder()

        while (cnt!=3)
        {
            val rand=Random.nextInt(10)

            if(cnt==0&&rand==0) continue
            if(rand.digitToChar() !in strBuild)
            {
                strBuild.append(rand.digitToChar())
                cnt++
            }
        }
        str=strBuild.toString()
    }
    override fun getString():String {
        return this.str
    }
}