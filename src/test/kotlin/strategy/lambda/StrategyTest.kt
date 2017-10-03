package strategy.lambda

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Define a family of algorithms, encapsulate each one, and make them interchangeable.
 * Strategy lets the algorithm vary independently from clients that use it.
 */

class StrategyTest {

  var consoleMessage = ""
  val console = { message: String -> consoleMessage = message }

  @Test
  fun `an error filter returns true if text starts with ERROR`() {
    // given
    val errorMessage = "ERROR - something bad happened"

    // => FILL LAMBDA FUNCTION BELOW!
    val errorFilter = null

    // when
    val filtered = false // => UNCOMMENT! errorFilter(errorMessage)

    // then
    assertTrue { filtered }
  }

  @Test
  fun `an error formatter returns text in UPPER CASE`() {
    // given
    val errorMessage = "ERROR - something bad happened"

    // => FILL LAMBDA FUNCTION BELOW!
    val errorFormatter = null

    // when
    val formattedText = "" // errorFormatter(errorMessage)

    // then
    assertEquals(formattedText, "ERROR - SOMETHING BAD HAPPENED")
  }

  @Test
  fun `a text prefixed with ERROR is published with upper case format`() {
    // given
    val errorMessage = "ERROR - something bad happened"

    // => FILL LAMBDA FUNCTIONS BELOW!
    val errorFilter = null
    val errorFormatter = null

    // when
    // => UNCOMMENT! publishText(console, errorMessage, errorFilter, errorFormatter)

    // then
    assertEquals("ERROR - SOMETHING BAD HAPPENED", consoleMessage)
  }

  @Test
  fun `a text with length lesser than 21 chars is published in lower case`() {
    // given
    val shortMessage = "DEBUG - I'am here"

    // => FILL LAMBDA FUNCTIONS BELOW!
    val shortTextFilter = null
    val shortTextFormatter = null

    // when
    // => UNCOMMENT! publishText(console, shortMessage, shortTextFilter, shortTextFormatter)

    // then
    assertEquals("debug - i'am here", consoleMessage)
  }
}