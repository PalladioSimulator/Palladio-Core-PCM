
	  package brs_repository.impl.ports;
      
	  // Port class for IAdmin_IAdminStub
	  public class IAdmin_IAdminStub implements brs_repository.IAdmin
	  {
	     protected brs_repository.impl.IIAdminStub myComponent = null;
	     
	     public IAdmin_IAdminStub(){}

	     public IAdmin_IAdminStub(brs_repository.impl.IIAdminStub myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   maintain0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iAdmin_maintain0(
	     
	ctx
);


   }   

	  }

   