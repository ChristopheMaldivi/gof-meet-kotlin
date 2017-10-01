package strategy.lambda

import Console

typealias Filter = (String) -> Boolean
typealias Formatter = (String) -> String

fun publishText(console: Console, message: String, filter: Filter, formatter: Formatter) {
  if (filter(message)) {
    console(formatter(message))
  }
}
