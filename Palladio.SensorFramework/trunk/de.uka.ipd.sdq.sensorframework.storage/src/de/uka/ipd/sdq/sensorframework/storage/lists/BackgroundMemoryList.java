package de.uka.ipd.sdq.sensorframework.storage.lists;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.AbstractList;
import java.util.List;

/**
 * @author Steffen Becker
 *
 * @param <T>
 */
public class BackgroundMemoryList<T> 
extends AbstractList<T>
implements List<T> {

	static final public int MEMORY_CHUNKS_SIZE = 10000;
	private Chunk<T> currentChunk = null;
	private RandomAccessFile raf = null;
	boolean isClosed = true;
	private ISerialiser serialiser;
	private int listSize;
	
	public BackgroundMemoryList(String filename, ISerialiser serialiser) throws IOException {
		this(new File(filename),serialiser);
	}

	public BackgroundMemoryList(File f, ISerialiser serialiser) throws IOException {
		raf = new RandomAccessFile(f,"rw");
		isClosed = false;
		this.serialiser = serialiser;
		initListSize();
	}

	@Override
	public void add(int index, T e) {
		try{
			ensureCorrectCunkLoaded(index);
			if (currentChunk == null || currentChunk.isFull()) {
				if (currentChunk != null)
					currentChunk.persist();
				currentChunk = new Chunk<T>(raf,serialiser);
			}
			currentChunk.add(e);
			this.listSize++;
		} catch(IOException ex) {
			throw new RuntimeException("Background List failed",ex);
		}
	}

	public T get(int index) {
		if (this.isClosed)
			throw new IllegalStateException("Tryed to get data from a closed background list");
		
		try{
			if (index >= size())
				throw new ArrayIndexOutOfBoundsException("Read behind background list length");
			ensureCorrectCunkLoaded(index);
			return currentChunk.get((int)(index-currentChunk.fromElement()));
		} catch(IOException ex) {
			throw new RuntimeException("Background List failed",ex);
		}
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	private void ensureCorrectCunkLoaded(int index) throws IOException {
		if (currentChunk == null) {
			currentChunk = new Chunk(raf,serialiser,index / MEMORY_CHUNKS_SIZE);
			return;
		}
		if ( (index < currentChunk.fromElement()) || (index > currentChunk.fromElement() + this.MEMORY_CHUNKS_SIZE - 1) ) {
			//if (currentChunk.isFull()) { 
				currentChunk.persist();
				currentChunk = new Chunk(raf,serialiser,index / MEMORY_CHUNKS_SIZE);
			//}
		}
	}

	public int size() {
		return this.listSize;
	}

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

	public void close() throws IOException {
		if (!isClosed){
			if (currentChunk != null) {
				currentChunk.persist();
			}
			raf.close();
			isClosed = true;
		}
	}

	public void flush() throws IOException {
		currentChunk.persist();
	}
}
