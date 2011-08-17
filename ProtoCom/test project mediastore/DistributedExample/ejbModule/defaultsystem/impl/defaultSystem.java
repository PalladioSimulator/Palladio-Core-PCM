
      
	
   package defaultsystem.impl;

import defaultrepository.impl.ICompOne;
import defaultrepository.impl.ICompThree;
import defaultrepository.impl.ICompTwo;
  
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
   		Object obj=context.lookup("java:global/ProtocomEAR/ProtocomEJB/CompOne_Impl__H4zRsDgmEeCFP6TiQB0B7A");	
		myAssembly_CompOne__CompOne_ = (defaultrepository.impl.ICompOne)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/ProtocomEAR/ProtocomEJB/CompTwo_Impl__IYO_sDgmEeCFP6TiQB0B7A");	
		myAssembly_CompTwo__CompTwo_ = (defaultrepository.impl.ICompTwo)obj;
    }

	{
		//FIXME: add the proper bean reference here (check your server output for the used names)
   		Object obj=context.lookup("java:global/ProtocomEAR/ProtocomEJB/CompThree_Impl__IwQeIDgmEeCFP6TiQB0B7A");	
		myAssembly_CompThree__CompThree_ = (defaultrepository.impl.ICompThree)obj;
    }

	} catch (javax.naming.NamingException e) {
		e.printStackTrace();
	}


	      
		
			/* And finally, my ports */
			
m_portProvided_One = new defaultsystem.impl.ports.One_defaultSystem(
		
			myAssembly_CompOne__CompOne_.
			getPortProvided_One_CompOne()
		
		);

		
	} 
		
      
      // Composed child components member variables
      
   protected 
      ICompOne 
         myAssembly_CompOne__CompOne_ = null;

   protected 
      ICompTwo 
         myAssembly_CompTwo__CompTwo_ = null;

   protected 
      ICompThree 
         myAssembly_CompThree__CompThree_ = null;

            
      /**
      * Inner Structure initialisation
      */
      private void initInnerComponents() {

		  /* First, initialise composite child structures */
		  
		  /* Then initialise basic components */
		  
			  initAssembly_CompOne__CompOne_();
		  
			  initAssembly_CompTwo__CompTwo_();
		  
			  initAssembly_CompThree__CompThree_();
		  
      }

      
   private void initAssembly_CompOne__CompOne_() {
      defaultrepository.impl.contexts.CompOneContext context = new defaultrepository.impl.contexts.CompOneContext(
         
	
		
			/* From Connector _J_iUsDgmEeCFP6TiQB0B7A */
			myAssembly_CompTwo__CompTwo_.getPortProvided_Two_CompTwo()
	   	
	

      );
      
	
		
 
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	
	
	myAssembly_CompOne__CompOne_.setComponentFrame(componentStackFrame);
  

	

      myAssembly_CompOne__CompOne_.setContext(context);
   }

   private void initAssembly_CompTwo__CompTwo_() {
      defaultrepository.impl.contexts.CompTwoContext context = new defaultrepository.impl.contexts.CompTwoContext(
         
	
		
			/* From Connector _KNIEwDgmEeCFP6TiQB0B7A */
			myAssembly_CompThree__CompThree_.getPortProvided_Three_CompThree()
	   	
	

      );
      
	
		
     
  
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	
	
	myAssembly_CompTwo__CompTwo_.setComponentFrame(componentStackFrame);
  

	

      myAssembly_CompTwo__CompTwo_.setContext(context);
   }

   private void initAssembly_CompThree__CompThree_() {
      defaultrepository.impl.contexts.CompThreeContext context = new defaultrepository.impl.contexts.CompThreeContext(
         
      );
      
	
		
    
  
	//Initialise Component Parameters
	de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
		new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
	
	
	
	myAssembly_CompThree__CompThree_.setComponentFrame(componentStackFrame);
  

	

      myAssembly_CompThree__CompThree_.setContext(context);
   }

      /**
      * Inner Structure initialisation end
      */


    
	
    

	
    protected defaultsystem.impl.ports.One_defaultSystem m_portProvided_One = null;

   	
   public defaultrepository.One getPortProvided_One () {
      return m_portProvided_One;
   }


	
   
   

   
   

   
   protected defaultsystem.impl.contexts.IdefaultSystemContext myContext = null;

   
   public void setContext(defaultsystem.impl.contexts.IdefaultSystemContext myContext) {
      this.myContext = myContext;
      
      	initInnerComponents();
      
   }


	
   }

	
	
	



   