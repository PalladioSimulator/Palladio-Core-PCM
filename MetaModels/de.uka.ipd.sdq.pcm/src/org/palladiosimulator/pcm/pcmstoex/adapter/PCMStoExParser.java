package org.palladiosimulator.pcm.pcmstoex.adapter;

import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.service.DefaultRuntimeModule;
import org.palladiosimulator.commons.stoex.adapter.StoExParser;
import org.palladiosimulator.pcm.pcmstoex.PCMStoExRuntimeModule;
import org.palladiosimulator.pcm.pcmstoex.PCMStoExStandaloneSetup;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

/**
 * @author Jonas Heinisch
 *
 */
public class PCMStoExParser extends StoExParser {

    /**
     * Constructor for PCM-specific StoEx parser adapter. Use this for eclipse runtime.
     * 
     * @param s
     *            String to parse
     */
    public PCMStoExParser(String s) {
        this(s, false);
    }

    /**
     * Constructor for PCM-specific StoEx parser adapter.
     * 
     * @param standalone
     *            set true if not working inside eclipse
     * @param s
     *            String to parse
     */
    public PCMStoExParser(String s, boolean standalone) {
        super(s, standalone);
    }

    @Override
    protected DefaultRuntimeModule getRuntimeModule() {
        return new PCMStoExRuntimeModule();
    }

    @Override
    protected ISetup getStandaloneSetup() {
        return new PCMStoExStandaloneSetup();
    }
    
    @Override
    protected Collection<EPackage> registerEPackages() {
        Collection<EPackage> packages = super.registerEPackages();
        packages.add(ParameterPackage.eINSTANCE);
        return packages;
    }
}
