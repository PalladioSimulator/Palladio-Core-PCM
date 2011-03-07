
	  package mediastorerepository.impl.ports;

import mediastorerepository.AbstractMediastoreSessionBean;
      
	  // Port class for IMediaStore_MediaStore
	  public class IMediaStore_MediaStore extends AbstractMediastoreSessionBean implements mediastorerepository.IMediaStore
	  {
	     protected mediastorerepository.impl.IMediaStore myComponent = null;
	     
	     public IMediaStore_MediaStore(){}

	     public IMediaStore_MediaStore(mediastorerepository.impl.IMediaStore myComponent){
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

   