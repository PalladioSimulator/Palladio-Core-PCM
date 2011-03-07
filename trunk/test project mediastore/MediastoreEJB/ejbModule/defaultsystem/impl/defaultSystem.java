
      
	
   package defaultsystem.impl;

 
   public class defaultSystem 
   {
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger(defaultSystem.class.getName());
	  
	public defaultSystem() {
		logger.info("Creating composed structure defaultSystem");
		
/*		myAssembly_WebGUI__WebGUI_ = new mediastorerepository.impl.WebGUI();

		myAssembly_MediaStore__MediaStore_ = new mediastorerepository.impl.MediaStore();

		myAssembly_DigitalWatermarking__DigitalWatermarking_ = new mediastorerepository.impl.DigitalWatermarking();

		myAssembly_AudioDB__AudioDB_ = new mediastorerepository.impl.AudioDB();*/
		
		try {
			//get the default JNDI initial context
			javax.naming.Context context = new javax.naming.InitialContext();
			
			{
				//Object obj=context.lookup(mediastorerepository.impl.MediaStore.class.getName());
				Object obj=context.lookup("java:global/MediastoreProtocomEAR/MediastoreEJB/MediaStore_Impl__a3kJ4FBvEd6ActLj8Gdl_A");
				myAssembly_MediaStore__MediaStore_ = (mediastorerepository.impl.IMediaStore)obj;
				}
			
			{
			Object obj=context.lookup("java:global/MediastoreProtocomEAR/MediastoreEJB/WebGUI_Impl__Yp70sFBvEd6ActLj8Gdl_A");
			myAssembly_WebGUI__WebGUI_ = (mediastorerepository.impl.IWebGUI)obj;
			}
						
			{
			Object obj=context.lookup("java:global/MediastoreProtocomEAR/MediastoreEJB/DigitalWatermarking_Impl__dbNyYFBvEd6ActLj8Gdl_A");
			myAssembly_DigitalWatermarking__DigitalWatermarking_ = ( mediastorerepository.impl.IDigitalWatermarking)obj;
			}
			
			{
			Object obj=context.lookup("java:global/MediastoreProtocomEAR/MediastoreEJB/AudioDB_Impl__jeBpYFBvEd6ActLj8Gdl_A");
			myAssembly_AudioDB__AudioDB_ = (mediastorerepository.impl.IAudioDB)obj;
			}
		} catch (javax.naming.NamingException e) {
			e.printStackTrace();
		}

	      
		
			/* And finally, my ports */
			
m_portProvided_IHTTP = new defaultsystem.impl.ports.IHTTP_defaultSystem(
		
			myAssembly_WebGUI__WebGUI_.
			getPortProvided_IHTTP_WebGUI()
		
		);

		
	}
		
      
      // Composed child components member variables
      
   protected 
      mediastorerepository.impl.IWebGUI 
         myAssembly_WebGUI__WebGUI_ = null;

   protected 
      mediastorerepository.impl.IMediaStore 
         myAssembly_MediaStore__MediaStore_ = null;

   protected 
      mediastorerepository.impl.IDigitalWatermarking 
         myAssembly_DigitalWatermarking__DigitalWatermarking_ = null;

   protected 
      mediastorerepository.impl.IAudioDB 
         myAssembly_AudioDB__AudioDB_ = null;

            
      /**
      * Inner Structure initialisation
      */
      private void initInnerComponents() {

		  /* First, initialise composite child structures */
		  
		  /* Then initialise basic components */
		  
			  initAssembly_WebGUI__WebGUI_();
		  
			  initAssembly_MediaStore__MediaStore_();
		  
			  initAssembly_DigitalWatermarking__DigitalWatermarking_();
		  
			  initAssembly_AudioDB__AudioDB_();
		  
      }

      
   private void initAssembly_WebGUI__WebGUI_() {
      mediastorerepository.impl.contexts.WebGUIContext context = new mediastorerepository.impl.contexts.WebGUIContext(
         
	
		
			/* From Connector _dFy8AFBvEd6ActLj8Gdl_A */
			myAssembly_MediaStore__MediaStore_.getPortProvided_IMediaStore_MediaStore()
	   	
	

      );
      myAssembly_WebGUI__WebGUI_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_WebGUI__WebGUI_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_MediaStore__MediaStore_() {
      mediastorerepository.impl.contexts.MediaStoreContext context = new mediastorerepository.impl.contexts.MediaStoreContext(
         
	
		
			/* From Connector _oujH0FBvEd6ActLj8Gdl_A */
			myAssembly_AudioDB__AudioDB_.getPortProvided_IAudioDB_AudioDB()
	   	
	
,
	
		
			/* From Connector _pCfXgFBvEd6ActLj8Gdl_A */
			myAssembly_DigitalWatermarking__DigitalWatermarking_.getPortProvided_ISound_DigitalWatermarking()
	   	
	

      );
      myAssembly_MediaStore__MediaStore_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_MediaStore__MediaStore_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_DigitalWatermarking__DigitalWatermarking_() {
      mediastorerepository.impl.contexts.DigitalWatermarkingContext context = new mediastorerepository.impl.contexts.DigitalWatermarkingContext(
         
      );
      myAssembly_DigitalWatermarking__DigitalWatermarking_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_DigitalWatermarking__DigitalWatermarking_.setComponentFrame(componentStackFrame);

	

   }

   private void initAssembly_AudioDB__AudioDB_() {
      mediastorerepository.impl.contexts.AudioDBContext context = new mediastorerepository.impl.contexts.AudioDBContext(
         
      );
      myAssembly_AudioDB__AudioDB_.setContext(context);
      
	
		
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	myAssembly_AudioDB__AudioDB_.setComponentFrame(componentStackFrame);

	

   }

      /**
      * Inner Structure initialisation end
      */


    
	
    

	
    protected defaultsystem.impl.ports.IHTTP_defaultSystem m_portProvided_IHTTP = null;

   	
   public mediastorerepository.IHTTP getPortProvided_IHTTP () {
      return m_portProvided_IHTTP;
   }


	
   
   

   
   

   
   protected defaultsystem.impl.contexts.IdefaultSystemContext myContext = null;

   
   public void setContext(defaultsystem.impl.contexts.IdefaultSystemContext myContext) {
      this.myContext = myContext;
      
      	initInnerComponents();
      
   }


	
   }

	
	
	



   