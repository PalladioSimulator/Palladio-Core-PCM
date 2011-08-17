
		package brs_repository.impl.bean;
		
		/** The Enterprise Java Bean for the component CRESingleMessageAdapter
		*/
		@javax.ejb.Stateless
		public class CRESingleMessageAdapterBean
			extends brs_repository.impl.CRESingleMessageAdapter
			implements brs_repository.impl.bean.ICRESingleMessageAdapterBean
		{
			
	public CRESingleMessageAdapterBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/CRESingleMessageAdapter/Context",beanInterface=brs_repository.impl.contexts.ICRESingleMessageAdapterContext.class)
   @Override
   public void setContext(brs_repository.impl.contexts.ICRESingleMessageAdapterContext context) {
      super.setContext(context);
   }

		}
	