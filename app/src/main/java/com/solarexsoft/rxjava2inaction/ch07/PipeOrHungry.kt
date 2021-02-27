package com.solarexsoft.rxjava2inaction.ch07

import io.reactivex.Observable

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 10:07 PM/2/27/21
 *    Desc: pipe
 * </pre>
 */

fun main() {
    Observable.create<Int> { it ->
        it.onNext(1)
        it.onNext(2)
        it.onNext(3)
        it.onNext(4)
    }.filter {
        println("filter $it")
        it % 2 == 0
    }.map {
        println("map $it")
        it * 2 + 1
    }.forEach {
        println("foreach $it")
    }
}