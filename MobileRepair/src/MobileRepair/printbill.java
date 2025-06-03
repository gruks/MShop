package MobileRepair;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Window.Type;

public class printbill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane txtprint;
	
	String rep;
	String mod;
	String msn;
	String mfee;
	String mpay;
	String mdue;
	String npay;
	String bal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					printbill frame = new printbill();
					frame.setAlwaysOnTop(true);
					frame.setVisible(true);
					frame.setLocation(0, 0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param due 
	 * @param pay 
	 * @param fee 
	 * @param sn 
	 * @param model 
	 * @param repairno 
	 */
	public printbill() {
		setType(Type.NORMAL);
		setTitle("Invoice...");
		setAlwaysOnTop(true);
		initComponents();
	}
	
	public printbill(String repairno, String model, String sn, String fee, String pay, String due, String npay,String bal) {
		initComponents();

		printbill.this.setLocation(600, 250);
		
		this.rep= repairno;
		this.mod= model;
		this.msn= sn;
		this.mfee= fee;
		this.mpay= pay;
		this.mdue= due;
		this.npay= npay;
		this.bal= bal; 
		
		txtprint.setText(txtprint.getText()+"    -------------------------------\n");
		txtprint.setText(txtprint.getText()+"       Mobile Repairing Shop\n");
		txtprint.setText(txtprint.getText()+"    -------------------------------\n");

		txtprint.setText(txtprint.getText()+String.format("     %-12s : %s\n", "Repair No.", rep));
		txtprint.setText(txtprint.getText()+String.format("     %-12s : %s\n", "Model No.", mod));
		txtprint.setText(txtprint.getText()+String.format("     %-12s : %s\n", "Serial No.", sn));
		txtprint.setText(txtprint.getText()+"\n");

		txtprint.setText(txtprint.getText()+String.format("     %-12s : %s\n", "Repair Fee", mfee));
		txtprint.setText(txtprint.getText()+String.format("     %-12s : %s\n", "Paid", npay));
		txtprint.setText(txtprint.getText()+"    -------------------------------\n");
		txtprint.setText(txtprint.getText()+String.format("     %-12s : %s\n", "Due", bal));
		txtprint.setText(txtprint.getText()+"    -------------------------------\n\n");

		txtprint.setText(txtprint.getText()+"       Thank You, Come Again!\n");

	}
	

	public void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 292, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtprint = new JTextPane();
		txtprint.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		txtprint.setBounds(10, 10, 258, 348);
		contentPane.add(txtprint);
	}
	
	

}
