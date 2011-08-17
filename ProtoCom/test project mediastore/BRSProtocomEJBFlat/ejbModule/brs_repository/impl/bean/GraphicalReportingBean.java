
		package brs_repository.impl.bean;
		
		/** The Enterprise Java Bean for the component GraphicalReporting
		*/
		@javax.ejb.Stateless
		public class GraphicalReportingBean
			extends brs_repository.impl.GraphicalReporting
			implements brs_repository.impl.bean.IGraphicalReportingBean
		{
			
	public GraphicalReportingBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/GraphicalReporting/Context",beanInterface=brs_repository.impl.contexts.IGraphicalReportingContext.class)
   @Override
   public void setContext(brs_repository.impl.contexts.IGraphicalReportingContext context) {
      super.setContext(context);
   }

		}
	