package com.example.higherorderfunction.hightorderfun

/**
 * 自己实现常用高阶函数
 */
class StandardKt {

    inline fun <T> Iterable<T>.myFilter(predicate:(T) -> Boolean): List<T> {
        var list = ArrayList<T>()

        for (item in this) {
            if (predicate(item)) {
                list.add(item)
            }
        }

        return list
    }

    inline fun <T> Iterable<T>.myForEach(handle:(T) -> Unit) {
        for (item in this) {
            handle(item)
        }
    }

    inline fun <T> T.myApply(handle:(T)-> Unit): T {
        handle(this)
        return this
    }

    inline fun <T, R> myWith(t: T, use:(T)-> R): R {
        return use(t)
    }

    inline fun <T, R> T.myRun(handle:(T) -> R): R {
        return handle(this)
    }
}