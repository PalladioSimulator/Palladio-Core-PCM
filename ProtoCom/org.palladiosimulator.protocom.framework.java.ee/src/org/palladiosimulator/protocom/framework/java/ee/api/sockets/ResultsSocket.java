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

import org.palladiosimulator.protocom.framework.java.ee.experiment.ExperimentData;
import org.palladiosimulator.protocom.framework.java.ee.main.JsonHelper;

/**
 * WebSocket class for providing real-time result updates.
 * @author Christian Klaussner
 */
@ServerEndpoint("/ws/results")
public class ResultsSocket extends WebSocket {
	private static final Queue<Session> SESSIONS = new ConcurrentLinkedQueue<Session>();

	/**
	 * Sends experiment meta data in all sessions.
	 * @param data the data so send
	 */
	public static void update(ExperimentData data) {
		sendToAll(SESSIONS, JsonHelper.toJson(data));
	}

	/**
	 * Called when a socket is opened.
	 * @param session the session of the socket
	 * @param config the endpoint configuration
	 */
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		SESSIONS.add(session);
	}

	/**
	 * Called when a socket is closed.
	 * @param session the session of the socket
	 * @param reason the close reason
	 */
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		SESSIONS.remove(session);
	}

	/**
	 * Called when an error occurred.
	 * @param session the session of the socket
	 * @param t a description of the error
	 */
	@OnError
	public void onError(Session session, Throwable t) {
	}
}
