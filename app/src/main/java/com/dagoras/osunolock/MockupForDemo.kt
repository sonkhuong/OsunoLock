package com.dagoras.osunolock

import com.dagoras.osunolock.model.LockManager

object MockupForDemo {
    val listMyLock = arrayListOf(
        LockManager("Lock SN1", 1, "2022-05-11 -> 2022-15-11"),
        LockManager("Lock SN2", 0, "2022-05-11 -> 2022-07-11")
    )
}