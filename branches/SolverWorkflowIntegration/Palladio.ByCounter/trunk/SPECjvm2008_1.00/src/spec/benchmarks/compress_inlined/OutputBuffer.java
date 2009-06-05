package spec.benchmarks.compress_inlined;

import java.util.zip.CRC32;

public class OutputBuffer {
    private byte[] buffer;
    private int cnt;
    
    public OutputBuffer(byte[] b) {
        buffer = b;
    }
    
    public long getCRC() {
        CRC32 crc32 = new CRC32();
        crc32.update(buffer, 0, cnt);
        return crc32.getValue();
    }
    
    public int getLength() {
        return cnt;
    }
    
    public void writeByte(byte c) {
        buffer[cnt++] = c;
    }
    
    public void writebytes(byte[] buf, int n) {
        for (int i = 0; i < n; i++) {
            buffer[cnt++] = buf[i];
        }
    }
}