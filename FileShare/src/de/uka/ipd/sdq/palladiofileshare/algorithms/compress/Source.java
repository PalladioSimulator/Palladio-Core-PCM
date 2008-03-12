package de.uka.ipd.sdq.palladiofileshare.algorithms.compress;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

public class Source {
    private byte[] buffer;
    private long crc;
    private int length;
    static int MAX_LENGTH;
    
    public Source(InputStream fileName, int inputByteSize) {
        buffer = fillBuffer(fileName, inputByteSize);
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
    
    private static byte[] fillBuffer(InputStream sif, int inputByteSize) {
        try {        	
            //FileInputStream sif = new FileInputStream(fileName);
        	// (int) new File(fileName).length();
            int length = inputByteSize; 
            int counter = 0;
            
            // Only allocate size of input file rather than MAX - kmd
            // If compressed file is larger than input file this allocation
            // will fail and out of bound exception will occur
            // In real lie, compress will no do any compression as no
            // space is saved.-- kaivalya
            byte[] result = new byte[length];
            
            int bytes_read;
            while ((bytes_read = sif.read(result, counter,
                    (length - counter))) > 0) {
                counter += bytes_read;
            }
            
            sif.close(); // release resources
            
            if (counter != length) {
                System.out.println(
                        "ERROR reading test input file");
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
