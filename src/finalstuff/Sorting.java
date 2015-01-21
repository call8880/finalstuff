package finalstuff;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;


public class Sorting extends JFrame {

	private JPanel contentPane;
	DefaultListModel model;
	JList lstnums;
	int[] nums = new int[100000];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sorting frame = new Sorting();
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
	public Sorting() {
		
		model = new DefaultListModel();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnGenerateNumbers = new JButton("Generate Numbers");
		btnGenerateNumbers.setBounds(10, 11, 156, 23);
		btnGenerateNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.clear();
				for (int x = 0; x < nums.length; x++){
					nums[x] = (int)(Math.random() * 50000) + 1;
					model.addElement(nums[x]);
				}
				
			}
		});
		contentPane.setLayout(null);
		btnGenerateNumbers.setBackground(Color.GREEN);
		contentPane.add(btnGenerateNumbers);
		
		JButton btnBubble = new JButton("Bubble");
		btnBubble.setBounds(172, 55, 102, 23);
		btnBubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				double stime = System.currentTimeMillis();
				bubbleSort(nums);
				double etime = System.currentTimeMillis();
				System.out.println(etime);
				for (int x = 0; x< nums.length; x++){
					model.addElement(nums[x]);
				}
			}
		});
		contentPane.add(btnBubble);
		
		JButton btnMethod = new JButton("Selection");
		btnMethod.setBounds(172, 87, 102, 23);
		btnMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.clear();
				double stime = System.currentTimeMillis();
				selectionSort(nums);
				double etime = System.currentTimeMillis();
				System.out.println(etime);
				for (int x = 0; x< nums.length; x++){
					model.addElement(nums[x]);
				}
			}
		});
		contentPane.add(btnMethod);
		
		JButton btnMethod_1 = new JButton("Insertion");
		btnMethod_1.setBounds(172, 117, 102, 23);
		btnMethod_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				double stime = System.currentTimeMillis();
				System.out.println(stime);
				insertionSort(nums);
				double etime = System.currentTimeMillis();
				System.out.println(etime);
				for (int x = 0; x< nums.length; x++){
					model.addElement(nums[x]);
				}
			}
		});
		contentPane.add(btnMethod_1);
		
		JButton btnRecursion = new JButton("Recursion");
		btnRecursion.setBounds(172, 149, 102, 23);
		btnRecursion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.clear();
				recursionsort(nums, 0, nums.length-1);
				for (int x = 0; x < nums.length; x++){
					model.addElement(nums[x]);
				}	
			}
		});
		contentPane.add(btnRecursion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 156, 194);
		contentPane.add(scrollPane);
		
		lstnums = new JList();
		scrollPane.setViewportView(lstnums);
		lstnums.setModel(model);
		
	}
	public static void bubbleSort(int[] a){
	   	int k = 0;
	   	boolean exchangeMade = true;
		// Make up to n - 1 passes through array, exit 
		//early if no exchanges are made on previous pass
	  
	 	while ((k < a.length - 1) && exchangeMade){
	      		exchangeMade = false;
	      		k++;
	      		for (int j = 0; j < a.length - k; j++)  
	         		if (a[j] > a[j + 1]){
	            			swap(a, j, j + 1);		 
	            			exchangeMade = true;
	         		}
	 	}
	}
	//supporting swap method
	public static void swap(int[] a, int x, int y){
	   int temp = a[x];
	   a[x] = a[y];
	   a[y] = temp;
	}
	public static void selectionSort(int[] a){
		   for (int i = 0; i < a.length - 1; i++){
		      int minIndex = findMinimum(a, i);
		      if (minIndex != i)
			//if lowest is not already in place
		         swap(a, i, minIndex);
		   } //end for
		}  

		//supporting findMinimum method

		public static int findMinimum(int[] a, int first){
		   //first=where to start looking from
		   //assume first is also the smallest for now
		   int minIndex = first; 
		   for (int i = first + 1; i < a.length; i++)
		      if (a[i] < a[minIndex])
		         minIndex = i;
		   return minIndex;
		}

		//supporting swap method (same as bubble sort swap)

		public static void insertionSort(int a[]){
			int itemToInsert, j;
			boolean stillLooking;

			//on the kth pass, pass item k upwards in list
			//and insert it in its proper place amoung the
			//first k entries in an array

			for (int k=1; k<a.length; k++){
			//move backwards through list, looking for
			//the right place to insert a[k];
				itemToInsert = a[k];
				j=k-1;
				stillLooking=true;
				while(j >=0 && stillLooking){
					if (itemToInsert < a[j]){
						//move item higher
						a[j+1] = a[j];
						j--;
					}else{
						//we have found new home for a[k];
						stillLooking=false;
					}//end else// j+1 is where the item goes
					a[j+1]=itemToInsert;
				}//end while
		  	}//end for
		}//end method
		public static void recursionsort(int[] a, int left, int right){
			
			if (left >= right)return;
			int i = left; 
			int j = right;
			int pivotvalue = a[(left + right) / 2];
			while(i < j){
				while (a[i] < pivotvalue) i++;
				while (a[i] > pivotvalue) j--;
				if (i <= j){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
					j--;
				}
			}
			recursionsort(a, left, j);
			recursionsort(a, i, right);
		}
}
