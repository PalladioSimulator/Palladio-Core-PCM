package de.uka.ipd.sdq.sensorframework.storage.lists;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import java.util.logging.Logger;

/**
 * A generic list implementation that consumes a constant amount of main memory regardless of the number of elements in the 
 * list. It relies on HDD memory as background storage. It uses views on the data stored in form of chunks.
 * A chunk contains a limited number of data elements. Chunks are (de-)serialized to disk depending on the
 * requested data elements. 
 * The list has some restrictions:
 * First, all elements have to be serializable with constant memory footprint.
 * Second, deletion of elements in the list is not implemented.
 * Third, insertion is only possible at the end of the list.
 * @param <T> The generic type parameter of the list's elements
 * @author Henning Groenda
 * @author Steffen Becker
 */
public class BackgroundMemoryList<T> 
	extends AbstractList<T>
	implements List<T>, RandomAccess, Serializable {

	private static final String ACCESS_MODIFIER_READ_WRITE = "rw";
	/**Serialization UID for this class. Change upon altered serialization. */
	private static final long serialVersionUID = 1L;
	/** Logger for this class. */
	transient private static Logger logger = Logger.getLogger(BackgroundMemoryList.class.getName());

	/** Number of data elements per chunk. */
	static final public int DEFAULT_CHUNK_SIZE = 10000;
	
	/** Access to chunks. */
	transient private Chunk<T> chunks = null;
	/** Name of the file which is used to store the chunks. Relative path to the current root directory of the measurements. */
	private String relativeFilename = null;
	/** The link to the attached background storage in which all chunks are persisted. */
	transient private RandomAccessFile raf = null;
	/** Status of the link to the attached file on background storage. Operations are only allowed in open state. */
	transient boolean closed = true;
	/** The serializer for the elements of the list on the background storage. */
	private ISerialiser<T> serialiser;
	/** Total number of elements in the list. */
	private int listSize;
	/** The size of the chunk in elements */
	private int chunkSize;
	
	/**
	 * Constructor for background memory lists.
	 * @param relativeFilename Identifier of the file used as background storage.
	 * @param serialiser The (de-)serializer to use upon serialization of data to the background storage.
	 * @throws IOException Thrown if file IO fails.
	 */
	public BackgroundMemoryList(String relativeFilename, ISerialiser<T> serialiser) throws IOException {
		this(relativeFilename, serialiser, DEFAULT_CHUNK_SIZE);
	}

	/**
	 * Constructor for background memory lists.
	 * @param relativeFilename Identifier of the file used as background storage.
	 * @param serialiser The (de-)serializer to use upon serialization of data to the background storage.
	 * @param chunkSize The size of the chunk in elements which should be used.
	 * @throws IOException Thrown if file IO fails.
	 */
	public BackgroundMemoryList(String relativeFilename, ISerialiser<T> serialiser, int chunkSize) throws IOException {
		this.relativeFilename = relativeFilename;
		this.serialiser = serialiser;
		this.chunkSize = chunkSize;
		open();
		listSize = (int) chunks.getElementsInFile();
	}
	
	/**Opens the link to the file on background storage. Only allowed if there is no open link.
	 * @throws IOException Thrown if file IO fails.
	 */
	private void open() throws IOException {
		if (!closed) {
			String msg = "Tried to open an already open background list.";
			logger.warning(msg);
			throw new IllegalStateException(msg);
		}
		raf = new RandomAccessFile(relativeFilename, ACCESS_MODIFIER_READ_WRITE);
		chunks = new Chunk<T>(raf, serialiser, chunkSize);
		closed = false;
		// list size is calculated in open() and readObject() to allow error detection.
	}

	/**Get the status of the link to the attached file. Any read or write operation is only allowed in open state.
	 * @return <code>true</code> if the link to the attached file is closed.
	 */
	public synchronized boolean isClosed() {
		return closed;
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	@Override
	public synchronized void add(int index, T element) {
		if (closed) {
			String msg = "Tried to add data to a closed background list.";
			logger.severe(msg);
			throw new IllegalStateException(msg);
		}
		if (index != listSize) {
			String msg = "The background list currently only supports adding elements at the end of the list";
			logger.info(msg);
			throw new IllegalArgumentException(msg);
		}
		try {
			ensureCorrectChunkLoaded(index);
			chunks.add(element);
			this.listSize++;
			if (chunks.isFull()) {
				chunks.saveChunk();
				chunks.createChunk();
			}
		} catch(IOException ex) {
			String msg = "Error during IO of background list for file \"" + relativeFilename +"\"";
			logger.severe(msg);
			throw new RuntimeException(msg, ex);
		}
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractList#get(int)
	 */
	public synchronized T get(int index) {
		if (closed) {
			String msg = "Tried to get data to a closed background list.";
			logger.severe(msg);
			throw new IllegalStateException(msg);
		}
		if (index < 0 || index >= size()) {
			String msg;
			if (index >= size()) {
				msg = "Tried to get data element beyond the number of elements in the background list.";
			} else {
				msg = "Tried to get data element with a negative index from the background list.";
			}
			logger.severe(msg);
			throw new ArrayIndexOutOfBoundsException(msg);
		}
		try {
			ensureCorrectChunkLoaded(index);
			return chunks.get((int)(index - chunks.indexStartingElementForChunk()));
		} catch(IOException ex) {
			String msg = "Error during IO of background list for file \"" + relativeFilename +"\"";
			logger.severe(msg);
			throw new RuntimeException(msg, ex);
		}
	}

	/**Ensures that the chunk containing the requested element is loaded.
	 * Serializes the current chunk and load the requested chunk if necessary.
	 * @param dataIndex index of the requested element in the list.
	 * @throws IOException Thrown if an error during IO occurs.
	 */
	private void ensureCorrectChunkLoaded(int dataIndex) throws IOException {
		if (chunks.acceptsDataElementIndex(dataIndex)) {
			return;
		} else {
			if (chunks.isChunkLoaded() && chunks.isChanged()) {
				chunks.saveChunk();
			}
			chunks.loadChunkForElement(dataIndex);
		}
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	public synchronized int size() {
		return listSize;
	}

	/** Closes the link to the file on background storage. There are no further add or get operations allowed after closing.
	 * @throws IOException
	 */
	public synchronized void close() throws IOException {
		if (closed) {
			String msg = "Tried to close a closed list.";
			logger.warning(msg);
			throw new IllegalStateException(msg);
		}
		if (!closed) {
			if (chunks.isChunkLoaded() && chunks.isChanged()) {
				chunks.saveChunk();
			}
			raf.close();
			closed = true;
		}
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		// default behavior
		in.defaultReadObject();

		// customization on load
		open();
		if (chunks.getElementsInFile() != listSize) {
			String msg = "Number of elements of this list and elements saved to file on background mismatch.";
			logger.severe(msg);
		}
		listSize = (int) chunks.getElementsInFile();
	}
}
