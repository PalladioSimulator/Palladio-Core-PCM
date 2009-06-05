package spec.benchmarks.compress;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * For future use
 *
 * @author Michael Kuperberg
 * @author Martin Krogmann
 * @since 1.0
 * @version 1.1
*/
public class CSVWriterAndAppenderForSPEC {
	
	public static final int BOOLEAN_COLUMN_TYPE = 0;
	public static final int DOUBLE_COLUMN_TYPE = 1;
	public static final int FLOAT_COLUMN_TYPE = 2;
	public static final int INTEGER_COLUMN_TYPE = 3;
	public static final int LONG_COLUMN_TYPE = 4;
	public static final int STRING_COLUMN_TYPE = 5;
	
	public static void main(String[] args){
		CSVWriterAndAppenderForSPEC csvwap = new CSVWriterAndAppenderForSPEC();
		csvwap.runAll();
	}
	
//	private int highstNumberColumnType;

	private Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	
	private long timestamp;

	public CSVWriterAndAppenderForSPEC() {
		super();
		PropertyConfigurator.configure("log4j.properties");
		timestamp = System.nanoTime();
	}
	 
	private void runAll() {
		int numberOfColumns = 3;
		int numberOfRows = 4;
		List<String> columnTitles = new ArrayList<String>();
		columnTitles.add("Column 1"); columnTitles.add("Column 2");columnTitles.add("Result");
		List<Integer> columnTypes = new ArrayList<Integer>();
		columnTypes.add(BOOLEAN_COLUMN_TYPE); columnTypes.add(BOOLEAN_COLUMN_TYPE);columnTypes.add(INTEGER_COLUMN_TYPE);
		List<List<Object>> columns = new ArrayList<List<Object>>();
		List<Object> column1 = new ArrayList<Object>();
		column1.add(new Boolean(true));
		column1.add(new Boolean(true));
		column1.add(new Boolean(false));
		column1.add(new Boolean(false));
		List<Object> column2 = new ArrayList<Object>();
		column2.add(new Boolean(true));
		column2.add(new Boolean(false));
		column2.add(new Boolean(true));
		column2.add(new Boolean(false));
		List<Object> column3 = new ArrayList<Object>();
		column3.add(new Integer(1));
		column3.add(new Integer(0));
		column3.add(new Integer(0));
		column3.add(new Integer(0));
		columns.add(column1);
		columns.add(column2);
		columns.add(column3);
		this.writeColumns(numberOfColumns, numberOfRows, columnTitles, columnTypes, columns, 
				true, 				//writeBooleansAsIntegers, 
				true, 				//writeMasterFile, 
				true, 				//appendMasterFile, 
				true, 				//writePieceFile, 
				false, 				//appendPieceFile, 
				';', 				//entriesSeparationChar
				"TestMaster.csv",	//masterFileNameWithPath, 
				".", 				//pieceFilePath, 
				"TestPiece", 		//pieceFileNameCore, 
				"csv", 				//pieceFileNameExtension
				false,
				-1
				);
//		this.writeColumns(numberOfColumns, numberOfRows, columnTitles, columnTypes, columns, 
//				false, //writeBooleansAsIntegers, 
//				true, //writeMasterFile, 
//				true, //appendMasterFile, 
//				true, //writePieceFile, 
//				false, //appendPieceFile, 
//				',', //entriesSeparationChar
//				"TestMaster.csv", //masterFileNameWithPath, 
//				".", //pieceFilePath, 
//				"TestPiece", //pieceFileNameCore, 
//				"csv" //pieceFileNameExtension
//				);
	}
	
	public long writeColumns(//TODO make a non-typed version for simpler creating of columns by callers
			int numberOfColumns,
			int numberOfRows,
			List<String> columnTitles,
			List<Integer> columnTypes,
			List<List<Object>> columns,
			boolean writeBooleansAsIntegers,
			boolean writeMasterFile,
			boolean appendMasterFile,
			boolean writePieceFile,
			boolean appendPieceFile,
			char entriesSeparationChar,
			String masterFileNameWithPath,
			String pieceFilePath,
			String pieceFileNameCore,
			String pieceFileNameExtension,
			boolean useOtherTimestampForPieceFile,
			long otherTimestampForPieceFile
			){
		
		if(useOtherTimestampForPieceFile){
			timestamp = otherTimestampForPieceFile;
		}
		
//		if(writeBooleansAsIntegers){
//			highstNumberColumnType = 4;
//		}else{
//			highstNumberColumnType = 3;
//		}
		
		if(columns==null || columns.size()==0){
			log.error("No data (i.e., nocolumns)");
			return -1;
		}
		
		if(numberOfColumns!=columns.size()
				|| numberOfColumns!=columnTitles.size()
				|| numberOfColumns!=columnTypes.size()
				){
			log.error("Wrong number of columns");
			return -1;
		}
		
		if(numberOfRows!=columns.get(0).size()){
			log.error("Wrong number of rows");
			return -1;
		}
		
		FileWriter fwMaster = null;
		FileWriter fwPiece  = null;
		try {
//			log.debug(masterFile.length());
			StringBuffer sb = new StringBuffer();
			for(String columnTitle:columnTitles){
				sb.append("\""+columnTitle+"\""+entriesSeparationChar);
			}
			sb.append("\n");
			log.debug("Column titles: "+sb.toString());
			
			if(writeMasterFile){
				File masterFile = new File(masterFileNameWithPath);
				log.debug("Master file path: "+masterFile.getAbsolutePath());
				boolean masterFileExists = masterFile.exists();
				fwMaster = new FileWriter(masterFileNameWithPath, appendMasterFile);
				if(!masterFileExists){
					log.debug("Master file did not exist");
					fwMaster.append(sb.toString());
				}else{
					log.debug("Master file already existed");
				}
				
			}
			
			if(writePieceFile){
				String piecePath = 
					"."+File.separator+pieceFilePath+File.separator+
					pieceFileNameCore+"."+this.timestamp+"."+
					pieceFileNameExtension;
				File pieceFile = new File(piecePath);
				log.debug("Piece file path: "+pieceFile.getAbsolutePath());
				boolean pieceFileExists = pieceFile.exists();
				fwPiece = new FileWriter(piecePath, appendPieceFile);
				if(!pieceFileExists){
					log.debug("Piece file did not exist (yet), creating header row");
					/*if(appendPieceFile) */
					fwPiece.append(sb.toString());
				}else{
					log.debug("Piece file already exists");
				}
			}

			//now writing the rows
			Boolean tempBool = false;
			sb = new StringBuffer();
//			Integer[] columnTypesArray = Arrays.fcolumnTypes
			for(int rowIndex=0; rowIndex<columns.get(0).size(); rowIndex++){
				for(int columnIndex=0; columnIndex<columns.size(); columnIndex++){
					int columnType = columnTypes.get(columnIndex);
//MK TODO					
//					if(columnType>highstNumberColumnType){
//						sb.append("\"");
//					}
					if(      columnType==DOUBLE_COLUMN_TYPE){
						sb.append(((Double) columns.get(columnIndex).get(rowIndex)).doubleValue()+""+entriesSeparationChar);
					}else if(columnType==FLOAT_COLUMN_TYPE){
						sb.append(((Float) columns.get(columnIndex).get(rowIndex)).floatValue()+""+entriesSeparationChar);
					}else if(columnType==LONG_COLUMN_TYPE){
						Object something = columns.get(columnIndex).get(rowIndex);
						long longSomething = 0L;
						if(something!=null){
							longSomething = ((Long) something).longValue();
						}else{
							System.err.println("TODO CSVWriterAndAppender cannot write null " +
									"(columnIndex="+columnIndex+
									", rowIndex="+rowIndex+")");
						}
						sb.append(longSomething+""+entriesSeparationChar);
					}else if(columnType==INTEGER_COLUMN_TYPE){
						sb.append(((Integer) columns.get(columnIndex).get(rowIndex)).intValue()+""+entriesSeparationChar);
					}else if(writeBooleansAsIntegers && columnType==BOOLEAN_COLUMN_TYPE){
						tempBool = (Boolean) columns.get(columnIndex).get(rowIndex);
						if(tempBool){
							sb.append("1"+entriesSeparationChar);
						}else{
							sb.append("0"+entriesSeparationChar);
						}
					}else{
						sb.append(columns.get(columnIndex).get(rowIndex).toString()+""+entriesSeparationChar);
					}
//MK TODO					
//					if(columnType>highstNumberColumnType){
//						sb.append("\""+entriesSeparationChar);
//					}
				}
				sb.append("\n");
//				sb.append(
//						"\""+platfromDesc.get(rowIndex)+"\""+","+
//						"\""+jvmConfDesc.get(rowIndex)+"\""+","+
//						"\""+jitConfDesc.get(rowIndex)+"\""+","+
//						"\""+digestAlgorithm.get(rowIndex)+"\""+","+
//						nrOfMeasurements.get(rowIndex)+"\""+","+
//						"\""+digestImmediately.get(rowIndex)+"\""+","+
//						inputSize.get(rowIndex)+","+
//						nrOfDifferentRandomInputs.get(rowIndex));
//				Long[] valuesToWrite = values.get(rowIndex);
//				for(int w = 0; w<valuesToWrite.length; w++){
//					sb.append(","+valuesToWrite[w]);
//				}
//				sb.append("\n");
			}
			if(fwMaster!=null && writeMasterFile) fwMaster.append(sb.toString());
			if(fwPiece!=null && writePieceFile) fwPiece.append(sb.toString());
			
			if(fwMaster!=null && writeMasterFile) fwMaster.close();
			if(fwPiece!=null && writePieceFile) fwPiece.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.timestamp;
	}
	
	public long writeColumns_fromArrays(//TODO make a non-typed version for simpler creating of columns by callers
			int numberOfColumns,
			int numberOfRows,
			String[] columnTitles,
			Integer[] columnTypes,
			List<Object>[] columns,
			boolean writeBooleansAsIntegers,
			boolean writeMasterFile,
			boolean appendMasterFile,
			boolean writePieceFile,
			boolean appendPieceFile,
			char entriesSeparationChar,
			String masterFileNameWithPath,
			String pieceFilePath,
			String pieceFileNameCore,
			String pieceFileNameExtension,
			boolean useOtherTimestampForPieceFile,
			long otherTimestampForPieceFile){
		return writeColumns(
				numberOfColumns, 
				numberOfRows, 
				Arrays.asList(columnTitles), 
				Arrays.asList(columnTypes), 
				Arrays.asList(columns), 
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
				useOtherTimestampForPieceFile, 
				otherTimestampForPieceFile); 
	}
	
	public long writeColumnsWithOneRow(//TODO make a non-typed version for simpler creating of columns by callers
			int numberOfColumns,
			//1 row, implicitly    //int numberOfRows,
			String[] columnTitles,
			Integer[] columnTypes,
			Object[] columnValues,
			boolean writeBooleansAsIntegers,
			boolean writeMasterFile,
			boolean appendMasterFile,
			boolean writePieceFile,
			boolean appendPieceFile,
			char entriesSeparationChar,
			String masterFileNameWithPath,
			String pieceFilePath,
			String pieceFileNameCore,
			String pieceFileNameExtension,
			boolean useOtherTimestampForPieceFile,
			long otherTimestampForPieceFile){
		ArrayList<List<Object>> columnsAsList = new ArrayList<List<Object>>();
		
		for(int i=0; i< numberOfColumns; i++){
			List<Object> column = new ArrayList<Object>();
			column.add(columnValues[i]);
			columnsAsList.add(column);
		}
		return writeColumns(
				numberOfColumns, 
				1, 
				Arrays.asList(columnTitles), 
				Arrays.asList(columnTypes), 
				columnsAsList,
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
				useOtherTimestampForPieceFile, 
				otherTimestampForPieceFile); 
	}
}
