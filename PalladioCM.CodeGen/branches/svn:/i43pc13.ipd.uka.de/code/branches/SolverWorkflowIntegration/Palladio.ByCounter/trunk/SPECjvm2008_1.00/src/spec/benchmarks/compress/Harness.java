/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 * All rights reserved.
 *
 * Copyright (c) 1997,1998 Sun Microsystems, Inc. All rights reserved.
 *
 * Modified by Kaivalya M. Dixit & Don McCauley (IBM) to read input files This
 * source code is provided as is, without any express or implied warranty.
 */

package spec.benchmarks.compress;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

import spec.benchmarks.compress.OutputBuffer;
import spec.harness.Context;
import spec.harness.Launch;

public final class Harness {
	static class Source {
        static int MAX_LENGTH;
        
        private static byte[] fillBuffer(String fileName) {
//        	System.out.println("MK calling Harness:Source.fillBuffer(String fileName) (static)");
            try {
                FileInputStream sif = new FileInputStream(fileName);
                int length = (int) new File(fileName).length();
                int counter = 0;
                
                // Only allocate size of input file rather than MAX - kmd
                // If compressed file is larger than input file this allocation
                // will fail and out of bound exception will occur
                // In real lie, compress will no do any compression as no
                // space is saved.-- kaivalya
                byte[] result = new byte[length];
                
                int bytes_read;
                while ((bytes_read = sif.read(result, counter,
                        (length - counter))) > 0) {
                    counter += bytes_read;
                }
                
                sif.close(); // release resources
                
                if (counter != length) {
                    spec.harness.Context.getOut().println(
                            "ERROR reading test input file");
                }
                return result;
            } catch (IOException e) {
                e.printStackTrace(Context.getOut());
            }
            
            return null;
        }
        
        private byte[] buffer;
        
        private long crc;
        
        int length;
        
        public Source(String fileName) {
//        	System.out.println("MK calling Harness:Source.Source(String fileName) (constructor)");
            buffer = fillBuffer(fileName);
            length = buffer.length;
            MAX_LENGTH = Math.max(length, MAX_LENGTH);
            CRC32 crc32 = new CRC32();
            crc32.update(buffer, 0, length);
            crc = crc32.getValue();
        }
        
        byte[] getBuffer() {
            return buffer;
        }
        
        long getCRC() {
            return crc;
        }
        
        int getLength() {
            return length;
        }
    }

    /**
     * TODO find out why this is unstable during instrumentation
     */
    private static int MK_fileIndex = 0; //30 = tinyText with 33 bytes; number 32 has 8703 bytes

	public static Compress CB;
    
    public static byte[][] COMPRESS_BUFFERS;
    
    public static final int DATA_TYPE_COMPRESSED=3;
    
    public static final int DATA_TYPE_MIXED=2;
    
    public static final int DATA_TYPE_UNCOMPRESSED=1;
    
    public static final int DATA_TYPE_UNKNOWN=0;//TODO replace through enum?

    public static byte[][] DECOMPRESS_BUFFERS;
    
    /**
     * currently unused
     */
    public static final int LOOP_COUNT = 2; //should be 2, sometimes mixed up with MK_fileIndex
    
   	public static final String[] MK_FILES_NAMES = new String[] {
        "resources/compress/input/202.tar",
        "resources/compress/input/205.tar",
        "resources/compress/input/208.tar",
        "resources/compress/input/209.tar",
        "resources/compress/input/210.tar",
        
        "resources/compress/input/211.tar",
        "resources/compress/input/213x.tar",
        "resources/compress/input/228.tar",
        "resources/compress/input/239.tar",
        "resources/compress/input/misc.tar",
        
        "resources/compress/input/CBSE_j0.jpg",
        "resources/compress/input/CBSE_j1.jpg",
        "resources/compress/input/CBSE_j2.jpg",
        "resources/compress/input/CBSE_j3.jpg",
        "resources/compress/input/CBSE_j4.jpg",
    	
        "resources/compress/input/CBSE_j5.jpg",
        "resources/compress/input/CBSE_j6.jpg",
        "resources/compress/input/CBSE_j7.jpg",
        "resources/compress/input/CBSE_j8.jpg",
        "resources/compress/input/CBSE_j9.jpg",
    	
        "resources/compress/input/CBSE_p0.pdf",
        "resources/compress/input/CBSE_p1.pdf",
        "resources/compress/input/CBSE_p2.pdf",
        "resources/compress/input/CBSE_p3.pdf",
        "resources/compress/input/CBSE_p4.pdf",
    	
        "resources/compress/input/CBSE_p5.pdf",
        "resources/compress/input/CBSE_p6.pdf",
        "resources/compress/input/CBSE_p7.pdf",
        "resources/compress/input/CBSE_p8.pdf",
        "resources/compress/input/CBSE_p9.pdf",
    	
        "resources/compress/input/CBSEx_01.tiny.txt", //Nr. 30
        "resources/compress/input/CBSEx_02.lesstiny.txt",
        "resources/compress/input/CBSEx_03.t0.txt",
        "resources/compress/input/CBSEx_04.small.jpg",
        "resources/compress/input/CBSEx_05.small.txt",
    	
        "resources/compress/input/CBSEx_06.small.zip",
        "resources/compress/input/CBSEx_07.medium.jpg",
        "resources/compress/input/CBSEx_08.medium.zip",
        "resources/compress/input/CBSEx_09.medium.txt",
        "resources/compress/input/CBSEx_10.long.txt"/*,
    	
        "resources/compress/input/CBSEx_11.superlong.txt",
        "resources/compress/input/CBSEx_12.large.jpg",
        "resources/compress/input/CBSEx_13.large.zip"*/
    	};


   	public static final int MK_FILES_NUMBER = MK_FILES_NAMES.length;
    
    public static final int[] MK_FILES_SIZES = new int[] {
   		1157120,
   		552960,
   		3522560 ,
   		2856960,
   		92160,
   		
   		1280000,
   		3153920,
   		409600,
   		962560,
   		2457600,
   		
   		36747,
   		29510,
   		44853,
   		36654,
   		20061,
   		
   		25149,
   		9578,
   		23230,
   		29038,
   		29423,
   		
   		24789,
   		26457,
   		31762,
   		29091,
   		33265,
   		
   		37831,
   		37616,
   		30999,
   		38526,
   		40151,
   		
   		33,
   		66,
   		8703,
   		25119,
   		33273,
   		
   		40931,
   		792492,
   		852945,
   		934007,
   		1933032/*,
   		
   		9665311,
   		11944339,
   		11994017 */
   		
   	};

   	public static final int[] MK_FILES_SIZES_COMPRESSED = new int[] {
   		368657   ,
   		176887   ,
   		1551479  ,
   		1132510  ,
   		36643    ,
   		
   		591635   ,
   		931067   ,
   		173261   ,
   		688827   ,
   		1924365  ,
   		
   		52556    ,//larger than input!
   		42429    ,//dito
   		63991    ,//dito
   		51022    ,//dito
   		26600    ,//dito
   		
   		33712    ,//dito
   		12976    ,//dito
   		32808    ,//dito
   		41589    ,//dito
   		40503    ,//dito
   		
   		26619    ,//dito
   		25219    ,//insignificantly smaller than input
   		43136    ,//larger than input
   		29165    ,//dito
   		35394    ,//dito
   		
   		41711    ,//dito
   		41447    ,//dito
   		34318    ,//dito
   		47623    ,//dito
   		47246    ,//dito

   		33, //TODO
   		66,
   		8703,
   		25119,
   		33273,
   		
   		40931,
   		792492,
   		852945,
   		934007,
   		1933032/*,
   		
   		9665311, //???
   		11944339,//???
   		11994017 //???*/
   		
   	};
    
   	public static final int[] MK_FILES_TYPES = new int[] {
    	DATA_TYPE_MIXED,
    	DATA_TYPE_MIXED,
    	DATA_TYPE_MIXED,
    	DATA_TYPE_MIXED,
    	DATA_TYPE_MIXED,

    	DATA_TYPE_MIXED,
    	DATA_TYPE_MIXED,
    	DATA_TYPE_MIXED,
    	DATA_TYPE_MIXED,
    	DATA_TYPE_MIXED,
    	
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED,

    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED,

    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,

    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_UNCOMPRESSED/*,
    	
    	DATA_TYPE_UNCOMPRESSED,
    	DATA_TYPE_COMPRESSED,
    	DATA_TYPE_COMPRESSED*/
    };
    
    private static int MK_lastInputSize; //MK TODO document that it doesn't work
    
    private static int MK_lastInputType;  //MK TODO document
    
    private static int MK_lastOutputSize; //MK TODO document

	public static boolean MK_persistExecutionDurationMeasurements;

	/**
     * MK-introduced or originally from SPEC?
     */
    public static StringBuffer MK_sb = new StringBuffer();

	public static Source[] SOURCES;

	/**
     * Introduced by MK?
     * @return
     */
    public static int MK_getFileIndex(){
    	return MK_fileIndex;
    }
    
    public static int MK_getLastInputSize() {
		return MK_lastInputSize;
	}
    
    public static int MK_getLastInputType() {
		return MK_lastInputType;
	}
    
    public static int MK_getLastOutputSize() {
		return MK_lastOutputSize;
	}
    
    public static void MK_setFileIndex(int i){
    	System.out.println("spec.compress.harness: File index set to "+i);
    	MK_fileIndex = i;
    }
    
    public static void MK_setLastInputSize(int lastInputSize) {
		Harness.MK_lastInputSize = lastInputSize;
	}

	public static void MK_setLastInputType(int lastInputType) {
		Harness.MK_lastInputType = lastInputType;
	}

	public static void MK_setLastOutputSize(int lastOutputSize) {
		Harness.MK_lastOutputSize = lastOutputSize;
	}

	static void prepareBuffers() {
//    	System.out.println("MK calling Harness.prepareBuffers()");
        CB = new Compress();
        SOURCES = new Source[MK_FILES_NUMBER];
        for (int i = 0; i < MK_FILES_NUMBER; i ++) {
            SOURCES[i] = new Source(
            		Context.getSpecBasePath() //should be OK as currently "."
            		+ "/" + MK_FILES_NAMES[i]);
        }
        DECOMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
        COMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
    }

	public Harness(){
		super();
    	System.out.println("MK calling Harness.Harness() (constructor)");
		if(/*COMPRESS_BUFFERS.length==DECOMPRESS_BUFFERS.length
				&& DECOMPRESS_BUFFERS.length==FILES_NAMES.length 
				&& */MK_FILES_NAMES.length==MK_FILES_SIZES.length 
				&& MK_FILES_SIZES.length==MK_FILES_SIZES_COMPRESSED.length 
				&& MK_FILES_SIZES_COMPRESSED.length==MK_FILES_TYPES.length/*
				&& FILES_TYPES.length == SOURCES.length*/){
			//do nothing
		}else{
			System.err.println("Input files names, sizes and lengthes (compressed and uncompressed) did not match " +
					" while constructing spec.benchmarks.compress.Harness");
		}
	}

	public long inst_main(int btid) {//the btid is a thread id...
//    	Context.getOut().println("MK Entering *.compress.Harness.inst_main with thread id "+btid);
    	System.out.println("MK calling Harness.inst_main(int btid)");
        long startTime = System.currentTimeMillis();//MK TODO document: SPEC code; intentionally not replaced through nanoTime
        runCompress(btid);
        return System.currentTimeMillis() - startTime;//MK TODO document: SPEC code; intentionally not replaced through nanoTime
    }

	@SuppressWarnings("static-access")
	public void runCompress(int btid) {//btid = benchmarking thread ID
    	System.out.println("MK calling Harness.runCompress(int btid)");
//	        spec.harness.Context.getOut().println("Loop count = " + LOOP_COUNT);
//	        for (int i = 0; i < LOOP_COUNT; i++) {
//	            for (int j = 0; j < FILES_NUMBER; j++) {
//	                Source source = SOURCES[j];
//	                OutputBuffer comprBuffer, decomprBufer;
//	                comprBuffer = CB.performAction(source.getBuffer(),
//	                        source.getLength(),
//	                        CB.COMPRESS,
//	                        COMPRESS_BUFFERS[btid - 1]);
//	                decomprBufer = CB.performAction(COMPRESS_BUFFERS[btid - 1],
//	                        comprBuffer.getLength(),
//	                        CB.UNCOMPRESS,
//	                        DECOMPRESS_BUFFERS[btid - 1]);
//	                Context.getOut().print(source.getLength() + " " + source.getCRC() + " ");
//	                Context.getOut().print(comprBuffer.getLength() + comprBuffer.getCRC() + " ");
//	                Context.getOut().println(decomprBufer.getLength() + " " + decomprBufer.getCRC());
//	            }
//	        }
//    	spec.harness.Context.getOut().println("Loop count = " + LOOP_COUNT);

//    	System.out.println(
//    			">>> MK Entering *.compress.Harness.runCompress with " +
//    			"thread ID "+btid+" and source ID (aka file index) "+fileIndex);
//        System.out.println("MK FILES_NUMBER="+FILES_NUMBER+", SOURCES size="+SOURCES.length);
        System.out.println("MK Output legend: output size |" +
        		"source.getLength() " +
        		"source.getCRC() "+
//        		"(comprBuffer.getLength()+comprBuffer.getCRC()) "+
        		// MK "decomprBufer.getLength() "+
        		// MK "decomprBufer.getCRC()"+
                "");
        
        //MK for (int i = 0; i < LOOP_COUNT; i++) {
            int j = MK_fileIndex; //MK TODO changed
            //MK for (; j < FILES_NUMBER; j++) {
                if(j<0 || j>=SOURCES.length){
                	System.err.println("MK fileIndex in Harness out of range");
                	return;
                }
                Source source = SOURCES[j];
                OutputBuffer comprBuffer;//TODO make sure the right thing was imported...
                System.out.println("MK length of source "+j+": "+source.length);
                //MK OutputBuffer decomprBufer;
                comprBuffer = CB.performAction(
                		source.getBuffer(),         //input for compression
                        source.getLength(),         //length of input for compression
                        CB.COMPRESS,                //i.e. "compress!"
                        COMPRESS_BUFFERS[btid - 1]); //target for compressed data
                /* MK
                 decomprBufer = CB.performAction(
                		COMPRESS_BUFFERS[btid - 1],    //input for decompression
                        comprBuffer.getLength(),       //length of input for decompression
                        CB.UNCOMPRESS,                 //i.e. "decompress!"
                        DECOMPRESS_BUFFERS[btid - 1]); //target for compressed data
                 */
                System.out.print("MK comprBuffer.getLength()="+comprBuffer.getLength()+" | ");
                System.out.print(source.getLength() + " ");
                System.out.print(source.getCRC() + " ");
//                System.out.print(comprBuffer.getLength() + comprBuffer.getCRC() + " ");
                System.out.println(/*decomprBufer.getLength() + " " + decomprBufer.getCRC()+*/"");
                Harness.MK_setLastInputSize(source.getLength());
                Harness.MK_setLastOutputSize(comprBuffer.getLength());
                Harness.MK_setLastInputType(Harness.MK_FILES_TYPES[Harness.MK_fileIndex]);

            //MK }
        //MK }
//        System.out.println("\nMK summary for CSV file: \n"+MK_sb.toString());
//        MK_sb.delete(0,MK_sb.length()-1);
    }
}

