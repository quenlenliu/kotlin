package sample

expect fun x1(): List<Int>

expect fun x2(): Nothing

expect fun <T> MutableList<out T>.x2(): T

expect fun <T> Map<in T, <!REDUNDANT_PROJECTION("Map")!>out<!> T>.x2(): T
