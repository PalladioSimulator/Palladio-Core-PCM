/*
 * $Id$
 * 
 * $Log$
 * Revision 1.6  2004/10/25 07:07:21  sliver
 * implementation of
 * - functions discrete, including convolution
 * - path segmentation of FSMs
 * - prediction of time consuption using density functions
 *
 * Revision 1.5  2004/09/23 00:44:14  sliver
 * - major refactorings
 * - changed TypedCollections to CodeSmith generated files
 * - introduced MakrovModel
 * - added Transition-, Potential-, VisitProbability-, and VisitsOnPath- matrix types
 *
 * Revision 1.4  2004/09/09 04:07:52  sliver
 * code refactored
 * vs.net project files created
 *
 * Revision 1.3  2004/07/19 04:37:48  sliver
 * extracted attributes
 *
 * Revision 1.2  2004/07/13 02:14:51  sliver
 * Added comments
 *
 * Revision 1.1  2004/07/12 06:33:04  sliver
 * Initial checkin
 *
 * Revision 1.2  2004/07/06 00:30:44  sliver
 * + added Markov Probability for transitions
 * + CCVisitor propagates the reliability now
 * 
 */

using System.Collections;
using log4net;
using Palladio.ComponentModel;
using Palladio.Identifier;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.Math;

namespace Palladio.Reliability.Model
{
	/// <summary>
	/// Description of CompositeComponentVisitor.	
	/// </summary>
	public class CCVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		public TreeNode ReliabilityTree
		{
			get { return tree; }
		}

		public override void VisitObject(object o)
		{
			log.Debug("Unkown object type: " + o.GetType());
		}

		public void VisitIMapping(IMapping m)
		{
			if (m.IsProvidesMapping)
			{
				Visit(m.InnerRole.Component);
				TreeNode innerNode = tree.Children[m.InnerRole.ComponentID];
				foreach (ISignature s in m.OuterRole.Role.Interface.SignatureList)
				{
					IExternalSignature innerSig = ComponentFactory.CreateExternalSignature(m.InnerRole.RoleID, s);
					IExternalSignature outerSig = ComponentFactory.CreateExternalSignature(m.OuterRole.RoleID, s);

					// forward reliability information
					// calculate influences of the mapping here!!
					tree.ProvidesReliabilities.Add(outerSig, innerNode.ProvidesReliabilities[innerSig]);
				}
			}
			else // m.IsRequiresMapping
			{
				TreeNode innerNode = tree.Children[m.InnerRole.ComponentID];
				foreach (ISignature s in m.OuterRole.Role.Interface.SignatureList)
				{
					IExternalSignature innerSig = ComponentFactory.CreateExternalSignature(m.InnerRole.RoleID, s);
					IExternalSignature outerSig = ComponentFactory.CreateExternalSignature(m.OuterRole.RoleID, s);

					// forward reliability information
					// calculate influences of the mapping here!!
					innerNode.RequiresReliabilities.Add(innerSig, tree.RequiresReliabilities[outerSig]);
				}
			}
		}

		public void VisitIBinding(IBinding b)
		{
			Visit(b.ProvidingRole.Component);
			TreeNode reqNode = tree.Children[b.RequiringRole.ComponentID];
			TreeNode provNode = tree.Children[b.ProvidingRole.ComponentID];

			foreach (ISignature s in b.RequiringRole.Role.Interface.SignatureList)
			{
				IExternalSignature reqSig = ComponentFactory.CreateExternalSignature(b.RequiringRole.RoleID, s);
				IExternalSignature provSig = ComponentFactory.CreateExternalSignature(b.ProvidingRole.RoleID, s);

				// forward reliability information
				// calculate influences of the mapping here!!
				reqNode.RequiresReliabilities.Add(reqSig, provNode.ProvidesReliabilities[provSig]);
			}
		}

		public void VisitICompositeComponent(ICompositeComponent aCC)
		{
			if (!visited.Contains(aCC.ID))
			{
				TreeNode ccNode = new TreeNode(aCC.ID);
				tree.AddChild(ccNode);
				visited.Add(aCC.ID);

				foreach (IConnection con in cc.GetRequiresConnections(aCC.ID))
					Visit(con);

				CCVisitor v = new CCVisitor(aCC, ccNode);
			}
		}

		public void VisitIBasicComponent(IBasicComponent bc)
		{
			if (!visited.Contains(bc.ID))
			{
				TreeNode bcNode = new TreeNode(bc.ID);
				tree.AddChild(bcNode);
				visited.Add(bc.ID);

				foreach (IConnection con in cc.GetRequiresConnections(bc.ID))
					Visit(con);

				foreach (IIdentifier id in bc.ProvidedRoles)
				{
					IInterfaceModel im = bc.GetProvidesInterface(id);
					foreach (ISignature sig in im.SignatureList)
					{
						IExternalSignature provSig = ComponentFactory.CreateExternalSignature(id, sig);
						ReliabilityAttribute srAttribute = sig.Attributes[ReliabilityAttribute.AttributeType] as ReliabilityAttribute;
						if (srAttribute != null)
						{
							bcNode.ProvidesReliabilities[ provSig ] = srAttribute.Reliability;
						}
						else
						{
							IServiceEffectSpecification se = bc.GetServiceEffectSpecification(provSig);
							IFSMServiceEffect fsmSe = se.GetAuxiliarySpecification(typeof (IFSMServiceEffect)) as IFSMServiceEffect;

							bcNode.ProvidesReliabilities[ provSig ] = new ServiceReliability(new MarkovModel(fsmSe.FSM), bcNode.RequiresReliabilities);
						}
					}
				}
			}
		}

		public CCVisitor(ICompositeComponent cc) : this(cc, new TreeNode(cc.ID))
		{
		}

		public CCVisitor(ICompositeComponent cc, TreeNode ccNode) : base(false)
		{
			this.cc = cc;
			this.visited = new ArrayList();
			this.tree = ccNode;
			foreach (IIdentifier i in cc.ProvidedRoles)
			{
				Visit(cc.GetProvidesMappingByOuter(i));
			}
		}

		private ICompositeComponent cc;
		private ArrayList visited;
		private TreeNode tree;

		private static readonly ILog log = LogManager.GetLogger(typeof (CCVisitor));
	}
}