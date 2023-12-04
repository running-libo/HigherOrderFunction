package com.example.higherorderfunction.coroutine

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StartCoroutines {

    fun runBlocking() = kotlinx.coroutines.runBlocking {
        repeat(5) {
            Log.i("minfo", "协程执行$it,当前线程name :${Thread.currentThread().name}")
            delay(1000)
        }
    }

    fun runCoroutine() {
        Log.i("minfo", "协程开始")
        CoroutineScope(Dispatchers.Default).launch {
            delay(2000)
            Log.i("minfo", "协程内部")
        }
        Log.i("minfo", "协程下面")
    }

    /**
     * 模拟访问接口获取接口数据
     */
    suspend fun loadData(): String {
        var response = ""
        withContext(Dispatchers.IO) {
            //子线程中模拟耗时操作
            delay(1000)
            response = "response"
        }

        return response
    }

    suspend fun getResult(): String {
        var result = GlobalScope.async(Dispatchers.Main) {
            return@async loadData()
        }
        return result.await()
    }
}