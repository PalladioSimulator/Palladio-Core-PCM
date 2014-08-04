package org.palladiosimulator.protocom.framework.config;

/**
 * Config class for protocom
 * 
 * TODO: Not in use.
 * 
 * @author Steffen Becker
 */
public class ProtocomConfig {
    private static final Long UNSET_LONG = null;
    private static final String UNSET_STRING = null;
    private static final Class<?> UNSET_CLASS = null;

    private boolean wait = false;
    private String propertyFile = UNSET_STRING;
    private String dataDirectory = UNSET_STRING;
    private String experimentName = UNSET_STRING;
    private Long userCount = UNSET_LONG;
    private Long maxMeasurements = UNSET_LONG;
    private Long warmUpRuns = UNSET_LONG;
    private String calibrationPath = UNSET_STRING;
    private String rmiIP = UNSET_STRING;
    private Class<?> mainClass = UNSET_CLASS;
    private Long seed = UNSET_LONG;
    private boolean debug = false;
    private boolean passive = false;
    private boolean warmupOnly = false;

    /**
     * @return the wait
     */
    public boolean isWait() {
        return wait;
    }

    /**
     * @param wait
     *            the wait to set
     */
    public void setWait(boolean wait) {
        this.wait = wait;
    }

    /**
     * @return the propertyFile
     */
    public String getPropertyFile() {
        return propertyFile;
    }

    /**
     * @param propertyFile
     *            the propertyFile to set
     */
    public void setPropertyFile(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    /**
     * @return the dataDirectory
     */
    public String getDataDirectory() {
        return dataDirectory;
    }

    /**
     * @param dataDirectory
     *            the dataDirectory to set
     */
    public void setDataDirectory(String dataDirectory) {
        this.dataDirectory = dataDirectory;
    }

    /**
     * @return the experimentName
     */
    public String getExperimentName() {
        return experimentName;
    }

    /**
     * @param experimentName
     *            the experimentName to set
     */
    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    /**
     * @return the userCount
     */
    public Long getUserCount() {
        return userCount;
    }

    /**
     * @param userCount
     *            the userCount to set
     */
    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }

    /**
     * @return the maxMeasurements
     */
    public Long getMaxMeasurements() {
        return maxMeasurements;
    }

    /**
     * @param maxMeasurements
     *            the maxMeasurements to set
     */
    public void setMaxMeasurements(Long maxMeasurements) {
        this.maxMeasurements = maxMeasurements;
    }

    /**
     * @return the warmUpRuns
     */
    public Long getWarmUpRuns() {
        return warmUpRuns;
    }

    /**
     * @param warmUpRuns
     *            the warmUpRuns to set
     */
    public void setWarmUpRuns(Long warmUpRuns) {
        this.warmUpRuns = warmUpRuns;
    }

    /**
     * @return the calibrationPath
     */
    public String getCalibrationPath() {
        return calibrationPath;
    }

    /**
     * @param calibrationPath
     *            the calibrationPath to set
     */
    public void setCalibrationPath(String calibrationPath) {
        this.calibrationPath = calibrationPath;
    }

    /**
     * @return the rmiIP
     */
    public String getRmiIP() {
        return rmiIP;
    }

    /**
     * @param rmiIP
     *            the rmiIP to set
     */
    public void setRmiIP(String rmiIP) {
        this.rmiIP = rmiIP;
    }

    /**
     * @return the mainClass
     */
    public Class<?> getMainClass() {
        return mainClass;
    }

    /**
     * @param mainClass
     *            the mainClass to set
     */
    public void setMainClass(Class<?> mainClass) {
        this.mainClass = mainClass;
    }

    /**
     * @return the seed
     */
    public Long getSeed() {
        return seed;
    }

    /**
     * @param seed
     *            the seed to set
     */
    public void setSeed(Long seed) {
        this.seed = seed;
    }

    /**
     * @return the debug
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * @param debug
     *            the debug to set
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /**
     * @return the passive
     */
    public boolean isPassive() {
        return passive;
    }

    /**
     * @param passive
     *            the passive to set
     */
    public void setPassive(boolean passive) {
        this.passive = passive;
    }

    /**
     * @return the warmupOnly
     */
    public boolean isWarmupOnly() {
        return warmupOnly;
    }

    /**
     * @param warmupOnly
     *            the warmupOnly to set
     */
    public void setWarmupOnly(boolean warmupOnly) {
        this.warmupOnly = warmupOnly;
    }
}
