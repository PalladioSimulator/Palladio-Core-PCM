
		package brs_repository.impl.bean;
		
		/** The Enterprise Java Bean for the component WebServer
		*/
		@javax.ejb.Stateless
		public class WebServerBean
			extends brs_repository.impl.WebServer
			implements brs_repository.impl.bean.IWebServerBean
		{
			
	public WebServerBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/WebServer/Context",beanInterface=brs_repository.impl.contexts.IWebServerContext.class)
   @Override
   public void setContext(brs_repository.impl.contexts.IWebServerContext context) {
      super.setContext(context);
   }

		}
	