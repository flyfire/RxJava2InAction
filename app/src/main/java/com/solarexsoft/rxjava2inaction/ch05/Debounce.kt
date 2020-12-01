package com.solarexsoft.rxjava2inaction.ch05

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import java.util.concurrent.TimeUnit

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 08:12/2020/12/1
 *    Desc:
 * </pre>
 */
fun main() {
    Observable.create(ObservableOnSubscribe<Int> { emitter ->
        if (emitter.isDisposed) {
            return@ObservableOnSubscribe
        }
        for (i in 1..10) {
            emitter.onNext(i)
            Thread.sleep(i*100L)
        }
        emitter.onComplete()
    }).debounce(500L, TimeUnit.MILLISECONDS)
        .subscribe(
            {
                println("onNext: $it")
            },
            {
                it.printStackTrace()
            }
        )
}
 