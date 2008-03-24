package de.uka.ipd.sdq.palladiofileshare.algorithms;

import java.io.IOException;
import java.util.Vector;

public class SimpleLZW {

	public static void main(String[] args) throws IOException {
		SimpleLZW slzw = new SimpleLZW();
		slzw.compress(null);
		if(1==1) return;
		String original = "TOBEORNOTTOBEORTOBEORNOT";
		String compressed = "";
		String word = "";
		char nextChar;
		Vector<String> dictionary = new Vector<String>();
		for(int i=0; i<0xFFFF; i++){
			dictionary.add(((char) i)+"");
		}
//		for
		char[] test = new char[]{0,'A','a',0xFFFF};
		for(char c : test){
			System.out.println(new Integer(c));
		}
//		System.out.println(new Integer("0xFFFF",16));
//		System.out.println(new Character());
//		Byte.MIN_VALUE;
//		BitArray

		// BufferedReader in = new BufferedReader(new
		// FileReader("dictionary.txt"));
		// String t = in.readLine();
		// 
		// while (t != null)
		// {
		// dictionary.addElement(t);
		// t = in.readLine();
		// }
		// 
		int lastIndex = original.length() - 1;
		for (int i = 0; i < original.length(); i++) {
			nextChar = original.charAt(i);
			
			if (dictionary.contains(word + nextChar)) {
				System.out.println("Found "+(word+nextChar));
				word = word + nextChar;
				if (i == lastIndex) {//cannot be removed if  
					System.out.println("Last word... "+word);
					compressed = compressed + "|" + dictionary.indexOf(word);
				}
			} else {
				System.out.println("Not found "+(word+nextChar)+", adding "+(word+nextChar)+" to compressed and "+dictionary.indexOf(word)+" to output");
				dictionary.add(word + nextChar);
				compressed = compressed + "|" + dictionary.indexOf(word);
				word = nextChar + "";
			}
		}

		System.out.println(compressed);
	}
	
	public static String byteArrayToString(byte[] input){
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length; j++) {
			sb.append((int) input[j]);
		}
		return sb.toString();
	}
	
	public static String byteArrayToLetterString(byte[] input){
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < input.length; j++) {
			sb.append((char) (64+input[j]));
		}
		return sb.toString();
	}
	
	public byte[] compress(byte[] input){
//		System.out.println((int) new Character('A'));
//		System.out.println(this.MK_map((byte) 1));
//		System.out.println(this.MK_map((byte) 26));
		
		byte[] original = new byte[]{20,15,2,5,15,18,14,15,20,20,15,2,5,15,18,20,15,2,5,15,18,14,15,20};
//		int lastIndex = original.length - 1;
		int origLength = original.length;
		System.out.println("ORIGINAL: "+byteArrayToString(original));
		System.out.println("ORIGINAL: "+byteArrayToLetterString(original)+" (MK mapping)");
		
		ByteArrayVector dictionary = new ByteArrayVector(); //am Ende verwerfen
		byte b = Byte.MIN_VALUE; 
		for(int i=0; i<256; i++){
//			System.out.println("Adding "+b);
			dictionary.add(new byte[]{b});
			b++;
		}
		System.out.println(dictionary.size()+" dict entries");
//		System.out.println(dictionary.contains(new byte[]{20}));
		
		char[] compressed = new char[original.length]; //TODO make this an integer array?
//		int outputLength = 0;

		byte[] window = new byte[]{}; //aka wc in the algorithm
		byte[] prevWindow = new byte[]{}; //aka w in the algorithm
		byte currentByte = 0;
		int currentByteIndex = 0;
//		int leftWindowBoundIncl=0;
//		int windowLength = 0;
//		int TEMP_outputLength=0;

		while(currentByteIndex<origLength){//TODO remove temp
			System.out.println("====Step "+currentByteIndex+" =============");
			currentByte = original[currentByteIndex];
			window = new byte[prevWindow.length+1];
			for(int i=0; i<prevWindow.length; i++){
				window[i] = prevWindow[i];
			}
			window[window.length-1] = currentByte;
			if(dictionary.contains(window)){
				System.out.println(/*"\n"+*/byteArrayToString(window)+" contained in dict");
				prevWindow = window;
			}else{
				System.out.println(/*"\n"+*/byteArrayToString(window)+" NOT contained in dict");
				dictionary.add(window, true);
				System.out.println("TODO: output code for "+byteArrayToLetterString(prevWindow));
				prevWindow = new byte[]{currentByte};
			}
			currentByteIndex++;
		}				
		System.out.println("TODO: output code for "+byteArrayToLetterString(prevWindow));
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
		return null;
	}

	private void arraycopy(byte[] src, int srcPos, byte[] dest, int destPos, int length) {
		System.out.println("Copying " + length +" bytes starting from index " + srcPos +
				" (incl.) of array with length "+src.length);
		System.arraycopy(src, srcPos, dest, destPos, length);
		
	}
	
	private Character MK_map(byte b){
		if(b>0 && b<27){
			return ((char) (64+b));
		}else{
			return null;
		}
	}

}