
      package mediastorerepository.impl.contexts;

      // Component context interface for EncodingMediaStore
      public interface IEncodingMediaStoreContext
      {
         
   mediastorerepository.IEncode getRoleIEncode_Req();

   mediastorerepository.IAudioDB getRoleIAudioDB_Req();

   mediastorerepository.ISound getRoleRequired_ISound_EncodingMediaStore();

         
   void setRoleIEncode_Req(mediastorerepository.IEncode newValue);

   void setRoleIAudioDB_Req(mediastorerepository.IAudioDB newValue);

   void setRoleRequired_ISound_EncodingMediaStore(mediastorerepository.ISound newValue);

      }
   