package sample

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
