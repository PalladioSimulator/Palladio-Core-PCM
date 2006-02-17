using System;
using System.Data;

namespace ILBenchmark.AnalyseTool.Clustering.KMeans
{

	/// <summary>
	/// This class implement a KMeans clustering algorithm
	/// </summary>
	public class KMeans
	{
		public KMeans()
		{
		}
		
		/// <summary>
		/// Calculates the Euclidean Distance Measure between two data points
		/// </summary>
		/// <param name="X">An array with the values of an object or datapoint</param>
		/// <param name="Y">An array with the values of an object or datapoint</param>
		/// <returns>Returns the Euclidean Distance Measure Between Points X and Points Y</returns>
		public static double EuclideanDistance(double [] X, double []Y)
		{
			int count = 0;

			double distance = 0.0;

			double sum = 0.0;


			if(X.GetUpperBound(0) != Y.GetUpperBound(0))
			{
				throw new System.ArgumentException("the number of elements in X must match the number of elements in Y");
			}
			else
			{
				count = X.Length;
			}

			for (int i = 0; i < count; i++)
			{
				sum = sum + Math.Pow(Math.Abs(X[i] - Y[i]),2);
			}

			distance = Math.Sqrt(sum);

			return distance;
		}

		
		/// <summary>
		/// Calculates the Manhattan Distance Measure between two data points
		/// </summary>
		/// <param name="X">An array with the values of an object or datapoint</param>
		/// <param name="Y">An array with the values of an object or datapoint</param>
		/// <returns>Returns the Manhattan Distance Measure Between Points X and Points Y</returns>
		public static double ManhattanDistance(double [] X, double []Y)
		{
			int count = 0;

			double distance = 0.0;

			double sum = 0.0;


			if(X.GetUpperBound(0) != Y.GetUpperBound(0))
			{
				throw new System.ArgumentException("the number of elements in X must match the number of elements in Y");
			}
			else
			{
				count = X.Length;
			}

			for (int i = 0; i < count; i++)
			{
				sum = sum + Math.Abs(X[i] - Y[i]);
			}

			distance = sum;

			return distance;
		}

		/// <summary>
		/// Calculates The Mean Of A Cluster OR The Cluster Center
		/// </summary>
		/// <param name="cluster">
		/// A two-dimensional array containing a dataset of numeric values
		/// </param>
		/// <returns>
		/// Returns an Array Defining A Data Point Representing The Cluster Mean or Centroid
		/// </returns>
		public static double [] ClusterMean(double [,] cluster)
		{
			int rowCount = 0;

			int fieldCount = 0;

			double [,] dataSum;

			double [] centroid;


			rowCount = cluster.GetUpperBound(0) + 1;

			fieldCount = cluster.GetUpperBound(1) + 1;

			dataSum = new double[1,fieldCount];

			centroid = new double[fieldCount];

			//((20+30)/2), ((170+160)/2), ((80+120)/2)
			for( int j = 0; j < fieldCount; j++)
			{
				for (int i = 0; i < rowCount; i++)
				{
					dataSum[0,j] = dataSum[0,j] + cluster[i,j];	
				}

				centroid[j] = (dataSum[0,j] / rowCount);
			}
			
			return centroid;
		}

		
		/// <summary>
		/// Seperates a dataset into clusters or groups with similar characteristics
		/// </summary>
		/// <param name="clusterCount">The number of clusters or groups to form</param>
		/// <param name="data">An array containing data that will be clustered</param>
		/// <returns>A collection of clusters of data</returns>
		public static ClusterCollection ClusterDataSet(int clusterCount, double [,] data)
		{
			//bool stableClusterFormation = false;

			int clusterNumber = 0;

			int rowCount = data.GetUpperBound(0) + 1;

			int fieldCount = data.GetUpperBound(1) + 1;

			int stableClustersCount = 0;

			int iterationCount = 0;

			double [] dataPoint;

			Random random = new Random();

			Cluster cluster = null;

			ClusterCollection clusters = new ClusterCollection();

			System.Collections.ArrayList clusterNumbers = new System.Collections.ArrayList(clusterCount);

			
			while(clusterNumbers.Count < clusterCount)
			{
				clusterNumber = random.Next(0, rowCount-1);

				if (!clusterNumbers.Contains(clusterNumber)) 
				{
					
					cluster = new Cluster();

					clusterNumbers.Add(clusterNumber);
					
					dataPoint = new double[fieldCount];


					for (int field = 0; field < fieldCount; field++)
					{
						dataPoint.SetValue((data[clusterNumber, field]),field);	
					}

					cluster.Add(dataPoint);

					clusters.Add(cluster);
				}
			}
			
			
			while (stableClustersCount != clusters.Count)
			{
				stableClustersCount = 0;

				ClusterCollection newClusters = KMeans.ClusterDataSet(clusters, data);

				for (int clusterIndex = 0; clusterIndex < clusters.Count; clusterIndex++)
				{
					if ((KMeans.ManhattanDistance(newClusters[clusterIndex].ClusterMean, clusters[clusterIndex].ClusterMean))==0)
					{
						stableClustersCount++;						
					}			
				}

				iterationCount++;

				clusters = newClusters;
			}

			return clusters;

		}
		

		/// <summary>
		/// Seperates a dataset into clusters or groups with similar characteristics
		/// </summary>
		/// <param name="clusters">A collection of data clusters</param>
		/// <param name="data">An array containing data to b eclustered</param>
		/// <returns>A collection of clusters of data</returns>
		public static ClusterCollection ClusterDataSet(ClusterCollection clusters, double [,] data)
		{
			double [] dataPoint;

			double [] clusterMean;

			double firstClusterDistance = 0.0;

			double secondClusterDistance = 0.0;

			int rowCount = data.GetUpperBound(0) + 1;

			int fieldCount = data.GetUpperBound(1) + 1;

			int position = 0;


			// create a new collection of clusters
			ClusterCollection newClusters = new ClusterCollection();

			for(int count = 0; count < clusters.Count; count++)
			{
				Cluster newCluster = new Cluster();

				newClusters.Add(newCluster);
			}


			if(clusters.Count <= 0)
			{
				throw new SystemException("Cluster Count Cannot Be Zero!");
			}


			//((20+30)/2), ((170+160)/2), ((80+120)/2)
			for( int row = 0; row < rowCount; row++)
			{
				dataPoint = new double[fieldCount];

				for (int field = 0; field < fieldCount; field++)
				{
					dataPoint.SetValue((data[row,field]),field);	
				}

				for(int cluster = 0; cluster < clusters.Count; cluster++)
				{
					clusterMean = clusters[cluster].ClusterMean;

					if(cluster == 0)
					{
						firstClusterDistance = KMeans.ManhattanDistance(dataPoint, clusterMean);
	
						position = cluster;
					}
					else
					{
						secondClusterDistance = KMeans.ManhattanDistance(dataPoint, clusterMean);

						if (firstClusterDistance > secondClusterDistance)
						{
							firstClusterDistance = secondClusterDistance;

							position = cluster;
						}							
					}
				}
				
				newClusters[position].Add(dataPoint);				 
			}

			return newClusters;
		}
		

		#region "Remarks" - This section has been commented out. Uncomment it to serialize your objects
		
		//		/// <summary>
		//		/// Saves or Serializes a Cluster Collection To an Xml file
		//		/// </summary>
		//		/// <param name="myObject">A serializable object to be persisted to an Xml file</param>
		//		/// <param name="writeToXmlPath">The location of the Xml file tha will contain serialized data</param>
		//		/// <returns>True if the serialization is successful otherwise false</returns>
		//		public static bool Serialize(System.Object myObject, string writeToXmlPath)
		//		{
		//			bool state = true;
		//			System.Runtime.Serialization.IFormatter formatter = null;
		//			System.IO.Stream stream = null;
		//			try
		//			{
		//				formatter = new System.Runtime.Serialization.Formatters.Soap.SoapFormatter();
		//				stream = new System.IO.FileStream(writeToXmlPath, FileMode.Create, FileAccess.Write, FileShare.None);
		//				formatter.Serialize(stream, myObject);
		//			}
		//			catch(System.Exception ex)
		//			{
		//				state = false;
		//				System.Diagnostics.Debug.WriteLine(ex.ToString());
		//			}
		//			finally
		//			{
		//				stream.Close();
		//				formatter = null;
		//				stream = null;
		//			}
		//			return state;
		//		}

		#endregion - This section has been commented out. Uncomment it to serialize your objects
		

		/// <summary>
		/// Converts a System.Data.DataTable to a 2-dimensional array
		/// </summary>
		/// <param name="data">A System.Data.DataTable containing data to cluster</param>
		/// <returns>A 2-dimensional array containing data to cluster</returns>
		public static double [,] ConvertDataTableToArray(DataTable table)
		{
			int rowCount = table.Rows.Count;

			int fieldCount = table.Columns.Count;
			
			double [,] dataPoints;

			double fieldValue = 0.0;

			DataRow row;
			

			dataPoints = new double[rowCount, fieldCount];

			for(int rowPosition = 0; rowPosition < rowCount; rowPosition++)
			{
				row = table.Rows[rowPosition];

				for (int fieldPosition = 0; fieldPosition < fieldCount; fieldPosition++)
				{
					try
					{
						fieldValue = double.Parse(row[fieldPosition].ToString());
					}
					catch(System.Exception ex)
					{
						System.Diagnostics.Debug.WriteLine(ex.ToString());

						throw new InvalidCastException("Invalid row at " + rowPosition.ToString() + " and field " + fieldPosition.ToString(),ex);
					}

					dataPoints[rowPosition, fieldPosition] = fieldValue;	
				}					
			}

			return dataPoints;
		}


	}
	
	
	
	/// <summary>
	/// A class containing a group of data with similar characteristics (cluster)
	/// </summary>
	[Serializable]
	public class Cluster  : System.Collections.CollectionBase
	{
		private double [] _clusterSum;		
		/// <summary>
		/// The sum of all the data in the cluster
		/// </summary>
		public double [] ClusterSum
		{
			get
			{
				return this._clusterSum;
			}
		}

		private double [] _clusterMean;
		/// <summary>
		/// The mean of all the data in the cluster
		/// </summary>
		public double [] ClusterMean
		{
			get
			{
				for (int count = 0; count < this[0].Length; count++)
				{
					this._clusterMean[count] = (this._clusterSum[count] / this.List.Count);
				}

				return this._clusterMean;
			}
		}

		/// <summary>
		/// Adds a single dimension array data to the cluster
		/// </summary>
		/// <param name="data">A 1-dimensional array containing data that will be added to the cluster</param>
		public virtual void Add (double [] data)
		{
			this.List.Add(data);
			
			if (this.List.Count == 1)
			{
				this._clusterSum = new double[data.Length];

				this._clusterMean = new double[data.Length];
			}
		
			for (int count = 0; count < data.Length; count++)
			{
				this._clusterSum[count] = this._clusterSum[count] + data[count];
			}
		}
		
		/// <summary>
		/// Returns the one dimensional array data located at the index
		/// </summary>
		public virtual double [] this[int Index] 
		{ 
			get 
			{ 
				//return the Neuron at IList[Index] 
				return (double[])this.List[Index];            
			}        
		} 
	}

	/// <summary>
	/// A collection of Cluster objects or Clusters
	/// </summary>
	[Serializable]
	public class ClusterCollection  : System.Collections.CollectionBase
	{
		
		/// <summary>
		/// Adds a Cluster to the collection of Clusters
		/// </summary>
		/// <param name="cluster">A Cluster to be added to the collection of clusters</param>
		public virtual void Add (Cluster cluster)
		{
			this.List.Add(cluster);
		}
		
		/// <summary>
		/// Returns the Cluster at this index
		/// </summary>
		public virtual Cluster this[int Index] 
		{ 
			get 
			{ 
				//return the Neuron at IList[Index] 
				return (Cluster)this.List[Index];            
			}        
		} 
	}
	

}
