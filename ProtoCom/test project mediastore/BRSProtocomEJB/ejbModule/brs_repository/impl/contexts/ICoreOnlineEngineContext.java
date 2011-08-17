
      package brs_repository.impl.contexts;

      // Component context interface for CoreOnlineEngine
      public interface ICoreOnlineEngineContext
      {
         
   brs_repository.ICache getRoleRequired_ICache_CoreReportingEngine();

   brs_repository.IDB getRoleRequired_IDB_CoreReportingEngine();

         
   void setRoleRequired_ICache_CoreReportingEngine(brs_repository.ICache newValue);

   void setRoleRequired_IDB_CoreReportingEngine(brs_repository.IDB newValue);

      }
   