package org.palladiosimulator.protocom.framework.java.ee.api.sockets;

import java.io.IOException;
import java.util.Queue;

import javax.websocket.Session;

/**
 * Abstract base class for WebSocket classes.
 * @author Christian Klaussner
 */
public abstract class WebSocket {
	/**
	 * Sends a message in the specified session.
	 * @param session the session in which the message will be sent
	 * @param message the message to send
	 */
	public static void send(Session session, String message) {
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends a message in the specified sessions.
	 * @param sessions the sessions in which the message will be sent
	 * @param message the message to send
	 */
	public static void sendToAll(Queue<Session> sessions, String message) {
		for (Session session : sessions) {
			send(session, message);
		}
	}
}
