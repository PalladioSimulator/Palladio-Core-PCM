
      package brs_repository.impl.contexts;

      // Component context interface for InnerCoreReportingEngine
      public interface IInnerCoreReportingEngineContext
      {
         
   brs_repository.IInnerDB getRoleRequired_IInnerDB_ReportingEngine();

   brs_repository.ICache getRoleRequired_ICache_ReportingEngine();

         
   void setRoleRequired_IInnerDB_ReportingEngine(brs_repository.IInnerDB newValue);

   void setRoleRequired_ICache_ReportingEngine(brs_repository.ICache newValue);

      }
   