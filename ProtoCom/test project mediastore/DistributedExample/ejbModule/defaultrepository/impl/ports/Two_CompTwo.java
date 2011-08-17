
	  package defaultrepository.impl.ports;
      
	  // Port class for Two_CompTwo
	  public class Two_CompTwo implements defaultrepository.Two
	  {
	     protected defaultrepository.impl.ICompTwo myComponent = null;
	     
	     public Two_CompTwo(){}

	     public Two_CompTwo(defaultrepository.impl.ICompTwo myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   serviceTwo0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.two_serviceTwo0(
	     
	ctx
);


   }   

	  }

   