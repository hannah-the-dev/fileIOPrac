package sw_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StockPrice01 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String k21_dir = "C:\\Users\\kopo21\\Desktop\\DailyStockPrice\\";  // 디렉토리 선언
		String k21_fileName= "THTSKS010H00.dat";							// 읽을 파일 이름 선언
		File k21_file = new File(k21_dir+k21_fileName);						// 읽을 파일 선언(디렉토리+파일이름)
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_file)); // 버퍼 리더 사용 선언
	
		String k21_fileOutName = "StockDailyPrice.csv";						// 쓸 파일이름 선언
		File k21_fileOut = new File(k21_dir+k21_fileOutName);				// 쓸 파일 선언
		BufferedWriter k21_bw = new BufferedWriter(new FileWriter(k21_fileOut)); // 버퍼 리더 사용 선언
		
		String k21_readtxt;			// 임시 저장할 텍스트 선언
		
		int k21_cnt = 0;		// 
		int k21_wcnt = 0;
		
		while((k21_readtxt = k21_br.readLine()) != null) {
			StringBuffer k21_s = new StringBuffer();
			String[] k21_field = k21_readtxt.split("%_%");
			
			if(k21_field.length > 2 && k21_field[2].replace("^","").trim().substring(0,1).equals("A")) {
				k21_s.append(k21_field[0].replace("^", "").trim());
				for (int j = 1; j < k21_field.length; j++) {
					k21_s.append(","+k21_field[j].replace("^", "").trim());
				}
				k21_bw.write(k21_s.toString());
				k21_bw.newLine();
				k21_wcnt ++;
//				System.out.printf("writing [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			k21_cnt ++;
		}
		k21_br.close();
		k21_bw.close();
		
		System.out.printf("Program end[%d][%d]records", k21_cnt, k21_wcnt);
	}
}
