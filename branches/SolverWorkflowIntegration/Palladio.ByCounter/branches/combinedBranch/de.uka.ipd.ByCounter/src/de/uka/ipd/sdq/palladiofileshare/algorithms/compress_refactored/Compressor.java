package de.uka.ipd.sdq.palladiofileshare.algorithms.compress_refactored;

/*
 * compress (Originally: stdin to stdout -- Changed by SPEC to: memory to
 * memory)
 *
 * Algorithm: use open addressing double hashing (no chaining) on the prefix
 * code / next character combination. We do a variant of Knuth's algorithm D
 * (vol. 3, sec. 6.4) along with G. Knott's relatively-prime secondary probe.
 * Here, the modular division first probe is gives way to a faster exclusive-or
 * manipulation. Also do block compression with an adaptive reset, whereby the
 * code table is cleared when the compression ratio decreases, but after the
 * table fills. The variable-length output codes are re-sized at this point, and
 * a special CLEAR code is generated for the decompressor. Late addition:
 * construct the table according to file size for noticeable speed improvement
 * on small files. Please direct questions about this implementation to
 * ames!jaw.
 */

public /*final*/ class Compressor extends CompBase {
    
    private final static int CHECK_GAP = 10000; /* ratio check interval */
    
    private int ratio;
    
    private int checkpoint;
    
    private int inCount; /* length of input */
    
    private int outCount; /* # of codes output */
    
    private int bytesOut; /* length of compressed output */
    
    private HashTable htab;
    
    private CodeTable codetab;
    
    public Compressor(InputBuffer in, OutputBuffer out) {
        super(in, out);
        if (maxBits < Compress.INIT_BITS) {
            maxBits = Compress.INIT_BITS;
        }
        if (maxBits > Compress.BITS) {
            maxBits = Compress.BITS;
        }
        maxMaxCode = 1 << maxBits;
        bitsNumber = Compress.INIT_BITS;
        maxCode = getMaxCode();
        
        offset = 0;
        bytesOut = 3; /* includes 3-byte header mojo */
        outCount = 0;
        clearFlag = 0;
        ratio = 0;
        inCount = 1;
        checkpoint = CHECK_GAP;
        freeEntry = ((blockCompress != 0) ? Compress.FIRST : 256);
        
        htab = new HashTable(); // dm/kmd 4/10/98
        codetab = new CodeTable();
        
        output.writeByte(Compress.magic_header[0]);
        output.writeByte(Compress.magic_header[1]);
        output.writeByte((byte) (maxBits | blockCompress));
    }
    
        /*
         * Output the given code. Inputs: code: A n_bits-bit integer. If == -1, then
         * EOF. This assumes that n_bits = < (long)wordsize - 1. Outputs: Outputs
         * code to the file. Assumptions: Chars are 8 bits long. Algorithm: Maintain
         * a BITS character long buffer (so that 8 codes will fit in it exactly).
         */
    
    /* table clear for block compress */
    @SuppressWarnings("unused")
	private void clBlock() {
        int rat;
        
        checkpoint = inCount + CHECK_GAP;
        
        if (inCount > 0x007fffff) { /* shift will overflow */
            rat = bytesOut >> 8;
            if (rat == 0) { /* Don't divide by zero */
                rat = 0x7fffffff;
            } else {
                rat = inCount / rat;
            }
        } else {
            rat = (inCount << 8) / bytesOut; /* 8 fractional bits */
        }
        if (rat > ratio) {
            ratio = rat;
        } else {
            ratio = 0;
            htab.clear();
            freeEntry = Compress.FIRST;
            clearFlag = 1;
            output((int) Compress.CLEAR);
        }
    }
    
    public void compress() {
        int fcode;
        int i = 0;
        int c;
        int disp;
        int hshift = 0;
        
        int ent = input.readByte();
        
        for (fcode = htab.hsize(); fcode < 65536; fcode *= 2) {
            hshift++;
        }
        hshift = 8 - hshift; /* set hash code range bound */
        
        int hsizeReg = htab.hsize();
        htab.clear(); /* clear hash table */
        
        /*next_byte: */while ((c = input.readByte()) != -1) {
            inCount++;
            fcode = (((int) c << maxBits) + ent);
            i = ((c << hshift) ^ ent); /* xor hashing */
            int temphtab = htab.of(i);
            if (temphtab == fcode) {
                ent = codetab.of(i);
                /*continue next_byte;*/
            }else{
            	boolean continueAbove = false;
	            if (temphtab >= 0) { /* non-empty slot dm kmd 4/15 */
	                disp = hsizeReg - i; /* secondary hash (after G. Knott) */
	                if (i == 0) {
	                    disp = 1;
	                }
	                do {
	                    if ((i -= disp) < 0) {
	                        i += hsizeReg;
	                    }
//	                    temphtab = htab.of(i);
	                    if (temphtab == fcode) {
	                        ent = codetab.of(i);
	                        continueAbove=true; /*continue next_byte;*/
	                    }
	                } while (temphtab > 0 && !continueAbove);
	            }
	            if(!continueAbove){
		            output(ent);
		            outCount++;
		            ent = c;
		            if (freeEntry < maxMaxCode) {
//		                codetab.set(i, freeEntry++); /* code -> hashtable */
//		                htab.set(i, fcode);
		            } else if (inCount >= checkpoint && blockCompress != 0) {
//		                clBlock();
		            }
	            }
            }
        }
        /*
         * Put out the final code.
         */
        output(ent);
        outCount++;
        output(-1);
        return;
    }
    
    private void output(int code) {
        int rOff = offset, bits = bitsNumber;
        int bp = 0;
        
        if (code >= 0) {
                        /*
                         * Get to the first byte.
                         */
            bp += rOff >> 3;
            rOff &= 7;
                        /*
                         * Since code is always >= 8 bits, only need to mask the first hunk
                         * on the left.
                         */
            buf[bp] = (byte) ((buf[bp] & Compress.rmask[rOff]) | (code << rOff)
            & Compress.lmask[rOff]);
            bp++;
            bits -= 8 - rOff;
            code >>= 8 - rOff;
            /* Get any 8 bit parts in the middle ( <=1 for up to 16 bits). */
            if (bits >= 8) {
                buf[bp++] = (byte) code;
                code >>= 8;
                bits -= 8;
            }
            /* Last bits. */
            if (bits != 0) {
                buf[bp] = (byte) code;
            }
            offset += bitsNumber;
            if (offset == (bitsNumber << 3)) {
                bp = 0;
                bits = bitsNumber;
                bytesOut += bits;
                do {
                    output.writeByte(buf[bp++]);
                } while (--bits != 0);
                offset = 0;
            }
            
                        /*
                         * If the next entry is going to be too big for the code size, then
                         * increase it, if possible.
                         */
            if (freeEntry > maxCode || clearFlag > 0) {
                                /*
                                 * Write the whole buffer, because the input side won't discover
                                 * the size increase until after it has read it.
                                 */
                if (offset > 0) {
                    output.writebytes(buf, bitsNumber);
                    bytesOut += bitsNumber;
                }
                offset = 0;
                
                if (clearFlag != 0) {
                    bitsNumber = Compress.INIT_BITS;
                    maxCode = getMaxCode();
                    clearFlag = 0;
                } else {
                    bitsNumber++;
                    if (bitsNumber == maxBits) {
                        maxCode = maxMaxCode;
                    } else {
                        maxCode = getMaxCode();
                    }
                }
            }
        } else {
                        /*
                         * At EOF, write the rest of the buffer.
                         */
            if (offset > 0) {
                output.writebytes(buf, ((offset + 7) / 8));
            }
            bytesOut += (offset + 7) / 8;
            offset = 0;
        }
    }
    
}