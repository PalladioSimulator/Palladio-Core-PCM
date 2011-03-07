
	  package brs_repository.impl.ports;
      
	  // Port class for IGraphicalReport_GraphicalReporting
	  public class IGraphicalReport_GraphicalReporting implements brs_repository.IGraphicalReport
	  {
	     protected brs_repository.impl.IGraphicalReporting myComponent = null;
	     
	     public IGraphicalReport_GraphicalReporting(){}

	     public IGraphicalReport_GraphicalReporting(brs_repository.impl.IGraphicalReporting myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   graphicalReport0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iGraphicalReport_graphicalReport0(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   viewGraphically1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iGraphicalReport_viewGraphically1(
	     
	ctx
);


   }   

	  }

   