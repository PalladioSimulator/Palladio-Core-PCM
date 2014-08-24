package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.palladiosimulator.protocom.framework.java.ee.api.sockets.CalibrationSocket;
import org.palladiosimulator.protocom.framework.java.ee.storage.Storage;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.ICalibrationListener;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.cpu.FibonacciDemand;

/**
 *
 * @author Christian Klaussner
 */
class CalibrationThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setDaemon(true);

		return thread;
	}
}

/**
 *
 * @author Christian Klaussner
 */
class Calibrator implements Runnable, ICalibrationListener {
	private ServletContext context;

	public Calibrator(ServletContext context) {
		this.context = context;
	}

	@Override
	public void progressChanged(float progress) {
		int percent = (int) (progress * 100.0f);
		String message = "Calibrating CPU Strategy: " + percent + "%";

		CalibrationSocket.update(percent, message);
	}

	@Override
	public void run() {
		FibonacciDemand strategy = new FibonacciDemand();

		strategy.setCalibrationListener(this);
		strategy.initializeStrategy(DegreeOfAccuracyEnum.LOW, 1.0);

		context.setAttribute("status", "started");
	}
}

/**
 *
 * @author Christian Klaussner
 */
@Path("/options")
public class Options {
	@Context
	private ServletContext context;

	private static ExecutorService executor;

	static {
		CalibrationThreadFactory factory = new CalibrationThreadFactory();
		executor = Executors.newFixedThreadPool(1, factory);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getOptions() {
		Storage storage = new Storage();

		try {
			return storage.readFileAsString("options.json");
		} catch (FileNotFoundException e) {
			return "{}";
		}
	}

	@POST
	public void setOptions(String data) {
		Storage storage = new Storage();

		context.setAttribute("status", "calibrating");

		executor.submit(new Calibrator(context));

		/*executor.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("running progress");
				int progress = 0;

				while (progress < 100) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					progress += 10;

					if (progress >= 100) {
						progress = 100;

						context.setAttribute("status", "started");
					}

					CalibrationSocket.update(progress);
				}
			}
		});*/

		try {
			// TODO: Validate input
			storage.writeFile("options.json", data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
