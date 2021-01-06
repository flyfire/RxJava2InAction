package com.solarexsoft.rxjava2inaction.ch06

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by houruhou on 1/6/21/2:54 PM
 * Desc:
 */
fun main() {
    Single.just(Unit)
        .delay(5, TimeUnit.SECONDS)
        .doOnSubscribe {
            println("onSubscribe ${Thread.currentThread().name} ${System.currentTimeMillis()}")
        }.doOnSuccess {
            println("onSuccess ${Thread.currentThread().name} ${System.currentTimeMillis()}")
        }.subscribeOn(Schedulers.io())
        .subscribe()
    Thread.sleep(6000)
}