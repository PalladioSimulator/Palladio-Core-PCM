package de.uka.ipd.sdq.ByCounter.utils;

/**
 * Barrier helper object for encapsulated synchronization.
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.9
 * @version 0.9
 *
 */
public class Barrier
{
	/**
	 * This blocks the current thread until {@link Barrier.release()} 
	 * is called.
	 * @throws InterruptedException
	 */
    public synchronized void block() throws InterruptedException
    {
        wait();
    }

	/**
	 * This unblocks the thread that was blocked with {@link Barrier.block()}.
	 * @throws InterruptedException
	 */
    public synchronized void release()
    {
        notify();
    }

	/**
	 * This unblocks all threads that were blocked with 
	 * {@link Barrier.block()}.
	 * @throws InterruptedException
	 */
    public synchronized void releaseAll()
    {
        notifyAll();
    }
 
}
