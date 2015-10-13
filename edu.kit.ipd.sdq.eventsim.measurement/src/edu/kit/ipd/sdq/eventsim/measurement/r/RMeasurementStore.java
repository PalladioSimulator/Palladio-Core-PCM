package edu.kit.ipd.sdq.eventsim.measurement.r;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
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
 * capacity improves performance at the cost of higher memory consumption (this needs to be further evaluated, however).
 * 
 * @author Philipp Merkle
 *
 */
public class RMeasurementStore {

	private static final Logger log = Logger.getLogger(RMeasurementStore.class);

	private static final int BUFFER_CAPACITY = 10_000;

	private RConnection conn;

	private Buffer buffer;

	/** the number of measurements processed since the last reset (or instantiation) */
	private int processed;

	/** the total time spent in R since the last reset (or instantiation) */
	private long rTime;

	private Map<Class<? extends Object>, Function<Object, String>> idExtractorMap;

	private BlockingQueue<RJob> rJobQueue;

	private Thread rJobProcessor;

	private int bufferNumber;

	public RMeasurementStore() {
		idExtractorMap = new HashMap<>();
		rJobQueue = new LinkedBlockingQueue<>();
		rJobProcessor = new Thread(new RJobProcessor(rJobQueue));
		rJobProcessor.start();
		try {
			conn = new RConnection();
			conn.voidEval("library(data.table)");
		} catch (RserveException e) {
			log.error("Rserve reported an error in initialization. Check if the package \"data.table\" is "
					+ "installed in R.", e);
		}
		buffer = new Buffer(BUFFER_CAPACITY);
	}

	public void addIdExtractor(Class<? extends Object> elementClass, Function<Object, String> function) {
		idExtractorMap.put(elementClass, function);
	}

	public <F extends Entity, S extends Entity, T> void putPair(Measurement<Pair<F, S>, T> m) {
		buffer.putPair(m);
		if (buffer.isFull()) {
			try {
				rJobQueue.put(new PushBufferToRJob(conn, buffer, bufferNumber++));
			} catch (InterruptedException e) {
				log.error(e);
			}
			buffer = new Buffer(BUFFER_CAPACITY);
		}
	}

	public <E> void put(Measurement<E, ?> m) {
		buffer.put(m);
		// TODO remove duplicated code
		if (buffer.isFull()) {
			try {
				rJobQueue.put(new PushBufferToRJob(conn, buffer, bufferNumber++));
			} catch (InterruptedException e) {
				log.error(e);
			}
			buffer = new Buffer(BUFFER_CAPACITY);
		}
	}

	public void finish() {
		buffer.shrinkToSize();
		try {
			rJobQueue.put(new PushBufferToRJob(conn, buffer, bufferNumber++));
			rJobQueue.put(new FinalizeRProcessing(conn));
		} catch (InterruptedException e) {
			log.error(e);
		}

		// wait until R processing is finished
		try {
			rJobProcessor.join();
		} catch (InterruptedException e) {
			log.error(e);
		}
		log.info("Finished R processing.");

		// clean up
		buffer = new Buffer(BUFFER_CAPACITY);
		bufferNumber = 0;
		rTime = 0;
		processed = 0;
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

		public <F extends Entity, S extends Entity, T> void putPair(Measurement<Pair<F, S>, T> m) {
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

		private Function<Object, String> findIdExtractorForType(Class<?> type) {
			if (type == null) {
				return null;
			}
			if (type.equals(Object.class)) {
				return null;
			}
			if (idExtractorMap.containsKey(type)) {
				return idExtractorMap.get(type);
			} else {
				Function<Object, String> x = findIdExtractorForType(type.getSuperclass());
				if (x != null) {
					return x;
				}

				for (Class<?> iface : type.getInterfaces()) {
					x = findIdExtractorForType(iface);
					if (x != null) {
						return x;
					}
				}
			}
			return null;
		}

		private String toIdString(Object o) {
			Function<Object, String> extractor = idExtractorMap.get(o.getClass());
			if (extractor == null) {
				// try to find extractor for one of the type's supertypes (classes + interfaces)
				extractor = findIdExtractorForType(o.getClass());
				if (extractor != null) {
					// found extractor for a supertype -> store that mapping to prevent the same lookup over and over
					// again
					idExtractorMap.put(o.getClass(), extractor);
				} else {
					// fallback
					log.warn("Could not find id extractor for class " + o.getClass() + ".");
					return o.toString();
				}
			}
			return extractor.apply(o);
		}

		private String toTypeString(Object o) {
			if (EObject.class.isInstance(o)) {
				return stripNamespace(((EObject) o).eClass().getInstanceClassName());

			} else {
				return stripNamespace(o.getClass().getName());
			}
		}

		private String stripNamespace(String fqn) {
			int startOfClassName = fqn.lastIndexOf(".");
			return fqn.substring(startOfClassName + 1, fqn.length());
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

	}

	private static abstract class RJob {

		protected RConnection connection;

		public RJob(RConnection connection) {
			this.connection = connection;
		}

		public abstract void process();

	}

	private static class RJobProcessor implements Runnable {

		private BlockingQueue<RJob> queue;

		public RJobProcessor(BlockingQueue<RJob> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			boolean keepRunning = true;
			while (keepRunning) {
				try {
					RJob job = queue.take();
					job.process();
					if (job.getClass().equals(FinalizeRProcessing.class)) {
						keepRunning = false;
					}
				} catch (InterruptedException e) {
					log.error(e);
				}
			}
		}

	}

	private static class PushBufferToRJob extends RJob {

		private Buffer buffer;

		private int bufferNumber;

		public PushBufferToRJob(RConnection connection, Buffer buffer, int bufferNumber) {
			super(connection);
			this.buffer = buffer;
			this.bufferNumber = bufferNumber;
		}

		@Override
		public void process() {
			pushBufferToR();
		}

		private void convertCategoricalColumnsToFactorColumns() {
			try {
				connection.voidEval("buffer$what <- as.factor(buffer$what)");
				connection.voidEval("buffer$where.first.type <- as.factor(buffer$where.first.type)");
				connection.voidEval("buffer$where.first.id <- as.factor(buffer$where.first.id)");
				connection.voidEval("buffer$where.second.type <- as.factor(buffer$where.second.type)");
				connection.voidEval("buffer$where.second.id <- as.factor(buffer$where.second.id)");
				connection.voidEval("buffer$where.property <- as.factor(buffer$where.property)");
				connection.voidEval("buffer$who.type <- as.factor(buffer$who.type)");
			} catch (RserveException e) {
				log.error("Rserve reported an error while converting categorical columns to factors", e);
			}
		}

		private void pushBufferToR() {
			long start = System.currentTimeMillis();
			int size = buffer.size;
			if (bufferNumber == 0) {
				try {
					connection.voidEval("mm <- list()");
				} catch (RserveException e) {
					e.printStackTrace();
				}
			}

			try {
				connection.assign("buffer", createDataFrameFromBuffer(buffer));
				convertCategoricalColumnsToFactorColumns();
				connection.voidEval("mm[[length(mm)+1]] <- buffer");
			} catch (RserveException e) {
				e.printStackTrace();
			}
			long end = System.currentTimeMillis();
			// rTime += end - start;
			if (log.isDebugEnabled())
				log.debug(String.format("Pushed %d measuements to R. Took %.2f seconds.", size, (end - start) / 1000.0));
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

	}

	/**
	 * Insert into buffer queue to bring buffer processor to a stop.
	 */
	private static class FinalizeRProcessing extends RJob {

		public FinalizeRProcessing(RConnection connection) {
			super(connection);
		}

		@Override
		public void process() {
			createSingleDataFrameFromBufferedDataFrames();
			storeRDS();
			// log.info(String.format("Finished R processing. Total time spent in R: %.2f seconds.", rTime / 1000.0));
		}

		private void storeRDS() {
			log.info("Saving measurements into RDS file. This can take a moment...");
			long start = System.currentTimeMillis();
			try {
				connection.voidEval("saveRDS(mm, 'D:/test.rds')");
			} catch (RserveException e) {
				log.error("Rserve reported an error while saving measurements to RDS file.", e);
			}
			long end = System.currentTimeMillis();
			// rTime += end - start;
			log.info(String.format("Saved measurements into RDS file. Took %.2f seconds.", (end - start) / 1000.0));
		}

		private void createSingleDataFrameFromBufferedDataFrames() {
			long start = System.currentTimeMillis();
			try {
				connection.voidEval("mm <- rbindlist(mm)");
			} catch (RserveException e) {
				e.printStackTrace();
			}
			long end = System.currentTimeMillis();
			// rTime += end - start;
			log.info(String.format("Merged buffers into single dataframe. Took %.2f seconds.", (end - start) / 1000.0));
		}

	}

}
