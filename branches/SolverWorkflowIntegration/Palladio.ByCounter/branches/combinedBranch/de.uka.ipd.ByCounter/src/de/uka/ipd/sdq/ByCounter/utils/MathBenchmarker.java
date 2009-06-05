package de.uka.ipd.sdq.ByCounter.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/** A special class to benchmark a few specific Java API methods.
 *  Does not belong semantically to ByCounter, but we need it for evaluation 
 *  on the basis of SPECjvm2008 benchmarks.
 * @author Michael Kuperberg
 * @version 0.1
 */
public class MathBenchmarker {
	public static void main(String[] args){
		MathBenchmarker mb = new MathBenchmarker();
		try{
			mb.run(5000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Logger log;
	
	public MathBenchmarker(){
		PropertyConfigurator.configure("log4j.properties");
		log = Logger.getLogger(this.getClass().getCanonicalName());
	}
	
	private synchronized Double benchmarkAbsDouble(int times) throws InterruptedException {
		Random rd = new Random();
		double[] quelle = new double[times];
		double[] ziel = new double[times];
		for(int i=0; i<times; i++){
			quelle[i] = rd.nextDouble(); 
			ziel[i] = rd.nextDouble(); 
		}
		Thread.sleep(500);
		long start = 0L;
		long stop = 0L;
		start = System.nanoTime();
		for(int i=0; i<times; i++){
			ziel[i] = Math.abs(quelle[i]);
			ziel[i]++;
		}
		stop = System.nanoTime();
		log.debug("Duration: "+(stop-start));
		return ((double)(stop-start))/((double)(times));
	}

	private synchronized Double benchmarkForLoop_double(int times) throws InterruptedException {
		Random rd = new Random();
		double[] ziel = new double[times];
		for(int i=0; i<times; i++){
			ziel[i] = rd.nextDouble(); 
		}
		Thread.sleep(500);
		long start = 0L;
		long stop = 0L;
		start = System.nanoTime();
		for(int i=0; i<times; i++){
			ziel[i]++;
		}
		stop = System.nanoTime();
		log.debug("Duration: "+(stop-start));
		return ((double)(stop-start))/((double)(times));
	}

	private synchronized Double benchmarkForLoop_int(int times) throws InterruptedException {
		Random rd = new Random();
		int[] ziel = new int[times];
		for(int i=0; i<times; i++){
			ziel[i] = rd.nextInt(); 
		}
		Thread.sleep(500);
		long start = 0L;
		long stop = 0L;
		start = System.nanoTime();
		for(int i=0; i<times; i++){
			ziel[i]++;
		}
		stop = System.nanoTime();
		log.debug("Duration: "+(stop-start));
		return ((double)(stop-start))/((double)(times));
	}

	private synchronized Double benchmarkMinInt(int times) throws InterruptedException {
		Random rd = new Random();
		int[] links = new int[times];
		int[] rechts = new int[times];
		int[] ziel = new int[times];
		for(int i=0; i<times; i++){
			links[i] = rd.nextInt(); 
			rechts[i] = rd.nextInt(); 
			ziel[i] = rd.nextInt(); 
		}
		Thread.sleep(500);
		long start = 0L;
		long stop = 0L;
		start = System.nanoTime();
		for(int i=0; i<times; i++){
			ziel[i] = Math.min(links[i], rechts[i]);
			ziel[i]++;
		}
		stop = System.nanoTime();
		log.debug("Duration: "+(stop-start));
		return ((double)(stop-start))/((double)(times));
	}
	
	private synchronized Map<String,Double> run(int times) throws InterruptedException {
		Map<String,Double> res = new HashMap<String,Double>();
		res.put("abs",this.benchmarkAbsDouble(times));
		Thread.sleep(2000);
		res.put("min",this.benchmarkMinInt(times));
		Thread.sleep(2000);
		res.put("loop_int",this.benchmarkForLoop_int(times));
		Thread.sleep(2000);
		res.put("loop_double",this.benchmarkForLoop_double(times));
		Thread.sleep(2000);
		StringBuffer sb = new StringBuffer();
		sb.append(	"with times = "+times+": "+
					"\n loop_int:         "+res.get("loop_int")+"" +
					"\n loop_double:      "+res.get("loop_double")+"" +
					"\n min with loop:    "+res.get("min")+"" +
					"\n abs with loop:    "+res.get("abs")+"\n" +
					"\n min without loop: "+(res.get("min")-res.get("loop_int"))+"" +
					"\n abs without loop: "+(res.get("abs")-res.get("loop_double"))+"");
		log.info(sb.toString());
		return res;
	}
}
