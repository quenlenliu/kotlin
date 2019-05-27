package sample

expect interface A11<T, K> : Comparable<K> where K: T, T: Iterable<K>

expect object A12 : Comparable<Int>

expect class A14<T> : Iterable<T> {
    override fun iterator(): Nothing
}

expect class A15<T> : Iterable<T> {
    override fun iterator(): Nothing
    fun iterator4(): Nothing
}
