package com.solarexsoft.rxjava2inaction.ch05

import io.reactivex.Observable

/**
 * Created by houruhou on 2020/11/27/9:04 PM
 * Desc:
 */
fun main() {
    Observable.range(1, 11)
        .window(2)
        .subscribe(
            {
                println("onNext")
                it.subscribe(
                    { element ->
                        println("accept $element")
                    },
                    {
                        it.printStackTrace()
                    }
                )
            },
            {
                it.printStackTrace()
            }
        )
}