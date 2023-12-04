package com.example.higherorderfunction.hightorderfun

import android.util.Log

class Calculate {

    /**
     * 加法
     */
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * 减法
     */
    fun minus(a: Int, b: Int): Int {
        return a - b
    }

    /**
     * 乘法
     */
    fun cheng(a: Int, b: Int): Int {
        return a * b
    }

    /**
     * 运算
     *
     * operate:(Int, Int)->Int 表示定义的一个函数，将其作为calculate参数的形参，实际传的时候是传入add或minus函数
     */
    fun calculate(a: Int, b: Int, operateType: (Int,Int) -> Int): Int {
        return operateType(a, b)
    }

    fun test() {
        Log.i("minfo", "" + calculate(12, 4, ::add))
        Log.i("minfo", "" + calculate(12, 4, ::minus))
        Log.i("minfo", "" + calculate(12, 4, ::cheng))
    }

    //高阶函数作为返回值示例
    fun getNum(type: Int): (a: Int, b: Int) -> Int {
        if (type == 1) {
            return { a, b ->
                a*b
            }
        } else {
            return { a, b ->
                a+b
            }
        }
    }
}