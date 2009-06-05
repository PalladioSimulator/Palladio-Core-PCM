package spec.benchmarks.compress_inlined;

public class CompBase {
    protected int bitsNumber; /* number of bits/code */
    
    protected int blockCompress;
    
    protected byte buf[];
    
    protected int clearFlag;
    
    protected int freeEntry; /* first unused entry */
    
    protected InputBuffer input;
    
    protected int maxBits; /* user settable max # bits/code */
    
    protected int maxCode; /* maximum code, given n_bits */
    
    protected int maxMaxCode; /* should NEVER generate this code */
    
    protected int offset;
    
    protected OutputBuffer output;
    
    public CompBase(InputBuffer in, OutputBuffer out) {
        input = in;
        output = out;
        maxBits = Compress.BITS;
        blockCompress = Compress.BLOCK_MASK;
        buf = new byte[Compress.BITS];
    }
    
    public int getMaxCode() {
        return ((1 << (bitsNumber)) - 1);
    }
}

