package com.solarexsoft.rxjava2inaction.ch06

import io.reactivex.Observable
import io.reactivex.functions.Predicate
import java.util.concurrent.TimeUnit

/**
 * Created by houruhou on 2020/12/10/9:55 PM
 * Desc:
 */
fun main() {
    Observable.just(1, 2, 3, 4, 5)
        .takeUntil(Predicate {
            it == 5
        })
        .subscribe(
            {
                println(it)
            },
            {
                it.printStackTrace()
            }
        )

    println("--------------------")

    Observable.intervalRange(1, 9, 0, 1, TimeUnit.MILLISECONDS)
        .takeUntil(Observable.timer(5, TimeUnit.MILLISECONDS))
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