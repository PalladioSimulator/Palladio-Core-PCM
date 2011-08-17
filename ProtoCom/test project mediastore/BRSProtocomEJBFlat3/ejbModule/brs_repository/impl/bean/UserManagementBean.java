
		package brs_repository.impl.bean;
		
		/** The Enterprise Java Bean for the component UserManagement
		*/
		@javax.ejb.Stateless
		public class UserManagementBean
			extends brs_repository.impl.UserManagement
			implements brs_repository.impl.bean.IUserManagementBean
		{
			
	public UserManagementBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/UserManagement/Context",beanInterface=brs_repository.impl.contexts.IUserManagementContext.class)
   @Override
   public void setContext(brs_repository.impl.contexts.IUserManagementContext context) {
      super.setContext(context);
   }

		}
	