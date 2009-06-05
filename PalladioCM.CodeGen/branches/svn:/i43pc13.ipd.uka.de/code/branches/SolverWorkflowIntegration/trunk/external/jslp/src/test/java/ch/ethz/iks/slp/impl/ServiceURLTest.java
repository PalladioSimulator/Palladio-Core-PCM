package ch.ethz.iks.slp.impl;

import ch.ethz.iks.slp.ServiceURL;
import junit.framework.TestCase;

public class ServiceURLTest extends TestCase {

	public ServiceURLTest() {
		super("ServiceURLTest");
		System.setProperty("net.slp.port", "10427");
	}
	
	public void testServiceURL1() throws Exception {
		String urlString = "service:test:myservice://localhost";
		ServiceURL url = new ServiceURL(urlString, 0);
		assertEquals(url.getServiceType().toString(), "service:test:myservice");
		assertEquals(url.getHost(), "localhost");
		assertEquals(url.getPort(), 0);
		assertEquals(url.getURLPath(), "");
		assertEquals(url.getProtocol(), null);
		assertEquals(url.toString(), urlString);
	}

	public void testServiceURL2() throws Exception {
		String urlString = "service:test:myservice://localhost:80";
		ServiceURL url = new ServiceURL(urlString, 0);
		assertEquals(url.getServiceType().toString(), "service:test:myservice");
		assertEquals(url.getHost(), "localhost");
		assertEquals(url.getPort(), 80);
		assertEquals(url.getURLPath(), "");
		assertEquals(url.getProtocol(), null);
		assertEquals(url.toString(), urlString);
	}

	public void testServiceURL3() throws Exception {
		String urlString = "service:test:myservice://localhost:80/path";
		ServiceURL url = new ServiceURL(urlString, 0);
		assertEquals(url.getServiceType().toString(), "service:test:myservice");
		assertEquals(url.getHost(), "localhost");
		assertEquals(url.getPort(), 80);
		assertEquals(url.getURLPath(), "/path");
		assertEquals(url.getProtocol(), null);
		assertEquals(url.toString(), urlString);
	}

	public void testServiceURL4() throws Exception {
		String urlString = "service:test:myservice://localhost/my/path";
		ServiceURL url = new ServiceURL(urlString, 0);
		assertEquals(url.getServiceType().toString(), "service:test:myservice");
		assertEquals(url.getHost(), "localhost");
		assertEquals(url.getPort(), 0);
		assertEquals(url.getURLPath(), "/my/path");
		assertEquals(url.getProtocol(), null);
		assertEquals(url.toString(), urlString);
	}

	public void testServiceURL5() throws Exception {
		String urlString = "service:test:myservice://http://localhost:8080/my/path";
		ServiceURL url = new ServiceURL(urlString, 0);
		assertEquals(url.getServiceType().toString(), "service:test:myservice");
		assertEquals(url.getHost(), "localhost");
		assertEquals(url.getPort(), 8080);
		assertEquals(url.getURLPath(), "/my/path");
		assertEquals(url.getProtocol(), "http");
		assertEquals(url.toString(), urlString);
	}

	public void testServiceURL6() throws Exception {
		String urlString = "service:test://http://localhost";
		ServiceURL url = new ServiceURL(urlString, 0);
		assertEquals(url.getServiceType().toString(), "service:test");
		assertEquals(url.getHost(), "localhost");
		assertEquals(url.getPort(), 0);
		assertEquals(url.getURLPath(), "");
		assertEquals(url.getProtocol(), "http");
		assertEquals(url.toString(), urlString);
	}
}
