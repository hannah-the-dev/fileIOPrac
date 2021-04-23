package sw_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Wifi {

	public static void main(String[] args) throws IOException {
		// 파일 선언
		File k21_file = new File("C:\\Users\\kopo21\\Desktop\\전국무료와이파이표준데이터(en).csv");	
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_file)); // 버퍼 리더 사용 선언
		
		String k21_readtxt;				// 한 줄로 읽을 문자를 저장할 변수
		
		if((k21_readtxt = k21_br.readLine()) == null) {  // 첫줄이 비었을 경우, 
			System.out.printf("빈 파일입니다.\n");		 // 문구 출력후 프로그램 종료
			return;
		}
		String[] k21_field_name = k21_readtxt.split(",");	// 첫줄을 , 로 분리해 field name array에 저장
		
		int k21_LineCnt = 0;								// 줄 수 카운터 변수 선언 

		while((k21_readtxt = k21_br.readLine()) != null){	// 해당줄이 비었다면 실행 안됨
			String[] k21_field = k21_readtxt.split(",");	// 해당 줄을 , 로 분리해 field array에 저장
			// 0번째 줄부터 줄 수 및 구분 선 인쇄
			System.out.printf("**[%03d번째 항목]***************************************\n", k21_LineCnt);
			// 타이틀의 개수만큼 반복하며 각 줄에 항목 명 및 내용 출력 
			for (int k21_j = 0; k21_j < k21_field_name.length; k21_j++) {
				System.out.printf(" %s: %s\n", k21_field_name[k21_j], k21_field[k21_j]);
			}
			System.out.printf("*******************************************************\n");
			if(k21_LineCnt == 100) break;					// 101 번 읽고 종료
			k21_LineCnt++;									// 줄 수 카운터 변수에 1추가
		}
		k21_br.close();		// reader 닫기
	}
}
