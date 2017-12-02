package billPrinting;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author All Open source developers
 * @version 1.0.0.0
 * @since 2014/12/22
 */
/*This Printsupport java class was implemented to get printout.
* This class was specially designed to print a Jtable content to a paper.
* Specially this class formated to print 7cm width paper.
* Generally for pos thermel printer.
* Free to customize this source code as you want.
* Illustration of basic invoice is in this code.
* demo by gayan liyanaarachchi
 
 */

public class BillPrinting {
 
         static JTable itemsTable;
         public static  int total_item_count=0;
         public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss a";
         public  static String title[] = new String[] {"Quantity","","Name","Price"};
	
public static void setItems(Object[][] printitem){
        Object data[][]=printitem;
        DefaultTableModel model = new DefaultTableModel();
       //assume jtable has 4 columns.
        model.addColumn(title[0]);
        model.addColumn(title[1]);
        model.addColumn(title[2]);
        model.addColumn(title[3]);
        

        int rowcount=printitem.length;
        
        addtomodel(model, data, rowcount);
       

        itemsTable = new JTable(model);
}

public static void addtomodel(DefaultTableModel model,Object [][]data,int rowcount){
        int count=0;
        while(count < rowcount){
         model.addRow(data[count]);
         count++;
        }
        if(model.getRowCount()!=rowcount)
          addtomodel(model, data, rowcount);
        
        System.out.println("Check Passed.");
}
          
public Object[][] getTableData (JTable table) {
    int itemcount=table.getRowCount();
    System.out.println("Item Count:"+itemcount);
    
    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
    int nRow = dtm.getRowCount(), nCol =dtm.getColumnCount();
    Object[][] tableData = new Object[nRow][nCol];
    if(itemcount==nRow)                                        //check is there any data loss.
    {
    for (int i = 0 ; i < nRow ; i++){
        for (int j = 0 ; j < nCol ; j++){
            tableData[i][j] = dtm.getValueAt(i,j);           //pass data into object array.
            }}
     if(tableData.length!=itemcount){                      //check for data losses in object array
     getTableData(table);                                  //recursively call method back to collect data
     }   
    System.out.println("Data check passed");
    }
    else{
                                                           //collecting data again because of data loss.
   getTableData(table);
   }
   return tableData;                                       //return object array with data.
    }     

public static PageFormat getPageFormat(PrinterJob pj){
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();    
             
                double middleHeight =total_item_count*1.0;  //dynamic----->change with the row count of jtable
                double headerHeight = 5.0;                  //fixed----->but can be mod
        	double footerHeight = 5.0;                  //fixed----->but can be mod
                
                double width = convert_CM_To_PPI(7);      //printer know only point per inch.default value is 72ppi
        	double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
            paper.setSize(width, height);
            paper.setImageableArea(
                            convert_CM_To_PPI(0.25), 
                            convert_CM_To_PPI(0.5), 
                            width - convert_CM_To_PPI(0.35), 
                            height - convert_CM_To_PPI(1));   //define boarder size    after that print area width is about 180 points
            
            pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
            pf.setPaper(paper);    
            
            return pf;
}
        
        
protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}

protected static double toPPI(double inch) {            
	        return inch * 72d;            
}

public static String now() {
//get current date and time as a String output   
Calendar cal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
return sdf.format(cal.getTime());

}

public static class MyPrintable implements Printable {
 @Override
  public int print(Graphics graphics, PageFormat pageFormat, 
	                int pageIndex) throws PrinterException {    
	                int result = NO_SUCH_PAGE;    
	                if (pageIndex == 0) {                    
	                Graphics2D g2d = (Graphics2D) graphics;                    
	                             
	                double width = pageFormat.getWidth();
	                double height = pageFormat.getImageableHeight(); 
	               // System.out.println("Width is =: "+width);
	                g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 
	                Font font = new Font("Monospaced",Font.PLAIN,7);       
	                g2d.setFont(font);
                       
	                
	                try {
	        	/*
                         * Draw Image*
                           assume that printing reciept has logo on top 
                         * that logo image is in .gif format .png also support
                         * image resolution is width 100px and height 50px
                         * image located in root--->image folder 
                         */
                                    int x=0 ;                                        //print start at 100 on x axies
                                    int y=10;                                          //print start at 10 on y axies
                                    int imagewidth=140;
                                    int imageheight=50;
                          BufferedImage read = ImageIO.read(getClass().getResource("/Icons/apsys-solutions-logo.png"));
                          g2d.drawImage(read,x,y,imagewidth,imageheight,null);         //draw image
                          g2d.drawLine(10, y+60, 140, y+60);                          //draw line
                                 } catch (IOException e) {
	        			e.printStackTrace();
	        		}
      		try{
	        /*Draw Header*/
                    int y=80;
	              g2d.drawString("Apsys Inventory ", 40,y);  
	              g2d.drawString("CopyWrite 2010-2017", 30,y+10);                 //shift a line by adding 10 to y value
	              g2d.drawString(now(), 10, y+20);                                //print date
	              g2d.drawString("Cashier : Admin", 10, y+30);
	              g2d.drawString("Bill No : "+BillingFrontEnd.billNumber, 10, y+40);
	        		
	              /*Draw Colums*/
                      g2d.drawLine(10, y+50, 140, y+50);
                      g2d.drawString(title[0], 10 ,y+60);
                      g2d.drawString(title[1], 35 ,y+60);
                      g2d.drawString(title[2], 60 ,y+60);
                      g2d.drawString(title[3], 105 ,y+60);
                      g2d.drawLine(10, y+70, 140, y+70);
                   
	              int cH = 0;
	              TableModel mod = itemsTable.getModel();
                        double total =0.0;
                        int PriceCountInt=0;
                        for(int i = 0;i < mod.getRowCount() ; i++){
                            double price =Double.parseDouble(mod.getValueAt(i, 3).toString()) ;
                            String priceCount=Double.toString(price);
                            if(priceCount.length()>PriceCountInt){
                            PriceCountInt=priceCount.length();
                            }
                        }
                        DecimalFormat df = new DecimalFormat("##.00");

	              for(int i = 0;i < mod.getRowCount() ; i++){
	                	/*Assume that all parameters are in string data type for this situation
                                 * All other premetive data types are accepted.
                                */
	                	String itemid = mod.getValueAt(i, 0).toString();
	                	String itemname = mod.getValueAt(i, 2).toString();
                                double price =Double.parseDouble(mod.getValueAt(i, 3).toString()) ;
                                String quantity = mod.getValueAt(i, 1).toString();
                                total+=price*Double.parseDouble(quantity);
                                
	                	
	                	cH = (y+80) + (10*i);                             //shifting drawing line
	                	System.out.println("cH : "+cH);
	                	g2d.drawString(quantity, 15, cH);
	                	g2d.drawString("",35, cH);
	                	g2d.drawString(itemname , 60, cH);
	                	int space=Math.abs(PriceCountInt-Double.toString(price).length())*5;
                       // System.out.println("PriceCountInt : "+PriceCountInt+" Currnt length : "+Double.toString(price).length()+" Space is : "+space);
                        g2d.drawString(df.format(price), 95+space, cH);
                              
	                }
 
	                /*Footer*/
	                font = new Font("Arial",Font.BOLD,11) ;                  //changed font size
	               // g2d.setFont(font);
	                g2d.drawLine(10, cH+10, 140, cH+10);
	                g2d.drawString("Total :", 60, cH+20);
	                g2d.drawString(df.format(total), 95, cH+20);
	                g2d.setFont(font);
	                g2d.drawString("Grand Total :", 10, cH+35);
	                g2d.drawString(df.format(Math.round(total)), 80, cH+35);
                    g2d.drawString("Thank You Come Again",5, cH+45);
                                                                                 //end of the reciept
            }
            catch(Exception r){
              r.printStackTrace();
            }
  
	                result = PAGE_EXISTS;    
	            }    
	            return result;    
      }
   }
         
}
