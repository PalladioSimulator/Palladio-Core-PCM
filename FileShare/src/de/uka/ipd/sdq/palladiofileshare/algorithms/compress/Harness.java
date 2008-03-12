/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 * All rights reserved.
 *
 * Copyright (c) 1997,1998 Sun Microsystems, Inc. All rights reserved.
 *
 * Modified by Kaivalya M. Dixit & Don McCauley (IBM) to read input files This
 * source code is provided as is, without any express or implied warranty.
 */

package de.uka.ipd.sdq.palladiofileshare.algorithms.compress;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

//import spec.harness.Context;
//import spec.harness.Launch;

public final class Harness {
    public static final String[] FILES_NAMES = new String[] {
        "resources/compress/input/202.tar",
        "resources/compress/input/205.tar",
        "resources/compress/input/208.tar",
        "resources/compress/input/209.tar",
        "resources/compress/input/210.tar",
        "resources/compress/input/211.tar",
        "resources/compress/input/213x.tar",
        "resources/compress/input/228.tar",
        "resources/compress/input/239.tar",
        "resources/compress/input/misc.tar"};
    
    public static final int FILES_NUMBER = FILES_NAMES.length;
    public static final int LOOP_COUNT = 2;
    public static Source[] SOURCES;
    public static byte[][] COMPRESS_BUFFERS;
    public static byte[][] DECOMPRESS_BUFFERS;
    public static Compress CB;
    
    public void runCompress(int btid) {
        //spec.harness.Context.getOut().println("Loop count = " + LOOP_COUNT);
        for (int i = 0; i < LOOP_COUNT; i++) {
            for (int j = 0; j < FILES_NUMBER; j++) {
                Source source = SOURCES[j];
                OutputBuffer comprBuffer, decomprBufer;
                comprBuffer = CB.performAction(source.getBuffer(),
                        source.getLength(),
                        CB.COMPRESS,
                        COMPRESS_BUFFERS[btid - 1]);
                decomprBufer = CB.performAction(COMPRESS_BUFFERS[btid - 1],
                        comprBuffer.getLength(),
                        CB.UNCOMPRESS,
                        DECOMPRESS_BUFFERS[btid - 1]);
                //Context.getOut().print(source.getLength() + " " + source.getCRC() + " ");
                //Context.getOut().print(comprBuffer.getLength() + comprBuffer.getCRC() + " ");
                //Context.getOut().println(decomprBufer.getLength() + " " + decomprBufer.getCRC());
            }
        }
    }
    
    public long inst_main(int btid) {
        long startTime = System.currentTimeMillis();
        runCompress(btid);
        return System.currentTimeMillis() - startTime;
    }
    
    static void prepareBuffers() {
        CB = new Compress();
        SOURCES = new Source[FILES_NUMBER];
        for (int i = 0; i < FILES_NUMBER; i ++) {
            //SOURCES[i] = new Source(Context.getSpecBasePath() + "/" + FILES_NAMES[i]);
        	SOURCES[i] = new Source("/" + FILES_NAMES[i]);
        }
        //DECOMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
        //COMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
        DECOMPRESS_BUFFERS = new byte[20][Source.MAX_LENGTH];
        COMPRESS_BUFFERS = new byte[20][Source.MAX_LENGTH];

    }
    

}

