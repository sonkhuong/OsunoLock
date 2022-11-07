package com.dagoras.osunolock

import com.dagoras.osunolock.models.Account
import com.dagoras.osunolock.models.MyLock

object MockupForDemo {
    val listAccount =
        arrayListOf(Account("0987127312", "123", "xxx"), Account("0971888123", "123", "xxx"))
    val listMyLock = arrayListOf(
        MyLock("Lock SN1", 1, "2022-05-11 -> 2022-15-11"),
        MyLock("Lock SN2", 0, "2022-05-11 -> 2022-07-11")
    )
}