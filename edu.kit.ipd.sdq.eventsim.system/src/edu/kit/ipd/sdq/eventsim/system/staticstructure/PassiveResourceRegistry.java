//package edu.kit.ipd.sdq.eventsim.system.staticstructure;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
//import de.uka.ipd.sdq.pcm.repository.PassiveResource;
//import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;
//import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;
//
///**
// * This class serves as registry for passive resources by mapping passive resource specifications to
// * passive resource instances.
// * <p>
// * Notice the distinction between resource specifications and resource instances:
// * <ul>
// * <li>specification: {@link PassiveResource}</li>
// * <li>instance: {@link SimPassiveResource}</li>
// * </ul>
// * 
// * @author Philipp Merkle
// * 
// */
//public class PassiveResourceRegistry {
//
//    // maps (AssemblyContext ID, PassiveResource ID) -> SimPassiveResource
//    private Map<String, SimPassiveResource> map;
//
//    /**
//     * Constructs a new registry for passive resources.
//     */
//    public PassiveResourceRegistry() {
//        this.map = new HashMap<String, SimPassiveResource>();
//    }
//
//    /**
//     * Registers a {@link SimPassiveResource} by mapping the given passive resource specification to
//     * the specified passive resource instance. The same passive resource specification can be
//     * instantiated in multiple {@link AssemblyContext}s, which is why the mapping also requires the
//     * assembly context of the resource instance.
//     * 
//     * @param specification
//     *            the passive resource specification
//     * @param instance
//     *            the passive resource instance
//     * @param assemblyCtx
//     *            the assembly context to which the resource instance belongs
//     */
//    public void registerPassiveResource(PassiveResource specification, SimPassiveResource instance,
//            AssemblyContext assemblyCtx) {
//        map.put(assemblyCtx.getId() + specification.getId(), instance);
//    }
//
//    /**
//     * Returns the passive resource instance for the given passive resource specification, which
//     * belongs to the specified assembly context.
//     * 
//     * @param specification
//     *            the passive resource specification
//     * @param assemblyCtx
//     *            the assembly context to which the returned resource instance belongs
//     * @return the resource instance for the passed specification and assembly context
//     */
//    public SimPassiveResource getPassiveResourceForContext(PassiveResource specification, AssemblyContext assemblyCtx) {
//        SimPassiveResource r = map.get(assemblyCtx.getId() + specification.getId());
//        if (r == null) {
//            throw new RuntimeException("Could not find the passive resource instance for "
//                    + PCMEntityHelper.toString(specification) + " in " + PCMEntityHelper.toString(assemblyCtx));
//        }
//        return r;
//    }
//
//    /**
//     * Returns all passive resource instances registered with this registry.
//     * 
//     * @return a collection of all registered passive resource instances
//     */
//    public Collection<SimPassiveResource> getPassiveResources() {
//        return map.values();
//    }
//
//}
