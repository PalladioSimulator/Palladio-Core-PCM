using System;
using System.Collections;

namespace QmlParser.Semantic
{
	public class StatConstr
	{
		// flat structure
		private StatTypes _statType;
		private DimConstraint.NumOps _numOp;
		private double _number;
		private double _percentileNumber;
		private Frequency _frequency;

		public enum StatTypes {Unknown, Percentile, Frequency, Mean, Variance}

		public StatConstr() : this (StatTypes.Unknown)
		{
		}

		public StatConstr(StatTypes type)
		{
			this._statType = type;
			this._numOp = DimConstraint.NumOps.Unknown;
		}

		public double Number
		{
			get
			{
				return this._number;
			}
			set
			{
				this._number = value;
			}
		}

		public DimConstraint.NumOps NumOp
		{
			get
			{
				return this._numOp;
			}
			set
			{
				this._numOp = value;
			}
		}

		public double PercentileNumber
		{
			get
			{
				return this._percentileNumber;
			}
			set
			{
				this._percentileNumber = value;
			}
		}

		public StatTypes StatType
		{
			get
			{
				return this._statType;
			}
		}

		public Frequency Frequency
		{
			get
			{
				return this._frequency;
			}
			set
			{
				this._frequency = value;
			}
		}
	}
}
