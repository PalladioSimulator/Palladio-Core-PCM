package org.palladiosimulator.protocom.resourcestrategies.ee.activeresource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.measure.quantity.Duration;

import org.apache.log4j.Logger;
import org.jscience.physics.amount.Amount;

/**
 * Struct to represent a single entry in the calibration table of the load generators. It is a tuple
 * <TargetTime, Parameter>
 *
 * @author Steffen Becker, Thomas Zolynski, Sebastian Lehrig
 *
 */
class CalibrationEntry implements Serializable {
    private static final long serialVersionUID = -1969713798721640687L;

    final private Amount<Duration> targetTime;
    final private long parameter;

    /**
     * Constructor
     *
     * @param targetTime
     *            The time (in ms) which the workload generator should run and generate load for the
     *            given parameter
     * @param parameter
     *            The load generator's parameter for which the algorithm runs targetTime
     *            milliseconds
     */
    public CalibrationEntry(Amount<Duration> targetTime, long parameter) {
        super();
        this.targetTime = targetTime;
        this.parameter = parameter;
    }

    /**
     * @return Target time in ms
     */
    public Amount<Duration> getTargetTime() {
        return targetTime;
    }

    /**
     * @return Algorithm's parameter for which the algorithm runs target time milliseconds
     */
    public long getParameter() {
        return parameter;
    }

    @Override
    public String toString() {
        return AbstractDemandStrategy.formatDuration(targetTime) + "\t | \t" + parameter;
    }
}

/**
 * Class representing the calibration table. Stores a collection of calibration entries.
 *
 * @author Tobias Denker, Anne Koziolek, Steffen Becker, Thomas Zolynski, Sebastian Lehrig
 */
public class CalibrationTable {

    /** Default number of tuples <targetTime, parameter> to store in the calibration table */
    public static final int DEFAULT_CALIBRATION_TABLE_SIZE = 5;

    protected CalibrationEntry[] table;

    private static final Logger LOGGER = Logger.getLogger(AbstractDemandStrategy.class.getName());

    /**
     * Private constructor. Used when created by loading an existing calibration table.
     */
    public CalibrationTable() {
        table = new CalibrationEntry[DEFAULT_CALIBRATION_TABLE_SIZE];
    }

    /**
     * Constructor. New calibration table with given size.
     *
     * @param tableSize
     *            size of the calibration table
     */
    public CalibrationTable(int tableSize) {
        table = new CalibrationEntry[tableSize];
    }

    /**
     * Loads calibration from config file
     *
     * @return The loaded calibration file or null if the file could not be loaded
     */
    public static CalibrationTable load(File configFile) {
        CalibrationTable calibrationTable = null;

        // tests whether the calibration file exists and can be loaded
        if (configFile.exists()) {
            LOGGER.debug("Loaded calibration from '" + configFile + "'");

            calibrationTable = new CalibrationTable();

            InputStream fis = null;
            try {
                fis = new FileInputStream(configFile);
                ObjectInputStream o = new ObjectInputStream(fis);
                calibrationTable.setTable((CalibrationEntry[]) o.readObject());
            } catch (IOException e) {
                LOGGER.error("Error while loading " + configFile, e);
                throw new RuntimeException(e);

            } catch (ClassNotFoundException e) {
                LOGGER.error("Error while reading " + configFile, e);
                throw new RuntimeException(e);
            } catch (Exception e) {
                LOGGER.error("Error while reading " + configFile, e);
                throw new RuntimeException(e);

            } finally {
                try {
                    fis.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        } else {
            LOGGER.debug(configFile + " not existing yet");
        }

        return calibrationTable;
    }

    /**
     * Saves calibration to config file. Config file uses a Java object stream to serialise the
     * calibration table.
     */
    public void save(File configFile) {
        LOGGER.info("Saving calibration to '" + configFile + "'");
        OutputStream fos = null;
        try {
            fos = new FileOutputStream(configFile);

            ObjectOutputStream o = new ObjectOutputStream(fos);
            o.writeObject(table);

        } catch (IOException e) {
            LOGGER.error("Error while writing calibration data", e);
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    public byte[] toBinary() {
    	ByteArrayOutputStream out = new ByteArrayOutputStream();

    	try {
	    	ObjectOutputStream stream = new ObjectOutputStream(out);
	    	stream.writeObject(table);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}

    	return out.toByteArray();
    }

    public static CalibrationTable fromBinary(byte[] binary) {
    	CalibrationTable result = new CalibrationTable();
    	CalibrationEntry[] table = null;

    	ByteArrayInputStream in = new ByteArrayInputStream(binary);

    	try {
    		ObjectInputStream stream = new ObjectInputStream(in);
    		table = (CalibrationEntry[]) stream.readObject();
    		result.setTable(table);
    	} catch (IOException e) {
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    	return result;
    }

    private void setTable(CalibrationEntry[] table) {
        this.table = table;
    }

    /**
     * Returns the calibration entry for given number.
     *
     * @param entryNumber
     * @return
     */
    public CalibrationEntry getEntry(int entryNumber) {
        return table[entryNumber];
    }

    /**
     * Creates a new calibration entry.
     *
     * @param entryNumber
     *            entry number (position in table)
     * @param targetTime
     * @param parameter
     */
    public void addEntry(int entryNumber, Amount<Duration> targetTime, long parameter) {
        table[entryNumber] = new CalibrationEntry(targetTime, parameter);
    }

    /**
     * Returns the size of the calibration table.
     *
     * @return
     */
    public int size() {
        return table.length;
    }

}
