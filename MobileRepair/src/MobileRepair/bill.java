package MobileRepair;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class bill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnpay;
	private JLabel txtrepair;
	private JLabel txtpay;
	private JLabel txtdue;
	private JLabel txtbalance;
	
	String repairno;
	String model;
	String sn;
	String fee;
	String pay;
	String due;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bill frame = new bill();
					frame.setVisible(true);
					frame.setLocation(600, 200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bill() {
		initComponents();
	}

	public bill(String repairno, String model, String sn, String fee, String pay, String due) {
		// TODO Auto-generated constructor stub
		initComponents();
		

		bill.this.setLocation(600, 200);
		
		this.repairno= repairno;
		this.model= model;
		this.sn= sn;
		this.fee= fee;
		this.pay= pay;
		this.due= due;
		
		
		txtrepair.setText(repairno);
		txtpay.setText(pay);
		txtdue.setText(due);
		
		
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 379, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bill Payment");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(69, 30, 245, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Repair Fee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(57, 120, 77, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pay");
		lblNewLabel_2.setBounds(57, 180, 45, 19);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Due");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(57, 240, 45, 19);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New Pay");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(57, 300, 101, 19);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Balance");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(57, 360, 101, 19);
		contentPane.add(lblNewLabel_5);
		
		txtrepair = new JLabel("");
		txtrepair.setBounds(220, 120, 45, 13);
		contentPane.add(txtrepair);
		
		txtpay = new JLabel("");
		txtpay.setBounds(220, 180, 45, 13);
		contentPane.add(txtpay);
		
		txtdue = new JLabel("");
		txtdue.setBounds(220, 240, 45, 13);
		contentPane.add(txtdue);
		
		txtbalance = new JLabel("");
		txtbalance.setBounds(220, 360, 45, 13);
		contentPane.add(txtbalance);
		
		txtnpay = new JTextField();
		txtnpay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int tot= Integer.parseInt(due)- Integer.parseInt(txtnpay.getText());
				txtbalance.setText(Integer.toString(tot));
			}
		});
		txtnpay.setBounds(220, 297, 96, 19);
		contentPane.add(txtnpay);
		txtnpay.setColumns(10);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				billUpdate();
				print();
				
				mshop m= new mshop();
				m.repaint();
				m.setLocation(200,0); // Copy location from current frame
				m.setVisible(true);
				bill.this.dispose();
			}

		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(133, 416, 112, 36);
		contentPane.add(btnNewButton);
	}
	
	Connection con;
	PreparedStatement pat;
	public void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Use the new driver
            this.con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/mshop", "root", "@estheticSQL"
            );
            System.out.println("Database connected successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database connection failed.");
        }
    }
	
	public void print() {
		String mrep= repairno;
		String mod= model;
		String msn= sn;
		String mfee= fee;
		String mpay= pay;
		String mdue= due;
		
		String npay= txtnpay.getText();
		String bal= txtbalance.getText();
		
		new printbill(mrep,mod,msn,mfee,mpay,mdue,npay,bal).setVisible(true);
	}
	
	public void billUpdate() {
		String rno= repairno;
		connection();
		
		try {
			pat = con.prepareStatement("UPDATE repair SET STATUS = 'Completed' WHERE repairno = ?");
			pat.setString(1, repairno);
			int rowsAffected = pat.executeUpdate(); // Correct method to use for UPDATE
	        System.out.println("Rows updated: " + rowsAffected);

	        if (rowsAffected == 0) {
	            System.out.println("No record found with repairno: " + rno);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
