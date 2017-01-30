import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.plaf.FileChooserUI;
public class MDConverter {

	public static void main(String[] args) throws FileNotFoundException {
		 String line = "";
	       String cvsSplitBy = ",";
	       File fpath= null;
	       
			PrintWriter pw = new PrintWriter(new File("test.csv"));
		
           StringBuilder sb = new StringBuilder();
	       JFileChooser chooser = new JFileChooser();
	       chooser.setCurrentDirectory(new java.io.File("."));
	       chooser.setDialogTitle("choosertitle");
	       
	       chooser.setAcceptAllFileFilterUsed(false);

	       if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	         System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
	         System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
	         fpath = chooser.getSelectedFile();
	       } else {
	         System.out.println("No Selection ");
	       }
		
		 try (BufferedReader br = new BufferedReader(new FileReader(fpath))) {

	            while ((line = br.readLine()) != null) {

	                
	                String[] gyrate = line.split(cvsSplitBy);
	                double time = new Double(gyrate[0]);
	                if(time % 10 == 0 ) {
	                	
	                	
	                    sb.append(time/1000);
	                    sb.append(", ");
	                    sb.append(gyrate[1]);
	                    sb.append(System.getProperty("line.separator"));
//	                System.out.println(time/1000 + ", " + gyrate[1]);
	                }
	            }
	            pw.write(sb.toString());
	            pw.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }


	}

}
