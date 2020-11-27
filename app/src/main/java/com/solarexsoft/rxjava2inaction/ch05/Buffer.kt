package com.solarexsoft.rxjava2inaction.ch05

import io.reactivex.Observable

/**
 * Created by houruhou on 2020/11/27/8:49 PM
 * Desc:
 */
fun main() {
    Observable.range(1, 11)
        .buffer(5, 1)
        .subscribe(
            {
                println("onNext: $it")
            },
            {
                it.printStackTrace()
            }
        )

    println("----------------------")

    Observable.range(1, 11)
        .buffer(5, 2)
        .subscribe(
            {
                println("onNext: $it")
            },
            {
                it.printStackTrace()
            }
        )
}