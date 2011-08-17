
	  package defaultrepository.impl.ports;
      
	  // Port class for Three_CompThree
	  public class Three_CompThree implements defaultrepository.Three
	  {
	     protected defaultrepository.impl.ICompThree myComponent = null;
	     
	     public Three_CompThree(){}

	     public Three_CompThree(defaultrepository.impl.ICompThree myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   service30
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.three_service30(
	     
	ctx
);


   }   

	  }

   