package com.solarexsoft.rxjava2inaction.ch06

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by houruhou on 2020/12/8/9:14 PM
 * Desc:
 */
fun main() {
    Observable.ambArray(
        Observable.just(1, 2, 3).delay(1, TimeUnit.SECONDS),
        Observable.just(4, 5, 6)
    ).subscribe(
        { it ->
            println("OnNext: $it")
        },
        { throwable ->
            throwable.printStackTrace()
        }
    )
}