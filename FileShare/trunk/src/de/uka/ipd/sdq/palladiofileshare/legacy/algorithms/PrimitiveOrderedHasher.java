package de.uka.ipd.sdq.palladiofileshare.legacy.algorithms;

import java.util.BitSet;

public class PrimitiveOrderedHasher {
	public static final int MAX_INPUT_LENGTH = 65536;// Math.pow(2,16);
	
	/** Calls the <code>test</code> method after constructing an instance.
	 * @param args
	 */
	public static void main(String[] args){
		PrimitiveOrderedHasher poh = new PrimitiveOrderedHasher();
		poh.testBitSetComparison();
		poh.testByteArrayComparison();
	}
	
	/** Returns Integer.MIN_VALUE if first parameter is null,
	 * returns Integer.MAX_VALUE if second parameter is null but the first is not,
	 * returns 0 if BitSets are non-null and  equal, or returns a signed 
	 * non-null integer if the BitSets are non-null and different.
	 * The signed Integer is positive if the first BitSet is "larger" and 
	 * negative if the second BitSet is "larger". 
	 * The absolute value of the returned Integer indicates the position 
	 * where the two BitSet differ at first, read from left to right with 
	 * the leftmost position having index 1.
	 * @param left
	 * @param right
	 * @return
	 */
	public Integer compareBitSets(BitSet left, BitSet right){
		if(left==null){
			System.out.println("First BitSet parameter is null --> exiting");
			return Integer.MIN_VALUE;
		}else if(right==null){
			System.out.println("Second BitSet parameter is null --> exiting");
			return Integer.MAX_VALUE;
		}else if(left.size()!=right.size()){
			System.out.println("Different BitSet lengths --> exiting");
			return null;
		}else{
			for(int i=0; i<left.size(); i++){
				if(left.get(i)==right.get(i)){
					//this position is the same, do nothing...
				}else if(left.get(i)==true && right.get(i)==false){
					//TODO test!
					return (i+1); //left BitSet larger at position i -> larger at all
				}else if(left.get(i)==false && right.get(i)==true){
					//TODO test!
					return -(i+1); //left BitSet larger at position i -> larger at all
				}
			}
			return 0; //both are the same
		}
	}
	
	/** Returns BitSet of constant length <code>MAX_INPUT_LENGTH</code> which 
	 * holds a primitive hash that is an essay of a (partially) sorted hash.
	 * A bit at position i in the hash is set of the byte in the array at 
	 * position i is 128 or larger, and the bit is cleared otherwise.
	 * For arrays shorter than the hash length (i.e., MAX_INPUT_LENGTH), 
	 * the remaining bits are "padded", i.e. cleared.
	 * 
	 * @param input must have MAX_INPUT_LENGTH bytes or less
	 * @return null if input is longer than MAX_INPUT_LENGTH or if input is null, 
	 * and a <code>BitSet</code> instance as described above. 
	 */
	public BitSet getHash(byte[] input){
		BitSet bs = new BitSet(MAX_INPUT_LENGTH);
		if(input==null){
			System.out.println("Cannot hash a null input");
			return null;
		}else if(input.length>MAX_INPUT_LENGTH){
			System.out.println("String too long, maximum length allowed: "+MAX_INPUT_LENGTH);
			return null;
		}else{
			int i;
			for(i=0; i<input.length; i++){
				if(input[i]<0){
					bs.clear(i);
				}else{
					bs.set(i);
				}
			}
			for(;i<bs.size();i++){
				bs.clear(i);
			}
			return bs;
		}
	}
	
	/**
	 * A very simple test that compares various BitSets of length 2 
	 */
	public void testBitSetComparison(){
		BitSet testLeft = new BitSet(2);
		BitSet testRight = new BitSet(2);
		testLeft.set(0);
		testLeft.set(1);
		testRight.set(0);
		testRight.clear(1);
		System.out.println("Should be 2: "+this.compareBitSets(testLeft, testRight));
		testLeft.set(0);
		testLeft.clear(1);
		testRight.set(0);
		testRight.set(1);
		System.out.println("Should be -2: "+this.compareBitSets(testLeft, testRight));
		testLeft.set(0);
		testLeft.clear(1);
		testRight.clear(0);
		testRight.set(1);
		System.out.println("Should be 1: "+this.compareBitSets(testLeft, testRight));
		testLeft.clear(0);
		testLeft.clear(1);
		testRight.set(0);
		testRight.set(1);
		System.out.println("Should be -1: "+this.compareBitSets(testLeft, testRight));
		testLeft.clear(0);
		testLeft.clear(1);
		testRight.clear(0);
		testRight.clear(1);
		System.out.println("Should be 0: "+this.compareBitSets(testLeft, testRight));
		
	}
	
	public void testByteArrayComparison(){
		byte[] A = new byte[]{-100,-100};
		byte[] B = new byte[]{-100,-50};
		byte[] C = new byte[]{-100,50};
		byte[] D = new byte[]{-100,100};
		
		byte[] E = new byte[]{-50,-100};
//		byte[] F = new byte[]{-50,-50};
//		byte[] G = new byte[]{-50,50};
//		byte[] H = new byte[]{-50,100};
		
		byte[] I = new byte[]{50,-100};
//		byte[] J = new byte[]{50,-50};
//		byte[] K = new byte[]{50,50};
//		byte[] L = new byte[]{50,-100};
//		
//		byte[] M = new byte[]{100,-100};
//		byte[] N = new byte[]{100,-50};
//		byte[] O = new byte[]{100,50};
//		byte[] P = new byte[]{100,-100};
		
		System.out.println("Should be  0: "+this.compareBitSets(this.getHash(A), this.getHash(B)));
		System.out.println("Should be -2: "+this.compareBitSets(this.getHash(A), this.getHash(C)));
		System.out.println("Should be -2: "+this.compareBitSets(this.getHash(A), this.getHash(D)));
		System.out.println("Should be  0: "+this.compareBitSets(this.getHash(A), this.getHash(E)));
		System.out.println("Should be -1: "+this.compareBitSets(this.getHash(A), this.getHash(I)));
		System.out.println("Should be  0: "+this.compareBitSets(this.getHash(B), this.getHash(A)));
		System.out.println("Should be +2: "+this.compareBitSets(this.getHash(C), this.getHash(A)));
		System.out.println("Should be +2: "+this.compareBitSets(this.getHash(D), this.getHash(A)));
		System.out.println("Should be  0: "+this.compareBitSets(this.getHash(E), this.getHash(A)));
		System.out.println("Should be +1: "+this.compareBitSets(this.getHash(I), this.getHash(A)));
}
}
