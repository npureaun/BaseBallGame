package org.example.Class

import org.example.Class.StringUtils.StringOverride.BuildString
import org.example.Class.StringUtils.StringOverride.InputString
import org.example.Class.StringUtils.StringUtile

class Manager {
    init { manual() }

    fun manual()
    {
        val cls=StringUtile()
        cls.setting(BuildString())
        cls.processInput()
        while (true)
        {
            break
        }
    }
}