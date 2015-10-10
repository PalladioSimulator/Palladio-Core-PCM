package edu.kit.ipd.sdq.eventsim.measurement.r;

import org.palladiosimulator.pcm.core.entity.Entity;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPDouble;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REXPString;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.Pair;

public class RMeasurementStore {

	private static final int BUFFER_SIZE = 100_000;

	private RConnection conn;

	private Buffer buffer;

	private int processed;

	public RMeasurementStore() {
		try {
			conn = new RConnection();
			conn.eval("tmp <- data.frame()");
		} catch (RserveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buffer = new Buffer(BUFFER_SIZE);
	}

	public <F extends Entity, S extends Entity> void putPair(Measurement<Pair<F, S>, ?> m) {
		buffer.putPair(m);
		if (buffer.isFull()) {
			pushBufferToR(buffer);
			buffer.reset();
		}
	}

	public <E> void put(Measurement<E, ?> m) {
		buffer.put(m);
		if (buffer.isFull()) {
			pushBufferToR(buffer);
			buffer.reset();
		}
	}

	public void finish() {
		buffer.shrinkToFillLevel();
		pushBufferToR(buffer);
		buffer.reset();
	}

	public void print() {
		try {
			// df = conn.eval("mm$when");
			REXP size = conn.eval("length(mm$when)");
			// System.out.println(df.asNativeJavaObject().toString());
			System.out.printf("Expecting %s measurements to be processed.\n", processed);
			System.out.printf("Measurements actually contained in R: %s\n", size.asIntegers()[0]);
		} catch (RserveException | REXPMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void pushBufferToR(Buffer buffer) {
		if (processed == 0) {
			try {
				conn.assign("mm", createDataFrameFromBuffer(buffer));
			} catch (RserveException e) {
				e.printStackTrace();
			}
		} else {
			try {
				conn.assign("tmp", createDataFrameFromBuffer(buffer));
				conn.voidEval("mm <- rbind(mm, tmp)");
			} catch (RserveException e) {
				e.printStackTrace();
			}
		}
		processed += buffer.fillLevel;
	}

	private REXP createDataFrameFromBuffer(Buffer buffer) {
		try {
			RList rList = new RList(6, true);
			rList.put("what", new REXPString(buffer.what));
			rList.put("where.element", new REXPString(buffer.whereElement));
			rList.put("where.property", new REXPString(buffer.whereProperty));
			rList.put("who", new REXPString(buffer.who));
			rList.put("value", new REXPDouble(buffer.value));
			rList.put("when", new REXPDouble(buffer.when));

			return REXP.createDataFrame(rList);
		} catch (REXPMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; // TODO
	}

	private class Buffer {

		String[] what;
		String[] whereElement;
		String[] whereProperty;
		// TODO contexts
		String[] who;
		double[] value;
		double[] when;

		/**
		 * the number of elements effectively contained in this buffer. Once this number equals the buffer size, the
		 * buffer is considered full
		 */
		int fillLevel = 0;

		final int size;

		public Buffer(int size) {
			this.size = size;

			what = new String[size];
			whereElement = new String[size];
			whereProperty = new String[size];
			who = new String[size];
			value = new double[size];
			when = new double[size];
		}

		// TODO fix code duplication
		public <F extends Entity, S extends Entity> void putPair(Measurement<Pair<F, S>, ?> m) {
			what[fillLevel] = m.getWhat().toString();
			// TODO
			whereElement[fillLevel] = m.getWhere().getElement().getFirst().getId() + ","
					+ m.getWhere().getElement().getSecond().getId();
			whereProperty[fillLevel] = m.getWhere().getProperty();
			who[fillLevel] = m.getWho().toString();
			value[fillLevel] = m.getValue();
			when[fillLevel] = m.getWhen();
			fillLevel++;
		}

		public <E> void put(Measurement<E, ?> m) {
			what[fillLevel] = m.getWhat().toString();
			if (Entity.class.isInstance(m.getWhere().getElement())) {
				whereElement[fillLevel] = ((Entity) m.getWhere().getElement()).getId();
			} else {
				whereElement[fillLevel] = m.getWhere().getElement().toString();
			}
			whereProperty[fillLevel] = m.getWhere().getProperty();
			if (m.getWho() != null) {
				who[fillLevel] = m.getWho().toString();
			} else {
				who[fillLevel] = null;
			}
			value[fillLevel] = m.getValue();
			when[fillLevel] = m.getWhen();
			fillLevel++;
		}

		public void shrinkToFillLevel() {
			what = shrinkArray(what);
			whereElement = shrinkArray(whereElement);
			whereProperty = shrinkArray(whereProperty);
			who = shrinkArray(who);
			value = shrinkArray(value);
			when = shrinkArray(when);
		}

		private String[] shrinkArray(String[] src) {
			String[] dest = new String[fillLevel];
			System.arraycopy(src, 0, dest, 0, fillLevel);
			return dest;
		}

		private double[] shrinkArray(double[] src) {
			double[] dest = new double[fillLevel];
			System.arraycopy(src, 0, dest, 0, fillLevel);
			return dest;
		}

		public boolean isFull() {
			return fillLevel == size;
		}

		public void reset() {
			fillLevel = 0;
		}

	}

}
