package de.uka.ipd.sdq.scheduler.resources.active;

public class HDDParameterConfig {
	
	private double writeDataTransferRate = 0.0;
	private double readDataTransferRate = 0.0;
	
	private double writeRequestSwitchOverhead = 0.0;
	private double readRequestSwitchOverhead = 0.0;
	
	private double writeTimeSliceLength = 0.0;
	private double readTimeSliceLength = 0.0;
	
	private boolean anticipatorySchedulingWrite = false;
	private boolean anticipatorySchedulingRead = false;

	private int blockSize = 0;
	
	public double getWriteDataTransferRate() {
		return writeDataTransferRate;
	}
	public void setWriteDataTransferRate(double writeDataTransferRate) {
		this.writeDataTransferRate = writeDataTransferRate;
	}
	public double getReadDataTransferRate() {
		return readDataTransferRate;
	}
	public void setReadDataTransferRate(double readDataTransferRate) {
		this.readDataTransferRate = readDataTransferRate;
	}
	
	public double getWriteRequestSwitchOverhead() {
		return writeRequestSwitchOverhead;
	}
	public void setWriteRequestSwitchOverhead(double writeRequestSwitchOverhead) {
		this.writeRequestSwitchOverhead = writeRequestSwitchOverhead;
	}
	public double getReadRequestSwitchOverhead() {
		return readRequestSwitchOverhead;
	}
	public void setReadRequestSwitchOverhead(double readRequestSwitchOverhead) {
		this.readRequestSwitchOverhead = readRequestSwitchOverhead;
	}
	
	public double getWriteTimeSliceLength() {
		return writeTimeSliceLength;
	}
	public void setWriteTimeSliceLength(double writeTimeSliceLength) {
		this.writeTimeSliceLength = writeTimeSliceLength;
	}
	public double getReadTimeSliceLength() {
		return readTimeSliceLength;
	}
	public void setReadTimeSliceLength(double readTimeSliceLength) {
		this.readTimeSliceLength = readTimeSliceLength;
	}
	
	public int getBlocksize() {
		return blockSize;
	}
	public void setBlocksize(int blockSize) {
		this.blockSize = blockSize;
	}
	
	public void setAnticipatorySchedulingWrite(boolean anticipatorySchedulingWrite) {
		this.anticipatorySchedulingWrite = anticipatorySchedulingWrite;
	}
	public boolean getAnticipatorySchedulingWrite() {
		return anticipatorySchedulingWrite;
	}
	public void setAnticipatorySchedulingRead(boolean anticipatorySchedulingRead) {
		this.anticipatorySchedulingRead = anticipatorySchedulingRead;
	}
	public boolean getAnticipatorySchedulingRead() {
		return anticipatorySchedulingRead;
	}
	
	


}
