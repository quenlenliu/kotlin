package sample

actual class Case9<T : Any?>

actual class Case10<T> : Iterable<T> {
    actual override fun iterator(): Nothing = TODO()
}

actual class Case11<T> : Iterable<T> {
    override fun <!ACTUAL_MISSING!>iterator<!>(): Nothing = TODO()
}

actual <!EXPERIMENTAL_FEATURE_WARNING("The feature "inline classes" is experimental")!>inline<!> class Case12<T>(actual val x: Int): Comparable<T> {
    override fun compareTo(other: T) = TODO()
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

actual <!ABSTRACT_MEMBER_NOT_IMPLEMENTED("Class 'Case19'", "public abstract operator fun iterator(): Iterator<T> defined in kotlin.collections.Iterable")!>class Case19<!><T> : Iterable<T>

actual class Case20<T> : Iterable<T> {
    actual override fun <!ACTUAL_WITHOUT_EXPECT("Actual function 'iterator'", "")!>iterator<!>(): Nothing = TODO()
}

actual abstract class Case21<T : Iterable<<!REDUNDANT_PROJECTION("Iterable")!>out<!> T>>

actual interface Case22<T, K> : Comparable<K> where K: T, T: Iterable<K>

actual object Case23 : Comparable<Int> {
    override fun compareTo(other: Int) = TODO()
}

actual annotation class Case24

actual annotation class Case25 {
    actual annotation class Foo(actual val x: Int = 10) {
        actual sealed class Bar<T> : Iterable<T>, Comparable<T> {
            actual val x: T = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>
        }
    }
}
