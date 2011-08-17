package brs_usage_scenario.impl;

import javax.naming.Context;
import javax.naming.InitialContext;

public class BRS_usage_scenario implements java.lang.Runnable {

	protected brs_repository.IAdmin m_portProvided_IAdmin = null;

	protected brs_repository.IHTTP m_portProvided_IHTTP = null;

	public BRS_usage_scenario() {
		javax.naming.InitialContext initial;
		try {
//			initial = new javax.naming.InitialContext();
//			javax.naming.Context context = (javax.naming.Context) initial
//					.lookup("java:comp/env");
//
//			m_portProvided_IAdmin = (brs_repository.IAdmin) javax.rmi.PortableRemoteObject
//					.narrow(context.lookup("ejb/IAdmin"),
//							brs_repository.IAdmin.class);
//
//			m_portProvided_IHTTP = (brs_repository.IHTTP) javax.rmi.PortableRemoteObject
//					.narrow(context.lookup("ejb/IHTTP"),
//							brs_repository.IHTTP.class);
			
			//get the default JNDI initial context
			Context context = new InitialContext();
			{
			//get the business interface
			Object obj=context.lookup(brs_repository.IAdmin.class.getName());
			//convert obj
			m_portProvided_IAdmin = (brs_repository.IAdmin)obj;
			}
			
			{
			//get the business interface
			Object obj=context.lookup(brs_repository.IHTTP.class.getName());
			//convert obj
			m_portProvided_IHTTP = (brs_repository.IHTTP)obj;
			}
		} catch (javax.naming.NamingException e) {
			e.printStackTrace();
		}

		ctx.getStack().createAndPushNewStackFrame();
		// StoExCache.initialiseStoExCache(new
		// de.uka.ipd.sdq.probfunction.math.impl.DefaultRandomGenerator());
		// new
		// de.uka.ipd.sdq.simucomframework.SimuComDefaultRandomNumberGenerator(null);
		de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache
				.initialiseStoExCache(new de.uka.ipd.sdq.probfunction.math.impl.DefaultRandomGenerator());
	}

	private de.uka.ipd.sdq.simucomframework.variables.StackContext ctx = new de.uka.ipd.sdq.simucomframework.variables.StackContext();

	@org.junit.Test
	public void scenarioRunner() {
		/* PROTECTED REGION ID(_qh-cQNpBEdyxgfK4Hy_RFA) ENABLED START */

		// Start a response time measurement
		long startTimeBRS_usage_scenario = System.nanoTime();

		{

			// Start Simulate an external call
			try {
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
						.getStack().currentStackFrame();
				// prepare stackframe
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
						.getStack().createAndPushNewStackFrame();

				stackframe.addValue("type.VALUE", ctx.evaluate("\"login\"",
						currentFrame));

				// Start a response time measurement
				long startTimeCall_processLoginLogout0 = System.nanoTime();

				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

				m_portProvided_IHTTP.processLoginLogout0(ctx);

				// Stop the time measurement

				// Stop the response time measurement
				long endTimeCall_processLoginLogout0 = System.nanoTime();
				long resultCall_processLoginLogout0 = endTimeCall_processLoginLogout0
						- startTimeCall_processLoginLogout0;
				System.out.println("Call_processLoginLogout0: "
						+ resultCall_processLoginLogout0);

			} finally {

				ctx.getStack().removeStackFrame();

			}
			// END Simulate an external call

			for (int iterationCount__fkev4GuVEd629YsFMvxaFg = 0, maxIterationCount__fkev4GuVEd629YsFMvxaFg = (Integer) ctx
					.evaluate("5", Integer.class); iterationCount__fkev4GuVEd629YsFMvxaFg < maxIterationCount__fkev4GuVEd629YsFMvxaFg; iterationCount__fkev4GuVEd629YsFMvxaFg++) {

				for (int iterationCount__votskNpBEdyxgfK4Hy_RFA = 0, maxIterationCount__votskNpBEdyxgfK4Hy_RFA = (Integer) ctx
						.evaluate("5", Integer.class); iterationCount__votskNpBEdyxgfK4Hy_RFA < maxIterationCount__votskNpBEdyxgfK4Hy_RFA; iterationCount__votskNpBEdyxgfK4Hy_RFA++) {

					// Start Simulate an external call
					try {
						de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
								.getStack().currentStackFrame();
						// prepare stackframe
						de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
								.getStack().createAndPushNewStackFrame();

						stackframe.addValue("type.VALUE", ctx.evaluate(
								"\"view\"", currentFrame));

						stackframe.addValue("type.TYPE", ctx.evaluate(
								"\"online\"", currentFrame));

						stackframe.addValue("requestedEntries.VALUE", ctx
								.evaluate("7", currentFrame));

						// Start a response time measurement
						long startTimeCall_processOnlineView4 = System
								.nanoTime();

						de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

						m_portProvided_IHTTP.processOnlineView4(ctx);

						// Stop the time measurement

						// Stop the response time measurement
						long endTimeCall_processOnlineView4 = System.nanoTime();
						long resultCall_processOnlineView4 = endTimeCall_processOnlineView4
								- startTimeCall_processOnlineView4;
						System.out.println("Call_processOnlineView4: "
								+ resultCall_processOnlineView4);

					} finally {

						ctx.getStack().removeStackFrame();

					}
					// END Simulate an external call

				}

				// Start Simulate an external call
				try {
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
							.getStack().currentStackFrame();
					// prepare stackframe
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
							.getStack().createAndPushNewStackFrame();

					stackframe.addValue("type.VALUE", ctx.evaluate(
							"\"logout\"", currentFrame));

					// Start a response time measurement
					long startTimeCall_processLoginLogout0 = System.nanoTime();

					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

					m_portProvided_IHTTP.processLoginLogout0(ctx);

					// Stop the time measurement

					// Stop the response time measurement
					long endTimeCall_processLoginLogout0 = System.nanoTime();
					long resultCall_processLoginLogout0 = endTimeCall_processLoginLogout0
							- startTimeCall_processLoginLogout0;
					System.out.println("Call_processLoginLogout0: "
							+ resultCall_processLoginLogout0);

				} finally {

					ctx.getStack().removeStackFrame();

				}
				// END Simulate an external call

				// Start Simulate an external call
				try {
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
							.getStack().currentStackFrame();
					// prepare stackframe
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
							.getStack().createAndPushNewStackFrame();

					stackframe.addValue("type.VALUE", ctx.evaluate("\"login\"",
							currentFrame));

					// Start a response time measurement
					long startTimeCall_processLoginLogout0 = System.nanoTime();

					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

					m_portProvided_IHTTP.processLoginLogout0(ctx);

					// Stop the time measurement

					// Stop the response time measurement
					long endTimeCall_processLoginLogout0 = System.nanoTime();
					long resultCall_processLoginLogout0 = endTimeCall_processLoginLogout0
							- startTimeCall_processLoginLogout0;
					System.out.println("Call_processLoginLogout0: "
							+ resultCall_processLoginLogout0);

				} finally {

					ctx.getStack().removeStackFrame();

				}
				// END Simulate an external call

				// Start Simulate an external call
				try {
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
							.getStack().currentStackFrame();
					// prepare stackframe
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
							.getStack().createAndPushNewStackFrame();

					stackframe.addValue("type.VALUE", ctx.evaluate("\"view\"",
							currentFrame));

					stackframe.addValue("type.TYPE", ctx.evaluate(
							"\"graphical\"", currentFrame));

					stackframe.addValue("requestedEntries.VALUE", ctx.evaluate(
							"7", currentFrame));

					// Start a response time measurement
					long startTimeCall_processGraphicalView3 = System
							.nanoTime();

					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

					m_portProvided_IHTTP.processGraphicalView3(ctx);

					// Stop the time measurement

					// Stop the response time measurement
					long endTimeCall_processGraphicalView3 = System.nanoTime();
					long resultCall_processGraphicalView3 = endTimeCall_processGraphicalView3
							- startTimeCall_processGraphicalView3;
					System.out.println("Call_processGraphicalView3: "
							+ resultCall_processGraphicalView3);

				} finally {

					ctx.getStack().removeStackFrame();

				}
				// END Simulate an external call

				// Start Simulate an external call
				try {
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
							.getStack().currentStackFrame();
					// prepare stackframe
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
							.getStack().createAndPushNewStackFrame();

					stackframe.addValue("type.VALUE", ctx.evaluate(
							"\"report\"", currentFrame));

					stackframe.addValue("type.TYPE", ctx.evaluate("\"online\"",
							currentFrame));

					stackframe
							.addValue("isDetailed.VALUE", ctx.evaluate(
									"EnumPMF[ (\"t\";0.1) (\"f\";0.9) ]",
									currentFrame));

					stackframe.addValue("requestedEntries.VALUE", ctx.evaluate(
							"7", currentFrame));

					// Start a response time measurement
					long startTimeCall_processOnlineReport2 = System.nanoTime();

					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

					m_portProvided_IHTTP.processOnlineReport2(ctx);

					// Stop the time measurement

					// Stop the response time measurement
					long endTimeCall_processOnlineReport2 = System.nanoTime();
					long resultCall_processOnlineReport2 = endTimeCall_processOnlineReport2
							- startTimeCall_processOnlineReport2;
					System.out.println("Call_processOnlineReport2: "
							+ resultCall_processOnlineReport2);

				} finally {

					ctx.getStack().removeStackFrame();

				}
				// END Simulate an external call

			}

			// Start Simulate an external call
			try {
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
						.getStack().currentStackFrame();
				// prepare stackframe
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
						.getStack().createAndPushNewStackFrame();

				stackframe.addValue("type.VALUE", ctx.evaluate("\"report\"",
						currentFrame));

				stackframe.addValue("type.TYPE", ctx.evaluate("\"graphical\"",
						currentFrame));

				stackframe.addValue("requestedEntries.VALUE", ctx.evaluate("7",
						currentFrame));

				stackframe.addValue("isDetailed.VALUE", ctx.evaluate(
						"EnumPMF[ (\"t\";0.1) (\"f\";0.9) ]", currentFrame));

				// Start a response time measurement
				long startTimeCall_processGraphicalReport1 = System.nanoTime();

				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

				m_portProvided_IHTTP.processGraphicalReport1(ctx);

				// Stop the time measurement

				// Stop the response time measurement
				long endTimeCall_processGraphicalReport1 = System.nanoTime();
				long resultCall_processGraphicalReport1 = endTimeCall_processGraphicalReport1
						- startTimeCall_processGraphicalReport1;
				System.out.println("Call_processGraphicalReport1: "
						+ resultCall_processGraphicalReport1);

			} finally {

				ctx.getStack().removeStackFrame();

			}
			// END Simulate an external call

			// Start Simulate an external call
			try {
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
						.getStack().currentStackFrame();
				// prepare stackframe
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
						.getStack().createAndPushNewStackFrame();

				stackframe.addValue("type.VALUE", ctx.evaluate("\"logout\"",
						currentFrame));

				// Start a response time measurement
				long startTimeCall_processLoginLogout0 = System.nanoTime();

				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

				m_portProvided_IHTTP.processLoginLogout0(ctx);

				// Stop the time measurement

				// Stop the response time measurement
				long endTimeCall_processLoginLogout0 = System.nanoTime();
				long resultCall_processLoginLogout0 = endTimeCall_processLoginLogout0
						- startTimeCall_processLoginLogout0;
				System.out.println("Call_processLoginLogout0: "
						+ resultCall_processLoginLogout0);

			} finally {

				ctx.getStack().removeStackFrame();

			}
			// END Simulate an external call

			// Start Simulate an external call
			try {
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
						.getStack().currentStackFrame();
				// prepare stackframe
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
						.getStack().createAndPushNewStackFrame();

				// Start a response time measurement
				long startTimeCall_maintain0 = System.nanoTime();

				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =

				m_portProvided_IAdmin.maintain0(ctx);

				// Stop the time measurement

				// Stop the response time measurement
				long endTimeCall_maintain0 = System.nanoTime();
				long resultCall_maintain0 = endTimeCall_maintain0
						- startTimeCall_maintain0;
				System.out.println("Call_maintain0: " + resultCall_maintain0);

			} finally {

				ctx.getStack().removeStackFrame();

			}
			// END Simulate an external call

		}

		// Stop the response time measurement
		long endTimeBRS_usage_scenario = System.nanoTime();
		long resultBRS_usage_scenario = endTimeBRS_usage_scenario
				- startTimeBRS_usage_scenario;
		System.out.println("BRS_usage_scenario: " + resultBRS_usage_scenario);

		/* PROTECTED REGION END */
	}

	public void run() {
		scenarioRunner();
	}
}
