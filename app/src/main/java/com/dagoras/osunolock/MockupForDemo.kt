package com.dagoras.osunolock

import com.dagoras.osunolock.model.Lock
import com.dagoras.osunolock.model.LockManager
import com.dagoras.osunolock.model.Unlock
import com.dagoras.osunolock.model.User

object MockupForDemo {
    val listUser = arrayListOf(
        User(0, "0123", "abc123"),
        User(1, "abc", "abc123"),
        User(2, "xyz", "abc123"),
    )

    val listLock = arrayListOf(
        Lock(0, "OSUNO-01", "Lock 01", "3E:1A", 10, false),
        Lock(1, "OSUNO-02", "Lock 02", "4E:2A", 36, true),
        Lock(2, "OSUNO-03", "Lock 03", "1E:5A", 72, false),
    )

    val listUnlock = arrayListOf(
        Unlock(0, 0, "Son1", "10-11-2022", "10-12-2022", null, null),
        Unlock(1, 1, "Son2", null, null, 20, null),
        Unlock(2, 2, "Son3", "10-11-2022", null, null, "234"),
        Unlock(3, 3, "Son4", "10-11-2022", "10-18-2022", null, "23456"),
        Unlock(4, 4, "Son5", "10-11-2022", "10-12-2022", 10, null),
    )

    val listLockManager = arrayListOf(
        LockManager(0, 0, 1, 1, null, "10-11-2022", "12-11-2022", null, null),
        LockManager(1, 1, 1, 0, 1, "09-11-2022", "10-11-2022", null, null),
    )
}