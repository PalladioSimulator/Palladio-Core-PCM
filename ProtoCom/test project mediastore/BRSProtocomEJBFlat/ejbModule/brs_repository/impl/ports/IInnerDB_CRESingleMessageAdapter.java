
	  package brs_repository.impl.ports;
      
	  // Port class for IInnerDB_CRESingleMessageAdapter
	  public class IInnerDB_CRESingleMessageAdapter implements brs_repository.IInnerDB
	  {
	     protected brs_repository.impl.ICRESingleMessageAdapter myComponent = null;
	     
	     public IInnerDB_CRESingleMessageAdapter(){}

	     public IInnerDB_CRESingleMessageAdapter(brs_repository.impl.ICRESingleMessageAdapter myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   getSmallReportInner0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iInnerDB_getSmallReportInner0(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   getBigReportInner1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iInnerDB_getBigReportInner1(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   getCachedDataInner2
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iInnerDB_getCachedDataInner2(
	     
	ctx
);


   }   

	  }

   