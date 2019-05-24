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

expect object A13 {
    val x1: Int

    object A13 {
        val x2: Int
        object A13 {
            val x3: Int
            object A13 {
                val x4: Int
            }
        }
    }

    class A14 {
        val x2: Int
    }

    sealed class A15<T> {
        val x2: T
    }

    interface A16<K> {
        val x2: K

        fun <K> foo(): K
    }

    annotation class P<T> {
        interface A16<K> {
            val x2: K

            // unexpected behaviour: KT-30065
            fun <K>foo(): K
        }
    }
}
