package org.palladiosimulator.protocom.framework.java.ee.api.sockets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.palladiosimulator.protocom.framework.java.ee.json.JsonHelper;

@ServerEndpoint("/sock/log")
public class LogSocket {
	private static Queue<Session> sessions = new ConcurrentLinkedQueue<Session>();

	public void addMessage(String message) {
		try {
			for (Session session : sessions) {
				Map<String, Object> payload = new HashMap<String, Object>();
				payload.put("message", message);

				session.getBasicRemote().sendText(JsonHelper.toJson(payload));
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
