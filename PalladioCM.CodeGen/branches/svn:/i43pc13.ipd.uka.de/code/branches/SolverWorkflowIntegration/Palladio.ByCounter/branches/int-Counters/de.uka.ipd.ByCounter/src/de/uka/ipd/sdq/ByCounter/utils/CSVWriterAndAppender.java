package de.uka.ipd.sdq.ByCounter.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * For future use
 * @author Michael
 * 
 */
public class CSVWriterAndAppender {
	
	public static final int BOOLEAN_COLUMN_TYPE = 4;
	public static final int DOUBLE_COLUMN_TYPE = 0;
	public static final int FLOAT_COLUMN_TYPE = 1;
	public static final int INTEGER_COLUMN_TYPE = 3;
	public static final int LONG_COLUMN_TYPE = 2;
	public static final int STRING_COLUMN_TYPE = 5;
	
	public static void main(String[] args){
		CSVWriterAndAppender csvwap = new CSVWriterAndAppender();
		csvwap.runAll();
	}
	
	private int highstNumberColumnType;

	private Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	
	private long timestamp;

	public CSVWriterAndAppender() {
		super();
		PropertyConfigurator.configure("log4j.properties");
		timestamp = System.currentTimeMillis();
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
			boolean usePrevTimestamp,
			long prevTimestampToUse
			){
		
		if(usePrevTimestamp) timestamp = prevTimestampToUse;
		if(writeBooleansAsIntegers){
			highstNumberColumnType = 4;
		}else{
			highstNumberColumnType = 3;
		}
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
			log.info("Column titles: "+sb.toString());
			
			if(writeMasterFile){
				File masterFile = new File(masterFileNameWithPath);
				log.debug("Master file path: "+masterFile.getAbsolutePath());
				boolean masterFileExists = masterFile.exists();
				fwMaster = new FileWriter(masterFileNameWithPath, appendMasterFile);
				if(!masterFileExists){
					log.debug("Master file does not exist");
					fwMaster.append(sb.toString());
				}else{
					log.debug("Master file already exists");
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
					if(columnType>highstNumberColumnType){
						sb.append("\"");
					}
					if(      columnType==DOUBLE_COLUMN_TYPE){
						sb.append(((Double) columns.get(columnIndex).get(rowIndex)).doubleValue()+""+entriesSeparationChar);
					}else if(columnType==FLOAT_COLUMN_TYPE){
						sb.append(((Float) columns.get(columnIndex).get(rowIndex)).floatValue()+""+entriesSeparationChar);
					}else if(columnType==LONG_COLUMN_TYPE){
						sb.append(((Long) columns.get(columnIndex).get(rowIndex)).longValue()+""+entriesSeparationChar);
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
						sb.append(columns.get(columnIndex).get(rowIndex).toString());
					}
					if(columnType>highstNumberColumnType){
						sb.append("\""+entriesSeparationChar);
					}
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

	/**
	 * @param platfromDesc
	 * @param jvmConfDesc
	 * @param jitConfDesc
	 * @param digestAlgorithm
	 * @param nrOfMeasurements
	 * @param digestImmediately
	 * @param inputSize
	 * @param nrOfDifferentRandomInputs
	 * @param masterFilePath
	 * @param values
	 * @return
	 * @deprecated because very specific and superseeded by writeColumns
	 */
	public String writeToMasterAndPieceCSVFiles(
			List<String> platfromDesc,
			List<String> jvmConfDesc,
			List<String> jitConfDesc,
			List<String> digestAlgorithm,
			List<Integer> nrOfMeasurements,
			List<Boolean> digestImmediately,
			List<Integer> inputSize,
			List<Integer> nrOfDifferentRandomInputs,
			String masterFilePath,
			List<Long[]> values){
//	FileOutputStream fos = new FileOutputStream(masterFilePath);
	FileWriter fwMaster;
	FileWriter fwPiece;
	String retString = null;
	try {
		File masterFile = new File(masterFilePath);
		boolean masterFileExists = masterFile.exists();
		log.debug(masterFile.length());
		fwMaster = new FileWriter(masterFilePath, true);
		fwPiece = new FileWriter((System.currentTimeMillis()+".digestmeasurement.csv"), true);
		
		StringBuffer sb = new StringBuffer();
		sb.append("\"Platform description\"," +
				"\"JVM conf\"," +
				"\"JIT conf\"," +
				"\"digest algo\"," +
				"\"nr of measurements\"," +
				"\"immediate digesting?\"," +
				"\"input size\"," +
				"\"nr of diff. rd. inputs\"");
		for(int i=0; i<values.get(0).length; i++){
			sb.append(", \"value"+i+"\""); //TODO make column names parametrisable
		}
		sb.append("\n");
			
		if(!masterFileExists){
			log.debug("Master file does not exist");
			fwMaster.append(sb.toString());
		}else{
			log.debug("Master file already exists");
		}
		fwPiece.append(sb.toString());
		retString  = sb.toString();
		sb = new StringBuffer();
		for(int i=0; i<platfromDesc.size(); i++){
			sb.append(
					"\""+platfromDesc.get(i)+"\""+","+
					"\""+jvmConfDesc.get(i)+"\""+","+
					"\""+jitConfDesc.get(i)+"\""+","+
					"\""+digestAlgorithm.get(i)+"\""+","+
					nrOfMeasurements.get(i)+"\""+","+
					"\""+digestImmediately.get(i)+"\""+","+
					inputSize.get(i)+","+
					nrOfDifferentRandomInputs.get(i));
			Long[] valuesToWrite = values.get(i);
			for(int w = 0; w<valuesToWrite.length; w++){
				sb.append(","+valuesToWrite[w]);
			}
			sb.append("\n");
		}
		fwMaster.append(sb.toString());
		fwPiece.append(sb.toString());
		retString += sb.toString();
		fwMaster.close();
		fwPiece.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return retString;
}

}
