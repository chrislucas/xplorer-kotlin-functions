package numbers.tests.theory

import numbers.theory.Exponential.modularDiv
import numbers.theory.Exponential.modularMul
import numbers.theory.Exponential.modularSub
import numbers.theory.Exponential.modularSum
import numbers.theory.Exponential.operation

private fun testOperation() {
    println(operation(1000, 25, 8, ::modularSum))
    println(operation(1000, 25, 8, ::modularSub))
    println(operation(1000, 25, 8, ::modularMul))
    println(operation(1000, 25, 8, ::modularDiv))
    val fn = { p: Double, q: Double, m: Double -> p * q / m }
    println(operation(10.0, 20.0, 30.0, fn))
}

fun main() {
    testOperation()
}