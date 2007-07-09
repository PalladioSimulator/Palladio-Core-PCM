import java.lang.Runnable;

import java.util.ArrayList;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO;

import uscenario.impl.UScenario;

public class Main {
	public static Experiment exp = null;
    public static void main(String[] args) {
    	exp = ExperimentDAO.singleton().createExperiment("test");
    	final TimeSpanSensor tss = exp.addTimeSpanSensor("Scenario overall");
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 1; i++) {
            threads.add(new Thread(new Runnable() {
                    UScenario us = new UScenario();

                    public void run() {
                    	int i=0;
                        while (i<100) {
                        	long start = System.nanoTime();
                            us.run();
                            tss.addTimeSpan((System.nanoTime()-start)/Math.pow(10,9), System.nanoTime());
                            try {
                                // TODO: Wait for think time of the model instance
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            i++;
                        }
                    }
                }));
        }
        for (Iterator<Thread> it = threads.iterator(); it.hasNext();) {
            it.next().start();
        }
        for (Iterator<Thread> it = threads.iterator(); it.hasNext();) {
            try {
				it.next().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        ExperimentDAO.singleton().storeExperiment(exp);
    }
}
