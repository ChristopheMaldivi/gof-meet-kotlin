package strategy

import Console

const val SHORT_TEXT_MAX_LEN = 20

typealias Filter = (String) -> Boolean
typealias Formatter = (String) -> String

fun errorFilter(message: String): Boolean {
    return message.contains("ERROR")
}

fun errorFormatter(message: String): String {
    return message.toUpperCase()
}

fun shortTextFilter(message: String): Boolean {
    return message.length <= SHORT_TEXT_MAX_LEN
}

fun shortTextFormatter(message: String): String {
    return message.toLowerCase()
}

val console =
        object : Console {
            override fun display(message: String) {
                println(message)
            }
        }

// Does not work as in java, ?
val console2 = { message: String -> println(message) }

fun main(args: Array<String>) {
    publishText(console, "ERROR - something bad happened", ::errorFilter, ::errorFormatter)
    publishText(console, "DEBUG - I'm here", ::shortTextFilter, ::shortTextFormatter)
}

fun publishText(console: Console, message: String, filter: Filter, formater: Formatter) {
    if (filter(message)) {
        console.display(formater(message))
    }
}
