
		package mediastorerepository.impl.bean;
		
		/** The Enterprise Java Bean for the component DBCache
		*/
		@javax.ejb.Stateless
		public class DBCacheBean
			extends mediastorerepository.impl.DBCache
			implements mediastorerepository.impl.bean.IDBCacheBean
		{
			
	public DBCacheBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/DBCache/Context",beanInterface=mediastorerepository.impl.contexts.IDBCacheContext.class)
   @Override
   public void setContext(mediastorerepository.impl.contexts.IDBCacheContext context) {
      super.setContext(context);
   }

		}
	