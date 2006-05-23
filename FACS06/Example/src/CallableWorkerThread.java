import java.util.concurrent.*;
public class CallableWorkerThread implements Callable<Integer> {
    private int workerNumber;
    private ServerComponent serverComponent;
    private long startTime;
    
    CallableWorkerThread(int number, ServerComponent serverComponent) {
        workerNumber = number;
        this.serverComponent = serverComponent;
    }

    public Integer call() {
    	this.startTime = System.nanoTime();
    	
    	serverComponent.providedMethod1();
    	
    	long elapsedTime = System.nanoTime()-startTime;
    	System.out.println("Thread "+workerNumber+": "+elapsedTime);
    	
    	return(workerNumber);
    }
}