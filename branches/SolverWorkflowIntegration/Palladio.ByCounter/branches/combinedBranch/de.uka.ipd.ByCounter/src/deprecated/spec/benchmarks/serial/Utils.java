/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.benchmarks.serial;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.BitSet;

public class Utils {
    public static final String[] classNamesSE = new String[] {
        "TestArray", "TestArrayList",
        "TestByteArray", "TestClassReferenceTest",
        "TestClassWithSQLDateOnly", "TestDomainObject",
        "TestExceptionReference", "TestExternalizable", "TestHugeData",
        "TestParent", "TestPayload", "TestProxy", "TestReadResolve",
        "TestSimple", "TestWithBigDecimal", "TestWithFinalField" };
    
    public static final String[] classNamesME = new String[] {
        "TestArray", "TestArrayList",
        "TestByteArray", "TestClassReferenceTest",
        "TestDomainObject",
        "TestExceptionReference", "TestExternalizable", "TestHugeData",
        "TestPayload", "TestProxy", "TestReadResolve",
        "TestSimple", "TestWithFinalField" };
    
    public static String[] classNames = classNamesSE;
    
    public static int classesNumber = classNames.length;
    
    public static final String dataPackagePrefix = "spec.benchmarks.serial.data.";
    
    public static final int singleLoop = 100000;
    
    public static final int pairLoop = singleLoop;// * 2;
    
    public static int startPortNumber = 3000;
    
    public static final int SCALE = 8;
    
    public static Object getInstance(int index) throws Exception {
        String fullName = Utils.dataPackagePrefix + classNames[index];
        Method method = Class.forName(fullName).getMethod("createTestInstance",
                (Class []) null);
        return method.invoke(Class.forName(fullName), (Object []) null);
    }
    
    public static BitSet createBitSet() {
        BitSet result = new BitSet();
        result.set(0, Utils.classesNumber);
        return result;
    }
    
    
    public static void printResult(PrintStream stream, BitSet results) {
        for (int i = 0; i < classesNumber; i ++) {
            stream.println(Utils.dataPackagePrefix + Utils.classNames[i] + ":"
                    + (results.get(i) ? "PASSED" : "FAILED"));
        }
    }
    
    public static Object[] createInstances() throws Exception {
        Object[] result = new Object[classesNumber * SCALE];
        for (int i = 0; i < classesNumber * SCALE; i ++) {
            result[i] = Utils.getInstance((i % classesNumber));
        }
        return result;
    }
}