
      package mediastorerepository.impl.contexts;

import mediastorerepository.AbstractMediastoreSessionBean;

      // Component context class for MediaStore
      public class MediaStoreContext extends AbstractMediastoreSessionBean implements mediastorerepository.impl.contexts.IMediaStoreContext
      {
         
   protected mediastorerepository.IAudioDB required_IAudioDB_MediaStore = null;

   protected mediastorerepository.ISound required_ISound_MediaStore = null;

         
   public mediastorerepository.IAudioDB getRoleRequired_IAudioDB_MediaStore() {
   	  if (required_IAudioDB_MediaStore == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_IAudioDB_MediaStore <__rkj8BpZEdyxqpPYxT_m3w> RequiringEntity MediaStore");
      }
      return required_IAudioDB_MediaStore;
   }

   public mediastorerepository.ISound getRoleRequired_ISound_MediaStore() {
   	  if (required_ISound_MediaStore == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_ISound_MediaStore <_ACOwcBpaEdyxqpPYxT_m3w> RequiringEntity MediaStore");
      }
      return required_ISound_MediaStore;
   }

         
   public void setRoleRequired_IAudioDB_MediaStore(mediastorerepository.IAudioDB newValue) {
      this.required_IAudioDB_MediaStore = newValue;
   }

   public void setRoleRequired_ISound_MediaStore(mediastorerepository.ISound newValue) {
      this.required_ISound_MediaStore = newValue;
   }

         public MediaStoreContext () {
         }
         
         
         public MediaStoreContext (
            
   mediastorerepository.IAudioDB required_IAudioDB_MediaStore
,
   mediastorerepository.ISound required_ISound_MediaStore
 ) {
            
   this.required_IAudioDB_MediaStore = required_IAudioDB_MediaStore;

   this.required_ISound_MediaStore = required_ISound_MediaStore;

         }
         
      }
   