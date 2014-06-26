//package de.uka.ipd.sdq.experimentautomation.application.tooladapter;
//
//import de.uka.ipd.sdq.experimentautomation.application.ExperimentBookkeeping;
//import de.uka.ipd.sdq.simulation.ISimulationListener;
//
//public class SimulationDurationSimulationListener implements ISimulationListener {
//
//    private ExperimentBookkeeping bookkeeping;
//    private long startTime;
//
//    private String variationName;
//    private long variationValue;
//
//    public SimulationDurationSimulationListener(ExperimentBookkeeping bookkeeping, String variationName,
//            long variationValue) {
//        this.bookkeeping = bookkeeping;
//        this.variationName = variationName;
//        this.variationValue = variationValue;
//    }
//
//    @Override
//    public void simulationStart() {
//        System.gc();
//        startTime = System.nanoTime();
//    }
//
//    @Override
//    public void simulationStop() {
//        // collect the garbage
////        System.gc();
//        long stopTime = System.nanoTime();
//        long duration = stopTime - startTime;
//        bookkeeping.addResult(Long.toString(duration), Long.toString(variationValue), variationName);
//        // writeResultEntry(Long.toString(duration), Long.toString(variationValue), variationName);
//    }
//
//    // private void writeResultEntry(String... columnText) {
//    // try {
//    // String line = "";
//    // for (int i = 0; i < columnText.length; i++) {
//    // line += columnText[i];
//    // if (i + 1 < columnText.length) {
//    // line += ";";
//    // }
//    // }
//    // FileOutputStream out = new FileOutputStream(resultFile, true);
//    // PrintWriter writer = new PrintWriter(out);
//    // writer.println(line);
//    // writer.flush();
//    // writer.close();
//    // out.flush();
//    // out.close();
//    // } catch (IOException e) {
//    // throw new RuntimeException(e);
//    // }
//    // }
//
//}
