package de.uka.ipd.sdq.simucomframework;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.apache.impl.MT19937RandomGenerator;
import de.uka.ipd.sdq.probfunction.math.random.IRandomStream;
import de.uka.ipd.sdq.simucomframework.variables.functions.LogNormDistFunction;
import de.uka.ipd.sdq.simucomframework.variables.functions.NormDistFunction;

/**
 * SimuComDefaultRandomNumberGenerator generates random numbers in a separate thread.
 * SimuComDefaultRandomNumberGenerator currently implements the interface for random numbers needed
 * by the prob function package. However, internally it relies on a random stream implementing the
 * RandomStream interface from JSS.
 *
 * SimuComDefaultRandomNumberGenerator implements {@link RandomStream} as the functions like
 * {@link LogNormDistFunction} and {@link NormDistFunction} in package
 * de.uka.ipd.sdq.simucomframework.variables.functions.
 *
 * This class is optimized for multi-cores, thus speeding up simulation significantly for at least
 * two cores. Here everything related to random numbers in SimuCom should be then localised,
 * especially seed initialisation and the multi-threading stuff (which was - as always - deadlock
 * prone while implementing). Also it locates the dependency to the [0..1] random number generator
 * to a single place in the source (remember this needs to be changed to get away from GPL code...).
 *
 * @author Steffen Becker
 *
 */
public class SimuComDefaultRandomNumberGenerator implements IRandomGenerator {

    private static final int MAX_PRODUCER_BUFFER_SIZE = 1000;
    private static final Logger LOGGER = Logger.getLogger(SimuComDefaultRandomNumberGenerator.class.getName());
    private static long streamCounter = 0;
    private final long myID;
    private final IRandomStream rndNumberGenerator;
    private final LinkedBlockingQueue<Double> producerQueue = new LinkedBlockingQueue<Double>(MAX_PRODUCER_BUFFER_SIZE);
    private final Thread producerThread;
    private volatile boolean finished;

    public SimuComDefaultRandomNumberGenerator(long[] randomSeed) {
        this.myID = streamCounter++;
        this.finished = false;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initialising random number generator! [Stream ID = " + myID + "]");
        }
        rndNumberGenerator = new MT19937RandomGenerator();// new MRG32k3aRandomGenerator();
        initRandomSeed(randomSeed);

        this.producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Random number producer started! [Stream ID = " + myID + "]");
                }
                try {
                    while (!finished) {
                        producerQueue.put(rndNumberGenerator.nextDouble());
                    }
                } catch (InterruptedException e) {
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("Bad concurrency problem", e);
                    }
                    throw new RuntimeException("Unexpected interruption of concurrent threads");
                }
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Random number producer stopped! [Stream ID = " + myID + "]");
                }
            }
        });
        producerThread.start();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Random number stream initialised! [Stream ID = " + myID + "]");
        }
    }

    /**
     * Set up seed of random number generator
     * 
     * @param randomSeed
     *            The random number generator's seed. May be null for default initialisation
     */
    private void initRandomSeed(long[] randomSeed) {
        if (randomSeed != null) {
            if (randomSeed.length == 6) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Setting fixed seed for random number generator! [Stream ID = " + myID + "]");
                    for (int i = 0; i < 6; i++) {
                        LOGGER.debug("Seed " + i + " = " + randomSeed[i]);
                    }
                }
                rndNumberGenerator.setSeed(randomSeed);
            } else {
                throw new RuntimeException(
                        "Seed array must have length of six longs for initialising random number generator");
            }
        } else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Setting random seed for random number generator! [Stream ID = " + myID + "]");
            }
            long[] myRandomSeed = new long[6];
            Random r = new Random();
            for (int i = 0; i < myRandomSeed.length; i++) {
                myRandomSeed[i] = r.nextInt();
            }
            rndNumberGenerator.setSeed(myRandomSeed);
        }
    }

    /**
     * Returns a (pseudo)random number from the uniform distribution over the interval (0, 1), using
     * this stream, after advancing its state by one step. The generators programmed in SSJ never
     * return the values 0 or 1. This method takes a previously generated random number from the
     * asynchronously running generator thread.
     */
    @Override
    public double random() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Drawing a random number from random number stream [" + myID + "]!");
        }
        double d;
        try {
            d = producerQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException("Unexpected interruption of concurrent threads");
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Number is: " + d);
        }
        return d;
    }

    @Override
    public void dispose() {
        finished = true;
        producerQueue.clear();
    }

    /**
     * Generates n (pseudo)random numbers from the uniform distribution and stores them into the
     * array u starting at index start. (doc from {@link RandomStream})
     * 
     * @param u
     *            - array that will contain the generated uniforms
     * @param start
     *            - starting index, in the array u, to write uniforms from
     * @param n
     *            - number of uniforms to generate
     */
    public void nextArrayOfDouble(double[] u, int start, int n) {
        for (int i = start; i < u.length && i - start < n; i++) {
            u[i] = this.random();
        }
    }

    /**
     * Generates n (pseudo)random numbers from the discrete uniform distribution over the integers
     * {i, i + 1,..., j}, using this stream and stores the result in the array u starting at index
     * start. (Calls nextInt n times.) (doc from {@link RandomStream}
     * 
     * @param i
     *            - smallest integer that can be generated
     * @param j
     *            - greatest integer that can be generated
     * @param u
     *            - array that will contain the generated values
     * @param start
     *            - starting index, in the array u, to write integers from
     * @param n
     *            - number of values being generated
     */
    public void nextArrayOfInt(int i, int j, int[] u, int start, int n) {
        for (int index = start; index < u.length && index - start < n; index++) {
            u[index] = this.nextInt(i, j);
        }
    }

    /**
     * Returns a (pseudo)random number from the uniform distribution over the interval (0, 1), using
     * this stream, after advancing its state by one step. The generators programmed in SSJ never
     * return the values 0 or 1. Calls random() which takes a previously generated random number
     * from the asynchronously running generator thread.
     */
    public double nextDouble() {
        return this.random();
    }

    /**
     * Returns a (pseudo)random number from the discrete uniform distribution over the integers {i,
     * i + 1,..., j}, using this stream. (Calls nextDouble once.) Copied from
     * {@link RandomStreamBase}.
     * 
     * @param i
     *            - smallest integer that can be generated
     * @param j
     *            - greatest integer that can be generated
     */
    public int nextInt(int i, int j) {
        // copied from RandomStreamBase
        return i + (int) (nextDouble() * (j - i + 1.0));
    }

    /**
     * does nothing because this implementation does not support any substreams
     */
    public void resetNextSubstream() {
    }

    /**
     * does nothing because this implementation does not support any substreams
     */
    public void resetStartStream() {
    }

    /**
     * does nothing because this implementation does not support any substreams
     */
    public void resetStartSubstream() {
    }

}
