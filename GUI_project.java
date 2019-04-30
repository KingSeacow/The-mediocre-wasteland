/**
*Text genereted by Simple GUI Extension for BlueJ
*/
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;


public class GUI_project extends JFrame {

	private JMenuBar menuBar;
	private JPanel TxtBox;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JLabel label1;
	private JPanel panel3;
	private JPanel panel4;
	private JTextField textfield2;

	//Constructor 
	public GUI_project(){

		this.setTitle("GUI_project");
		this.setSize(500,400);
		//menu generate method
		generateMenu();
		this.setJMenuBar(menuBar);

		//pane with null layout
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(500,400));
		contentPane.setBackground(new Color(51,51,51));


		TxtBox = new JPanel(null);
		TxtBox.setBorder(BorderFactory.createEtchedBorder(1));
		TxtBox.setBounds(154,75,331,186);
		TxtBox.setBackground(new Color(214,217,223));
		TxtBox.setForeground(new Color(0,0,0));
		TxtBox.setEnabled(true);
		TxtBox.setFont(new Font("sansserif",0,12));
		TxtBox.setVisible(true);

		button1 = new JButton();
		button1.setBounds(10,75,134,37);
		button1.setBackground(new Color(214,217,223));
		button1.setForeground(new Color(0,0,0));
		button1.setEnabled(true);
		button1.setFont(new Font("sansserif",0,12));
		button1.setText("View All");
		button1.setVisible(true);

		button2 = new JButton();
		button2.setBounds(9,116,134,37);
		button2.setBackground(new Color(214,217,223));
		button2.setForeground(new Color(0,0,0));
		button2.setEnabled(true);
		button2.setFont(new Font("sansserif",0,12));
		button2.setText("Add Contact");
		button2.setVisible(true);

		button3 = new JButton();
		button3.setBounds(10,156,134,37);
		button3.setBackground(new Color(214,217,223));
		button3.setForeground(new Color(0,0,0));
		button3.setEnabled(true);
		button3.setFont(new Font("sansserif",0,12));
		button3.setText("Remove Contact");
		button3.setVisible(true);

		button4 = new JButton();
		button4.setBounds(10,196,134,37);
		button4.setBackground(new Color(214,217,223));
		button4.setForeground(new Color(0,0,0));
		button4.setEnabled(true);
		button4.setFont(new Font("sansserif",0,12));
		button4.setText("Search");
		button4.setVisible(true);

		button5 = new JButton();
		button5.setBounds(11,237,134,37);
		button5.setBackground(new Color(214,217,223));
		button5.setForeground(new Color(0,0,0));
		button5.setEnabled(true);
		button5.setFont(new Font("sansserif",0,12));
		button5.setText("Exit");
		button5.setVisible(true);

		label1 = new JLabel();
		label1.setBounds(8,9,232,34);
		label1.setBackground(new Color(0,102,204));
		label1.setForeground(new Color(0,102,102));
		label1.setEnabled(true);
		label1.setFont(new Font("sansserif",0,12));
		label1.setText("Connor's Contact List");
		label1.setVisible(true);

		panel3 = new JPanel(null);
		panel3.setBorder(BorderFactory.createEtchedBorder(1));
		panel3.setBounds(4,5,491,63);
		panel3.setBackground(new Color(0,102,102));
		panel3.setForeground(new Color(0,0,0));
		panel3.setEnabled(true);
		panel3.setFont(new Font("sansserif",0,12));
		panel3.setVisible(true);

		panel4 = new JPanel(null);
		panel4.setBorder(BorderFactory.createEtchedBorder(1));
		panel4.setBounds(5,337,493,60);
		panel4.setBackground(new Color(0,102,102));
		panel4.setForeground(new Color(0,0,0));
		panel4.setEnabled(true);
		panel4.setFont(new Font("sansserif",0,12));
		panel4.setVisible(true);

		textfield2 = new JTextField();
		textfield2.setBounds(5,5,136,30);
		textfield2.setBackground(new Color(0,153,153));
		textfield2.setForeground(new Color(0,0,0));
		textfield2.setEnabled(true);
		textfield2.setFont(new Font("sansserif",0,12));
		textfield2.setText("Connor's Contact list");
		textfield2.setVisible(true);

		//adding components to contentPane panel
		contentPane.add(TxtBox);
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(button3);
		contentPane.add(button4);
		contentPane.add(button5);
		contentPane.add(label1);
		contentPane.add(panel3);
		contentPane.add(panel4);
		contentPane.add(textfield2);

		//adding panel to JFrame and seting of window position and close operation
		this.add(contentPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}

	//method for generate menu
	public void generateMenu(){
		menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenu tools = new JMenu("Tools");
		JMenu help = new JMenu("Help");

		JMenuItem open = new JMenuItem("Open   ");
		JMenuItem save = new JMenuItem("Save   ");
		JMenuItem exit = new JMenuItem("Exit   ");
		JMenuItem preferences = new JMenuItem("Preferences   ");
		JMenuItem about = new JMenuItem("About   ");


		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		tools.add(preferences);
		help.add(about);

		menuBar.add(file);
		menuBar.add(tools);
		menuBar.add(help);
	}



	 public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI_project();
			}
		});
	}

}