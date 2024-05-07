package org.example.Class

import org.example.Class.Dialog.Logger.Logger

enum class Selector(private val value: Int) {
    START_GAME(1) {
        override fun execute() {
            println("< 게임을 시작합니다 >\n")
            Manager.startGame()
        }
    },
    READ_GAME_LOG(2) {
        override fun execute() {
            println("< 게임 로그를 봅니다. >\n")
            Manager.readLog(Logger.LogType.GAME_LOG)
        }
    },
    READ_TIME_LOG(3) {
        override fun execute() {
            println("< 타임 로그를 봅니다. >\n")
            Manager.readLog(Logger.LogType.TIME_LOG)
        }
    },
    CLEAR_LOG(4) {
        override fun execute() {
            println("< 로그를 초기화 합니다. >\n")
            Manager.clearAll()
        }
    };

    abstract fun execute()

    companion object {
        fun fromValue(value: Int): Selector? =
            Selector.entries.find { it.value == value }
    }
}