package spec.benchmarks.compress;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**          
 * This looks like a database... --> to be replaced by a real one!
 * TODO: add tests!
 * @author Michael Kuperberg
 *
 */
public class GlobalCompressMeasurementsBlackboardForSPEC {
	
	private static CSVWriterAndAppenderForSPEC csvw = new CSVWriterAndAppenderForSPEC();

	private static List<Long> data_entryDates = new ArrayList<Long>();

	private static List<String> data_inputFileNames = new ArrayList<String>();

	private static List<Integer> data_inputFileSizes = new ArrayList<Integer>();
	
	private static List<Long> data_measurements = new ArrayList<Long>();
	
	private static List<Integer> data_outputFileSizes = new ArrayList<Integer>();
	
	private static Long initialisationTime = System.currentTimeMillis();
	
	private static GlobalCompressMeasurementsBlackboardForSPEC singleton = new GlobalCompressMeasurementsBlackboardForSPEC();
	
	public static CSVWriterAndAppenderForSPEC getCsvw() {
		return csvw;
	}
	
//	private static final int TO_PRIMITIVE_INT = 0;//TODO add others
	
	public static List<Long> getData_entryDates() {
		return data_entryDates;
	}
	
	public static List<String> getData_inputFileNames() {
		return data_inputFileNames;
	}
		
	public static List<Integer> getData_inputFileSizes() {
		return data_inputFileSizes;
	}
	
	public static List<Long> getData_measurements() {
		return data_measurements;
	}
	
	public static List<Integer> getData_outputFileSizes() {
		return data_outputFileSizes;
	}

	public static Long getInitialisationTime() {
		return initialisationTime;
	}

	public static GlobalCompressMeasurementsBlackboardForSPEC getInstance(){
		return singleton;
	}

	public static void main(String[] args){
		/*GlobalCompressMeasurementsBlackboard instance = GlobalCompressMeasurementsBlackboard.getInstance();
		instance.*/
		putSPECmeasurement(System.nanoTime(), 100, 1000, "nix1", 5000);
		putSPECmeasurement(System.nanoTime(), 200, 2000, "nix2", 10000);
	}

	public synchronized static int putSPECmeasurement(
			Long date, 
			int measurement, 
			int inputFileSize, 
			String inputFileName,
			int outputFileSize 
		){
		return putSPECmeasurement(
				date, 
				new Long(measurement), 
				new Integer(inputFileSize), 
				inputFileName,
				new Integer(outputFileSize) 
			);
	}

	public synchronized static int putSPECmeasurement(
			Long date, 
			Long measurement, 
			Integer inputFileSize, 
			String inputFileName,
			Integer outputFileSize 
		){
		
		//TODO check parameters
		
		data_entryDates.add(date);
		data_measurements.add(measurement);
		data_inputFileSizes.add(inputFileSize);
		data_inputFileNames.add(inputFileName);
		data_outputFileSizes.add(outputFileSize);
		
		new File("MK_results").mkdir();
		String baseDir = "MK_results"+File.separator+initialisationTime.toString(); 
		new File(baseDir).mkdir();
		csvw.writeColumnsWithOneRow(
				5, 
				new String[]{"Recorded","Duration","InputFileSize","InputFileName","OutputFileSize"}, 
				new Integer[]{CSVWriterAndAppenderForSPEC.LONG_COLUMN_TYPE, 
						CSVWriterAndAppenderForSPEC.LONG_COLUMN_TYPE, 
						CSVWriterAndAppenderForSPEC.LONG_COLUMN_TYPE, 
						CSVWriterAndAppenderForSPEC.STRING_COLUMN_TYPE, 
						CSVWriterAndAppenderForSPEC.LONG_COLUMN_TYPE 
				},
				new Object[]{date, 
						measurement,
						new Long(inputFileSize.intValue()),
						inputFileName,
						new Long(outputFileSize.intValue())
				}, 
				false, 	//writeBooleansAsIntegers
				true, 	//writeMasterFile
				true, 	//appendMasterFile
				true, 	//writePieceFile
				false, 	//appendPieceFile
				';', 							//entriesSeparationChar
				baseDir+File.separator+"allMeasurements.MK.csv" , //masterFileNameWithPath
				baseDir , 						//pieceFilePath
				"measurement", 					//pieceFileNameCore
				"MK.csv", 						//pieceFileNameExtension
				true, 
				System.nanoTime());
		return data_entryDates.size();
	}

	private GlobalCompressMeasurementsBlackboardForSPEC(){	}

	public synchronized long getMeasurement(long date){
		long currKey = -1;
		int i=0;
		for(i=0; i<data_entryDates.size(); i++){
			currKey = data_entryDates.get(i);
			if(currKey==date){
				return data_entryDates.get(i);
			}
		}
		return -1;
	}
	
}
