/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * Used 'Inner Classes' to minimize temptations of JVM exploiting low hanging
 * fruits. 'Inner classes' are defined in appendix D of the 'Java Programming
 * Language' by Ken Arnold. - We moved the class declaration, unchanged, of
 * Hash_Table to within the class declaration of Compressor. - We moved the
 * class declarations, unchanged, of De_Stack and Suffix_Table to within the
 * class declaration of Decompressor. - pre-computed trivial htab(i) to minimize
 * millions of trivial calls - Don McCauley (IBM), Kaivalya 4/16/98
 *
 * @(#)Compress.java 1.7 06/17/98 // Don McCauley/kmd - IBM 02/26/98 // getbyte
 * and getcode fixed -- kaivalya & Don compress.c - File compression ala IEEE
 * Computer, June 1984.
 *
 * Authors: Spencer W. Thomas (decvax!harpo!utah-cs!utah-gr!thomas) Jim McKie
 * (decvax!mcvax!jim) Steve Davies (decvax!vax135!petsd!peora!srd) Ken Turkowski
 * (decvax!decwrl!turtlevax!ken) James A. Woods (decvax!ihnp4!ames!jaw) Joe
 * Orost (decvax!vax135!petsd!joe)
 *
 * Algorithm from "A Technique for High Performance Data Compression", Terry A.
 * Welch, IEEE Computer Vol 17, No 6 (June 1984), pp 8-19.
 *
 * Algorithm: Modified Lempel-Ziv method (LZW). Basically finds common
 * substrings and replaces them with a variable size code. This is
 * deterministic, and can be done on the fly. Thus, the decompression procedure
 * needs no input table, but tracks the way the table was built.
 *
 * This source code is provided as is, without any express or implied warranty.
 */

package spec.benchmarks.compress_inlined;

import java.util.ArrayList;
import java.util.List;

import spec.harness.Context;

public class Compress {
    /* Defines for third byte of header */
    final static int BIT_MASK = 0x1f;
    final static int BITS = 16; /* always set to 16 for SPEC95 */
    final static int BLOCK_MASK = 0x80;
    final static int CLEAR = 256; /* table clear output code */
    final static int COMPRESS = 0;
    /*
         * the next two codes should not be changed lightly, as they must not lie
         * within the contiguous general code space.
         */
    final static int FIRST = 257; /* first free entry */
    final static int HSIZE = 69001; /* 95% occupancy */
    final static int INIT_BITS = 9; /* initial number of bits/code */
    
    final static byte lmask[] = { (byte) 0xff, (byte) 0xfe, (byte) 0xfc,
    (byte) 0xf8, (byte) 0xf0, (byte) 0xe0,
    (byte) 0xc0, (byte) 0x80, (byte) 0x00 };
    final static byte magic_header[] = { (byte) 037, (byte) 0235 }; /* 1F 9D */
    
        /*
         * Masks 0x40 and 0x20 are free. I think 0x20 should mean that there is a
         * fourth header byte (for expansion).
         */
    
        final static byte rmask[] = { (byte) 0x00, (byte) 0x01, (byte) 0x03,
    (byte) 0x07, (byte) 0x0f, (byte) 0x1f,
    (byte) 0x3f, (byte) 0x7f,	(byte) 0xff };
    final static int STACK_SZ = 8000; /* decompression stack size */
    
    final static int SUFFIX_TAB_SZ = 65536; /* 2**BITS */
    
    final static int UNCOMPRESS = 1;
	
    public static List<Long> lastResults = new ArrayList<Long>();
    
    /**
     * TODO modified by Michael
     * @param src
     * @param srcLength
     * @param action
     * @param dst
     * @return
     */
    public static OutputBuffer performAction(
    		byte[] src, //source
    		int srcLength, //source length
            int action,  //compress or uncompress
            byte[] dst) { //destination
        
        InputBuffer in = new InputBuffer(srcLength, src);
        OutputBuffer out = new OutputBuffer(dst);
        
//        if (action == COMPRESS) {
//            new Compressor(in, out).compress();
//        } else {
//            new Decompressor(in, out).decompress();
//        }
	      if (action == COMPRESS) {
	    	  Compressor c = new Compressor(in, out);
	    	  long compressionFinish;
	    	  long compressionStart = System.nanoTime();
	    	  c.compress();
	    	  compressionFinish = System.nanoTime();
	    	  long nsDuration = compressionFinish-compressionStart;
	    	  lastResults .add(nsDuration);
//	    	  Context.getOut().println(
//	    			  "MK compressing "+src.length+"(="+srcLength+") " +
//	    			  "took " + nsDuration+"ns" +
//	    			  "(="+nsDuration/1000+"us" +
//	    			  "="+nsDuration/(1000*1000)+"ms"+
//	    			  "="+((double) (nsDuration/(1000*1000*1000)))+"s)" );
	    	  Harness.sb.append(src.length+";"+
	    			  (compressionFinish-compressionStart)+"\n");
		  } else {
		      Decompressor d = new Decompressor(in, out);
	    	  long decompressionFinish;
	    	  long decompressionStart = System.nanoTime();
		      d.decompress();
	    	  decompressionFinish = System.nanoTime();
	    	  Context.getOut().println("MK decompressing "+src.length+"(="+srcLength+") took "+
	    			  (decompressionFinish-decompressionStart)+"ns");
//	    	  Harness.sb.append(src.length+";"+(decompressionFinish-decompressionStart)+"\n");
		  }
        return out;
    }
}







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



/*
 * Decompress stdin to stdout. This routine adapts to the codes in the file
 * building the "string" table on-the-fly; requiring no table to be stored in
 * the compressed file. The tables used herein are shared with those of the
 * compress() routine. See the definitions above.
 */




