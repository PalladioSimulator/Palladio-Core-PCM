package de.uka.ipd.sdq.ByCounter.SPECevaluation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.utils.ASMOpcodesMapper;
import de.uka.ipd.sdq.ByCounter.utils.CSVWriterAndAppender;
import de.uka.ipd.sdq.BySuite.ByPred.counting.results.OpcodeFrequencySorter;
import de.uka.ipd.sdq.BySuite.ByPred.counting.results.SortableFrequency;

public class SPECCompressResultsAggregator {
	
	private Logger log;

	public SPECCompressResultsAggregator(){
		log = Logger.getLogger(this.getClass().getCanonicalName());
	}
	
	public static void main(String[] args){
		SPECCompressResultsAggregator scra = new SPECCompressResultsAggregator();
		List<CountingResult> results = scra.readSerialisedCountingResults();
		scra.writeResultsAndRankings(results);
	}
	
	public List<CountingResult> readSerialisedCountingResults(){
		log.debug("\n"+"Entering readSerialisedCountingResults");
		
		List<CountingResult> deserialisedResults = new ArrayList<CountingResult>();
		File currDir = new File(".");
		File currSCResultFile;
		String[] currDirContents = currDir.list();
		for (int i = 0; i < currDirContents.length; i++) {
			if(currDirContents[i].endsWith(".SCResult")){
				currSCResultFile = new File(currDirContents[i]);
				if(currSCResultFile.isFile()){
					FileInputStream fis;
					ObjectInputStream ois;
					try {
						fis = new FileInputStream(currDirContents[i]);
						ois = new ObjectInputStream(fis);
						CountingResult result = (CountingResult) ois.readObject();
						System.out.println("Data parsed from serialised" +
								"CountingResult instance from file " +
								currDirContents[i]+": ID="+result.getID()+", "+
								"invocation start="+result.getMethodInvocationBeginning()+", "+
								"method reporting time="+result.getMethodReportingTime()+", "+
								"qualifying method name="+result.getQualifyingMethodName()+", " +
								"total counts="+result.getTotalOpcodeCount(true)+".");
						deserialisedResults.add(result);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return deserialisedResults;
	}
	
	public void writeResultsAndRankings(List<CountingResult> results){
		log.debug("\n"+"Entering writeResultsAndRankings");
		ASMOpcodesMapper asmom = ASMOpcodesMapper.getInstance();
		OpcodeFrequencySorter ofs = new OpcodeFrequencySorter();
		Iterator<CountingResult> iter = results.iterator();
		
		SortedSet<SortableFrequency> sortedFrequencies = null;
		Map<String, Map<Integer,Long>> detailedOpcodeCounts = new TreeMap<String, Map<Integer,Long>>();
		Map<String, Long> totalOpcodeCounts = new TreeMap<String, Long>();
		
		CountingResult currResult = null;
		
		//1. extract actual results from wrapper objects
		while(iter.hasNext()){
			currResult = iter.next();
			detailedOpcodeCounts.put(
					currResult.getID(), 
					currResult.getOpcodeCounts());
			totalOpcodeCounts.put(
					currResult.getID(), 
					currResult.getTotalOpcodeCount(true));
		}
		System.out.println(detailedOpcodeCounts.size()+" datasets, " +
				totalOpcodeCounts.size()+" totalCounts");

		
		try {
			sortedFrequencies = ofs.getMostFrequentOpcodes_Integer(
					OpcodeFrequencySorter.RELATIVE_LOCAL_FREQUENCY, 
					detailedOpcodeCounts, 
					totalOpcodeCounts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sortedFrequencies.size()+" sorted frequencies");
		
		Iterator<SortableFrequency> freqIter = sortedFrequencies.iterator();
		SortableFrequency currFreq = null;

		@SuppressWarnings("unused")
		SortedMap<Integer,Integer> rankingByInteger = new TreeMap<Integer, Integer>();
		@SuppressWarnings("unused")
		SortedMap<String,Integer> rankingByString = new TreeMap<String, Integer>();
		List<String> columnTitles = new ArrayList<String>();
		List<Integer> columnTypes = new ArrayList<Integer>();

		//		columnTitles.add("DataDesc");
//		columnTypes.add(CSVWriterAndAppender.STRING_COLUMN_TYPE);
		
		columnTitles.add("FileName");
		columnTypes.add(CSVWriterAndAppender.STRING_COLUMN_TYPE);
		List</*String*/Object> firstColumn = new ArrayList</*String*/Object>();//file name from ID
//		firstColumn.add("OverallRanking");

		columnTitles.add("InputSize");
		columnTypes.add(CSVWriterAndAppender.LONG_COLUMN_TYPE);
		List</*Long*/Object> secondColumn = new ArrayList</*Long*/Object>();   //input size
//		secondColumn.add(0); //meant for ranking
		
		columnTitles.add("OutputSize");
		columnTypes.add(CSVWriterAndAppender.LONG_COLUMN_TYPE);
		List</*Long*/Object> thirdColumn = new ArrayList</*Long*/Object>();    //output size
//		thirdColumn.add(0); //meant for rankign
		
		columnTitles.add("DataType");
		columnTypes.add(CSVWriterAndAppender.INTEGER_COLUMN_TYPE);
		List</*Integer*/Object> fourthColumn = new ArrayList</*Integer*/Object>(); //input type
//		fourthColumn.add(0);//meant for rankign
		
		columnTitles.add("TotalCount");
		columnTypes.add(CSVWriterAndAppender.LONG_COLUMN_TYPE);
		List</*Long*/Object> fifthColumn = new ArrayList</*Long*/Object>();    //totalCounts
//		fifthColumn.add(0);//meant for rankign
		
		List<List<Object>> columns = new ArrayList<List<Object>>(); //TODO
		List<List</*Long*/Object>> dataColumns = new ArrayList<List</*Long*/Object>>(); //TODO
		for(int i=0; i<sortedFrequencies.size(); i++){
			dataColumns.add(new ArrayList</*Long*/Object>());
//			dataColumns.get(i).add(rankingByString.get(sortedFrequencies.))
		}

		
//		SortableFrequency[] sortedFrequenciesArray;
//		sortedFrequenciesArray = (SortableFrequency[]) sortedFrequencies.toArray();
		for (int i = 0; i < sortedFrequencies.size()/*sortedFrequenciesArray.length*/; i++) {
			currFreq = freqIter.next();
			columnTypes.add(CSVWriterAndAppender.LONG_COLUMN_TYPE);
			columnTitles.add(currFreq/*sortedFrequenciesArray[i]*/.getID());
//			rankingByInteger.put(asmom.getOpcodeInteger(currFreq/*sortedFrequenciesArray[i]*/.getID()), i);
//			rankingByString.put(currFreq/*sortedFrequenciesArray[i]*/.getID(), i);
		}
		
		for(CountingResult r : results){
			firstColumn.add(r.getID());
			secondColumn.add(r.getInputCharacterisation());
			thirdColumn.add(r.getOutputCharacterisation());
			fourthColumn.add(r.getFileType());
			fifthColumn.add(r.getTotalOpcodeCount(true));
			Iterator<List</*Long*/Object>> iterDataColumns = dataColumns.iterator();
			for(SortableFrequency s: sortedFrequencies){
				iterDataColumns.next().add(r.getOpcodeCounts().get(asmom.getOpcodeInteger(s.getID())));
			}
		}
		columns.add(firstColumn);
		columns.add(secondColumn);
		columns.add(thirdColumn);
		columns.add(fourthColumn);
		columns.add(fifthColumn);
		for(List</*Long*/Object> dataColumn:dataColumns){
			columns.add(dataColumn);
		}

		CSVWriterAndAppender csvwaa = new CSVWriterAndAppender();
		csvwaa.writeColumns(
				5/*filename,inputsize,outputsize,datatype,totalcount*/+
					sortedFrequencies.size(),      //numberOfColumns, 
//				1/*title row*/+
//					1/*ranking*/+ //now implicit TODO document
					results.size(),//numberOfRows, //TODO check this 
				columnTitles, 
				columnTypes, 
				columns, 
				true, //writeBooleansAsIntegers, 
				true, //writeMasterFile, 
				false, //appendMasterFile, 
				false, //writePieceFile, 
				false, //appendPieceFile, 
				';', //entriesSeparationChar, 
				"allCountsSortedAndWeighted."+System.nanoTime()+".csv", //masterFileNameWithPath, 
				".", //pieceFilePath, 
				"pieceFile", //pieceFileNameCore, 
				".csv", //pieceFileNameExtension, 
				false, //usePrevTimestamp, 
				0L //prevTimestampToUse
		);
	}

}
