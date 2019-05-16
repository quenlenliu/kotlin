// !WITH_NEW_INFERENCE
class A<T> {
    fun T.foo() {}
    fun Out<T>.bar() {}
}
class Out<out E>

fun test(x: A<out CharSequence>, y: Out<CharSequence>) {
    with(x) {
        // TODO: this diagnostic could be replaced with TYPE_MISMATCH_DUE_TO_TYPE_PROJECTION
        "".<!NI;UNRESOLVED_REFERENCE, OI;UNRESOLVED_REFERENCE_WRONG_RECEIVER!>foo<!>()
        <!OI;TYPE_MISMATCH_DUE_TO_TYPE_PROJECTIONS!>y<!>.bar()

        with(y) {
            <!OI;TYPE_MISMATCH_DUE_TO_TYPE_PROJECTIONS!>bar<!>()
        }
    }
}
