/**
 * Alguns links com discussoes sobre nao poder usar default parameter
 * em lambda expression
 * https://stackoverflow.com/questions/58277468/default-parameters-in-lambda-expression-in-kotlin
 *
 * */

var fn1 = { p: Int, q: Int, fn: (Int, Int) -> Int -> fn(p, q) }

val fn2: (Int, Int, (Int, Int) -> Int) -> Int = { p, q, fn -> fn(p, q) }

val fn3: (_p: Int, _q: Int, _fn: (Int, Int) -> Int) -> Int = { p, q, fn -> fn(p, q) }

// funcoes anonimas tbm nao podem ter parametros default
fun fn4(p: Int, q: Int, fn: (Int, Int) -> Double = ::expBySquare) = fn(p, q)

/**
 * Funcao abaixo foi escrita baseada no link
 * http://eli.thegreenplace.net/2009/03/28/efficient-modular-exponentiation-algorithms
 * */
fun expBySquare(_b: Int, _e: Int): Double {
    var b = _b.toDouble()
    var e = _e
    return when (e) {
        0 -> {
            1.0
        }
        1 -> {
            b * 1.0
        }
        else -> {
            var ans = 1.0
            if (e < 0) {
                e = -e
                b = 1 / b
            }
            while (e > 0) {
                if (e and 1 == 1)
                    ans *= b
                b *= b
                e = e shr 1
            }
            ans
        }
    }
}