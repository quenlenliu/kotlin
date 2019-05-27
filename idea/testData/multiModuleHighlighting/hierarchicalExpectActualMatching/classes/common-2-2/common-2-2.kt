package sample

actual class Case3<K> : Iterable<K> {
    override fun iterator() = null!!
}

actual enum class Case4

actual enum class Case5 {
    TEST
}

expect abstract class Case21<T : Iterable<<!REDUNDANT_PROJECTION("Iterable")!>out<!> T>>

expect interface Case22<T, K> : Comparable<K> where K: T, T: Iterable<K>

expect object Case23 : Comparable<Int>
