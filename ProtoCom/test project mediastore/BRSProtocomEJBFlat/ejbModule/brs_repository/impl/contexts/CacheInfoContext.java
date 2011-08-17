
      package brs_repository.impl.contexts;

      // Component context class for CacheInfo
      public class CacheInfoContext implements brs_repository.impl.contexts.ICacheInfoContext
      {
         
   protected brs_repository.IDB required_IDB_CacheInfo = null;

         
   public brs_repository.IDB getRoleRequired_IDB_CacheInfo() {
   	  if (required_IDB_CacheInfo == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IDB_CacheInfo <_wNIh4No5EdyCSNQKlT1LxA> RequiringEntity CacheInfo");
      }
      return required_IDB_CacheInfo;
   }

         
   public void setRoleRequired_IDB_CacheInfo(brs_repository.IDB newValue) {
      this.required_IDB_CacheInfo = newValue;
   }

         public CacheInfoContext () {
         }
         
         
         public CacheInfoContext (
            
   brs_repository.IDB required_IDB_CacheInfo
 ) {
            
   this.required_IDB_CacheInfo = required_IDB_CacheInfo;

         }
         
         
         

      }
   