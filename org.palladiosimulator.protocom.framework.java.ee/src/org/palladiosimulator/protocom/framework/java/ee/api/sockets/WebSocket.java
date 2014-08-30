package org.palladiosimulator.protocom.framework.java.ee.api.sockets;

import java.io.IOException;
import java.util.Queue;

import javax.websocket.Session;

/**
 *
 * @author Christian Klaussner
 */
public abstract class WebSocket {

	/**
	 *
	 * @param session
	 * @param message
	 */
	public static void send(Session session, String message) {
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @param sessions
	 * @param message
	 */
	public static void sendToAll(Queue<Session> sessions, String message) {
		for (Session session : sessions) {
			send(session, message);
		}
	}
}
