package org.example.Class.DialogUtils.Logger

interface LogInterface<T> {
    val log: MutableList<T>
    fun input(data:T)
    fun output(n: Int):T
    fun isEmpty():Boolean
    fun indices(): IntRange
    fun readAll()
}