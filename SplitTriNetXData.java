import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SplitTriNetXData {
	public static void main(String[]args) throws Exception{
		String [] fs = {"diagnosis", "genomic", "lab_result", "medication_drug", "medication_ingredient", "patient", "procedure", "vitals_signs"};
		for(int qq = 0; qq < fs.length; qq++) {
			String dir = "/run/media/mm/Easystore/Research/Original/"; String folder = "/run/media/mm/Easystore/Research/Split/" + fs[qq] + "/";
			char [] h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
			File f = new File(dir + fs[qq] + ".csv"); FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr);
			File [][] files = new File[16][16]; FileWriter [][] fw = new FileWriter[16][16]; BufferedWriter [][] bw = new BufferedWriter[16][16];
			String line = br.readLine();
			for(int i = 0; i < h.length; i++) {
				for(int j = 0; j < h.length; j++) {
					files[i][j] = new File(folder + h[i] + h[j] + ".csv"); fw[i][j] = new FileWriter(files[i][j]); bw[i][j] = new BufferedWriter(fw[i][j]);bw[i][j].write(line + "\n");bw[i][j].flush();
				}
			}
			int count = 0; long time = System.currentTimeMillis(); long time2 = System.currentTimeMillis();
			while(line != null) {
				//String line2 = line.substring(line.indexOf(",")+1); line2 = line2.substring(1, line2.indexOf("\","));
				char a = line.charAt(1); char b = line.charAt(2);
				for(int i = 0; i < h.length; i++) {if(a == h[i]) {
						for(int j = 0; j < h.length; j++) {if(b == h[j]) {
								bw[i][j].write(line + "\n"); bw[i][j].flush();
								count++; if(count % 1000000 == 0) {System.out.println(count + "\t" + (System.currentTimeMillis() - time) + "\t" + (System.currentTimeMillis() - time2));time = System.currentTimeMillis();}
								break;
						}}
						break;
				}}
				line = br.readLine();
			}
			for(int i = 0; i < files.length; i++) { for(int j = 0; j < files[i].length; j++) {bw[i][j].flush(); bw[i][j].close(); fw[i][j].close();}} br.close(); fr.close();
		}
	}
}
