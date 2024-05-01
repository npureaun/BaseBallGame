package org.example.Class.DialogUtils.Logger

class Logger<T>(private var processor: LogInterface<T>? = null) {

    fun setProcess(processor: LogInterface<T>){
        this.processor=processor
    }

    fun setLog(data: T)= processor?.input(data)
    fun getLog(n: Int): Any? = processor?.output(n)
    fun readAll()= processor?.readAll()
}