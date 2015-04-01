package org.palladiosimulator.pcm.pcmstoex.adapter;

import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.palladiosimulator.commons.stoex.adapter.StoExSerializer;
import org.palladiosimulator.pcm.pcmstoex.PCMStoExRuntimeModule;
import org.palladiosimulator.pcm.pcmstoex.PCMStoExStandaloneSetup;

import com.google.inject.Module;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

/**
 * Serializer adapter for PCM-specific StoEx.
 * 
 * @author Jonas Heinisch
 *
 */
public class PCMStoExSerializer extends StoExSerializer {

    @Override
    protected Module getRuntimeModule() {
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
