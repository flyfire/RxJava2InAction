package com.solarexsoft.rxjava2inaction.ch04

import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

/**
 * Created by houruhou on 2020/11/20/9:05 PM
 * Desc:
 */
fun main() {
    val scheduler = TestScheduler()
    val atomicLong = AtomicLong()
    Observable.timer(2, TimeUnit.SECONDS, scheduler)
        .subscribe(
            {
                atomicLong.incrementAndGet()
            },
            {
                it.printStackTrace()
            }
        )
    println("atomic = ${atomicLong.get()}, virtual time: ${scheduler.now(TimeUnit.SECONDS)}")
    scheduler.advanceTimeBy(1, TimeUnit.SECONDS)
    println("atomic = ${atomicLong.get()}, virtual time: ${scheduler.now(TimeUnit.SECONDS)}")
    scheduler.advanceTimeBy(-1, TimeUnit.SECONDS)
    println("atomic = ${atomicLong.get()}, virtual time: ${scheduler.now(TimeUnit.SECONDS)}")
    scheduler.advanceTimeBy(1, TimeUnit.SECONDS)
    println("atomic = ${atomicLong.get()}, virtual time: ${scheduler.now(TimeUnit.SECONDS)}")
    scheduler.advanceTimeBy(1, TimeUnit.SECONDS)
    println("atomic = ${atomicLong.get()}, virtual time: ${scheduler.now(TimeUnit.SECONDS)}")

    println("----------------------------")

    val testScheduler = TestScheduler()
    testScheduler.createWorker().schedule {
        println("${Thread.currentThread().name} - virtual time: ${testScheduler.now(TimeUnit.SECONDS)}")
    }
    testScheduler.createWorker().schedule({
        println("${Thread.currentThread().name} - virtual time: ${testScheduler.now(TimeUnit.SECONDS)}")
    }, 20, TimeUnit.SECONDS)
    println("${Thread.currentThread().name} - virtual time: ${testScheduler.now(TimeUnit.SECONDS)}")
    testScheduler.advanceTimeBy(20, TimeUnit.SECONDS)
    testScheduler.triggerActions()
}