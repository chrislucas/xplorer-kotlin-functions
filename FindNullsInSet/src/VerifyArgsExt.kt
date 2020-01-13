object VerifyArgsExt {
    @JvmStatic
    inline fun <reified T : Any, reified R> verifyArgs(
        vararg args: T?, onAllArgsNonNulls: (Array<T>) -> Unit
        , onOneArgsIsNull: (args: Array<T?>) -> R
    ) {
        if (args.all { it != null }) {
            onAllArgsNonNulls(args.filterNotNull().toTypedArray())
        } else {
            onOneArgsIsNull(args.toList().toTypedArray())
        }
    }

    @JvmStatic
    inline fun <reified T : Any> simpleVerifyArgs(vararg args: T?, onAllArgsNonNulls: (Array<T>) -> Unit) {
        if (args.all { it != null }) {
            onAllArgsNonNulls(args.filterNotNull().toTypedArray())
        }
    }
}

inline fun <T, R : MutableCollection<Int>> Array<out T>.findIndexNull(
    destination: R,
    predicate: (value: T) -> Boolean
) {
    forEachIndexed { i, v ->
        if (predicate(v))
            destination.add(i)
    }
}
