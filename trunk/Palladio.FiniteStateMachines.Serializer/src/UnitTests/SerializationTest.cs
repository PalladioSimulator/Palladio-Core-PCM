#if TEST

using System;
using System.IO;
using System.Text;
using System.Xml;
using NUnit.Framework;
using Palladio.FiniteStateMachines.Serializer;
using Palladio.FiniteStateMachines.Serializer.DefaultImplementation;
using Palladio.FiniteStateMachines.Serializer.Interfaces;
using Palladio.FiniteStateMachines.UnitTests.TestClasses;

namespace Palladio.FiniteStateMachines.UnitTests
{
	/// <summary>
	/// Test of the FSM serialization.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.6  2005/08/25 18:43:47  kelsaka
	/// - support for default input serialization.
	///
	/// Revision 1.5  2005/08/24 09:25:40  kelsaka
	/// - created serializer for the default input
	/// - added methods for the IInputSerializerPlugin
	///
	/// Revision 1.4  2005/08/24 08:48:19  kelsaka
	/// - fixed error in test suite
	/// - added pre build event to copy XSD to bin directory
	///
	/// Revision 1.3  2005/08/24 08:38:22  kelsaka
	/// - added TypeID for IInputs
	///
	/// Revision 1.2  2005/08/22 16:39:02  kelsaka
	/// - load: validation against xsd added
	///
	/// Revision 1.1  2005/08/21 18:07:42  kelsaka
	/// - added further tests
	///
	/// Revision 1.3  2005/08/21 18:00:45  kelsaka
	/// - added further tests
	///
	/// Revision 1.2  2005/08/21 10:04:44  kelsaka
	/// - REadded test cases
	///
	/// Revision 1.1  2005/08/15 09:52:56  kelsaka
	/// *** empty log message ***
	///
	/// </code>
	/// </remarks>
	[TestFixture]
	public class SerializationTest
	{
		IFiniteStateMachine testFSM;

		/// <summary>
		/// </summary>
		[SetUp]
		public void Init() 
		{
			this.testFSM = BuildExampleFSM();
		}

		[Test]
		public void XMLWriterSaveTest()
		{
			IFiniteStateMachine fsm = BuildExampleFSM();
			IXMLSerializer serializer = new XMLSerializer();
			XmlTextWriter writer = new XmlTextWriter(".\\testFSM.xml", Encoding.UTF8);
			writer.Formatting = Formatting.Indented;
			writer.Indentation= 4;
			writer.Namespaces = true;
			writer.WriteStartDocument();
		
			serializer.Save(writer, fsm);

			writer.Close();
		}

		[Test]
		public void XMLFilenameSaveTest()
		{
			IFiniteStateMachine fsm = BuildExampleFSM();
			IXMLSerializer serializer = new XMLSerializer();
			serializer.Save(new FileInfo(".\\testFSM.xml"), fsm);
		}

		[Test]
		[ExpectedException(typeof(AttributeNotSupportedException))]
		public void AttributeNotSerializeable()
		{
			IFiniteStateMachine fsm = BuildExampleFSMAttributes();;
			IXMLSerializer serializer = new XMLSerializer();
			serializer.Save(new FileInfo(".\\testFSM.xml"), fsm);
		}

		[Test]
		public void AttributeSerialize()
		{
			IFiniteStateMachine fsm = BuildExampleFSMAttributes();
			IXMLSerializer serializer = new XMLSerializer();
			serializer.AddAttributeSerializerPlugin(new Test1AttributeSerializer(), new Test1AttributeType());
			serializer.AddAttributeSerializerPlugin(new Test1AttributeSerializer(), new Test1AttributeType());
			serializer.Save(new FileInfo(".\\testFSM.xml"), fsm);
		}

		[Test]
		public void AddMultipleAttributeSerializersForSameAttributeType()
		{
			IXMLSerializer serializer = new XMLSerializer();
			serializer.AddAttributeSerializerPlugin(new Test1AttributeSerializer(), new Test1AttributeType());
			serializer.AddAttributeSerializerPlugin(new Test1AttributeSerializer(), new Test1AttributeType());
		}

		[Test]
		[ExpectedException(typeof(AttributeNotSupportedException))]
		public void LoadFromFileNoAttributesPluginsLoaded()
		{
			IXMLSerializer serializer = new XMLSerializer();
			IFiniteStateMachine fsm = BuildExampleFSMAttributes();
			serializer.Save(new FileInfo(".\\testFSM.xml"), fsm);
			serializer.Load(new FileInfo(".\\testFSM.xml"));
		}

		[Test]
		public void LoadFromFileWithAttributes()
		{
			IFiniteStateMachine fsm = BuildExampleFSMAttributes();
			IXMLSerializer serializer = new XMLSerializer();
			serializer.AddAttributeSerializerPlugin(new Test1AttributeSerializer(), new Test1AttributeType());
			serializer.Save(new FileInfo(".\\testFSM.xml"), fsm);

			serializer.AddAttributeSerializerPlugin(new Test1AttributeSerializer(), new Test1AttributeType());
			fsm = serializer.Load(new FileInfo(".\\testFSM.xml"));
			Assert.IsTrue(fsm.HasFinalStates);
			Assert.IsTrue(fsm.HasStartState);
			Assert.IsTrue(fsm.States.Length.Equals(3));
			Assert.IsTrue(fsm.InputAlphabet.Length.Equals(4));
			Assert.IsTrue(fsm.Transitions.Length.Equals(4));
			Assert.IsTrue(fsm.StartState.ID.Equals("1"));
			
			IEditableFiniteStateMachine efsm = FSMFactory.GetEditableFSM(fsm);
			//TODO: test for attributes
			//Assert.IsTrue(((Test1Attribute)efsm.GetState("2").Attributes[new Test1AttributeType()]).TestProperty.Equals(new Test1Attribute().TestProperty));
			//Console.Out.WriteLine ("***" + efsm.GetState("2").Attributes.AttributeTypes.Count);
			//Console.Out.WriteLine ("***" + efsm.GetState("2").Attributes[new Test1AttributeType()]);
		}

		[Test]
		public void LoadFromXmlDocument()
		{
			IFiniteStateMachine fsm = BuildExampleFSM();
			IXMLSerializer serializer = new XMLSerializer();
			serializer.Save(new FileInfo(".\\testFSM.xml"), fsm);
			
			try 
			{

				XmlTextReader xmlTextReader = new XmlTextReader(".\\testFSM.xml");
				XmlValidatingReader validatingReader = new XmlValidatingReader(xmlTextReader);
				XmlDocument xmlDoc = new XmlDocument();	
				xmlDoc.Load(validatingReader);
				validatingReader.Close();

				serializer.Load(xmlDoc);
			}
			catch (Exception e)
			{
				Console.Out.WriteLine ("*** " + e.Message + e.StackTrace);
			}

			Assert.IsTrue(fsm.HasFinalStates);
			Assert.IsTrue(fsm.HasStartState);
			Assert.IsTrue(fsm.States.Length.Equals(3));
			Assert.IsTrue(fsm.InputAlphabet.Length.Equals(4));
			Assert.IsTrue(fsm.Transitions.Length.Equals(4));
			Assert.IsTrue(fsm.StartState.ID.Equals("1"));
		}

		private IFiniteStateMachine BuildExampleFSM()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash states = FSMFactory.CreateStatesFromList("1","2","3");
			InputSymbolHash inputs = FSMFactory.CreateInputFromList("a","b","c","eps");
			fsm.AddStates(states.StoredStates);
			fsm.AddInputSymbols(inputs.StoredInputs);
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["1"],inputs["a"],states["1"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["1"],inputs["b"],states["2"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["2"],inputs["c"],states["3"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["1"]));
			states = FSMFactory.CreateStatesFromList("1","2","3");
			fsm.FinalStates = new IState[] { states["1"], states["3"] };
			fsm.StartState = states["1"];
			return fsm;
		}

		private IFiniteStateMachine BuildExampleFSMAttributes()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			StateHash states = FSMFactory.CreateStatesFromList("1","2","3");
			InputSymbolHash inputs = FSMFactory.CreateInputFromList("a","b","c","eps");
			
			states.StoredStates[0].Attributes.Add(new Test1AttributeType(), new Test1Attribute());
			states.StoredStates[1].Attributes.Add(new Test1AttributeType(), new Test1Attribute());

			fsm.AddStates(states.StoredStates);
			fsm.AddInputSymbols(inputs.StoredInputs);

			ITransition t1 = FSMFactory.CreateDefaultTransition(states["1"],inputs["a"],states["1"]);
			t1.Attributes.Add(new Test1AttributeType(), new Test1Attribute());
			fsm.AddTransitions (t1);

			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["1"],inputs["b"],states["2"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["2"],inputs["c"],states["3"]));
			fsm.AddTransitions (FSMFactory.CreateDefaultTransition(states["3"],inputs["eps"],states["1"]));
			states = FSMFactory.CreateStatesFromList("1","2","3");
			fsm.FinalStates = new IState[] { states["1"], states["3"] };
			fsm.StartState = states["1"];
			return fsm;
		}
	}
}
#endif