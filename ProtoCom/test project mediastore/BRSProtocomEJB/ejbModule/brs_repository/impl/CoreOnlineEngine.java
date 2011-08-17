
		
   package brs_repository.impl;
  
   public class CoreOnlineEngine implements ICoreOnlineEngine 
   {
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(CoreOnlineEngine.class.getName());
	  
	public CoreOnlineEngine() {
		logger.info("Creating composed structure CoreOnlineEngine");
		
	
	try {
		//get the default JNDI initial context
		javax.naming.Context context = new javax.naming.InitialContext();
		
		
	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/InnerCoreReportingEngine_Impl__Fjb24Go3Ed631pecjlFspw");	
		myAssembly_FastCoreReportingEngine__FastCoreReportingEngine_ = (brs_repository.impl.IInnerCoreReportingEngine)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/BRSProtocomEAR/BRSProtocomEJB/CRESingleMessageAdapter_Impl__GldUkGo3Ed631pecjlFspw");	
		myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_ = (brs_repository.impl.ICRESingleMessageAdapter)obj;
    }

	} catch (javax.naming.NamingException e) {
		e.printStackTrace();
	}


	      
		
			/* And finally, my ports */
			
m_portProvided_IAdmin_CoreReportingEngine = new brs_repository.impl.ports.IAdmin_CoreOnlineEngine(
		
			myAssembly_FastCoreReportingEngine__FastCoreReportingEngine_.
			getPortProvided_IAdmin_ReportingEngine()
		
		);

m_portProvided_IReporting_CoreReportingEngine = new brs_repository.impl.ports.IReporting_CoreOnlineEngine(
		
			myAssembly_FastCoreReportingEngine__FastCoreReportingEngine_.
			getPortProvided_IReporting_ReportingEngine()
		
		);

		
	}
		
      
      // Composed child components member variables
      
   protected 
      brs_repository.impl.IInnerCoreReportingEngine 
         myAssembly_FastCoreReportingEngine__FastCoreReportingEngine_ = null;

   protected 
      brs_repository.impl.ICRESingleMessageAdapter 
         myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_ = null;

            
      /**
      * Inner Structure initialisation
      */
      private void initInnerComponents() {

		  /* First, initialise composite child structures */
		  
		  /* Then initialise basic components */
		  
			  initAssembly_FastCoreReportingEngine__FastCoreReportingEngine_();
		  
			  initAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_();
		  
      }

      
   private void initAssembly_FastCoreReportingEngine__FastCoreReportingEngine_() {
      brs_repository.impl.contexts.InnerCoreReportingEngineContext context = new brs_repository.impl.contexts.InnerCoreReportingEngineContext(
         
	
		
			/* From Connector _MR89UGo3Ed631pecjlFspw */
			myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_.getPortProvided_IDB_CRESingleMessageAdapter()
	   	
	
,
	 
		
			
			
				this.myContext.getRoleRequired_ICache_CoreReportingEngine()
	   		
			
	     
    

      );
      myAssembly_FastCoreReportingEngine__FastCoreReportingEngine_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_FastCoreReportingEngine__FastCoreReportingEngine_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_() {
      brs_repository.impl.contexts.CRESingleMessageAdapterContext context = new brs_repository.impl.contexts.CRESingleMessageAdapterContext(
         
	 
		
			
			
				this.myContext.getRoleRequired_IDB_CoreReportingEngine()
	   		
			
	     
    

      );
      myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_.setComponentFrame(componentStackFrame);

	

   }

      /**
      * Inner Structure initialisation end
      */


	    
	
    

    

	
    protected brs_repository.impl.ports.IAdmin_CoreOnlineEngine m_portProvided_IAdmin_CoreReportingEngine = null;

    protected brs_repository.impl.ports.IReporting_CoreOnlineEngine m_portProvided_IReporting_CoreReportingEngine = null;

   	
   /* (non-Javadoc)
 * @see brs_repository.impl.ICoreOnlineEngine#getPortProvided_IAdmin_CoreReportingEngine()
 */
public brs_repository.IAdmin getPortProvided_IAdmin_CoreReportingEngine () {
      return m_portProvided_IAdmin_CoreReportingEngine;
   }

   /* (non-Javadoc)
 * @see brs_repository.impl.ICoreOnlineEngine#getPortProvided_IReporting_CoreReportingEngine()
 */
public brs_repository.IReporting getPortProvided_IReporting_CoreReportingEngine () {
      return m_portProvided_IReporting_CoreReportingEngine;
   }


		
   
   

   
   

   
   protected brs_repository.impl.contexts.ICoreOnlineEngineContext myContext = null;

   
   /* (non-Javadoc)
 * @see brs_repository.impl.ICoreOnlineEngine#setContext(brs_repository.impl.contexts.ICoreOnlineEngineContext)
 */
public void setContext(brs_repository.impl.contexts.ICoreOnlineEngineContext myContext) {
      this.myContext = myContext;
      
      	initInnerComponents();
      
   }


		
   }

	