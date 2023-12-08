package com.example.higherorderfunction.inline

/** * 高阶函数 */
fun action(block: () -> Unit) {
    println("hello")
    block()
}

fun main() {
    //调用处
    action{
        println("world")
    }

}

/**
 * 生成中间临时变量 object :Function0
 */
//fun action(block: () -> Unit) {
//    println("hello")
//    block()
//}
//fun main() {
//    //调用处
//    val action = object :Function0<Unit>{
//        override fun invoke() {
//            return println("world")
//        }
//    }
//    action(action)
//}