package de.uka.sdq.pcm.transformations.builder.infrastructure;

import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.sdq.pcm.transformations.builder.IComponentBuilder;


public interface IMiddlewareInteractingComponentBuilder extends
		IComponentBuilder {

		
		/**
		 */
		public abstract RequiredRole getMiddlewareRole();
		

}
