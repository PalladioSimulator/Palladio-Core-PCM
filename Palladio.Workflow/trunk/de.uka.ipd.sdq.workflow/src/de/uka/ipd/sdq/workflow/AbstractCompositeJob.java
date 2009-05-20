package de.uka.ipd.sdq.workflow;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public abstract class AbstractCompositeJob implements ICompositeJob, List<IJob> {

	protected LinkedList<IJob> myJobs;
	protected Stack<IJob> myExecutedJobs;
	protected Logger logger = Logger.getLogger(OrderPreservingCompositeJob.class);
	String myName = null;

	public AbstractCompositeJob() {
		super();
		myJobs = new LinkedList<IJob>();
		myExecutedJobs = new Stack<IJob>();
	}
	
	public void addJob(IJob job) {
		if (job == null)
			throw new IllegalArgumentException("Job cannot be null");
		
		myJobs.add(job);
	}

	public abstract void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException;

	public String getName() {
		if (myName != null)
			return myName;
		
		String compositeName = "CompositeJob <";
		for(IJob job:myJobs) {
			compositeName += job.getName() + " ";
		}
		compositeName += ">";
		
		return compositeName;
	}
	
	public void setName(String name) {
		this.myName = name;
	}

	public void rollback(IProgressMonitor monitor) throws RollbackFailedException {
		monitor.subTask("Rollback of "+getName());
		while (!myExecutedJobs.empty()) {
			myExecutedJobs.pop().rollback(monitor);
			monitor.worked(1);
		}
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.LinkedList#add(java.lang.Object)
	 */
	public boolean add(IJob e) {
		return myJobs.add(e);
	}

	/**
	 * @param index
	 * @param element
	 * @see java.util.LinkedList#add(int, java.lang.Object)
	 */
	public void add(int index, IJob element) {
		myJobs.add(index, element);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.LinkedList#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends IJob> c) {
		return myJobs.addAll(c);
	}

	/**
	 * @param index
	 * @param c
	 * @return
	 * @see java.util.LinkedList#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends IJob> c) {
		return myJobs.addAll(index, c);
	}

	/**
	 * @param e
	 * @see java.util.LinkedList#addFirst(java.lang.Object)
	 */
	public void addFirst(IJob e) {
		myJobs.addFirst(e);
	}

	/**
	 * @param e
	 * @see java.util.LinkedList#addLast(java.lang.Object)
	 */
	public void addLast(IJob e) {
		myJobs.addLast(e);
	}

	/**
	 * 
	 * @see java.util.LinkedList#clear()
	 */
	public void clear() {
		myJobs.clear();
	}

	/**
	 * @return
	 * @see java.util.LinkedList#clone()
	 */
	public Object clone() {
		return myJobs.clone();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.LinkedList#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return myJobs.contains(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.AbstractCollection#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		return myJobs.containsAll(c);
	}

	/**
	 * @return
	 * @see java.util.LinkedList#descendingIterator()
	 */
	public Iterator<IJob> descendingIterator() {
		return myJobs.descendingIterator();
	}

	/**
	 * @return
	 * @see java.util.LinkedList#element()
	 */
	public IJob element() {
		return myJobs.element();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.AbstractList#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		return myJobs.equals(o);
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.LinkedList#get(int)
	 */
	public IJob get(int index) {
		return myJobs.get(index);
	}

	/**
	 * @return
	 * @see java.util.LinkedList#getFirst()
	 */
	public IJob getFirst() {
		return myJobs.getFirst();
	}

	/**
	 * @return
	 * @see java.util.LinkedList#getLast()
	 */
	public IJob getLast() {
		return myJobs.getLast();
	}

	/**
	 * @return
	 * @see java.util.AbstractList#hashCode()
	 */
	public int hashCode() {
		return myJobs.hashCode();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.LinkedList#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		return myJobs.indexOf(o);
	}

	/**
	 * @return
	 * @see java.util.AbstractCollection#isEmpty()
	 */
	public boolean isEmpty() {
		return myJobs.isEmpty();
	}

	/**
	 * @return
	 * @see java.util.AbstractSequentialList#iterator()
	 */
	public Iterator<IJob> iterator() {
		return myJobs.iterator();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.LinkedList#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return myJobs.lastIndexOf(o);
	}

	/**
	 * @return
	 * @see java.util.AbstractList#listIterator()
	 */
	public ListIterator<IJob> listIterator() {
		return myJobs.listIterator();
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.LinkedList#listIterator(int)
	 */
	public ListIterator<IJob> listIterator(int index) {
		return myJobs.listIterator(index);
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.LinkedList#offer(java.lang.Object)
	 */
	public boolean offer(IJob e) {
		return myJobs.offer(e);
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.LinkedList#offerFirst(java.lang.Object)
	 */
	public boolean offerFirst(IJob e) {
		return myJobs.offerFirst(e);
	}

	/**
	 * @param e
	 * @return
	 * @see java.util.LinkedList#offerLast(java.lang.Object)
	 */
	public boolean offerLast(IJob e) {
		return myJobs.offerLast(e);
	}

	/**
	 * @return
	 * @see java.util.LinkedList#peek()
	 */
	public IJob peek() {
		return myJobs.peek();
	}

	/**
	 * @return
	 * @see java.util.LinkedList#peekFirst()
	 */
	public IJob peekFirst() {
		return myJobs.peekFirst();
	}

	/**
	 * @return
	 * @see java.util.LinkedList#peekLast()
	 */
	public IJob peekLast() {
		return myJobs.peekLast();
	}

	/**
	 * @return
	 * @see java.util.LinkedList#poll()
	 */
	public IJob poll() {
		return myJobs.poll();
	}

	/**
	 * @return
	 * @see java.util.LinkedList#pollFirst()
	 */
	public IJob pollFirst() {
		return myJobs.pollFirst();
	}

	/**
	 * @return
	 * @see java.util.LinkedList#pollLast()
	 */
	public IJob pollLast() {
		return myJobs.pollLast();
	}

	/**
	 * @return
	 * @see java.util.LinkedList#pop()
	 */
	public IJob pop() {
		return myJobs.pop();
	}

	/**
	 * @param e
	 * @see java.util.LinkedList#push(java.lang.Object)
	 */
	public void push(IJob e) {
		myJobs.push(e);
	}

	/**
	 * @return
	 * @see java.util.LinkedList#remove()
	 */
	public IJob remove() {
		return myJobs.remove();
	}

	/**
	 * @param index
	 * @return
	 * @see java.util.LinkedList#remove(int)
	 */
	public IJob remove(int index) {
		return myJobs.remove(index);
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.LinkedList#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return myJobs.remove(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.AbstractCollection#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		return myJobs.removeAll(c);
	}

	/**
	 * @return
	 * @see java.util.LinkedList#removeFirst()
	 */
	public IJob removeFirst() {
		return myJobs.removeFirst();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.LinkedList#removeFirstOccurrence(java.lang.Object)
	 */
	public boolean removeFirstOccurrence(Object o) {
		return myJobs.removeFirstOccurrence(o);
	}

	/**
	 * @return
	 * @see java.util.LinkedList#removeLast()
	 */
	public IJob removeLast() {
		return myJobs.removeLast();
	}

	/**
	 * @param o
	 * @return
	 * @see java.util.LinkedList#removeLastOccurrence(java.lang.Object)
	 */
	public boolean removeLastOccurrence(Object o) {
		return myJobs.removeLastOccurrence(o);
	}

	/**
	 * @param c
	 * @return
	 * @see java.util.AbstractCollection#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return myJobs.retainAll(c);
	}

	/**
	 * @param index
	 * @param element
	 * @return
	 * @see java.util.LinkedList#set(int, java.lang.Object)
	 */
	public IJob set(int index, IJob element) {
		return myJobs.set(index, element);
	}

	/**
	 * @return
	 * @see java.util.LinkedList#size()
	 */
	public int size() {
		return myJobs.size();
	}

	/**
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 * @see java.util.AbstractList#subList(int, int)
	 */
	public List<IJob> subList(int fromIndex, int toIndex) {
		return myJobs.subList(fromIndex, toIndex);
	}

	/**
	 * @return
	 * @see java.util.LinkedList#toArray()
	 */
	public Object[] toArray() {
		return myJobs.toArray();
	}

	/**
	 * @param <T>
	 * @param a
	 * @return
	 * @see java.util.LinkedList#toArray(T[])
	 */
	public <T> T[] toArray(T[] a) {
		return myJobs.toArray(a);
	}

	/**
	 * @return
	 * @see java.util.AbstractCollection#toString()
	 */
	public String toString() {
		return myJobs.toString();
	}


}
