package com.solarexsoft.rxjava2inaction.ch06

import io.reactivex.Single
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 * Created by houruhou on 1/14/21/10:35 AM
 * Desc:
 */
fun main() {
    var disposable1: Disposable? = null
    Single.just(1)
        .doOnSubscribe {
            disposable1 = it
        }
        .doOnSuccess {
            println(it)
        }.subscribe()
    disposable1?.dispose()

    var disposable2: Disposable? = null

    Single.just(2)
        .delay(1, TimeUnit.SECONDS)
        .doOnSubscribe {
            disposable2 = it
        }
        .doOnSuccess {
            println(it)
        }.subscribe()
    disposable2?.dispose()

    Thread.sleep(2000)

}