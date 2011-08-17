
		package mediastorerepository.impl.bean;
		
		/** The Enterprise Java Bean for the component DigitalWatermarking
		*/
		@javax.ejb.Stateless
		public class DigitalWatermarkingBean
			extends mediastorerepository.impl.DigitalWatermarking
			implements mediastorerepository.impl.bean.IDigitalWatermarkingBean
		{
			
	public DigitalWatermarkingBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/DigitalWatermarking/Context",beanInterface=mediastorerepository.impl.contexts.IDigitalWatermarkingContext.class)
   @Override
   public void setContext(mediastorerepository.impl.contexts.IDigitalWatermarkingContext context) {
      super.setContext(context);
   }

		}
	