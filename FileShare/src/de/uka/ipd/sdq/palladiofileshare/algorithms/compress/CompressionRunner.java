package de.uka.ipd.sdq.palladiofileshare.algorithms.compress;

import java.io.InputStream;

/**
 * Replaces Harness.java from original SPEC compression
 * @author kelsaka
 *
 */
public class CompressionRunner {    
    public static final int LOOP_COUNT = 2;
    public static Source SOURCE;
    public static byte[][] COMPRESS_BUFFERS;
    public static byte[][] DECOMPRESS_BUFFERS;
    public static Compress CB;
	
	public byte[] compress(InputStream inputStream) {		
		
		prepareBuffers();
		
		runCompress(0);//FIXME: see Harness.java
		
		return null;
	}

	private void runCompress(int btid) {
	    Compress CB = new Compress();
		
		SOURCE = null; //TODO: inputStream --> source
	    OutputBuffer comprBuffer, decomprBufer;
	    comprBuffer = CB.performAction(SOURCE.getBuffer(),
	    		SOURCE.getLength(),
	            CB.COMPRESS,
	            COMPRESS_BUFFERS[btid - 1]);
	    decomprBufer = CB.performAction(COMPRESS_BUFFERS[btid - 1],
	            comprBuffer.getLength(),
	            CB.UNCOMPRESS,
	            DECOMPRESS_BUFFERS[btid - 1]);
	}
	
    static void prepareBuffers() {
        CB = new Compress();
        
        //SOURCES[i] = new Source(Context.getSpecBasePath() + "/" + FILES_NAMES[i]);
    	SOURCE = new Source("/" + "here");

        //DECOMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
        //COMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
        DECOMPRESS_BUFFERS = new byte[20][Source.MAX_LENGTH];
        COMPRESS_BUFFERS = new byte[20][Source.MAX_LENGTH];
    }

	
}
