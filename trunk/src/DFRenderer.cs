using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Windows.Forms;
using Palladio.FiniteStateMachines;
using Palladio.Reliability.Attributes;
using Palladio.Reliability.ExecutionTime;
using Palladio.Reliability.Functions;
using Palladio.Reliability.Functions.Discrete;
using Palladio.Reliability.Paths;
using Palladio.Reliability.Tests;
using Palladio.Reliability.TypedCollections;

namespace Palladio.Reliability.Visualisation
{
	/// <summary>
	/// Zusammenfassung für Form1.
	/// </summary>
	public class DFRenderer : Form
	{
		private Label topLabel;
		private Panel renderPanel;
		private Button runButton;

		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private Container components = null;

		private Button calcButton;
		private Button expButton;
		private Button clearButton;

		private FunctionRenderer renderer;
		private Button testButton;
		private Button trellisButton;
		private System.Windows.Forms.Button bruteForceButton;
		private IFiniteStateMachine fsm;

		public DFRenderer()
		{
			InitializeComponent();
			fsm = TestBuilder.CreateTestMarkovModel3();
			renderer = new FunctionRenderer(renderPanel.CreateGraphics());
			renderer.Right = renderPanel.Size.Width;
			renderer.Bottom = renderPanel.Size.Height;
			renderer.XMax = 25;
			renderer.Accuracy = 0.001f;
		}

		/// <summary>
		/// Die verwendeten Ressourcen bereinigen.
		/// </summary>
		protected override void Dispose(bool disposing)
		{
			if (disposing)
			{
				if (components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose(disposing);
		}

		#region Vom Windows Form-Designer generierter Code

		/// <summary>
		/// Erforderliche Methode für die Designerunterstützung. 
		/// Der Inhalt der Methode darf nicht mit dem Code-Editor geändert werden.
		/// </summary>
		private void InitializeComponent()
		{
			this.renderPanel = new System.Windows.Forms.Panel();
			this.topLabel = new System.Windows.Forms.Label();
			this.runButton = new System.Windows.Forms.Button();
			this.calcButton = new System.Windows.Forms.Button();
			this.expButton = new System.Windows.Forms.Button();
			this.clearButton = new System.Windows.Forms.Button();
			this.testButton = new System.Windows.Forms.Button();
			this.trellisButton = new System.Windows.Forms.Button();
			this.bruteForceButton = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// renderPanel
			// 
			this.renderPanel.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.renderPanel.BackColor = System.Drawing.SystemColors.ControlLightLight;
			this.renderPanel.Location = new System.Drawing.Point(8, 40);
			this.renderPanel.Name = "renderPanel";
			this.renderPanel.Size = new System.Drawing.Size(952, 640);
			this.renderPanel.TabIndex = 0;
			this.renderPanel.Paint += new System.Windows.Forms.PaintEventHandler(this.renderPanel_Paint);
			// 
			// topLabel
			// 
			this.topLabel.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.topLabel.BackColor = System.Drawing.SystemColors.ControlDark;
			this.topLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.topLabel.Location = new System.Drawing.Point(8, 8);
			this.topLabel.Name = "topLabel";
			this.topLabel.Size = new System.Drawing.Size(952, 23);
			this.topLabel.TabIndex = 1;
			this.topLabel.Text = "Density Function";
			this.topLabel.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// runButton
			// 
			this.runButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.runButton.Location = new System.Drawing.Point(864, 696);
			this.runButton.Name = "runButton";
			this.runButton.Size = new System.Drawing.Size(96, 32);
			this.runButton.TabIndex = 2;
			this.runButton.Text = "Run";
			this.runButton.Click += new System.EventHandler(this.runButton_Click);
			// 
			// calcButton
			// 
			this.calcButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.calcButton.Location = new System.Drawing.Point(760, 696);
			this.calcButton.Name = "calcButton";
			this.calcButton.Size = new System.Drawing.Size(96, 32);
			this.calcButton.TabIndex = 3;
			this.calcButton.Text = "Calculate";
			this.calcButton.Click += new System.EventHandler(this.calcButton_Click);
			// 
			// expButton
			// 
			this.expButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.expButton.Location = new System.Drawing.Point(640, 696);
			this.expButton.Name = "expButton";
			this.expButton.Size = new System.Drawing.Size(112, 32);
			this.expButton.TabIndex = 4;
			this.expButton.Text = "Exp Distribution";
			this.expButton.Click += new System.EventHandler(this.expButton_Click);
			// 
			// clearButton
			// 
			this.clearButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
			this.clearButton.Location = new System.Drawing.Point(16, 696);
			this.clearButton.Name = "clearButton";
			this.clearButton.Size = new System.Drawing.Size(96, 32);
			this.clearButton.TabIndex = 5;
			this.clearButton.Text = "Clear";
			this.clearButton.Click += new System.EventHandler(this.clearButton_Click);
			// 
			// testButton
			// 
			this.testButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.testButton.Location = new System.Drawing.Point(536, 696);
			this.testButton.Name = "testButton";
			this.testButton.Size = new System.Drawing.Size(96, 32);
			this.testButton.TabIndex = 6;
			this.testButton.Text = "Test";
			this.testButton.Click += new System.EventHandler(this.testButton_Click);
			// 
			// trellisButton
			// 
			this.trellisButton.Location = new System.Drawing.Point(424, 696);
			this.trellisButton.Name = "trellisButton";
			this.trellisButton.Size = new System.Drawing.Size(104, 32);
			this.trellisButton.TabIndex = 7;
			this.trellisButton.Text = "Trellis";
			this.trellisButton.Click += new System.EventHandler(this.trellisButton_Click);
			// 
			// bruteForceButton
			// 
			this.bruteForceButton.Location = new System.Drawing.Point(320, 696);
			this.bruteForceButton.Name = "bruteForceButton";
			this.bruteForceButton.Size = new System.Drawing.Size(96, 32);
			this.bruteForceButton.TabIndex = 8;
			this.bruteForceButton.Text = "Brute Force";
			this.bruteForceButton.Click += new System.EventHandler(this.bruteForceButton_Click);
			// 
			// DFRenderer
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(6, 15);
			this.ClientSize = new System.Drawing.Size(968, 736);
			this.Controls.Add(this.bruteForceButton);
			this.Controls.Add(this.trellisButton);
			this.Controls.Add(this.testButton);
			this.Controls.Add(this.clearButton);
			this.Controls.Add(this.expButton);
			this.Controls.Add(this.calcButton);
			this.Controls.Add(this.runButton);
			this.Controls.Add(this.topLabel);
			this.Controls.Add(this.renderPanel);
			this.Name = "DFRenderer";
			this.Text = "DFRenderer";
			this.Resize += new System.EventHandler(this.DFRenderer_Resize);
			this.Load += new System.EventHandler(this.DFRenderer_Load);
			this.ResumeLayout(false);

		}

		#endregion

		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		private static void Main()
		{
			Application.Run(new DFRenderer());
		}


		private struct StateInfo
		{
			private IState state;
			private IFunction densityFunction;
			private double p;

			public IState State
			{
				get { return state; }
				set { state = value; }
			}

			public IFunction DensityFunction
			{
				get { return densityFunction; }
				set { densityFunction = value; }
			}

			public double P
			{
				get { return p; }
				set { p = value; }
			}

			public StateInfo(IState state, IFunction densityFunction, double p)
			{
				this.state = state;
				this.densityFunction = densityFunction;
				this.p = p;
			}
		}


		private void runButton_Click(object sender, EventArgs e)
		{
			Stack currentStates = new Stack();
			StateInfo si = new StateInfo(fsm.StartState, TimeAttribute.GetAttribute(fsm.StartState).DensityFunction, 1.0);
			currentStates.Push(si);
			double pTotal = 0.0;
			long numPaths = 0;
			long level = 0;
			double pConfidence = 0.95;
			IFunction dfTotal = null;

			while (pTotal <= pConfidence)
			{
				Stack nextStates = new Stack();
				foreach (StateInfo sInfo in currentStates)
				{
					foreach (ITransition transition in fsm.GetOutgoingTransitions(sInfo.State))
					{
						StateInfo nsInfo = new StateInfo();
						nsInfo.State = transition.DestinationState;
						nsInfo.P = sInfo.P*MarkovAttribute.GetAttribute(transition).Probability.Expression.Calculate();
						nsInfo.DensityFunction = sInfo.DensityFunction.Convolution(TimeAttribute.GetAttribute(transition.DestinationState).DensityFunction);

						if (fsm.IsFinalState(nsInfo.State))
						{
							pTotal += nsInfo.P;
							nsInfo.DensityFunction.Scale(nsInfo.P);
							if (dfTotal == null)
								dfTotal = nsInfo.DensityFunction;
							else
								dfTotal = dfTotal.Sum(nsInfo.DensityFunction);

							renderer.AddFunction(dfTotal, Pens.Red, "Brute Force");
							renderer.Draw();

							Console.WriteLine(++numPaths + "\t" + pTotal + "\tProb:\t" + nsInfo.P);
							if (pTotal > pConfidence)
								break;
						}
						else
						{
							nextStates.Push(nsInfo);
						}
					}
					if (pTotal > pConfidence)
						break;
				}
				currentStates = nextStates;
				Console.WriteLine("Level:\t" + ++level + "\tStackSize:\t" + currentStates.Count);
			}
		}


		private void calcButton_Click(object sender, EventArgs e)
		{
			IFsmElement time = TimeOperations.FSMExecutionTime(fsm);
			IFunction g = time.TimeDensityFunction;
			renderer.AddFunction(g, Pens.Blue, "Calculated");
			renderer.Draw();
		}

		private void renderPanel_Paint(object sender, PaintEventArgs e)
		{
			renderer.Draw();
		}

		private void DFRenderer_Resize(object sender, EventArgs e)
		{
			renderer.Graphics = renderPanel.CreateGraphics();
			renderer.Right = renderPanel.Size.Width;
			renderer.Bottom = renderPanel.Size.Height;
			renderer.Draw();
		}

		private void expButton_Click(object sender, EventArgs e)
		{
			IFunctionFactory ffactory = new DiscreteFactory(0.01, 0, 20);
			IFunction f = ffactory.CreateExponentialDistribution(1.0);
			//IFunction F = f.Integral();
//			IFunction g = f.Convolution(f);
//			IFunction G = g.Integral();

			renderer.AddFunction(f, Pens.Green, "Exp Distribution");
//			renderer.AddFunction(F, Pens.Green, "Integral Exp");
//			renderer.AddFunction(g, Pens.Blue, "Convolution");
//			renderer.AddFunction(G, Pens.Blue, "Integral Conv");
			renderer.Draw();
		}

		private void clearButton_Click(object sender, EventArgs e)
		{
			renderer.RemoveAll();
			renderer.Draw();
		}

		private void DFRenderer_Load(object sender, EventArgs e)
		{
		}

		private void testButton_Click(object sender, EventArgs e)
		{
			IFSMPaths paths = new FSMPaths(fsm);
			IPathElement fp = TimeOperations.PathExecutionTime(paths.FinalPaths[0]);
			IPathElement[] cp = new IPathElement[2];
			cp[0] = TimeOperations.PathExecutionTime(paths.CyclicPaths[0]);
			cp[1] = TimeOperations.PathExecutionTime(paths.CyclicPaths[1]);
			IExecutionElement innerCycle;

			if (fp.Path.Overlaps(cp[0].Path))
			{
				ICyclicElement cycle = TimeOperations.Cycle(cp[1]);
				innerCycle = TimeOperations.Sum(cp[0], TimeOperations.Sequence(cp[0], cycle, cycle.Probability)); // / cycle.Probability ));
				innerCycle.TimeDensityFunction.Scale(cp[0].Probability);
			}
			else
			{
				ICyclicElement cycle = TimeOperations.Cycle(cp[0]);
				innerCycle = TimeOperations.Sum(cp[1], TimeOperations.Sequence(cp[1], cycle, 1)); // / cycle.Probability ));
				innerCycle.TimeDensityFunction.Scale(cp[1].Probability);
			}

			renderer.AddFunction(innerCycle.TimeDensityFunction, Pens.Black, "inner");

			IExecutionElement total = TimeOperations.Sum(fp, TimeOperations.Sequence(fp, TimeOperations.Cycle(innerCycle), 1.0));
			total.TimeDensityFunction.Scale(fp.Probability);


			renderer.AddFunction(total.TimeDensityFunction, Pens.Blue, "Cycles on cycles");
			renderer.Draw();
		}

		private void trellisButton_Click(object sender, EventArgs e)
		{
			double pTotal = 0.0;
			long numPaths = 0;
			long level = 0;
			double pConfidence = 0.99;
			IFunction dfTotal = null;

			StateTimeTable currentTimes = new StateTimeTable();
			currentTimes[fsm.StartState] = TimeOperations.StateExecutionTime(fsm.StartState);

			while (pTotal <= pConfidence)
			{
				StateTimeTable nextTimes = new StateTimeTable();
				foreach (IState state in currentTimes.Keys)
				{
					if (fsm.IsFinalState(state))
					{
						pTotal += currentTimes[state].Probability;
						if (dfTotal == null)
							dfTotal = currentTimes[state].TimeDensityFunction;
						else
							dfTotal = dfTotal.Sum(currentTimes[state].TimeDensityFunction);

						renderer.AddFunction(dfTotal, Pens.Blue, "Trellis");
						renderer.Draw();

						Console.WriteLine(++numPaths + "\t" + pTotal + "\tProb:\t" + currentTimes[state].Probability);
					}
					else
					{
						foreach (ITransition transition in fsm.GetOutgoingTransitions(state))
						{
							IState destState = transition.DestinationState;
							double probability = MarkovAttribute.GetAttribute(transition).Probability.Expression.Calculate();

							if (nextTimes[destState] == null)
								nextTimes[destState] = currentTimes[state].Scale(probability);
							else
								nextTimes[destState] = TimeOperations.Sum(nextTimes[destState], currentTimes[state].Scale(probability) );
						}
					}
				}

				foreach (IState state in fsm.States)
				{
					if (nextTimes[state] != null)
					{
						IExecutionElement stateTime = TimeOperations.StateExecutionTime(state);
						nextTimes[state] = TimeOperations.Sequence(nextTimes[state],stateTime,1.0);
					}
				}
				currentTimes = nextTimes;
				Console.WriteLine("Level:\t" + ++level + "\tStackSize:\t" + currentTimes.Count);
			}
			IFunction F = dfTotal.Integral();
			renderer.AddFunction(F, Pens.Blue, "Integral");
			renderer.Draw();
		}

		struct StateTime
		{
			public IState State;
			public IExecutionElement Time;

			public StateTime(IState state, IExecutionElement time)
			{
				State = state;
				Time = time;
			}
		}

		private void bruteForceButton_Click(object sender, System.EventArgs e)
		{
			Stack currentStates = new Stack();
			StateTime st = new StateTime(fsm.StartState, TimeOperations.StateExecutionTime(fsm.StartState));
			currentStates.Push(st);
			double pTotal = 0.0;
			long numPaths = 0;
			long level = 0;
			double pConfidence = 0.95;
			IFunction dfTotal = null;

			while (pTotal <= pConfidence)
			{
				Stack nextStates = new Stack();
				foreach (StateTime time in currentStates)
				{
					foreach (ITransition transition in fsm.GetOutgoingTransitions(time.State))
					{
						StateTime nextTime = new StateTime(
							transition.DestinationState,
							TimeOperations.Sequence(
								time.Time, 
								TimeOperations.StateExecutionTime(transition.DestinationState), 
								MarkovAttribute.GetAttribute(transition).Probability.Expression.Calculate()
							)
						);
							
						if (fsm.IsFinalState(nextTime.State))
						{
							pTotal += nextTime.Time.Probability;
							nextTime.Time.TimeDensityFunction.Scale(nextTime.Time.Probability);
							if (dfTotal == null)
								dfTotal = nextTime.Time.TimeDensityFunction;
							else
								dfTotal = dfTotal.Sum(nextTime.Time.TimeDensityFunction);

							renderer.AddFunction(dfTotal, Pens.Green, "Brute Force, new");
							renderer.Draw();

							Console.WriteLine(++numPaths + "\t" + pTotal + "\tProb:\t" + nextTime.Time.Probability);
							if (pTotal > pConfidence)
								break;
						}
						else
						{
							nextStates.Push(nextTime);
						}
					}
					if (pTotal > pConfidence)
						break;
				}
				currentStates = nextStates;
				Console.WriteLine("Level:\t" + ++level + "\tStackSize:\t" + currentStates.Count);
			}
			IFunction F = dfTotal.Integral();
			renderer.AddFunction(F, Pens.Green,"BF - Integral");
			renderer.Draw();
		}
	}
}