package sample

actual fun x7() = object : I {}

actual <!NOTHING_TO_INLINE("public actual inline fun <T> T.x8(): I defined in sample in file jvm-3.kt")!>inline<!> fun <T> T.x8() = object : I {}

class Case9 : I {}

actual fun <!ACTUAL_WITHOUT_EXPECT("Actual function 'x9'", " The following declaration is incompatible because return type is different:     public expect fun x9(): I ")!>x9<!>() = Case9()

actual fun <!ACTUAL_WITHOUT_EXPECT("Actual function 'x10'", " The following declaration is incompatible because return type is different:     public expect fun x10(): Number ")!>x10<!>() = 10

actual suspend fun x11() = 10

actual suspend inline fun <T> (suspend T.(T) -> T).x12(crossinline x: (T) -> T): T = x(<!NO_VALUE_FOR_PARAMETER("p1")!>)<!>

actual suspend inline fun <T> (suspend T.(T) -> T).x13<!ACTUAL_WITHOUT_EXPECT("Actual function 'x13'", " The following declaration is incompatible because parameter types are different:     public expect suspend inline fun <T> (T.(T) -> T).x13(crossinline x: (T) -> T): T ")!>(crossinline x: (T) -> T)<!>: T = x(<!NO_VALUE_FOR_PARAMETER("p1")!>)<!>

actual suspend inline fun <T> (suspend T.(T) -> T).x14<!ACTUAL_WITHOUT_EXPECT("Actual function 'x14'", " The following declaration is incompatible because some value parameter is noinline in one declaration and not noinline in the other:     public expect suspend inline fun <T> (suspend T.(T) -> T).x14(crossinline x: (T) -> T): T ")!>(noinline x: (T) -> T)<!>: T = x(<!NO_VALUE_FOR_PARAMETER("p1")!>)<!>

<!ACTUAL_WITHOUT_EXPECT("Actual function 'x15'", " The following declaration is incompatible because modifiers are different (suspend):     public expect suspend fun <T> (suspend T.(T) -> T).x15(x: (T) -> T): T ")!>actual<!> fun <T> (suspend T.(T) -> T).x15(x: (T) -> T): T = x(<!NO_VALUE_FOR_PARAMETER("p1")!>)<!>

actual fun <T> T.x5() = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>

actual fun x6() = 10

actual fun <T> Map<in T, <!REDUNDANT_PROJECTION("Map")!>out<!> T>.x2() = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>
