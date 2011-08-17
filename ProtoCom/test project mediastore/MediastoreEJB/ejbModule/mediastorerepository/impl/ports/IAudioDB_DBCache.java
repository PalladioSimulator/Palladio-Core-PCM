
	  package mediastorerepository.impl.ports;
      
	  // Port class for IAudioDB_DBCache
	  public class IAudioDB_DBCache implements mediastorerepository.IAudioDB
	  {
	     protected mediastorerepository.impl.IDBCache myComponent = null;
	     
	     public IAudioDB_DBCache(){}

	     public IAudioDB_DBCache(mediastorerepository.impl.IDBCache myComponent){
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

   