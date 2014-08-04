package de.uka.ipd.sdq.simucomframework.variables.userdata;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class UserData {

    List<UserDataEntry> userData = new ArrayList<UserDataEntry>();

    private static Logger logger = Logger.getLogger(SimulatedStackframe.class.getName());

    public UserData() {

    }

    public void addUserData(String variableName, String assemblyContextID, Object value) {
        userData.add(new UserDataEntry(variableName, assemblyContextID, value));
    }

    public void overwriteParametersForAssemblyContext(String assemblyContext,
            SimulatedStackframe<Object> currentStackframe) {

        for (UserDataEntry userDataEntry : userData) {
            if (assemblyContext.equals(userDataEntry.getAssemblyContextID())) {
                currentStackframe.addValue(userDataEntry.getVariableName(), userDataEntry.getValue());
                if (logger.isEnabledFor(Level.INFO))
                    logger.info("Storing variable " + userDataEntry.getVariableName() + " for AssemblyContext "
                            + userDataEntry.getAssemblyContextID());
            }
        }

    }

}

class UserDataEntry {

    private String variableName;
    private String assemblyContextID;

    private Object value;

    public UserDataEntry(String assemblyContextID, String variableName, Object value) {
        super();
        this.variableName = variableName;
        this.assemblyContextID = assemblyContextID;
        this.value = value;
    }

    public String getVariableName() {
        return variableName;
    }

    public String getAssemblyContextID() {
        return assemblyContextID;
    }

    public Object getValue() {
        return value;
    }

}
