
      package defaultrepository.impl.contexts;

      // Component context class for CompTwo
      public class CompTwoContext implements defaultrepository.impl.contexts.ICompTwoContext
      {
         
   protected defaultrepository.Three required_Three_CompTwo = null;

         
   public defaultrepository.Three getRoleRequired_Three_CompTwo() {
   	  if (required_Three_CompTwo == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_Three_CompTwo <_l9BvwDglEeCFP6TiQB0B7A> RequiringEntity CompTwo");
      }
      return required_Three_CompTwo;
   }

         
   public void setRoleRequired_Three_CompTwo(defaultrepository.Three newValue) {
      this.required_Three_CompTwo = newValue;
   }

         public CompTwoContext () {
         }
         
         
         public CompTwoContext (
            
   defaultrepository.Three required_Three_CompTwo
 ) {
            
   this.required_Three_CompTwo = required_Three_CompTwo;

         }
         
         
         

      }
   