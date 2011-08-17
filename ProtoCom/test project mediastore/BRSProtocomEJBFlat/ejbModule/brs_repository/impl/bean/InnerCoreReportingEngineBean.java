
		package brs_repository.impl.bean;
		
		/** The Enterprise Java Bean for the component InnerCoreReportingEngine
		*/
		@javax.ejb.Stateless
		public class InnerCoreReportingEngineBean
			extends brs_repository.impl.InnerCoreReportingEngine
			implements brs_repository.impl.bean.IInnerCoreReportingEngineBean
		{
			
	public InnerCoreReportingEngineBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/InnerCoreReportingEngine/Context",beanInterface=brs_repository.impl.contexts.IInnerCoreReportingEngineContext.class)
   @Override
   public void setContext(brs_repository.impl.contexts.IInnerCoreReportingEngineContext context) {
      super.setContext(context);
   }

		}
	