
      package brs_repository.impl.contexts;

      // Component context class for IAdminStub
      public class IAdminStubContext implements brs_repository.impl.contexts.IIAdminStubContext
      {
         
   protected brs_repository.IAdmin req_IAdmin_Stub = null;

         
   public brs_repository.IAdmin getRolereq_IAdmin_Stub() {
   	  if (req_IAdmin_Stub == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role req_IAdmin_Stub <_Cx3ZklE_EeCAJIcLKkksgA> RequiringEntity IAdminStub");
      }
      return req_IAdmin_Stub;
   }

         
   public void setRolereq_IAdmin_Stub(brs_repository.IAdmin newValue) {
      this.req_IAdmin_Stub = newValue;
   }

         public IAdminStubContext () {
         }
         
         
         public IAdminStubContext (
            
   brs_repository.IAdmin req_IAdmin_Stub
 ) {
            
   this.req_IAdmin_Stub = req_IAdmin_Stub;

         }
         
         
         

      }
   