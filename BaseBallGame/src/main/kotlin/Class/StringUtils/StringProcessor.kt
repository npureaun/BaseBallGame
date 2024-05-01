package org.example.Class.StringUtils

class StringProcessor() {
    private var processor: StringInterface? = null

    private fun processInput() = processor?.setString()

    fun processGetting(): String?= processor?.getString()

    fun runProcess(processor: StringInterface) {
        this.processor = processor
        processInput()
    }

}