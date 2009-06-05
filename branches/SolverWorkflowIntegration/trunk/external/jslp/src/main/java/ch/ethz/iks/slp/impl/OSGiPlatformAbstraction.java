/* Copyright (c) 2005-2007 Jan S. Rellermeyer
 * Information and Communication Systems Research Group (IKS),
 * Department of Computer Science, ETH Zurich.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *    - Redistributions of source code must retain the above copyright notice,
 *      this list of conditions and the following disclaimer.
 *    - Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *    - Neither the name of ETH Zurich nor the names of its contributors may be
 *      used to endorse or promote products derived from this software without
 *      specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package ch.ethz.iks.slp.impl;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.service.log.LogService;

import ch.ethz.iks.slp.impl.filter.Filter;

/**
 * Platform abstraction for the OSGi implementation.
 * 
 * @author Jan S. Rellermeyer, ETH Zurich
 */
public class OSGiPlatformAbstraction implements PlatformAbstraction,
		ServiceListener {

	/**
	 * 
	 */
	private final BundleContext context;

	/**
	 * 
	 */
	private LogService log;

	/**
	 * 
	 */
	private boolean debug;

	/**
	 * Constructor.
	 * 
	 * @param context
	 *            the bundle context from the OSGi framework.
	 * @param log
	 *            the LogService, or null.
	 * @param debug
	 *            true if debugging is enabled.
	 */
	OSGiPlatformAbstraction(BundleContext context, LogService log, boolean debug) {
		this.context = context;
		this.log = log;
		this.debug = debug;
		if (log != null) {
			if (debug) {
				log.log(LogService.LOG_INFO, "DEBUG OUTPUTS ENABLED");
			} else {
				log.log(LogService.LOG_INFO, "DEBUG OUTPUTS DISABLED");
			}
		}
		try {
			context.addServiceListener(this, "(" + Constants.OBJECTCLASS
					+ "=org.osgi.service.log)");
		} catch (InvalidSyntaxException i) {
			i.printStackTrace();
		}
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#createFilter(java.lang.String)
	 */
	public Filter createFilter(String filterString) {
		try {
			final org.osgi.framework.Filter filter = context
					.createFilter(filterString);
			return new Filter() {
				public boolean match(Dictionary values) {
					return filter.match(values);
				}

				public String toString() {
					return filter.toString();
				}
			};
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#isDebugEnabled()
	 */
	public boolean isDebugEnabled() {
		return log != null && debug;
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#isErrorEnabled()
	 */
	public boolean isErrorEnabled() {
		return log != null;
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#isTraceEnabled()
	 */
	public boolean isTraceEnabled() {
		return log != null;
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#isWarningEnabled()
	 */
	public boolean isWarningEnabled() {
		return log != null;
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#logDebug(java.lang.String)
	 */
	public void logDebug(String message) {
		log.log(LogService.LOG_DEBUG, message);
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#logDebug(java.lang.String,
	 *      java.lang.Throwable)
	 */
	public void logDebug(String message, Throwable exception) {
		log.log(LogService.LOG_DEBUG, message, exception);

	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#logError(java.lang.String)
	 */
	public void logError(String message) {
		log.log(LogService.LOG_ERROR, message);

	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#logError(java.lang.String,
	 *      java.lang.Throwable)
	 */
	public void logError(String message, Throwable exception) {
		log.log(LogService.LOG_ERROR, message, exception);
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#logTrace(java.lang.String)
	 */
	public void logTrace(String message) {
		log.log(LogService.LOG_INFO, message);
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#logTrace(java.lang.String,
	 *      java.lang.Throwable)
	 */
	public void logTrace(String message, Throwable exception) {
		log.log(LogService.LOG_INFO, message, exception);
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#logWarning(java.lang.String)
	 */
	public void logWarning(String message) {
		log.log(LogService.LOG_WARNING, message);
	}

	/**
	 * 
	 * @see ch.ethz.iks.slp.impl.PlatformAbstraction#logWarning(java.lang.String,
	 *      java.lang.Throwable)
	 */
	public void logWarning(String message, Throwable exception) {
		log.log(LogService.LOG_WARNING, message, exception);
	}

	/**
	 * 
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	public void serviceChanged(final ServiceEvent event) {
		switch (event.getType()) {
		case ServiceEvent.REGISTERED:
			log = (LogService) context.getService(event.getServiceReference());
			return;
		case ServiceEvent.UNREGISTERING:
			log = null;
		default:
		}
	}
}
