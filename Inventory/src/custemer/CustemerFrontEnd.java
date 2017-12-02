package custemer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import custemer.bean.Custemer;
import custemer.dao.CustemerDAO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustemerFrontEnd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldEmailId;
	private JTextField textFieldPhNumber;
	private JTextField textFieldGender;
	private JTextField textFieldAge;
	private JTextField textFieldAddress;
	private JTextField textFieldFax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustemerFrontEnd frame = new CustemerFrontEnd();
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
	public CustemerFrontEnd() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CustemerFrontEnd.class.getResource("/Icons/Users-icon.png")));
		setTitle("Add Customer");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(246, 71, 71));
		panel.setBounds(0, 0, 236, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CustemerFrontEnd.class.getResource("/Icons/Users-icon.png")));
		label.setBounds(65, 72, 106, 96);
		panel.add(label);
		
		JLabel lblAddCustomer = new JLabel("Add Customer");
		lblAddCustomer.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAddCustomer.setBounds(65, 179, 106, 46);
		panel.add(lblAddCustomer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(241, 169, 160));
		panel_1.setBounds(234, 0, 581, 443);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(106, 71, 157, 30);
		panel_1.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblFillAllDetails = new JLabel("Fill All Details");
		lblFillAllDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFillAllDetails.setBounds(242, 11, 79, 30);
		panel_1.add(lblFillAllDetails);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setBounds(21, 79, 67, 14);
		panel_1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(21, 135, 67, 14);
		panel_1.add(lblLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(106, 127, 157, 30);
		panel_1.add(textFieldLastName);
		
		JLabel lblEmailId = new JLabel("Email ID:");
		lblEmailId.setBounds(38, 192, 50, 14);
		panel_1.add(lblEmailId);
		
		textFieldEmailId = new JTextField();
		textFieldEmailId.setColumns(10);
		textFieldEmailId.setBounds(106, 184, 157, 30);
		panel_1.add(textFieldEmailId);
		
		JLabel lblPhNumber = new JLabel("Ph Number:");
		lblPhNumber.setBounds(21, 261, 67, 14);
		panel_1.add(lblPhNumber);
		
		textFieldPhNumber = new JTextField();
		textFieldPhNumber.setColumns(10);
		textFieldPhNumber.setBounds(106, 253, 157, 30);
		panel_1.add(textFieldPhNumber);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(340, 79, 47, 14);
		panel_1.add(lblGender);
		
		textFieldGender = new JTextField();
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(402, 71, 157, 30);
		panel_1.add(textFieldGender);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(358, 134, 41, 14);
		panel_1.add(lblAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(402, 127, 157, 30);
		panel_1.add(textFieldAge);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(330, 192, 58, 14);
		panel_1.add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(402, 184, 157, 30);
		panel_1.add(textFieldAddress);
		
		JLabel lblFax = new JLabel("Fax:");
		lblFax.setBounds(358, 261, 23, 14);
		panel_1.add(lblFax);
		
		textFieldFax = new JTextField();
		textFieldFax.setColumns(10);
		textFieldFax.setBounds(402, 253, 157, 30);
		panel_1.add(textFieldFax);
		
		JLabel labelResult = new JLabel("");
		labelResult.setBounds(201, 377, 186, 16);
		panel_1.add(labelResult);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldFirstName.setText("");
				textFieldLastName.setText("");
				textFieldEmailId.setText("");
				textFieldPhNumber.setText("");
				textFieldGender.setText("");
				textFieldAge.setText("");
				textFieldAddress.setText("");
				textFieldFax.setText("");
				labelResult.setText("");
			}
		});
		btnClear.setBackground(new Color(192, 192, 192));
		btnClear.setIcon(new ImageIcon(CustemerFrontEnd.class.getResource("/Icons/Clear-icon.png")));
		btnClear.setBounds(271, 323, 110, 30);
		panel_1.add(btnClear);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Custemer custemer=new Custemer();
				custemer.setFirstName(textFieldFirstName.getText());
				custemer.setLastName(textFieldLastName.getText());
				custemer.setEmailId(textFieldEmailId.getText());
				custemer.setPhNumber(textFieldPhNumber.getText());
				custemer.setGender(textFieldGender.getText());
				custemer.setAge(textFieldAge.getText());
				custemer.setAddress(textFieldAddress.getText());
				custemer.setFax(textFieldFax.getText());
				
				CustemerDAO custemerDAO=new CustemerDAO();
				int status=custemerDAO.save(custemer);
				if(status>0){
					labelResult.setText("Custemer uploaded successfully");
				}else{
					labelResult.setText("Failed to upload");
				}
				
			}
		});
		btnUpload.setBackground(new Color(192, 192, 192));
		btnUpload.setIcon(new ImageIcon(CustemerFrontEnd.class.getResource("/Icons/upload-icon.png")));
		btnUpload.setBounds(135, 323, 110, 30);
		panel_1.add(btnUpload);
		
		JButton btnNewButton = new JButton("Show Custemer");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowCustomer showCustomer=new ShowCustomer();
				showCustomer.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(CustemerFrontEnd.class.getResource("/Icons/Programming-Show-Property-icon.png")));
		btnNewButton.setBounds(402, 323, 157, 30);
		panel_1.add(btnNewButton);
		
		
	}
}
