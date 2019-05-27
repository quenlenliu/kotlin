package sample

expect enum class A43 {
    TEST
}

expect enum class A4103 {
    TEST;
    val x: Int
}

expect enum class A44<!EXPECTED_ENUM_CONSTRUCTOR!>(x: Int)<!> {
    TEST
}

expect data class A5(<!EXPECTED_CLASS_CONSTRUCTOR_PROPERTY_PARAMETER!>val x: Int<!>)

expect data class A6<R>(<!EXPECTED_CLASS_CONSTRUCTOR_PROPERTY_PARAMETER!>val x: R<!>)

expect sealed class A7

expect sealed class A8<T>

expect open class A9<T> where T : Comparable<T>

expect abstract class A10<T : Iterable<<!REDUNDANT_PROJECTION("Iterable")!>out<!> T>>
