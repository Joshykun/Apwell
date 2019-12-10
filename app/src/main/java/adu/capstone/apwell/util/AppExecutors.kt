package adu.capstone.apwell.util

import android.os.Looper
import java.util.concurrent.Executor
import android.os.Handler

class AppExecutors(private val diskIO: Executor, private val networkIO: Executor, private val mainThread: Executor) {

    fun diskIO():Executor = diskIO

    fun networkIO():Executor = networkIO

    fun mainThread():Executor = mainThread

    class mainThreadExecutor : Executor{
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }

    companion object{
        private val THREAD_COUNT = 3
    }
}