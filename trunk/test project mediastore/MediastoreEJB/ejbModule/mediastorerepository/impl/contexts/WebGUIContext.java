
      package mediastorerepository.impl.contexts;


      // Component context class for WebGUI
      public class WebGUIContext implements mediastorerepository.impl.contexts.IWebGUIContext
      {
         
   protected mediastorerepository.IMediaStore required_IMediaStore_WebGUI = null;

         
   public mediastorerepository.IMediaStore getRoleRequired_IMediaStore_WebGUI() {
   	  if (required_IMediaStore_WebGUI == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IMediaStore_WebGUI <_-uB9oBpZEdyxqpPYxT_m3w> RequiringEntity WebGUI");
      }
      return required_IMediaStore_WebGUI;
   }

         
   public void setRoleRequired_IMediaStore_WebGUI(mediastorerepository.IMediaStore newValue) {
      this.required_IMediaStore_WebGUI = newValue;
   }

         public WebGUIContext () {
         }
         
         
         public WebGUIContext (
            
   mediastorerepository.IMediaStore required_IMediaStore_WebGUI
 ) {
            
   this.required_IMediaStore_WebGUI = required_IMediaStore_WebGUI;

         }
         
      }
   