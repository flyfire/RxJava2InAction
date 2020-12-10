package com.solarexsoft.rxjava2inaction.ch06

import io.reactivex.Observable
import io.reactivex.functions.Predicate

/**
 * Created by houruhou on 2020/12/10/10:01 PM
 * Desc:
 */
fun main() {
    Observable.just(1, 2, 3, 4, 5)
        .takeWhile(Predicate {
            it <= 3
        })
        .subscribe(
            {
                println(it)
            },
            {
                it.printStackTrace()
            }
        )
}