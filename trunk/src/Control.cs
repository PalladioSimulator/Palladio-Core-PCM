using System;
using Palladio.Editor.Common;
using Palladio.Editor.Common.EntityProxies;
using log4net;

namespace Palladio.Editor.Plugins.AnalyzeTest
{
	/// <summary>
	/// Zusammenfassung für AnalyzeTest.
	/// </summary>
	[PluginInfo(Name="AnalyzeTest",
		 Description="Simple test implementation of an analyze plugin.",
		 Author="Matthias Uflacker")]
	public class Control : AnalyzePluginSkeleton
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(Control));

		private Presentation.Configuration _configControl;
		private Presentation.Result _resultControl;

		private int count;
		private string resultString;

		public Control(string name, string descr, string author, string version)
			: base(name,descr,author,version)
		{
			this._configControl = new Presentation.Configuration();
			this.CanStart = false;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="host"></param>
		/// <returns></returns>
		public override bool Initialize(IAnalyzePluginHost host)
		{
			this._configControl.ServiceSelectionChanged += new EventHandler(_configControl_ServiceSelectionChanged);
			return base.Initialize (host);
		}


		/// <summary>
		/// 
		/// </summary>
		public override System.Type[] RequiredAttributeTypes
		{
			get
			{
				return new System.Type[]{typeof(Attributes.WeightAttributeType)};
			}
		}

		public override void Detach()
		{
			log.Debug("Detached");
		}

		public override System.Windows.Forms.UserControl ConfigControl
		{
			get
			{
				return this._configControl;
			}
		}

		public override System.Windows.Forms.UserControl ResultControl
		{
			get
			{
				return this._resultControl;
			}
		}

		public override void UpdateConfigControl()
		{
			this._configControl.UpdateComponents(this._host.GetComponentModel());
			SignatureProxy sig = this._configControl.GetSelectedService();
			if (sig != null)
				this.CanStart = true;
			else
				this.CanStart = false;
			this._configControl.CanStart = this.CanStart;
		}

		public override void Start()
		{
			this.count = 0;
			this.resultString = "";
			log.Debug("Starting!");
			CompositeComponentProxy model = this._host.GetComponentModel();
			this.TraverseCompositeComponent(model, this._configControl.GetSelectedService());
			log.Debug("Result: "+count);
			this._resultControl = new Presentation.Result(this.resultString, "Result: "+this.count.ToString());
		}

		private void TraverseCompositeComponent(CompositeComponentProxy component, SignatureProxy service)
		{
			this.resultString += service.Name+this.AddWeight(service)+" ";
			RoleProxy role = component.GetProvidesRoleByInterfaceID(service.Interface.ID);
			if (role != null)
			{
				try
				{
					ProvidesMappingProxy mapping = component.GetProvidesMappingByOuterRole(role);
					this.resultString += "--"+AddWeight(mapping)+"--> ";

					foreach(SignatureProxy mappedSig in mapping.InnerRole.Interface.Signatures)
					{
						if (mappedSig.ID.Equals(service.ID))
						{
							if (mapping.InnerRole.Component is BasicComponentProxy)
							{
								this.TraverseImplementation(mapping.InnerRole.Component as BasicComponentProxy, mappedSig);
							}
							else if (mapping.InnerRole.Component is CompositeComponentProxy)
							{
								this.TraverseCompositeComponent(mapping.InnerRole.Component as CompositeComponentProxy, mappedSig);
							}
						}
					}
				}
				catch(Exception e)
				{
					return;
				}
			}
		}

		private void TraverseImplementation(BasicComponentProxy component, SignatureProxy service)
		{
			this.resultString += service.Name+this.AddWeight(service)+" ";
			RoleProxy role = component.GetProvidesRoleByInterfaceID(service.Interface.ID);
			if (role != null)
			{
				try
				{
					ServiceEffectSpecificationProxy sef = component.GetServiceEffectSpecification(role.Interface.ID, service.ID);

					int indent;
					int lastLF = this.resultString.LastIndexOf("\n");
					if (lastLF < 0)
						indent = this.resultString.Length;
					else
						indent = this.resultString.Length - lastLF;

					foreach (SignatureProxy reqSig in sef.ServiceList)
					{
						this.resultString += "XXX> "+reqSig.Name+AddWeight(reqSig)+" ";
						RoleProxy reqRole = component.GetRequiresRoleByInterfaceID(reqSig.Interface.ID);
						ConnectionProxy conn = reqRole.AttachedConnection;
						if (conn != null)
						{
							this.resultString += "--"+AddWeight(conn)+"--> ";

							if (conn is RequiresMappingProxy)
							{
								RoleProxy mappedRole = ((RequiresMappingProxy)conn).OuterRole;
								foreach (SignatureProxy mappedSig in mappedRole.Interface.Signatures)
								{
									if (mappedSig.ID.Equals(reqSig.ID))
									{
										this.TraverseRequiresMapping(mappedRole.Component as CompositeComponentProxy, mappedSig);
									}
								}
							}
							else if (conn is BindingProxy)
							{
								RoleProxy bindedRole = ((BindingProxy)conn).ProvidesRole;
								if (bindedRole.Component is BasicComponentProxy)
								{
									foreach(SignatureProxy bindedSig in bindedRole.Interface.Signatures)
									{
										if (bindedSig.ID.Equals(reqSig.ID))
										{
											this.TraverseImplementation(bindedRole.Component as BasicComponentProxy, bindedSig);
										}
									}
								}
								else if (bindedRole.Component is CompositeComponentProxy)
								{
									foreach(SignatureProxy bindedSig in bindedRole.Interface.Signatures)
									{
										if (bindedSig.ID.Equals(reqSig.ID))
										{
											this.TraverseCompositeComponent(bindedRole.Component as CompositeComponentProxy, bindedSig);
										}
									}
								}
							}
						}
						this.resultString += "\n\r";
						for (int i=0;i<indent;i++) this.resultString+=" ";


					}
				}
				catch(Exception e) // no service effect specification for service
				{
						
				}
			}
		}

		private void TraverseRequiresMapping(CompositeComponentProxy component, SignatureProxy service)
		{
			this.resultString += service.Name+this.AddWeight(service)+" ";
			RoleProxy role = component.GetRequiresRoleByInterfaceID(service.Interface.ID);
			ConnectionProxy conn = role.AttachedConnection;
			if (conn != null)
			{
				this.resultString += "--"+AddWeight(conn)+"--> ";

				if (conn is RequiresMappingProxy)
				{
					RoleProxy mappedRole = ((RequiresMappingProxy)conn).OuterRole;
					foreach (SignatureProxy mappedSig in mappedRole.Interface.Signatures)
					{
						if (mappedSig.ID.Equals(service.ID))
						{
							this.TraverseRequiresMapping(mappedRole.Component as CompositeComponentProxy, mappedSig);
						}
					}
				}
				else if (conn is BindingProxy)
				{
					RoleProxy bindedRole = ((BindingProxy)conn).ProvidesRole;
					if (bindedRole.Component is BasicComponentProxy)
					{
						foreach(SignatureProxy bindedSig in bindedRole.Interface.Signatures)
						{
							if (bindedSig.ID.Equals(service.ID))
							{
								this.TraverseImplementation(bindedRole.Component as BasicComponentProxy, bindedSig);
							}
						}
					}
					else if (bindedRole.Component is CompositeComponentProxy)
					{
						foreach(SignatureProxy bindedSig in bindedRole.Interface.Signatures)
						{
							if (bindedSig.ID.Equals(service.ID))
							{
								this.TraverseCompositeComponent(bindedRole.Component as CompositeComponentProxy, bindedSig);
							}
						}
					}
				}
			}
		}

		private void _configControl_ServiceSelectionChanged(object sender, System.EventArgs e)
		{
			SignatureProxy sig = this._configControl.GetSelectedService();
			if (sig != null)
				this.CanStart = true;
			else
				this.CanStart = false;
			this._configControl.CanStart = this.CanStart;
		}

		private string AddWeight(EntityProxy entity)
		{
			Attributes.WeightAttribute attr = entity.Attributes[typeof(Attributes.WeightAttributeType)] as Attributes.WeightAttribute;
			if (attr != null)
			{
				this.count += attr.Value;
				return "["+attr.Value.ToString()+"]";
			}
			return "[-]";
		}
	}
}
