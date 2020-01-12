package numbers.tests.theory

import numbers.theory.Exponential.expBySquaring
import numbers.theory.format

private fun testExpBySquaring() {
    println(expBySquaring(5, 20).format("%.2f"))
}

fun main() {
    testExpBySquaring()
}