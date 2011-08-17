
		package mediastorerepository.impl.bean;
		
		/** The Enterprise Java Bean for the component Encoding
		*/
		@javax.ejb.Stateless
		public class EncodingBean
			extends mediastorerepository.impl.Encoding
			implements mediastorerepository.impl.bean.IEncodingBean
		{
			
	public EncodingBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/Encoding/Context",beanInterface=mediastorerepository.impl.contexts.IEncodingContext.class)
   @Override
   public void setContext(mediastorerepository.impl.contexts.IEncodingContext context) {
      super.setContext(context);
   }

		}
	