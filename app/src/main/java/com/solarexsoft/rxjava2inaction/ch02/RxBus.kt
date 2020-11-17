package com.solarexsoft.rxjava2inaction.ch02

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by houruhou on 2020/11/17/9:28 PM
 * Desc:
 */
class RxBus {
    companion object {
        val BUS = RxBus()
    }
    val mBus = PublishSubject.create<Any>().toSerialized()

    fun get(): RxBus {
        return BUS
    }

    fun post(obj: Any) {
        mBus.onNext(obj)
    }

    fun <T> toObservable(tClz: Class<T>): Observable<T>? {
        return mBus.ofType(tClz)
    }

    fun toObservable(): Observable<Any> {
        return mBus
    }

    fun hasObservers(): Boolean {
        return mBus.hasObservers()
    }
}