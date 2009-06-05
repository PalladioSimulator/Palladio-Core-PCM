/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package spec.harness;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;


public class Util {   
    /**
     * Get the value of the property passed in.
     * 1. Get the value of the benchmark specific property, that is <propname>.<bmname>
     * 2. Get the value of the base property.
     * 3. Use the default value.
     *
     * A time can be passed in as a long in millis, or with a unit on it, like '60s'.
     * Possible units are
     *   ms, millis seconds
     *   s, seconds
     *   m, minutes
     *   h, hours
     *
     * @return The value of the property, or what is in default.
     * @throws NumberFormatException
     */
    public static long getTimeProperty(String propname, String bmName)
    throws NumberFormatException {
        String value = getProperty(propname, bmName);
        return getTimeAsMillis(value);
    }
    
    /**
     * A time can be passed in as a long in millis, or with a unit on it, like '60s'.
     * Possible units are
     *   ms, millis seconds
     *   s, seconds
     *   m, minutes
     *   h, hours
     *
     * @return The value of the property, or what is in default.
     * @throws NumberFormatException
     */
    public static long getTimeAsMillis(String value)
    throws NumberFormatException {
        if (value.indexOf("ms") != -1) {
            return Long.parseLong(value.substring(0, value.indexOf("ms")));
        } else if (value.indexOf("s") != -1) {
            return 1000 * Long
                    .parseLong(value.substring(0, value.indexOf("s")));
        } else if (value.indexOf("m") != -1) {
            return 1000 * 60 * Long.parseLong(value.substring(0, value
                    .indexOf("m")));
        } else if (value.indexOf("h") != -1) {
            return 1000 * 60 * 60 * Long.parseLong(value.substring(0, value
                    .indexOf("h")));
        } else {
            return 1000 * Long.parseLong(value);
        }
    }
    
    /**
     * A time can be passed in as a long in millis, or with a unit on it, like '60s'.
     * Possible units are
     *   ms, millis seconds
     *   s, seconds
     *   m, minutes
     *   h, hours
     *
     * @return The value of the property, or what is in default.
     * @throws NumberFormatException
     */
    public static long getTimeAsSeconds(String value) {
        return getTimeAsMillis(value) / 1000;
    }
    
    /**
     * Get the calculated int value of the property passed in. 1. Get the value
     * of the benchmark specific property, that is <propname>.<bmname> 2. Get
     * the value of the base property. 3. Use the default value.
     *
     * A hard ware thread property can be passed in as fixed or relativ.
     * Examples: #hwt, same as number of hard ware threads on the machine
     * (processors available to java) 2x#hwt, 2 times the number of hardware
     * threads 4, will return 4.
     *
     * @return Number of hardware threads calculated based on value.
     * @throws NumberFormatException
     */
    public static int getHwtCalcProperty(String propname, String bmName)
    throws NumberFormatException {
        String value = getProperty(propname, bmName);
        int hwtFactor = 1;
        double ret = 1;
        if (value.indexOf("x") != -1) {
            ret = Double.parseDouble(value.substring(0,value.indexOf("x")));
            value = value.substring(1+value.indexOf("x"), value.length());
        }
        if (value.indexOf("#hwt") != -1) {
            int tmp = Util.getIntProperty(Constants.BENCHMARK_THREADS_HW_OVERRIDE_PROP, bmName);
            hwtFactor = (tmp == -1 ? Runtime.getRuntime().availableProcessors() : tmp);
            value = value.substring(0, value.indexOf("#hwt"));
        }
        if (value.length() > 0) {
            ret = Integer.parseInt(value);
        }
        return (int) Math.round(ret * hwtFactor);
    }
    
    /**
     * Get the value of the property passed in as a boolean.
     * 1. Get the value of the benchmark specific property, that is <propname>.<bmname>
     * 2. Get the value of the base property.
     * 3. Use the default value.
     * @return The value of the property, or what is in default.
     */
    public static boolean getBoolProperty(String propname, String bmName) {
        String value = getProperty(propname, bmName);
        return value == null ? false : (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("1"));
    }
    
    /**
     * Get the value of the property passed in as a int.
     * 1. Get the value of the benchmark specific property, that is <propname>.<bmname>
     * 2. Get the value of the base property.
     * 3. Use the default value.
     * @return The value of the property, or what is in default, or -1 if nothing is set.
     */
    public static int getIntProperty(String propname, String bmName) {
        String value = getProperty(propname, bmName);
        return value == null ? -1 : Integer.parseInt(value);
    }
    
    /**
     * Get the value of the property passed in as a long.
     * 1. Get the value of the benchmark specific property, that is <propname>.<bmname>
     * 2. Get the value of the base property.
     * 3. Use the default value.
     * @return The value of the property, or what is in default.
     */
    public static long getLongProperty(String propname, String bmName) {
        String value = getProperty(propname, bmName);
        return value == null ? -1 : Long.parseLong(value);
    }
    
    private static String getPropertyHelper(Properties props, String propname, String bmName) {
        String value = null;
        if (value == null && bmName != null) {
            value = props.getProperty(propname + "." + bmName);
            if (value != null && value.equals("null")) {
                value = null;
            }
        }
        if (value == null) {
            value = props.getProperty(propname);
            if (value != null && value.equals("null")) {
                value = null;
            }
        }
        return value;
    }
    
    /**
     * Get the value of the property passed in.
     * 1. Get the value of the benchmark specific property, that is <propname>.<bmname>
     * 2. Get the value of the base property.
     * 3. Use the default value.
     * @param propname Name of the property (base name).
     * @param bmName Name of the benchmark that gets the property.
     * @return The value of the property, or null if all options are unset.
     */
    public static String getProperty(String propname, String bmName) {
        
        String value = null;
        
        // Always use default properties for check
        // Check is not like the other children...
        if (bmName != null && bmName.equals("check")) {
            if (value == null && Launch.defaultProperties != null) {
                value = getPropertyHelper(Launch.defaultProperties, propname, bmName);
            }
        }
        
        if (value == null && Launch.userProperties != null) {
            value = getPropertyHelper(Launch.userProperties, propname, bmName);
        }
        
        if (value == null && Launch.defaultProperties != null) {
            value = getPropertyHelper(Launch.defaultProperties, propname, bmName);
        }
        return value;
    }
    
    static String getDefaultProperty(String propname, String bmName) {
        return getPropertyHelper(Launch.defaultProperties, propname, bmName);
    }

    static String getUserProperty(String propname, String bmName) {
        return getPropertyHelper(Launch.userProperties, propname, bmName);
    }

    public static void printProperties(Properties props) {
        printProperties(Context.getOut(), props);
    }
    
    public static void printProperties(PrintStream ps, Properties props) {
        if (props != null) {
            Enumeration e = props.keys();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = (String) props.getProperty(key);
                ps.println("  " + key + "=" + value);
            }
        }
    }
    
    public static void printReqs(HashMap<String,String> reqs) {
        printProperties(Context.getOut(), reqs);
    }
    
    public static void printProperties(PrintStream ps, HashMap<String,String> reqs) {
        if (reqs != null) {
            Iterator<String> i = reqs.keySet().iterator();
            while (i.hasNext()) {
                String key = i.next();
                String value = reqs.get(key);
                ps.println("  " + key + "=" + value);
            }
        }
    }
    
    public static boolean sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }
    
    public static boolean isScimarkAndNotMonteCarlo(String name) {
    	return name != null && name.startsWith(Constants.SCIMARK_BNAME_PREFIX) 
    	    && !name.equals(Constants.SCIMARK_MONTE_CARLO_BNAME); 
    }    
}
