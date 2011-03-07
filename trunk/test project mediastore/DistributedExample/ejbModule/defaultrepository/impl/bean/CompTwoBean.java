
		package defaultrepository.impl.bean;
		
		/** The Enterprise Java Bean for the component CompTwo
		*/
		@javax.ejb.Stateless
		public class CompTwoBean
			extends defaultrepository.impl.CompTwo
			implements defaultrepository.impl.bean.ICompTwoBean
		{
			
	public CompTwoBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/CompTwo/Context",beanInterface=defaultrepository.impl.contexts.ICompTwoContext.class)
   @Override
   public void setContext(defaultrepository.impl.contexts.ICompTwoContext context) {
      super.setContext(context);
   }

		}
	