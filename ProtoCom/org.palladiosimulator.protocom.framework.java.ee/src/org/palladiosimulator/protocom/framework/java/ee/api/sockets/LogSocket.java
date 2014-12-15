package org.palladiosimulator.protocom.framework.java.ee.api.sockets;

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

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.framework.java.ee.api.rest.data.LogData;
import org.palladiosimulator.protocom.framework.java.ee.json.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.ui.LogMessage;
import org.palladiosimulator.protocom.framework.java.ee.ui.WebAppender;

/**
 *
 * @author Christian Klaussner
 */
@ServerEndpoint("/ws/log")
public class LogSocket extends WebSocket {
	private static Queue<Session> sessions = new ConcurrentLinkedQueue<Session>();
	private static boolean enabled = true;

	/**
	 *
	 * @param message
	 */
	public static void append(LogMessage message) {
		LogData data = new LogData();
		data.setPayload(message);
		
		sendToAll(sessions, JsonHelper.toJson(data));
	}

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		sessions.add(session);

		Logger logger = Logger.getRootLogger();
		WebAppender appender = (WebAppender) logger.getAppender(WebAppender.NAME);

		LogData data = new LogData();
		data.setPayload(appender.getLogContent());

		sendToAll(sessions, JsonHelper.toJson(data));
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		// Sending "toggle" switches the state of the log. If you want to implement more 
		// complex communication, you should replace this with some sort of JSON protocol.
		
		if (message.equals("toggle")) {
			enabled = !enabled;
			
			Logger logger = Logger.getRootLogger();
			
			if (enabled) {
				logger.setLevel(Level.INFO);
			} else {
				logger.setLevel(Level.OFF);
			}
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason reason) {
		sessions.remove(session);
	}

	@OnError
	public void onError(Session session, Throwable t) {
	}
}
