/**
 * 
 */
package org.jscience.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.unit.BaseUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import junit.framework.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.intrnal.SerializationUtil;

/**Test if serialization and deserialization of JScience is compatible with the current EDP2 implementation.
 * @author groenda
 *
 */
public class Serialization {

	@Test
	public void deserializationOfMeasure() throws IOException, ClassNotFoundException {
		 Measure m = Measure.valueOf(15.0, SI.METER);
		 String serializedString = SerializationUtil.writeObject(m);
		 Measure m2 = (Measure) SerializationUtil.readObject(serializedString);

		 Assert.assertEquals(m2.getValue(), m.getValue()); 
		 Assert.assertEquals(m2.getUnit(),m.getUnit());
	}
	
	@Test
	public void deserializationOfNonStandardUnit() throws IOException, ClassNotFoundException {
		Unit unit = new BaseUnit<Dimensionless>("Threads");
		String serializedString = SerializationUtil.writeObject(unit);
		Unit unit2 = (Unit) SerializationUtil.readObject(serializedString);
		
		Assert.assertTrue("Unit must be equal after (de-)serialization.", unit.equals(unit2));
	}
	
}
