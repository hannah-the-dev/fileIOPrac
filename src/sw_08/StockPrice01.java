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
		
		int k21_cnt = 0;		// 실행카운터
		int k21_wcnt = 0;		// 작성행카운터 
		
		while((k21_readtxt = k21_br.readLine()) != null) {					// 해당 줄이 비었을때 while종료
			// string buffer 사용 선언
			// string buffer: append 하더라도 객체 생성1회. String 대비 자료형은 무거워 메모리 사용량, 속도에서 불리
			StringBuffer k21_s = new StringBuffer();						
			String[] k21_field = k21_readtxt.split("%_%");				// %_%를 구분자로 텍스트 분리
			
			// 구분자로 구분된 항목이 2개 이상되는 행에 한해서, 3번째 항목의 ^ 문자와 앞뒤 공백을 제거한 첫번째 글자가
			// A와 같을 경우(항목 단축코드 A******) ^ 문자와 앞뒤 공백을 제거한 첫번째 항목을 문자열에 추가함
			if(k21_field.length > 2 && k21_field[2].replace("^","").trim().substring(0,1).equals("A")) {
				k21_s.append(k21_field[0].replace("^", "").trim());
				for (int j = 1; j < k21_field.length; j++) {		// 1~필드 길이를 인덱스로
					// 문자열에 ^ 문자와 앞뒤 공백을 제거한 각 항목을 , 로 연결하여 추가함
					k21_s.append(","+k21_field[j].replace("^", "").trim());	
				}
				k21_bw.write(k21_s.toString());		// 버퍼 라이터로 완성된 문자열 쓰기
				k21_bw.newLine();					// 개행
				k21_wcnt ++;						// 행 카운터 1 증가
//				System.out.printf("writing [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			k21_cnt ++;		//실행카운터 1증가
		}
		k21_br.close();		// 버퍼 리더 닫기
		k21_bw.close();		// 버퍼 라이터 닫기
		
		System.out.printf("Program end[%d][%d]records", k21_cnt, k21_wcnt);	// 프로그램 종료시 실행수와 작성 행 수 출력
	}
}
