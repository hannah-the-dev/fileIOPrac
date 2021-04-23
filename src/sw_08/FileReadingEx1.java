package sw_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadingEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 파일 변수 생성 및 파일 패스 설정
		File k21_file = new File("C:\\Users\\kopo21\\Desktop\\Mytest.txt");	
//		File file1 = new File("C:\\Users\\kopo21\\Desktop\\Mytest1.txt");
		try {			// file을 다룰 때는 오류에 대비해 catch/throw가 필수적
			FileWriter k21_fw = new FileWriter(k21_file);	// 파일 라이터 사용 선언
			k21_fw.write("안녕 파일\n");				// 문장 작성
			k21_fw.write("Hello 헬로\n");
			k21_fw.close();								// 라이터 닫기(다중 사용 프로그램은 필수)
			
			FileReader k21_fr = new FileReader(k21_file);	// 파일 리더 사용 선언
			int k21_n = -1;								// 파일 리더 리턴값 초기화
			char[] k21_ch;								// char 배열 생성
			
			while (true) {
				k21_ch = new char[100];					// 100 단위로 읽기위해 배열 초기화
				k21_n = k21_fr.read(k21_ch);					// 읽었을 때: 캐릭터 수, 내용이 없을 경우 -1 
				
				if (k21_n == -1)	break;				// 읽을 내용이 없을 경우 종료
				
				for(char k21_c : k21_ch) {					// char 배열에 담긴 char c 하나씩
					System.out.printf("%c", k21_c);		// c 자신 출력
				}
			}
			
			k21_fr.close();								// fr 닫기
			System.out.printf("\n FILE READ END");	
		
			// 파일을 쓸 권한이 없거나 읽는 파일이 없을 경우
		} catch (FileNotFoundException k21_e) {
			System.out.printf("파일을 읽고 쓸 권한이 없거나 없는 파일입니다.\n");
			k21_e.printStackTrace();	// 오류 문구 출력
			
			// 기타 오류 발생시
		} catch (IOException k21_e) {
			System.out.printf("다음의 에러가 발생했습니다.");
			k21_e.printStackTrace();	// 오류 문구 출력
		}
	}
}
