package org.palladiosimulator.protocom.framework;

public class ComponentAllocation {

    private Class<?> componentClass;

    private String assemblyContext;

    public ComponentAllocation(Class<?> componentClass, String assemblyContext) {
        super();
        this.componentClass = componentClass;
        this.assemblyContext = assemblyContext;
    }

    public Class<?> getComponentClass() {
        return componentClass;
    }

    public void setComponentClass(Class<?> componentClass) {
        this.componentClass = componentClass;
    }

    public String getAssemblyContext() {
        return assemblyContext;
    }

    public void setAssemblyContext(String assemblyContext) {
        this.assemblyContext = assemblyContext;
    }

}
