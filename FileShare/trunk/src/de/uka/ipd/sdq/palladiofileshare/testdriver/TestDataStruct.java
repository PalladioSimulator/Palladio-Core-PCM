package de.uka.ipd.sdq.palladiofileshare.testdriver;

public class TestDataStruct implements Comparable<TestDataStruct> {
	
	private String[] inputFileIds;
	private byte[][] inputFiles;
	private int[] inputFileTypes;
	private long uploadId;
	
//	/**
//	 * @deprecated because parametrised constructor should be used instead
//	 */
//	public TestDataStruct() {
//		try {
//			Thread.sleep(50);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		this.uploadId = System.currentTimeMillis()-1200000000000L;
//		this.inputFiles = new byte[0][];
//		this.inputFileIds = new String[0];
//		this.inputFileTypes = new int[0];
//	}
	
	public TestDataStruct(
			String[] inputFileIds,
			byte[][] inputFiles,
			int[] inputFileTypes) {
		if(!(inputFileIds!=null
				&& inputFiles!=null
				&& inputFileTypes!=null
				&& inputFileIds.length==inputFiles.length
				&& inputFileIds.length==inputFileTypes.length)){
			System.out.println("Parameters for TestDataStruct are (partially) " +
					"null or have different size, not creating the instance!");
			this.uploadId = Long.MIN_VALUE;
			this.inputFileIds = null;
			this.inputFiles = null;
			this.inputFileTypes = null;
			return;
		}
		try {
			Thread.sleep(50); //make sure test data struct ids are not identical
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.uploadId = System.currentTimeMillis()-1200000000000L;
		this.inputFiles = inputFiles;
		this.inputFileIds = inputFileIds;
		this.inputFileTypes = inputFileTypes;
	}
	
	public int compareTo(TestDataStruct o) {
		if(this.uploadId<o.uploadId){
			return -1;
		}else if(this.uploadId>o.uploadId){
			return 1;
		}else{
			return 0;
		}
	}
	
	public String[] getInputFileIds() {
		return inputFileIds;
	}
	
	public byte[][] getInputFiles() {
		return inputFiles;
	}
	
	public int[] getInputFileTypes() {
		return inputFileTypes;
	}
	
	public long getUploadId() {
		return uploadId;
	}
	
	public void setInputFileIds(String[] inputFileIds) {
		if(inputFileIds==null 
				|| !(
						inputFileIds.length==this.inputFiles.length
						&& inputFileIds.length==this.inputFileTypes.length
					)
			){
			System.out.println("inputFileIds parameters for TestDataStruct " +
					"are null or have different size " +
					"than other existing parameters" +
			"size --> parameter is not accepted!");
			return;
		}
		this.inputFileIds = inputFileIds;
	}

	public void setInputFiles(byte[][] inputFiles) {
		if(inputFiles==null 
				|| !(
						inputFiles.length==this.inputFileIds.length
						&& inputFiles.length==this.inputFileTypes.length
					)
			){
			System.out.println("inputFiles parameters for TestDataStruct " +
					"are null or have different size " +
					"than other existing parameters" +
					"size --> parameter is not accepted!");
			return;
		}
		this.inputFiles = inputFiles;
	}	

	public void setInputFileTypes(int[] inputFileTypes) {
		if(inputFileTypes==null 
				|| !(
						inputFileTypes.length==this.inputFiles.length
						&& inputFileTypes.length==this.inputFileIds.length
					)
			){
			System.out.println("inputFileTypes parameters for TestDataStruct " +
					"are null or have different size " +
					"than other existing parameters" + "size " +
					"--> parameter is not accepted!");
			return;
		}
		this.inputFileTypes = inputFileTypes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		if(!(inputFileIds!=null
				&& inputFiles!=null
				&& inputFileTypes!=null
				&& this.inputFileIds.length==this.inputFiles.length
				&& this.inputFileIds.length==this.inputFileTypes.length)){
			System.out.println("Corrupt instance of TestDataStruct!");
			return null;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("TestDataStruct with upload id "+this.uploadId+" and " +
				this.inputFileIds.length+" elements: [");
		for(int i=0; i<this.inputFiles.length; i++){
			sb.append(inputFileIds[i]+"("+inputFiles[i].length+","+
					inputFileTypes[i]+"),");
		}
		sb.append("]");
		return sb.toString();
		
	}	
}
