package MobileRepair;

import java.awt.EventQueue;

import java.util.logging.Logger;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mshop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCusName;
	private JTextField txtCusNo;
	private JTextField txtDevName;
	private JTextField txtDevSerial;
	private JTextField txtfee;
	private JTextField txtpay;
	private JTextField txtdue;
	private JLabel txtno;
	private JTextPane prblm;
	private JComboBox<String> txtstatus;
	private JTable table;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mshop frame = new mshop();
					frame.setVisible(true);
					frame.setLocation(200, 0); 
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public mshop() {
		
			initComponents();
			AutoId();
			tableData();
	    }
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1134, 909);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mobile Repairing Shop");
		lblNewLabel.setForeground(new Color(91, 91, 91));
		lblNewLabel.setBounds(341, 27, 360, 55);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 109, 418, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Repairing Information");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(74, 10, 273, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Repair No.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(42, 80, 102, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(42, 130, 102, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Customer Phone No.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(44, 180, 136, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Device Name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(42, 230, 125, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Device S/n.");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(42, 280, 102, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Problem");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(42, 330, 88, 13);
		panel.add(lblNewLabel_7);
		
		txtno = new JLabel("");
		txtno.setForeground(new Color(255, 0, 0));
		txtno.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtno.setBounds(250, 81, 114, 13);
		panel.add(txtno);
		
		txtCusName = new JTextField();
		txtCusName.setBounds(250, 128, 146, 19);
		panel.add(txtCusName);
		txtCusName.setColumns(10);
		
		txtCusNo = new JTextField();
		txtCusNo.setColumns(10);
		txtCusNo.setBounds(250, 178, 146, 19);
		panel.add(txtCusNo);
		
		txtDevName = new JTextField();
		txtDevName.setColumns(10);
		txtDevName.setBounds(250, 228, 146, 19);
		panel.add(txtDevName);
		
		txtDevSerial = new JTextField();
		txtDevSerial.setColumns(10);
		txtDevSerial.setBounds(250, 278, 146, 19);
		panel.add(txtDevSerial);
		
		prblm = new JTextPane();
		prblm.setBounds(250, 330, 146, 69);
		panel.add(prblm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(590, 109, 412, 261);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Bill Information");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(89, 10, 273, 37);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Repair Fee");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(51, 80, 102, 13);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Pay");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(51, 130, 102, 13);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Due");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(51, 180, 102, 13);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Status");
		lblNewLabel_2_4.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4.setBounds(51, 232, 102, 13);
		panel_1.add(lblNewLabel_2_4);
		
		txtfee = new JTextField();
		txtfee.setColumns(10);
		txtfee.setBounds(242, 78, 146, 19);
		panel_1.add(txtfee);
		
		txtpay = new JTextField();
		txtpay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int fee= Integer.parseInt(txtfee.getText());
				int pay= Integer.parseInt(txtpay.getText());
				
				int tot= fee-pay;
				
				txtdue.setText(String.valueOf(tot));
			}
		});
		txtpay.setColumns(10);
		txtpay.setBounds(242, 128, 146, 19);
		panel_1.add(txtpay);
		
		txtdue = new JTextField();
		txtdue.setColumns(10);
		txtdue.setBounds(242, 178, 146, 19);
		panel_1.add(txtdue);
		
		txtstatus = new JComboBox<>(new String[] {"Active", "Completed"});
		txtstatus.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtstatus.setBounds(242, 227, 146, 24);
		panel_1.add(txtstatus);

	        // Table
	        table = new JTable();
	        DefaultTableModel model = new DefaultTableModel(
	                new Object[][] {},
	                new String[] {"RepairNo", "Customer", "Model", "SN", "Repair Fee", "Pay", "Due", "Status"}
	        );
	        table.setModel(model);
	        JScrollPane scrollPane = new JScrollPane(table);
	        table.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		
	        		DefaultTableModel d1= (DefaultTableModel) table.getModel();
	        		int selectIndex = table.getSelectedRow();
	        		
	        		String status = d1.getValueAt(selectIndex, 7).toString();
	        		
	        		if(status.equals("Completed")) {
	        			JOptionPane.showMessageDialog(null, "Order Completed.....");
	        		}
	        		else {
	        			String repairno = d1.getValueAt(selectIndex, 0).toString();
	        			String model = d1.getValueAt(selectIndex, 2).toString();
	        			String sn = d1.getValueAt(selectIndex, 3).toString();
	        			String fee = d1.getValueAt(selectIndex, 4).toString();
	        			String pay = d1.getValueAt(selectIndex, 5).toString();
	        			String due = d1.getValueAt(selectIndex, 6).toString();
	        			
	        			new bill(repairno,model,sn,fee,pay,due).setVisible(true);
	        				
	        		
	        			
	        		}
	        	}
	        });
	        scrollPane.setBounds(496, 429, 600, 297);
	        getContentPane().add(scrollPane);
	        
	        JButton btnNewButton = new JButton("Print");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		print();
	        		save();
	        	}
	        });
	        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
	        btnNewButton.setBounds(79, 641, 130, 49);
	        contentPane.add(btnNewButton);
	        
	        JButton btnNewButton_1 = new JButton("Cancel");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	        btnNewButton_1.setBounds(288, 641, 130, 49);
	        contentPane.add(btnNewButton_1);
	}
	
	Connection con;
    PreparedStatement pat;


    public void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Use the new driver
            this.con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mshop", "root", "@estheticSQL1"
            );
            System.out.println("Database connected successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database connection failed.");
        }
    }

    public void AutoId() {
        try {
            connection(); // Ensure this sets con
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(repairno) FROM repair");

            String maxId = null;
            if (rs.next()) {
                maxId = rs.getString(1); // Get result of MAX(repairno)
            }

            String newId;
            if (maxId == null || maxId.isEmpty()) {
                newId = "CST001";
            } else {
                int id = Integer.parseInt(maxId.substring(3)); // Remove "CST"
                id++;
                newId = "CST" + String.format("%03d", id);
            }

            txtno.setText(newId);
            System.out.println("Generated ID: " + newId); // Debug print

        } catch (SQLException ex1) {
            Logger.getLogger(mshop.class.getName()).log(Level.ALL, null, ex1);
            ex1.printStackTrace();
        } catch (Exception ex2) {
            ex2.printStackTrace();
        }
    }
    
    public void save() {
    	String repairno= txtno.getText();
    	String	custname= txtCusName.getText();
    	String phone= txtCusNo.getText();
    	String Model= txtDevName.getText();
    	String sn= txtDevSerial.getText();
    	String mproblem= prblm.getText();
    	
    	String fee= txtfee.getText();
    	String pay= txtpay.getText();
    	String Due= txtdue.getText();
    	String status = txtstatus.getSelectedItem().toString();
    	
    	connection();
    	
    	try {
    		pat = con.prepareStatement("INSERT INTO repair (repairno,custname,status,phoneno,dmodel,sn,prob,fee,pay,due) VALUES (?,?,?,?,?,?,?,?,?,?)");
			pat.setString(1, repairno);
			pat.setString(2, custname);
			pat.setString(3, status);
			pat.setString(4, phone);
			pat.setString(5, Model);
			pat.setString(6, sn);
			pat.setString(7, mproblem);
			pat.setString(8, fee);
			pat.setString(9, pay);
			pat.setString(10, Due);
			
			pat.executeUpdate();
			
			txtno.setText("");
	    	  txtCusName.setText("");
	    	  txtCusNo.setText("");
	    	  txtDevName.setText("");
	    	  txtDevSerial.setText("");
	    	  prblm.setText("");
	    	
	    	  txtfee.setText("");
	    	  txtpay.setText("");
	    	  txtdue.setText("");
	    	  txtstatus.setSelectedIndex(-1);
	    	  
	    	  txtCusName.requestFocus();
	    	  
	    	  AutoId();
	    	  tableData();
	    	  
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void tableData() {
		connection();
		
		try {
			pat = con.prepareStatement("SELECT repairno, custname, dmodel, sn, fee, pay, due, status FROM repair");

			ResultSet rs = pat.executeQuery();
			
			ResultSetMetaData rsd = rs.getMetaData();
			int c= rsd.getColumnCount();;
			DefaultTableModel dft= (DefaultTableModel) table.getModel();
			dft.setRowCount(0);
			
			while(rs.next()) {
				Vector<String> v2 = new Vector<String>();
				
				
				for(int i=1; i<=c; i++) {
			        v2.add(rs.getString("repairno"));
			        v2.add(rs.getString("custname"));
			        v2.add(rs.getString("dmodel"));
			        v2.add(rs.getString("sn"));
			        v2.add(rs.getString("fee"));
			        v2.add(rs.getString("pay"));
			        v2.add(rs.getString("due"));
			        v2.add(rs.getString("status"));
			    }
					
				dft.addRow(v2);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    
    public void print() {
    	String repairno= txtno.getText();
    	String model= txtDevName.getText();
    	String sn= txtDevSerial.getText();
    	String fee= txtfee.getText();
    	String pay= txtpay.getText();
    	String due= txtdue.getText();
    	
    	new print(repairno,model,sn,fee,pay,due).setVisible(true);
    	
    }
	}

