
      package defaultrepository.impl.contexts;

      // Component context class for CompOne
      public class CompOneContext implements defaultrepository.impl.contexts.ICompOneContext
      {
         
   protected defaultrepository.Two required_Two_CompOne = null;

         
   public defaultrepository.Two getRoleRequired_Two_CompOne() {
   	  if (required_Two_CompOne == null) {
   	  	  throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
   	  	  		"Role Required_Two_CompOne <_lvmXwDglEeCFP6TiQB0B7A> RequiringEntity CompOne");
      }
      return required_Two_CompOne;
   }

         
   public void setRoleRequired_Two_CompOne(defaultrepository.Two newValue) {
      this.required_Two_CompOne = newValue;
   }

         public CompOneContext () {
         }
         
         
         public CompOneContext (
            
   defaultrepository.Two required_Two_CompOne
 ) {
            
   this.required_Two_CompOne = required_Two_CompOne;

         }
         
         
         

      }
   