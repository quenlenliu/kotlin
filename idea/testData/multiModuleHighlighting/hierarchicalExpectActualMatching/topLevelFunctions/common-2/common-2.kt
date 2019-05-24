package sample

actual fun x1(): List<Int> = listOf(1)

actual fun x2(): Nothing = null!!

expect fun Number.x2(): Int

expect inline fun <T> T.x3(): T

expect fun x4(): Int

expect fun <T> T.x5(): T

expect fun x6(): Int

actual fun <T> MutableList<out T>.x2() = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>
