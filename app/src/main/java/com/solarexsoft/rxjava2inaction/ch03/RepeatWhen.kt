package com.solarexsoft.rxjava2inaction.ch03

import io.reactivex.Observable
import java.util.concurrent.TimeUnit


/**
 * Created by houruhou on 2020/11/18/9:25 PM
 * Desc:
 */
fun main() {
    Observable.range(0, 9)
        .repeatWhen {
            Observable.timer(10, TimeUnit.SECONDS)
        }.subscribe(
            {
                println(it)
            },
            {
                it.printStackTrace()
            }
        )
    Thread.sleep(12000)
}