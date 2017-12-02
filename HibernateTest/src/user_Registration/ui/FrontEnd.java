package user_Registration.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import user_Registration.bean.Address;
import user_Registration.bean.User;
import user_Registration.dao.UserMain;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class FrontEnd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5685170063435822490L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblPassword;
	private JLabel lblEmail;
	private JTextField textField_3;
	private JLabel lblCountry;
	private JLabel imageLabel;
	File file;
	private JLabel labelStatu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontEnd frame = new FrontEnd();
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
	public FrontEnd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setBounds(0, 0, 235, 454);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//imageLabel = new JLabel("");
		//imageLabel.setBounds(50, 92, 133, 106);
		//panel.add(imageLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 192, 203));
		panel_1.setBounds(235, 0, 581, 454);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(256, 81, 164, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(256, 134, 164, 28);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(256, 190, 164, 28);
		panel_1.add(textField_2);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(191, 84, 46, 14);
		panel_1.add(lblName);
		
		lblPassword = new JLabel("Street :");
		lblPassword.setBounds(191, 137, 46, 14);
		panel_1.add(lblPassword);
		
		lblEmail = new JLabel("City :");
		lblEmail.setBounds(200, 193, 46, 14);
		panel_1.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(256, 243, 164, 28);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		lblCountry = new JLabel("Country :");
		lblCountry.setBounds(176, 246, 61, 14);
		panel_1.add(lblCountry);
		
		JButton btnNewButton = new JButton("Add Image");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FileOpnerClass fileOpnerClass=new FileOpnerClass();
				try {
					file= fileOpnerClass.pick_me();
					String sname=file.getAbsolutePath();
					//System.out.println("Path : "+sname);
					imageLabel = new JLabel("", new ImageIcon(sname), JLabel.CENTER);
					imageLabel.setBounds(50, 92, 133, 106);
	                panel.add(imageLabel, BorderLayout.CENTER);
	                panel.revalidate(); //ADD THIS AS WELL
	                panel.repaint();  //ADD THIS AS WELL
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				//imageLabel.setText(fileOpnerClass.sb.toString());
				
			}
		});
		btnNewButton.setBounds(256, 298, 164, 28);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				byte[] imageData = new byte[(int) file.length()];
				 
				try {
				    FileInputStream fileInputStream = new FileInputStream(file);
				    fileInputStream.read(imageData);
				    fileInputStream.close();
				} catch (Exception e) {
				    e.printStackTrace();
				}
				
				String name=textField.getText();
				String street=textField_1.getText();
				String city=textField_2.getText();
				String country=textField_3.getText();
				
				Session session=UserMain.getSession();
				Transaction transaction=session.beginTransaction();
				
				User user=new User();
				user.setUserName(name);
				user.setImage(imageData);
				
				Address address=new Address();
				address.setCity(city);
				address.setStreet(street);
				address.setCountry(country);
				address.setUser(user);
				
				user.setAddress(address);
				
				session.save(user);
				transaction.commit();
				boolean status=transaction.wasCommitted();
				
				if(status){
					labelStatu.setText("Registered Successfully...");
				}else{
					labelStatu.setText("Registration Failed...");
				}
				
				session.close();
				
			}
		});
		btnNewButton_1.setBounds(256, 349, 164, 28);
		panel_1.add(btnNewButton_1);
		
		labelStatu = new JLabel("");
		labelStatu.setBounds(266, 400, 154, 28);
		panel_1.add(labelStatu);
	}
}
