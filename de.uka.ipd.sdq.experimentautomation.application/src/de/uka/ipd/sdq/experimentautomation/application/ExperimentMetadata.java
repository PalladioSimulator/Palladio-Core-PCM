package de.uka.ipd.sdq.experimentautomation.application;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

public class ExperimentMetadata {

    private static final String LINE_FEED = "\r\n";

    private String experimentName;
    private String[] commandLineArguments;
    private String virtualMachineArguments;
    private Date startTime;
    private Date endTime;

    public ExperimentMetadata() {
        // nothing to do
    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public String[] getCommandLineArguments() {
        return commandLineArguments;
    }

    public void setCommandLineArguments(String[] commandLineArguments) {
        this.commandLineArguments = commandLineArguments;
    }

    public String getVirtualMachineArguments() {
        return virtualMachineArguments;
    }

    public void setVirtualMachineArguments(String virtualMachineArguments) {
        this.virtualMachineArguments = virtualMachineArguments;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Experiment name:        " + experimentName + "\r\n");
        builder.append("Workstation name:       " + getWorkstationName() + "\r\n");
        builder.append("Command line arguments: " + toString(commandLineArguments) + "\r\n");
        builder.append("VM arguments:           " + getVMArguments() + "\r\n");
        builder.append("Started:                " + startTime + "\r\n");
        builder.append("Finished:               " + endTime + "\r\n");

        // append OS properties
        builder.append(getOSProperties());

        // append VM properties
        builder.append(getVMProperties());

        return builder.toString();
    }

    private String getWorkstationName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "Could not determine the host name";
        }
    }

    private String getVMArguments() {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = bean.getInputArguments();
        return arguments.toString();
    }

    private String getVMProperties() {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        StringBuilder b = new StringBuilder();
        b.append(LINE_FEED);
        b.append("--[ Virtual Machine ]---------------------------------------." + LINE_FEED);
        b.append("Name:                   " + bean.getName() + LINE_FEED);
        b.append("Specification Name:     " + bean.getSpecName() + LINE_FEED);
        b.append("Specification Vendor:   " + bean.getSpecVendor() + LINE_FEED);
        b.append("Specification Version:  " + bean.getSpecVersion() + LINE_FEED);
        b.append("VM Name:                " + bean.getVmName() + LINE_FEED);
        b.append("VM Vendor:              " + bean.getVmVendor() + LINE_FEED);
        b.append("VM Version:             " + bean.getVmVersion() + LINE_FEED);
        return b.toString();
    }

    private String getOSProperties() {
        OperatingSystemMXBean bean = ManagementFactory.getOperatingSystemMXBean();
        StringBuilder b = new StringBuilder();
        b.append(LINE_FEED);
        b.append("--[ Operating System ]---------------------------------------" + LINE_FEED);
        b.append("Architecture:           " + bean.getArch() + LINE_FEED);
        b.append("Available Processors:   " + bean.getAvailableProcessors() + LINE_FEED);
        b.append("Version:                " + bean.getVersion() + LINE_FEED);
        return b.toString();
    }

    private String toString(String[] strings) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            b.append(strings[i]);
            if (i + 1 < strings.length) {
                b.append(", ");
            }
        }
        return b.toString();
    }

}
