
	  package defaultrepository.impl.ports;
      
	  // Port class for One_CompOne
	  public class One_CompOne implements defaultrepository.One
	  {
	     protected defaultrepository.impl.ICompOne myComponent = null;
	     
	     public One_CompOne(){}

	     public One_CompOne(defaultrepository.impl.ICompOne myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   serviceOne0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.one_serviceOne0(
	     
	ctx
);


   }   

	  }

   