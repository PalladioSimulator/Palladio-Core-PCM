package de.uka.ipd.sdq.palladiofileshare.businesslogic;

/**
 * @author Michael
 * The class NOT containing the main logic (see BusinessCore for it... WHY so much delegating?)
 */
public class BusinessRunner implements Runnable{

	private BusinessCore businessCore;
	private boolean measure;
	private boolean monitor;
	private String[] uploadFileIds;
	private byte[][] uploadFiles;
	private int[] uploadFileTypes;
	private long uploadId;
	
	/**
	 * Default constructor
	 */
	public BusinessRunner() {
		this.businessCore = new BusinessCore(-1L);
		this.measure = false;
		this.monitor = false;
		this.uploadFiles = null;
		this.uploadFileIds = null;
		this.uploadFileTypes = null;
	}
	
	/**
	 * Normal constructor
	 * @param uploadId
	 * @param uploadFiles
	 * @param uploadFileIds
	 * @param uploadFileTypes
	 * @param measure
	 * @param monitor
	 */
	public BusinessRunner(
			byte[][] uploadFiles,
			String[] uploadFileIds,
			int[] uploadFileTypes,
			boolean measure, 
			boolean monitor) {
		this.businessCore = new BusinessCore(uploadId);
		this.uploadFiles = uploadFiles;
		this.uploadFileIds = uploadFileIds;
		this.uploadFileTypes = uploadFileTypes;
		this.measure = measure;
		this.monitor = monitor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		uploadFiles(
				this.uploadFiles, 
				this.uploadFileIds, 
				this.uploadFileTypes, 
				this.measure, 
				this.monitor 
				);
	}

	/**
	 * delegate to BusinessCore
	 * @param inputStreams
	 * @param fileType
	 */
	public void uploadFiles(
			byte[][] uploadFiles, 
			String[] uploadFileIds,
			int[] uploadFileTypes,
			boolean measure,
			boolean monitor
			) {
		this.businessCore.uploadFiles(				
				uploadFiles, 
				uploadFileIds, 
				uploadFileTypes,
				measure,
				monitor
				);		
	}

}
