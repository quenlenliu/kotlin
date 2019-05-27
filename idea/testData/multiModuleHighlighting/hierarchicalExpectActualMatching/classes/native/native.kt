package sample

actual class Case1

actual class Case2<K>

actual class Case3<K> : Iterable<K> {
    override fun iterator() = null!!
}

actual enum class Case4

actual enum class Case5 {
    TEST
}

actual enum class Case6 {
    TEST
}

actual enum class <!ACTUAL_WITHOUT_EXPECT("Actual enum class 'Case7'", " The following declaration is incompatible because some entries from expected enum are missing in the actual enum:     public final expect enum class Case7 : Enum<Case7> ")!>Case7<!> {
    TEST2
}

actual enum class Case8<!ACTUAL_MISSING!>(<!UNUSED_PARAMETER("x")!>x<!>: Int)<!> {
    TEST(1)
}

actual class Case9<T : Any?>

actual class Case10<T> : Iterable<T> {
    actual override fun iterator(): Nothing = null!!
}

actual class Case11<T> : Iterable<T> {
    override fun <!ACTUAL_MISSING!>iterator<!>(): Nothing = null!!
}

actual <!EXPERIMENTAL_FEATURE_WARNING("The feature "inline classes" is experimental")!>inline<!> class Case12<T>(actual val x: Int): Comparable<T> {
    override fun compareTo(other: T) = null!!
}

// unexpected behaviour: KT-31498
actual class Case13<!ACTUAL_WITHOUT_EXPECT("Actual class 'Case13'", " The following declaration is incompatible because upper bounds of type parameters are different:     public final expect class Case13<T : Int> ")!><T : Number><!>() {
    actual inner class Foo<!ACTUAL_WITHOUT_EXPECT("Actual class 'Foo'", " The following declaration is incompatible because upper bounds of type parameters are different:     public final expect inner class Foo<K : T> ")!><K : T><!> {

    }
}

// unexpected behaviour: KT-18565
actual data class Case14<!ACTUAL_MISSING!>(actual val x: Int)<!>

// unexpected behaviour: KT-18565
actual data class Case15<T><!ACTUAL_WITHOUT_EXPECT("Constructor of 'Case15'", " The following declaration is incompatible because names of type parameters are different:     public constructor Case15<R>(x: R) ")!>(actual val x: T)<!>

actual sealed class Case16

actual sealed class Case17<R>

actual open class Case18<T> where T : Comparable<T>

expect class Case19<T> : Iterable<T>

expect class Case20<T> : Iterable<T>

actual <!ABSTRACT_MEMBER_NOT_IMPLEMENTED("Class 'Case19'", "public abstract operator fun iterator(): Iterator<T> defined in kotlin.collections.Iterable")!>class Case19<!><T> : Iterable<T>

actual class Case20<T> : Iterable<T> {
    actual override fun <!ACTUAL_WITHOUT_EXPECT("Actual function 'iterator'", "")!>iterator<!>(): Nothing = <!UNRESOLVED_REFERENCE("TODO")!>TODO<!>()
}

actual annotation class <!ACTUAL_WITHOUT_EXPECT("Actual annotation class 'Case24'", "")!>Case24<!>

actual annotation class <!ACTUAL_WITHOUT_EXPECT("Actual annotation class 'Case25'", "")!>Case25<!> {
    actual annotation class <!ACTUAL_WITHOUT_EXPECT("Actual annotation class 'Foo'", "")!>Foo<!>(actual val <!ACTUAL_WITHOUT_EXPECT("Actual property 'x'", "")!>x<!>: Int = 10) {
        actual sealed class <!ACTUAL_WITHOUT_EXPECT("Actual class 'Bar'", "")!>Bar<!><T> : Iterable<T>, Comparable<T> {
            actual val <!ACTUAL_WITHOUT_EXPECT("Actual property 'x'", "")!>x<!>: T = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>
        }
    }
}
