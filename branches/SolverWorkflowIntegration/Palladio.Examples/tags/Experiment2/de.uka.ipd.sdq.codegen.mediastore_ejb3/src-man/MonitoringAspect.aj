import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public aspect MonitoringAspect {
	public static final int COUNT = 10000;
	
	private static double[] mediastorerepository.impl.ports.IAudioDB_DBAdapter.test = new double[COUNT];
	private static int mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos = 0;

	private static double[] mediastorerepository.impl.ports.IAudioDB_DBAdapter.test2 = new double[COUNT];
	private static int mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos2 = 0;
	private static double[] mediastorerepository.impl.ports.IAudioDB_DBAdapter.filesize = new double[COUNT];

	private static double[] mediastorerepository.impl.ports.ISound_DigitalWatermarking.test = new double[COUNT];
	private static int mediastorerepository.impl.ports.ISound_DigitalWatermarking.pos = 0;
	
	private static double[] mediastorerepository.impl.ports.IHTTP_WebGUI.test = new double[COUNT];
	private static int mediastorerepository.impl.ports.IHTTP_WebGUI.pos = 0;

	private static long[] measures = new long[20];
	private static int stackpos = 0;
	
//	before() : execution(public * mediastorerepository.*.*(..)) {
//		measures[stackpos] = System.nanoTime();
//		System.out.println(space(stackpos) + "Executing " + thisJoinPointStaticPart.getSignature().getName());
//		stackpos++;
//	}
//
//	private String space(int len){
//		String result = "";
//		for (int i=0; i<len; i++) result += "  ";
//		return result;
//	}
//	
//	after() : execution(public * mediastorerepository.*.*(..)) {
//		long newValue = System.nanoTime();
//		stackpos--;
//		System.out.println(space(stackpos) + "Execution of " + thisJoinPointStaticPart.getSignature().getName()+" took "+(newValue-measures[stackpos])/1000000000.0);
//		newValue = System.nanoTime();
//		System.out.println(space(stackpos) + "Execution of " + thisJoinPointStaticPart.getSignature().getName()+" took "+(newValue-measures[stackpos])/1000000000.0);
//	}
	
	public pointcut monitoredOverallLike(Object s,Object i) : 
	execution(byte[][] mediastorerepository.impl.ports.IHTTP_WebGUI.queryFileByField(String,int)) && args(s,i);
	/** Advice that records statistics for each monitored operation. */
	byte[][] around(Object s,Object i) : monitoredOverallLike(s,i) {

		long start = System.nanoTime();
		byte[][] result = proceed(s,i);

		long end = System.nanoTime();
		mediastorerepository.impl.ports.IHTTP_WebGUI.test[mediastorerepository.impl.ports.IHTTP_WebGUI.pos] = (end-start)/Math.pow(10,9);
		mediastorerepository.impl.ports.IHTTP_WebGUI.pos++;
		storeArray("c:/temp/all_like.txt",mediastorerepository.impl.ports.IHTTP_WebGUI.test,mediastorerepository.impl.ports.IHTTP_WebGUI.pos);
		return result;
	}
	
//	public pointcut monitoredOverall(Object i) : 
//		execution(byte[][] mediastorerepository.impl.ports.IHTTP_WebGUI.downloadHTTP(int[])) && args(i);
//
//	/** Advice that records statistics for each monitored operation. */
//	byte[][] around(Object i) : monitoredOverall(i) {
//
//		long start = System.nanoTime();
//		byte[][] result = proceed(i);
//
//		long end = System.nanoTime();
//		mediastorerepository.impl.ports.IHTTP_WebGUI.test[mediastorerepository.impl.ports.IHTTP_WebGUI.pos] = (end-start)/Math.pow(10,9);
//		mediastorerepository.impl.ports.IHTTP_WebGUI.pos++;
//		storeArray("c:/temp/all.txt",mediastorerepository.impl.ports.IHTTP_WebGUI.test,mediastorerepository.impl.ports.IHTTP_WebGUI.pos);
//		return result;
//	}
//	

//	public pointcut monitoredQuery(Object s,Object i) : 
//	    execution(int[] mediastorerepository.impl.ports.IMySQL_AudioDB.getIDsOfMatchingFiles(String,int)) && args(s,i);
//
//	public pointcut monitoredQueryInternal(Object s,Object i) : 
//	    execution(List mediastorerepository.impl.AudioDB.queryDBInternal(String,int)) && args(s,i);
//
//	public pointcut monitoredGetFiles(Object i) : 
//	    execution(byte[][] mediastorerepository.impl.ports.IMySQL_AudioDB.getFiles(int[])) && args(i);
//	
//	public pointcut monitoredWatermark(Object operation) : 
//	    execution(byte[] mediastorerepository.impl.ports.ISound_DigitalWatermarking.watermark(byte[])) && args(operation);
//	
//
//	/** Advice that records statistics for each monitored operation. */
//	byte[] around(Object operation) : monitoredWatermark(operation) {
//		long start = System.nanoTime();
//		byte[] result = proceed(operation);
//
//		long end = System.nanoTime();
//		mediastorerepository.impl.ports.ISound_DigitalWatermarking.test[mediastorerepository.impl.ports.ISound_DigitalWatermarking.pos] = (end-start)/Math.pow(10,9);
//		mediastorerepository.impl.ports.ISound_DigitalWatermarking.pos++;
//		storeArray("c:/temp/watermark.txt",mediastorerepository.impl.ports.ISound_DigitalWatermarking.test,mediastorerepository.impl.ports.ISound_DigitalWatermarking.pos);
//		return result;
//	}
//
//	/** Advice that records statistics for each monitored operation. */
//	int[] around(Object s,Object i) : monitoredQuery(s,i) {
//
//		long start = System.nanoTime();
//		int[] result = proceed(s,i);
//
//		long end = System.nanoTime();
//		mediastorerepository.impl.ports.IAudioDB_DBAdapter.test[mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos] = (end-start)/Math.pow(10,9);
//		mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos++;
//		storeArray("c:/temp/query.txt",mediastorerepository.impl.ports.IAudioDB_DBAdapter.test,mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos);
//		return result;
//	}
//
//	/** Advice that records statistics for each monitored operation. */
//	List around(Object s,Object i) : monitoredQueryInternal(s,i) {
//
//		long start = System.nanoTime();
//		List result = proceed(s,i);
//
//		long end = System.nanoTime();
//		mediastorerepository.impl.ports.IAudioDB_DBAdapter.test[mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos] = (end-start)/Math.pow(10,9);
//		mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos++;
//		storeArray("c:/temp/query.txt",mediastorerepository.impl.ports.IAudioDB_DBAdapter.test,mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos);
//		return result;
//	}
//	
//	
//	/** Advice that records statistics for each monitored operation. */
//	byte[][] around(Object i) : monitoredGetFiles(i) {
//
//		long start = System.nanoTime();
//		byte[][] result = proceed(i);
//
//		long end = System.nanoTime();
//		mediastorerepository.impl.ports.IAudioDB_DBAdapter.test2[mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos2] = (end-start)/Math.pow(10,9);
//		mediastorerepository.impl.ports.IAudioDB_DBAdapter.filesize[mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos2] = result[0].length;
//		mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos2++;
//		store2Array("c:/temp/getfiles.csv",mediastorerepository.impl.ports.IAudioDB_DBAdapter.test2,mediastorerepository.impl.ports.IAudioDB_DBAdapter.filesize,mediastorerepository.impl.ports.IAudioDB_DBAdapter.pos2);
//		return result;
//	}
	
	private void storeArray(String filename, double[] a, int len){
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(filename));
			for (int i=0; i<len; i++){
				bw.write(a[i]+"\n");
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void store2Array(String filename, double[] a, double[] b, int len){
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(filename));
			for (int i=0; i<len; i++){
				bw.write(b[i]+";"+a[i]+"\n");
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
