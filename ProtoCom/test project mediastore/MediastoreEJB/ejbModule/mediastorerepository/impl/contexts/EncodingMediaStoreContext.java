
      package mediastorerepository.impl.contexts;

      // Component context class for EncodingMediaStore
      public class EncodingMediaStoreContext implements mediastorerepository.impl.contexts.IEncodingMediaStoreContext
      {
         
   protected mediastorerepository.IEncode iEncode_Req = null;

   protected mediastorerepository.IAudioDB iAudioDB_Req = null;

   protected mediastorerepository.ISound required_ISound_EncodingMediaStore = null;

         
   public mediastorerepository.IEncode getRoleIEncode_Req() {
   	  if (iEncode_Req == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role IEncode_Req <_EreeoBwqEdyg5YJN38bxwQ> RequiringEntity EncodingMediaStore");
      }
      return iEncode_Req;
   }

   public mediastorerepository.IAudioDB getRoleIAudioDB_Req() {
   	  if (iAudioDB_Req == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role IAudioDB_Req <_FVDAEBwqEdyg5YJN38bxwQ> RequiringEntity EncodingMediaStore");
      }
      return iAudioDB_Req;
   }

   public mediastorerepository.ISound getRoleRequired_ISound_EncodingMediaStore() {
   	  if (required_ISound_EncodingMediaStore == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_ISound_EncodingMediaStore <_F0MaMBwqEdyg5YJN38bxwQ> RequiringEntity EncodingMediaStore");
      }
      return required_ISound_EncodingMediaStore;
   }

         
   public void setRoleIEncode_Req(mediastorerepository.IEncode newValue) {
      this.iEncode_Req = newValue;
   }

   public void setRoleIAudioDB_Req(mediastorerepository.IAudioDB newValue) {
      this.iAudioDB_Req = newValue;
   }

   public void setRoleRequired_ISound_EncodingMediaStore(mediastorerepository.ISound newValue) {
      this.required_ISound_EncodingMediaStore = newValue;
   }

         public EncodingMediaStoreContext () {
         }
         
         
         public EncodingMediaStoreContext (
            
   mediastorerepository.IEncode iEncode_Req
,
   mediastorerepository.IAudioDB iAudioDB_Req
,
   mediastorerepository.ISound required_ISound_EncodingMediaStore
 ) {
            
   this.iEncode_Req = iEncode_Req;

   this.iAudioDB_Req = iAudioDB_Req;

   this.required_ISound_EncodingMediaStore = required_ISound_EncodingMediaStore;

         }
         
      }
   