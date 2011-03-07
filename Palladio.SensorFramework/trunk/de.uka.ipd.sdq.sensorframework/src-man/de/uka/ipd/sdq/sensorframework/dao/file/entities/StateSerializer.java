package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.util.HashMap;

import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.storage.lists.ISerialiser;

/**
 * @author Henning Groenda 
 * @author Steffen Becker
 */
public class StateSerializer 
implements ISerialiser<State> {

	HashMap<Long, State> hashMap = new HashMap<Long, State>(); 
	
	StateSensor mySensor = null;
	
	public StateSerializer(StateSensor stateSensor){
		this.mySensor = stateSensor;
		initSensorStateHash();
	}

	private void initSensorStateHash() {
		hashMap.clear();
		for (State s : mySensor.getSensorStates()) {
			hashMap.put(s.getStateID(),s);
		}
	}
	
	public State[] deserialise(byte[] bytes) {
		initSensorStateHash();
		
		State[] states = new State[(int)(bytes.length / getElementLength())];
		int blockPos = 0;
		for (int j = 0; j<states.length; j++){
			long l = 0;
			for (int i = 7; i >=0; i--) {
				l = l << 8;
				l |= bytes[blockPos+i] < 0 ? 256 + bytes[blockPos+i] : bytes[blockPos+i];
			}
			blockPos += 8;
			states[j] = hashMap.get(l);
			if (states[j] == null)
				throw new RuntimeException("State could not be deserialized " +
						"as it returned null values for state "+j+".");
		}
		return states;
	}

	public long getElementLength() {
		return 8;
	}

	public byte[] serialise(Object[] objects, int count) {
		byte[] block = new byte[(int)(count*getElementLength())];
		int blockPos = 0;
		for (int j = 0; j < count; j++){
			long l = ((State)objects[j]).getStateID();
			for (int i = 0; i < 8; i++) {
				block[blockPos++] = (byte)(l & 0xff);
				l = l >> 8;
			}
		}
		return block;
	}

}
