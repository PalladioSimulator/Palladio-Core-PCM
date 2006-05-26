package Example;

import java.util.concurrent.*;
public class CallableWorkerThread implements Callable<Integer> {
    private int workerNumber;
    private ServerComponent serverComponent;
    
    CallableWorkerThread(int number, ServerComponent serverComponent) {
        workerNumber = number;
        this.serverComponent = serverComponent;
    }

    public Integer call() {
    	long startTime = System.nanoTime();
    	
    	serverComponent.providedMethod1();

    	Monitoring.addThreadMeasurement(System.nanoTime()-startTime);
    	return(workerNumber);
    }
}