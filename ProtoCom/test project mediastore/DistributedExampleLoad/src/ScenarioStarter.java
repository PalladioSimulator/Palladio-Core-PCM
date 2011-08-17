import de.uka.ipd.sdq.prototype.framework.AbstractMain;

/**
 * 
 */




/**
 * @author Nikolas
 *
 */

public class ScenarioStarter {
	
	public static final String RESULT_OUTPUT_FOLDER = "results-protocom-distributed-example";
	public static final String EXPERIMENT_NAME = "distributed";
	public static final int NUMBER_OF_MEASUREMENTS = 100;
	public static final int NUMBER_OF_WARMUP_CYCLES = 0;
	
	// set or remaove theoption "C" or "S" to measure inner response times. 
	
	public static final int NUMBER_OF_USERS_IN_CLOSED_WL = 1;

	public static void start(){

			
					// m: number of measurements
					// u: number of warmup cycles
					// d: folder where to store results, relative to glassfish's domain/config
					// n: name of the experiment
					String[] args = {"-m"+NUMBER_OF_MEASUREMENTS,"-u"+NUMBER_OF_WARMUP_CYCLES,"-d"+RESULT_OUTPUT_FOLDER,"-n"+EXPERIMENT_NAME,
							"-C"};
					Main.main(args);

	}
	
	public static void stopPassiveMeasurement(){
		AbstractMain.stopMeasurements();
	}
	
	public static void warmupOnly(){
		String[] args = {"-u"+NUMBER_OF_WARMUP_CYCLES,"-d"+RESULT_OUTPUT_FOLDER,"-n"+EXPERIMENT_NAME,
				"-W"};
		Main.main(args);
	}
	
}
