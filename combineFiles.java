import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class combineFiles {
	public static void main(String[]args) throws Exception {
		char [] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f'};
		File [] files = new File[c.length];
		//File [] files = new File[c.length][c.length];
		for(int i = 0; i < c.length; i++) {
			//for(int j = 0; j < c.length; j++) {
				files[i] = new File(c[i] + ".txt");
				//files[i][j] = new File("" + c[i] + c[j] + ".txt");
			//}
		}
		
		File o = new File("encounters.txt");
		FileWriter fw = new FileWriter(o);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(int i = 0; i < files.length; i++) {
			FileReader fr = new FileReader(files[i]); BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line != null) {
				bw.write(line); bw.flush();
				line = br.readLine();
			}
			br.close();fr.close();
		}
		bw.flush();fw.flush();bw.close();fw.close();
	}
}
