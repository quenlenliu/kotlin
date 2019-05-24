package sample

actual fun x7() = object : I {}

actual <!NOTHING_TO_INLINE("public actual inline fun <T> T.x8(): I defined in sample in file common-4.kt")!>inline<!> fun <T> T.x8() = object : I {}

expect tailrec fun x16(y: () -> Unit): Int

expect infix fun <T> T.x17(x: Int): Int

expect infix fun <T> T.x18(x: Int): Int

expect fun <T> T.x19(x: Int): Int

actual suspend fun x11() = 10

expect operator fun CharSequence.plus(x: Int): Int

expect internal suspend inline infix operator fun <T> T.plus(x: () -> T): T

expect infix operator fun <T> T.minus(x: () -> T): T

expect fun x20(): Int

expect internal fun x21(): Int

class Case9 : I {}

actual fun <!ACTUAL_WITHOUT_EXPECT("Actual function 'x9'", " The following declaration is incompatible because return type is different:     public expect fun x9(): I ")!>x9<!>() = Case9()

actual fun <!ACTUAL_WITHOUT_EXPECT("Actual function 'x10'", " The following declaration is incompatible because return type is different:     public expect fun x10(): Number ")!>x10<!>() = 10

actual suspend inline fun <T> (suspend T.(T) -> T).x12(crossinline x: (T) -> T): T = x(<!NO_VALUE_FOR_PARAMETER("p1")!>)<!>

actual suspend fun <T> (suspend T.(T) -> T).x15(x: (T) -> T): T = x(<!NO_VALUE_FOR_PARAMETER("p1")!>)<!>
