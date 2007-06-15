package de.uka.sdq.pcm.transformations.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.sdq.pcm.transformations.BytesizeComputationForSignature;

public class BytesizeComputationForSignatureTest {

	private Signature testSig;
	
	@Before
	public void setUp(){
		RepositoryFactory factory = RepositoryFactory.eINSTANCE; 
		
		testSig = factory.createSignature();
		
		Parameter param1 = factory.createParameter();
		PrimitiveDataType primDT = factory.createPrimitiveDataType();
		primDT.setType(PrimitiveTypeEnum.INT);
		param1.setParameterName("param1");
		param1.setDatatype__Parameter(primDT);
		testSig.getParameters__Signature().add(param1);
		
		Parameter param2 = factory.createParameter();
		CollectionDataType collDT = factory.createCollectionDataType();
		collDT.setEntityName("SomeCollection");
		param2.setDatatype__Parameter(collDT);
		param2.setParameterName("param2");
		testSig.getParameters__Signature().add(param2);
		
		Parameter param3 = factory.createParameter();
		CompositeDataType compDT = factory.createCompositeDataType();
		compDT.setEntityName("SomeComposite");
		param3.setDatatype__Parameter(compDT);
		param3.setParameterName("param3");
		
		InnerDeclaration innerDecl1 = factory.createInnerDeclaration();
		innerDecl1.setEntityName("innerParam1");
		innerDecl1.setDatatype_InnerDeclaration(primDT);
		compDT.getInnerDeclaration_CompositeDataType().add(innerDecl1);

		InnerDeclaration innerDecl2 = factory.createInnerDeclaration();
		innerDecl2.setEntityName("innerParam2");
		innerDecl2.setDatatype_InnerDeclaration(primDT);
		compDT.getInnerDeclaration_CompositeDataType().add(innerDecl2);
		
		InnerDeclaration innerDecl3 = factory.createInnerDeclaration();
		innerDecl3.setEntityName("innerParam3");
		innerDecl3.setDatatype_InnerDeclaration(collDT);
		compDT.getInnerDeclaration_CompositeDataType().add(innerDecl3);

		InnerDeclaration innerDecl4 = factory.createInnerDeclaration();
		innerDecl4.setEntityName("innerParam4");
		
		CompositeDataType compDT2 = factory.createCompositeDataType();
		compDT2.setEntityName("AnotherComposite");
		innerDecl4.setDatatype_InnerDeclaration(compDT2);
		InnerDeclaration innerInnerDecl1 = factory.createInnerDeclaration();
		innerInnerDecl1.setEntityName("innerInnerParam1");
		innerInnerDecl1.setDatatype_InnerDeclaration(primDT);
		compDT2.getInnerDeclaration_CompositeDataType().add(innerInnerDecl1);
		
		compDT.getInnerDeclaration_CompositeDataType().add(innerDecl4);
		
		
		testSig.getParameters__Signature().add(param3);
		
	}
	
	@Test
	public void testGetByteSize(){
		BytesizeComputationForSignature blah = new BytesizeComputationForSignature();
		String actual = blah.getBytesizeForSignature(testSig);
		
		Assert.assertEquals("param1.BYTESIZE + " +
				"param2.NUMBER_OF_ELEMENTS * param2.INNER.BYTESIZE + " + 
				"param3.innerParam1.BYTESIZE + " + 
				"param3.innerParam2.BYTESIZE + " + 
				"param3.innerParam3.NUMBER_OF_ELEMENTS * param3.innerParam3.INNER.BYTESIZE + " +
				"param3.innerParam4.innerInnerParam1.BYTESIZE", actual);
	}
	
}
