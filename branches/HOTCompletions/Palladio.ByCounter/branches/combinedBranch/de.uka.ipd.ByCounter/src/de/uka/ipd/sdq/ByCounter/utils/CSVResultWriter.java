package de.uka.ipd.sdq.ByCounter.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import de.uka.ipd.sdq.ByCounter.execution.CountingResult;

/**
 * Docs TODO . However, not that appending is a bad idea, since  
 * 
 * @author Michael Kuperberg
 * @author Martin Krogmann
 * @since 0.1
 * @version 0.9
 */
public class CSVResultWriter implements IResultWriter {

	private boolean appendGrandTotalAtTheEnd = false;


	private char entriesSeparationChar = ';';
	
	//	182 corresponds to INVOKEVIRTUAL
	//	183 corresponds to INVOKESPECIAL
	//	184 corresponds to INVOKESTATIC
	//	185 corresponds to INVOKEINTERFACE
	private boolean listInvokeOpcodes = true;
	
	private Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	private boolean performIntegrityCheckOnInvokeOpcodes = false;
	private String pieceFileNameCore = "CBSE";
	private String pieceFileNameExtension = "csv";
	private String pieceFilePath = ".";
	private boolean writeBooleansAsIntegers = true;
	private boolean writeOpcodesAsIntegers = false;
	private boolean truncatedUndefindedOpcodes = false;
	private boolean writeUnusedOpcodes = false;
	private boolean writeArrayDetailsToSeparateFile = false;//write array details to a separate file
	public CSVResultWriter() {
		super();
		PropertyConfigurator.configure("log4j.properties");
	}
	public CSVResultWriter(
			boolean appendGrandTotalAtTheEnd,
			char entriesSeparationChar, 
			boolean listInvokeOpcodes,
			boolean performIntegrityCheckOnInvokeOpcodes,
			String pieceFileNameCore, 
			String pieceFileNameExtension,
			String pieceFilePath, 
			boolean writeBooleansAsIntegers,
			boolean writeOpcodesAsIntegers,
			boolean writeUnusedOpcodes,
			boolean truncateUndefinedOpcodes,
			boolean writeArrayDetailsToSeparateFile) {
		this();
		this.appendGrandTotalAtTheEnd = appendGrandTotalAtTheEnd;
		this.entriesSeparationChar = entriesSeparationChar;
		this.listInvokeOpcodes = listInvokeOpcodes;
		this.performIntegrityCheckOnInvokeOpcodes = performIntegrityCheckOnInvokeOpcodes;
		this.pieceFileNameCore = pieceFileNameCore;
		this.pieceFileNameExtension = pieceFileNameExtension;
		this.pieceFilePath = pieceFilePath;
		this.writeBooleansAsIntegers = writeBooleansAsIntegers;
		this.writeOpcodesAsIntegers = writeOpcodesAsIntegers;
		this.writeUnusedOpcodes = writeUnusedOpcodes;
		this.truncatedUndefindedOpcodes = truncateUndefinedOpcodes;
		this.writeArrayDetailsToSeparateFile = writeArrayDetailsToSeparateFile;
	}
	

	@Override
	public void writeResult(CountingResult cr) {
		log.info("Logging/writing results...");
		
		long time = cr.getTime(); 
		String qualifyingMethodName = cr.getQualifyingMethodName(); 

		HashMap<Integer, Long> opcodeCounts 		= cr.getOpcodeCounts();
		HashMap<String, Long> methodCallCounts 	= cr.getMethodCallCounts();
		

		if(time<0) {
			log.error("Wrong time: "+time);//TODO which kind of time is this?
			return /*null*/;
		}
		if(qualifyingMethodName==null || qualifyingMethodName.equals("")) {
			log.error("Qualifying method name is null or empty, EXITING");
			return /*null*/;
		}
		if(opcodeCounts == null) {
			log.error("Opcode counts hashmap is null... EXITING");
			return /*null*/;
		}
		if(methodCallCounts == null) {
			log.error("Method counts hashmap is null... EXITING");
			return /*null*/;
		}
		
		//TODO add such checks for array stuff as well...
		
		ASMOpcodesMapper dop = ASMOpcodesMapper.getInstance();
		
		Long totalCountOfAllOpcodes = 0L; //you need longs for that...
		Long totalCountOfAllMethods = 0L; //you need longs for that...
		BigInteger totalCountOfAllOpcodesBig = BigInteger.valueOf(0L);
		BigInteger totalCountOfAllMethodsBig = BigInteger.valueOf(0L);
		
		String 		currentOpcodeString;	// opcode as string
		Long 	currentOpcodeCount = 0L;	// opcode count
		Long 	currentMethodCount = 0L;	// method count
		
		List<Integer> listOpcodes = new ArrayList<Integer>(opcodeCounts.keySet());
		if(listOpcodes.contains(new Integer(-1))){
			log.error("Strangely, list of opcode contains a key with value -1!");
		}
		int upperOpcodeBoundExcl = 256;
		if(truncatedUndefindedOpcodes){
			upperOpcodeBoundExcl = 200;
		}
		if(writeUnusedOpcodes){
			listOpcodes = new ArrayList<Integer>();//TODO find out why this creates errors.... dop.getAllOpcodesAsList();
			for(int i=0; i<upperOpcodeBoundExcl; i++){
				listOpcodes.add(i);
			}
		}
		int indexOfMinusOneOpcode = listOpcodes.indexOf(new Integer(-1));
		if(indexOfMinusOneOpcode>=0){
			listOpcodes.remove(indexOfMinusOneOpcode);
			log.debug("Strange \"-1\" opcode removed from position "+indexOfMinusOneOpcode);
		}
		if(listOpcodes.contains(new Integer(-1))){
			log.error("Strangely, list of opcode contains a key with value -1 " +
					"after all available but uncounted opcodes are included!");
		}
		if(!listInvokeOpcodes){
			List<Integer> invokelessListOfOpcodes = new ArrayList<Integer>();
			for(Integer opcode:listOpcodes){
				if(opcode.intValue()<182 || opcode.intValue()>185){
					invokelessListOfOpcodes.add(opcode);
				}
			}
			listOpcodes = invokelessListOfOpcodes;
		}
		if(listOpcodes.contains(new Integer(-1))){
			log.error("Strangely, list of opcode contains a key with value -1 " +
					"after invoke* opcodes are excluded!");
		}
		Integer numberOfValueColumns = listOpcodes.size()+methodCallCounts.size();
		Integer numberOfRows = 1; //here: implicitly TODO document
		List<String> columnTitles = new ArrayList<String>();
		List<Integer> columnTypes = new ArrayList<Integer>();
		List<List<Object>> columns = new ArrayList<List<Object>>();
		
		List<Object> characterisations		= cr.getCharacterisations();
		List<String> characterisationTitles	= cr.getCharacterisationTitles();
		List<Integer> characterisationTypes	= cr.getCharacterisationTypes();

		int nrOfCharacterisationColumns = 0;
		if(characterisations!=null 
				&& characterisationTitles!=null
				&& characterisationTypes!=null
				&&characterisations.size()==characterisationTitles.size()
				&&characterisations.size()==characterisationTypes.size()
				&&characterisations.size()!=0
				&&characterisationTitles.size()!=0
				&&characterisationTypes.size()!=0){
			nrOfCharacterisationColumns = characterisations.size();
			for(int i=0; i<characterisationTitles.size(); i++){
				columnTitles.add(characterisationTitles.get(i)); //replace through Iterator
				columnTypes.add(characterisationTypes.get(i));
				columns.add(new ArrayList<Object>());
			}
//			Integer currType = 0;
//			String currString = "";
//			int highstNumberColumnType;
//			if(writeBooleansAsIntegers){
//				highstNumberColumnType = 4;
//			}else{
//				highstNumberColumnType = 3;
//			}
			for(int i=0; i<characterisations.size(); i++){
//				currType = characterisationTypes.get(i);
//				if(currType>highstNumberColumnType){
//					currString = "\""+characterisations.get(i);
					columns.get(i).add(characterisations.get(i));	
//				}else{
//					
//				}
//				
			}
		}
		int numberOfColumns = nrOfCharacterisationColumns+numberOfValueColumns;
		
		for (int i=0; i<numberOfValueColumns; i++){
			columnTypes.add(new Integer(CSVWriterAndAppender.LONG_COLUMN_TYPE));
		}
		for (int i=0; i<numberOfValueColumns; i++){
			columns.add(new ArrayList<Object>());
		}

		log.info("\n================ CSVResultWriter ================");
		log.info("qualifyingMethodName: " + qualifyingMethodName);
		
		//TODO FIXME TESTME
		Collections.sort(listOpcodes);
		Integer currentOpcode = -1;
		Long currentOpcodeCountLongObject;
		for(int i=0; i<listOpcodes.size(); i++) {
			currentOpcode = listOpcodes.get(i);
			currentOpcodeString = dop.getOpcodeString(currentOpcode);
			if(writeOpcodesAsIntegers){
				columnTitles.add(""+currentOpcode);
			}else{
				columnTitles.add(currentOpcodeString);
			}
			currentOpcodeCountLongObject = opcodeCounts.get(currentOpcode);
			if(currentOpcodeCountLongObject!=null){
				currentOpcodeCount = currentOpcodeCountLongObject.longValue();
			}else{
				currentOpcodeCount = 0L;
			}
			columns.get(nrOfCharacterisationColumns+i).add(currentOpcodeCount);
			if((totalCountOfAllOpcodes+currentOpcodeCount)<totalCountOfAllOpcodes){
				log.error("OVERFLOW if adding opcode counts... " +
						"adding skipped... use BigInteger instead!");
			}else{
				totalCountOfAllOpcodes += currentOpcodeCount;
			}
			totalCountOfAllOpcodesBig = totalCountOfAllOpcodesBig.add(
					BigInteger.valueOf(currentOpcodeCount));
		}
		
		List<String> methodSigs = new ArrayList<String>(methodCallCounts.keySet());
		Collections.sort(methodSigs);
		String currentMethodSignature = "";
		int methodsOffset = nrOfCharacterisationColumns+listOpcodes.size();
		for(int i=0; i<methodSigs.size(); i++) {
			currentMethodSignature = methodSigs.get(i);
			columnTitles.add(currentMethodSignature);
			currentMethodCount = methodCallCounts.get(currentMethodSignature);
			columns.get(i+methodsOffset).add(currentMethodCount);
			if(totalCountOfAllMethods + currentMethodCount<totalCountOfAllMethods){
				log.error("OVERFLOW if adding method counts... " +
						"adding skipped... use BigInteger instead!");
			}else{
				totalCountOfAllMethods += currentMethodCount;
			}
			totalCountOfAllMethodsBig = totalCountOfAllMethodsBig.add(BigInteger.valueOf(currentMethodCount));
		}

		if(performIntegrityCheckOnInvokeOpcodes){
			Long counts182 = cr.getOpcodeCounts().get(new Integer(182));
			Long counts183 = cr.getOpcodeCounts().get(new Integer(183));
			Long counts184 = cr.getOpcodeCounts().get(new Integer(184));
			Long counts185 = cr.getOpcodeCounts().get(new Integer(185));
			Long totalInvokeOpcodesCounts = 0L;
			if(counts182!=null && counts182>=0){
				totalInvokeOpcodesCounts+=counts182;
			}
			if(counts183!=null && counts183>=0){
				totalInvokeOpcodesCounts+=counts183;
			}
			if(counts184!=null && counts184>=0){
				totalInvokeOpcodesCounts+=counts184;
			}
			if(counts185!=null && counts185>=0){
				totalInvokeOpcodesCounts+=counts185;
			}
			if(totalInvokeOpcodesCounts!=totalCountOfAllMethods){
				log.error("Integrity check on invoke* opcodes produced a " +
						"DIFFERENT total sum ("+totalInvokeOpcodesCounts+") " +
						"than the number of counted " +
						"method invocations ("+totalCountOfAllMethods+") !!!");
			}else{
				log.info("Integrity check on invoke* opcodes produced a " +
						"SAME total sum than the number of counted " +
						"method invocations, namely "+totalCountOfAllMethods+"!!!");
			}
		}
		long timestampFromArrayWriting = -1;
		if(writeArrayDetailsToSeparateFile){//TODO characterisation currently omitted
			boolean writeDown = true; //TODO if false, write "to the left"
			
			long[] newArrayCounts 	= cr.getNewArrayCounts();
			int[] newArrayDims 		= cr.getNewArrayDim();
			String[] newArrayTypes 	= cr.getNewArrayTypes();
			
			if(newArrayCounts != null 
				&& newArrayDims != null 
				&& newArrayTypes != null) {
				int numberOfColumns_arr = 3;
				int numberOfRows_arr = newArrayCounts.length;
				List<String> columnTitles_arr = new ArrayList<String>();
				columnTitles_arr.add("Type");//"\"Type\"");
				columnTitles_arr.add("Dimension");//"\"Dimension\"");
				columnTitles_arr.add("Counts");//"\"Counts\"");
				List<Integer> columnTypes_arr = new ArrayList<Integer>();
				columnTypes_arr.add(new Integer(CSVWriterAndAppender.STRING_COLUMN_TYPE));
				columnTypes_arr.add(new Integer(CSVWriterAndAppender.INTEGER_COLUMN_TYPE));
				columnTypes_arr.add(new Integer(CSVWriterAndAppender.LONG_COLUMN_TYPE));
				List<List<Object>> columns_arr = new ArrayList<List<Object>>();
				List<Object> typesColumn_arr = new ArrayList<Object>();
				List<Object> dimColumn_arr = new ArrayList<Object>();
				List<Object> countsColumn_arr = new ArrayList<Object>();
				columns_arr.add(typesColumn_arr);
				columns_arr.add(dimColumn_arr);
				columns_arr.add(countsColumn_arr);
				
				//TODO check if aggregated...
				for(int i = 0; i < newArrayCounts.length; i++) {
					typesColumn_arr.add(newArrayTypes[i]);
					dimColumn_arr.add(newArrayDims[i]);
					countsColumn_arr.add(newArrayCounts[i]);//hier auch potentiell Ueberlauf
//					log.info("SKIPPED new array of type '" + newArrayTypes[i] + "'" 
//							+ (newArrayDims[i] > 0 ? ", dim " + newArrayDims[i] : "")
//							+ ": " + newArrayCounts[i]);
				}
				CSVWriterAndAppender csvwap = new CSVWriterAndAppender();
				timestampFromArrayWriting = csvwap.writeColumns(
						numberOfColumns_arr, 
						numberOfRows_arr, 
						columnTitles_arr, 
						columnTypes_arr, 
						columns_arr, 
						true, 	//egal hier... writeBooleansAsIntegers, 
						false, 	//egal hier... writeMasterFile, 
						false, 	//egal hier... appendMasterFile,
						true, 	//writePieceFile, 
						true, 	//appendPieceFile, 
						';', 	//entriesSeparationChar, 
						"egal", //masterFileNameWithPath, 
						pieceFilePath, 
						pieceFileNameCore, 
						"arrays."+pieceFileNameExtension,
						false,
						-1);
				
			}else{
				log.error("One of the structures with new array information was null...");
			}

		}else{
			log.info("Not writing array initialisations at the moment!");
			log.error("Array initialisations are important for LZW, however!");
		}
		CSVWriterAndAppender csvwap = new CSVWriterAndAppender();
//		boolean writeBooleansAsIntegers = true;
		boolean writeMasterFile = false;
		boolean appendMasterFile = false;
		boolean writePieceFile = true;
		boolean appendPieceFile = false;
//		char entriesSeparationChar = ';';
		String masterFileNameWithPath = "";
//		String pieceFilePath = ".";
//		String pieceFileNameCore = "CBSE";
//		String pieceFileNameExtension = "csv";
		if(appendGrandTotalAtTheEnd){
			columnTitles.add("GRANDTOTAL");
			columnTypes.add(new Integer(CSVWriterAndAppender.LONG_COLUMN_TYPE));
			long grandTotal = totalCountOfAllOpcodes+totalCountOfAllMethods;
			BigInteger grandTotalBig =  totalCountOfAllOpcodesBig.add(totalCountOfAllMethodsBig);//TODO use 
			List<Object> grandTotalColumn = new ArrayList<Object>();
			grandTotalColumn.add(grandTotal);//TODO replace through grand total...!
			columns.add(grandTotalColumn);
		}

		boolean usePrevTimestamp = false;
		if(timestampFromArrayWriting>0){
			usePrevTimestamp = true;
		}
		csvwap.writeColumns(
				columnTitles.size(), 
				numberOfRows, 
				columnTitles, 
				columnTypes, 
				columns, 
				writeBooleansAsIntegers, 
				writeMasterFile, 
				appendMasterFile,
				writePieceFile, 
				appendPieceFile, 
				entriesSeparationChar, 
				masterFileNameWithPath, 
				pieceFilePath, 
				pieceFileNameCore, 
				pieceFileNameExtension,
				usePrevTimestamp,
				timestampFromArrayWriting //ignored if usePrevTimestamp=false
			);
		System.out.println("====================================================");
//		log.info(totalCountOfAllOpcodes + " opcodes of "+opcodeCounts.size() + " different types were counted.\n");
//		log.info(totalCountOfAllMethods + " methods of "+methodCallCounts.size() + " different types were counted.\n");
//		System.out.println("====================================================");
//		System.out.println("\n");
//		System.out.println("\n");
//		System.out.println("\n");
	
	}

}
