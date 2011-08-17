
	  package brs_repository.impl.ports;
      
	  // Port class for ICache_CacheInfo
	  public class ICache_CacheInfo implements brs_repository.ICache
	  {
	     protected brs_repository.impl.ICacheInfo myComponent = null;
	     
	     public ICache_CacheInfo(){}

	     public ICache_CacheInfo(brs_repository.impl.ICacheInfo myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   doCacheAccess0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iCache_doCacheAccess0(
	     
	ctx
);


   }   

	  }

   