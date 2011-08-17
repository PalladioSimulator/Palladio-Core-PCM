
	  package mediastorerepository.impl.ports;
      
	  // Port class for IMediaStore_EncodingMediaStore
	  public class IMediaStore_EncodingMediaStore implements mediastorerepository.IMediaStore
	  {
	     protected mediastorerepository.impl.IEncodingMediaStore myComponent = null;
	     
	     public IMediaStore_EncodingMediaStore(){}

	     public IMediaStore_EncodingMediaStore(mediastorerepository.impl.IEncodingMediaStore myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   download0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iMediaStore_download0(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   upload1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iMediaStore_upload1(
	     
	ctx
);


   }   

	  }

   