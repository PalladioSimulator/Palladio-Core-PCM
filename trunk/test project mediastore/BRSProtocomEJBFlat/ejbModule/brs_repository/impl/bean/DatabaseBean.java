
		package brs_repository.impl.bean;
		
		/** The Enterprise Java Bean for the component Database
		*/
		@javax.ejb.Stateless
		public class DatabaseBean
			extends brs_repository.impl.Database
			implements brs_repository.impl.bean.IDatabaseBean
		{
			
	public DatabaseBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/Database/Context",beanInterface=brs_repository.impl.contexts.IDatabaseContext.class)
   @Override
   public void setContext(brs_repository.impl.contexts.IDatabaseContext context) {
      super.setContext(context);
   }

		}
	