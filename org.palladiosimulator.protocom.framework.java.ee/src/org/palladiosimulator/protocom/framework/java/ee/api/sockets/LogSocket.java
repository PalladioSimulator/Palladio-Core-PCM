package org.palladiosimulator.protocom.framework.java.ee.api.sockets;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Christian Klaussner
 */
@ServerEndpoint("/ws/log")
public class LogSocket extends WebSocket {
	private static Queue<Session> sessions = new ConcurrentLinkedQueue<Session>();

	/**
	 *
	 * @param message
	 */
	public static void addMessage(String message) {
		//Map<String, Object> payload = new HashMap<String, Object>();
		//payload.put("message", message);

		//String json = JsonHelper.toJson(payload);

		sendToAll(sessions, message);
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
	}
}
