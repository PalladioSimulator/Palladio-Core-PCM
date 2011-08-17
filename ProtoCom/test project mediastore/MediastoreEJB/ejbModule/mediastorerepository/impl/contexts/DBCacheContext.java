
      package mediastorerepository.impl.contexts;

      // Component context class for DBCache
      public class DBCacheContext implements mediastorerepository.impl.contexts.IDBCacheContext
      {
         
   protected mediastorerepository.IAudioDB required_IAudioDB_DBCache = null;

         
   public mediastorerepository.IAudioDB getRoleRequired_IAudioDB_DBCache() {
   	  if (required_IAudioDB_DBCache == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IAudioDB_DBCache <_rt6xkCAeEdyB2fTIEA4hbA> RequiringEntity DBCache");
      }
      return required_IAudioDB_DBCache;
   }

         
   public void setRoleRequired_IAudioDB_DBCache(mediastorerepository.IAudioDB newValue) {
      this.required_IAudioDB_DBCache = newValue;
   }

         public DBCacheContext () {
         }
         
         
         public DBCacheContext (
            
   mediastorerepository.IAudioDB required_IAudioDB_DBCache
 ) {
            
   this.required_IAudioDB_DBCache = required_IAudioDB_DBCache;

         }
         
      }
   