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

@ServerEndpoint("/ws/results")
public class ResultsSocket extends WebSocket {
	private static Queue<Session> sessions = new ConcurrentLinkedQueue<Session>();

	public static void update(ExperimentData data) {
		sendToAll(sessions, JsonHelper.toJson(data));
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
