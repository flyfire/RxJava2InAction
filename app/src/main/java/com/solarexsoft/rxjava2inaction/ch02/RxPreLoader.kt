package com.solarexsoft.rxjava2inaction.ch02

import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by houruhou on 2020/11/17/9:34 PM
 * Desc:
 */
class RxPreLoader<T>(private val defaultValue: T) {
    private val data = BehaviorSubject.createDefault(defaultValue)
    private var disposable: Disposable? = null

    fun publish(obj: T) {
        data.onNext(obj)
    }

    fun subscribe(consumer: Consumer<T>): Disposable {
        disposable = data.subscribe(consumer)
        return disposable!!
    }

    fun dispose() {
        disposable?.let {
            if (!it.isDisposed) {
                it.dispose()
                disposable = null
            }
        }
    }

    fun cacheDataSubject(): BehaviorSubject<T> {
        return data
    }

    fun lastCacheData(): T? {
        return data.value
    }
}