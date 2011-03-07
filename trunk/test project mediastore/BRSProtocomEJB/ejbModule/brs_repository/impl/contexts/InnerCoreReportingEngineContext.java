
      package brs_repository.impl.contexts;

      // Component context class for InnerCoreReportingEngine
      public class InnerCoreReportingEngineContext implements brs_repository.impl.contexts.IInnerCoreReportingEngineContext
      {
         
   protected brs_repository.IDB required_IDB_ReportingEngine = null;

   protected brs_repository.ICache required_ICache_ReportingEngine = null;

         
   public brs_repository.IDB getRoleRequired_IDB_ReportingEngine() {
   	  if (required_IDB_ReportingEngine == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IDB_ReportingEngine <_tOgNkNo5EdyCSNQKlT1LxA> RequiringEntity InnerCoreReportingEngine");
      }
      return required_IDB_ReportingEngine;
   }

   public brs_repository.ICache getRoleRequired_ICache_ReportingEngine() {
   	  if (required_ICache_ReportingEngine == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_ICache_ReportingEngine <_gXZbcNo9EdyxgfK4Hy_RFA> RequiringEntity InnerCoreReportingEngine");
      }
      return required_ICache_ReportingEngine;
   }

         
   public void setRoleRequired_IDB_ReportingEngine(brs_repository.IDB newValue) {
      this.required_IDB_ReportingEngine = newValue;
   }

   public void setRoleRequired_ICache_ReportingEngine(brs_repository.ICache newValue) {
      this.required_ICache_ReportingEngine = newValue;
   }

         public InnerCoreReportingEngineContext () {
         }
         
         
         public InnerCoreReportingEngineContext (
            
   brs_repository.IDB required_IDB_ReportingEngine
,
   brs_repository.ICache required_ICache_ReportingEngine
 ) {
            
   this.required_IDB_ReportingEngine = required_IDB_ReportingEngine;

   this.required_ICache_ReportingEngine = required_ICache_ReportingEngine;

         }
         
      }
   