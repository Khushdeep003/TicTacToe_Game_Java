import java.awt.*; //providing a graphical user interface (GUI) for a Java program
import java.awt.event.*; //defines classes and interfaces used for event handling in the AWT and Swing
import java.util.*; //contains the collections of tablework
import javax.swing.*; //providing a graphical user interface (GUI) for a Java program
import javax.swing.text.AttributeSet.ColorAttribute;

//tic tac toe class
public class TicTacToe implements ActionListener {
	// declaration
	Random random = new Random();
	JFrame table = new JFrame(); // panel for table
	JPanel titleP = new JPanel(); // panel to hold a title
	JPanel buttonP = new JPanel(); // panel to hold all buttons
	JLabel textfield = new JLabel(); // panel to hold text
	JButton[] buttons = new JButton[9]; // arrays for buttons, we need 9 buttons
	boolean p1Turn; // if it's true the player1 turns and if it's false the player2's turn

	TicTacToe() {
		// set the JFrame
		table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make a table
		table.setSize(500, 500); // set a size of table
		table.getContentPane().setBackground(Color.pink); // add object and set background color
		table.setLayout(new BorderLayout()); // set the lable
		table.setVisible(true); // set the visibility of the table
		// set the text
		textfield.setBackground(new Color(207, 159, 255)); // set background color
		textfield.setForeground(Color.GRAY); // set foreground color
		textfield.setFont(new Font("Serif", Font.ITALIC, 70)); // set font style
		textfield.setHorizontalAlignment(JLabel.CENTER); // set the horizontal allignment
		textfield.setText("Tic-Tac-Toe"); // set the text
		textfield.setOpaque(true); // for java swing
		// set the title
		titleP.setLayout(new BorderLayout()); // set the border
		titleP.setBounds(0, 0, 700, 70); // set the alligns
		// set the button
		buttonP.setLayout(new GridLayout(3, 3)); // set layout (9)
		buttonP.setBackground(Color.LIGHT_GRAY); // set background color
		// set 9 buttons, using for loops for creating 9 buttons
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton(); // button array
			buttonP.add(buttons[i]); // set buttons
			buttons[i].setFont(new Font("Dialog", Font.BOLD, 110));// set font styles
			buttons[i].setFocusable(false); // set focusable to false to fit the button
			buttons[i].addActionListener(this); // set actionListener for every button
		}

		titleP.add(textfield); // set title panel
		table.add(titleP, BorderLayout.NORTH); // set the title on top of table
		table.add(buttonP); // set the button panel

		firstTurn(); // return firstTurn
	}

	// since we used actionListener we need to use this(unimplements method)
	public void actionPerformed(ActionEvent e) {
		// since it should be run 9 times when the button is clicked, we used for
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) { // check the turns of player
				if (p1Turn) { // X plays then O turn
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(Color.RED); // set the red color for X
						buttons[i].setText("X");
						p1Turn = false;
						textfield.setText("O turn");
						check(); // call the check function
					}
				} else { // O plays then X turn
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(Color.BLUE); // set the blue color for O
						buttons[i].setText("O");
						p1Turn = true;
						textfield.setText("X turn");
						check(); // call the check function
					}
				}
			}
		}
	}

	// this method determines that whose turn is first
	public void firstTurn() {
		// use the try and catch to change between tic tac toe and the turns, delay
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		// this if, choose the first player based on reading a number that random has
		// generated
		if (random.nextInt(2) == 0) {
			p1Turn = true;
			textfield.setText("X Turn");
		} else {
			p1Turn = false;
			textfield.setText("O Turn");
		}
	}

	// method that check the condition to win
	public void check() {
		// check X win conditions
		if ((buttons[0].getText() == "X") &&
				(buttons[1].getText() == "X") &&
				(buttons[2].getText() == "X")) {
			xWins(0, 1, 2);
		}
		if ((buttons[3].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[5].getText() == "X")) {
			xWins(3, 4, 5);
		}
		if ((buttons[6].getText() == "X") &&
				(buttons[7].getText() == "X") &&
				(buttons[8].getText() == "X")) {
			xWins(6, 7, 8);
		}
		if ((buttons[0].getText() == "X") &&
				(buttons[3].getText() == "X") &&
				(buttons[6].getText() == "X")) {
			xWins(0, 3, 6);
		}
		if ((buttons[1].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[7].getText() == "X")) {
			xWins(1, 4, 7);
		}
		if ((buttons[2].getText() == "X") &&
				(buttons[5].getText() == "X") &&
				(buttons[8].getText() == "X")) {
			xWins(2, 5, 8);
		}
		if ((buttons[0].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[8].getText() == "X")) {
			xWins(0, 4, 8);
		}
		if ((buttons[2].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[6].getText() == "X")) {
			xWins(2, 4, 6);
		}
		// check O win conditions
		if ((buttons[0].getText() == "O") &&
				(buttons[1].getText() == "O") &&
				(buttons[2].getText() == "O")) {
			oWins(0, 1, 2);
		}
		if ((buttons[3].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[5].getText() == "O")) {
			oWins(3, 4, 5);
		}
		if ((buttons[6].getText() == "O") &&
				(buttons[7].getText() == "O") &&
				(buttons[8].getText() == "O")) {
			oWins(6, 7, 8);
		}
		if ((buttons[0].getText() == "O") &&
				(buttons[3].getText() == "O") &&
				(buttons[6].getText() == "O")) {
			oWins(0, 3, 6);
		}
		if ((buttons[1].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[7].getText() == "O")) {
			oWins(1, 4, 7);
		}
		if ((buttons[2].getText() == "O") &&
				(buttons[5].getText() == "O") &&
				(buttons[8].getText() == "O")) {
			oWins(2, 5, 8);
		}
		if ((buttons[0].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[8].getText() == "O")) {
			oWins(0, 4, 8);
		}
		if ((buttons[2].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[6].getText() == "O")) {
			oWins(2, 4, 6);
		}
	}

	// this method define the conditions for winning X
	public void xWins(int a, int b, int c) { // set background color when X wins
		buttons[a].setBackground(Color.PINK);
		buttons[b].setBackground(Color.PINK);
		buttons[c].setBackground(Color.PINK);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false); // this for enables the buttons after X wins
		}
		textfield.setText("X wins"); // set text when X wins
	}

	// this method define the conditions for winning Y
	public void oWins(int a, int b, int c) { // set background when Y wins
		buttons[a].setBackground(Color.PINK);
		buttons[b].setBackground(Color.PINK);
		buttons[c].setBackground(Color.PINK);

		for (int i = 0; i < 9; i++) { // this for enables the buttons after O wins
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins"); // set text when Y wins
	}
}