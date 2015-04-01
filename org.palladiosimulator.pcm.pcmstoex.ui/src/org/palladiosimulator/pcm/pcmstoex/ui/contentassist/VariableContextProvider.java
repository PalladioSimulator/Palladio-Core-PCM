package org.palladiosimulator.pcm.pcmstoex.ui.contentassist;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Contains a Map of Variables and their description for contexthelp.
 * @author Jonas Heinisch
 *
 */
public class VariableContextProvider {
    private static volatile VariableContextProvider instance;
    
    public static VariableContextProvider getInstance(){
        if(instance==null){
            instance = new VariableContextProvider();
        }
        return instance;
    }
    
    public static void resetInstance(){
        instance = null;
    }
    
    private Map<String,String> variables;
    
    private VariableContextProvider() {
        variables = new HashMap<String, String>();
    }

    public Map<String,String> getVariableMap() {
        return variables;
    }

    public void addVariable(String name, String description){
        variables.put(name, description);
    }
    
    public Set<String> getVariables(){
        return variables.keySet();
    }
}
