package com.solarexsoft.rxjava2inaction.ch04

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * Created by houruhou on 2020/11/20/7:24 PM
 * Desc:
 */
fun main() {
    Observable.just("aaa", "bbb")
        .subscribeOn(Schedulers.newThread())
        .map(Function<String, String> {
            println(Thread.currentThread().name)
            it.toUpperCase()
        })
        .subscribeOn(Schedulers.single())
        .subscribe(
            {
                println("${Thread.currentThread().name} --> $it")
            },
            {
                it.printStackTrace()
            }
        )
    Single.just(1)
        .subscribeOn(Schedulers.single())
        .observeOn(Schedulers.newThread())
        .map {
            println("${Thread.currentThread().name} - $it")
            it + 10
        }
        .observeOn(Schedulers.io())
        .map {
            println("${Thread.currentThread().name} - $it")
            it + 100
        }
        .observeOn(Schedulers.computation())
        .subscribe(
            {
                println("${Thread.currentThread().name} - $it")
            },
            {
                it.printStackTrace()
            }
        )

    Thread.sleep(500)
}