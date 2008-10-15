package de.uka.ipd.sdq.sensorframework.storage.lists;

/**
 * A serialiser to serialise doubles
 * @author Steffen Becker
 */
public class DoubleSerialiser implements ISerialiser<Double> {

	public long getElementLength() {
		return 8;
	}
	
	public byte[] serialise(Double[] objects, int count){
		byte[] block = new byte[(int)(count*getElementLength())];
		int blockPos = 0;
		for (int j = 0; j < count; j++){
			long l = Double.doubleToRawLongBits(objects[j]);
			for (int i = 0; i < 8; i++) {
				block[blockPos++] = (byte)(l & 0xff);
				l = l >> 8;
			}
		}
		return block;
	}

	public Double[] deserialise(byte[] bytes){
		Double[] doubles = new Double[(int)(bytes.length / getElementLength())];
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
