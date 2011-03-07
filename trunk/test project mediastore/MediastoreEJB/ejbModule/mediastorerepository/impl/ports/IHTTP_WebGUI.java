
	  package mediastorerepository.impl.ports;

import mediastorerepository.AbstractMediastoreSessionBean;
      
	  // Port class for IHTTP_WebGUI
	  public class IHTTP_WebGUI extends AbstractMediastoreSessionBean implements mediastorerepository.IHTTP
	  {
	     protected mediastorerepository.impl.IWebGUI myComponent = null;
	     
	     public IHTTP_WebGUI(){}

	     public IHTTP_WebGUI(mediastorerepository.impl.IWebGUI myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   HTTPDownload0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iHTTP_HTTPDownload0(
	     
	ctx
);


   }   

   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   HTTPUpload1
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iHTTP_HTTPUpload1(
	     
	ctx
);


   }   

	  }

   