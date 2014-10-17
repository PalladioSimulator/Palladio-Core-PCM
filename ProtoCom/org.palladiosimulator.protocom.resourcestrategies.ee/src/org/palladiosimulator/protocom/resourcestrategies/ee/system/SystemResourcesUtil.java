package org.palladiosimulator.protocom.resourcestrategies.ee.system;

import java.io.File;
import java.lang.management.ManagementFactory;

import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.jscience.physics.amount.Amount;

/**
 * Helper class for monitoring system resources.
 *
 * @author Thomas Zolynski
 *
 */
public final class SystemResourcesUtil {

    /**
     * Sun's implementation of OperatingSystemMXBean is used. Eclipse is not very fond of this
     * import (Forbidden references), so you might have to change your preferences (Java -> Compiler
     * -> Errors/Warnings -> Forbidden references)
     */
    private static final com.sun.management.OperatingSystemMXBean OS = (com.sun.management.OperatingSystemMXBean) ManagementFactory
            .getOperatingSystemMXBean();

    /**
     * This systems' temp directory. Due to inconsistencies between different systems a file
     * separator is added.
     */
    public static final File TEMP_DIR = new File("D:\\TEMP");
    public static final File TEMP_DIR2 = new File(System.getProperty("java.io.tmpdir")
            + System.getProperty("file.separator"));

    /**
     * Returns the total size of the physical memory in bytes.
     *
     * @return total memory in bytes
     */
    public static long getTotalPhysicalMemorySize() {
        return OS.getTotalPhysicalMemorySize();
    }

    /**
     * Returns the free physical memory in bytes.
     *
     * @return free memory in bytes
     */
    public static long getFreePhysicalMemorySize() {
        return OS.getFreePhysicalMemorySize();
    }

    /**
     * Returns the free space of the temp directory
     *
     * @return free space in bytes
     */
    public static long getFreeTempDirectorySize() {
        return TEMP_DIR2.getUsableSpace();
    }

    /**
     * Returns the number of CPU cores.
     *
     * @return CPU cores
     */
    public static int getCPUCores() {
        return OS.getAvailableProcessors();
    }

    /**
     * Returns the CPU time used by this JVM
     *
     * @return CPU usage in nanoseconds
     */
    public static double getCPUProcessTimeNS() {
        return OS.getProcessCpuTime();
    }

    /**
     * Returns the CPU time used by this JVM
     *
     * @return CPU usage as a JScience object
     */
    public static Amount<Duration> getCPUProcessTime() {
        return Amount.valueOf(getCPUProcessTimeNS(), SI.NANO(SI.SECOND));
    }

}
