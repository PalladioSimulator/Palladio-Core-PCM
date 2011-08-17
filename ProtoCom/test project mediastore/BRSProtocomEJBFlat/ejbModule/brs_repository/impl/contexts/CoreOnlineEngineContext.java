
      package brs_repository.impl.contexts;

      // Component context class for CoreOnlineEngine
      public class CoreOnlineEngineContext implements brs_repository.impl.contexts.ICoreOnlineEngineContext
      {
         
   protected brs_repository.ICache required_ICache_CoreReportingEngine = null;

   protected brs_repository.IDB required_IDB_CoreReportingEngine = null;

         
   public brs_repository.ICache getRoleRequired_ICache_CoreReportingEngine() {
   	  if (required_ICache_CoreReportingEngine == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_ICache_CoreReportingEngine <_XlnfYGo2Ed631pecjlFspw> RequiringEntity CoreOnlineEngine");
      }
      return required_ICache_CoreReportingEngine;
   }

   public brs_repository.IDB getRoleRequired_IDB_CoreReportingEngine() {
   	  if (required_IDB_CoreReportingEngine == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IDB_CoreReportingEngine <_YDMzQGo2Ed631pecjlFspw> RequiringEntity CoreOnlineEngine");
      }
      return required_IDB_CoreReportingEngine;
   }

         
   public void setRoleRequired_ICache_CoreReportingEngine(brs_repository.ICache newValue) {
      this.required_ICache_CoreReportingEngine = newValue;
   }

   public void setRoleRequired_IDB_CoreReportingEngine(brs_repository.IDB newValue) {
      this.required_IDB_CoreReportingEngine = newValue;
   }

         public CoreOnlineEngineContext () {
         }
         
         
         public CoreOnlineEngineContext (
            
   brs_repository.ICache required_ICache_CoreReportingEngine
,
   brs_repository.IDB required_IDB_CoreReportingEngine
 ) {
            
   this.required_ICache_CoreReportingEngine = required_ICache_CoreReportingEngine;

   this.required_IDB_CoreReportingEngine = required_IDB_CoreReportingEngine;

         }
         
         
         

      }
   