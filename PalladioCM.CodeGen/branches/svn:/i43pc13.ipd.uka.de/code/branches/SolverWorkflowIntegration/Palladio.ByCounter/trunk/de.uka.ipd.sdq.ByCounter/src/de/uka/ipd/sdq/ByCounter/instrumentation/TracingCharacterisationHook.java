package de.uka.ipd.sdq.ByCounter.instrumentation;

import org.apache.log4j.Logger;

/**
 * Tracing Hook for debugging purposes.
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
*/
public class TracingCharacterisationHook implements ICharacterisationHook {
	
	/**
	 * log4j logger for this class.
	 */
	Logger log = Logger.getLogger(this.getClass().getCanonicalName());

	@Override
	public void methodCallHook(
			MethodCountMethodAdapter methodCountMethodAdapter,
			InstrumentationParameters instrumentationParameters, 
			int opcode,
			String owner, 
			String name, 
			String desc) {
		log.info("[TracingCharacterisationHook] Method call (" + owner + "." + name + "):");
		log.info("Descriptor: " + desc);
	}

	@Override
	public void methodReturnHook(
			MethodCountMethodAdapter methodCountMethodAdapter, 
			InstrumentationParameters instrumentationParameters) {
		log.info("[TracingCharacterisationHook] Method return");
	}

	@Override
	public void methodStartHook(
			MethodCountMethodAdapter methodCountMethodAdapter,
			InstrumentationParameters instrumentationParameters, 
			int access,
			String name, 
			String desc, 
			String signature,
			String[] exceptions) {
		log.info("[TracingCharacterisationHook] Method start (" + name + "):");
		log.info("Descriptor: " + desc);
		log.info("Signature: " + signature);
		if(exceptions != null) {
			for(String except : exceptions) {
				log.info("Exception: " + except);
			}
		}
	}
}
