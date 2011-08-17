
      package brs_repository.impl.contexts;

      // Component context class for CoreGraphicEngine
      public class CoreGraphicEngineContext implements brs_repository.impl.contexts.ICoreGraphicEngineContext
      {
         
   protected brs_repository.IDB required_IDB_CoreReportingEngine2 = null;

   protected brs_repository.ICache required_ICache_CoreReportingEngine2 = null;

         
   public brs_repository.IDB getRoleRequired_IDB_CoreReportingEngine2() {
   	  if (required_IDB_CoreReportingEngine2 == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IDB_CoreReportingEngine2 <_03FmsHqPEd6uqIqMUZizUw> RequiringEntity CoreGraphicEngine");
      }
      return required_IDB_CoreReportingEngine2;
   }

   public brs_repository.ICache getRoleRequired_ICache_CoreReportingEngine2() {
   	  if (required_ICache_CoreReportingEngine2 == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_ICache_CoreReportingEngine2 <_16uN8HqPEd6uqIqMUZizUw> RequiringEntity CoreGraphicEngine");
      }
      return required_ICache_CoreReportingEngine2;
   }

         
   public void setRoleRequired_IDB_CoreReportingEngine2(brs_repository.IDB newValue) {
      this.required_IDB_CoreReportingEngine2 = newValue;
   }

   public void setRoleRequired_ICache_CoreReportingEngine2(brs_repository.ICache newValue) {
      this.required_ICache_CoreReportingEngine2 = newValue;
   }

         public CoreGraphicEngineContext () {
         }
         
         
         public CoreGraphicEngineContext (
            
   brs_repository.IDB required_IDB_CoreReportingEngine2
,
   brs_repository.ICache required_ICache_CoreReportingEngine2
 ) {
            
   this.required_IDB_CoreReportingEngine2 = required_IDB_CoreReportingEngine2;

   this.required_ICache_CoreReportingEngine2 = required_ICache_CoreReportingEngine2;

         }
         
      }
   