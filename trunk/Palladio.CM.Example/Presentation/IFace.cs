using System;
using System.Collections;
using Palladio.ComponentModel;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.CM.Example.Presentation
{
	/// <summary>
	/// This is the class for all visual representations of the componentmodels interfaces in the example.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/12 17:36:24  joemal
	/// implement the creation of a component model
	///
	/// Revision 1.1  2005/04/08 10:54:33  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class IFace : AbstractEntity
	{
		#region data

		//holds the signatures
		private Hashtable signatures = new Hashtable();

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new visual representation of an interface in the example.
		/// </summary>
		/// <param name="iface">the model of the interface</param>
		/// <param name="modelEnvironment">the model</param>
		public IFace(IInterface iface, ComponentModelEnvironment modelEnvironment) : base(iface, modelEnvironment)
		{
			Init();
		}

		#endregion

		#region private methods

		//does some intitial work
		private void Init()
		{
			InterfaceEvents events = modelEnvironment.EventInterface.GetInterfaceEvents(Model.InterfaceID);
			events.ProtocolAddedEvent += new ProtocolBuildEventHandler(events_ProtocolAddedEvent);
			events.ProtocolRemovedEvent += new ProtocolBuildEventHandler(events_ProtocolRemovedEvent);
			events.SignatureAddedEvent += new SignatureBuildEventHandler(events_SignatureAddedEvent);
			events.SignatureRemovedEvent += new SignatureBuildEventHandler(events_SignatureRemovedEvent);
		}

		//called when a protocol has been added to the interface
		private void events_ProtocolAddedEvent(object sender, ProtocolBuildEventArgs args)
		{
			Console.WriteLine("Protocol has been added to the Interface "+Model.Name+".");
		}

		//called when a protocol has been removed from the interface
		private void events_ProtocolRemovedEvent(object sender, ProtocolBuildEventArgs args)
		{
			Console.WriteLine("Protocol has been removed from the Interface "+Model.Name+".");
		}

		//called when a signature has been added to the interface
		private void events_SignatureAddedEvent(object sender, SignatureBuildEventArgs args)
		{
			Signature signature = new Signature(args.Signature,this.modelEnvironment);
			signatures.Add(args.Signature.ID,signature);
			Console.WriteLine("Signature "+args.Signature.Name+" added to the interface "+this.Model.Name+".");
			signature.Paint();
		}

		//called when a signature has been removed from the interface
		private void events_SignatureRemovedEvent(object sender, SignatureBuildEventArgs args)
		{
			if (!signatures.ContainsKey(args.Signature.ID)) return;
			signatures.Remove(args.Signature.ID);
			Console.WriteLine("Remove Signature "+args.Signature.Name+" from Interface "+Model.Name+".");
			Console.WriteLine("Repaint interface "+Model.Name+".");
			this.Paint();
		}

		#endregion

		#region public methods

		/// <summary>
		/// called to paint the visual representation of an entity and its childs
		/// </summary>
		public override void Paint()
		{
			Console.WriteLine("Interface "+this.Model.Name+" painted.");

			Console.WriteLine("Paint signatues of the interface: ");
			foreach(DictionaryEntry entry in signatures)
				((AbstractEntity)entry.Value).Paint();
            Console.WriteLine("Signatures painted.");
		}

		#endregion

		#region properties

		/// <summary>
		/// called to return the model of the interface
		/// </summary>
		public IInterface Model
		{
			get
			{
				return (IInterface) this.entity;
			}
		}

		#endregion
	}
}
