package user_Registration.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import user_Registration.bean.User;
import user_Registration.dao.UserMain;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

public class UserLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginFrame frame = new UserLoginFrame();
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
	public UserLoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240,52,52));
		panel.setBounds(0, 0, 178, 435);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setBounds(10, 114, 158, 142);
		panel.add(imagelabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(241, 169, 160));
		panel_1.setBounds(178, 0, 629, 435);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setBounds(288, 59, 51, 22);
		panel_1.add(lblLogin);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(178, 123, 70, 14);
		panel_1.add(lblUserName);
		
		JLabel lblId = new JLabel("Id :");
		lblId.setBounds(231, 183, 17, 14);
		panel_1.add(lblId);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				Session session=UserMain.getSession();
				Criteria criteria=session.createCriteria(User.class);
				SimpleExpression se=Restrictions.eq("userName", textField.getText());
				User user=(User) criteria.add(se).uniqueResult();
				byte[] userImage= user.getImage();
				Image image=Toolkit.getDefaultToolkit().createImage(userImage);
				ImageIcon imageIcon=new ImageIcon(image);
				imagelabel.setIcon(imageIcon);
				
			}
		});
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		textField.setBounds(258, 116, 180, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(258, 180, 180, 28);
		panel_1.add(textField_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				
				Session session=UserMain.getSession();
				Query query=session.createQuery("select u.userName,u.image from User u where id="+textField_1.getText());
				//SQLQuery query= session.createSQLQuery("SELECT * FROM user ");
				
				List list=query.list();
				Iterator iterator=list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					
					System.out.println("User Name : "+obj[0]);
				}
				
			}
		});
		btnLogin.setBounds(308, 247, 89, 36);
		panel_1.add(btnLogin);
	}
}
