package de.uka.ipd.sdq.edp2.models.binary;

import java.util.List;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

/**
 * Interface to abstract lists of measurements which are persisted in some kind of binary format.
 * @author groenda
 * @author S. Becker
 * @param <V> Value type of the measurements to be stored. Most often used values are Double or Long
 * @param <Q> Quantity to be stored, see {@link Quantity}
 */
public interface BinaryMeasurementsList<V, Q extends Quantity> extends List<Measure<V, Q>> {
}
