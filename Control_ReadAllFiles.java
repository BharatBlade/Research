import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Control_ReadAllFiles {
	
	public static FileReader fr;
	public static BufferedReader br;
	public static String pID = "0000032934018973b4960980cef29feeb76cdaff";
	public static String delim = "\",\"";
	
	public static void main(String[]args) throws Exception {
		String dir = "D:\\TriNetX_Data\\CT_20210830\\2021-08-30\\";
		miniHelper(	dir + "patient.csv"                                                 );
		helper(		  dir + "diagnosis\\diagnosis.csv.gz_0_", 						            7, 2);
		helper(		  dir + "lab_result\\lab_result.csv.gz_0_", 						          7, 4);
		helper(		  dir + "VITALS_SIGNS\\VITALS_SIGNS.csv.gz_0_", 					        7, 1);
		helper(		  dir + "encounter\\encounter.csv.gz_0_", 						            7, 3);
		miniHelper(	dir + "genomic.csv"                                                 );
		helper(		  dir + "medication_drug\\medication_drug.csv.gz_0_", 			      7, 3);
		helper(		  dir + "medication_ingredient\\medication_ingredient.csv.gz_0_", 7, 17);
		helper(		  dir + "procedure\\procedure.csv.gz_0_", 						            7, 2);
	}
	
  //for loops to go through control data which are split into multiple parts, for example "<filename>_0_0_0.csv","<filename>_0_0_1.csv", etc 
	public static void helper(String filePrefix, int x, int y) throws Exception{
		for(int i = 0; i <= x; i++) {
			for(int j = 0; j <= y; j++) {
				miniHelper(filePrefix + i + "_" + j + ".csv");
			}
		}
	}
	
  //Opens file, skips header, reads file line by line. If any part of a line contains the patient ID (pID) specified above, the line will be printed
	public static void miniHelper(String file) throws Exception{
		File f = new File(file);
		openReader(f);
		skipHeader();
		String line = br.readLine();
		while(line != null) {
			if(line.contains(pID)) {
				System.out.println("FOUND: " + line);
			}
			line = br.readLine();
		}
		closeReader();
	}
		
	public static void skipHeader() throws Exception {
		br.readLine();
	}
	public static BufferedReader openReader(File f) throws Exception {
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		return br;
	}
	public static void closeReader () throws Exception {
		fr.close();
		br.close();
	}
}
