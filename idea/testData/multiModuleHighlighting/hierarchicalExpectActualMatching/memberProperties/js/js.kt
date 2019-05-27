package sample

actual class A1 {
    actual val x = 0f as Number
}

val <T> T.x2 get() = 0 <!UNCHECKED_CAST("Int", "T")!>as T<!>

actual class A2<K> {
    actual var x = (0 <!UNCHECKED_CAST("Int", "K")!>as K<!>).x2
}

actual class A3<K> : Iterable<K> {
    actual override fun iterator() = TODO()
    actual protected val y = null <!UNCHECKED_CAST("Nothing?", "K")!>as K<!>
}

actual enum class A4 {
    TEST, TEST1;
    actual val x = 10
}

actual enum class A5(actual val x: Int)

actual enum class A6 <!ACTUAL_WITHOUT_EXPECT("Actual constructor of 'A6'", "")!>actual constructor(actual val x: Int)<!>

actual annotation class A14<T>(actual val x: Int)
