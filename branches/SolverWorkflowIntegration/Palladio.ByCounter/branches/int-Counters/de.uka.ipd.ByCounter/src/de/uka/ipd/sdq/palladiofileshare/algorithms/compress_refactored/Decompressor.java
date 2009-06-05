package de.uka.ipd.sdq.palladiofileshare.algorithms.compress_refactored;

/*
 * Decompress stdin to stdout. This routine adapts to the codes in the file
 * building the "string" table on-the-fly; requiring no table to be stored in
 * the compressed file. The tables used herein are shared with those of the
 * compress() routine. See the definitions above.
 */

public /*final*/ class Decompressor extends CompBase {
    private int size;
    
    private CodeTable tabPrefix;
    
    private SuffixTable tabSuffix;
    
    private DeStack deStack;
    
        /*
         * Read one code from the standard input. If EOF, return -1. Inputs: stdin
         * Outputs: code or -1 is returned.
         */
    
    public Decompressor(InputBuffer in, OutputBuffer out) {
        super(in, out);
        
        /* Check the magic number */
        if (((input.readByte() & 0xFF) != (Compress.magic_header[0] & 0xFF))
        || ((input.readByte() & 0xFF) != (Compress.magic_header[1] & 0xFF))) {
            System.err.println("stdin: not in compressed format");
        }
        
        maxBits = input.readByte(); /* set -b from file */
        blockCompress = maxBits & Compress.BLOCK_MASK;
        maxBits &= Compress.BIT_MASK;
        maxMaxCode = 1 << maxBits;
        if (maxBits > Compress.BITS) {
            System.err.println("stdin: compressed with " + maxBits
                    + " bits, can only handle " + Compress.BITS + " bits");
        }
        bitsNumber = Compress.INIT_BITS;
        maxCode = getMaxCode();
        
        offset = 0;
        size = 0;
        clearFlag = 0;
        freeEntry = ((blockCompress != 0) ? Compress.FIRST : 256);
        
        tabPrefix = new CodeTable();
        tabSuffix = new SuffixTable();
        deStack = new DeStack();
        
                /*
                 * As above, initialize the first 256 entries in the table.
                 */
        tabPrefix.clear(256);
        tabSuffix.init(256);
    }
    
    
    public void decompress() {
        int code, oldcode, incode;
        
        int finchar = oldcode = getCode();
        if (oldcode == -1)  {/* EOF already? */
            return; /* Get out of here */
        }
        output.writeByte((byte) finchar); /* first code must be 8 bits = byte */
        
        while ((code = getCode()) > -1) {
            if ((code == Compress.CLEAR) && (blockCompress != 0)) {
                tabPrefix.clear(256);
                clearFlag = 1;
                freeEntry = Compress.FIRST - 1;
                if ((code = getCode()) == -1) /* O, untimely death! */
                    break;
            }
            incode = code;
                        /*
                         * Special case for KwKwK string.
                         */
            if (code >= freeEntry) {
                deStack.push((byte) finchar);
                code = oldcode;
            }
            
                        /*
                         * Generate output characters in reverse order
                         */
            while (code >= 256) {
                deStack.push(tabSuffix.of(code));
                code = tabPrefix.of(code);
            }
            deStack.push((byte) (finchar = tabSuffix.of(code)));
            
                        /*
                         * And put them out in forward order
                         */
            do {
                output.writeByte(deStack.pop());
            } while (!deStack.isEmpty());
            
                        /*
                         * Generate the new entry.
                         */
            if ((code = freeEntry) < maxMaxCode) {
                tabPrefix.set(code, oldcode);
                tabSuffix.set(code, (byte) finchar);
                freeEntry = code + 1;
            }
                        /*
                         * Remember previous code.
                         */
            oldcode = incode;
        }
    }
    
    
    private int getCode() {
        int code;
        int rOff, bits;
        int bp = 0;
        
        if (clearFlag > 0 || offset >= size || freeEntry > maxCode) {
                        /*
                         * If the next entry will be too big for the current code size, then
                         * we must increase the size. This implies reading a new buffer
                         * full, too.
                         */
            if (freeEntry > maxCode) {
                bitsNumber++;
                if (bitsNumber == maxBits) {
                    maxCode = maxMaxCode; /* won't get any bigger now */
                } else {
                    maxCode = getMaxCode();
                }
            }
            if (clearFlag > 0) {
                bitsNumber = Compress.INIT_BITS;
                maxCode = getMaxCode();
                clearFlag = 0;
            }
            size = input.readBytes(buf, bitsNumber);
            if (size <= 0) {
                return -1; /* end of file */
            }
            offset = 0;
            /* Round size down to integral number of codes */
            size = (size << 3) - (bitsNumber - 1);
        }
        rOff = offset;
        bits = bitsNumber;
                /*
                 * Get to the first byte.
                 */
        bp += rOff >> 3;
        rOff &= 7;
        /* Get first part (low order bits) */
        code = ((buf[bp++] >> rOff) & Compress.rmask[8 - rOff]) & 0xff;
        bits -= 8 - rOff;
        rOff = 8 - rOff; /* now, offset into code word */
        /* Get any 8 bit parts in the middle ( <=1 for up to 16 bits). */
        if (bits >= 8) {
            code |= (buf[bp++] & 0xff) << rOff;
            rOff += 8;
            bits -= 8;
        }
        /* high order bits. */
        //	code |= (buf[bp] & Compress.rmask[bits]) << r_off; // kmd
        // Don McCauley/kmd - IBM 02/26/98
        if (bits > 0) {
            code |= (buf[bp] & Compress.rmask[bits]) << rOff;
        }
        offset += bitsNumber;
        
        return code;
    }
}
