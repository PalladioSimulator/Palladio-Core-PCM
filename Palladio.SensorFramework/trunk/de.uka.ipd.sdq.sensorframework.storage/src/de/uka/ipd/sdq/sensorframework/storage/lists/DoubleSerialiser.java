package de.uka.ipd.sdq.sensorframework.storage.lists;

public class DoubleSerialiser implements ISerialiser {

	public long getElementLenght() {
		return 8;
	}
	
	public byte[] serialise(Object[] objects, int count){
		byte[] block = new byte[(int)(count*getElementLenght())];
		int blockPos = 0;
		for (int j = 0; j < count; j++){
			long l = Double.doubleToRawLongBits((Double)objects[j]);
			for (int i = 0; i < 8; i++) {
				block[blockPos++] = (byte)(l & 0xff);
				l = l >> 8;
			}
		}
		return block;
	}

	public Object[] deserialise(byte[] bytes){
		Double[] doubles = new Double[(int)(bytes.length / getElementLenght())];
		int blockPos = 0;
		for (int j = 0; j<doubles.length; j++){
			long l = 0;
			for (int i = 7; i >=0; i--) {
				l = l << 8;
				l |= bytes[blockPos+i] < 0 ? 256 + bytes[blockPos+i] : bytes[blockPos+i];
			}
			blockPos += 8;
			doubles[j] = Double.longBitsToDouble(l);
		}
		return doubles;
	}
	
}
