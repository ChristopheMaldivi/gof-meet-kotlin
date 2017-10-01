package strategy.lambda

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StrategyLambdaTest {

    var consoleMessage = ""
    val console = { message: String -> consoleMessage = message }

    @Test
    fun `an error filter returns true if text starts with ERROR`() {
        // given
        val errorMessage = "ERROR - something bad happened"
        val errorFilter = { text: String -> text.startsWith("ERROR") }

        // when
        val filtered = errorFilter(errorMessage)

        // then
        assertTrue { filtered }
    }

    @Test
    fun `an error formatter returns text in UPPER CASE`() {
        // given
        val errorMessage = "ERROR - something bad happened"
        val errorFormatter = { text: String -> text.toUpperCase() }

        // when
        val formattedText = errorFormatter(errorMessage)

        // then
        assertEquals(formattedText, "ERROR - SOMETHING BAD HAPPENED")
    }

    @Test
    fun `a text prefixed with ERROR is published with upper case format`() {
        // given
        val errorMessage = "ERROR - something bad happened"
        val errorFilter = { text: String -> text.startsWith("ERROR") }
        val errorFormatter = { text: String -> text.toUpperCase() }

        // when
        publishText(console, errorMessage, errorFilter, errorFormatter)

        // then
        assertEquals("ERROR - SOMETHING BAD HAPPENED", consoleMessage)
    }

    @Test
    fun `a text with length lesser than 21 chars is published in lower case`() {
        // given
        val shortMessage = "DEBUG - I'am here"
        val shortTextFilter = { text: String -> text.length < 21 }
        val shortTextFormatter = { text: String -> text.toLowerCase() }

        // when
        publishText(console, shortMessage, shortTextFilter, shortTextFormatter)

        // then
        assertEquals("debug - i'am here", consoleMessage)
    }
}