import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleLZW_CMD {

	private static final String[] fileNames = { 
		"notafileatall_willbeignored",
		"j0.jpg",
		"j1.jpg",
		"j2.jpg",
		"j3.jpg",
		"j4.jpg",
		"j5.jpg",
		"j6.jpg",
		"j7.jpg",
		"j8.jpg",
		"j9.jpg",
		"p0.pdf",
		"p1.pdf",
		"p2.pdf",
		"p3.pdf",
		"p4.pdf",
		"p5.pdf",
		"p6.pdf",
		"p7.pdf",
		"p8.pdf",
		"p9.pdf",
		"t0.txt",
//		"large.jpg", 	// index 0 	size 11.944.339
//		"large.zip", 	// index 1 	size 11.994.017
//		"lesstiny.txt", // index 2 	size 66 //TODO document change w.r.t. PalladioFileShare
//		"long.txt", 	// index 3 	size 1.933.032
//		"medium.jpg", 	// index 4 	size 792.492
//		"medium.txt", 	// index 5 	size 934.007
//		"medium.zip", 	// index 6 	size 852.945
//		"small.jpg", 	// index 7 	size 25.119
//		"small.txt", 	// index 8 	size 33.273
//		"small.zip", 	// index 9 	size 40.931
//		"superlong.txt",// index 10 size 9.665.311
//		"tiny.txt", 	// index 11 size 33
	};
	
	public static boolean INLINED_VERBOSE = false;

	private static final int RUN_VERSION = 0;

	// 	needs to terminate with a "/"
	private static final String uploadFilesLocation = "input/testFiles/";

//	private static final boolean VERY_CLEVER_OPTIMIZATION = true;
//
//	/**
//	 * @param input
//	 * @return
//	 * @deprecated because untested
//	 */
//	private static final int[] convertByteArrayToIntArray_MK(byte[] input,
//			boolean verbose) {
//		int[] ret = new int[input.length / 2]; // TODO check input size
//		int i = 0;
//		for (; i < ret.length; i++) {
//			ret[i] = (input[2 * i] + 128) * 256 + (input[2 * i + 1] + 128);
//			if (verbose)
//				System.out.println(ret[i] + " created from [" + input[2 * i]
//						+ "," + input[2 * i + 1] + "]");
//		}
//		return ret;
//	}
//
//	/**
//	 * Uses "my own" encoding: A=1, ..., Z=26
//	 * 
//	 * @param input
//	 * @return
//	 * @deprecated because using own "standards"
//	 */
//	private static final String convertByteArrayToLetterString_MK(byte[] input) {
//		StringBuffer sb = new StringBuffer();
//		for (int j = 0; j < input.length; j++) {
//			sb.append((char) (64 + input[j]));
//		}
//		return sb.toString();
//	}
//
//	private static final String convertByteArrayToString(byte[] input) {
//		StringBuffer sb = new StringBuffer();
//		for (int j = 0; j < input.length; j++) {
//			sb.append((int) input[j]);// TODO research whether char would be
//										// more appropriate...
//		}
//		return sb.toString();
//	}
//
//	private static final String convertByteArrayToString(byte[] input,
//			String separator) {
//		StringBuffer sb = new StringBuffer();
//		for (int j = 0; j < input.length - 1; j++) {
//			sb.append(input[j] + separator);// TODO research whether char would
//											// be more appropriate...
//		}
//		sb.append((int) input[input.length - 1]);
//		return sb.toString();
//	}

	/**
	 * @param input
	 * @return
	 * @deprecated because untested
	 */
	private static final byte[] convertCharArrayToByteArray_MK(char[] input, boolean verbose) {
		byte[] ret = new byte[input.length * 2];
		int i = 0;
		// int left = 0;
		// int right = 0;
		for (; i < input.length; i++) {
			// left = input[i]/256;
			// right = input[i]%256;
			// ret[2*i] = (byte) left;
			// ret[(2*i)+1] = (byte) right;
			ret[2 * i] = (byte) (input[i] / 256 - 128);
			ret[(2 * i) + 1] = (byte) (input[i] % 256 - 128);
			if (verbose)
				System.out.println((int) input[i]
						+ " (here in int form) converted to [" + ret[2 * i]
						+ "," + ret[2 * i + 1] + "]");
		}
		return ret;
	}

//	private static final String convertIntArrayToString(int[] input,
//			String separator) {
//		StringBuffer sb = new StringBuffer();
//		for (int j = 0; j < input.length - 1; j++) {
//			sb.append(input[j] + separator);
//		}
//		sb.append(input[input.length - 1]);
//		return sb.toString();
//	}
	
	private static final byte[] lzwcompress_inlined(byte[] input, int maxDictSize) {
		if (maxDictSize > 256 * 256) {
			System.err.println("Dictionary too large to be hold in chars... " +
					"EXITING BEFORE COMPRESSION STARTS...");
			return null;
		}
		int inputLength = input.length;

		byte[][] dictionary = new byte[maxDictSize][];
		int dictNextIndex = 0; 
		byte b = Byte.MIN_VALUE;
		for (int i = 0; i < 256; i++) {
			dictionary[i] = new byte[] { b };
			dictNextIndex++;
			b++;
		}
		int dictMaxLengthOfElement = 1;
		// at the same time, dictNextIndex can be considered as dictLength

		int compressedMaxLength = input.length;
		if (compressedMaxLength < 1000)
			compressedMaxLength *= 2;
		char[] compressedChar = new char[compressedMaxLength];
		int compressedNextIndex = 0;

		byte[] prevWindow_w = new byte[] {};
		byte[] window_wc = new byte[] {};
		int prevWindowDictPos = -1;
		int windowDictPos = -1;
		@SuppressWarnings("unused")
		int prevWindowLength = -1;
		int windowLength = -1;

		byte currentByte_c = 0;
		int currentByteIndex = 0;

		while (currentByteIndex < inputLength) {

			currentByte_c = input[currentByteIndex];

			window_wc = new byte[prevWindow_w.length + 1]; //ineffective?
			for (int i = 0; i < prevWindow_w.length; i++) {
				window_wc[i] = prevWindow_w[i]; //arraycopy more effective?
			}
			window_wc[window_wc.length - 1] = currentByte_c;
			windowLength = window_wc.length;

			if (windowLength == 1) {
				windowDictPos = window_wc[0] + 128;
			} else {
//				windowDictPos = dictionary.firstIndexOf(window_wc);
				if (window_wc == null) {
					// if(LOUD) System.out.println("prm null -> -1");
					windowDictPos = -1;
				} else {
					int prmLength = window_wc.length;
					byte[] current;
					boolean containsPrm = false;
					int i = 0;
					int foundIndex = -1;
					for (; i < dictNextIndex; i++) {
						current = dictionary[i];
						if (current.length == prmLength) { // todo debug this!
							containsPrm = true;
							int j = 0;
							for (; j < prmLength; j++) {
								if (current[j] != window_wc[j]) {
									containsPrm = false;
									// if(LOUD) System.out.println("curr["+i+"]
									// different at position "+j+" -> skipped");
									j = prmLength; // premature exit of inner loop
								}
							}
							if (containsPrm == true) {
								// if(LOUD) System.out.println("curr["+i+"] identical ->
								// returning "+i);
								foundIndex = i;
								i = dictNextIndex;
							}
						} else {
							// if(LOUD) System.out.println("curr: diff length ->
							// skipped");
						}
					}
					windowDictPos = foundIndex;
				}
			}

			if (windowDictPos != -1) {
				prevWindow_w = window_wc;
				prevWindowLength = windowLength;
				prevWindowDictPos = windowDictPos;
			} else {
				if (dictNextIndex < maxDictSize) {
					//here: different variant with comments
					dictionary[dictNextIndex]=window_wc;
					dictNextIndex++;
					if (windowLength > dictMaxLengthOfElement) {
						dictMaxLengthOfElement = windowLength;
					}
				} else {
				}

				compressedChar[compressedNextIndex] = (char) prevWindowDictPos;
				prevWindow_w = new byte[] { currentByte_c };
				prevWindowLength = 1;
				prevWindowDictPos = prevWindow_w[0] + 128;
				compressedNextIndex++;
			}
			currentByteIndex++;
		}

		compressedChar[compressedNextIndex] = (char) prevWindowDictPos;
		
		int compressedLength = compressedNextIndex + 1;

		if (INLINED_VERBOSE == true) {
			double ourNeededBits = Math.log(dictNextIndex) / Math.log(2.0D);
			int reallyNeededBits = (int) Math.ceil(ourNeededBits);

			int ourCompressedBytes = compressedLength * 2;
			double ourCompressionRate = 
				((double) ourCompressedBytes)/ ((double) inputLength);
			int reallyNeededCompressedBytes = 
				(int) Math.ceil((double) (reallyNeededBits * compressedLength) / 8.0D);
			double reallyNeededRate = 
				((double) reallyNeededCompressedBytes) / ((double) inputLength);

			System.out.println("\n> " + dictNextIndex + ": "
					+ " dict size (codable in " + reallyNeededBits + " bits)");
			System.out.println("> WE: " + compressedLength
					+ " double-byte words " + "(i.e., " + ourCompressedBytes
					+ " bytes) " + "-> compression rate " + ourCompressionRate);
			System.out.println("> BitSet: " + reallyNeededCompressedBytes
					+ " bytes " + "-> achievable compression rate "
					+ reallyNeededRate + "\n");
		}

		char[] retChar = new char[compressedLength];
//		long arraycopyStart = System.nanoTime();
		System.arraycopy(compressedChar, 0, retChar, 0, compressedLength);
//		long arraycopyStop = System.nanoTime();
//		System.out.println("arraycopy: "+(arraycopyStop-arraycopyStart));
		
//		long conversionStart = System.nanoTime();
		byte[] resultByteArray = convertCharArrayToByteArray_MK(retChar, false);
//		long conversionStop = System.nanoTime();
//		System.out.println("conversion: "+(conversionStop-conversionStart));
		
		return resultByteArray;
	}

	public static void main(String[] args) throws IOException {
		int index = 20;
		try{
			index = Integer.parseInt(args[0]);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		SimpleLZW_CMD.INLINED_VERBOSE = false; //note that this is a static field
		SimpleLZW_CMD slzw = new SimpleLZW_CMD();
//		int nrOfWarmups = 
		long nsDuration = 0L;
		try{
			nsDuration = slzw.runCompression(index);
		}catch (Exception e) {
			e.printStackTrace();
		}
		long usDuration = nsDuration / 1000;
		long msDuration = usDuration / 1000;

		try{
			System.out.println(
					nsDuration + " ns=" + 
					usDuration + " us=" + 
					msDuration + " ms " +
					"to compress "+fileNames[index]);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//		System.out.println("Command-line args: " + Arrays.toString(args));
//		byte[] input = new byte[] { 20, 15, 2, 5, 15, 18, 14, 15, 20, 20, 15,
//				2, 5, 15, 18, 20, 15, 2, 5, 15, 18, 14, 15, 20 };
//		System.out.println("\nOriginal data:\n"
//				+ convertByteArrayToString(input, " "));
//
//		long start = System.nanoTime();
//		byte[] compressed_fromInlined = SimpleLZW_CMD.lzwcompress_inlined(input, 300);
//		long stop = System.nanoTime();
//		System.out.println("Compressing small array in "+(stop-start)+" ns");
//		System.out.println("\nCompressed data from inlined version:\n"
//				+ convertByteArrayToString(compressed_fromInlined, " "));
//
//		int[] compressed_int_fromInlined = convertByteArrayToIntArray_MK(compressed_fromInlined, false);
//		System.out.println("\nCompressed data as bytes converted to pseudo-ints (coded in two bytes each) :\n"
//						+ convertIntArrayToString(compressed_int_fromInlined, " "));
	}
	
//	private static void main_old(String[] args) throws IOException {
//		System.out.println("Command-line args: " + Arrays.toString(args));
//		byte[] input = new byte[] { 20, 15, 2, 5, 15, 18, 14, 15, 20, 20, 15,
//				2, 5, 15, 18, 20, 15, 2, 5, 15, 18, 14, 15, 20 };
//		System.out.println("\nOriginal data:\n"
//				+ convertByteArrayToString(input, " "));
//
////		byte[] compressed = SimpleLZW.lzwcompress(input, 300, 0);
////		System.out.println("\nCompressed data:\n"
////				+ convertByteArrayToString(compressed, " "));
//
//		byte[] compressed_fromInlined = SimpleLZW.lzwcompress_inlined(input, 300);
//		System.out.println("\nCompressed data from inlined version:\n"
//				+ convertByteArrayToString(compressed_fromInlined, " "));
//
//		// char[] compressed_char = convertByteArrayToCharArray_MK(compressed,
//		// false);
//		// System.out.println("Compressed data as bytes converted to
//		// chars:\n"+convertCharArrayToString(compressed_char, " "));
//
////		int[] compressed_int = convertByteArrayToIntArray_MK(compressed, false);
////		System.out.println("\nCompressed data as bytes converted to pseudo-ints (coded in two bytes each) :\n"
////						+ convertIntArrayToString(compressed_int, " "));
//
//		int[] compressed_int_fromInlined = convertByteArrayToIntArray_MK(compressed_fromInlined, false);
//		System.out.println("\nCompressed data as bytes converted to pseudo-ints (coded in two bytes each) :\n"
//						+ convertIntArrayToString(compressed_int_fromInlined, " "));
//
//		// TEST OK SimpleLZW.convertCharArrayToByteArray_MK(new char[]{1000,
//		// 'M','i','K','u'},true);
//
//		// for(char c = Character.MIN_VALUE; c<Character.MAX_VALUE; c++){
//		// if(c%256==0) System.out.println("");
//		// System.out.print(c/*+" "*/);
//		// }
//		//		
//		// if(1==1) return; //TODO
//		// String original = "TOBEORNOTTOBEORTOBEORNOT";
//		// String compressed = "";
//		// String word = "";
//		// char nextChar;
//		// Vector<String> dictionary = new Vector<String>();
//		// for(int i=0; i<0xFFFF; i++){
//		// dictionary.add(((char) i)+"");
//		// }
//		// // for
//		// char[] test = new char[]{0,'A','a',0xFFFF};
//		// for(char c : test){
//		// System.out.println(new Integer(c));
//		// }
//		// // System.out.println(new Integer("0xFFFF",16));
//		// // System.out.println(new Character());
//		// // Byte.MIN_VALUE;
//		// // BitArray
//		//
//		// // BufferedReader in = new BufferedReader(new
//		// // FileReader("dictionary.txt"));
//		// // String t = in.readLine();
//		// //
//		// // while (t != null)
//		// // {
//		// // dictionary.addElement(t);
//		// // t = in.readLine();
//		// // }
//		// //
//		// int lastIndex = original.length() - 1;
//		// for (int i = 0; i < original.length(); i++) {
//		// nextChar = original.charAt(i);
//		//			
//		// if (dictionary.contains(word + nextChar)) {
//		// System.out.println("Found "+(word+nextChar));
//		// word = word + nextChar;
//		// if (i == lastIndex) {//cannot be removed if
//		// System.out.println("Last word... "+word);
//		// compressed = compressed + "|" + dictionary.indexOf(word);
//		// }
//		// } else {
//		// System.out.println("Not found "+(word+nextChar)+", adding
//		// "+(word+nextChar)+" to compressed and "+dictionary.indexOf(word)+" to
//		// output");
//		// dictionary.add(word + nextChar);
//		// compressed = compressed + "|" + dictionary.indexOf(word);
//		// word = nextChar + "";
//		// }
//		// }
//		//
//		// System.out.println(compressed);
//	}

	/*
	static final void arraycopy(byte[] src, int srcPos, byte[] dest,
			int destPos, int length) {
		System.out.println("Copying " + length + " bytes starting from index "
				+ srcPos + " (incl.) of array with length " + src.length);
		System.arraycopy(src, srcPos, dest, destPos, length);
	}
	*/

//	/**
//	 * @deprecated because not what is in SimpleTestDriver.java!
//	 */
//	private void run_MK(){ //non-final, yet calling a static method
//		byte[] input;
//		int variant = -1;
//		boolean verbose = false;
//		
//		if(variant<0 || variant>fileNames.length){
//			input = new byte[] { 20, 15, 2, 5, 15, 18, 14, 15, 20, 20, 15,
//				2, 5, 15, 18, 20, 15, 2, 5, 15, 18, 14, 15, 20 };
//			if(verbose) System.out.println("\nOriginal data:\n"
//					+ convertByteArrayToString(input, " "));
//	
//			byte[] compressed_fromInlined = SimpleLZW.lzwcompress_inlined(input, 300); //static method!
//			if(verbose) System.out.println("\nCompressed data from inlined version:\n"
//					+ convertByteArrayToString(compressed_fromInlined, " "));
//	
//			if(verbose){
//				int[] compressed_int_fromInlined = convertByteArrayToIntArray_MK(compressed_fromInlined, false);
//				System.out.println("\nCompressed data as bytes converted to pseudo-ints (coded in two bytes each) :\n"
//						+ convertIntArrayToString(compressed_int_fromInlined, " "));
//			}
//			
//			System.out.println("Compressed variant "+variant+" " +
//					"from "+ input.length+" to "+compressed_fromInlined.length);
//		}else{
//			this.runCompression(variant);
//		}
//	}
//
//	private void run_MK(int variant){ //non-final, yet calling a static method
//		System.out.println("000000000000000000000000000000000000000000000");
//		
//		byte[] input;
//		boolean verbose = false;
//		
//		if(variant==0 || variant>fileNames.length){
//			input = new byte[] { 20, 15, 2, 5, 15, 18, 14, 15, 20, 20, 15,
//				2, 5, 15, 18, 20, 15, 2, 5, 15, 18, 14, 15, 20 };
//			if(verbose) System.out.println("\nOriginal data:\n"
//					+ convertByteArrayToString(input, " "));
//	
//			byte[] compressed_fromInlined = SimpleLZW.lzwcompress_inlined(input, 300); //static method!
//			if(verbose) System.out.println("\nCompressed data from inlined version:\n"
//					+ convertByteArrayToString(compressed_fromInlined, " "));
//	
//			if(verbose){
//				int[] compressed_int_fromInlined = convertByteArrayToIntArray_MK(compressed_fromInlined, false);
//				System.out.println("\nCompressed data as bytes converted to pseudo-ints (coded in two bytes each) :\n"
//						+ convertIntArrayToString(compressed_int_fromInlined, " "));
//			}
//			
//			System.out.println("Compressed: variant "+variant+" " +
//					"from "+ input.length+" bytes " +
//					"to "+compressed_fromInlined.length+" bytes");
//		}else{
//			this.runCompression(variant);
//		}
//	}

	private final long runCompression(Integer param) {
		FileInputStream sif = null;
		String fullFileName = uploadFilesLocation + fileNames[param];
		File inputFile = new File(fullFileName);
		int length = (int) inputFile.length();
		// OutputBuffer ob = null;
		System.out.println("Compressing for option " + param + ", " +
				"i.e. file " + inputFile.getAbsolutePath() + " " +
				"(size " + length + ")");
		long start = -1L;
		long stop  = -2L;
		try {
			sif = new FileInputStream(fullFileName);
			byte[] input = new byte[length];
			// byte[] result = new byte[length];
			int readLast = 0;
			int readTotally = 0;
			do {
				readLast = sif.read(input, readTotally, (length - readTotally));
				readTotally += readLast;
			} while (readLast > 0);

//			start = System.nanoTime();
			int[] byteStatistics = new int[256];
			Arrays.fill(byteStatistics, 0);
			for (int i = 0; i < input.length; i++) {
				byteStatistics[input[i] + 128]++;
			}
			int total = 0;
			for (int i = 0; i < byteStatistics.length; i++) {
				System.out.print(byteStatistics[i] + "+");
				total += byteStatistics[i];
			}
			System.out.println("=" + total);
//			stop = System.nanoTime();
//			System.out.println((stop - start) + " ns to compute statistics");

			sif.close(); // release resources
			byte[] compressed;
			if (RUN_VERSION==0) {
				System.out.println("REMOVE THIS Running version "+
						RUN_VERSION+", i.e. dict size "+1024+" and " +
						"lzwcompress_inlined");
				start = System.nanoTime();
				// TODO can be null if early exit... -> take int case!
				compressed = SimpleLZW_CMD.lzwcompress_inlined(input,
						1024/*TODO document 256 * 256*/);
				// ob = Compress.performAction(input, length, Compress.COMPRESS,
				// result);
				stop = System.nanoTime();

			}
			long nsDuration = stop - start;
			long usDuration = nsDuration / 1000;
			long msDuration = usDuration / 1000;

			System.out.println(
					nsDuration + " ns=" + 
					usDuration + " us=" + 
					msDuration + " ms " +
					"to compress " + length + " bytes to "
					+ compressed.length + " bytes (i.e., " + compressed.length
					/ 2 + " chars)");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return stop-start;
	}

	/*
	private static final char[] convertByteArrayToCharArray_MK(byte[] input,
			boolean verbose) {
		char[] ret = new char[input.length / 2]; // TODO check input size
		int i = 0;
		// int left = 0;
		// int right = 0;
		for (; i < ret.length; i++) {
			// left = input[i]/256;
			// right = input[i]%256;
			// ret[2*i] = (byte) left;
			// ret[(2*i)+1] = (byte) right;
			ret[i] = (char) ((input[2 * i] + 128) * 256 + (input[2 * i + 1] + 128));
			if (verbose)
				System.out.println(ret[i] + " created from [" + input[2 * i]
						+ "," + input[2 * i + 1] + "]");
		}
		return ret;
	}
	*/

	/*
	private static final byte[] convertCharArrayToByteArray_MK(char[] input) {
		byte[] ret = new byte[input.length * 2];
		int i = 0;
		for (; i < input.length; i++) {
			ret[2 * i] = (byte) (input[i] / 256 - 128);
			ret[(2 * i) + 1] = (byte) (input[i] % 256 - 128);
		}
		return ret;
	}
	*/

	/*
	private static final String convertCharArrayToString(char[] input) {// TODO delegate
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length; j++) {
			sb.append(input[j]);
		}
		return sb.toString();
	}
	*/

	/*
	private static final String convertCharArrayToString(char[] input,
			String separator) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length - 1; j++) {
			sb.append(input[j] + separator);
		}
		sb.append(input[input.length - 1]);
		return sb.toString();
	}
	*/

	/*
	private static final byte[] convertIntArrayToByteArray_MK(int[] input,
			boolean verbose) {
		byte[] ret = new byte[input.length * 4];
		int dividerA = 256 * 256 * 256;
		int dividerB = 256 * 256;
		int dividerC = 256;
		int a, b, c, d;
		for (int i = 0; i < input.length; i++) {
			a = input[i] / dividerA;
			b = input[i] / dividerB;
			c = input[i] / dividerC;
			d = input[i] % dividerC;
			ret[(4 * i) + 0] = (byte) a;
			ret[(4 * i) + 1] = (byte) b;
			ret[(4 * i) + 2] = (byte) c;
			ret[(4 * i) + 3] = (byte) d;
			if (verbose)
				System.out.println(input[i] + " (aka " + ((int) input[i])
						+ ") " + "converted to [" + a + "," + b + "," + c + ","
						+ d + "," + "]");
		}
		return ret;
	}
	 */
	
	/*
	private static final String convertIntArrayToString(int[] input) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length; j++) {
			sb.append(input[j]);
		}
		return sb.toString();
	}
	*/
	
	/*
	private static final Character getCharFromByte_MK(byte b) {
		if (b > 0 && b < 27) {
			return ((char) (64 + b));
		} else {
			return null;
		}
	}
	*/

	/*
	private static final String intArrayToString(int[] input) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length; j++) {
			sb.append(input[j]);
		}
		return sb.toString();
	}
	*/

	/*
	private static final String intArrayToString(int[] input, String separator) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length - 1; j++) {
			sb.append(input[j] + separator);
		}
		sb.append(input[input.length - 1]);
		return sb.toString();
	}
	*/

	/*@deprecated contains int version as well...
	private static final byte[] lzwcompress_old(byte[] input, boolean verbose) {
		
		
		 * // System.out.println((int) new Character('A')); //
		 * System.out.println(this.MK_map((byte) 1)); //
		 * System.out.println(this.MK_map((byte) 26));
		 * 
		 * byte[] original = new
		 * byte[]{20,15,2,5,15,18,14,15,20,20,15,2,5,15,18,20,15,2,5,15,18,14,15,20};
		 * 
		 * if(input!=null){ original = input; } // int lastIndex =
		 * original.length - 1; int origLength = original.length; if(verbose)
		 * System.out.println("ORIGINAL: "+convertByteArrayToString(original));
		 * if(verbose) System.out.println("ORIGINAL:
		 * "+convertByteArrayToLetterString_MK(original)+" (MK mapping)");
		 * 
		 * SimpleByteArrayVector dictionary = new SimpleByteArrayVector(); //am
		 * Ende verwerfen byte b = Byte.MIN_VALUE; for(int i=0; i<256; i++){ //
		 * System.out.println("Adding "+b); dictionary.add(new byte[]{b}); b++; }
		 * if(verbose) System.out.println(dictionary.size()+" dict entries"); //
		 * System.out.println(dictionary.contains(new byte[]{20}));
		 *  // char[] compressed = new char[original.length]; //TODO make this
		 * an integer array? int[] compressedInt = new int[2*original.length];
		 * //TODO make it longer than necessary... Abschaetzung? char[]
		 * compressedChar = new char[2*original.length]; //TODO make it longer
		 * than necessary... Abschaetzung? int nextCompressedIndex = 0; int
		 * compressedLength = 0; // int outputLength = 0;
		 * 
		 * byte[] window = new byte[]{}; //aka wc in the algorithm byte[]
		 * prevWindow = new byte[]{}; //aka w in the algorithm byte currentByte =
		 * 0; int currentByteIndex = 0; // int leftWindowBoundIncl=0; // int
		 * windowLength = 0; // int TEMP_outputLength=0;
		 * 
		 * while(currentByteIndex<origLength){//TODO remove temp if(verbose)
		 * System.out.println("====Step "+currentByteIndex+" =============");
		 * currentByte = original[currentByteIndex]; window = new
		 * byte[prevWindow.length+1]; for(int i=0; i<prevWindow.length; i++){
		 * window[i] = prevWindow[i]; } window[window.length-1] = currentByte;
		 * if(dictionary.contains(window)){ if(verbose)
		 * System.out.println(convertByteArrayToString(window)+" contained in
		 * dict"); prevWindow = window; }else{ if(verbose)
		 * System.out.println(convertByteArrayToString(window)+" NOT contained
		 * in dict"); dictionary.add(window, true); // if(verbose)
		 * System.out.println("TEMP: indexOf
		 * "+byteArrayToLetterString(prevWindow)+":
		 * "+dictionary.indexOf(prevWindow)); compressedInt[nextCompressedIndex] =
		 * dictionary.indexOf(prevWindow); compressedChar[nextCompressedIndex] =
		 * (char) dictionary.indexOf(prevWindow); if(verbose)
		 * System.out.println("Output code for
		 * "+convertByteArrayToLetterString_MK(prevWindow)+":
		 * "+compressedInt[nextCompressedIndex]); nextCompressedIndex++;
		 * prevWindow = new byte[]{currentByte}; } currentByteIndex++; } //
		 * if(verbose) System.out.println("TEMP: indexOf
		 * "+byteArrayToLetterString(prevWindow)+":
		 * "+dictionary.indexOf(prevWindow)); compressedInt[nextCompressedIndex] =
		 * dictionary.indexOf(prevWindow); compressedChar[nextCompressedIndex] =
		 * (char) dictionary.indexOf(prevWindow); if(verbose)
		 * System.out.println("Output code for
		 * "+convertByteArrayToLetterString_MK(prevWindow)+":
		 * "+compressedInt[nextCompressedIndex]); compressedLength =
		 * nextCompressedIndex+1; nextCompressedIndex = -1;
		 * 
		 * if(verbose) System.out.println(compressedLength+": length of
		 * compressed data"); if(verbose)
		 * System.out.println(convertCharArrayToString(compressedChar, " ")+":
		 * compressed data AS CHAR (UNtruncated)"); if(verbose)
		 * System.out.println(intArrayToString(compressedInt, " ")+": compressed
		 * data AS INT (UNtruncated)");
		 * 
		 * if(verbose) System.out.println(dictionary.size()+": dictionary
		 * size"); double neededBits=Math.log(dictionary.size())/Math.log(2.0D);
		 * if(verbose) System.out.println(neededBits+": needed bits"); int
		 * reallyNeededBits = (int) Math.ceil(neededBits); if(verbose)
		 * System.out.println(reallyNeededBits+": REALLY needed bits");
		 * 
		 * int[] retInt = new int[compressedLength]; char[] retChar = new
		 * char[compressedLength];
		 * 
		 * System.arraycopy(compressedChar, 0, retChar, 0, compressedLength);
		 * System.arraycopy(compressedInt, 0, retInt, 0, compressedLength);
		 * if(verbose) System.out.println(convertCharArrayToString(retChar, "
		 * ")+": compressed data AS CHAR (truncated)"); if(verbose)
		 * System.out.println(intArrayToString(retInt, " ")+": compressed data
		 * AS INT (truncated)");
		 * 
		 * return convertIntArrayToByteArray_MK(retInt, true);
		 *  // // // this.arraycopy(original, leftWindowBoundIncl, window, 0,
		 * windowLength); // // // windowLength++; // window = new
		 * byte[windowLength]; // this.arraycopy(original, leftWindowBoundIncl,
		 * window, 0, windowLength); // System.out.println("WINDOW:
		 * "+byteArrayToString(window)); //
		 * System.out.println("\n"+byteArrayToString(window)+" contained in dict
		 * (left bound "+leftWindowBoundIncl+", length "+windowLength+")"); //
		 * prevWindow = window; // }else{ //
		 * System.out.println("\n"+byteArrayToString(window)+" NOT yet contained
		 * in dict (left bound "+leftWindowBoundIncl+", length
		 * "+windowLength+")"); // System.out.println("Output:
		 * "+this.byteArrayToLetterString(prevWindow)); //
		 * leftWindowBoundIncl+=(windowLength-1); // windowLength = 1;//or 1? // } //
		 * currentByteIndex++; // } // while(leftWindowBoundIncl+windowLength<=origLength &&
		 * TEMP_outputLength<50){//TODO remove temp //
		 * System.out.println("================="); // windowLength++; // window =
		 * new byte[windowLength]; // this.arraycopy(original,
		 * leftWindowBoundIncl, window, 0, windowLength); //
		 * System.out.println("WINDOW: "+byteArrayToString(window)); //
		 * if(dictionary.contains(window)){ //
		 * System.out.println("\n"+byteArrayToString(window)+" contained in dict
		 * (left bound "+leftWindowBoundIncl+", length "+windowLength+")"); //
		 * prevWindow = window; // }else{ //
		 * System.out.println("\n"+byteArrayToString(window)+" NOT yet contained
		 * in dict (left bound "+leftWindowBoundIncl+", length
		 * "+windowLength+")"); // dictionary.add(window, true); //
		 * System.out.println("Output:
		 * "+this.byteArrayToLetterString(prevWindow)); //
		 * leftWindowBoundIncl+=(windowLength-1); // windowLength = 1;//or 1? // } //
		 * TEMP_outputLength++; // }
		 
		return null;
	}
	 */
}