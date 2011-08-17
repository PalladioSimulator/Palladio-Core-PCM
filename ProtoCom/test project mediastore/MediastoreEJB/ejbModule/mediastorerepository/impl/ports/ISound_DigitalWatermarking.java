
	  package mediastorerepository.impl.ports;

import mediastorerepository.AbstractMediastoreSessionBean;
      
	  // Port class for ISound_DigitalWatermarking
	  public class ISound_DigitalWatermarking extends AbstractMediastoreSessionBean implements mediastorerepository.ISound
	  {
	     protected mediastorerepository.impl.IDigitalWatermarking myComponent = null;
	     
	     public ISound_DigitalWatermarking(){}

	     public ISound_DigitalWatermarking(mediastorerepository.impl.IDigitalWatermarking myComponent){
	        this.myComponent = myComponent;
	     }
	     
	     


	     
   public 
   
   de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>

   watermark0
   ( 
	de.uka.ipd.sdq.simucomframework.variables.StackContext ctx
 )
 {
   	  
   
	return myComponent.iSound_watermark0(
	     
	ctx
);


   }   

	  }

   