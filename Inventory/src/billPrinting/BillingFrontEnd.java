package billPrinting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BillingFrontEnd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 646944446926082670L;
	private JPanel contentPane;
	private JTextField BillNotextField;
	private JTextField CnametextField;
	private JTextField PnametextField;
	private JTextField MRPtextField;
	private JTextField QuantitytextField;
	private JTable Jtable;
	static String billNumber=null;
	JComboBox<String> PrintSettingscomboBox = new JComboBox<String>();
	JLabel lblNewLabel_2 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillingFrontEnd frame = new BillingFrontEnd();
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
	public BillingFrontEnd() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
                
		        for (PrintService printer : printServices)
		           // System.out.println("Printer: " + printer.getName()); 
		        PrintSettingscomboBox.addItem(printer.getName());
		            
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Invoice Printing");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(356, 11, 137, 28);
		contentPane.add(lblNewLabel);
		
		BillNotextField = new JTextField();
		BillNotextField.setBounds(144, 72, 125, 20);
		contentPane.add(BillNotextField);
		BillNotextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Custemer Name :");
		lblNewLabel_1.setBounds(0, 114, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		CnametextField = new JTextField();
		CnametextField.setBounds(144, 111, 125, 20);
		contentPane.add(CnametextField);
		CnametextField.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product ID :");
		lblProductId.setBounds(28, 150, 70, 14);
		contentPane.add(lblProductId);
		
		JLabel lblPName = new JLabel("P Name :");
		lblPName.setBounds(40, 187, 58, 14);
		contentPane.add(lblPName);
		
		PnametextField = new JTextField();
		PnametextField.setBounds(144, 184, 125, 20);
		contentPane.add(PnametextField);
		PnametextField.setColumns(10);
		
		JLabel lblMrp = new JLabel("MRP :");
		lblMrp.setBounds(58, 223, 40, 14);
		contentPane.add(lblMrp);
		
		MRPtextField = new JTextField();
		MRPtextField.setBounds(144, 220, 125, 20);
		contentPane.add(MRPtextField);
		MRPtextField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(37, 264, 61, 14);
		contentPane.add(lblQuantity);
		
		QuantitytextField = new JTextField();
		QuantitytextField.setBounds(144, 261, 125, 20);
		contentPane.add(QuantitytextField);
		QuantitytextField.setColumns(10);
		JComboBox<Object> PidcomboBox = new JComboBox<Object>();

		lblNewLabel_2.setBounds(626, 18, 106, 16);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model =(DefaultTableModel) Jtable.getModel();
			    
                String s2= QuantitytextField.getText();//quantity
                String s1=MRPtextField.getText(); //mrp
                //String s3=jTextField6.getText();
                //int d=Integer.parseInt(s3);
                double a=Double.parseDouble(s1);
                double b;
                 b = Double.parseDouble(s2); 
                double c = a * b;
                //int e = c -((d/100)*c);
                String result=String.valueOf(c);
                model.addRow(new Object[]{PidcomboBox.getSelectedItem(),QuantitytextField.getText(),PnametextField.getText(),MRPtextField.getText(),result});
   		}
		});
		btnAdd.setIcon(new ImageIcon(BillingFrontEnd.class.getResource("/Icons/07_plus-20.png")));
		btnAdd.setBounds(58, 314, 89, 36);
		contentPane.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model =(DefaultTableModel) Jtable.getModel();
	            model.removeRow(Jtable.getSelectedRow());
	    
			}
		});
		btnRemove.setIcon(new ImageIcon(BillingFrontEnd.class.getResource("/Icons/del.png")));
		btnRemove.setBounds(155, 314, 114, 36);
		contentPane.add(btnRemove);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(583, 20, 46, 14);
		contentPane.add(lblDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(273, 302, 537, -234);
		contentPane.add(scrollPane);
		
		PidcomboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2", "3"}));
		PidcomboBox.setBounds(144, 147, 125, 20);
		contentPane.add(PidcomboBox);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			//PrinterJob pj1 = PrinterJob.getPrinterJob();
			    PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
			    //System.out.println("Number of printers configured: " + printServices.length);
			    String printerType=(String) PrintSettingscomboBox.getSelectedItem();
			   /* for (PrintService printer : printServices) {
			        System.out.println("Printer: " + printer.getName()+"--- Selected Printer : "+printerType);
			        if (printer.getName().trim().equalsIgnoreCase(printerType.trim())) {
			            try {
			                pj1.setPrintService(printer);
			                System.out.println("Set");
			            } catch (PrinterException ex) {
			            }
			        }
			    }*/
				
				
				billNumber= BillNotextField.getText();
				System.out.println("printer type : "+printerType);
				if(printerType.equalsIgnoreCase("POS-58")){
				BillPrinting ps=new BillPrinting();
				 Object printitem [][]=ps.getTableData(Jtable);
				 BillPrinting.setItems(printitem);
				       
				 PrinterJob pj = PrinterJob.getPrinterJob();
				 pj.setPrintable(new BillPrinting.MyPrintable(),BillPrinting.getPageFormat(pj));
				 for (PrintService printer : printServices) {
				        //System.out.println("Printer: " + printer.getName()+"--- Selected Printer : "+printerType);
				        if (printer.getName().trim().equalsIgnoreCase(printerType.trim())) {
				            try {
				                pj.setPrintService(printer);
				                System.out.println("Page Width : "+pj.defaultPage().getWidth());
				                break;
				            } catch (PrinterException ex) {
				            }
				        }
				    }				       try {
				            pj.print();
				            }
				        catch (PrinterException ex) {
				                ex.printStackTrace();
				            }
				}else if(printerType.equalsIgnoreCase("RICOH SP 111 DDST")){
					BillPrintingForA4Sheet ps=new BillPrintingForA4Sheet();
					 Object printitem [][]=ps.getTableData(Jtable);
					 BillPrintingForA4Sheet.setItems(printitem);
					 
					 PrinterJob pj = PrinterJob.getPrinterJob();
					 pj.setPrintable(new BillPrinting.MyPrintable(),BillPrinting.getPageFormat(pj));
					 for (PrintService printer : printServices) {
					        //System.out.println("Printer: " + printer.getName()+"--- Selected Printer : "+printerType);
					        if (printer.getName().trim().equalsIgnoreCase(printerType.trim())) {
					            try {
					                pj.setPrintService(printer);
					                System.out.println("Page Width : "+pj.defaultPage().getWidth());
					                break;
					            } catch (PrinterException ex) {
					            	ex.printStackTrace();
					            }
					        }
					    }	
					       
					 pj.setPrintable(new BillPrintingForA4Sheet.MyPrintable(),BillPrintingForA4Sheet.getPageFormat(pj));
					       try {
					            pj.print();
					           
					            }
					        catch (PrinterException ex) {
					                ex.printStackTrace();
					            }
				}else{
					BillPrintingForA4Sheet ps=new BillPrintingForA4Sheet();
					 Object printitem [][]=ps.getTableData(Jtable);
					 BillPrintingForA4Sheet.setItems(printitem);
					 
					 PrinterJob pj = PrinterJob.getPrinterJob();
					 pj.setPrintable(new BillPrinting.MyPrintable(),BillPrinting.getPageFormat(pj));
					 for (PrintService printer : printServices) {
					        //System.out.println("Printer: " + printer.getName()+"--- Selected Printer : "+printerType);
					        if (printer.getName().trim().equalsIgnoreCase(printerType.trim())) {
					            try {
					                pj.setPrintService(printer);
					              //  System.out.println("Page Width : "+pj.defaultPage().getWidth());
					                break;
					            } catch (PrinterException ex) {
					            	ex.printStackTrace();
					            }
					        }
					    }	
					       
					 pj.setPrintable(new BillPrintingForA4Sheet.MyPrintable(),BillPrintingForA4Sheet.getPageFormat(pj));
					       try {
					            pj.print();
					           
					            }
					        catch (PrinterException ex) {
					                ex.printStackTrace();
					            }
					//JOptionPane.showMessageDialog(null, "Please Select a valid Printer Type");
				}
			}
		});
		btnPrint.setIcon(new ImageIcon(BillingFrontEnd.class.getResource("/Icons/print.png")));
		btnPrint.setBounds(522, 314, 119, 36);
		contentPane.add(btnPrint);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(279, 66, 531, 237);
		contentPane.add(scrollPane_1);
		
		Jtable = new JTable();
		Jtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "Quantity", "Product Name", "MRP", "Total Price"
			}
		));
		scrollPane_1.setViewportView(Jtable);
		
		JLabel lblBillNo = new JLabel("Bill No :");
		lblBillNo.setBounds(48, 75, 58, 14);
		contentPane.add(lblBillNo);
		
		PrintSettingscomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Printer"}));
		PrintSettingscomboBox.setBounds(678, 314, 132, 36);
		contentPane.add(PrintSettingscomboBox);
		showdate();
		
		
	}
	
	public void showdate()
    {
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      lblNewLabel_2.setText(format.format(new Date()));
        
    }
}
