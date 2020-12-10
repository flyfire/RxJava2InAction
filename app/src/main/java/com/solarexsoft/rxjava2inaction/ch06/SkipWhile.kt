package com.solarexsoft.rxjava2inaction.ch06

import io.reactivex.Observable
import io.reactivex.functions.Predicate

/**
 * Created by houruhou on 2020/12/10/9:50 PM
 * Desc:
 */
fun main() {
    Observable.just(1, 2, 3, 4, 5)
        .skipWhile(Predicate {
            it<=2
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