
      package mediastorerepository.impl.contexts;

      // Component context interface for MediaStore
      public interface IMediaStoreContext
      {
         
   mediastorerepository.IAudioDB getRoleRequired_IAudioDB_MediaStore();

   mediastorerepository.ISound getRoleRequired_ISound_MediaStore();

         
   void setRoleRequired_IAudioDB_MediaStore(mediastorerepository.IAudioDB newValue);

   void setRoleRequired_ISound_MediaStore(mediastorerepository.ISound newValue);

      }
   