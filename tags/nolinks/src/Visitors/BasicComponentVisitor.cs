using System;
using System.Collections;
using Palladio.Utils.Collections;
using System.Reflection;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel.Visitors
{
	/// <summary>
	/// </summary>
	internal class BasicComponentVisitor : ReflectionBasedVisitor.ReflectionBasedVisitor
	{
		ICompositeComponent componsiteComponent;
		ArrayList visitedBasicComponents;
		ArrayList visitedCompositeComponents;


		public IBasicComponent[] VisitedComponents
		{
			get { return (IBasicComponent[]) visitedBasicComponents.ToArray(typeof(IBasicComponent)); }
		}

		public override void VisitObject(object o)
		{
		}

		public void VisitISignatureList(ISignatureList aSigList)
		{
			if (componsiteComponent.HasProvidesInterface(aSigList.RoleID))
			{
				Visit(componsiteComponent.GetProvidesMappingByOuter(aSigList.RoleID).InnerInterface.Component);
			}
		}

		public void VisitIBasicComponent(IBasicComponent aComponent)
		{
			if ( !visitedBasicComponents.Contains(aComponent) )
			{
				visitedBasicComponents.Add(aComponent);
				IBinding[] bindings = componsiteComponent.GetRequiresBindings(aComponent);
				foreach( IBinding b in bindings)
				{
					Visit(b.ProvidesInterface.Component);
				}
			}
		}

		public void VisitICompositeComponent(ICompositeComponent aComponent)
		{
			if (!visitedCompositeComponents.Contains(aComponent))
			{
				visitedCompositeComponents.Add(aComponent);
				BasicComponentVisitor subVisitor = new BasicComponentVisitor(aComponent);
				subVisitor.Start();
				visitedBasicComponents.AddRange(subVisitor.VisitedComponents);
			}
		}

		public void Start()
		{
			foreach(ISignatureList sigList in componsiteComponent.ProvidesInterfaces)
			{
				Visit(sigList);
			}
		}

		public BasicComponentVisitor( ICompositeComponent c ) : base (false)
		{
			componsiteComponent = c;
			visitedBasicComponents = new ArrayList();
			visitedCompositeComponents = new ArrayList();
		}

	}
}
