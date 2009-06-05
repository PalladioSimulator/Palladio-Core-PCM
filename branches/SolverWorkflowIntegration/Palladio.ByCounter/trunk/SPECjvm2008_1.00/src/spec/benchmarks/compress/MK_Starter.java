package spec.benchmarks.compress;

import java.sql.Timestamp;
import java.util.ArrayList;

public class MK_Starter {
    public static void main(String[] args) throws Exception {
    	ArrayList<Integer> indexes = new ArrayList<Integer>();
    	//the following one-by-one-addition is intentional:
    	//thus, I can control which input files to skip 
    	
    	//warmup
    	for(int i=0; i<10; i++){
    		indexes.add(0);//warmup
    	}
    	
    	//actual measurements
    	for(int i=0; i<40; i++){
    		indexes.add(i);
    	}
    	
    	long start = System.currentTimeMillis();
    	for(int i=0; i<indexes.size(); i++){
    		Main.MK_main_mine(new String[]{}, indexes.get(i), true);
    	}
    	long end = System.currentTimeMillis();
    	
    	System.out.println((end-start)+" ms to treat all " +
    			indexes.size()+" scenarios (each performed "+
    			Compress.MK_nrOfMeasurements+" times): " +
    			"started at "+(new Timestamp(start)).toString()+", "+
    			"ended at "+(new Timestamp(end)).toString()+". ");
    }

}
