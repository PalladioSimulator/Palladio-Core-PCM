package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ContextPatternXpt

class SimContextPatternXpt extends ContextPatternXpt {
	def contextInterfaceUserData(InterfaceRequiringEntity ire) '''
		
		public de.uka.ipd.sdq.simucomframework.variables.userdata.UserData getUserData();
		  	  
		public void setUserData(de.uka.ipd.sdq.simucomframework.variables.userdata.UserData data);
		
	'''

	def componentContextImplUserData(InterfaceRequiringEntity ire) '''
		
		de.uka.ipd.sdq.simucomframework.variables.userdata.UserData myUserData;
		
		public de.uka.ipd.sdq.simucomframework.variables.userdata.UserData getUserData(){
		  return this.myUserData;
		}
		  	  
		public void setUserData(de.uka.ipd.sdq.simucomframework.variables.userdata.UserData data){
		  this.myUserData = data;
		}
		
	'''

	// overwritten template methods
	override CharSequence contextInterfaceAdditionsTM(InterfaceRequiringEntity entity) {
		contextInterfaceUserData(entity)
	}

	override CharSequence componentContextImplAdditionsTM(InterfaceRequiringEntity entity) {
		componentContextImplUserData(entity)
	}

}
