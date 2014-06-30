package org.palladiosimulator.protocom.tech.rmi.system;

public class X extends NanoHTTPD {

	public X() {
		super(8081);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Response serve(IHTTPSession session) {
		return new Response(MIME_HTML);
	}
}
