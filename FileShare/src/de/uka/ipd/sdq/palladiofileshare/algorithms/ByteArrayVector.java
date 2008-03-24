package de.uka.ipd.sdq.palladiofileshare.algorithms;

import java.util.Vector;

public class ByteArrayVector extends Vector<byte[]> {
	public boolean contains(Object o){
		if(o instanceof byte[]){
			byte[] prmArr = (byte[]) o;
			byte[] current;
			boolean containsPrm = false;
			int i=0;
			for(; i< this.size(); i++){
				current = this.get(i);
				if(current.length==prmArr.length){
					int j=0;
					containsPrm = true;
					for(; j<prmArr.length; j++){
						if(current[j]!=prmArr[j]){
							containsPrm = false;
						}
					}
				}
				if(containsPrm==true) i=this.size();
			}
			return containsPrm;
		}else {
			return false;
		}
	}
	
	public static void main(String args[]){
		ByteArrayVector bav = new ByteArrayVector();
		bav.test();
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
		System.out.println(this.contains(new byte[]{3}));
//		System.out.println(((byte[]) this.get(0)).equals(new byte[]{2}));
	}
}
