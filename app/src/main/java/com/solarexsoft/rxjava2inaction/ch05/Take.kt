package com.solarexsoft.rxjava2inaction.ch05

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by houruhou on 2020/11/27/9:19 PM
 * Desc:
 */
fun main() {
    Observable.intervalRange(0, 10, 1, 1, TimeUnit.SECONDS)
        .take(3, TimeUnit.SECONDS)
        .subscribe(
            {
                println("onNext $it")
            },
            {
                it.printStackTrace()
            }
        )

    Thread.sleep(10000)
}