package observer

import org.junit.Test
import kotlin.test.assertTrue
import observable.Observable

class ObserverTest {

    @Test
    fun observer_gets_notified_when_event_occurs() {
        // given
        var called = false
        val observable = Observable()
        observable.register({ called = true })
        // when
        observable.event()

        // then
        assertTrue(called)
    }
}