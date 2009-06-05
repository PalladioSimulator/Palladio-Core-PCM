package de.uka.ipd.sdq.ByCounter.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This program is executed in the following way: java MKSudoku <input-file>
 * For details of the input-file format, see the Grid.java class.
 * 
 * Adapted from www.exampledepot.com
 * 
 * @author Patrick Chan (original code)
 * @author Michael Kuperberg (modifications, extensions)
 * @version 2, June 8th, 2007
 * @see Grid
 */
public class Sudoku {
	/**
	 * A Grid object holds the currently known values of the MKSudoku puzzle. The
	 * grid consists of 9x9 cells that hold integer values from 0 to 9. A value
	 * of 0 indicates that the cell is empty.
	 * 
	 * Each of the 81 cells has a location which is used to identify a specific
	 * cell. There are 81 locations, labelled location 0 to location 80. Cell
	 * locations are ordered from left-to-right and top-down. For example,
	 * location 0 refers to the top-leftmost cell. Location 8 refers to the
	 * top-righttmost cell. Location 71 refers to the bottom-leftmost cell.
	 * Location 80 refers to the bottom-rightmost cell.
	 * 
	 * The grid consists of 9 columns, labelled column 0 to column 8. The grid
	 * consists of 9 rows, labelled row 0 to row 8.
	 * 
	 * The grid consists of 9 subgrids, labelled subgrid 0 to subgrid 8. Each
	 * subgrid contains a subgrid of 3x3 cells. Subgrid 0 contains cells - 0, 1,
	 * 2, 9, 10, 11, 18, 19, 20. Subgrid 8 contains cells - 60, 61, 62, 69, 70,
	 * 71, 78, 79, 80
	 */
	private class Grid implements Cloneable {
		// Array that contains values of all 81 cells in the grid.
		private int[] cells = new int[81];

		// A set of bit-vectors that represent the known values for each column.
		// Specifically, if column c contains the digits d1 and d2,
		// colsSet[c] = 2^(d1-1)|2^(d2-1)
		// For example, if column 0 contains the values 1 and 4, colsSet[0] = 9.
		// The information in this variable is redundant with the information
		// in the cells variable. The purpose of this variable is to reduce
		// the cost of determining whether a particular digit can be set in
		// a particular cell.
		private int[] colsSet = new int[9];

		// This purpose and behavior of this variable is similar to colsSet.
		private int[] rowsSet = new int[9];

		// This purpose and behavior of this variable is similar to colsSet.
		private int[] subgridSet = new int[9];

		// /**
		// * This method returns a grid of givens and empty cells ready to be
		// * solved. The cells containing givens have values between 1 and 9.
		// * Empty cells have the value 0.
		// *
		// * Characters are read one at a time from the input stream and placed
		// * into the grid in left-to-right and top-down order. - The characters
		// 0
		// * or . indicates an empty cell. - The characters 1 to 9 indicates a
		// * given. - The character # is used for comments; subsequent
		// characters
		// * are ignored until a newline is encountered. - All other characters
		// * are simply ignored.
		// *
		// * @param rd
		// * Reader containing the givens
		// * @return null if there are not enough characters in 'rd' to form a
		// * grid.
		// */
		// protected Grid create(Reader rd) throws Exception {
		// Grid grid = new Grid();
		//
		// // Read until all 81 cells are filled
		// for (int loc = 0; loc < grid.cells.length;) {
		// // Read a character
		// int ch = rd.read();
		//
		// // -1 is returned if the input stream has no more characters
		// if (ch < 0) {
		// // No more characters so return null
		// return null;
		// }
		// if (ch == '#') {
		// // Skip to end-of-line
		// while (ch >= 0 && ch != '\n' && ch != '\r') {
		// ch = rd.read();
		// }
		// } else if (ch >= '1' && ch <= '9') {
		// // A given
		// grid.set(loc, ch - '0');
		// loc++;
		// } else if (ch == '.' || ch == '0') {
		// // Empty cell
		// loc++;
		// }
		// }
		// return grid;
		// }

		/*
		 * Removes the number in a cell. @param loc the location of the target
		 * cell. Values must be in the range [0, 80].
		 */
		private void clear(int loc) {
			// Compute row and column
			int r = loc / 9;
			int c = loc % 9;
			int blockLoc = (r / 3) * 3 + c / 3;

			int num = cells[loc];
			cells[loc] = 0;
			colsSet[c] ^= (1 << num);
			rowsSet[r] ^= (1 << num);
			subgridSet[blockLoc] ^= (1 << num);
		}

		/**
		 * Returns a copy of this grid. Any modifications to the returned grid
		 * will not affect this grid.
		 * 
		 * @return a non-null deep copy of this grid.
		 */
		protected Grid clone() {
			Grid grid = new Grid();
			grid.cells = cells.clone();
			grid.colsSet = colsSet.clone();
			grid.rowsSet = rowsSet.clone();
			grid.subgridSet = subgridSet.clone();
			return grid;
		}

		/*
		 * Finds an empty cell. @return the location of an empty cell or -1 if
		 * there are no empty cells. Values must be in the range [-1, 80].
		 */
		private int findEmptyCell() {
			for (int i = 0; i < cells.length; i++) {
				if (cells[i] == 0) {
					return i;
				}
			}
			return -1;
		}

		private void initialize(int[] instance) {
			int loc = 0;
			for (int i = 0; i < instance.length; i++) {
				if (instance[i] >= 1 && instance[i] <= 9) {
					this.set(loc, instance[i]);
				}
				loc++;
			}

		}

		/*
		 * Sets a number in a cell. This method checks to see if 1. the cell is
		 * empty 2. the cell is allowed to contain the specified number. E.g. if
		 * the number is 5 but the row already has a 5, the cell will not be set
		 * and false is returned. @param loc the location of the target cell.
		 * Values must be in the range [0, 80]. @param num the number to set in
		 * the cell. Values must be in the range [1, 9]. @return true if the set
		 * was successful.
		 */
		private boolean set(int loc, int num) {
			// Compute row and column
			int r = loc / 9;
			int c = loc % 9;
			int blockLoc = (r / 3) * 3 + c / 3;

			boolean canSet = cells[loc] == 0 && (colsSet[c] & (1 << num)) == 0
					&& (rowsSet[r] & (1 << num)) == 0
					&& (subgridSet[blockLoc] & (1 << num)) == 0;
			if (!canSet) {
				return false;
			}

			cells[loc] = num;
			colsSet[c] |= (1 << num);
			rowsSet[r] |= (1 << num);
			subgridSet[blockLoc] |= (1 << num);
			return true;
		}

		/**
		 * Returns a string representing the current contents of the grid. Used
		 * for debugging purposes.
		 * 
		 * @return a non-null string representing the current contents of the
		 *         grid.
		 */
		public String toString() {
			StringBuffer buf = new StringBuffer();
			for (int r = 0; r < 9; r++) {
				if (r % 3 == 0) {
					buf.append("-------------------------\n");
				}
				for (int c = 0; c < 9; c++) {
					if (c % 3 == 0) {
						buf.append("| ");
					}
					int num = cells[r * 9 + c];
					if (num == 0) {
						buf.append(". ");
					} else {
						buf.append(num + " ");
					}
				}
				buf.append("|\n");
			}
			buf.append("-------------------------");
			return buf.toString();
		}
	}

	private final static int[] example1 = new int[] { 0, 6, 0, 1, 0, 4, 0, 5,
			0, 0, 0, 8, 3, 0, 5, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 8, 0, 0,
			4, 0, 7, 0, 0, 6, 0, 0, 6, 0, 0, 0, 3, 0, 0, 7, 0, 0, 9, 0, 1, 0,
			0, 4, 5, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 7, 2, 0, 6, 9, 0, 0, 0, 4,
			0, 5, 0, 8, 0, 7, 0 };

	@SuppressWarnings("unused")
	private final static int[] example2 = new int[] { 0, 6, 0, 1, 0, 4, 0, 5,
			0, 0, 0, 3, 8, 0, 5, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 8, 0, 0,
			4, 0, 7, 0, 0, 6, 0, 0, 6, 0, 0, 0, 3, 0, 0, 7, 0, 0, 9, 0, 1, 0,
			0, 4, 5, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 7, 2, 0, 6, 9, 0, 0, 0, 4,
			0, 5, 0, 8, 0, 7, 0 };

	@SuppressWarnings("unused")
	private final static int[] example3 = new int[] { 0, 6, 0, 1, 0, 4, 0, 5,
			0, 0, 0, 8, 3, 0, 5, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 8, 0, 0,
			4, 0, 7, 0, 0, 6, 0, 0, 6, 0, 0, 0, 4, 0, 0, 7, 0, 0, 9, 0, 1, 0,
			0, 3, 5, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 7, 2, 0, 6, 9, 0, 0, 0, 4,
			0, 5, 0, 8, 0, 7, 0 };

	@SuppressWarnings("unused")
	private final static int[] example4 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8,
			9, 0, 6, 0, 0, 0, 0, 0, 3, 0, 0, 7, 0, 0, 0, 0, 0, 4, 0, 7, 8, 9,
			1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 4, 5, 6, 7, 8, 9, 1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0 };

	private ArrayList<int[]> inputPool;

	private Random rd;

	public Sudoku() {
		super();
		rd = new Random();
		inputPool = new ArrayList<int[]>();
		inputPool.add(example1);
//		inputPool.add(example2);
//		inputPool.add(example3);
//		inputPool.add(example4);
	}

	public static void main(String[] args) throws Exception {
		Sudoku ss = new Sudoku();
		for(int i=0; i<50; i++){
			System.out.println(ss.run_benchmark(1));
		}
//		ss.run(example1);
//		ss.run(example2);
//		ss.run(example3);
//		ss.run(example4);
	}

	protected List<Long> measureSudoku(
			int nrOfWarmups, int nrOfChainings, int nrOfMeasurements){
		int maxUsableNrOfMeasurements = 65000;
		int usedNrOfMeasurements=0;
		if(nrOfMeasurements<=maxUsableNrOfMeasurements){
			usedNrOfMeasurements = nrOfMeasurements;
		}else{
			usedNrOfMeasurements = maxUsableNrOfMeasurements;
//			CPUCyclesCounter.o.println("Restricting the number of measurements to " +
//					maxUsableNrOfMeasurements+" (instead of " +
//					nrOfMeasurements + ") because of Microsoft Excel CSV " +
//					"restrictions in number of lines.");
		}
		
//		CPUCyclesCounter.o.println("\n"+"MKSudoku measurement: starting with \n"
//				+ nrOfWarmups		+ " as nrOfWarmups, \n"+
//				+ nrOfChainings		+ " as nrOfChainings, \n"+
//				+ usedNrOfMeasurements	+ " as nrOfMeasurements.");
		
		List<Long> warmupPseudoResults = new ArrayList<Long>();
		for(int i=0; i<nrOfWarmups; i++){
			warmupPseudoResults.add(run_benchmark(nrOfChainings));
		}
		Collections.sort(warmupPseudoResults);
//		CPUCyclesCounter.o.println("\n"+"MKSudoku warmup finished (median of warmup: "+
//				warmupPseudoResults.get(warmupPseudoResults.size()/2)+" ns).");
		warmupPseudoResults = null; //GC rules
	
		List<Long> measurements = new ArrayList<Long>();
		
		for(int i=0; i<usedNrOfMeasurements; i++){
			measurements.add(run_benchmark(nrOfChainings));
		}
//		CPUCyclesCounter.o.println("");
		if(measurements.size()!=usedNrOfMeasurements){
//			CPUCyclesCounter.o.println("Measurements not carried out properly, returning");
			return null;
		}
		return measurements;
		
	}

	public List<Long> MKmeasureSudoku(){
		int pseudoNrOfWarmups = 10;
		int pseudoNrOfMeasurements = 10;
		
		int maxUsableNrOfMeasurements = 65000;
		int usedNrOfMeasurements=0;
		if(pseudoNrOfMeasurements<=maxUsableNrOfMeasurements){
			usedNrOfMeasurements = pseudoNrOfMeasurements;
		}else{
			usedNrOfMeasurements = maxUsableNrOfMeasurements;
//			CPUCyclesCounter.o.println("Restricting the number of measurements to " +
//					maxUsableNrOfMeasurements+" (instead of " +
//					nrOfMeasurements + ") because of Microsoft Excel CSV " +
//					"restrictions in number of lines.");
		}
		
//		CPUCyclesCounter.o.println("\n"+"MKSudoku measurement: starting with \n"
//				+ nrOfWarmups		+ " as nrOfWarmups, \n"+
//				+ nrOfChainings		+ " as nrOfChainings, \n"+
//				+ usedNrOfMeasurements	+ " as nrOfMeasurements.");
		
		List<Long> warmupPseudoResults = new ArrayList<Long>();
		for(int i=0; i<pseudoNrOfWarmups; i++){
			warmupPseudoResults.add(run_benchmark(1));
		}
		Collections.sort(warmupPseudoResults);
//		CPUCyclesCounter.o.println("\n"+"MKSudoku warmup finished (median of warmup: "+
//				warmupPseudoResults.get(warmupPseudoResults.size()/2)+" ns).");
		warmupPseudoResults = null; //GC rules
	
		List<Long> measurements = new ArrayList<Long>();
		
		for(int i=0; i<usedNrOfMeasurements; i++){
			measurements.add(run_benchmark(1));
		}
//		CPUCyclesCounter.o.println("");
		if(measurements.size()!=usedNrOfMeasurements){
//			CPUCyclesCounter.o.println("Measurements not carried out properly, returning");
			return null;
		}
		return measurements;
	}

	private void printSolutions(Grid grid, List<Grid> solutions) {
		// Print the grid with the givens
		System.out.println("Original");
		System.out.println(grid);

		// Print the solution
		if (solutions.size() == 0) {
			System.out.println("Unsolveable");
		} else if (solutions.size() == 1) {
			System.out.println("Solved");
		} else {
			System.out.println("At least two solutions");
		}

		// Print the solution(s)
		for (int i = 0; i < solutions.size(); i++) {
			System.out.println(solutions.get(i));
		}
		System.out.println();
		System.out.println();
	}

	@SuppressWarnings("unused")
	private void run(int[] instance) {
		Grid grid = new Grid();
		grid.initialize(instance);
		List<Grid> solutions = this.solve(grid);
		printSolutions(grid, solutions);
	}

//	private long MKrun_benchmark() {
//		return run_benchmark(1);
//	}

	private long run_benchmark(int nrOfChainings) {
		long before=0L;
		long after=0L;

		int usedNrOfChainings = 1;
		if (nrOfChainings < 1) {
			usedNrOfChainings = 1;
			System.out.println("Number of chainings has been set to 1 "
					+ "because the given parameter (" + nrOfChainings + ") "
					+ "was not permissible.");
		} else {
			usedNrOfChainings = nrOfChainings;
		}
		Grid grid = new Grid();
		before = System.nanoTime();
		for (int c = 0; c < usedNrOfChainings; c++) {
			int indexOfInput = rd.nextInt(inputPool.size());
			grid.initialize(this.inputPool.get(indexOfInput));
			@SuppressWarnings("unused")
			List<Grid> solutions = this.solve(grid);
		}
		after = System.nanoTime();

		return (after - before);
	}

	private List<Grid> solve(Grid grid) {
		List<Grid> solutions = new ArrayList<Grid>();
		solve(grid, solutions);
		return solutions;
	}

	/**
	 * @author Patrick Chan
	 * @version 1, 12/31/05
	 * @see Sudoku
	 */

	private void solve(Grid grid, List<Grid> solutions) {
		// Return if there is already more than two solution
		if (solutions.size() >= 2) {
			return;
		}

		// Find first empty cell
		int loc = grid.findEmptyCell();

		// If no empty cells are found, a solution is found
		if (loc < 0) {
			solutions.add(grid.clone());
			return;
		}

		// Try each of the 9 digits in this empty cell
		for (int n = 1; n < 10; n++) {
			if (grid.set(loc, n)) {
				// With this cell set, work on the next cell
				solve(grid, solutions);

				// Clear the cell so that it can be filled with another
				// digit
				grid.clear(loc);
			}
		}
	}
}
