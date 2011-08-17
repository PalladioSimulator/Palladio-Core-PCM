
      package brs_repository.impl.contexts;

      // Component context class for Scheduler
      public class SchedulerContext implements brs_repository.impl.contexts.ISchedulerContext
      {
         
   protected brs_repository.IOnlineReport required_IOnlineReport_Scheduler = null;

   protected brs_repository.IGraphicalReport required_IGraphicalReport_Scheduler = null;

   protected brs_repository.IUserMgmt required_IUserMgmt_Scheduler = null;

         
   public brs_repository.IOnlineReport getRoleRequired_IOnlineReport_Scheduler() {
   	  if (required_IOnlineReport_Scheduler == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IOnlineReport_Scheduler <_XOHfkNo5EdyCSNQKlT1LxA> RequiringEntity Scheduler");
      }
      return required_IOnlineReport_Scheduler;
   }

   public brs_repository.IGraphicalReport getRoleRequired_IGraphicalReport_Scheduler() {
   	  if (required_IGraphicalReport_Scheduler == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IGraphicalReport_Scheduler <_8cgw8FemEd6zR8NNmb-sJg> RequiringEntity Scheduler");
      }
      return required_IGraphicalReport_Scheduler;
   }

   public brs_repository.IUserMgmt getRoleRequired_IUserMgmt_Scheduler() {
   	  if (required_IUserMgmt_Scheduler == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IUserMgmt_Scheduler <_3tnYoFhFEd6UHd_VhJH9SQ> RequiringEntity Scheduler");
      }
      return required_IUserMgmt_Scheduler;
   }

         
   public void setRoleRequired_IOnlineReport_Scheduler(brs_repository.IOnlineReport newValue) {
      this.required_IOnlineReport_Scheduler = newValue;
   }

   public void setRoleRequired_IGraphicalReport_Scheduler(brs_repository.IGraphicalReport newValue) {
      this.required_IGraphicalReport_Scheduler = newValue;
   }

   public void setRoleRequired_IUserMgmt_Scheduler(brs_repository.IUserMgmt newValue) {
      this.required_IUserMgmt_Scheduler = newValue;
   }

         public SchedulerContext () {
         }
         
         
         public SchedulerContext (
            
   brs_repository.IOnlineReport required_IOnlineReport_Scheduler
,
   brs_repository.IGraphicalReport required_IGraphicalReport_Scheduler
,
   brs_repository.IUserMgmt required_IUserMgmt_Scheduler
 ) {
            
   this.required_IOnlineReport_Scheduler = required_IOnlineReport_Scheduler;

   this.required_IGraphicalReport_Scheduler = required_IGraphicalReport_Scheduler;

   this.required_IUserMgmt_Scheduler = required_IUserMgmt_Scheduler;

         }
         
      }
   