package de.uka.ipd.sdq.capra.simulator.resources_new;
import java.util.Deque;


public class ProcessQueue<T> {

	public void addLast(T process) {
		// TODO Auto-generated method stub
		
	}

	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addFirst(T process) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * @uml.property   name="processQueue"
	 * @uml.associationEnd   multiplicity="(0 -1)" aggregation="shared" inverse="abstractFCFSQueue:de.uka.ipd.sdq.capra.simulator.resources_new.ActiveProcess"
	 */
	private Deque<T> processQueue;

	/**
	 * Getter of the property <tt>processQueue</tt>
	 * @return  Returns the runningProcess.
	 * @uml.property  name="processQueue"
	 */
	public Deque<T> getProcessQueue() {
		return processQueue;
	}

	/**
	 * Setter of the property <tt>processQueue</tt>
	 * @param processQueue  The runningProcess to set.
	 * @uml.property  name="processQueue"
	 */
	public void setProcessQueue(Deque<T> processQueue) {
		this.processQueue = processQueue;
	}

		
		/**
		 */
		public int getNumberOfProcesses(){
			return 0;
		}
}
