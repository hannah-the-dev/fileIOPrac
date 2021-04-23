package sw_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderEx1 {
	public static void FileWrite() throws IOException { // try/catch 대신 throw 사용
		File k21_file = new File("C:\\Users\\kopo21\\Desktop\\Mytest.txt"); // 쓸 파일 선언	
		BufferedWriter k21_bw = new BufferedWriter(new FileWriter(k21_file)); // 버퍼라이터 사용 선언
		
		k21_bw.write("안녕 파일");					// 문장 작성
		k21_bw.newLine();							// 개행 처리
		k21_bw.write("Hello 헬로");	
		k21_bw.newLine();
		k21_bw.close();								// 라이터 닫기
	}
	
	public static void FileRead() throws IOException {
		File k21_file = new File("C:\\Users\\kopo21\\Desktop\\Mytest.txt");	// 읽을 파일 선언
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_file)); // 버퍼 리더 사용 선언
		
		String k21_readtxt;				// 한 줄로 읽을 문자를 저장할 변수
		while ((k21_readtxt = k21_br.readLine()) != null) {	// 상기 변수 선언, 해당 줄이 있을 경우 반복
			System.out.printf("%s\n", k21_readtxt);	// 해당 줄 출력
		}	
		k21_br.close();		// reader 닫기
	}

	public static void main(String[] args) throws IOException { 
		// TODO Auto-generated method stub
		FileWrite();				//FileWrite() 함수 호출 
		FileRead();					//FileRead() 함수 호출
	}
}