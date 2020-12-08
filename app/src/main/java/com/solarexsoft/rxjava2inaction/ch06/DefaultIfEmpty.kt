package com.solarexsoft.rxjava2inaction.ch06

import io.reactivex.Observable

/**
 * Created by houruhou on 2020/12/8/9:29 PM
 * Desc:
 */
fun main() {
    Observable.empty<Int>()
        .defaultIfEmpty(8)
        .subscribe(
            {
                println(it)
            },
            {
                it.printStackTrace()
            }
        )
    Observable.empty<Int>()
        .switchIfEmpty(Observable.just(1, 2, 3))
        .subscribe(
            {
                println(it)
            },
            {
                it.printStackTrace()
            }
        )
}