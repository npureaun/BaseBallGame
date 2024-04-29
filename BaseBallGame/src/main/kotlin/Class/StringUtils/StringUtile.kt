package org.example.Class.StringUtils

import org.example.Class.StringUtils.StringOverride.BuildString
import org.example.Class.StringUtils.StringOverride.InputString

class StringUtile() {
    private var processor: StringInterface? = null

    fun processInput() {
        processor?.input()
    }


    fun processGetting(): String?
    {
        return processor?.getString()
    }

    fun setting(processor: StringInterface) {
        this.processor = processor
    }
}