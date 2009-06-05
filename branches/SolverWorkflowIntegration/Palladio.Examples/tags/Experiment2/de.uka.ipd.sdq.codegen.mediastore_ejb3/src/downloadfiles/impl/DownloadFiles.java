package downloadfiles.impl;

public class DownloadFiles implements java.lang.Runnable {
    protected mediastorerepository.IHTTP m_portIHTTP = null;
    private static final int ARTIST = 0;
	private static final int TITLE = 1;
	private static final int MOVIE = 2;

    public DownloadFiles() {
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

    public void scenarioRunner() {
        /*PROTECTED REGION ID(_gBOngaY5EdudtvdezBq5JQ) ENABLED START*/
    	int count = ((int)(Math.random()*5))+10;
    	
    	int[] ids = new int[count];
    	for (int i=0; i<count; i++){
    		ids[i] = (int)(Math.random()*4100)+1;
    	}
        System.out.println("Start run "+count);
        long start = System.nanoTime();
    	{
            //m_portIHTTP.downloadHTTP(ids);
            // m_portIHTTP.downloadHTTP(new int[]{1,2,3});
    		//m_portIHTTP.queryFileByField("truckstop", ARTIST);
    		m_portIHTTP.queryFileByField("anno_1701", MOVIE);
        }
    	long result = System.nanoTime()-start;
    	System.out.println("Result: "+result / Math.pow(10,9));
//    	for(int i=1; i<=4159; i++) {
//    		m_portIHTTP.downloadHTTP(new int[] {i});
//    		System.out.println(i);
//    	}
//    	System.exit(0);
    	/*PROTECTED REGION END*/
    }

    public void run() {
        scenarioRunner();
    }
}
