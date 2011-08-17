
      package brs_repository.impl.contexts;

      // Component context class for CRESingleMessageAdapter
      public class CRESingleMessageAdapterContext implements brs_repository.impl.contexts.ICRESingleMessageAdapterContext
      {
         
   protected brs_repository.IDB required_IDB_CRESingleMessageAdapter = null;

         
   public brs_repository.IDB getRoleRequired_IDB_CRESingleMessageAdapter() {
   	  if (required_IDB_CRESingleMessageAdapter == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IDB_CRESingleMessageAdapter <_VVnLoGo2Ed631pecjlFspw> RequiringEntity CRESingleMessageAdapter");
      }
      return required_IDB_CRESingleMessageAdapter;
   }

         
   public void setRoleRequired_IDB_CRESingleMessageAdapter(brs_repository.IDB newValue) {
      this.required_IDB_CRESingleMessageAdapter = newValue;
   }

         public CRESingleMessageAdapterContext () {
         }
         
         
         public CRESingleMessageAdapterContext (
            
   brs_repository.IDB required_IDB_CRESingleMessageAdapter
 ) {
            
   this.required_IDB_CRESingleMessageAdapter = required_IDB_CRESingleMessageAdapter;

         }
         
      }
   