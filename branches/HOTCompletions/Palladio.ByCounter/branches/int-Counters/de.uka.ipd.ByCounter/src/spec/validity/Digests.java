/*
 * 
 * Copyright (c) 2000-2008 Standard Performance Evaluation Corporation (SPEC) All
 * rights reserved. Copyright (c) 2000-2008 Hewlett-Packard All rights reserved.
 * Copyright (c) 1997-2008 Sun Microsystems, Inc. All rights reserved.
 * 
 * This source code is provided as is, without any express or implied warranty.
 *  
 */
package spec.validity;

import java.io.*;
import java.security.*;
import java.util.*;
import java.lang.*;

import spec.harness.Context;

public class Digests { 
    boolean debug;


    public Digests() { 
	debug = false;  
    };

    public boolean crunch_jars() {
	boolean correct = true;
	//	String path = System.getProperty("java.class.path");

	ExpectedJarDigests jarDigests = new ExpectedJarDigests();

	// Get iterator of jar filenames to check
	Iterator<String> iter = jarDigests.iterator();

	while (iter.hasNext()) {
	    String curr_jar = iter.next();

	    // open that File
	    try {
		FileInputStream the_jar = new FileInputStream(curr_jar);
		// DigestInputStream digestible_jar = new
		// DigestibleInputStream(the_jar);
		byte[] expected = jarDigests.getArray(curr_jar);
		MessageDigest md = MessageDigest.getInstance("SHA");
		DigestInputStream dis = new DigestInputStream(the_jar, md);
		int count = (int) (new File(curr_jar).length());
		for (int i = 0; i < count; i++) 
		    dis.read(); 
		byte a[] = md.digest();
		for (int i = 0; i < 10; i++) {
		    if (debug) 
			System.out.println(", " + a[i] + " " + expected[i]);
		    if (a[i] != expected[i])
			correct = false;
		}
		System.out.println (curr_jar + " validity is " + correct);
	    }
	    catch (Exception e) {
		System.out.println("Digests: caught exception " + e);
	    }
	} // while (iter.hasNext()) ...
	return correct;
    } 



    public boolean crunch_resources() {
	boolean correct = true;
	final String prefix = Context.getSpecBasePath() + "/resources/";

	ExpectedResourceDigests resourceDigests = new ExpectedResourceDigests();

	// Get iterator of resource filenames to check
	Iterator<String> iter = resourceDigests.iterator();

	while (iter.hasNext()) {
	    String curr_resource = iter.next();

	    String resource_name = new String(prefix + curr_resource);

	    try {
		FileInputStream the_resource = new FileInputStream(resource_name);

		byte[] expected = resourceDigests.getArray(curr_resource);
		MessageDigest md = MessageDigest.getInstance("SHA");
		DigestInputStream dis = new DigestInputStream(the_resource, md);
		int count = (int) (new File(resource_name).length());
		for (int i = 0; i < count; i++) 
		    dis.read(); 
		byte a[] = md.digest();
		for (int i = 0; i < 10; i++) {
		    if (debug) 
			System.out.println(", " + a[i]);
		    if (a[i] != expected[i])
			correct = false;
		}
		System.out.println (curr_resource + " validity is " + correct);
	    }
	    catch (Exception e) {
		System.out.println("Digests: caught exception " + e);
	    }
	} // while (iter.hasNext()) ...
	return correct;


    }



}
