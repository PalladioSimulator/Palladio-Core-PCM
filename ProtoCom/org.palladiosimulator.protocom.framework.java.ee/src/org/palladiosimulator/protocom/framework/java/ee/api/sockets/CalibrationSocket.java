package org.palladiosimulator.protocom.framework.java.ee.api.sockets;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.palladiosimulator.protocom.framework.java.ee.main.JsonHelper;

/**
 * WebSocket class for providing real-time calibration updates.
 * @author Christian Klaussner
 */
@ServerEndpoint("/ws/calibration")
public class CalibrationSocket extends WebSocket {
	private static final Queue<Session> SESSIONS = new ConcurrentLinkedQueue<Session>();

	private static int lastProgress;
	private static String lastMessage;

	/**
	 * Builds the payload of a progress update message.
	 * @param progress the new progress (0 to 100)
	 * @param message the message for the progress update
	 * @return a string containing the payload
	 */
	private static String buildPayload(int progress, String message) {
		Map<String, Object> data = new HashMap<String, Object>();

		data.put("progress", progress);
		data.put("message", message);

		return JsonHelper.toJson(data);
	}

	/**
	 * Sends a progress update in all sessions.
	 * @param progress the new progress (0 to 100)
	 * @param message the message for the progress update
	 */
	public static void update(int progress, String message) {
		progress = Math.max(0, Math.min(100, progress));

		lastProgress = progress;
		lastMessage = message;

		String payload = buildPayload(progress, message);

		for (Session session : SESSIONS) {
			send(session, payload);
		}
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
	 * Called when a message is received.
	 * @param message the message
	 * @param session the session of the socket
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		String payload = buildPayload(lastProgress, lastMessage);
		send(session, payload);
	}

	/**
	 * Called when an error occurred.
	 * @param session the session of the socket
	 * @param t a description of the error
	 */
	@OnError
	public void onError(Session session, Throwable t) {
		// Uncomment the next line if the progress bar doesn't update after starting
		// the calibration. In this case, an IllegalStateException is thrown (reason unknown).
		
		// t.printStackTrace();
	}
}
