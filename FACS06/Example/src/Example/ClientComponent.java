package Example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ClientComponent {

	private ServerComponent[] scArray;
	private final static int numWorkers = 3;
	
	public ClientComponent(){
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
}
