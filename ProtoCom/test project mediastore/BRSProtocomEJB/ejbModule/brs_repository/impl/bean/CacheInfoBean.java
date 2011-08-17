
		package brs_repository.impl.bean;
		
		/** The Enterprise Java Bean for the component CacheInfo
		*/
		@javax.ejb.Stateless
		public class CacheInfoBean
			extends brs_repository.impl.CacheInfo
			implements brs_repository.impl.bean.ICacheInfoBean
		{
			
	public CacheInfoBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/CacheInfo/Context",beanInterface=brs_repository.impl.contexts.ICacheInfoContext.class)
   @Override
   public void setContext(brs_repository.impl.contexts.ICacheInfoContext context) {
      super.setContext(context);
   }

		}
	