
		package mediastorerepository.impl.bean;
		
		/** The Enterprise Java Bean for the component EncodingMediaStore
		*/
		@javax.ejb.Stateless
		public class EncodingMediaStoreBean
			extends mediastorerepository.impl.EncodingMediaStore
			implements mediastorerepository.impl.bean.IEncodingMediaStoreBean
		{
			
	public EncodingMediaStoreBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/EncodingMediaStore/Context",beanInterface=mediastorerepository.impl.contexts.IEncodingMediaStoreContext.class)
   @Override
   public void setContext(mediastorerepository.impl.contexts.IEncodingMediaStoreContext context) {
      super.setContext(context);
   }

		}
	