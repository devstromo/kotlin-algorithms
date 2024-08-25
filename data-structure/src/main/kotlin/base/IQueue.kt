package base

interface IQueue<T> {

    /**
     * Add a value to the beginning of the queue.
     *
     * @param value to add to queue.
     * @return True if added to queue.
     */
    fun offer(value: T): Boolean

    /**
     * Remove a value from the tail of the queue.
     *
     * @return value from the tail of the queue.
     */
    fun poll(): T?

    /**
     * Get but do not remove tail of the queue.
     *
     * @return value from the tail of the queue.
     */
    fun peek(): T?

    /**
     * Remove the value from the queue.
     *
     * @param value to remove from the queue.
     * @return True if the value was removed from the queue.
     */
    fun remove(value: T): Boolean

    /**
     * Clear the entire queue.
     */
    fun clear()

    /**
     * Does the queue contain the value.
     *
     * @param value to find in the queue.
     * @return True if the queue contains the value.
     */
    fun contains(value: T): Boolean

    /**
     * Get the size of the queue.
     *
     * @return size of the queue.
     */
    fun size(): Int

    /**
     * Validate the queue according to the invariants.
     *
     * @return True if the queue is valid.
     */
    fun validate(): Boolean
}
