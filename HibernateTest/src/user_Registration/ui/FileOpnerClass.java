package user_Registration.ui;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

public class FileOpnerClass {
	
	JFileChooser jFileChooser=new JFileChooser();
	//StringBuilder sb=new StringBuilder();
	
	public File pick_me() throws FileNotFoundException{
		
		File file=null;
		if(jFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			
			 file=jFileChooser.getSelectedFile();
			/*Scanner input=new Scanner(file);
			
			while(input.hasNext()){
				
				sb.append(input.nextLine());
				sb.append("\n");
				
			}
			input.close();*/
			
		}/*else{
			
			//sb.append("No file is selected");
			
		}*/
		return file;
		
	}

}
