package sample

expect class Case1

expect class Case2<T>

expect class Case3<T> : Iterable<T>

expect enum class Case4

expect enum class Case5 {
    TEST
}

expect enum class Case6 {
    TEST
}

expect enum class Case7 {
    TEST
}

expect enum class Case8<!EXPECTED_ENUM_CONSTRUCTOR!>(x: Int)<!> {
    TEST
}
