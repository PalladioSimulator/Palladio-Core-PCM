
		package mediastorerepository.impl.bean;
		
		/** The Enterprise Java Bean for the component MediaStore
		*/
		@javax.ejb.Stateless
		public class MediaStoreBean
			extends mediastorerepository.impl.MediaStore
			implements mediastorerepository.impl.bean.IMediaStoreBean
		{
			
	public MediaStoreBean() {
		System.out.println("I'm the mediastore bean");
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/MediaStore/Context",beanInterface=mediastorerepository.impl.contexts.IMediaStoreContext.class)
   @Override
   public void setContext(mediastorerepository.impl.contexts.IMediaStoreContext context) {
      super.setContext(context);
   }

		}
	