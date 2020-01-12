package test

import expBySquare
import fn4

fun Double.format(format: String) = String.format(format, this)

fun testExpBySquare() {
    val p = ::expBySquare
    println(p)
    println(p(5, 7))
    println(p(5, -7).format("%.7f"))
    println(expBySquare(5, 27).format("%.7f"))
}

fun testFn4() {
    // curiosidade, se eu passar a referencia da funcao para uma variavel
    // vou ter que especificar
    val q = ::fn4
    println(q(5, -7, ::expBySquare).format("%.7f"))
    println(q(5, -7) { _p, _q -> (_p * _q).toDouble() }.format("%.7f") )
}

fun main() {
    testFn4()
}