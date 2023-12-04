package com.example.higherorderfunction.hightorderfun

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HighOrderContext : ViewModel() {

    /**
     * 传入suspend方法发起请求，获取到BaseData数据，如果请求成功回调successCallBack函数并返回 T
     * 如果失败，调用failCallBack函数自行实现处理
     */
    fun <T: Any> requestData(
        showLoading: Boolean = true,
        request: suspend () -> BaseData<T>,
        successCallBack: (T) -> Unit,
        failCallBack: suspend (String) -> Unit = { errMsg->
            showLoading()
        }
    ) {
        viewModelScope.launch {
            if (showLoading) {
                showLoading()
            }
            try {
                val baseData = request.invoke()
                if (baseData.isSuccess()) {
                    baseData.data?.let { successCallBack(it) }
                } else {
                    baseData.errorMsg?.let { error(it) }
                }
            } catch (e: Exception) {
                e.message?.let { failCallBack(it) }
            } finally {
                if (showLoading) {
                    showLoading()
                }
            }
        }
    }

    class BaseData<T> {
        var errorCode = -1
        var errorMsg: String? = null
        var data: T? = null

        fun isSuccess(): Boolean = errorCode == 200
    }

    fun loadData() {
        requestData(
            showLoading = true,
            request = { getUser() },
            successCallBack = { data ->

            })
    }

    suspend fun getUser(): BaseData<User> {
        return TODO("Provide the return value")
    }

    fun showLoading() {

    }
}