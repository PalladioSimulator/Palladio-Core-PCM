
		package brs_repository.impl.bean;
		
		/** The Enterprise Java Bean for the component Scheduler
		*/
		@javax.ejb.Stateless
		public class SchedulerBean
			extends brs_repository.impl.Scheduler
			implements brs_repository.impl.bean.ISchedulerBean
		{
			
	public SchedulerBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/Scheduler/Context",beanInterface=brs_repository.impl.contexts.ISchedulerContext.class)
   @Override
   public void setContext(brs_repository.impl.contexts.ISchedulerContext context) {
      super.setContext(context);
   }

		}
	