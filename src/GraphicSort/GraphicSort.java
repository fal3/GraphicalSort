/*********************************************************

 The java program to display the graphical demonstration of the sorting algorithms insertion sort, selection sort and the shell sort. 

 **************************/

// package which contains the class

package GraphicSort;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
//Create the class GraphicSort which gives the graphical representation of the sorting algorithms by implementing the interface ActionListener.
// create the class which demonstrates the sorting in graphical form
public class GraphicSort extends JFrame
implements ActionListener
{
	// declare and define the class variables
	private static final int INSERTION = 1;
	private static final int SELECTION = 2;
	private static final int SHELL = 3;
	int a[];
	int scrambledA[];
	Color aColor[];
	// Create the class Sort for the execution of sorting on the graphical object.
	public class Sort
	{
		int sortKind;
		// Define the constructor of the class Sort it calls the constructor of its super class.
		public Sort(int kind)
		{
			sortKind = kind;
		} // end constructor
		// Define the method runSort which is used to run the algorithms.
		// the method run to run the selected algorithm
		public void runSort()
		{
			// set the text of the label
			progressLabel.setText("Sorting");
			sorting = true;
			// switch case to select the type of sorting
			switch (sortKind)
			{
			case INSERTION:
				// INSERTION
				chosenAlgorithm = INSERTION;
				insertionSort(a, 0, 255);
				break;
			case SELECTION:
				chosenAlgorithm = SELECTION;
				selectionSort(a, 256);
				break;
			case SHELL:
				chosenAlgorithm = SHELL;
				shellSort(a, 0, 255);
				break;
			} // end switch
			sorting = false;
			// set the text of progress label
			progressLabel.setText("Idle");
		} // end run
	} // end Sort
	// Declare the objects of the standard classes for the graphical structure.
	//declaration of private variables for graphics
	private Container container;
	private JLabel progressLabel;
	private JLabel randomAlgorithmLabel;
	private JLabel guessLabel;
	private JButton randomAlgorithmButton;
	private JButton scrambleLinesButton;
	private JButton checkGuessButton;
	private JTextField guessTextField;
	private JRadioButton insertionButton;
	private JRadioButton selectionButton;
	private JRadioButton shellButton;
	private ButtonGroup sortGroup;
	private JPanel scramblePanel;
	private JPanel radioPanel;
	private JPanel randomPanel;
	private JPanel guessPanel;
	private JPanel panels;
	private int chosenAlgorithm;
	private boolean sorting;
	// Define the constructor of the class GraphicSort.
	// the constructor of the class GraphicSort
	public GraphicSort()
	{
		a = new int[256];
		scrambledA = new int[256];
		aColor = new Color[256];
		initializeArrays();
		container = getContentPane();
		container.setLayout(new BorderLayout(5, 5));
		// create the object of label
		progressLabel = new JLabel("Idle");
		randomAlgorithmLabel = new JLabel("Random Algorithm");
		guessLabel = new JLabel("Guess:");
		scrambleLinesButton = new JButton("Scramble Lines");
		randomAlgorithmButton = new JButton("Go");
		checkGuessButton = new JButton("Check Guess");
		guessTextField = new JTextField(5);
		insertionButton = new JRadioButton("Insertion sort", true);
		selectionButton = new JRadioButton("Selection sort", false);
		shellButton = new JRadioButton("Shell sort", false);
		scrambleLinesButton.addActionListener(this);
		randomAlgorithmButton.addActionListener(this);
		checkGuessButton.addActionListener(this);
		guessTextField.addActionListener(this);
		insertionButton.addActionListener(this);
		selectionButton.addActionListener(this);
		shellButton.addActionListener(this);
		// create the object of button group
		sortGroup = new ButtonGroup();
		sortGroup.add(insertionButton);
		sortGroup.add(selectionButton);
		sortGroup.add(shellButton);
		scramblePanel = new JPanel();
		scramblePanel.add(scrambleLinesButton);
		radioPanel = new JPanel(new GridLayout(3, 1, 5, 5));
		radioPanel.add(insertionButton);
		radioPanel.add(selectionButton);
		radioPanel.add(shellButton);
		radioPanel.setBorder(new TitledBorder(new EtchedBorder(), "Sort Algorithms"));
		// create the object of swing panel
		randomPanel = new JPanel();
		randomPanel.add(randomAlgorithmLabel);
		randomPanel.add(randomAlgorithmButton);
		guessPanel = new JPanel();
		guessPanel.add(guessTextField);
		guessPanel.add(checkGuessButton);
		// create the panel
		panels = new JPanel(new GridLayout(6, 1, 5, 5));
		// add the objects to the panel
		panels.add(scramblePanel);
		panels.add(radioPanel);
		panels.add(randomPanel);
		panels.add(guessLabel);
		panels.add(guessPanel);
		panels.add(progressLabel);
		container.add(panels, BorderLayout.EAST);
		setSize(1000, 500);
		setVisible(true);
	} // end constructor
	public void initializeArrays()
	{
		for (int i = 0; i < 256; i++)
		{
			a[i] = i + 1;
			// array scramble to scramble the lines
			scrambledA[i] = a[i];
			switch (i % 10)
			{
			case 0:
				aColor[i] = Color.black;
				break;
			case 1:
				aColor[i] = Color.green;
				break;
			case 2:
				aColor[i] = Color.cyan;
				break;
			case 3:
				aColor[i] = Color.magenta;
				break;
			case 4:
				aColor[i] = Color.yellow;
				break;
			case 5:
				aColor[i] = Color.black;
				break;
			case 6:
				aColor[i] = Color.white;
				break;
			case 7:
				aColor[i] = Color.red;
				break;
			case 8:
				aColor[i] = Color.black;
				break;
			case 9:
				aColor[i] = Color.blue;
				break;
			default:
				aColor[i] = Color.black;
			} // end switch
		} // end for
		// Use the same scrambled order each time
		int j, temp;
		// execute the loop till 256 times
		for (int i = 0; i < 256; i++)
		{
			// generate the random values and multiply it with 256
			j = (int) (Math.random() * 256);
			temp = scrambledA[i];
			scrambledA[i] = scrambledA[j];
			scrambledA[j] = temp;
		} // end for
		chosenAlgorithm = 0;
		sorting = false;
	} // end initializeArrays
	// Define the method scramble to scramble the array objects
	//the method to scramble the array elements
	public void scramble()
	{
		// execute the loop to scramble the array
		for (int i = 0; i < 256; i++)
		{
			a[i] = scrambledA[i];
		} // end for
	} // end scramble
	// Define the method actionPerformed which recognizes the events which is
	// occurred and performs the action accordingly.
	// method to perform the action on a event
	public void actionPerformed(ActionEvent event)
	{
		if (!sorting)
		{
			// check if the button Scramble is pressed
			if (event.getSource() == scrambleLinesButton)
			{
				scramble();
				repaint();
			}
			else if (event.getSource() == insertionButton)
				new Sort(INSERTION).runSort();
			else if (event.getSource() == selectionButton)
				new Sort(SELECTION).runSort();
			else if (event.getSource() == shellButton)
				new Sort(SHELL).runSort();
			else if (event.getSource() == randomAlgorithmButton)
			{
				int ran = 1 + (int) (Math.random() * 3);
				// switch case to select the type of sorting
				switch (ran) {
				case INSERTION:
					new Sort(INSERTION).runSort();
					break;
				case SELECTION:
					new Sort(SELECTION).runSort();
					System.out.println("Selection sort is called");
					break;
				case SHELL:
					new Sort(SHELL).runSort();
					break;
				} // end switch
			} // end if
		} // end if
			// allow checking while the sort is running
		if (event.getSource() == checkGuessButton) {
			String answer = guessTextField.getText();
			checkAnswer(answer);
		} else if (event.getSource() == guessTextField)
		{
			String answer = event.getActionCommand();
			checkAnswer(answer);
		} // end if
	} // end actionPerformed
	private void checkAnswer(String answer)
	{
		boolean solved = false;
		boolean goodGuess = false;
		if (answer.equalsIgnoreCase("insertion")) {
			goodGuess = true;
			if (chosenAlgorithm == INSERTION)
				solved = true;
		} // end if
		if (answer.equalsIgnoreCase("selection")) {
			// update the variable
			goodGuess = true;
			if (chosenAlgorithm == SELECTION)
				solved = true;
		} // end if
		if (answer.equalsIgnoreCase("shell")) {
			// update the variable
			goodGuess = true;
			if (chosenAlgorithm == SHELL)
				solved = true;
		} // end if
		if (solved)
			JOptionPane.showMessageDialog(null, "Your guess is correct!",
					"Check Answer Results", JOptionPane.INFORMATION_MESSAGE);
		else if (goodGuess)
			JOptionPane.showMessageDialog(null, "Your guess was NOT correct! ",
					"Check Answer Results", JOptionPane.INFORMATION_MESSAGE);
		else

			JOptionPane
					.showMessageDialog(
							null,
							"Your guess must be one of: Insertion, Selection or Shell.",
							"Check Answer Results",
							JOptionPane.INFORMATION_MESSAGE);
	}// end checkAnswer
	// Define the method paint which draws the graphical lines that are being
	// sort by using the sorting algorithms.
	// method to draw the graphics of the program
	public void paint(Graphics g)
	{
		// call the paint method of super class
		super.paint(g);
		for (int i = 0, j = 0; i < 256; i++, j += 3)
		{
			g.setColor(aColor[a[i] - 1]);
			g.drawLine(20 + j, 100 + (256 - (a[i] + 100)), 20 + j, 100 + (256 - (a[i] + 10)) + a[i] + 10);
		} // end for
	} // end paint
	/**
	 * method to implement the selection sort
	 * 
	 * @param a
	 *            , an array of Comparable objects
	 * @param n
	 *            , an integer > 0
	 */


	public void selectionSort(int[] a, int n)
	{
		for (int index = 0; index < n - 1; index++)
		{
			// declare the variable to store the result of indexOfSmallest method
			int indexOfNextSmallest = indexOfSmallest(a, index, n - 1);
			// call the method to swap the elements of array
			swap(a, index, indexOfNextSmallest);
			repaint();
		} // end for
	} // end selectionSort
	// Define the method indexOfSmallest which finds the index of the smallest
	// element in the array and returns it.
	/**
	 * method to return the index of the smallest value in
	 * 
	 * an array.
	 * 
	 * @param a
	 *            an array of Comparable objects
	 * @param first
	 *            an integer > 0
	 * @param last
	 *            an integer > 0
	 * @return the index of the smallest value
	 */
	private int indexOfSmallest(int[] a, int first, int last)
	{
		// declare and define an integer variable
		int min = a[first];
		// declare and define the integer variable to store
		// the index of minimum value
		int indexOfMin = first;
		// execute the loop till the index is less than or
		// equal to last
		for (int index = first + 1; index <= last; index++) {
			// check if the value at index of a is less than min
			if (a[index] < min) {
				// set the value of min and indexOfMin
				min = a[index];
				indexOfMin = index;
			} // end if
		} // end for
		return indexOfMin;
	} // end indexOfSmallest
	// Define the method swap which exchanges the values of two variables that
	// are passed to it as an argument.
	/**
	 * Method to swap the array elements a[i] and a[j].
	 * 
	 * @param a
	 *            , an array of Comparable objects
	 * @param I
	 *            , an integer
	 * @param j
	 *            , an integer
	 */
	private void swap(int[] a, int i, int j)
	{
		// declare a temporary variable to swap the elements
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	} // end swap
	// Define the method insertionSort which implements the operation of the
	// sorting algorithm insertion sort.
	// method to perform the insertion sort
	public void insertionSort(int[] a, int first, int last)
	{
		if (first < last) {
			// sort all but the last element
			insertionSort(a, first, last - 1);
			// insert the last element in sorted order
			insertInOrder(a[last], a, first, last - 1);
			repaint();
		} // end if
	} // end insertionSort
	// Define the method insertInOrder which decides the order of insertion of
	// the elements in the array for sorting.
	// method to define the order of insertion
	private void insertInOrder(int element, int[] a, int first, int last) {
		// check if the element is greater than the last
		// element of array
		if (element >= a[last]) {
			a[last + 1] = element; // update the last element of array
			repaint(); // call the method repaint
		}
		// check if the first is less than last
		else if (first < last)
		{
			// update the last element of array
			a[last + 1] = a[last];
			// call the method repaint
			repaint();
			// recursively call the method insertInOrder
			insertInOrder(element, a, first, last - 1);
		}
		// first == last and element < a[last]
		else {
			a[last + 1] = a[last];
			a[last] = element;
			repaint();
		} // end if

	} // end insertInOrder
	// Define the method incrementalInsertionSort which sorts the arrays of the
	// elements that are at equal space.
	/**
	 * Sorts equally spaced elements of an array into
	 * 
	 * ascending order.
	 * 
	 * @param a
	 *            an array of Comparable objects
	 * @param first
	 *            an integer
	 * @param last
	 *            an integer
	 * @param space
	 *            the difference between the indices of
	 * 
	 *            the elements to sort
	 */
	private void incrementalInsertionSort(int[] a, int first, int last,
			int space) {
		// declare the local variables
		int unsorted, index;
		// execute the loop till the unsorted is less than
		// or equal to last
		for (unsorted = first + space; unsorted <= last; unsorted = unsorted
				+ space) {
			// declare a variable to store the unsorted
			// value of array
			int firstUnsorted = a[unsorted];
			// execute the loop for the condition (index >=
			// first) &&(firstUnsorted < a[index])
			for (index = unsorted - space; (index >= first)
					&& (firstUnsorted < a[index]); index = index - space)
			{
				// update the array values
				a[index + space] = a[index];
				// call the method repaint
				repaint();
			} // end for
				// update the array values
			a[index + space] = firstUnsorted;
			// call the method repaint
			repaint();
		} // end for
	} // end incrementalInsertionSort
	// Define the method shellSort which implements the operation of the shell
	// sort algorithm for sorting the graphical elements of an array.
	// method to define the shellSort
	public void shellSort(int[] a, int first, int last)
	{
		// number of array elements
		int n = last - first + 1;
		// execute the loop till the space is greater than zero
		for (int space = n / 2; space > 0; space = space / 2) {
			// execute the loop
			for (int begin = first; begin < first + space; begin++)
				// call the method incrementalInsertionSort for the array
				incrementalInsertionSort(a, begin, last, space);
		} // end for
	} // end shellSort
	// Define the main method of the program which starts the execution of the
	// program by creating the object of the class.
	public static void main(String[] args) {
		// create the object of the class GraphicSort
		GraphicSort sortDemo1 = new GraphicSort();
	} // end main
}
