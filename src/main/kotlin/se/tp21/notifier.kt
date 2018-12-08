package se.tp21

interface Event

interface Monitor<Ev: Event> {
    fun notify(event: Ev)
}

interface ToEvent<T, Ev: Event> {
    fun T.event() : Ev
}

interface Notifier<Ev: Event> {
    val monitor: Monitor<Ev>

    fun <T> notify(t: T, with toEvent: ToEvent<T, Ev>) {
        monitor.notify(t.event())
    }
}



