class DownloadFilesThread extends Thread implements IStopable {
    de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor tss = null;
    downloadfiles.impl.DownloadFiles us = null;
    boolean shouldContinue = true;

    public DownloadFilesThread(
        de.uka.ipd.sdq.sensorfactory.entities.Experiment exp) {
        tss = exp.addTimeSpanSensor("Scenario overall DownloadFiles");
        us = new downloadfiles.impl.DownloadFiles();
    }

    public void requestStop() {
        shouldContinue = false;
    }

    public void run() {
        while (shouldContinue) {
            long start = System.nanoTime();
            us.run();
            tss.addTimeSpan(System.nanoTime(),
                (System.nanoTime() - start) / Math.pow(10, 9));

            try {
                // TODO: Wait for think time of the model instance
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}


interface IStopable {
    void requestStop();
}


public class Main {
    public static de.uka.ipd.sdq.sensorfactory.entities.Experiment exp = null;

    public static void main(String[] args) {
        exp = de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO.singleton()
                                                                      .createExperiment("test");

        java.util.ArrayList<Thread> threads = new java.util.ArrayList<Thread>();

        for (int i = 0; i < 1; i++) {
            threads.add(new DownloadFilesThread(exp));
        }

        System.out.println(
            "Starting workload threads. Request a measurement stop by pressing any key!");

        for (java.util.Iterator<Thread> it = threads.iterator(); it.hasNext();) {
            it.next().start();
        }

        try {
            System.in.read();
        } catch (java.io.IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.println("Request Thread stop");

        for (java.util.Iterator<Thread> it = threads.iterator(); it.hasNext();) {
            ((IStopable) it.next()).requestStop();
        }

        for (java.util.Iterator<Thread> it = threads.iterator(); it.hasNext();) {
            try {
                it.next().join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO.singleton()
                                                                .storeExperiment(exp);
    }
}
