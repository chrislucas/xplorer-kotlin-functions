package numbers.theory


fun Double.format(format: String) : String = String.format(format, this)

object Exponential {

    @JvmStatic
    fun modularSum(a: Int, b: Int, m: Int) = ((a % m) + (b % m)) % m

    @JvmStatic
    fun modularSub(a: Int, b: Int, m: Int) = ((a % m) - (b % m)) % m

    @JvmStatic
    fun modularMul(a: Int, b: Int, m: Int) = ((a % m) * (b % m)) % m

    @JvmStatic
    fun modularDiv(a: Int, b: Int, m: Int) = ((a % m) / (b % m)) % m

    @JvmStatic
    inline fun <reified Arg, reified R> operation(
        a: Arg, b: Arg
        , m: Arg, fn: (Arg, Arg, Arg) -> R
    ) = fn(a, b, m)

    @JvmStatic
    fun expBySquaring(_b: Int, _e: Int): Double {
        var b = _b.toDouble()
        var e = _e
        return when (e) {
            0 -> 1.0
            1 -> b * 1.0
            else -> {
                if (e < 0) {
                    e = -e
                    b = 1 / b
                }
                squaring(b, e)
            }
        }
    }

    private fun squaring(_b: Double, _e: Int) : Double {
        var ans = 1.0
        var b = _b
        var e = _e
        while (e > 0) {
            if (e and 1 == 1)
                ans *= b
            b *= b
            e = e shr 1
        }
        return ans
    }
}
