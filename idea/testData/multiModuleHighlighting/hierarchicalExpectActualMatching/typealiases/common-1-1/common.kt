package sample

expect class A16<T> : Iterable<T>

expect class A17<T> : Iterable<T>

expect annotation class A18

expect annotation class A19 {
    annotation class A20(val x: Int) {
        sealed class A21<T> : Iterable<T>, Comparable<T> {
            val x: T
        }
    }
}

expect <!EXPERIMENTAL_FEATURE_WARNING("The feature "inline classes" is experimental")!>inline<!> class A22<T>(val x: Int): Comparable<T>

expect class A23<T>() {
    inner class A24<T>() {

    }
}
