
		package brs_repository.impl.bean;
		
		/** The Enterprise Java Bean for the component OnlineReporting
		*/
		@javax.ejb.Stateless
		public class OnlineReportingBean
			extends brs_repository.impl.OnlineReporting
			implements brs_repository.impl.bean.IOnlineReportingBean
		{
			
	public OnlineReportingBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/OnlineReporting/Context",beanInterface=brs_repository.impl.contexts.IOnlineReportingContext.class)
   @Override
   public void setContext(brs_repository.impl.contexts.IOnlineReportingContext context) {
      super.setContext(context);
   }

		}
	