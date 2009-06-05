package de.uka.ipd.sdq.palladiofileshare.algorithms;

import java.io.IOException;

public class OldSimpleLZW {

	@SuppressWarnings("unused")
	private static final void arraycopy(
			byte[] src, 
			int srcPos, 
			byte[] dest, 
			int destPos, 
			int length) {
		System.out.println("Copying " + length +" bytes starting from index " + 
				srcPos + " (incl.) of array with length "+src.length);
		System.arraycopy(
				src, 
				srcPos, 
				dest, 
				destPos, 
				length);
	}
	
	/**
	 * @param input
	 * @return
	 * @deprecated because untested
	 */
	private static final char[] convertByteArrayToCharArray_MK(byte[] input, boolean verbose){
		char[] ret = new char[input.length/2]; //TODO check input size
		int i = 0;
//		int left  = 0;
//		int right = 0;
		for (; i < ret.length; i++) {
//			left = input[i]/256;
//			right = input[i]%256;
//			ret[2*i] = (byte) left;
//			ret[(2*i)+1] = (byte) right;
			ret[i] = (char) ((input[2*i]+128)*256+(input[2*i+1]+128)); 
			if(verbose) System.out.println(ret[i]+" created from ["+input[2*i]+","+input[2*i+1]+"]");
		}
		return ret;
	}
	
	/**
	 * @param input
	 * @return
	 * @deprecated because untested
	 */
	private static final int[] convertByteArrayToIntArray_MK(byte[] input, boolean verbose){
		int[] ret = new int[input.length/2]; //TODO check input size
		int i = 0;
		for (; i < ret.length; i++) {
			ret[i] = (input[2*i]+128)*256+(input[2*i+1]+128); 
			if(verbose) System.out.println(ret[i]+" created from ["+input[2*i]+","+input[2*i+1]+"]");
		}
		return ret;
	}
	
	/**Uses "my own" encoding: A=1, ..., Z=26
	 * @param input
	 * @return
	 * @deprecated because using own "standards"
	 */
	@SuppressWarnings("unused")
	private static final String convertByteArrayToLetterString_MK(byte[] input){
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length; j++) {
			sb.append((char) (64+input[j]));
		}
		return sb.toString();
	}
	
	public static final String convertByteArrayToString(byte[] input){
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length; j++) {
			sb.append((int) input[j]);//TODO research whether char would be more appropriate...
		}
		return sb.toString();
	}
	
	public static final String convertByteArrayToString(byte[] input, String separator){
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length-1; j++) {
			sb.append(input[j]+separator);//TODO research whether char would be more appropriate...
		}
		sb.append((int) input[input.length-1]);
		return sb.toString();
	}
	
	/**
	 * @param input
	 * @return
	 * @deprecated because undocumented mapping and because untested
	 */
	@SuppressWarnings("unused")
	private static final byte[] convertCharArrayToByteArray_MK(char[] input){
		byte[] ret = new byte[input.length*2];
		int i = 0;
		for (; i < input.length; i++) {
			ret[2*i] = (byte) (input[i]/256-128);
			ret[(2*i)+1] = (byte) (input[i]%256-128);
		}
		return ret;
	}
	
	/**
	 * @param input
	 * @return
	 * @deprecated because untested
	 */
	private static final byte[] convertCharArrayToByteArray_MK(char[] input, boolean verbose){
		byte[] ret = new byte[input.length*2];
		int i = 0;
//		int left  = 0;
//		int right = 0;
		for (; i < input.length; i++) {
//			left = input[i]/256;
//			right = input[i]%256;
//			ret[2*i] = (byte) left;
//			ret[(2*i)+1] = (byte) right;
			ret[2*i] = (byte) (input[i]/256-128);
			ret[(2*i)+1] = (byte) (input[i]%256-128);
			if(verbose) System.out.println(input[i]+" (aka "+((int) input[i])+ ") converted to ["+ret[2*i]+","+ret[2*i+1]+"]");
		}
		return ret;
	}
	
	@SuppressWarnings("unused")
	private static final String convertCharArrayToString(char[] input){//TODO delegate
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length; j++) {
			sb.append(input[j]);
		}
		return sb.toString();
	}
	
	private static final String convertCharArrayToString(char[] input, String separator){
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length-1; j++) {
			sb.append(input[j]+separator);
		}
		sb.append(input[input.length-1]);
		return sb.toString();
	}
	
	/**
	 * @param input
	 * @return
	 * @deprecated because unfinished
	 */
	@SuppressWarnings("unused")
	private static final byte[] convertIntArrayToByteArray_MK(int[] input, boolean verbose){
		byte[] ret = new byte[input.length*4];
		int dividerA = 256*256*256;
		int dividerB = 256*256;
		int dividerC = 256;
		int a, b, c, d;
		for (int i = 0; i < input.length; i++) {
			a = input[i]/dividerA;
			b = input[i]/dividerB;
			c = input[i]/dividerC;
			d = input[i]%dividerC;
			ret[(4*i)+0] = (byte) a;
			ret[(4*i)+1] = (byte) b;
			ret[(4*i)+2] = (byte) c;
			ret[(4*i)+3] = (byte) d;
			if(verbose) System.out.println(input[i]+" (aka "+((int) input[i])+ ") " +
					"converted to ["+a+","+b+","+c+","+d+","+"]");
		}
		return ret;
	}
	
	@SuppressWarnings("unused")
	private static final String convertIntArrayToString(int[] input){
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length; j++) {
			sb.append(input[j]);
		}
		return sb.toString();
	}
	
	private static final String convertIntArrayToString(int[] input, String separator){
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length-1; j++) {
			sb.append(input[j]+separator);
		}
		sb.append(input[input.length-1]);
		return sb.toString();
	}
	
	/**
	 * @param b
	 * @return
	 * @deprecated because statically coded and undocumented
	 */
	@SuppressWarnings("unused")
	private static final Character getCharFromByte_MK(byte b){
		if(b>0 && b<27){
			return ((char) (64+b));
		}else{
			return null;
		}
	}

	@SuppressWarnings("unused")
	private static final String intArrayToString(int[] input){
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length; j++) {
			sb.append(input[j]);
		}
		return sb.toString();
	}
	
	@SuppressWarnings("unused")
	private static final String intArrayToString(int[] input, String separator){
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length-1; j++) {
			sb.append(input[j]+separator);
		}
		sb.append(input[input.length-1]);
		return sb.toString();
	}

	/** Compresses to char array which is represented as byte array (two bytes per char).
	 * Char x is represented by tuple [(x/256-128), (x%256-128)]
	 * @param input
	 * @param verbose
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static final byte[] lzwcompress(byte[] input, int maxDictSize, boolean verbose){
		if(maxDictSize<257){
			System.out.println("dictionary makes no sense");
			return null;
		}
		int origLength = input.length;
		OldSimpleByteArrayVector dictionary = new OldSimpleByteArrayVector(maxDictSize); //am Ende verwerfen
		byte b = Byte.MIN_VALUE; 
		for(int i=0; i<256; i++){
			dictionary.add(new byte[]{b});
			b++;
		}
		int maxLengthOfDictElement = 1;
		char[] compressedChar = new char[2*input.length];
		int nextCompressedIndex = 0;
		int compressedLength = 0;

		byte[] window = new byte[]{}; //aka wc in the algorithm
		byte[] prevWindow = new byte[]{}; //aka w in the algorithm
		byte currentByte = 0; //b could be reused
		int currentByteIndex = 0;
//		Arrays.co
		
		while(currentByteIndex<origLength){//TODO remove temp
			if(currentByteIndex%1000==0/* && verbose*/) {
				System.out.print("\n1000er row "+currentByteIndex/1000+": ");
			}
			
//			System.out.print(currentByteIndex%100+" ");
//			if(verbose) System.out.println("====Step "+currentByteIndex+" =============");
			currentByte = input[currentByteIndex];
			window = new byte[prevWindow.length+1];
			for(int i=0; i<prevWindow.length; i++){
				window[i] = prevWindow[i];
			}
			window[window.length-1] = currentByte;
			if(dictionary.contains(window)){
				prevWindow = window;
			}else{
				if(dictionary.size()<maxDictSize){//TODO test
					dictionary.add(window, verbose);
					if(window.length>maxLengthOfDictElement){
						maxLengthOfDictElement = window.length; //could be increased by 1 instead of assignment, or not?
					}
				}else{
//					System.out.print("\nNot adding "+convertByteArrayToLetterString_MK(window)+" to dict");
				}
//				if (dictionary.size()>=256*256){
//					System.out.println("Dictionary too large");
//					return null;
//				}
				//this conversion may distort the decompression if too large dictionary is present
				compressedChar[nextCompressedIndex] = (char) dictionary.indexOf(prevWindow);
				nextCompressedIndex++;
				prevWindow = new byte[]{currentByte};
			}
			currentByteIndex++;
		}				
		compressedChar[nextCompressedIndex] = (char) dictionary.indexOf(prevWindow);
		compressedLength = nextCompressedIndex+1;
//		nextCompressedIndex = -1;
//		if(verbose){
			double neededBits=Math.log(dictionary.size())/Math.log(2.0D);
			int reallyNeededBits = (int) Math.ceil(neededBits);
			System.out.println("\n"+dictionary.size()+": " +
					"dict size (codable in "+reallyNeededBits+" bits)");
//		}
		

		char[] retChar = new char[compressedLength];
		//TODO eliminate by setting a static variable to length and truncating the array afterwards...		
		System.arraycopy(compressedChar, 0, retChar, 0, compressedLength);
		return convertCharArrayToByteArray_MK(retChar, verbose);
	}

	/**
	 * @param input
	 * @param verbose
	 * @return
	 * @deprecated contains int version as well...
	 */
	@SuppressWarnings("unused")
	private static final byte[] lzwcompress_old(byte[] input, boolean verbose){
/*
//		System.out.println((int) new Character('A'));
//		System.out.println(this.MK_map((byte) 1));
//		System.out.println(this.MK_map((byte) 26));
		
		byte[] original = new byte[]{20,15,2,5,15,18,14,15,20,20,15,2,5,15,18,20,15,2,5,15,18,14,15,20};
		
		if(input!=null){
			original = input;
		}
//		int lastIndex = original.length - 1;
		int origLength = original.length;
		if(verbose) System.out.println("ORIGINAL: "+convertByteArrayToString(original));
		if(verbose) System.out.println("ORIGINAL: "+convertByteArrayToLetterString_MK(original)+" (MK mapping)");
		
		OldSimpleByteArrayVector dictionary = new OldSimpleByteArrayVector(); //am Ende verwerfen
		byte b = Byte.MIN_VALUE; 
		for(int i=0; i<256; i++){
//			System.out.println("Adding "+b);
			dictionary.add(new byte[]{b});
			b++;
		}
		if(verbose) System.out.println(dictionary.size()+" dict entries");
//		System.out.println(dictionary.contains(new byte[]{20}));
		
//		char[] compressed = new char[original.length]; //TODO make this an integer array?
		int[] compressedInt = new int[2*original.length]; //TODO make it longer than necessary... Abschaetzung?
		char[] compressedChar = new char[2*original.length]; //TODO make it longer than necessary... Abschaetzung?
		int nextCompressedIndex = 0;
		int compressedLength = 0;
//		int outputLength = 0;

		byte[] window = new byte[]{}; //aka wc in the algorithm
		byte[] prevWindow = new byte[]{}; //aka w in the algorithm
		byte currentByte = 0;
		int currentByteIndex = 0;
//		int leftWindowBoundIncl=0;
//		int windowLength = 0;
//		int TEMP_outputLength=0;
		
		while(currentByteIndex<origLength){//TODO remove temp
			if(verbose) System.out.println("====Step "+currentByteIndex+" =============");
			currentByte = original[currentByteIndex];
			window = new byte[prevWindow.length+1];
			for(int i=0; i<prevWindow.length; i++){
				window[i] = prevWindow[i];
			}
			window[window.length-1] = currentByte;
			if(dictionary.contains(window)){
				if(verbose) System.out.println(convertByteArrayToString(window)+" contained in dict");
				prevWindow = window;
			}else{
				if(verbose) System.out.println(convertByteArrayToString(window)+" NOT contained in dict");
				dictionary.add(window, true);
//				if(verbose) System.out.println("TEMP: indexOf "+byteArrayToLetterString(prevWindow)+": "+dictionary.indexOf(prevWindow));
				compressedInt[nextCompressedIndex] = dictionary.indexOf(prevWindow);
				compressedChar[nextCompressedIndex] = (char) dictionary.indexOf(prevWindow);
				if(verbose) System.out.println("Output code for "+convertByteArrayToLetterString_MK(prevWindow)+": "+compressedInt[nextCompressedIndex]);
				nextCompressedIndex++;
				prevWindow = new byte[]{currentByte};
			}
			currentByteIndex++;
		}				
//		if(verbose) System.out.println("TEMP: indexOf "+byteArrayToLetterString(prevWindow)+": "+dictionary.indexOf(prevWindow));
		compressedInt[nextCompressedIndex] = dictionary.indexOf(prevWindow);
		compressedChar[nextCompressedIndex] = (char) dictionary.indexOf(prevWindow);
		if(verbose) System.out.println("Output code for "+convertByteArrayToLetterString_MK(prevWindow)+": "+compressedInt[nextCompressedIndex]);
		compressedLength = nextCompressedIndex+1;
		nextCompressedIndex = -1;
		
		if(verbose) System.out.println(compressedLength+": length of compressed data");
		if(verbose) System.out.println(convertCharArrayToString(compressedChar, " ")+": compressed data AS CHAR (UNtruncated)");
		if(verbose) System.out.println(intArrayToString(compressedInt, " ")+": compressed data AS INT (UNtruncated)");
		
		if(verbose) System.out.println(dictionary.size()+": dictionary size");
		double neededBits=Math.log(dictionary.size())/Math.log(2.0D);
		if(verbose) System.out.println(neededBits+": needed bits");
		int reallyNeededBits = (int) Math.ceil(neededBits);
		if(verbose) System.out.println(reallyNeededBits+": REALLY needed bits");

		int[] retInt = new int[compressedLength];
		char[] retChar = new char[compressedLength];
		
		System.arraycopy(compressedChar, 0, retChar, 0, compressedLength);
		System.arraycopy(compressedInt, 0, retInt, 0, compressedLength);
		if(verbose) System.out.println(convertCharArrayToString(retChar, " ")+": compressed data AS CHAR (truncated)");
		if(verbose) System.out.println(intArrayToString(retInt, " ")+": compressed data AS INT (truncated)");

		return convertIntArrayToByteArray_MK(retInt, true);
		
//
//			
//			this.arraycopy(original, leftWindowBoundIncl, window, 0, windowLength);
//			
//			
//			windowLength++;
//			window = new byte[windowLength];
//			this.arraycopy(original, leftWindowBoundIncl, window, 0, windowLength);
//			System.out.println("WINDOW: "+byteArrayToString(window));
//				System.out.println("\n"+byteArrayToString(window)+" contained in dict (left bound "+leftWindowBoundIncl+", length "+windowLength+")");
//				prevWindow = window;
//			}else{
//				System.out.println("\n"+byteArrayToString(window)+" NOT yet contained in dict (left bound "+leftWindowBoundIncl+", length "+windowLength+")");
//				System.out.println("Output: "+this.byteArrayToLetterString(prevWindow));
//				leftWindowBoundIncl+=(windowLength-1);
//				windowLength = 1;//or 1?
//			}
//			currentByteIndex++;
//		}
//		while(leftWindowBoundIncl+windowLength<=origLength && TEMP_outputLength<50){//TODO remove temp
//			System.out.println("=================");
//			windowLength++;
//			window = new byte[windowLength];
//			this.arraycopy(original, leftWindowBoundIncl, window, 0, windowLength);
//			System.out.println("WINDOW: "+byteArrayToString(window));
//			if(dictionary.contains(window)){
//				System.out.println("\n"+byteArrayToString(window)+" contained in dict (left bound "+leftWindowBoundIncl+", length "+windowLength+")");
//				prevWindow = window;
//			}else{
//				System.out.println("\n"+byteArrayToString(window)+" NOT yet contained in dict (left bound "+leftWindowBoundIncl+", length "+windowLength+")");
//				dictionary.add(window, true);
//				System.out.println("Output: "+this.byteArrayToLetterString(prevWindow));
//				leftWindowBoundIncl+=(windowLength-1);
//				windowLength = 1;//or 1?
//			}
//			TEMP_outputLength++;
//		}
*/
	return null;
	}

	public static void main(String[] args) throws IOException {
		byte[] input = new byte[]{20,15,2,5,15,18,14,15,20,20,15,2,5,15,18,20,15,2,5,15,18,14,15,20};
		System.out.println("Original data:\n"+convertByteArrayToString(input, " "));
		
		byte[] compressed = OldSimpleLZW.lzwcompress(input, 262, false);
		System.out.println("Compressed data:\n"+convertByteArrayToString(compressed, " "));
		
		char[] compressed_char = convertByteArrayToCharArray_MK(compressed, false);
		System.out.println("Compressed data as bytes converted to chars:\n"+convertCharArrayToString(compressed_char, " "));
		
		int[] compressed_int = convertByteArrayToIntArray_MK(compressed, false);
		System.out.println("Compressed data as bytes converted to pseudo-ints (coded in two bytes each) :\n"+convertIntArrayToString(compressed_int, " "));
		
//TEST OK OldSimpleLZW.convertCharArrayToByteArray_MK(new char[]{1000, 'M','i','K','u'},true);
		
//		for(char c = Character.MIN_VALUE; c<Character.MAX_VALUE; c++){
//			if(c%256==0) System.out.println("");
//			System.out.print(c/*+" "*/);
//		}
//		
//		if(1==1) return;//TODO
//		String original = "TOBEORNOTTOBEORTOBEORNOT";
//		String compressed = "";
//		String word = "";
//		char nextChar;
//		Vector<String> dictionary = new Vector<String>();
//		for(int i=0; i<0xFFFF; i++){
//			dictionary.add(((char) i)+"");
//		}
////		for
//		char[] test = new char[]{0,'A','a',0xFFFF};
//		for(char c : test){
//			System.out.println(new Integer(c));
//		}
////		System.out.println(new Integer("0xFFFF",16));
////		System.out.println(new Character());
////		Byte.MIN_VALUE;
////		BitArray
//
//		// BufferedReader in = new BufferedReader(new
//		// FileReader("dictionary.txt"));
//		// String t = in.readLine();
//		// 
//		// while (t != null)
//		// {
//		// dictionary.addElement(t);
//		// t = in.readLine();
//		// }
//		// 
//		int lastIndex = original.length() - 1;
//		for (int i = 0; i < original.length(); i++) {
//			nextChar = original.charAt(i);
//			
//			if (dictionary.contains(word + nextChar)) {
//				System.out.println("Found "+(word+nextChar));
//				word = word + nextChar;
//				if (i == lastIndex) {//cannot be removed if  
//					System.out.println("Last word... "+word);
//					compressed = compressed + "|" + dictionary.indexOf(word);
//				}
//			} else {
//				System.out.println("Not found "+(word+nextChar)+", adding "+(word+nextChar)+" to compressed and "+dictionary.indexOf(word)+" to output");
//				dictionary.add(word + nextChar);
//				compressed = compressed + "|" + dictionary.indexOf(word);
//				word = nextChar + "";
//			}
//		}
//
//		System.out.println(compressed);
	}

}