package Example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import RegEx.util.Monitoring;

public class ClientComponent {

	private ServerComponent[] scArray;
	private int numWorkers = 0;
	
	public ClientComponent(int numberOfThreads){
		numWorkers = numberOfThreads;
		scArray = new ServerComponent[numWorkers];
		for (int i=0; i<numWorkers; i++){
			scArray[i] = new ServerComponent();
		}
	}
	
	public void providedMethod1(ExecutorService tpes) {
        CallableWorkerThread workers[] = 
            new CallableWorkerThread[numWorkers];
        Future<Integer> futures[] = new Future[numWorkers];
        
        // start threads
        for (int i = 0; i < numWorkers; i++) {
            workers[i] = new CallableWorkerThread(i,scArray[i]);
            futures[i]=tpes.submit(workers[i]);
        }
        
        // join
        for (int i = 0; i < numWorkers; i++) {
            try { 
            	futures[i].get();
 	        	//System.out.format("Ending worker: %d%n",futures[i].get());
	        } catch (Exception e) {
	        	System.out.println(e.getStackTrace());
	        }
        }
	}  
	
	public void providedMethod1() {
    	long startTime = System.nanoTime();
    	scArray[0].providedMethod1();
    	scArray[0].providedMethod1();
    	scArray[0].providedMethod1();
    	Monitoring.addThreadMeasurement(System.nanoTime()-startTime);
	} 
}
