package se.tp21

sealed class TestEvent : Event
data class StartEvent(val message: String = "StartEvent") : TestEvent()
data class SuccessEvent(val message: String = "SuccessEvent") : TestEvent()
data class ErrorEvent(val message: String = "ErrorEvent") : TestEvent()

class TestMonitor : Monitor<TestEvent> {
    val events = mutableListOf<TestEvent>()
    override fun notify(event: TestEvent) {
        events.add(event)
    }
}

class TestNotifier(
    override val monitor: Monitor<TestEvent>
) : Notifier<TestEvent>

