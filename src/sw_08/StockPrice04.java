package sw_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StockPrice04 {

	// 삼성파일-> 15년도 총가 최대값 최소값 만들기
	// index 3 = 종가
	public static void main(String[] args) throws IOException {

//		String k21_dir = "C:\\Users\\kopo21\\Desktop\\DailyStockPrice\\";  // 디렉토리 선언
		String k21_dir = "D:\\sw08 data\\";  // 디렉토리 선언
		String k21_fileName= "A005930.csv";							// 읽을 파일 이름 선언
		File k21_file = new File(k21_dir+k21_fileName);						// 읽을 파일 선언(디렉토리+파일이름)
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_file)); // 버퍼 리더 사용 선언
	
		String k21_readtxt;			// 임시 저장할 텍스트 선언
		
		int k21_cnt = 0;			// 카운터
		
		long min = 0;				// 최저가 저장할 변수 생성
		long max = 0;				// 최고가 저장할 변수 생성
		
		while((k21_readtxt = k21_br.readLine()) != null) {				// 해당 줄이 비었을때 while종료
			if(k21_readtxt.split(",")[1].startsWith("2015")) {			// 2번째 항목이 2015로 시작하는 경우
				String[] readArray = k21_readtxt.split(",");			// split으로 쪼갠 스트링 배열 생성
				if(k21_cnt == 0) {										// 첫줄일경우
					min = Long.parseLong(readArray[3]);					// 최저가,
					max = Long.parseLong(readArray[3]);					// 최고가 해당 종가로 저장
				} else {												// 첫줄이 아닐경우
					min = Math.min(min, Long.parseLong(readArray[3])); 	// 기존 최저가과 해당 종가 비교하여 더 작은 값으로 저장 
					max = Math.max(max, Long.parseLong(readArray[3])); 	// 기존 최고가와 해당 종가 비교하여 더 큰 값으로 저장
				}
				k21_cnt++;			// 카운터 증가
			}
		}
			
		k21_br.close();		// 버퍼 리더 닫기
		System.out.printf("Min price: %d\nMax price: %d\n", min, max);	// 프로그램 종료시 작성 행 수 출력
	}
}

