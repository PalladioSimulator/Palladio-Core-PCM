/**
 * 
 */
package de.uka.ipd.sdq.edp2.local.file;


/**Serializer for long datatypes.
 * @author groenda
 */
public class LongSerializer implements Serializer<Long> {

    @Override
	public Long[] deserialise(byte[] bytes) {
		Long[] longs = new Long[(int)(bytes.length / getElementLength())];
		int blockPos = 0;
		for (int j = 0; j<longs.length; j++){
			long l = 0;
			for (int i = 7; i >=0; i--) {
				l = l << 8;
				l |= bytes[blockPos+i] < 0 ? 256 + bytes[blockPos+i] : bytes[blockPos+i];
			}
			blockPos += 8;
			longs[j] = l;
		}
		return longs;
	}

	@Override
	public long getElementLength() {
		return 8;
	}

	@Override
	public byte[] serialise(Object[] objects, int count) {
		byte[] block = new byte[(int)(count*getElementLength())];
		int blockPos = 0;
		for (int j = 0; j < count; j++){
			long l = (Long) objects[j];
			for (int i = 0; i < 8; i++) {
				block[blockPos++] = (byte)(l & 0xff);
				l = l >> 8;
			}
		}
		return block;
	}

}
