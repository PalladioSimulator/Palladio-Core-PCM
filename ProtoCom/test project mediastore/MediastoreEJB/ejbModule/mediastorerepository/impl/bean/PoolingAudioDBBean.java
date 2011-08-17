
		package mediastorerepository.impl.bean;
		
		/** The Enterprise Java Bean for the component PoolingAudioDB
		*/
		@javax.ejb.Stateless
		public class PoolingAudioDBBean
			extends mediastorerepository.impl.PoolingAudioDB
			implements mediastorerepository.impl.bean.IPoolingAudioDBBean
		{
			
	public PoolingAudioDBBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/PoolingAudioDB/Context",beanInterface=mediastorerepository.impl.contexts.IPoolingAudioDBContext.class)
   @Override
   public void setContext(mediastorerepository.impl.contexts.IPoolingAudioDBContext context) {
      super.setContext(context);
   }

		}
	