package sample

expect data class Case14(<!EXPECTED_CLASS_CONSTRUCTOR_PROPERTY_PARAMETER!>val x: Int<!>)

expect data class Case15<R>(<!EXPECTED_CLASS_CONSTRUCTOR_PROPERTY_PARAMETER!>val x: R<!>)

expect sealed class Case16

expect sealed class Case17<T>

expect open class Case18<T> where T : Comparable<T>
