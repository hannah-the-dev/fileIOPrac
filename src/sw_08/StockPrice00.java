package sw_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StockPrice00 {

	public static void main(String[] args) throws IOException {
		// 사용 파일 선언
		File k21_file = new File("C:\\Users\\kopo21\\Desktop\\DailyStockPrice\\THTSKS010H00.dat");	
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_file)); // 버퍼 리더 사용 선언
	
//		String readtxt;		사용하지 않는 변수
		int k21_LineCnt = 0;	// 줄 수 카운터
		int k21_n = -1;			// read 매서드 리턴 값 저장할 변수 초기화(=데이터 없음)
		StringBuffer k21_s = new StringBuffer();  // string buffer 사용 선언
		
		while(true) {					// break 만나기 전까지 계속 반복
			char[] k21_ch = new char[1000];	// 1000개 글자까지 검사
			k21_n = k21_br.read(k21_ch);			// 배열을 읽어서 수를 확인 
			if (k21_n == -1) break;			// n이 -1일 경우(데이터가 없을경우) break
			for (char k21_c : k21_ch) {			// ch 배열의 요소 c에 대해
				if(k21_c == '\n') {			// c가 개행문자이면
					System.out.printf("[%s]***\n", k21_s.toString()); // 지금까지 저장된 s 출력
					k21_s.delete(0, k21_s.length());	// s의 내용을 전체 지움
				} else {				// 개행문자가 아닐 경우,
					k21_s.append(k21_c);		//  s에 c 글자 추가
				}
			}
			k21_LineCnt += 10000;					// 줄 카운터 +1
		}
		System.out.printf("[%s]***\n", k21_s.toString());	// 마지막 데이터가 출력되지 않았으므로 출력
		k21_br.close();		// 버퍼 리더 닫기
	}
}
