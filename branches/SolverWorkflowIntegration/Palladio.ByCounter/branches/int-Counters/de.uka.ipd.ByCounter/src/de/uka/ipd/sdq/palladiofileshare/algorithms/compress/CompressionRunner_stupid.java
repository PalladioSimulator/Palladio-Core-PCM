package de.uka.ipd.sdq.palladiofileshare.algorithms.compress;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Replaces Harness.java from original SPEC compression
 * @author kelsaka
 *
 */
public class CompressionRunner_stupid {    
	private Logger logger = Logger.getLogger(this.getClass().getCanonicalName());
	
    public Source_stupid SOURCE;
    public byte[][] COMPRESS_BUFFERS;
    public byte[][] DECOMPRESS_BUFFERS;
    public Compress_stupid CB;
	
	void prepareBuffers(byte[] inputFile) {
        CB = new Compress_stupid();
        
    	SOURCE = new Source_stupid(inputFile);

        //DECOMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source_stupid.MAX_LENGTH];
        //COMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source_stupid.MAX_LENGTH];
        DECOMPRESS_BUFFERS = new byte[20][Source_stupid.MAX_LENGTH]; //FIXME: 20
        COMPRESS_BUFFERS = new byte[20][Source_stupid.MAX_LENGTH]; //FIXME: 20
    }

	OutputBuffer_stupid runCompress(int btid) {		
    	
	    @SuppressWarnings("unused")
		OutputBuffer_stupid comprBuffer, decomprBufer;
	    comprBuffer = Compress_stupid.performAction(SOURCE.getBuffer(),
	    		SOURCE.getLength(),
	    		Compress_stupid.COMPRESS,
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
		OutputBuffer_stupid outBuffer = runCompress(threadID);
		byte[] returnBytes = Arrays.copyOf(outBuffer.getBuffer(), outBuffer.getLength());
		return returnBytes;
	}

	
}
