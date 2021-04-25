package sw_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StockPrice03 {

	// 특정일자파일만들기
	public static void main(String[] args) throws IOException {

//		String k21_dir = "C:\\Users\\kopo21\\Desktop\\DailyStockPrice\\";  // 디렉토리 선언
		String k21_dir = "D:\\sw08 data\\";  // 디렉토리 선언
		String k21_fileName= "StockDailyPrice.csv";							// 읽을 파일 이름 선언
		File k21_file = new File(k21_dir+k21_fileName);						// 읽을 파일 선언(디렉토리+파일이름)
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_file)); // 버퍼 리더 사용 선언
	
		String k21_fileOutName = "20150112.csv";						// 쓸 파일이름 선언
		File k21_fileOut = new File(k21_dir+k21_fileOutName);				// 쓸 파일 선언
		BufferedWriter k21_bw = new BufferedWriter(new FileWriter(k21_fileOut)); // 버퍼 리더 사용 선언
		
		String k21_readtxt;			// 임시 저장할 텍스트 선언
		
		int k21_cnt = 0;		// 카운터
		
		while((k21_readtxt = k21_br.readLine()) != null) {					// 해당 줄이 비었을때 while종료
			if(k21_readtxt.split(",")[1].equals("20150112")) {		// 두번째 항목이 지정한 날짜와 같을 경우
					k21_bw.write(k21_readtxt);		// 버퍼 라이터로 해당 줄 입력
					k21_bw.newLine();					// 개행
					k21_cnt ++;		//카운터 1증가
			}
		}
		k21_br.close();		// 버퍼 리더 닫기
		k21_bw.close();		// 버퍼 라이터 닫기
		
		System.out.printf("Program end[%d]records", k21_cnt);	// 프로그램 종료시 작성 행 수 출력
	}
}