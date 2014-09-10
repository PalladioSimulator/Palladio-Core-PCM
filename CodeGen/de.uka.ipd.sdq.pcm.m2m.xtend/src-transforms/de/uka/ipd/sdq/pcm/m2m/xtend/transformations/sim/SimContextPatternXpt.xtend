package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ContextPatternXpt
import edu.kit.ipd.sdq.xtend2m.annotations.ModelIn

@ModelIn(#[
	"pcm.core.entity.InterfaceRequiringEntity"
])
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
	
	override contextInterfaceAdditionsTM(InterfaceRequiringEntity entity) {
		contextInterfaceUserData(entity)
	}

	override componentContextImplAdditionsTM(InterfaceRequiringEntity entity) {
		componentContextImplUserData(entity)
	}
		
}