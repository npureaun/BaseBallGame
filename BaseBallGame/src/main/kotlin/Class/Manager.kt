package org.example.Class

import org.example.Class.DialogUtils.Dialog
import org.example.Class.DialogUtils.Logger
import org.example.Class.StringUtils.StringOverride.BuildString
import org.example.Class.StringUtils.StringOverride.InputString
import org.example.Class.StringUtils.StringProcessor

class Manager(private val handler: StringProcessor, logger: Logger):Dialog(logger) {
    init { manual() }

    private fun startGame()
    {
        handler.runProcess(BuildString())
        val com=handler.processGetting()

        do{
            handler.runProcess(InputString())
            val user = handler.processGetting()
        }while (!referee(com.toString(), user.toString()))
        loopCnt=0
    }

    private fun readLog()=readAllLog()


    private fun manual()
    {
        while (true)
        {
            val choice = inputManu()
            when(choice)
            {
                1->startGame()
                2->readLog()
                3->break
            }
        }
    }
}