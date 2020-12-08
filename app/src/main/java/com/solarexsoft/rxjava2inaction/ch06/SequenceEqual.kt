package com.solarexsoft.rxjava2inaction.ch06

import io.reactivex.Observable
import io.reactivex.functions.BiPredicate

/**
 * Created by houruhou on 2020/12/8/9:37 PM
 * Desc:
 */

data class TestSequenceEqualClass(
    val tag: String = "",
    val variant: String = ""
)
fun main() {
    Observable.sequenceEqual(
        Observable.just(TestSequenceEqualClass("1", "1"),TestSequenceEqualClass("2", "2"), TestSequenceEqualClass("3", "3")),
        Observable.just(TestSequenceEqualClass("1", "1"),TestSequenceEqualClass("2", "3"), TestSequenceEqualClass("3", "3")),
        BiPredicate { t1, t2 -> t1 == t2 }
    ).subscribe(
        {
            println("same: $it")
        },
        {
            it.printStackTrace()
        }
    )
}