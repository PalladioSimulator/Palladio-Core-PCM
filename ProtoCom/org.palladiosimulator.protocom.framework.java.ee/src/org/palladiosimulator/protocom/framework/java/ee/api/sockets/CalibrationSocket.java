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

@ServerEndpoint("/sock/calibration")
public class CalibrationSocket {
	private static Queue<Session> sessions = new ConcurrentLinkedQueue<Session>();

	private static int lastProgress;
	private static String lastMessage;

	private static String buildPayload(int progress, String message) {
		Map<String, Object> data = new HashMap<String, Object>();

		data.put("progress", progress);
		data.put("message", message);

		return JsonHelper.toJson(data);
	}

	public static void update(int progress, String message) {
		progress = Math.max(0, Math.min(100, progress));

		lastProgress = progress;
		lastMessage = message;

		try {
			String payload = buildPayload(progress, message);

			for (Session session : sessions) {
				// String json = "{\"progress\":" + progress + "}";
				session.getBasicRemote().sendText(payload);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		sessions.add(session);

		try {
			String payload = buildPayload(lastProgress, lastMessage);
			session.getBasicRemote().sendText(payload);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
