package sample

actual typealias A1 = Nothing

class List1<K> : List<K> {
    override val size: Int get() = TODO()
    override fun contains(element: K)= TODO()
    override fun containsAll(elements: Collection<K>)= TODO()
    override fun get(index: Int)= TODO()
    override fun indexOf(element: K)= TODO()
    override fun isEmpty()= TODO()
    override fun iterator()= TODO()
    override fun lastIndexOf(element: K)= TODO()
    override fun listIterator()= TODO()
    override fun listIterator(index: Int)= TODO()
    override fun subList(fromIndex: Int, toIndex: Int) = TODO()
}

actual typealias A2<K> = List1<K>

interface I2<K> : Iterable<K>

class A<T : Any?> : Iterable<T>, I2<T> {
    override fun iterator() = TODO()
}

actual typealias A3<T> = A<T>

interface I3<K> : Iterable<K>

class A414<T> : I2<T> {
    override fun iterator() = TODO()
}

actual typealias <!ACTUAL_WITHOUT_EXPECT("Actual typealias 'A31'", " The following declaration is incompatible because some supertypes are missing in the actual declaration:     public final expect class A31<T> : Iterable<T> ")!>A31<!><T> = A414<T>

class A4141<T> : Iterable<Int> {
    override fun iterator() = TODO()
}

actual typealias <!ACTUAL_WITHOUT_EXPECT("Actual typealias 'A311'", " The following declaration is incompatible because some supertypes are missing in the actual declaration:     public final expect class A311<T> : Iterable<T> ")!>A311<!><T> = A4141<T>

expect enum class A410 {}
actual enum class A410 {}

actual typealias A4 = A410

enum class A4101 { TEST }

actual typealias A41 = A4101

enum class A4102 { TEST2 }

actual typealias <!ACTUAL_WITHOUT_EXPECT("Actual typealias 'A42'", " The following declaration is incompatible because some entries from expected enum are missing in the actual enum:     public final expect enum class A42 : Enum<A42> ")!>A42<!> = A4102

actual enum class A4103 { TEST; actual val x = 10; }

actual typealias A43 = A4103

enum class A4411(<!UNUSED_PARAMETER("x")!>x<!>: Int) {
    TEST(10)
}

actual typealias A44 = A4411

data class A511(val x: Int)

actual typealias A5 = A511

data class A512<K>(val x: K)

actual typealias <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS("A512", "      public constructor A6<R>(x: R)      The following declaration is incompatible because names of type parameters are different:         public constructor A512<K>(x: K) ")!>A6<!><T> = A512<T>

sealed class A71(val x: Int) : Iterable<Int> {
    override fun iterator() = TODO()
}

actual typealias A7 = A71

sealed class A81<K> : Iterable<K> {
    abstract override fun iterator(): Iterator<K>
}

actual typealias A8<Y> = A81<Y>

open class A91<T : Comparable<T>> constructor(var x: Int = 10)

actual typealias A9<Y> = A91<Y>

abstract class A101<T : Iterable<T>>

actual typealias A10<Y> = A101<Y>

interface A111<T, K : T> : Comparable<K> where T: Iterable<K>

actual typealias A11<Y, P> = A111<Y, P>

object A121 : Comparable<Int> {
    override fun compareTo(other: Int) = 10
}

actual typealias A12 = A121

class A141<T1> : Iterable<T1> {
    override fun iterator() = TODO()
}

actual typealias A14<L> = A141<L>

interface A911 {
    fun iterator4(): Nothing = TODO()
}

class A151<T1> : Iterable<T1>, A911 {
    override fun iterator() = TODO()
}

actual typealias A15<L> = A151<L>

<!ACTUAL_TYPE_ALIAS_TO_CLASS_WITH_DECLARATION_SITE_VARIANCE!>actual typealias <!ACTUAL_WITHOUT_EXPECT("Actual typealias 'A16'", " The following declaration is incompatible because class kinds are different (class, interface, object, enum, annotation):     public final expect class A16<T> : Iterable<T> ")!>A16<!><T> = Iterable<T><!>

<!ABSTRACT_MEMBER_NOT_IMPLEMENTED("Class 'A171'", "public abstract operator fun iterator(): Iterator<T> defined in kotlin.collections.Iterable")!>class A171<!><T> : Iterable<T>
typealias A172<T> = A171<T>
<!ACTUAL_TYPE_ALIAS_NOT_TO_CLASS!>actual typealias A17<T> = A172<T><!>

annotation class A181
actual typealias A18 = A181

annotation class A191 {
    annotation class A20(val x: Int) {
        sealed class A21<T> : Iterable<T>, Comparable<T> {
            val x: T = null <!UNCHECKED_CAST("Nothing?", "T")!>as T<!>
        }
    }
}

// unexpected behaviour
actual typealias <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS("A191", "      public final expect annotation class A20 : Annotation      The following declaration is incompatible because some expected members have no actual ones:         public final annotation class A20 : Annotation     No actual members are found for expected members listed below:          public constructor A20(x: Int)          The following declaration is incompatible because return type is different:             public constructor A20(x: Int) ")!>A19<!> = A191

<!EXPERIMENTAL_FEATURE_WARNING("The feature "inline classes" is experimental")!>inline<!> class A221<T>(val x: Int): Comparable<T> {
    override fun compareTo(other: T) = TODO()
}

actual typealias A22<T> = A221<T>

class A231<T>() {
    inner class A24<T>() {

    }
}

// unexpected behaviour
actual typealias <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS("A231", "      public final expect inner class A24<T>      The following declaration is incompatible because some expected members have no actual ones:         public final inner class A24<T>     No actual members are found for expected members listed below:          public constructor A24<T>()          The following declaration is incompatible because return type is different:             public constructor A24<T>() ")!>A23<!><T> = A231<T>
