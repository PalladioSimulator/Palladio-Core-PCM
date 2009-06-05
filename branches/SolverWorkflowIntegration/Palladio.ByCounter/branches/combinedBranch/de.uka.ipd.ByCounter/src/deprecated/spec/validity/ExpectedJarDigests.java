/*
 * 
 * Copyright (c) 2000-2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved. 
 * Copyright (c) 2000-2008 Hewlett-Packard All rights reserved.
 * Copyright (c) 1997-2008 Sun Microsystems, Inc. All rights reserved.
 * 
 * This source code is provided as is, without any express or implied warranty.
 *  
 */
package deprecated.spec.validity;

import java.util.*;
import java.lang.*;

public class ExpectedJarDigests 
    implements Iterable<String>
{ 
    HashMap<String, byte[]> hm;


    /*****
     * Generated digests
     *****/

    private final static String[] jars = {
        "SPECjvm2008.jar",
        "lib/ant.jar",
        "lib/ant-launcher.jar",
        "lib/derby.jar",
        "lib/janino.jar",
        "lib/javac.jar",
        "lib/jcommon-1.0.9.jar",
        "lib/jfreechart-1.0.5.jar",
        "lib/jl1.0.jar",
        "lib/sunflow.jar",
        "lib/Tidy.jar",
        "lib/xom-1.1.jar",
    };


    private final static byte[][] jarDigests = {
        { 102, -37, -7, 97, -84, -65, 70, 26, 99, -105 },
        { 94, -45, -31, 17, 24, -101, -101, 43, 100, -81 },
        { -20, 77, 41, 51, 106, -60, 5, 32, 11, 89 },
        { 30, 33, 121, 100, 94, 126, 59, 49, 119, 39 },
        { -32, -40, -103, -67, -127, -54, 114, 87, -63, -116 },
        { 14, 52, -105, 34, -37, -36, 91, 102, 71, -30 },
        { 121, 32, 106, -89, -25, -99, -70, -57, -27, 55 },
        { 89, -99, 64, -86, -117, 19, 46, -18, 87, 43 },
        { 24, 54, -49, 4, -86, 118, 13, 99, -22, -55 },
        { -126, -108, 26, 31, -30, 38, -122, 16, 100, -127 },
        { -29, -6, -2, -105, -3, -61, -11, 85, -37, 37 },
        { -57, -113, -98, -41, 69, -75, 41, -118, -116, -85 },
    };


    /******
     * End of generated digests
     ******/

    public ExpectedJarDigests(){ 
	//	if( !jarHM ) {

	hm = new HashMap<String, byte[]>();
	
	// Insert jarfile-digest pairs
	for (int i=0; i < jars.length; i++) {
	    hm.put(jars[i], jarDigests[i]); 
	}
	//	}
    }     

    public Iterator<String> iterator() {
	return hm.keySet().iterator();
    }

    public byte[] getArray(String key){ 
	return hm.get(key);
    } 
} 
