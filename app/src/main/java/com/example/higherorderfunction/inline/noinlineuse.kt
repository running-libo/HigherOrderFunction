package com.example.higherorderfunction.inline

private fun clearResource(excution:() -> Unit) {
    excution()
    println("clean resource1")
    println("clean resource2")
}

/**
 * 高阶函数作为另一个高阶函数参数，参数需要加 oninline，避免内联
 */
private inline fun proxy(action: () -> Unit, noinline action2:() -> Unit) {
    println("start loggin")
    action()
    println("end loggin")
    clearResource(action2)
}

/**
 * 高阶函数作为返回值，参数需要加noinline
 */
private inline fun proxy2(action: () -> Unit, noinline action2:() -> Unit): () -> Unit {
    println("start loggin")
    action()
    println("end loggin")
    return action2
}

/**
 * 将内联参数做返回值报错
 */
//inline fun action2(block: () -> Unit, blockReturn: () -> Unit): () -> Unit {
//    block()
//    blockReturn()
//    return blockReturn
//}
///** * 实际编译的代码，如果能编译通过的话（其实用inline修饰后，再将函数作为返回值使编译不通过了，需要加noinline关键字的） */
//fun main() {
//    //调用处
//    println("hello")
//    println("world")
//    blockReturn  // ????
//}