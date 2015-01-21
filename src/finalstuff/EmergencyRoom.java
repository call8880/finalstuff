package finalstuff;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class EmergencyRoom extends JFrame{

	private JPanel contentPane;
	private JTextField txtname;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Patient p;
	JScrollPane txtpatients;
	String option = "";
	LinkedPriorityQueue q;
	int value = 10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmergencyRoom frame = new EmergencyRoom();
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
	public EmergencyRoom() {
		
		q = new LinkedPriorityQueue(3);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(10, 11, 89, 14);
		contentPane.add(lblPatientName);
		
		txtname = new JTextField();
		txtname.setBounds(95, 8, 126, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		final JRadioButton btnfair = new JRadioButton("Fair");
		buttonGroup.add(btnfair);
		btnfair.setBounds(6, 63, 109, 23);
		contentPane.add(btnfair);
		
		JLabel lblCondition = new JLabel("Condition");
		lblCondition.setBounds(10, 42, 75, 14);
		contentPane.add(lblCondition);
		
		final JRadioButton btnserious = new JRadioButton("Serious");
		buttonGroup.add(btnserious);
		btnserious.setBounds(6, 89, 109, 23);
		contentPane.add(btnserious);
		
		final JRadioButton btncritical = new JRadioButton("Critical");
		buttonGroup.add(btncritical);
		btncritical.setBounds(6, 115, 109, 23);
		contentPane.add(btncritical);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnfair.isSelected()) option = btnfair.getText();
				if(btnserious.isSelected()) option = btnserious.getText();
				if(btncritical.isSelected()) option = btncritical.getText();
				String nm = txtname.getText();
				System.out.println(option);
				boolean treated = false;
				p = new Patient(nm, option, treated);
				String str = p.toString();
				txtpatients.setToolTipText(str);
				int priority = -1;

				if(btncritical.isSelected()) priority = 0;
				if(btnserious.isSelected()) priority = 1;
				if(btnfair.isSelected()) priority = 2;
				q.enqueue(p, priority);
				System.out.println(q.hasData());
				
			}

		});
		btnSchedule.setBounds(121, 63, 89, 23);
		contentPane.add(btnSchedule);
		
		JButton btnTreatNext = new JButton("Treat Next");
		btnTreatNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				p = (Patient) q.dequeue();
				p.isTreated(true);
				txtpatients.append(p.toString());
				
			}
		});
		btnTreatNext.setBounds(121, 97, 89, 23);
		contentPane.add(btnTreatNext);
		
		JButton btnTreatAll = new JButton("Treat All");
		btnTreatAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}	
		});
		btnTreatAll.setBounds(121, 131, 89, 23);
		contentPane.add(btnTreatAll);
		
		txtpatients = new JScrollPane();
		txtpatients.setEditable(false);
		txtpatients.setBounds(10, 159, 211, 91);
		contentPane.add(txtpatients);

		
	}
}

	
