package sample

expect class A1 {
    val x: Number
}

actual class A1 {
    actual val x = 10 as Number
}

expect annotation class <!NO_ACTUAL_FOR_EXPECT("annotation class 'A2'", "common", "")!>A2<!> {
    actual annotation class A2
}

expect class <!NO_ACTUAL_FOR_EXPECT("class 'A3'", "common", "")!>A3<!> {
    actual class A3
}

expect val x: Int

actual val x = 10
