package sample

actual fun x1(): List<Int> = listOf(1)

actual fun x2(): Nothing = null!!

actual fun <T> MutableList<out T>.x2() = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>

actual fun <T> Map<in T, <!REDUNDANT_PROJECTION("Map")!>out<!> T>.x2() = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>
