package de.uka.ipd.sdq.palladiofileshare.algorithms;

import java.util.Vector;

public class SimpleByteArrayVector extends Vector<byte[]> {

	@SuppressWarnings("unused")
	private static boolean LOUD = true;
	private static final long serialVersionUID = 1L;


	public static void main(String args[]) {
		SimpleByteArrayVector bav = new SimpleByteArrayVector(10);
		bav.test();
	}

	SimpleByteArrayVector(int size) {
		super(size);
	}

	final boolean add_custom(byte[] addedElement) {
		super.add(addedElement);
		return true;
	}

	final boolean add(byte[] addedElement, boolean verbose) {
		super.add(addedElement);
		if (verbose)
			System.out.println("Added ["
					+ SimpleLZW.convertByteArrayToString(addedElement, " ")
					+ "]");
		return true;
	}

	/**
	 * Performance bottlenecks DONE test with EXPLICIT step-by-step debugging!
	 * TODO it may be faster to compare the first byte, and only then to compare
	 * the rest! (i.e., how expensive is ".length"?)
	 * 
	 * @param o
	 * @return
	 */
	final int firstIndexOf(byte[] prmArr) {
		if (prmArr == null) {
			// if(LOUD) System.out.println("prm null -> -1");
			return -1;
		} else {
			int prmLength = prmArr.length;
			byte[] current;
			boolean containsPrm = false;
			int i = 0;
			int foundIndex = -1;
			for (; i < this.size(); i++) {
				current = this.get(i);
				if (current.length == prmLength) { // todo debug this!
					containsPrm = true;
					int j = 0;
					for (; j < prmLength; j++) {
						if (current[j] != prmArr[j]) {
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
						i = this.size();
					}
				} else {
					// if(LOUD) System.out.println("curr: diff length ->
					// skipped");
				}
			}
			return foundIndex;
		}
	}

	final void test() {
		this.add(new byte[] { 1, 2, 3 }); // should be skipped due to the
											// length
		this.add(new byte[] { 2, 3 }); // should be skipped after the first
										// byte
		this.add(new byte[] { 1, 2 }); // should be found
		this.add(new byte[] { 3, 4 }); // should not be entered at all
		System.out.println(this.firstIndexOf(new byte[] { 1, 2 }));
		// System.out.println(this.get(0).hashCode());
		// System.out.println((new byte[]{1}).hashCode());
		// System.out.println("");
		// System.out.println(this.get(0));
		// System.out.println((new byte[]{2}).hashCode());
		// System.out.println(this.contains(new byte[]{1}));
		// System.out.println(this.contains(new byte[]{2}));
		// System.out.println(this.contains(new byte[]{3}));
		// System.out.println(this.firstIndexOf(new byte[]{1}));
		// System.out.println(this.firstIndexOf(new byte[]{2}));
		// System.out.println(this.firstIndexOf(new byte[]{3}));
		// System.out.println(new byte[]{1,2,3}.hashCode());
		// System.out.println(new byte[]{1,2,3}.hashCode());
		// System.out.println(((byte[]) this.get(0)).equals(new byte[]{2}));
	}
	
	/* TODO document that unused
	final boolean contains(byte[] o) {
		if (o != null) { // TODO document
			int firstIndex = this.firstIndexOf(o);
			if (firstIndex < 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	 */
	
	/* TODO document why removed
	private boolean equals_priv(Object o) {
		if (!(o instanceof SimpleByteArrayVector)) {
			return false;
		} else {
			SimpleByteArrayVector bav = (SimpleByteArrayVector) o;
			if (bav.size() != this.size()) {
				return false;
			}
			for (int i = 0; i < this.size(); i++) {
				if (!SimpleByteArrayVector.equal(this.get(i), bav.get(i))) {
					return false;
				}
			}
			return true;
		}
	}
	 */
	
	/* TODO document why removed
	private static boolean equal(byte[] left, byte[] right) {
		if (left == null && right == null) {
			return true;
		} else if (left.length != right.length) {
			return false;
		} else {
			for (int i = 0; i < left.length; i++) {
				if (left[i] != right[i]) {
					return false;
				}
			}
			return true;
		}
	}*/
	 
}
