package de.uka.ipd.sdq.ByCounter.test;

import java.io.FileOutputStream;
import java.io.IOException;

public class JavaLangRuntimeTester {

	public static void main(String[] args) {
		System.out.println("A: " + (0 + 6));
		java.lang.Runtime.getRuntime().traceInstructions(true);
		System.out.println("B: " + (1 + 6));
		java.lang.Runtime.getRuntime().traceMethodCalls(true);
		System.out.println("C: " + (2 + 6));
		java.lang.Runtime.getRuntime().traceInstructions(false);
		System.out.println("D: " + (3 + 6));
		java.lang.Runtime.getRuntime().traceMethodCalls(false);
		System.out.println("E: " + (4 + 6));

		JavaLangRuntimeTester jlrt = new JavaLangRuntimeTester();
		try {
			jlrt.connect(null, "1.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void connect(String[] cmdarray, String fileName) throws Exception {

//		CharSequence cs;

		Runtime runtime = Runtime.getRuntime();
		runtime.traceInstructions(true);
		runtime.traceMethodCalls(true);
		Process process;

		process = runtime.exec("java -version"/* MK cmdarray */);

		// any error message?
		ReadBuffer errorBuffer = new ReadBuffer(process.getErrorStream());

		// any output?
		FileOutputStream stream;

		stream = new FileOutputStream(fileName);
		ReadBuffer outputBuffer = new ReadBuffer(process.getInputStream(),
				stream);

		// kick them off
		errorBuffer.start();
		outputBuffer.start();

		try {
			process.waitFor();
		} catch (InterruptedException e) {
			throw new /* MK API */Exception(
					"System IO error. Please try this operation later.");
		}

		while (outputBuffer.isAlive() || errorBuffer.isAlive()) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			stream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
