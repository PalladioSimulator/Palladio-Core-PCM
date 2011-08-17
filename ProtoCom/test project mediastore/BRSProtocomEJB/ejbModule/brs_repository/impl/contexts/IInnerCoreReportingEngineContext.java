
      package brs_repository.impl.contexts;

      // Component context interface for InnerCoreReportingEngine
      public interface IInnerCoreReportingEngineContext
      {
         
   brs_repository.IDB getRoleRequired_IDB_ReportingEngine();

   brs_repository.ICache getRoleRequired_ICache_ReportingEngine();

         
   void setRoleRequired_IDB_ReportingEngine(brs_repository.IDB newValue);

   void setRoleRequired_ICache_ReportingEngine(brs_repository.ICache newValue);

      }
   