/*
 * generated by Xtext 2.24.0
 */
package org.palladiosimulator.pcm.stoex;

import org.eclipse.emf.ecore.EPackage;
import org.palladiosimulator.pcm.parameter.ParameterPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class PCMStoexStandaloneSetup extends PCMStoexStandaloneSetupGenerated {

    public static void doSetup() {
        new PCMStoexStandaloneSetup().createInjectorAndDoEMFRegistration();
    }

    @Override
    public void register(Injector injector) {
        if (!EPackage.Registry.INSTANCE.containsKey(de.uka.ipd.sdq.stoex.StoexPackage.eNS_URI)) {
            EPackage.Registry.INSTANCE.put(de.uka.ipd.sdq.stoex.StoexPackage.eNS_URI,
                    de.uka.ipd.sdq.stoex.StoexPackage.eINSTANCE);
        }
        if (!EPackage.Registry.INSTANCE.containsKey(de.uka.ipd.sdq.probfunction.ProbfunctionPackage.eNS_URI)) {
            EPackage.Registry.INSTANCE.put(de.uka.ipd.sdq.probfunction.ProbfunctionPackage.eNS_URI,
                    de.uka.ipd.sdq.probfunction.ProbfunctionPackage.eINSTANCE);
        }
        if (!EPackage.Registry.INSTANCE.containsKey(de.uka.ipd.sdq.units.UnitsPackage.eNS_URI)) {
            EPackage.Registry.INSTANCE.put(de.uka.ipd.sdq.units.UnitsPackage.eNS_URI,
                    de.uka.ipd.sdq.units.UnitsPackage.eINSTANCE);
        }
        if (!EPackage.Registry.INSTANCE.containsKey(ParameterPackage.eNS_URI)) {
            EPackage.Registry.INSTANCE.put(ParameterPackage.eNS_URI, ParameterPackage.eINSTANCE);
        }

        super.register(injector);
    }
}