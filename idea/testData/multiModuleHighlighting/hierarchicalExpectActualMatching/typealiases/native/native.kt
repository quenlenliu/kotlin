package sample

actual typealias A1 = Nothing

class List1<K> : List<K> {
    override val size: Int get() = null!!
    override fun contains(element: K)= null!!
    override fun containsAll(elements: Collection<K>)= null!!
    override fun get(index: Int)= null!!
    override fun indexOf(element: K)= null!!
    override fun isEmpty()= null!!
    override fun iterator()= null!!
    override fun lastIndexOf(element: K)= null!!
    override fun listIterator()= null!!
    override fun listIterator(index: Int)= null!!
    override fun subList(fromIndex: Int, toIndex: Int) = null!!
}

actual typealias A2<K> = List1<K>

interface I2<K> : Iterable<K>

class A<T : Any?> : Iterable<T>, I2<T> {
    override fun iterator() = null!!
}

actual typealias A3<T> = A<T>

interface I3<K> : Iterable<K>

class A414<T> : I2<T> {
    override fun iterator() = null!!
}

actual typealias <!ACTUAL_WITHOUT_EXPECT("Actual typealias 'A31'", " The following declaration is incompatible because some supertypes are missing in the actual declaration:     public final expect class A31<T> : Iterable<T> ")!>A31<!><T> = A414<T>

class A4141<T> : Iterable<Int> {
    override fun iterator() = null!!
}

actual typealias <!ACTUAL_WITHOUT_EXPECT("Actual typealias 'A311'", " The following declaration is incompatible because some supertypes are missing in the actual declaration:     public final expect class A311<T> : Iterable<T> ")!>A311<!><T> = A4141<T>

expect enum class A410 {}
actual enum class A410 {}

actual typealias A4 = A410

enum class A4101 { TEST }

actual typealias A41 = A4101

enum class A4102 { TEST2 }

actual typealias <!ACTUAL_WITHOUT_EXPECT("Actual typealias 'A42'", " The following declaration is incompatible because some entries from expected enum are missing in the actual enum:     public final expect enum class A42 : Enum<A42> ")!>A42<!> = A4102

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
    override fun compareTo(other: T) = null!!
}

actual typealias A22<T> = A221<T>

class A231<T>() {
    inner class A24<T>() {

    }
}

// unexpected behaviour
actual typealias <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS("A231", "      public final expect inner class A24<T>      The following declaration is incompatible because some expected members have no actual ones:         public final inner class A24<T>     No actual members are found for expected members listed below:          public constructor A24<T>()          The following declaration is incompatible because return type is different:             public constructor A24<T>() ")!>A23<!><T> = A231<T>
