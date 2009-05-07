package de.uka.ipd.sdq.palladiofileshare.algorithms.compress;

public final class InputBuffer_stupid {
    private int cnt;
    private int current;
    private byte[] buffer;
    
    public InputBuffer_stupid(int c, byte[] b) {
        cnt = c;
        buffer = b;
    }
    
    public int readByte() {
        return cnt-- > 0 ? (buffer[current++] & 0x00FF) : -1;
    }
    
    public int readBytes(byte[] buf, int n) {
        if (cnt <= 0)
            return -1;
        int num = Math.min(n, cnt);
        for (int i = 0; i < num; i++) {
            buf[i] = buffer[current++];
            cnt--;
        }
        return num;
    }
}
