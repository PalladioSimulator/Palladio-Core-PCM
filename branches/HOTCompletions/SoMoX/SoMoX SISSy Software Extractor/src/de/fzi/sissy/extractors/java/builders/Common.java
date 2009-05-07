package de.fzi.sissy.extractors.java.builders;

import java.util.List;

import recoder.abstraction.ClassType;
import recoder.abstraction.Method;
import recoder.abstraction.ParameterizedType;
import recoder.abstraction.Type;
import recoder.abstraction.TypeArgument;
import recoder.java.declaration.TypeArgumentDeclaration;
import recoder.java.expression.operator.New;
import recoder.java.reference.ConstructorReference;
import recoder.java.reference.MethodReference;
import recoder.java.reference.TypeReference;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.FunctionAccess;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.metamod.TypeAccess;

public class Common {

    public static void extractTypeArguments(TypeAccess typeAccess, Type referencedType_recoder) {
        if (referencedType_recoder instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) referencedType_recoder;
            List<? extends TypeArgument> taList = pType.getTypeArgs();
        	if (taList == null)
        		return;
            for (TypeArgument ta : taList) {
                if ((ta.getWildcardMode() == TypeArgument.WildcardMode.Any) || 
                    (ta.getWildcardMode() == TypeArgument.WildcardMode.Super)) {
                    de.fzi.sissy.metamod.Type mmType = ClassTypeBuilder.getSingleton().extractMembers(ExtractorFassade.getNameInfo().getJavaLangObject()); 
                    if (mmType != null)
                        typeAccess.addTypeArg(mmType);
                } else {
                    if (ta instanceof TypeArgumentDeclaration) {
                        TypeArgumentDeclaration tad = (TypeArgumentDeclaration) ta;
                        Type type_recoder = ExtractorFassade.getSourceInfo().getType(tad.getTypeReference());
                        if (type_recoder instanceof ClassType) {
                            de.fzi.sissy.metamod.Type type_mm = ClassTypeBuilder.getSingleton().extractMembers((ClassType)type_recoder);
                            if (type_mm != null)                            	
                                typeAccess.addTypeArg(type_mm);
                        }
                    }
                }
            }
        }
    }
    
    public static void extractTypeArguments(FunctionAccess funcAccess, MethodReference referencedMethod_recoder) {
    	List<? extends TypeArgument> taList = referencedMethod_recoder.getTypeArguments();
    	if (taList == null)
    		return;
        for (TypeArgument ta : taList) {
        	if ((ta.getWildcardMode() == TypeArgument.WildcardMode.Any) || 
        			(ta.getWildcardMode() == TypeArgument.WildcardMode.Super)) {
                de.fzi.sissy.metamod.Type mmType = ClassTypeBuilder.getSingleton().extractMembers(ExtractorFassade.getNameInfo().getJavaLangObject()); 
                if (mmType != null)
                	funcAccess.addTypeArg(mmType);
        	} else {
            	if (ta instanceof TypeArgumentDeclaration) {
                	TypeArgumentDeclaration tad = (TypeArgumentDeclaration) ta;
                    Type type_recoder = ExtractorFassade.getSourceInfo().getType(tad.getTypeReference());
                    if (type_recoder instanceof ClassType) {
                    	de.fzi.sissy.metamod.Type type_mm = ClassTypeBuilder.getSingleton().extractMembers((ClassType)type_recoder);
                        if (type_mm != null)                            	
                        	funcAccess.addTypeArg(type_mm);
                    }
                }
            }
        }
    }

    public static void extractTypeArguments(FunctionAccess funcAccess, ConstructorReference constructorRef_recoder) {
    	if (constructorRef_recoder instanceof New) {
    		TypeReference typeRef = ((New)constructorRef_recoder).getTypeReference();
        	List<? extends TypeArgument> taList = typeRef.getTypeArguments();
        	if (taList == null)
        		return;
            for (TypeArgument ta : taList) {
            	if ((ta.getWildcardMode() == TypeArgument.WildcardMode.Any) || 
            			(ta.getWildcardMode() == TypeArgument.WildcardMode.Super)) {
                    de.fzi.sissy.metamod.Type mmType = ClassTypeBuilder.getSingleton().extractMembers(ExtractorFassade.getNameInfo().getJavaLangObject()); 
                    if (mmType != null)
                    	funcAccess.addTypeArg(mmType);
            	} else {
                	if (ta instanceof TypeArgumentDeclaration) {
                    	TypeArgumentDeclaration tad = (TypeArgumentDeclaration) ta;
                        Type type_recoder = ExtractorFassade.getSourceInfo().getType(tad.getTypeReference());
                        if (type_recoder instanceof ClassType) {
                        	de.fzi.sissy.metamod.Type type_mm = ClassTypeBuilder.getSingleton().extractMembers((ClassType)type_recoder);
                            if (type_mm != null)                            	
                            	funcAccess.addTypeArg(type_mm);
                        }
                    }
                }
            }
    	}
    }
}
