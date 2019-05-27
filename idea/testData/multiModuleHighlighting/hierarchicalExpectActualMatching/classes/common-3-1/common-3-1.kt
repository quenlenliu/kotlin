package sample

expect annotation class Case24

expect annotation class Case25 {
    annotation class Foo(val x: Int) {
        sealed class Bar<T> : Iterable<T>, Comparable<T> {
            val x: T
        }
    }
}

actual enum class Case6 {
    TEST
}

actual enum class <!ACTUAL_WITHOUT_EXPECT("Actual enum class 'Case7'", " The following declaration is incompatible because some entries from expected enum are missing in the actual enum:     public final expect enum class Case7 : Enum<Case7> ")!>Case7<!> {
    TEST2
}

actual enum class Case8<!ACTUAL_MISSING!>(<!UNUSED_PARAMETER("x")!>x<!>: Int)<!> {
    TEST(1)
}