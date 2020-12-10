package com.solarexsoft.rxjava2inaction.ch06

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by houruhou on 2020/12/10/9:44 PM
 * Desc:
 */
fun main() {
    Observable.intervalRange(1, 9, 0, 1, TimeUnit.MILLISECONDS)
        .skipUntil(Observable.timer(4, TimeUnit.MILLISECONDS))
        .subscribe(
            {
                println(it)
            },
            {
                it.printStackTrace()
            }
        )

    Thread.sleep(1000)
}