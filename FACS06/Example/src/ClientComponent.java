import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ClientComponent {

	private ServerComponent[] scArray;
	private long startTime = 0;
	private final static int numWorkers = 15;
	
	public ClientComponent(){
		scArray = new ServerComponent[numWorkers];
		for (int i=0; i<numWorkers; i++){
			scArray[i] = new ServerComponent();
		}
		
		this.startTime = System.nanoTime();
	}
	
	public void providedMethod1(ExecutorService tpes) {
        CallableWorkerThread workers[] = 
            new CallableWorkerThread[numWorkers];
        Future<Integer> futures[] = new Future[numWorkers];
        
        
        for (int i = 0; i < numWorkers; i++) {
            workers[i] = new CallableWorkerThread(i,scArray[i]);
            futures[i]=tpes.submit(workers[i]);
            //printTimestamp("after start "+i);
        }
        
        for (int i = 0; i < numWorkers; i++) {
            try {
            	futures[i].get();
/* 	        	System.out.format("Ending worker: %d%n",
                      futures[i].get());
               
*/	        } catch (Exception e) {}
        }
        
        printTimestamp("finishing all");

	}  
	
	protected void printTimestamp(String markingDescription){
		System.out.println("Elapsed after "
				+ markingDescription 
				+ ": " 
				+ ((System.nanoTime() - startTime)));
	}

}
