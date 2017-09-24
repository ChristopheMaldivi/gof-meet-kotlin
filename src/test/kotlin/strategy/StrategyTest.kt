package strategy

import org.junit.Test
import kotlin.test.assertEquals
import Console

class StrategyTest {

    @Test
    fun publish_error_text() {
        // given
        val errorMessage = "ERROR - something bad happened"
        var consoleMessage = ""
        val console = object: Console {
            override fun display(message: String) {
                consoleMessage = message
            }
        }

        // when
        strategy.publishText(console, errorMessage, ::errorFilter, ::errorFormatter)

        // then
        assertEquals("ERROR - SOMETHING BAD HAPPENED", consoleMessage)
    }

    @Test
    fun publish_short_text() {
        // given
        val shortMessage = "DEBUG - I'am here"
        var consoleMessage = ""
        val console = object: Console {
            override fun display(message: String) {
                consoleMessage = message
            }
        }

        // when
        strategy.publishText(console, shortMessage, ::shortTextFilter, ::shortTextFormatter)

        // then
        assertEquals("debug - i'am here", consoleMessage)
    }
}