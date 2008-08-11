package de.uka.ipd.sdq.sensorframework.dao.file.entities;


import de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor;
import de.uka.ipd.sdq.sensorframework.storage.lists.ISerialiser;

/**TODO document me!!!
 * @author Paul-Remis Beauvais
 *
 */
public class ParameterValueSerialiser implements ISerialiser {

//HashMap<Long, State> hashMap = new HashMap<Long, State>(); 
private int nbParameters;
	
	public ParameterValueSerialiser(ScalabilitySensor sSensor){
		nbParameters = 1;
		/*for (State s : stateSensor.getSensorStates()) {
			hashMap.put(s.getStateID(),s);
		}*/
	}
	
	public Object[] deserialise(byte[] bytes) {
		if (bytes.length < 4) {
			return new Double[0][0];
		}
		int blockPos = 0;
		int nb = 0;
		for (int i = 3; i >=0; i--) {
			nb = nb << 4;
			nb |= bytes[blockPos+i] < 0 ? 256 + bytes[blockPos+i] : bytes[blockPos+i];
		}
		blockPos += 4;
		nbParameters = nb;
		Double[][] values = new Double[(int)((bytes.length - 4)/ getElementLenght())][nbParameters];
		
		
		
		   for (int j = 0; j<values.length; j++){
			   for (int k = 0; k < nbParameters; k++) {
				long l = 0;
				for (int i = 7; i >=0; i--) {
					l = l << 8;
					l |= bytes[blockPos+i] < 0 ? 256 + bytes[blockPos+i] : bytes[blockPos+i];
				}
				blockPos += 8;
				values[j][k] = Double.valueOf(l);//hashMap.get(l);
			}
		
			//if (states[j] == null)
			//	throw new RuntimeException("State could not be deserialized as it returned null values for states.");
		}

		return values;
	}

	public long getElementLenght() {
		return 8*nbParameters;
	}

	public byte[] serialise(Object[] objects, int count) {
		
		if (count>0) { 	
			nbParameters = ((Double[])objects[0]).length;
		}
		byte[] block = new byte[(int)(count*getElementLenght()+4)];;
		int blockPos = 0;
		
		int nb = nbParameters;
		for (int i = 0; i < 4; i++) {
			block[blockPos++] = (byte)(nb & 0xff);
			nb = nb >> 4;
		}
		
		for (int j = 0; j < count; j++){
			Double[] serie = (Double[])objects[j];
			
		  
				for (int k = 0; k < nbParameters; k++) {
			
			
				
				long l = ((Double)serie[k]).longValue();
				for (int i = 0; i < 8; i++) {
					block[blockPos++] = (byte)(l & 0xff);
					l = l >> 8;
				}
			}
		}

		
		return block;
	}

	
}
