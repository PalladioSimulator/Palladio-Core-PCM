package de.uka.ipd.sdq.palladiofileshare.algorithms.compress;

import java.util.zip.CRC32;

public class Source_stupid {
	
    static int MAX_LENGTH;
    private byte[] buffer;
    private long crc;
    private int length;
    
    public Source_stupid(byte[] inputFile) {
        buffer = inputFile;
        length = buffer.length;
        MAX_LENGTH = Math.max(length, MAX_LENGTH);        
        CRC32 crc32 = new CRC32();
        crc32.update(buffer, 0, length);
        crc = crc32.getValue();
    }
    
    public byte[] getBuffer() {
        return buffer;
    }
    
    public long getCRC() {
        return crc;
    }
    
    public int getLength() {
        return length;
    }
    

    
}
