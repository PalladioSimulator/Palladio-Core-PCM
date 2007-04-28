public class Main {
    public static void main(String[] args) {
        java.util.ArrayList<Thread> threads = new java.util.ArrayList<Thread>();

        for (int i = 0; i < 1; i++) {
            threads.add(new Thread(new java.lang.Runnable() {
                    downloadfiles.impl.DownloadFiles us = new downloadfiles.impl.DownloadFiles();

                    public void run() {
                        while (true) {
                            us.run();

                            try {
                                Thread.sleep(0);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }));
        }

        for (java.util.Iterator<Thread> it = threads.iterator(); it.hasNext();)
            it.next().start();
    }
}
