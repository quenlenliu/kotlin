package sample

actual <!NOTHING_TO_INLINE("public actual inline fun Number.x2(): Int defined in sample in file common-3.kt")!>inline<!> fun Number.x2() = 10

interface I

expect fun x7(): I

expect fun <T> T.x8(): I

expect fun x9(): <!NO_ACTUAL_FOR_EXPECT("function 'x9'", "js-3 for JS", " The following declaration is incompatible because return type is different:     public actual fun x9(): Case9 "), NO_ACTUAL_FOR_EXPECT("function 'x9'", "js-4 for JS", " The following declaration is incompatible because return type is different:     public actual fun x9(): Case9 "), NO_ACTUAL_FOR_EXPECT("function 'x9'", "jvm-3 for JVM", " The following declaration is incompatible because return type is different:     public actual fun x9(): Case9 "), NO_ACTUAL_FOR_EXPECT("function 'x9'", "jvm-4 for JVM", " The following declaration is incompatible because return type is different:     public actual fun x9(): Case9 ")!>I<!>

expect fun x10(): <!NO_ACTUAL_FOR_EXPECT("function 'x10'", "js-3 for JS", " The following declaration is incompatible because return type is different:     public actual fun x10(): Int "), NO_ACTUAL_FOR_EXPECT("function 'x10'", "js-4 for JS", " The following declaration is incompatible because return type is different:     public actual fun x10(): Int "), NO_ACTUAL_FOR_EXPECT("function 'x10'", "jvm-3 for JVM", " The following declaration is incompatible because return type is different:     public actual fun x10(): Int "), NO_ACTUAL_FOR_EXPECT("function 'x10'", "jvm-4 for JVM", " The following declaration is incompatible because return type is different:     public actual fun x10(): Int ")!>Number<!>

actual <!NOTHING_TO_INLINE("public actual inline fun <T> T.x3(): T defined in sample in file common-3.kt")!>inline<!> fun <T> T.x3() = 10 <!UNCHECKED_CAST("Int", "T")!>as T<!>

expect suspend fun x11(): Int

expect suspend inline fun <T> (suspend T.(T) -> T).x12(crossinline x: (T) -> T): T

expect suspend inline fun <T> (T.(T) -> T).x13<!NO_ACTUAL_FOR_EXPECT("function 'x13'", "js-3 for JS", " The following declaration is incompatible because parameter types are different:     public actual suspend inline fun <T> (suspend T.(T) -> T).x13(crossinline x: (T) -> T): T "), NO_ACTUAL_FOR_EXPECT("function 'x13'", "js-4 for JS", " The following declaration is incompatible because parameter types are different:     public actual suspend inline fun <T> (suspend T.(T) -> T).x13(crossinline x: (T) -> T): T "), NO_ACTUAL_FOR_EXPECT("function 'x13'", "jvm-3 for JVM", " The following declaration is incompatible because parameter types are different:     public actual suspend inline fun <T> (suspend T.(T) -> T).x13(crossinline x: (T) -> T): T "), NO_ACTUAL_FOR_EXPECT("function 'x13'", "jvm-4 for JVM", " The following declaration is incompatible because parameter types are different:     public actual suspend inline fun <T> (suspend T.(T) -> T).x13(crossinline x: (T) -> T): T ")!>(crossinline x: (T) -> T)<!>: T

expect suspend inline fun <T> (suspend T.(T) -> T).x14(crossinline x: (T) -> T): T

expect suspend fun <T> (suspend T.(T) -> T).x15(x: (T) -> T): T

actual fun x4() = 10

