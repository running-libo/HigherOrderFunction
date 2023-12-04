package com.example.higherorderfunction.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * 多个挂起函数操作线性异步操作
 */
class SuspendUse {

    companion object {
        suspend fun getUserInfo(): String {
            withContext(Dispatchers.IO) {
                delay(1000L)
            }
            return "BoyCoder"
        }

        suspend fun getFriendList(user: String): String {
            withContext(Dispatchers.IO) {
                delay(1000L)
            }
            return user + "' friendLists"
        }

        suspend fun getFeedList(list: String): String {
            withContext(Dispatchers.IO) {
                delay(1000L)
            }
            return "{FeedList..}"
        }

        suspend fun getToken(id: String): String = "token"
        suspend fun getInfo(token: String): String = "info"

        suspend fun test() {
            val token = getToken("123") // 挂起点1，这里是异步线程
            var a = 10 // 这里是10  //主线程
            val info = getInfo(token) // 挂起点2，需要将前面的数据保存(比如a)，在挂起点之后恢复   //异步线程
            println(info)  //主线程
            println(a)
        }
    }
}