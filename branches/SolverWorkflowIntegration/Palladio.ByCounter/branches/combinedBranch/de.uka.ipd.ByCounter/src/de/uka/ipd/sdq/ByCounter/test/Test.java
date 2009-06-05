package de.uka.ipd.sdq.ByCounter.test;

import org.apache.log4j.PropertyConfigurator;

import de.uka.ipd.sdq.ByCounter.test.Test.InnerClass.InnerClassLevel2;

//import org.apache.log4j.Logger;

/**
 * Class for testing the instrumentation.
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
@SuppressWarnings("unused")
public class Test {
//	private Logger log;
	
	public Test(){
//		log = Logger.getLogger(this.getClass().getCanonicalName());
//		log.info(getClass().getCanonicalName() + " was constructed.");
	}
	
	public int loopTest() {
		int a = 0;
		int i = 0;
		for(; i < 20; i++) {
			a += i;
//			log.getLevel();
		}
		if(i>200){
			return a/2;
		}
		return a;
	}
	
	public void methodCallTest() {
		int a = 0;
		if(parameterTest(1, 2.0f, "abc")) {
			a = 2;
		}
		loopTest();
		printTest();
		
	}
	
	public boolean parameterTest(int i, float f, String s) {
		int MK1 = 10;
		int MK2 = 10;
		int MK3 = 10;
		int MK4 = 10;
		int MK5 = 10;
		
		f *= 20 + i;
//		log.info("From parameterTest(): " + s);
		return true;
	}
	
	public boolean parameterTest(int i, int j, String s) {
		int MK1 = 10;
		int MK2 = 10;
		int MK3 = 10;
		int MK4 = 10;
		int MK5 = 10;
		
		i *= 20 + j;
//		log.info("From parameterTest(): " + s);
		return false;
	}
	
	/**
	 * Try different operations here.
	 *
	 */
	public void printTest() {
		int i = 0;
		i += 2;
		i += 3;
		i *= 20;
		
		Object obj = null;
		
		int[][] abc = new int [3][2];
		abc[1][1] = 0;
		
		switch(i) {
			case 100:
				i -= 1;
				break;
			default:
				i -= 2;
		}
		
		for(int j = 0; j < 100; j++) {
			i += j;
			int a = 5*j/2;
			a++;
			if(j < 30) {
				//log.debug("test" + a);
			}
		}
		
//		log.info("printTest: " + "a" + "b" + "c");
	}
	
//	public int loopTest(int iMax) {
//		int a = 0;
//		int i = 0;
//		for(; i < iMax; i++) {
//			a += i;
//			
//		}
//		return a;
//	}
	
	
	/**
	 * Example of a static nested class.
	 */
	public static class StaticNested {
		
		/**
		 * Example of a static nested class inside a static nested class.
		 */
		public static class StaticNestedLevel2 {
			public StaticNestedLevel2() {
				int b = 1;
				b--;
			}
		}
		
		public StaticNested() {
			int a = 0;
			a++;
		}
	}
	
	/**
	 * Example of an inner class.
	 */
	public class InnerClass {

		/**
		 * Example of an inner class inside an inner class.
		 */
		public class InnerClassLevel2 {
			public InnerClassLevel2() {
				System.out.println("!!InnerClassLevel2 here!!");
				loopTest();
			}
		}
		
		public InnerClass() {
			System.out.println("!!InnerClass here!!");
			loopTest();
		}
	}
	
	/**
	 * Usage of an inner class.
	 * Note that to instantiate a nested class through reflection as in 
	 * "obj.newInstance" the inner class constructor does take an _additional_
	 * parameter (even when otherwise without constructor parameters), that is
	 * the enclosing class.
	 * 
	 */
	public static void useInnerClassLevel2() {
		System.out.println("!!useInnerClassLevel2() here!!");
		InnerClass i1 = new Test().new InnerClass();
		InnerClassLevel2 i2 = i1.new InnerClassLevel2();
	}
}
