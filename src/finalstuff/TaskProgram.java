package finalstuff;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.TextArea;

import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TaskProgram extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	ArrayList list;
	ListIterator li;
	int curtask, tottask;
	Task t, tclear;
	TextArea txtdesc;
	JLabel lblttask, lblctask;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskProgram frame = new TaskProgram();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TaskProgram() {
		
		list = new ArrayList();
		li = list.listIterator();
		curtask = 0;
		tottask = 0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnProgram = new JMenu("Program");
		menuBar.add(mnProgram);
		
		JMenuItem mnushowall = new JMenuItem("Show all Tasks");
		mnushowall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = "";
				for (int x = 0; x < list.size(); x++){
					t = (Task)list.get(x);
					result += "Task " + (x + 1) + ":\n" + t.toString() + "\n";
				}
				JOptionPane.showMessageDialog(null, result);
			}
		});
		mnProgram.add(mnushowall);
		
		JMenuItem mnuexit = new JMenuItem("Exit Program");
		mnuexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnProgram.add(mnuexit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mnureplace = new JMenuItem("Replace Current Task");
		mnureplace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tottask == 0){
					JOptionPane.showMessageDialog(null, "No task to replace\n use insert instead");
					return;
				}
				String nm = txtname.getText();
				String d = txtdesc.getText();
				Task t = new Task(nm, d);
				if(t.validate() == false){
					JOptionPane.showMessageDialog(null, "ERROR\n --must enter all information--");
					return;
				}
				li.next();
				li.set(t);
				li.previous();
			}
		});
		mnEdit.add(mnureplace);
		
		JMenuItem mnuremove = new JMenuItem("Remove Current Task");
		mnuremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tottask == 0) return;
				li.next();
				li.remove();
				tottask--;
				lblttask.setText("" + tottask);
				if (tottask == 0){
					txtname.setText("");
					txtdesc.setText("");
					curtask = 0;
					lblctask.setText("N/A");
					return;
				}
				if (tottask > 1){
					li.next();
					t = (Task)li.previous();
				}
				else if (tottask == 1){
					t = (Task)li.previous();
					curtask = 1;
					lblctask.setText("" + curtask);
				}
				txtname.setText(t.getName());
				txtdesc.setText(t.getDescription());
			}
		});
		mnEdit.add(mnuremove);
		
		JMenuItem mnurestore = new JMenuItem("Restore Current Task to screen");
		mnurestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtname.setText(tclear.getName());
				txtdesc.setText( tclear.getDescription());
			}
		});
		mnEdit.add(mnurestore);
		
		JMenuItem mnuclear = new JMenuItem("Clear Screen");
		mnuclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nm = txtname.getText();
				String d = txtdesc.getText();
				tclear = new Task(nm, d);
				txtname.setText("");
				txtdesc.setText("");
			}
		});
		mnEdit.add(mnuclear);
		
		JMenu mnInsert = new JMenu("Insert");
		menuBar.add(mnInsert);
		
		JMenuItem mnubefore = new JMenuItem("Before Current Task");
		mnubefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nm = txtname.getText();
				String d = txtdesc.getText();
				Task t = new Task(nm, d);
				if(t.validate() == false){//add a new task to the program
					JOptionPane.showMessageDialog(null, "ERROR\n --must enter all information--");
					return;
				}
				li.previous();
				li.add(t);
				li.previous();
				curtask--;
				tottask++;
				lblttask.setText("" + tottask);
				lblctask.setText("" + curtask);
				JOptionPane.showMessageDialog(null, "Task Added");
			}
		});
		mnInsert.add(mnubefore);
		
		JMenuItem mnuafter = new JMenuItem("After Current Task");
		mnuafter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nm = txtname.getText();
				String d = txtdesc.getText();
				Task t = new Task(nm, d);
				if(t.validate() == false){//add a new task to the program
					JOptionPane.showMessageDialog(null, "ERROR\n --must enter all information--");
					return;
				}
				if (tottask > 0) li.next();
				li.add(t);
				li.previous();
				curtask++;
				tottask++;
				lblttask.setText("" + tottask);
				lblctask.setText("" + curtask);
				JOptionPane.showMessageDialog(null, "Task Added");
			}
		});
		mnInsert.add(mnuafter);
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(0, 42, 46, 14);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(66, 39, 358, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(0, 73, 66, 14);
		contentPane.add(lblDescription);
		
		txtdesc = new TextArea();
		txtdesc.setBounds(66, 65, 358, 86);
		contentPane.add(txtdesc);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(66, 157, 284, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCurrentTask = new JLabel("Current Task");
		lblCurrentTask.setForeground(Color.WHITE);
		lblCurrentTask.setBounds(6, 16, 81, 14);
		panel.add(lblCurrentTask);
		
		lblctask = new JLabel("N/A");
		lblctask.setForeground(Color.WHITE);
		lblctask.setBounds(97, 16, 46, 14);
		panel.add(lblctask);
		
		JLabel lblTotalTasks = new JLabel("Total Tasks");
		lblTotalTasks.setForeground(Color.WHITE);
		lblTotalTasks.setBounds(153, 16, 69, 14);
		panel.add(lblTotalTasks);
		
		lblttask = new JLabel("N/A");
		lblttask.setForeground(Color.WHITE);
		lblttask.setBounds(232, 16, 46, 14);
		panel.add(lblttask);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 200, 417, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnfirst = new JButton("|<");
		btnfirst.setBounds(6, 16, 89, 23);
		panel_1.add(btnfirst);
		
		JButton btnprevious = new JButton("<");
		btnprevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (curtask == 1) return;
				curtask--;
				lblctask.setText("" + curtask);
				t = (Task)li.previous();
				
				txtname.setText(t.getName());
				txtdesc.setText(t.getDescription());
			}
		});
		btnprevious.setBounds(105, 16, 89, 23);
		panel_1.add(btnprevious);
		
		JButton btnnext = new JButton(">");
		btnnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (curtask == tottask) return;//move forwards one
				curtask++;
				lblctask.setText("" + curtask);
				li.next();
				li.next();
				t = (Task)li.previous();
				txtname.setText(t.getName());
				txtdesc.setText(t.getDescription());
				
			}
		});
		btnnext.setBounds(209, 16, 89, 23);
		panel_1.add(btnnext);
		
		JButton btnlast = new JButton(">|");
		btnlast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (curtask == tottask) return;//switch to the last program	
				while(li.hasNext()) li.next();
				t = (Task) li.previous();
				curtask = tottask;
				lblctask.setText("" + curtask);
				txtname.setText(t.getName());
				txtdesc.setText(t.getDescription() );
			}
		});
		btnlast.setBounds(308, 16, 89, 23);
		panel_1.add(btnlast);
	}
}
