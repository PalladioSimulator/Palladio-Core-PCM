package edu.kit.ipd.sdq.eventsim.measurement.r;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
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

/**
 * Stores {@link Measurement}s into R using Rserve (for details on Rserve see https://rforge.net/Rserve).
 * <p>
 * Measurements are buffered and sent to R as a batch once the buffer size reaches its capacity. Increasing the buffer
 * capacity improves performance at the cost of higher memory consumption.
 * 
 * @author Philipp Merkle
 *
 */
public class RMeasurementStore {

	private static final Logger log = Logger.getLogger(RMeasurementStore.class);

	private static final int BUFFER_CAPACITY = 100_000;

	private RConnection conn;

	private Buffer buffer;

	/** the number of measurements processed since the last reset (or instantiation) */
	private int processed;

	/** the total time spent in R */
	private long rTime;

	public RMeasurementStore() {
		try {
			conn = new RConnection();
			conn.voidEval("library(data.table)");
		} catch (RserveException e) {
			log.error("Rserve reported an error in initialization. Check if the package \"data.table\" is "
					+ "installed in R.", e);
		}
		buffer = new Buffer(BUFFER_CAPACITY);
	}

	public <F extends Entity, S extends Entity> void putPair(Measurement<Pair<F, S>, ?> m) {
		buffer.putPair(m);
		if (buffer.isFull()) {
			pushBufferToR(buffer);
		}
	}

	public <E> void put(Measurement<E, ?> m) {
		buffer.put(m);
		if (buffer.isFull()) {
			pushBufferToR(buffer);
		}
	}

	public void finish() {
		buffer.shrinkToSize();
		pushBufferToR(buffer);
		createSingleDataFrameFromBufferedDataFrames();
		storeRDS();
		log.info(String.format("Finished R processing. Total time spent in R: %.2f seconds.", rTime / 1000.0));

		// clean up
		buffer = new Buffer(BUFFER_CAPACITY); // restore buffer to initial (non-shrinked) size
		processed = 0;
		rTime = 0;
	}

	private void storeRDS() {
		long start = System.currentTimeMillis();
		try {
			conn.voidEval("saveRDS(mm, 'D:/test.rds')");
		} catch (RserveException e) {
			log.error("Rserve reported an error while saving measurements to RDS file.", e);
		}
		long end = System.currentTimeMillis();
		rTime += end - start;
		log.info(String.format("Saved measurements into RDS file. Took %.2f seconds.", (end - start) / 1000.0));
	}

	public void print() {
		try {
			REXP size = conn.eval("length(mm$when)");
			System.out.printf("Expecting %s measurements to be processed.\n", processed);
			System.out.printf("Measurements actually contained in R: %s\n", size.asIntegers()[0]);

			// String s = conn.eval("paste(capture.output(print(mm[1:100,])),collapse='\\n')").asString();
			// System.out.println(s);
		} catch (RserveException | REXPMismatchException e) {
			e.printStackTrace();
		}
	}

	private void pushBufferToR(Buffer buffer) {
		long start = System.currentTimeMillis();
		int size = buffer.size;
		if (processed == 0) {
			try {
				conn.voidEval("mm <- list()");
			} catch (RserveException e) {
				e.printStackTrace();
			}
		}

		try {
			conn.assign("buffer", createDataFrameFromBuffer(buffer));
			conn.voidEval("mm[[length(mm)+1]] <- buffer");
		} catch (RserveException e) {
			e.printStackTrace();
		}
		processed += buffer.size;
		buffer.reset();
		convertCategoricalColumnsToFactorColumns();
		long end = System.currentTimeMillis();
		rTime += end - start;
		if (log.isDebugEnabled())
			log.debug(String.format("Pushed %d measuements to R. Took %.2f seconds.", size, (end - start) / 1000.0));
	}

	private void convertCategoricalColumnsToFactorColumns() {
		try {
			conn.voidEval("buffer$what <- as.factor(buffer$what)");
			conn.voidEval("buffer$where.element <- as.factor(buffer$where.element)");
			conn.voidEval("buffer$where.property <- as.factor(buffer$where.property)");
			conn.voidEval("buffer$who <- as.factor(buffer$who)");
		} catch (RserveException e) {
			log.error("Rserve reported an error while converting categorical columns to factors", e);
		}
	}

	private void createSingleDataFrameFromBufferedDataFrames() {
		long start = System.currentTimeMillis();
		try {
			conn.voidEval("mm<-rbindlist(mm)");
		} catch (RserveException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		rTime += end - start;
		log.info(String.format("Merged buffers into single dataframe. Took %.2f seconds.", (end - start) / 1000.0));
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

			for (Entry<String, String[]> context : buffer.contexts.entrySet()) {
				rList.put(context.getKey(), new REXPString(context.getValue()));
			}
			return REXP.createDataFrame(rList);
		} catch (REXPMismatchException e) {
			// indicates a programming error => throw unchecked
			throw new RuntimeException(e);
		}
	}

	private class Buffer {

		String[] what;
		String[] whereElement;
		String[] whereProperty;
		String[] who;
		double[] value;
		double[] when;

		Map<String, String[]> contexts;

		/**
		 * the number of elements effectively contained in this buffer. Once this number equals the buffer size, the
		 * buffer is considered full
		 */
		int size = 0;

		final int capacity;

		public Buffer(int capacity) {
			this.capacity = capacity;

			what = new String[capacity];
			whereElement = new String[capacity];
			whereProperty = new String[capacity];
			who = new String[capacity];
			value = new double[capacity];
			when = new double[capacity];

			contexts = new HashMap<>();
		}

		public <F extends Entity, S extends Entity> void putPair(Measurement<Pair<F, S>, ?> m) {
			whereElement[size] = m.getWhere().getElement().getFirst().getId() + ","
					+ m.getWhere().getElement().getSecond().getId();
			whereProperty[size] = m.getWhere().getProperty();

			putCommonProperties(m);
			size++;
		}

		public <E> void put(Measurement<E, ?> m) {
			if (Entity.class.isInstance(m.getWhere().getElement())) {
				whereElement[size] = ((Entity) m.getWhere().getElement()).getId();
			} else {
				whereElement[size] = m.getWhere().getElement().toString();
			}
			whereProperty[size] = m.getWhere().getProperty();

			putCommonProperties(m);
			size++;
		}

		private <E> void putCommonProperties(Measurement<E, ?> m) {
			what[size] = m.getWhat().toString();

			for (Object o : m.getWhere().getContexts()) {
				String key = o.getClass().getSimpleName();
				if (!contexts.containsKey(key)) {
					contexts.put(key, new String[capacity]);
				}
				contexts.get(key)[size] = ((Entity) o).getId();
			}

			if (m.getWho() != null) {
				who[size] = m.getWho().toString();
			} else {
				who[size] = null;
			}
			value[size] = m.getValue();
			when[size] = m.getWhen();
		}

		public void shrinkToSize() {
			what = shrinkArray(what);
			whereElement = shrinkArray(whereElement);
			whereProperty = shrinkArray(whereProperty);

			who = shrinkArray(who);
			value = shrinkArray(value);
			when = shrinkArray(when);

			for (String key : contexts.keySet()) {
				contexts.put(key, shrinkArray(contexts.get(key)));
			}
		}

		private String[] shrinkArray(String[] src) {
			String[] dest = new String[size];
			System.arraycopy(src, 0, dest, 0, size);
			return dest;
		}

		private double[] shrinkArray(double[] src) {
			double[] dest = new double[size];
			System.arraycopy(src, 0, dest, 0, size);
			return dest;
		}

		public boolean isFull() {
			return size == capacity;
		}

		public void reset() {
			size = 0;
		}

	}

}
