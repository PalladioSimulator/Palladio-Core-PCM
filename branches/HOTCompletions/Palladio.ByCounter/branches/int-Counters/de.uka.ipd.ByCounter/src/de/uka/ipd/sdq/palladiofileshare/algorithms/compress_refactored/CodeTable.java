package de.uka.ipd.sdq.palladiofileshare.algorithms.compress_refactored;

public /*final*/ class CodeTable {
    private short tab[];
    
    public CodeTable() {
        tab = new short[Compress.HSIZE];
    }
    
    public void clear(int size) {
        for (int code = 0; code < size; code++) {
            tab[code] = 0;
        }
    }
    
    public int of(int i) {
        return (int) tab[i] << 16 >>> 16;
    }
    
    public void set(int i, int v) {
        tab[i] = (short) v;
    }

}
