/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ResourceenvironmentdecoratorXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceenvironmentdecoratorXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        ResourceenvironmentdecoratorPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the
     * ResourceenvironmentdecoratorResourceFactoryImpl factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (this.registrations == null) {
            super.getRegistrations();
            this.registrations.put(XML_EXTENSION, new ResourceenvironmentdecoratorResourceFactoryImpl());
            this.registrations.put(STAR_EXTENSION, new ResourceenvironmentdecoratorResourceFactoryImpl());
        }
        return this.registrations;
    }

} // ResourceenvironmentdecoratorXMLProcessor
