package com.solarexsoft.rxjava2inaction.ch03

import io.reactivex.Observable
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by houruhou on 2020/11/18/9:02 PM
 * Desc:
 */
fun main() {
    val executorService = Executors.newCachedThreadPool()
    val future = executorService.submit(SleepFiveSecondCallable())
    Observable.fromFuture(future, 4, TimeUnit.SECONDS)
        .subscribe(
            {
                println(it)
            },
            {
                it.printStackTrace()
            }
        )
}

class SleepFiveSecondCallable: Callable<String> {
    override fun call(): String {
        println("mock time consuming task")
        Thread.sleep(5000)
        return "OK"
    }

}