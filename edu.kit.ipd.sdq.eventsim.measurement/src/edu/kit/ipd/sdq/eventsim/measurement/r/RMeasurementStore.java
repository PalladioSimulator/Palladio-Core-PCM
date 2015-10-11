package edu.kit.ipd.sdq.eventsim.measurement.r;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
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
 * capacity improves performance at the cost of higher memory consumption (this needs to be further evaluated, however).
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

	/** the total time spent in R since the last reset (or instantiation) */
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
		log.info("Saving measurements into RDS file. This can take a moment...");
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
			convertCategoricalColumnsToFactorColumns();
			conn.voidEval("mm[[length(mm)+1]] <- buffer");
		} catch (RserveException e) {
			e.printStackTrace();
		}
		processed += buffer.size;
		buffer.reset();
		long end = System.currentTimeMillis();
		rTime += end - start;
		if (log.isDebugEnabled())
			log.debug(String.format("Pushed %d measuements to R. Took %.2f seconds.", size, (end - start) / 1000.0));
	}

	private void convertCategoricalColumnsToFactorColumns() {
		try {
			conn.voidEval("buffer$what <- as.factor(buffer$what)");
			conn.voidEval("buffer$where.first.type <- as.factor(buffer$where.first.type)");
			conn.voidEval("buffer$where.first.id <- as.factor(buffer$where.first.id)");
			conn.voidEval("buffer$where.second.type <- as.factor(buffer$where.second.type)");
			conn.voidEval("buffer$where.second.id <- as.factor(buffer$where.second.id)");
			conn.voidEval("buffer$where.property <- as.factor(buffer$where.property)");
			conn.voidEval("buffer$who.type <- as.factor(buffer$who.type)");
			conn.voidEval("buffer$who.id <- as.factor(buffer$who.id)");
		} catch (RserveException e) {
			log.error("Rserve reported an error while converting categorical columns to factors", e);
		}
	}

	private void createSingleDataFrameFromBufferedDataFrames() {
		long start = System.currentTimeMillis();
		try {
			conn.voidEval("mm <- rbindlist(mm)");
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
			rList.put("where.first.type", new REXPString(buffer.whereFirstType));
			rList.put("where.first.id", new REXPString(buffer.whereFirstId));
			rList.put("where.second.type", new REXPString(buffer.whereSecondType));
			rList.put("where.second.id", new REXPString(buffer.whereSecondId));
			rList.put("where.property", new REXPString(buffer.whereProperty));
			rList.put("who.type", new REXPString(buffer.whoType));
			rList.put("who.id", new REXPString(buffer.whoId));
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
		String[] whereFirstId;
		String[] whereFirstType;
		String[] whereSecondId;
		String[] whereSecondType;
		String[] whereProperty;
		String[] whoType;
		String[] whoId;
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
			whereFirstId = new String[capacity];
			whereFirstType = new String[capacity];
			whereSecondId = new String[capacity];
			whereSecondType = new String[capacity];
			whereProperty = new String[capacity];
			whoType = new String[capacity];
			whoId = new String[capacity];
			value = new double[capacity];
			when = new double[capacity];

			contexts = new HashMap<>();
		}

		public <F extends Entity, S extends Entity> void putPair(Measurement<Pair<F, S>, ?> m) {
			F first = m.getWhere().getElement().getFirst();
			S second = m.getWhere().getElement().getSecond();
			whereFirstId[size] = toIdString(first);
			whereFirstType[size] = toTypeString(first);
			whereSecondId[size] = toIdString(second);
			whereSecondType[size] = toTypeString(second);

			whereProperty[size] = m.getWhere().getProperty();

			putCommonProperties(m);
			size++;
		}

		private String toIdString(Object o) {
			if (Entity.class.isInstance(o)) {
				return ((Entity) o).getId();
			} else if (o.getClass().getName().equals("edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource")) {
				// TODO fix hard-coded class name
				try {
					ProcessingResourceSpecification r = (ProcessingResourceSpecification) o.getClass().getMethod("getSpecification").invoke(o);
					return r.getId();
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					// indicates a programming error => throw unchecked
					throw new RuntimeException(e);
				}
			} else if (o.getClass().getName().equals("edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource")) {
				// TODO fix hard-coded class name
				try {
					PassiveResource r = (PassiveResource) o.getClass().getMethod("getSpecification").invoke(o);
					return r.getId();
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					// indicates a programming error => throw unchecked
					throw new RuntimeException(e);
				}
			} else if (o.getClass().getSuperclass().getName()
					.equals("edu.kit.ipd.sdq.eventsim.entities.EventSimEntity")) {
				// TODO fix hard-coded class name
				try {
					return o.getClass().getMethod("getEntityId").invoke(o).toString();
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					// indicates a programming error => throw unchecked
					throw new RuntimeException(e);
				}
			} else {
				// TODO refine
				return o.toString();
			}
		}

		private String toTypeString(Object o) {
			if (EObject.class.isInstance(o)) {
				return stripNamespace(((EObject) o).eClass().getInstanceClassName());

			} else {
				return stripNamespace(o.getClass().getName());
			}
		}

		private String stripNamespace(String className) {
			String[] typeSplit = className.split("\\.");
			return typeSplit[typeSplit.length - 1];
		}

		public <E> void put(Measurement<E, ?> m) {
			whereFirstId[size] = toIdString(m.getWhere().getElement());
			whereFirstType[size] = toTypeString(m.getWhere().getElement());
			whereSecondId[size] = null;
			whereSecondType[size] = null;
			whereProperty[size] = m.getWhere().getProperty();

			putCommonProperties(m);
			size++;
		}

		private <E> void putCommonProperties(Measurement<E, ?> m) {
			what[size] = m.getWhat().toString();

			for (Object o : m.getWhere().getContexts()) {
				String key = toTypeString(o);
				if (!contexts.containsKey(key)) {
					contexts.put(key, new String[capacity]);
				}
				contexts.get(key)[size] = toIdString(o);
			}

			if (m.getWho() != null) {
				whoType[size] = toTypeString(m.getWho());
				whoId[size] = toIdString(m.getWho());
			} else {
				whoType[size] = null;
				whoId[size] = null;
			}
			value[size] = m.getValue();
			when[size] = m.getWhen();
		}

		public void shrinkToSize() {
			what = shrinkArray(what);
			whereFirstId = shrinkArray(whereFirstId);
			whereFirstType = shrinkArray(whereFirstType);
			whereSecondId = shrinkArray(whereSecondId);
			whereSecondType = shrinkArray(whereSecondType);
			whereProperty = shrinkArray(whereProperty);

			whoType = shrinkArray(whoType);
			whoId = shrinkArray(whoId);
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
			// contexts map is filled sparsely, hence buffered entries are not guaranteed to be overwritten by the next
			// "buffering run" is full.
			contexts = new HashMap<>();
		}

	}

}
