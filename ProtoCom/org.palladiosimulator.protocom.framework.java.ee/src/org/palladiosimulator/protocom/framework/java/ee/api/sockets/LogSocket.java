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
import org.palladiosimulator.protocom.framework.java.ee.api.http.data.LogData;
import org.palladiosimulator.protocom.framework.java.ee.main.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.main.LogMessage;
import org.palladiosimulator.protocom.framework.java.ee.main.WebAppender;

/**
 * WebSocket class for providing real-time log updates.
 * @author Christian Klaussner
 */
@ServerEndpoint("/ws/log")
public class LogSocket extends WebSocket {
	private static final Queue<Session> SESSIONS = new ConcurrentLinkedQueue<Session>();

	/**
	 * Sends a log message in all sessions.
	 * @param message the message to send
	 */
	public static void append(LogMessage message) {
		LogData data = new LogData();
		data.setPayload(message);

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

		Logger logger = Logger.getRootLogger();
		WebAppender appender = (WebAppender) logger.getAppender(WebAppender.NAME);

		LogData data = new LogData();
		data.setPayload(appender.getLogContent());

		sendToAll(SESSIONS, JsonHelper.toJson(data));
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
