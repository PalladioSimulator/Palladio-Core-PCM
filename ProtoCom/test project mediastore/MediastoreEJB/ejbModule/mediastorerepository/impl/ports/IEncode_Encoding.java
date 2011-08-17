
	  package mediastorerepository.impl.ports;
      
	  // Port class for IEncode_Encoding
	  public class IEncode_Encoding implements mediastorerepository.IEncode
	  {
	     protected mediastorerepository.impl.IEncoding myComponent = null;
	     
	     public IEncode_Encoding(){}

	     public IEncode_Encoding(mediastorerepository.impl.IEncoding myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   encode0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iEncode_encode0(
	     
	ctx
);


   }   

	  }

   