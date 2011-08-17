
		
   package brs_repository.impl;
  
   public class CoreGraphicEngine 
   {
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(CoreGraphicEngine.class.getName());
	  

    
	
   
   public CoreGraphicEngine() {

		
		
		logger.info("Creating composed structure CoreGraphicEngine");
		
	
	try {
		//get the default JNDI initial context
		javax.naming.Context context = new javax.naming.InitialContext();
		
		
	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/ProtocomEAR/ProtocomEJB/InnerCoreReportingEngine_Impl__83KboHqPEd6uqIqMUZizUw");	
		myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_ = (brs_repository.impl.IInnerCoreReportingEngine)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/ProtocomEAR/ProtocomEJB/CRESingleMessageAdapter_Impl__-8fJYHqPEd6uqIqMUZizUw");	
		myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_ = (brs_repository.impl.ICRESingleMessageAdapter)obj;
    }

	} catch (javax.naming.NamingException e) {
		e.printStackTrace();
	}


	      
		
			/* And finally, my ports */
			
m_portProvided_IReporting_CoreReportingEngine2 = new brs_repository.impl.ports.IReporting_CoreGraphicEngine(
		
			myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_.
			getPortProvided_IReporting_ReportingEngine()
		
		);

		
	} 
		
      
      // Composed child components member variables
      
   protected 
      IInnerCoreReportingEngine 
         myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_ = null;

   protected 
      ICRESingleMessageAdapter 
         myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_ = null;

            
      /**
      * Inner Structure initialisation
      */
      private void initInnerComponents() {

		  /* First, initialise composite child structures */
		  
		  /* Then initialise basic components */
		  
			  initAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_();
		  
			  initAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_();
		  
      }

      
   private void initAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_() {
      brs_repository.impl.contexts.InnerCoreReportingEngineContext context = new brs_repository.impl.contexts.InnerCoreReportingEngineContext(
         
	
		
			/* From Connector _B6Os4HqQEd6uqIqMUZizUw */
			myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_.getPortProvided_IDB_CRESingleMessageAdapter()
	   	
	
,
	 
		
			
			
				this.myContext.getRoleRequired_ICache_CoreReportingEngine2()
	   		
			
	     
    

      );
      
	
		
  	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	
	
	myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_.setComponentFrame(componentStackFrame);
  

	

      myAssembly_InnerCoreReportingEngine__InnerCoreReportingEngine_.setContext(context);
   }

   private void initAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_() {
      brs_repository.impl.contexts.CRESingleMessageAdapterContext context = new brs_repository.impl.contexts.CRESingleMessageAdapterContext(
         
	 
		
			
			
				this.myContext.getRoleRequired_IDB_CoreReportingEngine2()
	   		
			
	     
    

      );
      
	
		
  
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	
	
	myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_.setComponentFrame(componentStackFrame);
  

	

      myAssembly_CRESingleMessageAdapter__CRESingleMessageAdapter_.setContext(context);
   }

      /**
      * Inner Structure initialisation end
      */


	    
	
    

	
    protected brs_repository.impl.ports.IReporting_CoreGraphicEngine m_portProvided_IReporting_CoreReportingEngine2 = null;

   	
   public brs_repository.IReporting getPortProvided_IReporting_CoreReportingEngine2 () {
      return m_portProvided_IReporting_CoreReportingEngine2;
   }


		
   
   

   
   

   
   protected brs_repository.impl.contexts.ICoreGraphicEngineContext myContext = null;

   
   public void setContext(brs_repository.impl.contexts.ICoreGraphicEngineContext myContext) {
      this.myContext = myContext;
      
      	initInnerComponents();
      
   }


		
   }

	