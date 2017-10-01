package observer

import org.junit.Test
import kotlin.test.assertTrue
import observable.Observable

/**
 * Define a one-to-many dependency between objects so that when one object changes
 * state, all its dependents are notified and updated automatically.
 */

class ObserverTest {

  @Test
  fun `listener lambda is called when event occurs`() {
    // given
    var called = false
    val observable = Observable()
    val listener = { called = true }
    observable.register(listener)

    // when
    observable.event()

    // then
    assertTrue(called)
  }
}