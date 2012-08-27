package de.uka.ipd.sdq.edp2.local.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Logger;


/**
 * Takes care of storing and loading data arrays from and to a file on background storage.
 * 
 * @author Henning Groenda
 * @author Steffen Becker
 * 
 * @param <T> Data type of the elements stored in each chunk. T has to be persistable with constant memory footprint, e.g., 
 *            Double, Long, or Enum Ordinals
 */
class ChunkedFile<T> {
	
    /** Logger for this class. */
	private static final Logger logger = Logger.getLogger(ChunkedFile.class.getName());
	
	/** Link to the file on background storage containing all chunks. */
	private final RandomAccessFile raf;
	
	/** Starting position of the loaded chunk in the file in bytes. 
	 * May be after the end of the file in case the chunk is not saved yet. 
	 * Must be valid if {@link chunkLoaded} is <code>true</code>*/
	private long loadedChunkFilePos;
	
	/** Serializer to use for storing and loading data elements. */
	private final Serializer<T> serializer;
	
	/** Number of data elements stored in the file on background storage. */
	private long elementsInFile;
	
	/** Size of the chunks handled by this class. */
	private final int chunkSize;
	
	/** Data elements in the current chunk. */
	private T[] data = null;
	
	/** Total number of elements in the current loaded chunk. */
	private int elementsInLoadedChunk = 0;
	
	/** Status of the current chunk. <code>true</code> if any element has been changed and the changes are not saved yet. */
	private boolean changed;
	
	/** Determines if there is currently a valid chunk loaded. */
	private boolean chunkLoaded;

	/**
	 * Creates a new chunked file instance
	 * @param raf Link to the file on background storage to load/store the chunks.
	 * @param serializer The serializer to use for the data elements.
	 * @param chunkSize Size of each chunk.
	 * @throws IOException Thrown if an IO error occured.
	 */
	public ChunkedFile(RandomAccessFile raf, Serializer<T> serializer, int chunkSize) throws IOException {
	    super();
	    
		this.raf = raf;
		this.serializer = serializer;
		this.chunkSize = chunkSize;
		this.elementsInFile = raf.length() / serializer.getElementLength();
		this.chunkLoaded = false;
	}

	/**Adds a data element at the end of the background list.
	 * @param d data element to add.
	 */
	public void add(T d){
		if (d == null) {
			String msg = "Chunks do not support null values.";
			logger.severe(msg);
			throw new IllegalArgumentException(msg);
		}
		if (!chunkLoaded) {
			String msg = "Tried to add data element to chunk although there is no chunk loaded.";
			logger.severe(msg);
			throw new IllegalStateException(msg);
		}
		if (isFull()) {
			String msg = "Tried to add data element to chunk without any capacity left.";
			logger.warning(msg);
			throw new IllegalStateException(msg);
		}
		data[elementsInLoadedChunk++] = d;
		changed = true;
	}
	
	/** 
	 * Returns the index of the element with which the current chunk begins.
	 * The element does not have to exist if the chunk is empty.
	 * @return Index of the starting element.
	 */
	public long indexStartingElementForChunk() {
		return loadedChunkFilePos / serializer.getElementLength();
	}
	
	/**
	 * Returns the requested element from the chunk.
	 * @param indexInChunk Index of the element in the current chunk.
	 * @return The requested element.
	 */
	public T get(int indexInChunk) {
		if (!chunkLoaded) {
			String msg = "Tried to add data element to chunk although there is no chunk loaded.";
			logger.severe(msg);
			throw new IllegalStateException(msg);
		}
		return (T)data[indexInChunk];
	}

	/**
	 * Sets the requested element in the chunk.
	 * @param indexInChunk Index of the element in the current chunk.
	 * @param value The new element.
	 * @return The old element
	 */
	public T set(int indexInChunk, T value) {
		if (value == null) {
			String msg = "Chunks do not support null values.";
			logger.severe(msg);
			throw new IllegalArgumentException(msg);
		}
		if (!chunkLoaded) {
			String msg = "Tried to add data element to chunk although there is no chunk loaded.";
			logger.severe(msg);
			throw new IllegalStateException(msg);
		}
		T oldElement = data[indexInChunk];
		data[indexInChunk] = value;
		changed = true;
		return oldElement;
	}
	
	/**Checks if the current chunk is completely filled.
	 * @return <code>true</code> if completely filled.
	 */
	public boolean isFull() {
		return elementsInLoadedChunk >= chunkSize;
	}
	
	/**
	 * Load chunk which contains the requested element.
	 * @param elementIndex Index of the data element with respect to all elements in the file on background storage.
	 * @throws IOException Thrown if an IO error occurs.
	 */
	@SuppressWarnings("unchecked")
	public void loadChunkForElement(long elementIndex) throws IOException {
		if (chunkLoaded && changed) {
			String msg = "The currently loaded chunk has been changed but not saved to disc. Cannot load other chunk.";
			logger.severe(msg);
			throw new IllegalArgumentException(msg);
		}
		long requestedChunkNumber = (long) Math.floor(elementIndex / chunkSize);
		//determine starting position and number of read bytes
		long chunkSizeBytes = (long)(chunkSize * serializer.getElementLength());
		loadedChunkFilePos = chunkSizeBytes * requestedChunkNumber;
		long lastChunkNumber = (long)Math.floor((elementsInFile - 1) / chunkSize);
		int loadedChunkSizeBytes;
		if (requestedChunkNumber < lastChunkNumber) { 
			loadedChunkSizeBytes = (int) chunkSizeBytes;
		} else if (requestedChunkNumber == lastChunkNumber) {
			// last and potential partial chunk
			loadedChunkSizeBytes = (int) (elementsInFile * serializer.getElementLength() - lastChunkNumber * chunkSizeBytes); 
		} else {
			// new chunk. Created after the last chunk is complete.
			loadedChunkSizeBytes = 0;
		}
		if (loadedChunkFilePos > raf.length()) {
			String msg = "The requested element index is not stored in the file.";
			logger.severe(msg);
			throw new IllegalArgumentException(msg);
		}
		
		// read raw data
		byte[] rawData = new byte[loadedChunkSizeBytes];
		raf.seek(loadedChunkFilePos);
		raf.read(rawData);
		
		// deserialize and store in memory
		T[] newData = serializer.deserialise(rawData);
		if (newData.length == chunkSize) {
			data = newData;
		} else {
			data = (T[])(new Object[chunkSize]);
			java.lang.System.arraycopy(newData, 0, data, 0, newData.length);
		}
		elementsInLoadedChunk = newData.length;
		chunkLoaded = true;
		changed = false;
	}
	
	@SuppressWarnings("unchecked")
	public void createChunk() {
		if (chunkLoaded && changed) {
			String msg = "Cannot create chunk if the currently loaded chunk is changed and not saved yet.";
			logger.severe(msg);
			throw new IllegalStateException(msg);
		}
		if (elementsInFile % chunkSize != 0) {
			String msg = "Cannot create new chunk if there is a chunk with free capacity available.";
			logger.severe(msg);
			throw new IllegalStateException(msg);
		}
		data = (T[])(new Object[chunkSize]);
		elementsInLoadedChunk = 0;
		loadedChunkFilePos = elementsInFile * serializer.getElementLength();
		chunkLoaded = true;
		changed = false;
	}

	/**
	 * Serializes the current chunk to disc.
	 * @throws IOException Thrown if an IO error occurs.
	 */
	public void saveChunk() throws IOException {
		if (chunkLoaded && changed) {
			raf.seek(loadedChunkFilePos);
			raf.write(serializer.serialise(data, elementsInLoadedChunk));
			elementsInFile = raf.length() / serializer.getElementLength();
			changed = false;
		} else {
			if (!chunkLoaded) {
				String msg = "Tried to save the current chunk although there is no chunk loaded.";
				logger.warning(msg);
				throw new IllegalStateException(msg);
			}
			if (!changed) {
				String msg = "Tried to save the current chunk although it is not changed.";
				logger.info(msg);
			}
		}
	}
	
	/**
	 * Returns the number of elements in the currently loaded chunk.
	 * @return the number of elements.
	 */
	public int getNumberElementsInLoadedChunk() {
		if (!chunkLoaded) {
			String msg = "Tried to query number of elements in loaded chunk although there is no chunk loaded.";
			logger.warning(msg);
			throw new IllegalStateException(msg);
		}
		return elementsInLoadedChunk;
	}

	/**
	 * Returns the number of elements which can still be stored in this chunk.
	 * @return The number of elements. <code>0</code> if there is no chunk loaded. 
	 */
	public int elementCapacityLeft() {
		if (!chunkLoaded) {
			return 0;
		}
		return chunkSize - elementsInLoadedChunk;
	}

	/**
	 * Returns if the current chunk has been changed until it was last saved.
	 * @return <code>true</code> if changed.
	 */
	public boolean isChanged() {
		if (!chunkLoaded) {
			String msg = "Tried to query changed status although there is no chunk loaded.";
			logger.warning(msg);
			throw new IllegalStateException(msg);
		}
		return changed;
	}

	/**
	 * Returns the number of serialized data elements in the file on background storage.
	 * It may not be equal to the total number of elements stored and in memory.
	 * @return The number of data elements in the file.
	 */
	public long getElementsInFile() {
		return elementsInFile;
	}
	
	/**
	 * Checks if the index of a data element is within the current chunk.
	 * @param elementIndex Index of the data element with respect to all elements stored in the file on background storage.
	 * @return <code>true</code> if the index is within the current chunk.
	 */
	public boolean acceptsDataElementIndex(long elementIndex) {
		if (chunkLoaded && indexStartingElementForChunk() <= elementIndex && elementIndex < indexStartingElementForChunk() + chunkSize) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if there is currently a chunk loaded.
	 * @return <code>true</code> if a chunk is loaded.
	 */
	public boolean isChunkLoaded() {
		return chunkLoaded;
	}

}
