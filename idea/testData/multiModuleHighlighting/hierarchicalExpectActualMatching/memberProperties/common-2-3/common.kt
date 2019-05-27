package sample

expect sealed class A7 {
    <!EXPECTED_LATEINIT_PROPERTY!>lateinit<!> var x: Any
}

expect sealed class A8 {
    var x: Any
}

expect object A12 : Comparable<Int> {
    <!EXPECTED_DECLARATION_WITH_BODY!>override fun compareTo(other: Int)<!> = <!UNRESOLVED_REFERENCE("TODO")!>TODO<!>()
    <!CONST_VAL_WITHOUT_INITIALIZER!>const<!> val x: Int
}
