package sample

actual fun <T> Map<in T, <!REDUNDANT_PROJECTION("Map")!>out<!> T>.x2() = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>

actual fun <T> T.x5() = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>

actual fun x6() = 10

actual suspend inline fun <T> (suspend T.(T) -> T).x13<!ACTUAL_WITHOUT_EXPECT("Actual function 'x13'", " The following declaration is incompatible because parameter types are different:     public expect suspend inline fun <T> (T.(T) -> T).x13(crossinline x: (T) -> T): T ")!>(crossinline x: (T) -> T)<!>: T = x(<!NO_VALUE_FOR_PARAMETER("p1")!>)<!>

actual suspend inline fun <T> (suspend T.(T) -> T).x14<!ACTUAL_WITHOUT_EXPECT("Actual function 'x14'", " The following declaration is incompatible because some value parameter is noinline in one declaration and not noinline in the other:     public expect suspend inline fun <T> (suspend T.(T) -> T).x14(crossinline x: (T) -> T): T ")!>(noinline x: (T) -> T)<!>: T = x(<!NO_VALUE_FOR_PARAMETER("p1")!>)<!>

actual tailrec fun x16(y: () -> Unit): Int {
    y()
    return if (true) 10 else x16 { }
}

actual infix fun <T> T.x17(x: Int) = 10

<!ACTUAL_WITHOUT_EXPECT("Actual function 'x18'", " The following declaration is incompatible because some modifiers on expected declaration are missing on the actual one (external, infix, inline, operator, tailrec):     public expect infix fun <T> T.x18(x: Int): Int ")!>actual<!> fun <T> T.x18(x: Int) = 10

actual infix fun <T> T.x19(x: Int) = 10

actual operator fun CharSequence.plus(x: Int) = 10

actual internal suspend inline infix operator fun <T> T.plus(x: () -> T) = x()

<!ACTUAL_WITHOUT_EXPECT("Actual function 'minus'", " The following declaration is incompatible because some modifiers on expected declaration are missing on the actual one (external, infix, inline, operator, tailrec):     public expect infix operator fun <T> T.minus(x: () -> T): T ")!>actual operator<!> fun <T> T.minus(x: () -> T) = x()

actual <!ACTUAL_WITHOUT_EXPECT("Actual function 'x20'", " The following declaration is incompatible because visibility is different:     public expect fun x20(): Int ")!>internal<!> fun x20() = 10

actual fun x21() = 10
