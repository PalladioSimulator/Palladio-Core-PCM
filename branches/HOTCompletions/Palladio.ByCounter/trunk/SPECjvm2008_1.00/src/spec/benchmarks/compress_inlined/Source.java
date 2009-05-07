/**
 * 
 */
package spec.benchmarks.compress_inlined;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

import spec.harness.Context;

public class Source {
    static int MAX_LENGTH;
    
    private static byte[] fillBuffer(String fileName) {
        try {
            FileInputStream sif = new FileInputStream(fileName);
            int length = (int) new File(fileName).length();
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
                spec.harness.Context.getOut().println(
                        "ERROR reading test input file");
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace(Context.getOut());
        }
        
        return null;
    }
    private byte[] buffer;
    private long crc;
    
    int length;
    
    public Source(String fileName) {
        buffer = fillBuffer(fileName);
        length = buffer.length;
        MAX_LENGTH = Math.max(length, MAX_LENGTH);
        CRC32 crc32 = new CRC32();
        crc32.update(buffer, 0, length);
        crc = crc32.getValue();
    }
    
    byte[] getBuffer() {
        return buffer;
    }
    
    long getCRC() {
        return crc;
    }
    
    int getLength() {
        return length;
    }
}