package org.palladiosimulator.protocom.framework.java.ee.api.sockets;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/sock/calibration")
public class CalibrationSocket {
	private static Queue<Session> sessions = new ConcurrentLinkedQueue<Session>();

	public static void update(int progress) {
		progress = Math.max(0, Math.min(100, progress));

		try {
			for (Session session : sessions) {
				String json = "{\"progress\":" + progress + "}";
				session.getBasicRemote().sendText(json);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		sessions.add(session);
	}

	@OnClose
	public void onClose(Session session, CloseReason reason) {
		sessions.remove(session);
	}

	@OnError
	public void onError(Session session, Throwable t) {
		// FIXME: Tomcat throws a SocketException before onOpen is called. Ignore for now.
		// t.printStackTrace();
	}
}
