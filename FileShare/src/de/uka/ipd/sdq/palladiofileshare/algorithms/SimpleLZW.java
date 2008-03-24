package de.uka.ipd.sdq.palladiofileshare.algorithms;

import java.io.IOException;
import java.util.Vector;

import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;

public class SimpleLZW {

	public static void main(String[] args) throws IOException {
		SimpleLZW slzw = new SimpleLZW();
		slzw.compress(null);
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
	
	public byte[] compress(byte[] input){
		byte[] original = new byte[]{20,15,2,5,15,18,14,15,20,20,15,2,5,15,18,20,15,2,5,15,18,14,15,20};
		int lastIndex = original.length - 1;
		
		Vector<byte[]> dictionary = new Vector<byte[]>(); //am Ende verwerfen
		char[] compressed = new char[original.length];
//		int outputLength = 0;

		byte[] window = null;
		byte[] prevWindow = null;
		int leftWindowBoundIncl=0;
		int windowLength = 1;
//		byte nextByte;

//		for(int i=Byte.MIN_VALUE; i<=Byte.MAX_VALUE; i++){
//			System.out.println(i); //TODO reflect in the dictionary
//		}
//		char[] test = new char[]{0,'A','a',0xFFFF};
//		for(char c : test){
//			System.out.println(new Integer(c));
//		}
		
		
		for (int i = 0; i < original.length; i++) {
//			nextByte = original[i];
			if(windowLength==1){
				prevWindow = window;
				windowLength++;
				System.arraycopy(original, leftWindowBoundIncl, window, 0, windowLength);
				//do not output anything
				
				//this is contained in the dict "by default"...
			}else{
				if (!dictionary.contains(window)){
					dictionary.add(window);
					leftWindowBoundIncl++; //=prevWindow.length;
//					windowLength = 2;
//					
//					compressed
//					
//					
					System.out.println("Not found "+window);
//					word = word + nextChar;
//					if (i == lastIndex) {//cannot be removed if  
//						System.out.println("Last word... "+word);
//						compressed = compressed + "|" + dictionary.indexOf(word);
//					}
				} else {
					
//					System.out.println("Not found "+(word+nextChar)+", adding "+(word+nextChar)+" to compressed and "+dictionary.indexOf(word)+" to output");
//					dictionary.add(word + nextChar);
//					compressed = compressed + "|" + dictionary.indexOf(word);
//					word = nextChar + "";
				}
		}
		}

		System.out.println(compressed);
		return null;
	}

}