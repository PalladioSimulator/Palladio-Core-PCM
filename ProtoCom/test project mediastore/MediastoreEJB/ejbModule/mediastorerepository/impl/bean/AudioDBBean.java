
		package mediastorerepository.impl.bean;
		
		/** The Enterprise Java Bean for the component AudioDB
		*/
		@javax.ejb.Stateless
		public class AudioDBBean
			extends mediastorerepository.impl.AudioDB
			implements mediastorerepository.impl.bean.IAudioDBBean
		{
			
	public AudioDBBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/AudioDB/Context",beanInterface=mediastorerepository.impl.contexts.IAudioDBContext.class)
   @Override
   public void setContext(mediastorerepository.impl.contexts.IAudioDBContext context) {
      super.setContext(context);
   }

		}
	