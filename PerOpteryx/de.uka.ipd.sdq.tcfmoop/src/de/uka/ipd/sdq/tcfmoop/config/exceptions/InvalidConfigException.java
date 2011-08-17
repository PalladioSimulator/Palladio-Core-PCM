/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.config.exceptions;

/**
 *
 * An Exception thrown in case the parameters supplied
 * to the Configuration classes are not valid
 * @author Atanas Dimitrov
 */
@SuppressWarnings("serial")
public class InvalidConfigException extends Exception {
	
	public InvalidConfigException(String message){
		super(message);
	}
	
}
