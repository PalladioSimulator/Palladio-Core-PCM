/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class RepositorydecoratorXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RepositorydecoratorXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        RepositorydecoratorPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the RepositorydecoratorResourceFactoryImpl
     * factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (this.registrations == null) {
            super.getRegistrations();
            this.registrations.put(XML_EXTENSION, new RepositorydecoratorResourceFactoryImpl());
            this.registrations.put(STAR_EXTENSION, new RepositorydecoratorResourceFactoryImpl());
        }
        return this.registrations;
    }

} // RepositorydecoratorXMLProcessor
