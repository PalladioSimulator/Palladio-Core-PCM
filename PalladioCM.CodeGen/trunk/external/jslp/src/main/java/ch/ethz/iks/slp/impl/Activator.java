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

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.log.LogService;

/**
 * Bundle Activator, also serves as a ServiceFactory for Advertiser and Locator
 * services and as listener for appearing log services to allow on-demand
 * logging.
 * 
 * @author Jan S. Rellermeyer, ETH Zurich
 */
public class Activator implements BundleActivator, ServiceFactory {

	/**
	 * 
	 */
	private ServiceRegistration advertiserReg;

	/**
	 * 
	 */
	private ServiceRegistration locatorReg;

	/**
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(final BundleContext context) throws Exception {
		LogService log = null;
		final ServiceReference sref = context
				.getServiceReference(LogService.class.getName());
		if (sref != null) {
			log = (LogService) context.getService(sref);
		}

		// initialize the platform abstraction layer
		SLPCore.platform = new OSGiPlatformAbstraction(context, log, Boolean
				.valueOf(context.getProperty("ch.ethz.iks.slp.debug"))
				.booleanValue());
		SLPCore.init();

		// register the service factories
		advertiserReg = context.registerService("ch.ethz.iks.slp.Advertiser",
				this, null);
		locatorReg = context.registerService("ch.ethz.iks.slp.Locator", this,
				null);

		if (log != null) {
			log.log(LogService.LOG_DEBUG, "jSLP OSGi started.");
		} else {
			if (context.getProperty("net.slp.traceMsg") != null) {
				System.err
						.println("NO LOG SERVICE FOUND, MESSAGE TRACING DISABLED");
			}
			if (context.getProperty("ch.ethz.iks.slp.debug") != null) {
				System.err.println("NO LOG SERVICE FOUND, DEBUG DISABLED");
			}
		}

	}

	/**
	 * 
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(final BundleContext context) throws Exception {

	}

	/**
	 * 
	 * @see org.osgi.framework.ServiceFactory#getService(org.osgi.framework.Bundle,
	 *      org.osgi.framework.ServiceRegistration)
	 */
	public Object getService(final Bundle bundle,
			final ServiceRegistration registration) {
		if (registration == advertiserReg) {
			return new AdvertiserImpl();
		} else if (registration == locatorReg) {
			return new LocatorImpl();
		}
		return null;
	}

	/**
	 * 
	 * @see org.osgi.framework.ServiceFactory#ungetService(org.osgi.framework.Bundle,
	 *      org.osgi.framework.ServiceRegistration, java.lang.Object)
	 */
	public void ungetService(final Bundle bundle,
			final ServiceRegistration registration, Object service) {

	}

}
