package com.example.higherorderfunction.inline

inline fun action2(crossinline block: () -> Unit) {
    println("hello")
    middleLayer {
        block()
    }
}
fun middleLayer(block: () -> Unit){
    block()
}
fun main() {
    //调用处
    action2 {
        print("world")
        return@action2  //这样写才能通过，需要加局部返回，只允许在自己范围内去return
    }
}