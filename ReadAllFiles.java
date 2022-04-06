import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class ReadAllFiles {
	public static void main(String[]args) throws Exception{
		//The patientID and encounter ID being searched, and putting them in an array
		String patientID = "0009f485eb96da1ff5ea89e6cf2c6dd42f1ef85f"; String encounterID = "2c0f2374ddce7ff976fb6215e25e773fd716fbbb";
		String [] IDs = {patientID, encounterID};
		//The files in the ADHD set being searched
		String [] fileNames = {"diagnosis", "encounter", "genomic", "lab_result", "medication_drug", "medication_ingredient", "patient", "procedure", "vitals_signs"};
		//The output file being written to
		File out = new File("output.txt"); FileWriter fw = new FileWriter(out); BufferedWriter bw = new BufferedWriter(fw);
		//Going through each ID
		for(int a = 0; a < IDs.length; a++) {
			//bw.write just means writing the paramater to the file
			bw.write(IDs[a] + " is being searched now\n");
			//Going through each file
			for(int i = 0; i < fileNames.length; i++) {
				//Reading the next file in fileNames[]
				File f = new File("/run/media/mm/Easystore/Research/Original/" + fileNames[i] + ".csv"); FileReader fr = new FileReader(f);BufferedReader br = new BufferedReader(fr);
				bw.write(fileNames[i] + ".csv\n");
				//br.readLine() just reads the next line in the file being looked at
				bw.write(br.readLine() + "\n");
				StringBuilder line = new StringBuilder(br.readLine());
				//just a faster way in this specific case to say if line doesn't equal null
				while(line.length() != 4) {
					//if(line.indexOf() returns -1, then it means it's not in the line, so I'm checking if it's anything other than -1 to check if it's there
					if(line.indexOf(IDs[a]) != -1) {	bw.write(line + "\n");	}
					//Deletes data from line and moves onto the next line;
					line.setLength(0); line.append(br.readLine());
				}
				//Just to make sure everything is being written
				bw.flush();fw.flush();br.close();fr.close();
			}
		}
		bw.flush();fw.flush();bw.close();fw.close();
	}
}
