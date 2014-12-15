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

import org.palladiosimulator.protocom.framework.java.ee.json.JsonHelper;

/**
 *
 * @author Christian Klaussner
 */
@ServerEndpoint("/ws/calibration")
public class CalibrationSocket extends WebSocket {
	private static Queue<Session> sessions = new ConcurrentLinkedQueue<Session>();

	private static int lastProgress;
	private static String lastMessage;

	/**
	 *
	 * @param progress
	 * @param message
	 * @return
	 */
	private static String buildPayload(int progress, String message) {
		Map<String, Object> data = new HashMap<String, Object>();

		data.put("progress", progress);
		data.put("message", message);

		return JsonHelper.toJson(data);
	}

	/**
	 *
	 * @param progress
	 * @param message
	 */
	public static void update(int progress, String message) {
		progress = Math.max(0, Math.min(100, progress));

		lastProgress = progress;
		lastMessage = message;

		String payload = buildPayload(progress, message);

		for (Session session : sessions) {
			send(session, payload);
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

	@OnMessage
	public void onMessage(String message, Session session) {
		String payload = buildPayload(lastProgress, lastMessage);
		send(session, payload);
	}

	@OnError
	public void onError(Session session, Throwable t) {
		// Uncomment the next line if the progress bar doesn't update after starting
		// the calibration. In this case, an IllegalStateException is thrown (reason unknown).
		
		// t.printStackTrace();
	}
}
