package observable

typealias Listener = () -> Unit

class Observable {

    private val listeners = mutableListOf<Listener>()

    fun register(listener: () -> Unit) {
        listeners.add(listener)
    }

    fun event() {
        listeners.forEach { listener -> listener() }
    }
}