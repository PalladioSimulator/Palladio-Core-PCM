package de.uka.ipd.sdq.sensorframework.storage.lists;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/**
 * @author Steffen Becker
 * A generic list implementation that consumes a constant amount of main memory regardless of the number of elements in the 
 * list. It relies on HDD memory as background storage. It uses chuncks which are filled and upon fully filled swapped to disk.
 * The list has some resrictions for this to work. First, all elements have to be serialisable with constant memory footprint. Second,
 * deletion of elements in the list is not implemented.
 * @param <T> The generic type parameter of the list's elements
 */
public class BackgroundMemoryList<T> 
	extends AbstractList<T>
	implements List<T>, RandomAccess {

	/**
	 * Number of list elements per list chunk
	 */
	static final public int MEMORY_CHUNKS_SIZE = 10000;
	
	/**
	 * The current chunk loaded into memory
	 */
	private Chunk<T> currentChunk = null;
	
	/**
	 * The background file storage in which all chunks get persisted when they are swapped from main memory
	 */
	private RandomAccessFile raf = null;
	
	/**
	 * Inner state of the underlying background storage
	 */
	boolean isClosed = true;
	
	/**
	 * The serialiser used to serialise the elements of the list on the background storage
	 */
	private ISerialiser<T> serialiser;
	
	/**
	 * Current number of elements in the list
	 */
	private int listSize;
	
	/**
	 * Constructor of a background memory list
	 * @param filename The file used as background storage
	 * @param serialiser The serialiser used to serialise the elements of the list
	 * @throws IOException Thrown if file IO fails
	 */
	public BackgroundMemoryList(String filename, ISerialiser<T> serialiser) throws IOException {
		this(new File(filename),serialiser);
	}

	/**
	 * Constructor of a background memory list
	 * @param f The file used as background storage
	 * @param serialiser The serialiser used to serialise the elements of the list
	 * @throws IOException Thrown if file IO fails
	 */
	public BackgroundMemoryList(File f, ISerialiser<T> serialiser) throws IOException {
		raf = new RandomAccessFile(f,"rw");
		isClosed = false;
		this.serialiser = serialiser;
		initListSize();
	}

	@Override
	public synchronized void add(int index, T e) {
		try{
			ensureCorrectCunkLoaded(index);
			if (currentChunk == null || currentChunk.isFull()) {
				flush();
				currentChunk = new Chunk<T>(raf,serialiser);
			}
			currentChunk.add(e);
			this.listSize++;
		} catch(IOException ex) {
			throw new RuntimeException("Background List failed",ex);
		}
	}

	public synchronized T get(int index) {
		if (this.isClosed)
			throw new IllegalStateException("Tryed to get data from a closed background list");
		if (index >= size())
			throw new ArrayIndexOutOfBoundsException("Read behind background list length");
		try{
			ensureCorrectCunkLoaded(index);
			return currentChunk.get((int)(index-currentChunk.fromElement()));
		} catch(IOException ex) {
			throw new RuntimeException("Background List failed",ex);
		}
	}

	/**
	 * Tests whether a chunk swapping is needed to access the list element add the given index and if so swaps the chunks
	 */
	private void ensureCorrectCunkLoaded(int index) throws IOException {
		if (currentChunk != null && currentChunk.accepts(index))
			return;
		else {
			flush();
			currentChunk = new Chunk<T>(raf,serialiser,index / MEMORY_CHUNKS_SIZE);
		}
	}

	public synchronized int size() {
		return this.listSize;
	}

	/**
	 * Derive the list size from the size of the underlying file. Called on opening a list
	 */
	private void initListSize() {
		try {
			if (currentChunk != null && !currentChunk.isFull()) {
				// The current chunk is the last chunk which might contain unsaved data,
				// so the size is the size of all saved data + all unsaved data
				this.listSize = (int)(raf.length() / (serialiser.getElementLength() * MEMORY_CHUNKS_SIZE) + currentChunk.size());
			}
			this.listSize = (int)(raf.length() / serialiser.getElementLength());
		} catch (IOException e) {
			throw new RuntimeException("Background list failed unexpectedly",e);
		}
	}

	/** Closes the background storage. The list is inaccessible afterwards
	 * @throws IOException
	 */
	public synchronized void close() throws IOException {
		if (!isClosed){
			flush();
			raf.close();
			isClosed = true;
		}
	}

	/** Writes all buffered data to the background storage
	 * @throws IOException
	 */
	public synchronized void flush() throws IOException {
		if (currentChunk != null) {
			currentChunk.persist();
		}
	}
}
