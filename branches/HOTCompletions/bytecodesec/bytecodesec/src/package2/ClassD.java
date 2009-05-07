package package2;

import java.lang.reflect.Field;

import package1.ClassA;

public class ClassD{
	public static void main(String[] args){
		ClassD classD= new ClassD();
		classD.run();
	}

	private void run() {
		System.out.println("==== Getting accessible fields ====");
		ClassA myClassA = new ClassA();
		Field[] myClassA_fields = myClassA.getClass().getFields();
		for(int i=0; i<myClassA_fields.length; i++){
			System.out.println(myClassA_fields[i].getName()+" "+
					myClassA_fields[i].getModifiers()+" "+
					myClassA_fields[i].isAccessible());
		}
		System.out.println("==== Getting declared fields ====");
		myClassA_fields = myClassA.getClass().getDeclaredFields();
		for(int i=0; i<myClassA_fields.length; i++){
			System.out.println(myClassA_fields[i].getName()+" "+
					myClassA_fields[i].getModifiers()+" "+
					myClassA_fields[i].isAccessible());
		}
		System.out.println("==== Trying to read the declared fields without accessiblity changes ====");
		try {
			System.out.println(myClassA_fields[0].get(myClassA));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(myClassA_fields[1].get(myClassA));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(myClassA_fields[2].get(myClassA));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(myClassA_fields[3].get(myClassA));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("==== Setting the declared fields to accessible ====");
		try {
			myClassA_fields[0].setAccessible(true);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		try {
			myClassA_fields[1].setAccessible(true);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		try {
			myClassA_fields[2].setAccessible(true);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		try {
			myClassA_fields[3].setAccessible(true);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println("==== Trying again to read the declared fields ====");
		try {
			System.out.println(myClassA_fields[0].get(myClassA));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(myClassA_fields[1].get(myClassA));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(myClassA_fields[2].get(myClassA));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(myClassA_fields[3].get(myClassA));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("==== Getting accessible fields (MAY BE AN ERROR) ====");
		myClassA_fields = myClassA.getClass().getFields();
		for(int i=0; i<myClassA_fields.length; i++){
			System.out.println(myClassA_fields[i].getName()+" "+
					myClassA_fields[i].getModifiers()+" "+
					myClassA_fields[i].isAccessible());
		}
		System.out.println("====================");
		
	}
}
