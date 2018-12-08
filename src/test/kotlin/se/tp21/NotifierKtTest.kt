package se.tp21

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class NotifierKtTest {

    class Foo

    extension class FooToEvent : ToEvent<Foo, TestEvent> {
        override fun Foo.event(): TestEvent = StartEvent()
    }

    private lateinit var monitor: TestMonitor
    private lateinit var notifier: Notifier<TestEvent>

    @Before
    fun setUp() {
        monitor = TestMonitor()
        notifier = TestNotifier(monitor)
    }

    @Test
    fun `notifier test`() {
        assertNoEvents()
        notifier.notify(Foo())
        assertTheseEvents(StartEvent())
    }

    private fun assertTheseEvents(vararg events: TestEvent) {
        assertThat(monitor.events.toList(), equalTo(events.toList()))
    }

    private fun assertNoEvents() {
        assertTheseEvents()
    }
}