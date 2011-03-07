
      package brs_repository.impl.contexts;

      // Component context class for GraphicalReporting
      public class GraphicalReportingContext implements brs_repository.impl.contexts.IGraphicalReportingContext
      {
         
   protected brs_repository.IReporting required_IReporting_GraphicalReporting = null;

         
   public brs_repository.IReporting getRoleRequired_IReporting_GraphicalReporting() {
   	  if (required_IReporting_GraphicalReporting == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IReporting_GraphicalReporting <_TNCNUFelEd6zR8NNmb-sJg> RequiringEntity GraphicalReporting");
      }
      return required_IReporting_GraphicalReporting;
   }

         
   public void setRoleRequired_IReporting_GraphicalReporting(brs_repository.IReporting newValue) {
      this.required_IReporting_GraphicalReporting = newValue;
   }

         public GraphicalReportingContext () {
         }
         
         
         public GraphicalReportingContext (
            
   brs_repository.IReporting required_IReporting_GraphicalReporting
 ) {
            
   this.required_IReporting_GraphicalReporting = required_IReporting_GraphicalReporting;

         }
         
         
         

      }
   