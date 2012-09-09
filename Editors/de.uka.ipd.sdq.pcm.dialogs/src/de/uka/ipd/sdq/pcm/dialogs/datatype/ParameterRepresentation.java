package de.uka.ipd.sdq.pcm.dialogs.datatype;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * Responsibly for representation different Signature property (ReturnType, Parameters, Exceptions),
 * as string
 * 
 * @author Roman Andrej
 */
public class ParameterRepresentation {

    /**
     * Represents DataType in accordance with Palladio styles
     */
    public static String dataTypeToString(DataType returnType) {

        String result = "";

        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
        adapterFactory.addAdapterFactory(new RepositoryItemProviderAdapterFactory());

        PalladioItemProviderAdapterFactory decoratedFactory = new PalladioItemProviderAdapterFactory(adapterFactory);

        if (returnType != null) {
            IItemLabelProvider datatypeProvider = (IItemLabelProvider) decoratedFactory.adapt((Object) returnType,
                    IItemLabelProvider.class);
            result = datatypeProvider.getText(returnType);
        }

        return result;
    }

    /**
     * The method create the string list of parameter (parameter1, parameter2, ...)
     */
    public static String parametersToString(EList<Parameter> parameters) {
        String result = "";

        for (Iterator<Parameter> it = parameters.iterator(); it.hasNext();) {
            result += it.next().getParameterName() + ", ";
        }
        return deleteComma(result);
    }

    /**
     * Comma of the sentence deletes ends
     */
    private static String deleteComma(String result) {
        if (!result.equals("")) {
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }
}
