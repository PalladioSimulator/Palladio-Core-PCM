/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 * All rights reserved.
 *
 * Copyright (c) 1997,1998 Sun Microsystems, Inc. All rights reserved.
 *
 * Modified by Kaivalya M. Dixit & Don McCauley (IBM) to read input files This
 * source code is provided as is, without any express or implied warranty.
 */

package spec.benchmarks.compress_inlined;


import spec.harness.Context;
import spec.harness.Launch;

public class Harness {
	public Harness(){
		super();
		if(/*COMPRESS_BUFFERS.length==DECOMPRESS_BUFFERS.length
				&& DECOMPRESS_BUFFERS.length==FILES_NAMES.length 
				&& */FILES_NAMES.length==FILES_SIZES.length 
				&& FILES_SIZES.length==FILES_SIZES_COMPRESSED.length 
				&& FILES_SIZES_COMPRESSED.length==FILES_TYPES.length/*
				&& FILES_TYPES.length == SOURCES.length*/){
			//do nothing
		}else{
			System.err.println("Shit happened while constructing " +
					"spec.benchmarks.compress.Harness");
		}
	}

	public static Compress CB;
    
    public static byte[][] COMPRESS_BUFFERS;
    
    public static final int DATA_TYPE_COMPRESSED=3;
    
    public static final int DATA_TYPE_MIXED=2;
    
    public static final int DATA_TYPE_UNCOMPRESSED=1;

    public static final int DATA_TYPE_UNKNOWN=0;//TODO replace through enum?
    
    public static byte[][] DECOMPRESS_BUFFERS;
    
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
    	
        "resources/compress/input/CBSEx_01.tiny.txt",
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

   	public static final int FILES_NUMBER = FILES_NAMES.length;


   	public static final int[] FILES_SIZES = new int[] {
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
    
    /**
     * TODO find out why this is unstable during instrumentation
     */
    private static int fileIndex = 30; //30 = tinyText with 33 bytes

   	public static final int[] FILES_SIZES_COMPRESSED = new int[] {
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
   		
   		9665311,
   		11944339,
   		11994017 */
   		
   	};
    
   	public static final int[] FILES_TYPES = new int[] {
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
    
    private static int lastInputSize; //MK TODO document that it doesn't works
    
    private static int lastInputType;  //MK TODO document
    
    private static int lastOutputSize; //MK TODO document

	/**
     * currently unused
     */
    public static final int LOOP_COUNT = 2;

	/**
     * MK-introduced or originally from SPEC?
     */
    public static StringBuffer sb = new StringBuffer();

	public static Source[] SOURCES;
    
    /**
     * Introduced by MK?
     * @return
     */
    public static int getFileIndex(){
    	return fileIndex;
    }
    
    public static int getLastInputSize() {
		return lastInputSize;
	}
    
    public static int getLastInputType() {
		return lastInputType;
	}
    
    public static int getLastOutputSize() {
		return lastOutputSize;
	}
    
    static void prepareBuffers() {
        CB = new Compress();
        SOURCES = new Source[FILES_NUMBER];
        for (int i = 0; i < FILES_NUMBER; i ++) {
            SOURCES[i] = new Source(
            		Context.getSpecBasePath() //should be OK as currently "."
            		+ "/" + FILES_NAMES[i]);
        }
        DECOMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
        COMPRESS_BUFFERS = new byte[Launch.currentNumberBmThreads][Source.MAX_LENGTH];
    }

	public static void setFileIndex(int i){
    	System.out.println("spec.compress.harness: File index set to "+i);
    	fileIndex = i;
    }

	public static void setLastInputSize(int lastInputSize) {
		Harness.lastInputSize = lastInputSize;
	}

	public static void setLastInputType(int lastInputType) {
		Harness.lastInputType = lastInputType;
	}

	public static void setLastOutputSize(int lastOutputSize) {
		Harness.lastOutputSize = lastOutputSize;
	}

	public long inst_main(int btid) {
//    	Context.getOut().println("MK Entering *.compress.Harness.inst_main with thread id "+btid);
        long startTime = System.currentTimeMillis();//MK TODO document: intentionally not replaced through nanoTime
        runCompress(btid);
        return System.currentTimeMillis() - startTime;//MK TODO document: intentionally not replaced through nanoTime
    }

	@SuppressWarnings("static-access")
	public void runCompress(int btid) {
//    	spec.harness.Context.getOut().println("Loop count = " + LOOP_COUNT);

//    	System.out.println(
//    			">>> MK Entering *.compress.Harness.runCompress with " +
//    			"thread ID "+btid+" and source ID (aka file index) "+fileIndex);
//        System.out.println("MK FILES_NUMBER="+FILES_NUMBER+", SOURCES size="+SOURCES.length);
        System.out.println("MK Output legend: output size|" +
        		"source.getLength() " +
        		"source.getCRC() "+
        		"(comprBuffer.getLength()+comprBuffer.getCRC()) "+
        		// MK "decomprBufer.getLength() "+
        		// MK "decomprBufer.getCRC()"+
                "");
        
        //MK for (int i = 0; i < LOOP_COUNT; i++) {
            int j = fileIndex; //MK TODO changed
            //MK for (; j < FILES_NUMBER; j++) {
                if(j<0 || j>=SOURCES.length){
                	System.err.println("fileIndex in Harness out of range");
                	return;
                }
                Source source = SOURCES[j];
                System.out.println(">>>MK length of source "+j+": "+source.length);
                OutputBuffer comprBuffer;
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
                Context.getOut().print("MK comprBuffer.getLength()="+comprBuffer.getLength()+" | ");
                Context.getOut().print(source.getLength() + " " + source.getCRC() + " ");
                Context.getOut().print(comprBuffer.getLength() + comprBuffer.getCRC() + " ");
                Context.getOut().println(/*decomprBufer.getLength() + " " + decomprBufer.getCRC()+*/"");
                Harness.setLastInputSize(source.getLength());
                Harness.setLastOutputSize(comprBuffer.getLength());
                Harness.setLastInputType(Harness.FILES_TYPES[Harness.fileIndex]);

            //MK }
        //MK }
        System.out.println("\nMK summary for CSV file: \n"+sb.toString());
        sb.delete(0,sb.length()-1);
    }
}

