
      package brs_repository.impl.contexts;

      // Component context interface for Scheduler
      public interface ISchedulerContext
      {
         
   brs_repository.IOnlineReport getRoleRequired_IOnlineReport_Scheduler();

   brs_repository.IGraphicalReport getRoleRequired_IGraphicalReport_Scheduler();

   brs_repository.IUserMgmt getRoleRequired_IUserMgmt_Scheduler();

         
   void setRoleRequired_IOnlineReport_Scheduler(brs_repository.IOnlineReport newValue);

   void setRoleRequired_IGraphicalReport_Scheduler(brs_repository.IGraphicalReport newValue);

   void setRoleRequired_IUserMgmt_Scheduler(brs_repository.IUserMgmt newValue);

         
         

      }
   