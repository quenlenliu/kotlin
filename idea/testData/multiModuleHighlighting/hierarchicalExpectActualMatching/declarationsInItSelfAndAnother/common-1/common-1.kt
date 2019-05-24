package sample

expect class <!AMBIGUOUS_ACTUALS("Class 'A1'", "common-2, common-1")!>A1<!> {
    val <!AMBIGUOUS_ACTUALS("Property 'x'", "common-2, common-1")!>x<!>: Number
}

actual class A1 {
    actual val x = 10 as Number
}

expect annotation class <!NO_ACTUAL_FOR_EXPECT("annotation class 'A2'", "common-2", "")!>A2<!> {
    actual annotation class A2
}

expect class <!NO_ACTUAL_FOR_EXPECT("class 'A3'", "common-2", "")!>A3<!> {
    actual class A3
}

expect val <!AMBIGUOUS_ACTUALS("Property 'x'", "common-2, common-1")!>x<!>: Int

actual val x = 10
