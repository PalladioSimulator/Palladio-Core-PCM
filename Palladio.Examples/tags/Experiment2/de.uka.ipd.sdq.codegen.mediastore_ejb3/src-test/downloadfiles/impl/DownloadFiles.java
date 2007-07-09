package downloadfiles.impl;

public class DownloadFiles implements java.lang.Runnable {
    protected mediastorerepository.IHTTP m_portIHTTP = null;
    private de.uka.ipd.sdq.simucomframework.variables.StackContext ctx = new de.uka.ipd.sdq.simucomframework.variables.StackContext();

    public DownloadFiles() {
        ctx = new de.uka.ipd.sdq.simucomframework.variables.StackContext();

        javax.naming.InitialContext initial;

        try {
            initial = new javax.naming.InitialContext();

            javax.naming.Context context = (javax.naming.Context) initial.lookup(
                    "java:comp/env");

            m_portIHTTP = (mediastorerepository.IHTTP) javax.rmi.PortableRemoteObject.narrow(context.lookup(
                        "ejb/IHTTP"), mediastorerepository.IHTTP.class);
        } catch (javax.naming.NamingException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void scenarioRunner() {
        ctx.getStack().createAndPushNewStackFrame();

        /*PROTECTED REGION ID(_gBOngaY5EdudtvdezBq5JQ) ENABLED START*/

        // Start a resonse time measurement
        long startTimeDownloadFiles = System.nanoTime();
        // Start Simulate an external call
        {
            de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe currentFrame =
                ctx.getStack().currentStackFrame();

            // prepare stackframe
            de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe stackframe =
                ctx.getStack().createAndPushNewStackFrame();

            stackframe.addValue("desiredFiles.NUMBER_OF_ELEMENTS",
                ctx.evaluate(
                    "IntPMF(unit=\"files\")[ (1; 0.2) (2; 0.5) (3; 0.3) ]",
                    currentFrame));

            // Start a resonse time measurement
            long startTimeUsage_downloadHTTP = System.nanoTime();

            de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe callResult =
                m_portIHTTP.downloadHTTP(ctx);

            // Stop the resonse time measurement
            long endTimeUsage_downloadHTTP = System.nanoTime();
            long resultUsage_downloadHTTP = endTimeUsage_downloadHTTP -
                startTimeUsage_downloadHTTP;
            System.out.println("Usage_downloadHTTP: " +
                resultUsage_downloadHTTP);

            ctx.getStack().removeStackFrame();
        }

        // Stop the resonse time measurement
        long endTimeDownloadFiles = System.nanoTime();
        long resultDownloadFiles = endTimeDownloadFiles -
            startTimeDownloadFiles;
        System.out.println("DownloadFiles: " + resultDownloadFiles);

        /*PROTECTED REGION END*/
        ctx.getStack().removeStackFrame();
    }

    public void run() {
        scenarioRunner();
    }
}
