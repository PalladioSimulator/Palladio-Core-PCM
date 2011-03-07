
		package defaultrepository.impl.bean;
		
		/** The Enterprise Java Bean for the component CompOne
		*/
		@javax.ejb.Stateless
		public class CompOneBean
			extends defaultrepository.impl.CompOne
			implements defaultrepository.impl.bean.ICompOneBean
		{
			
	public CompOneBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/CompOne/Context",beanInterface=defaultrepository.impl.contexts.ICompOneContext.class)
   @Override
   public void setContext(defaultrepository.impl.contexts.ICompOneContext context) {
      super.setContext(context);
   }

		}
	