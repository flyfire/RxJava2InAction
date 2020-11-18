package com.solarexsoft.rxjava2inaction.ch03

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by houruhou on 2020/11/18/9:31 PM
 * Desc:
 */
fun main() {
    val start = System.currentTimeMillis()
    Observable.interval(500, TimeUnit.MILLISECONDS)
        .take(5)
        .repeatUntil {
            System.currentTimeMillis() - start > 5000
        }.subscribe(
            {
                println(it)
            },
            {
                it.printStackTrace()
            }
        )
    Thread.sleep(6000)
}