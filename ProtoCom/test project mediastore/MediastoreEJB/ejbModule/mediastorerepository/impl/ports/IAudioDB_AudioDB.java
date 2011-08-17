
	  package mediastorerepository.impl.ports;

import mediastorerepository.AbstractMediastoreSessionBean;
      
	  // Port class for IAudioDB_AudioDB
	  public class IAudioDB_AudioDB extends AbstractMediastoreSessionBean implements mediastorerepository.IAudioDB
	  {
	     protected mediastorerepository.impl.IAudioDB myComponent = null;
	     
	     public IAudioDB_AudioDB(){}

	     public IAudioDB_AudioDB(mediastorerepository.impl.IAudioDB myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   queryDB0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iAudioDB_queryDB0(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   addFile1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iAudioDB_addFile1(
	     
	ctx
);


   }   

	  }

   