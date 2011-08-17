
      
	
   package defaultsystem.impl;
  
   public class defaultSystem 
   {
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(defaultSystem.class.getName());
	  
	public defaultSystem() {
		logger.info("Creating composed structure defaultSystem");
		
	
	try {
		//get the default JNDI initial context
		javax.naming.Context context = new javax.naming.InitialContext();
		
		
	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEARFlat/BRSProtocomEJBFlat/WebServer_Impl__XKuBcKSKEd-ujcVHnT0lvg");	
		myAssembly_WebServer__WebServer_ = (brs_repository.impl.IWebServer)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEARFlat/BRSProtocomEJBFlat/Scheduler_Impl__YNP1cKSKEd-ujcVHnT0lvg");	
		myAssembly_Scheduler__Scheduler_ = (brs_repository.impl.IScheduler)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEARFlat/BRSProtocomEJBFlat/UserManagement_Impl__ZkJW8KSKEd-ujcVHnT0lvg");	
		myAssembly_UserManagement__UserManagement_ = (brs_repository.impl.IUserManagement)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEARFlat/BRSProtocomEJBFlat/GraphicalReporting_Impl__sj8o0KSKEd-ujcVHnT0lvg");	
		myAssembly_GraphicalReporting__GraphicalReporting_ = (brs_repository.impl.IGraphicalReporting)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEARFlat/BRSProtocomEJBFlat/OnlineReporting_Impl__tg1H0KSKEd-ujcVHnT0lvg");	
		myAssembly_OnlineReporting__OnlineReporting_ = (brs_repository.impl.IOnlineReporting)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEARFlat/BRSProtocomEJBFlat/InnerCoreReportingEngine_Impl__uq0OsKSKEd-ujcVHnT0lvg");	
		myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_ = (brs_repository.impl.IInnerCoreReportingEngine)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEARFlat/BRSProtocomEJBFlat/CRESingleMessageAdapter_Impl__vv19EKSKEd-ujcVHnT0lvg");	
		myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_ = (brs_repository.impl.ICRESingleMessageAdapter)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEARFlat/BRSProtocomEJBFlat/CacheInfo_Impl__xwoJEKSKEd-ujcVHnT0lvg");	
		myAssembly_CacheInfo__CacheInfo_ = (brs_repository.impl.ICacheInfo)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEARFlat/BRSProtocomEJBFlat/Database_Impl__yzOOgKSKEd-ujcVHnT0lvg");	
		myAssembly_Database__Database_ = (brs_repository.impl.IDatabase)obj;
    }

	} catch (javax.naming.NamingException e) {
		e.printStackTrace();
	}


	      
		
			/* And finally, my ports */
			
m_portIHTTP_System_Provided = new defaultsystem.impl.ports.IHTTP_defaultSystem(
		
			myAssembly_WebServer__WebServer_.
			getPortProvided_IHTTP_WebServer()
		
		);

m_portIAdmin_System_Provided = new defaultsystem.impl.ports.IAdmin_defaultSystem(
		
			myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_.
			getPortProvided_IAdmin_ReportingEngine()
		
		);

		
	}
		
      
      // Composed child components member variables
      
   protected 
      brs_repository.impl.IWebServer 
         myAssembly_WebServer__WebServer_ = null;

   protected 
      brs_repository.impl.IScheduler 
         myAssembly_Scheduler__Scheduler_ = null;

   protected 
      brs_repository.impl.IUserManagement 
         myAssembly_UserManagement__UserManagement_ = null;

   protected 
      brs_repository.impl.IGraphicalReporting 
         myAssembly_GraphicalReporting__GraphicalReporting_ = null;

   protected 
      brs_repository.impl.IOnlineReporting 
         myAssembly_OnlineReporting__OnlineReporting_ = null;

   protected 
      brs_repository.impl.IInnerCoreReportingEngine 
         myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_ = null;

   protected 
      brs_repository.impl.ICRESingleMessageAdapter 
         myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_ = null;

   protected 
      brs_repository.impl.ICacheInfo 
         myAssembly_CacheInfo__CacheInfo_ = null;

   protected 
      brs_repository.impl.IDatabase 
         myAssembly_Database__Database_ = null;

            
      /**
      * Inner Structure initialisation
      */
      private void initInnerComponents() {
    	  
    	  System.out.println("Initialising inner system components.");

		  /* First, initialise composite child structures */
		  
		  /* Then initialise basic components */
		  
			  initAssembly_WebServer__WebServer_();
		  
			  initAssembly_Scheduler__Scheduler_();
		  
			  initAssembly_UserManagement__UserManagement_();
		  
			  initAssembly_GraphicalReporting__GraphicalReporting_();
		  
			  initAssembly_OnlineReporting__OnlineReporting_();
		  
			  initAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_();
		  
			  initAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_();
		  
			  initAssembly_CacheInfo__CacheInfo_();
		  
			  initAssembly_Database__Database_();
		  
      }

      
   private void initAssembly_WebServer__WebServer_() {
      brs_repository.impl.contexts.WebServerContext context = new brs_repository.impl.contexts.WebServerContext(
         
	
		
			/* From Connector _5ZA2wKSKEd-ujcVHnT0lvg */
			myAssembly_Scheduler__Scheduler_.getPortProvided_IBRSSystem_Scheduler()
	   	
	

      );
      myAssembly_WebServer__WebServer_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	

	myAssembly_WebServer__WebServer_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_Scheduler__Scheduler_() {
      brs_repository.impl.contexts.SchedulerContext context = new brs_repository.impl.contexts.SchedulerContext(
         
	
		
			/* From Connector _5_868KSKEd-ujcVHnT0lvg */
			myAssembly_OnlineReporting__OnlineReporting_.getPortProvided_IReporting_OnlineReporting()
	   	
	
,
	
		
			/* From Connector _7IHc4KSKEd-ujcVHnT0lvg */
			myAssembly_GraphicalReporting__GraphicalReporting_.getPortProvided_IReporting_GraphicalReporting()
	   	
	
,
	
		
			/* From Connector _8YqewKSKEd-ujcVHnT0lvg */
			myAssembly_UserManagement__UserManagement_.getPortProvided_IUserMgmt_UserManagement()
	   	
	

      );
      myAssembly_Scheduler__Scheduler_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_Scheduler__Scheduler_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_UserManagement__UserManagement_() {
      brs_repository.impl.contexts.UserManagementContext context = new brs_repository.impl.contexts.UserManagementContext(
         
      );
      myAssembly_UserManagement__UserManagement_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_UserManagement__UserManagement_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_GraphicalReporting__GraphicalReporting_() {
      brs_repository.impl.contexts.GraphicalReportingContext context = new brs_repository.impl.contexts.GraphicalReportingContext(
         
	
		
			/* From Connector _9G1MUKSKEd-ujcVHnT0lvg */
			myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_.getPortProvided_IReporting_ReportingEngine()
	   	
	

      );
      myAssembly_GraphicalReporting__GraphicalReporting_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_GraphicalReporting__GraphicalReporting_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_OnlineReporting__OnlineReporting_() {
      brs_repository.impl.contexts.OnlineReportingContext context = new brs_repository.impl.contexts.OnlineReportingContext(
         
	
		
			/* From Connector _9dy60KSKEd-ujcVHnT0lvg */
			myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_.getPortProvided_IReporting_ReportingEngine()
	   	
	

      );
      myAssembly_OnlineReporting__OnlineReporting_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_OnlineReporting__OnlineReporting_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_() {
      brs_repository.impl.contexts.InnerCoreReportingEngineContext context = new brs_repository.impl.contexts.InnerCoreReportingEngineContext(
         
	
		
			/* From Connector __-ZPUKSKEd-ujcVHnT0lvg */
			myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_.getPortProvided_IDB_CRESingleMessageAdapter()
	   	
	
,
	
		
			/* From Connector _AMf8wKSLEd-ujcVHnT0lvg */
			myAssembly_CacheInfo__CacheInfo_.getPortProvided_ICache_CacheInfo()
	   	
	

      );
      myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_() {
      brs_repository.impl.contexts.CRESingleMessageAdapterContext context = new brs_repository.impl.contexts.CRESingleMessageAdapterContext(
         
	
		
			/* From Connector _AbFLUKSLEd-ujcVHnT0lvg */
			myAssembly_Database__Database_.getPortProvided_IDB_DB()
	   	
	

      );
      myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_CacheInfo__CacheInfo_() {
      brs_repository.impl.contexts.CacheInfoContext context = new brs_repository.impl.contexts.CacheInfoContext(
         
	
		
			/* From Connector _AlTeUKSLEd-ujcVHnT0lvg */
			myAssembly_Database__Database_.getPortProvided_IDB_DB()
	   	
	

      );
      myAssembly_CacheInfo__CacheInfo_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_CacheInfo__CacheInfo_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_Database__Database_() {
      brs_repository.impl.contexts.DatabaseContext context = new brs_repository.impl.contexts.DatabaseContext(
         
      );
      myAssembly_Database__Database_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	componentStackFrame.addValue("Entries.NUMBER_OF_ELEMENTS",
		   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("100000",
		   	new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>()));
	
	myAssembly_Database__Database_.setComponentFrame(componentStackFrame);

	

   }

      /**
      * Inner Structure initialisation end
      */


    
	
    

    

	
    protected defaultsystem.impl.ports.IHTTP_defaultSystem m_portIHTTP_System_Provided = null;

    protected defaultsystem.impl.ports.IAdmin_defaultSystem m_portIAdmin_System_Provided = null;

   	
   public brs_repository.IHTTP getPortIHTTP_System_Provided () {
      return m_portIHTTP_System_Provided;
   }

   public brs_repository.IAdmin getPortIAdmin_System_Provided () {
      return m_portIAdmin_System_Provided;
   }


	
   
   

   
   

   
   protected defaultsystem.impl.contexts.IdefaultSystemContext myContext = null;

   
   public void setContext(defaultsystem.impl.contexts.IdefaultSystemContext myContext) {
      this.myContext = myContext;
      
      	initInnerComponents();
      
   }


	
   }

	
	
	



   