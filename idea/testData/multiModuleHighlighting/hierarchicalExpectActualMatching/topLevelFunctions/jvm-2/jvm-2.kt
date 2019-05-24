package sample

actual <!NOTHING_TO_INLINE("public actual inline fun Number.x2(): Int defined in sample in file jvm-2.kt")!>inline<!> fun Number.x2() = 10

actual <!NOTHING_TO_INLINE("public actual inline fun <T> T.x3(): T defined in sample in file jvm-2.kt")!>inline<!> fun <T> T.x3() = 10 <!UNCHECKED_CAST("Int", "T")!>as T<!>

actual fun x4() = 10

actual inline fun <!ACTUAL_WITHOUT_EXPECT("Actual function 'x5'", " The following declaration is incompatible because some type parameter is reified in one declaration and non-reified in the other:     public expect fun <T> T.x5(): T ")!><reified T><!> T.x5() = null as T

actual fun x6() = 10

actual fun <T> Map<in T, <!REDUNDANT_PROJECTION("Map")!>out<!> T>.x2() = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>