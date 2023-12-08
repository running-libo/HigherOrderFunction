package com.example.higherorderfunction.inline


fun main() {
    listOf<Int>(1,2,3,4).forEach {
        println("---$it")
        if (it == 3) {
            return
        }
    }
}

//打印：
//---1
//---2
//---3