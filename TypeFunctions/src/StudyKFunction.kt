/**
 * Sample para estudar sobre varargs e pq nao conseguimos usa-las
 * em funcoes lambda em kotlin
 * */

// a declaracao abaixo nao funciona
// Unsupported [modifier on parameter in function type]
// val cct: (vararg args: Any, div: String) -> String = {  args, div -> args.reduce { acc, s -> "$acc$div$s" } }

// usando Array<T> como argumento de uma lambda expression
// (full syntactic form of lambda expressions: https://kotlinlang.org/docs/reference/lambdas.html#lambda-expression-syntax)
// para resolver a falta de suporte a vararg
val concat: (args: Array<out String>, div: String) -> String = { args, div -> args.reduce { acc, s -> "$acc$div$s" } }

fun concat(vararg args: Any, div: String) = args.reduce { acc, s -> "$acc$div$s" }.toString()

// numa funcao anonima eh possivel usar vararg, mas a IDE dispara um warning  USELESS_VARARG_ON_PARAMTER
// val cct = fun(vararg args: Any, div: String) = args.reduce { arg, s  -> "$arg$div$s" }.toString()

// anonymous function
val cct = fun(args: Array<out Any>, div: String) = args.reduce { arg, s  -> "$arg$div$s" }.toString()