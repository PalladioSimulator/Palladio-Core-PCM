package de.uka.ipd.sdq.palladiofileshare.algorithms;

import java.util.Vector;

public class ByteArrayVector extends Vector<byte[]> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]){
		ByteArrayVector bav = new ByteArrayVector();
		bav.test();
	}
	
	public boolean add(byte[] addedElement, boolean loud){
		super.add(addedElement);
		if(loud) System.out.println("Added "+SimpleLZW.byteArrayToString(addedElement));
		return true;
	}
	
	public boolean add(byte[] addedElement){
		return this.add(addedElement, false);
	}
	
	public boolean contains(Object o){
		if(o instanceof byte[]){
			int firstIndex = this.firstIndexOf(o);
			if (firstIndex<0){
				return false;
			}else{
				return true;
			}
		}else {
			return false;
		}
	}
	
	public int firstIndexOf(Object o){
		if (o==null || !(o instanceof byte[])){
			return -1;
		}else{
			byte[] prmArr = (byte[]) o;
			byte[] current;
			boolean containsPrm = false;
			int i=0;
			int foundIndex = -1;
			for(; i< this.size(); i++){
				current = this.get(i);
				if(current.length==prmArr.length){
					int j=0;
					containsPrm = true;
					for(; j<prmArr.length; j++){
						if(current[j]!=prmArr[j]){
							containsPrm = false;
							j=prmArr.length;
						}
					}
				}
				if(containsPrm==true){
					foundIndex=i;
					i=this.size();
				}
			}
			return foundIndex;
		}
	}
	
	/**
	 * @deprecated
	 */
	public int indexOf(Object o){
		return firstIndexOf(o);
	}

	private void test() {
		this.add(new byte[]{1});
		this.add(new byte[]{1});
		this.add(new byte[]{2});
//		System.out.println(this.get(0).hashCode());
//		System.out.println((new byte[]{1}).hashCode());
//		System.out.println("");
//		System.out.println(this.get(0));
//		System.out.println((new byte[]{2}).hashCode());
		System.out.println(this.contains(new byte[]{1}));
		System.out.println(this.contains(new byte[]{2}));
		System.out.println(this.contains(new byte[]{3}));
		System.out.println(this.firstIndexOf(new byte[]{1}));
		System.out.println(this.firstIndexOf(new byte[]{2}));
		System.out.println(this.firstIndexOf(new byte[]{3}));
//		System.out.println(((byte[]) this.get(0)).equals(new byte[]{2}));
	}
}
