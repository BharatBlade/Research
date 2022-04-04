import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeSet;
public class ADHDIngredient {
	public static void main(String[]args) throws Exception {
		int [] rxcui = {2599, 40114, 42347, 725, 3288, 6901, 30125, 38400, 700810}; String dir = "/run/media/mm/Easystore/Research/ATC/ADHD/";
		String [] drug = {"clonidine", "guanfacine", "bupropion", "amfetamine", "dexamfetamine", "methylphenidate", "modafinil", "atomoxetine", "lisdexamfetamine"};
		File [] out = new File[drug.length];
		for(int i = 0; i < drug.length; i++) {out[i] = new File(dir + drug[i] + ".csv");}
		FileReader fr = new FileReader(new File("/run/media/mm/Easystore/Research/Original/medication_ingredient.csv")); BufferedReader br = new BufferedReader(fr);
		FileWriter [] fws = new FileWriter[out.length];BufferedWriter [] bws = new BufferedWriter[out.length];
		for(int i = 0; i < out.length; i++) {fws[i] = new FileWriter(out[i]);bws[i] = new BufferedWriter(fws[i]);}
		br.readLine();
		String line = br.readLine(); int count = 0; long time = System.currentTimeMillis(); long time2 = System.currentTimeMillis();
		while(line != null) {
			String line2 = line.substring(line.indexOf("RxNorm"));
			line2 = line2.substring(line2.indexOf("\",\"")+3);
			line2 = line2.substring(0, line2.indexOf("\",\""));
			try {
				int rx = Integer.valueOf(line2);
				for(int i = 0; i < rxcui.length; i++) {
					if(rx == rxcui[i]) {bws[i].write(line + "\n");bws[i].flush();break;}
				}
				count++;
			} catch (Exception e) {if(!line2.contains("OMOP")){System.out.println(line);}}
			if(count % 1000000 == 0) {
				System.out.println(count + "\t" + (System.currentTimeMillis() - time2) + "\t" + (System.currentTimeMillis() - time));time2 = System.currentTimeMillis();
			}
			line = br.readLine();
		}
		for(int i = 0; i < out.length; i++) {bws[i].flush();bws[i].close();fws[i].close();}
		br.close(); fr.close();
	}
}
