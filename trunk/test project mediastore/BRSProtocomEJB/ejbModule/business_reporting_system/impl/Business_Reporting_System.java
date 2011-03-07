package business_reporting_system.impl;

public class Business_Reporting_System {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(Business_Reporting_System.class.getName());

	public Business_Reporting_System() {
		logger.info("Creating composed structure Business_Reporting_System");

		try {
			// get the default JNDI initial context
			javax.naming.Context context = new javax.naming.InitialContext();

			{
				// FIXME: add the proper bean reference here (check your server
				// output for the used names)
				Object obj = context
						.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/WebServer_Impl__N8Qq8No_EdyxgfK4Hy_RFA");
				myAC_Webserver = (brs_repository.impl.IWebServer) obj;
			}

			{
				// FIXME: add the proper bean reference here (check your server
				// output for the used names)
				Object obj = context
						.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/Scheduler_Impl__T00ZwNo_EdyxgfK4Hy_RFA");
				myAC_Scheduler = (brs_repository.impl.IScheduler) obj;
			}

			{
				// FIXME: add the proper bean reference here (check your server
				// output for the used names)
				Object obj = context
						.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/CoreOnlineEngine_Impl__VmpjwNo_EdyxgfK4Hy_RFA");
				myAC_CoreOnlineEngine = (brs_repository.impl.ICoreOnlineEngine) obj;
			}

			{
				// FIXME: add the proper bean reference here (check your server
				// output for the used names)
				Object obj = context
						.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/Database_Impl__cWmNkNo_EdyxgfK4Hy_RFA");
				myAC_Database = (brs_repository.impl.IDatabase) obj;
			}

			{
				// FIXME: add the proper bean reference here (check your server
				// output for the used names)
				Object obj = context
						.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/CacheInfo_Impl__e5UB8No_EdyxgfK4Hy_RFA");
				myAC_Cache = (brs_repository.impl.ICacheInfo) obj;
			}

			{
				// FIXME: add the proper bean reference here (check your server
				// output for the used names)
				Object obj = context
						.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/GraphicalReporting_Impl__YH_kEFeoEd6zR8NNmb-sJg");
				myAC_GraphicalReporting__GraphicalReporting_ = (brs_repository.impl.IGraphicalReporting) obj;
			}

			{
				// FIXME: add the proper bean reference here (check your server
				// output for the used names)
				Object obj = context
						.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/OnlineReporting_Impl__iR-r0FeoEd6zR8NNmb-sJg");
				myAC_OnlineReporting__OnlineReporting_ = (brs_repository.impl.IOnlineReporting) obj;
			}

			{
				// FIXME: add the proper bean reference here (check your server
				// output for the used names)
				Object obj = context
						.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/UserManagement_Impl__cmDYoFhJEd6UHd_VhJH9SQ");
				myAC_UserManagement__UserManagement_ = (brs_repository.impl.IUserManagement) obj;
			}

			{
				// FIXME: add the proper bean reference here (check your server
				// output for the used names)
				Object obj = context
						.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/CoreGraphicEngine_Impl__Gnz2UHqQEd6uqIqMUZizUw");
				myAssembly_CoreGraphicEngine__CoreReportingEngine2_ = (brs_repository.impl.ICoreGraphicEngine) obj;
			}

		} catch (javax.naming.NamingException e) {
			e.printStackTrace();
		}

		/* And finally, my ports */

		m_portProvided_IHTTP = new business_reporting_system.impl.ports.IHTTP_Business_Reporting_System(

		myAC_Webserver.getPortProvided_IHTTP_WebServer()

		);

		m_portProvided_IAdmin = new business_reporting_system.impl.ports.IAdmin_Business_Reporting_System(

		myAC_CoreOnlineEngine.getPortProvided_IAdmin_CoreReportingEngine()

		);

	}

	// Composed child components member variables

	protected brs_repository.impl.IWebServer myAC_Webserver = null;

	protected brs_repository.impl.IScheduler myAC_Scheduler = null;

	protected brs_repository.impl.ICoreOnlineEngine myAC_CoreOnlineEngine = null;

	protected brs_repository.impl.IDatabase myAC_Database = null;

	protected brs_repository.impl.ICacheInfo myAC_Cache = null;

	protected brs_repository.impl.IGraphicalReporting myAC_GraphicalReporting__GraphicalReporting_ = null;

	protected brs_repository.impl.IOnlineReporting myAC_OnlineReporting__OnlineReporting_ = null;

	protected brs_repository.impl.IUserManagement myAC_UserManagement__UserManagement_ = null;

	protected brs_repository.impl.ICoreGraphicEngine myAssembly_CoreGraphicEngine__CoreReportingEngine2_ = null;

	/**
	 * Inner Structure initialisation
	 */
	private void initInnerComponents() {

		/* First, initialise composite child structures */

		initAC_CoreOnlineEngine();

		initAssembly_CoreGraphicEngine__CoreReportingEngine2_();

		/* Then initialise basic components */

		initAC_Webserver();

		initAC_Scheduler();

		initAC_Database();

		initAC_Cache();

		initAC_GraphicalReporting__GraphicalReporting_();

		initAC_OnlineReporting__OnlineReporting_();

		initAC_UserManagement__UserManagement_();

	}

	private void initAC_Webserver() {
		brs_repository.impl.contexts.WebServerContext context = new brs_repository.impl.contexts.WebServerContext(

		/* From Connector _Q6ZZYMSGEd2CxsWT-lM9kQ */
		myAC_Scheduler.getPortProvided_IBRSSystem_Scheduler()

		);
		myAC_Webserver.setContext(context);

		// Initialise Component Parameters
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();

		myAC_Webserver.setComponentFrame(componentStackFrame);

	}

	private void initAC_Scheduler() {
		brs_repository.impl.contexts.SchedulerContext context = new brs_repository.impl.contexts.SchedulerContext(

		/* From Connector _kBloQFeoEd6zR8NNmb-sJg */
		myAC_OnlineReporting__OnlineReporting_
				.getPortProvided_IReporting_OnlineReporting()

		,

		/* From Connector _ecj5cFeoEd6zR8NNmb-sJg */
		myAC_GraphicalReporting__GraphicalReporting_
				.getPortProvided_IReporting_GraphicalReporting()

		,

		/* From Connector _ec0F8FhJEd6UHd_VhJH9SQ */
		myAC_UserManagement__UserManagement_
				.getPortProvided_IUserMgmt_UserManagement()

		);
		myAC_Scheduler.setContext(context);

		// Initialise Component Parameters
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();

		myAC_Scheduler.setComponentFrame(componentStackFrame);

	}

	private void initAC_CoreOnlineEngine() {
		brs_repository.impl.contexts.CoreOnlineEngineContext context = new brs_repository.impl.contexts.CoreOnlineEngineContext(

		/* From Connector _iIwZcNo_EdyxgfK4Hy_RFA */
		myAC_Cache.getPortProvided_ICache_CacheInfo()

		,

		/* From Connector _eiDYgNo_EdyxgfK4Hy_RFA */
		myAC_Database.getPortProvided_IDB_DB()

		);
		myAC_CoreOnlineEngine.setContext(context);

	}

	private void initAC_Database() {
		brs_repository.impl.contexts.DatabaseContext context = new brs_repository.impl.contexts.DatabaseContext(

		);
		myAC_Database.setContext(context);

		// Initialise Component Parameters
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();

		componentStackFrame
				.addValue(
						"Entries.NUMBER_OF_ELEMENTS",
						new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy(
								"100000.0",
								new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>()));

		myAC_Database.setComponentFrame(componentStackFrame);

	}

	private void initAC_Cache() {
		brs_repository.impl.contexts.CacheInfoContext context = new brs_repository.impl.contexts.CacheInfoContext(

		/* From Connector _itFOgNo_EdyxgfK4Hy_RFA */
		myAC_Database.getPortProvided_IDB_DB()

		);
		myAC_Cache.setContext(context);

		// Initialise Component Parameters
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();

		myAC_Cache.setComponentFrame(componentStackFrame);

	}

	private void initAC_GraphicalReporting__GraphicalReporting_() {
		brs_repository.impl.contexts.GraphicalReportingContext context = new brs_repository.impl.contexts.GraphicalReportingContext(

		/* From Connector _JmTnwHqQEd6uqIqMUZizUw */
		myAssembly_CoreGraphicEngine__CoreReportingEngine2_
				.getPortProvided_IReporting_CoreReportingEngine2()

		);
		myAC_GraphicalReporting__GraphicalReporting_.setContext(context);

		// Initialise Component Parameters
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();

		myAC_GraphicalReporting__GraphicalReporting_
				.setComponentFrame(componentStackFrame);

	}

	private void initAC_OnlineReporting__OnlineReporting_() {
		brs_repository.impl.contexts.OnlineReportingContext context = new brs_repository.impl.contexts.OnlineReportingContext(

		/* From Connector _l10mAFeoEd6zR8NNmb-sJg */
		myAC_CoreOnlineEngine.getPortProvided_IReporting_CoreReportingEngine()

		);
		myAC_OnlineReporting__OnlineReporting_.setContext(context);

		// Initialise Component Parameters
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();

		myAC_OnlineReporting__OnlineReporting_
				.setComponentFrame(componentStackFrame);

	}

	private void initAC_UserManagement__UserManagement_() {
		brs_repository.impl.contexts.UserManagementContext context = new brs_repository.impl.contexts.UserManagementContext(

		);
		myAC_UserManagement__UserManagement_.setContext(context);

		// Initialise Component Parameters
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();

		myAC_UserManagement__UserManagement_
				.setComponentFrame(componentStackFrame);

	}

	private void initAssembly_CoreGraphicEngine__CoreReportingEngine2_() {
		brs_repository.impl.contexts.CoreGraphicEngineContext context = new brs_repository.impl.contexts.CoreGraphicEngineContext(

		/* From Connector _K-F6EHqQEd6uqIqMUZizUw */
		myAC_Database.getPortProvided_IDB_DB()

		,

		/* From Connector _KgFIYHqQEd6uqIqMUZizUw */
		myAC_Cache.getPortProvided_ICache_CacheInfo()

		);
		myAssembly_CoreGraphicEngine__CoreReportingEngine2_.setContext(context);

	}

	/**
	 * Inner Structure initialisation end
	 */

	protected business_reporting_system.impl.ports.IHTTP_Business_Reporting_System m_portProvided_IHTTP = null;

	protected business_reporting_system.impl.ports.IAdmin_Business_Reporting_System m_portProvided_IAdmin = null;

	public brs_repository.IHTTP getPortProvided_IHTTP() {
		return m_portProvided_IHTTP;
	}

	public brs_repository.IAdmin getPortProvided_IAdmin() {
		return m_portProvided_IAdmin;
	}

	protected business_reporting_system.impl.contexts.IBusiness_Reporting_SystemContext myContext = null;

	public void setContext(
			business_reporting_system.impl.contexts.IBusiness_Reporting_SystemContext myContext) {
		this.myContext = myContext;

		initInnerComponents();

	}

}
