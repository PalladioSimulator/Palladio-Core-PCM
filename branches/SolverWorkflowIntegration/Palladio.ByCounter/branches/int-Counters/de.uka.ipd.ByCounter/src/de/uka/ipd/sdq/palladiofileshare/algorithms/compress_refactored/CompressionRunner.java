package de.uka.ipd.sdq.palladiofileshare.algorithms.compress_refactored;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Replaces Harness.java from original SPEC compression
 * @author kelsaka
 *
 */
public class CompressionRunner {    
	private Logger logger = Logger.getLogger(this.getClass().getCanonicalName());
	
    public Source SOURCE;
    public byte[][] COMPRESS_BUFFERS;
    public byte[][] DECOMPRESS_BUFFERS;
    public Compress CB;
	
	void prepareBuffers(byte[] inputFile) {
        CB = new Compress();
        
    	SOURCE = new Source(inputFile);

        //DECOMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
        //COMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
        DECOMPRESS_BUFFERS = new byte[20][Source.MAX_LENGTH]; //FIXME: 20
        COMPRESS_BUFFERS = new byte[20][Source.MAX_LENGTH]; //FIXME: 20
    }

	OutputBuffer runCompress(int btid) {		
    	
	    @SuppressWarnings("unused")
		OutputBuffer comprBuffer, decomprBufer;
	    comprBuffer = Compress.performAction(SOURCE.getBuffer(),
	    		SOURCE.getLength(),
	    		Compress.COMPRESS,
	            COMPRESS_BUFFERS[btid - 1]);
	    /*decomprBufer = CB.performAction(COMPRESS_BUFFERS[btid - 1],
	            comprBuffer.getLength(),
	            CB.UNCOMPRESS,
	            DECOMPRESS_BUFFERS[btid - 1]);*/
        logger.debug("src length: " + SOURCE.getLength() + " -- " + SOURCE.getCRC() + " ");
        logger.debug("compressed length: " + comprBuffer.getLength() + " -- " + comprBuffer.getCRC() + " ");                
        //logger.info(decomprBufer.getLength() + " " + decomprBufer.getCRC());
    
        return comprBuffer;
	}
	
    public byte[] compress(byte[] inputFile) {				
		prepareBuffers(inputFile);

		//int threadID = (int)Thread.currentThread().getId();				
		int threadID = 1; //TODO: check use of threads
		OutputBuffer outBuffer = runCompress(threadID);
		byte[] returnBytes = Arrays.copyOf(outBuffer.getBuffer(), outBuffer.getLength());
		return returnBytes;
	}

	
}
