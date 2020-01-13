package fn.test

import Point2D
import cct
import concat


fun String.println() = println(this)

fun main() {
    val name = arrayOf("chris", "lucas", "f", "s")
    concat(name, "|").println()
    // using spread operator
    concat(Point2D(1, 1), Point2D(10,5), *name,  div = "|").println()
    // anonymous function
    cct(name, "|").println()

}