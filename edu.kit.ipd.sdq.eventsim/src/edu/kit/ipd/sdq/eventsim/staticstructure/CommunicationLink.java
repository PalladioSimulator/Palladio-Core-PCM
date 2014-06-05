package edu.kit.ipd.sdq.eventsim.staticstructure;

import java.util.List;

import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * A communication link connects two or more {@link SimulatedResourceContainer}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class CommunicationLink {

    private List<SimulatedResourceContainer> connectedContainer;
    private CommunicationLinkResourceSpecification specification;

    /**
     * Default constructor.
     * 
     * @param connectedContainer
     *            the containers that are connected by this link
     * @param specification
     *            the specification of the communication channel connecting the resource containers
     */
    public CommunicationLink(List<SimulatedResourceContainer> connectedContainer,
            CommunicationLinkResourceSpecification specification) {
        this.connectedContainer = connectedContainer;
        this.specification = specification;
    }

    /**
     * Returns whether this link establishes a connection between the specified resource containers.
     * 
     * @param c1
     *            first resource container
     * @param c2
     *            second resource container
     * @return true if this links connects both resource containers; false else
     */
    public boolean connects(SimulatedResourceContainer c1, SimulatedResourceContainer c2) {
        return connectedContainer.contains(c1) && connectedContainer.contains(c2);
    }

    /**
     * Returns the specification of the communication channel represented by this link.
     */
    public CommunicationLinkResourceSpecification getSpecification() {
        return specification;
    }

    /**
     * Returns the list of resource containers connected by this link.
     */
    public List<SimulatedResourceContainer> getConnectedContainer() {
        return connectedContainer;
    }

    @Override
    public String toString() {
        return PCMEntityHelper.toString(specification.getLinkingResource_CommunicationLinkResourceSpecification());
    }

}
