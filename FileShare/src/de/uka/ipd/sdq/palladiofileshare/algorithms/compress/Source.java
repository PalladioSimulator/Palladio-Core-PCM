package de.uka.ipd.sdq.palladiofileshare.algorithms.compress;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.CRC32;

import org.apache.log4j.Logger;

public class Source {
	
	private static Logger logger = Logger.getLogger(Source.class);
	
    private byte[] buffer;
    private long crc;
    private int length;
    static int MAX_LENGTH;
    
    public Source(byte[] inputFile) {
        buffer = inputFile;
        length = buffer.length;
        MAX_LENGTH = Math.max(length, MAX_LENGTH);        
        CRC32 crc32 = new CRC32();
        crc32.update(buffer, 0, length);
        crc = crc32.getValue();
    }
    
    public long getCRC() {
        return crc;
    }
    
    public int getLength() {
        return length;
    }
    
    public byte[] getBuffer() {
        return buffer;
    }
    

    
}
