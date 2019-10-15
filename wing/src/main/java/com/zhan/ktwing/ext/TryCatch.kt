package com.zhan.ktwing.ext

/**
 *  @author: HyJame
 *  @date:   2019-10-15
 *  @desc:   TODO
 */
inline fun tryCatch(block: TryCatch.() -> Unit) {
    TryCatch().apply(block)
}

inline fun tryCatch(tryBlock: () -> Unit, catchBlock: (Throwable) -> Unit = {}) {
    try {
        tryBlock()
    } catch (t: Throwable) {
        t.printStackTrace()
        catchBlock(t)
    }
}

class TryCatch {

    private var tryBlock: (() -> Unit)? = null
    private var catchBlock: ((Throwable) -> Unit)? = null

    fun onTry(block: () -> Unit) {
        this.tryBlock = block
    }

    fun onCatch(block: (Throwable) -> Unit) {
        this.catchBlock = block
    }
}
