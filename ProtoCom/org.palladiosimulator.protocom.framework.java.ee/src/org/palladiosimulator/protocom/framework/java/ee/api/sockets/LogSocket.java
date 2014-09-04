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

import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.framework.java.ee.ui.WebAppender;

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
	public static void append(String message) {
		sendToAll(sessions, message);
	}

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		sessions.add(session);

		Logger logger = Logger.getRootLogger();
		WebAppender appender = (WebAppender) logger.getAppender(WebAppender.NAME);

		sendToAll(sessions, appender.getLogContent());
	}

	@OnClose
	public void onClose(Session session, CloseReason reason) {
		sessions.remove(session);
	}

	@OnError
	public void onError(Session session, Throwable t) {
	}
}
