package edu.kit.ipd.sdq.eventsim.measurement.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares that the annotated class is capable of  
 * 
 * @author pmerkle
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Probe {
	
	Class<?> type();
	
	String property();

}
