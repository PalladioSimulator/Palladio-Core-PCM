
      package brs_repository.impl.contexts;

      // Component context class for OnlineReporting
      public class OnlineReportingContext implements brs_repository.impl.contexts.IOnlineReportingContext
      {
         
   protected brs_repository.IReporting required_IReporting_OnlineReporting = null;

         
   public brs_repository.IReporting getRoleRequired_IReporting_OnlineReporting() {
   	  if (required_IReporting_OnlineReporting == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IReporting_OnlineReporting <_URR4kFelEd6zR8NNmb-sJg> RequiringEntity OnlineReporting");
      }
      return required_IReporting_OnlineReporting;
   }

         
   public void setRoleRequired_IReporting_OnlineReporting(brs_repository.IReporting newValue) {
      this.required_IReporting_OnlineReporting = newValue;
   }

         public OnlineReportingContext () {
         }
         
         
         public OnlineReportingContext (
            
   brs_repository.IReporting required_IReporting_OnlineReporting
 ) {
            
   this.required_IReporting_OnlineReporting = required_IReporting_OnlineReporting;

         }
         
         
         

      }
   