package spec.benchmarks.compress_inlined;

public /*static*/ class HashTable { // moved 4/15/98 dm/kmd
    /*
     * Use protected instead of private to allow access by parent class of inner
     * class. wnb 4/17/98
     */
    
    protected int size;
    
    protected int tab[]; // for dynamic table sizing */
    
    public HashTable() {
        size = Compress.HSIZE;
        tab = new int[size];
    }
    
    public void clear() {
    	{
        	System.out.println("TEMPORARY LOGGING: \"size\" in Compressor$HashTable.clear() is "+size); //this does not increase the count of ILOADs... //TODO remove!
        	try{
        		int a= 1/0;//TODO remove this
        	}catch(Exception e){
        		System.err.println("Remove unneeded code from Compressor$HashTable.clear() before counting Compressor.compress or other SPEC stuff");
//        		e.printStackTrace();
        	}
    	}
        
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

