
		package defaultrepository.impl.bean;
		
		/** The Enterprise Java Bean for the component CompThree
		*/
		@javax.ejb.Stateless
		public class CompThreeBean
			extends defaultrepository.impl.CompThree
			implements defaultrepository.impl.bean.ICompThreeBean
		{
			
	public CompThreeBean() {
	}

			
   // Called by the Container to inject a reference to the local interface of this components
   // context class
   @javax.ejb.EJB(name="ejb/CompThree/Context",beanInterface=defaultrepository.impl.contexts.ICompThreeContext.class)
   @Override
   public void setContext(defaultrepository.impl.contexts.ICompThreeContext context) {
      super.setContext(context);
   }

		}
	