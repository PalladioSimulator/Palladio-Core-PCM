package de.uka.ipd.sdq.pcm.transformations.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.transformations.BytesizeComputationForSignature;

public class BytesizeComputationForSignatureTest {

	private OperationSignature testSig1;
	private OperationSignature testSig2;
	private OperationSignature testSig3;
	
	@Before
	public void setUp(){
		RepositoryFactory factory = RepositoryFactory.eINSTANCE; 
		ParameterFactory paramFactory = ParameterFactory.eINSTANCE;
		
		testSig1 = factory.createOperationSignature();
		
		
		Variable param1 = paramFactory.createVariable();
		PrimitiveDataType primDT = factory.createPrimitiveDataType();
		primDT.setEntityName("INT");
		param1.setEntityName("param1");
		param1.setDataType__Variable(primDT);
		testSig1.getParameters__OperationSignature().add(param1);
		
		Variable param2 = paramFactory.createVariable();
		CollectionDataType collDT = factory.createCollectionDataType();
		collDT.setEntityName("SomeCollection");
		collDT.setInnerDataType__CollectionDataType(primDT);
		
		param2.setDataType__Variable(collDT);
		param2.setEntityName("param2");
		//param2.setModifier__Parameter(ParameterModifier.OUT);
		testSig1.getParameters__OperationSignature().add(param2);
		
		
		Variable param3 = paramFactory.createVariable();
		CompositeDataType compDT = factory.createCompositeDataType();
		compDT.setEntityName("SomeComposite");
		param3.setDataType__Variable(compDT);
		param3.setEntityName("param3");
		
		Variable innerDecl1 = paramFactory.createVariable();
		innerDecl1.setEntityName("innerParam1");
		innerDecl1.setDataType__Variable(primDT);
		compDT.getMembers__CompositeDataType().add(innerDecl1);

		Variable innerDecl2 = paramFactory.createVariable();
		innerDecl2.setEntityName("innerParam2");
		innerDecl2.setDataType__Variable(primDT);
		compDT.getMembers__CompositeDataType().add(innerDecl2);
		
		Variable innerDecl3 = paramFactory.createVariable();
		innerDecl3.setEntityName("innerParam3");
		innerDecl3.setDataType__Variable(collDT);
		compDT.getMembers__CompositeDataType().add(innerDecl3);

		Variable innerDecl4 = paramFactory.createVariable();
		innerDecl4.setEntityName("innerParam4");
		
		CompositeDataType compDT2 = factory.createCompositeDataType();
		compDT2.setEntityName("AnotherComposite");
		innerDecl4.setDataType__Variable(compDT2);
		Variable innerInnerDecl1 = paramFactory.createVariable();
		innerInnerDecl1.setEntityName("innerInnerParam1");
		innerInnerDecl1.setDataType__Variable(primDT);
		compDT2.getMembers__CompositeDataType().add(innerInnerDecl1);
		
		compDT.getMembers__CompositeDataType().add(innerDecl4);
		
		
		testSig1.getParameters__OperationSignature().add(param3);
		
	}
	
	/* TODO: update for metamodel changes in parameter package
	@Before
	public void setUp2(){
		RepositoryFactory factory = RepositoryFactory.eINSTANCE; 
		
		testSig2 = factory.createOperationSignature();
		
		Parameter param1 = factory.createParameter();
		PrimitiveDataType primDT = factory.createPrimitiveDataType();
		primDT.setType(PrimitiveTypeEnum.INT);
		param1.setParameterName("param1");
		param1.setDatatype__Parameter(primDT);
		testSig2.getParameters__Signature().add(param1);
		
		Parameter param2 = factory.createParameter();
		CollectionDataType collDT = factory.createCollectionDataType();
		collDT.setEntityName("SomeCollection");
		param2.setDatatype__Parameter(collDT);
		param2.setParameterName("param2");
		testSig2.getParameters__Signature().add(param2);
		
		
		CollectionDataType collDT2 = factory.createCollectionDataType();
		collDT2.setEntityName("SomeCollection2");
		collDT2.setInnerDataType__CollectionDataType(primDT);
		
		collDT.setInnerDataType__CollectionDataType(collDT2);		
		
	}

	@Before
	public void setUp3(){
		RepositoryFactory factory = RepositoryFactory.eINSTANCE; 
		
		testSig3 = factory.createOperationSignature();
		
		Parameter param1 = factory.createParameter();
		PrimitiveDataType primDT = factory.createPrimitiveDataType();
		primDT.setType(PrimitiveTypeEnum.INT);
		param1.setParameterName("param1");
		param1.setDatatype__Parameter(primDT);
		testSig3.getParameters__Signature().add(param1);
		
		Parameter param2 = factory.createParameter();
		CollectionDataType collDT = factory.createCollectionDataType();
		collDT.setEntityName("SomeCollection");
		param2.setDatatype__Parameter(collDT);
		param2.setParameterName("param2");
		testSig3.getParameters__Signature().add(param2);
		
		CompositeDataType compDT = factory.createCompositeDataType();
		compDT.setEntityName("SomeComposite");
		
		InnerDeclaration innerDecl1 = factory.createInnerDeclaration();
		innerDecl1.setEntityName("innerParam1");
		innerDecl1.setDatatype_InnerDeclaration(primDT);
		compDT.getInnerDeclaration_CompositeDataType().add(innerDecl1);
		
		InnerDeclaration innerDecl2 = factory.createInnerDeclaration();
		innerDecl2.setEntityName("innerParam2");
		innerDecl2.setDatatype_InnerDeclaration(primDT);
		compDT.getInnerDeclaration_CompositeDataType().add(innerDecl2);
		
		collDT.setInnerDataType__CollectionDataType(compDT);		
	}*/
	
	@Test
	public void testGetByteSize(){
		String actual = BytesizeComputationForSignature.getBytesizeForSignature(testSig1, BytesizeComputationForSignature.Modifier.IN);
		Assert.assertEquals("param1.BYTESIZE + " +
				"param2.NUMBER_OF_ELEMENTS * param2.INNER.BYTESIZE + " + 
				"(param3.innerParam1.BYTESIZE + " + 
				"param3.innerParam2.BYTESIZE + " + 
				"param3.innerParam3.NUMBER_OF_ELEMENTS * param3.innerParam3.INNER.BYTESIZE + " +
				"(param3.innerParam4.innerInnerParam1.BYTESIZE))", actual);
	}		
		
	@Test
	public void testGetByteSize2(){
		String actual2 = BytesizeComputationForSignature.getBytesizeForSignature(testSig2, BytesizeComputationForSignature.Modifier.IN);
		Assert.assertEquals("param1.BYTESIZE + " +
				"param2.NUMBER_OF_ELEMENTS * param2.INNER.NUMBER_OF_ELEMENTS * param2.INNER.INNER.BYTESIZE", actual2);

	}
	
	@Test
	public void testGetByteSize3(){
		String actual = BytesizeComputationForSignature.getBytesizeForSignature(testSig3, BytesizeComputationForSignature.Modifier.IN);
		Assert.assertEquals("param1.BYTESIZE + " +
				"param2.NUMBER_OF_ELEMENTS * (param2.INNER.innerParam1.BYTESIZE + param2.INNER.innerParam2.BYTESIZE)", actual);

	}
}
