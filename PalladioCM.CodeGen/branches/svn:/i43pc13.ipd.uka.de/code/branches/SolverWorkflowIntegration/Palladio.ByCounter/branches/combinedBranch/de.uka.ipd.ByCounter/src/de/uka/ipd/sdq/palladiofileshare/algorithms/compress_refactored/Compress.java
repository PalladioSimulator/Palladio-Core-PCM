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

package de.uka.ipd.sdq.palladiofileshare.algorithms.compress_refactored;

public /*final*/ class Compress {
    public final static int COMPRESS = 0;
    public final static int UNCOMPRESS = 1;
    
    final static int BITS = 16; /* always set to 16 for SPEC95 */
    final static int INIT_BITS = 9; /* initial number of bits/code */
    final static int HSIZE = 69001; /* 95% occupancy */
    final static int SUFFIX_TAB_SZ = 65536; /* 2**BITS */
    final static int STACK_SZ = 8000; /* decompression stack size */
    final static byte magic_header[] = { (byte) 037, (byte) 0235 }; /* 1F 9D */
    
    /* Defines for third byte of header */
    final static int BIT_MASK = 0x1f;
    final static int BLOCK_MASK = 0x80;
    
        /*
         * Masks 0x40 and 0x20 are free. I think 0x20 should mean that there is a
         * fourth header byte (for expansion).
         */
    
        /*
         * the next two codes should not be changed lightly, as they must not lie
         * within the contiguous general code space.
         */
    final static int FIRST = 257; /* first free entry */
    final static int CLEAR = 256; /* table clear output code */
    
    final static byte lmask[] = { (byte) 0xff, (byte) 0xfe, (byte) 0xfc,
    (byte) 0xf8, (byte) 0xf0, (byte) 0xe0,
    (byte) 0xc0, (byte) 0x80, (byte) 0x00 };
    
    final static byte rmask[] = { (byte) 0x00, (byte) 0x01, (byte) 0x03,
    (byte) 0x07, (byte) 0x0f, (byte) 0x1f,
    (byte) 0x3f, (byte) 0x7f,	(byte) 0xff };
    
    /** The method called by the business logic
     * @param src
     * @param srcLength
     * @param action
     * @param dst
     * @return
     */
    public static OutputBuffer performAction(
    		byte[] src, 
    		int srcLength,
            int action, 
            byte[] dst
      ) {
        
        InputBuffer in = new InputBuffer(srcLength, src);
        OutputBuffer out = new OutputBuffer(dst);
        
        if (action == COMPRESS) {
            new Compressor(in, out).compress();
        } else {
            new Decompressor(in, out).decompress();
        }
        return out;
    }
}






