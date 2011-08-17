
	  package brs_repository.impl.ports;
      
	  // Port class for IDB_CRESingleMessageAdapter
	  public class IDB_CRESingleMessageAdapter implements brs_repository.IDB
	  {
	     protected brs_repository.impl.ICRESingleMessageAdapter myComponent = null;
	     
	     public IDB_CRESingleMessageAdapter(){}

	     public IDB_CRESingleMessageAdapter(brs_repository.impl.ICRESingleMessageAdapter myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   getSmallReport0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iDB_getSmallReport0(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   getBigReport1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iDB_getBigReport1(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   getCachedData2
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iDB_getCachedData2(
	     
	ctx
);


   }   

	  }

   