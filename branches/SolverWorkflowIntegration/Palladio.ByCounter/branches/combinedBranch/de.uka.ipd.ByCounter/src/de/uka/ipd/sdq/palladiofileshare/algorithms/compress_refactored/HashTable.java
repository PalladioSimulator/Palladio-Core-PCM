package de.uka.ipd.sdq.palladiofileshare.algorithms.compress_refactored;

public /*final*/ class HashTable { // moved 4/15/98 dm/kmd
    /*
     * Use protected instead of private to allow access by parent class of inner
     * class. wnb 4/17/98
     */
    
    protected int tab[]; // for dynamic table sizing */
    
    protected int size;
    
    public HashTable() {
        size = Compress.HSIZE;
        tab = new int[size];
    }
    
    public void clear() {
        for (int i = 0; i < size; i++) {
            tab[i] = -1;
        }
    }
    
    public int hsize() {
        return size;
    }
    
    public int of(int i) {
        return tab[i];
    }
    
    public void set(int i, int v) {
        tab[i] = v;
    }
}
