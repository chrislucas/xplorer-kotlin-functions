package test

import VerifyArgsExt.simpleVerifyArgs
import VerifyArgsExt.verifyArgs
import findIndexNull

data class User(val id: Int, val name: String)

fun testVerifyArgsFun() {
    val execute = fun(args: Array<Any>) {
        val (a, b, c, user) = args
        println("Argumentos nao nulos $a, $b, $c, $user")
    }
    val user1: User? = null
    val user2 = User(1, "chrisluccas")
    verifyArgs(0, 1, null, user1, user2, onAllArgsNonNulls = execute) { args ->
        val indexesNull = mutableListOf<Int>()
        args.findIndexNull(indexesNull) { value: Any? ->
            value == null
        }
        println(indexesNull)
    }
}

fun testSimpleVerifyArgsFun() {
    val user1 = User(1, "chrisluccas")
    val user2 = User(2, "james")
    simpleVerifyArgs(user1, user2) { (user1, user2) ->
        println("$user1")
        println("$user2")
    }
}

fun main() {
    testSimpleVerifyArgsFun()
}