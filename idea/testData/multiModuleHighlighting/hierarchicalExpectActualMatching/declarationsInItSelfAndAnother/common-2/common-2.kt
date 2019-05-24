package sample

actual class A1 {
    actual val x = 10 as Number
}

expect val x: Int

actual val <!AMBIGUOUS_EXPECTS("Actual property 'x'", "common-2, common-1")!>x<!> = 10
