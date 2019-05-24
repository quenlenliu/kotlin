package sample

expect class A3<T> : Iterable<T> {
    override fun iterator(): Nothing
    protected val y: T
}

expect enum class A4 {
    TEST;
    val x: Int
}
