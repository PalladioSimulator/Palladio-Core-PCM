
	  package mediastorerepository.impl.ports;
      
	  // Port class for IAudioDB_PoolingAudioDB
	  public class IAudioDB_PoolingAudioDB implements mediastorerepository.IAudioDB
	  {
	     protected mediastorerepository.impl.IPoolingAudioDB myComponent = null;
	     
	     public IAudioDB_PoolingAudioDB(){}

	     public IAudioDB_PoolingAudioDB(mediastorerepository.impl.IPoolingAudioDB myComponent){
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

   