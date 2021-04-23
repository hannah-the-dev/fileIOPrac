package sw_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WifiClose {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 탭으로 구분되는 txt 파일로 파일 변경
		File k21_file = new File("C:\\Users\\kopo21\\Desktop\\전국무료와이파이표준데이터(entab).txt");	
		BufferedReader k21_br = new BufferedReader(new FileReader(k21_file)); // 버퍼 리더 사용 선언
		
		String k21_readtxt;				// 한 줄로 읽을 문자를 저장할 변수
		
		if((k21_readtxt = k21_br.readLine()) == null) {  // 첫줄이 비었을 경우, 
			System.out.printf("빈 파일입니다.\n");		 // 문구 출력후 프로그램 종료
			return;
		}
		String[] k21_field_name = k21_readtxt.split("\t");	// 첫줄을 탭으로 분리해 field name array에 저장
		
		double k21_lat = 37.3860521;						// 거리 확인을 원하는 위치의 위도
		double k21_lng = 127.1214038;						// 거리 확인을 원하는 위치의 경도
		double[] k21_minDist = new double[2];					// 가장 가까운 거리의 [줄번호, 거리] 저장 변수 생성
		double[] k21_maxDist = new double[2];					// 가장 먼 거리의 [줄번호, 거리] 저장 변수 생성
		int k21_LineCnt = 0;								// 줄 수 카운터 변수 선언 
		String[] k21_minStr = null;							// 최소값 스트링 데이터 저장용 변수 선언
		String[] k21_maxStr = null;							// 최대값 스트링 데이터 저장용 변수 선언

		while((k21_readtxt = k21_br.readLine()) != null){	// 해당줄이 비었다면 실행 안됨
			String[] k21_field = k21_readtxt.split("\t");	// 해당 줄을 탭으로 분리해 field array에 저장
			System.out.printf("**[%06d번째 항목]**************************************\n", k21_LineCnt); // 0번째 줄부터 줄 수 및 구분 선 출력
			System.out.printf(" %s: %s\n", k21_field_name[9], k21_field[9]);	// 위치의 주소 출력
		
			if ((!k21_field[13].isBlank()) && (!k21_field[12].isBlank())) {		// 위/경도 모두 빈 값이 아닐 경우
				System.out.printf(" %s: %s\n", k21_field_name[12], k21_field[12]);	// 위도: x.xxxxx
				System.out.printf(" %s: %s\n", k21_field_name[13], k21_field[13]);	// 경도: x.xxxxx
				double dist = Math.sqrt(											// 거리(피타고라스정리)	
						Math.pow(Double.parseDouble(k21_field[12])-k21_lat, 2)		// (경도 델타)^2 + 
						+ Math.pow(Double.parseDouble(k21_field[13])-k21_lng, 2));	// (위도 델타)^2
				System.out.printf("현재 지점과의 거리: %f\n", dist);				// 거리 출력
				if (k21_LineCnt == 0) {										// 0번째 데이터셋일 경우
					k21_minDist[0] = k21_LineCnt;							// 최소값 줄 번호는 0번째와 같음
					k21_minDist[1] = dist;									// 최소값 거리는 0번째와 같음
					k21_maxDist[0] = k21_LineCnt;							// 최대값 줄 번호는 0번째와 같음
					k21_maxDist[1] = dist;									// 최소값 거리는 0번째와 같음	
					k21_minStr = k21_field;									// 스트링 데이터 저장 값 0번째와 같음
				}
				else {														// 0번째 데이터가 아니면 다음 작업 수행
					if ((Math.min(k21_minDist[1], dist) == dist)) {			// 최소값으로 저장한 값보다 계산한 거리가 더 작거나 같으면
						k21_minDist[0] = k21_LineCnt;						// 최소값 줄 번호는 해당 줄 번호로 변경 
						k21_minDist[1] = dist;								// 최소 거리도 해당 거리로 변경
						k21_minStr = k21_field;  							// 스트링 데이터 저장
					} 
					if ((Math.max(k21_maxDist[1], dist) == dist)) {			// 최대값으로 저장한 값보다 계산한 거리가 더 크거나 같으면
						k21_maxDist[0] = k21_LineCnt;						// 최대값 줄 번호는 해당 줄 번호로 변경 
						k21_maxDist[1] = dist;								// 최대 거리도 해당 줄 번호로 변경 
						k21_maxStr = k21_field;  							// 스트링 데이터 저장
					} 
				}
			}
			else {																	// 위경도 중 하나라도 빈 값이면		
				System.out.printf(" %s: %s\n", k21_field_name[12], "미확인");		// 미확인으로 출력
				System.out.printf(" %s: %s\n", k21_field_name[13], "미확인");
				System.out.printf("현재 지점과의 거리: %s\n", "거리가 확인되지 않았습니다");	
			}
			
			System.out.printf("*********************************************************\n");
			k21_LineCnt++;									// 줄 수 카운터 변수에 1추가
		}
		k21_br.close();		// reader 닫기								
		System.out.println("++ 가장 가까운 wifi ++");							// 주소는 거리명 주소로 출력
		System.out.printf("%s 번째 데이터, 거리: %f\n", (int)k21_minDist[0], k21_minDist[1]); // 가장 가까운 와이파이 줄번호, 거리 출력
		System.out.println(k21_minStr[8]+ ": "+ k21_minStr[6]);								  // 가장 가까운 와이파이 주소, 이름 출력		
		System.out.println("++ 가장 먼 wifi ++");				
		System.out.printf("%s 번째 데이터, 거리: %f\n", (int)k21_maxDist[0], k21_maxDist[1]); // 가장 먼 와이파이 줄번호, 거리 출력
		System.out.println(k21_maxStr[8] +": "+  k21_maxStr[6]);							  // 가장 먼 와이파이 주소, 이름 출력
	}
}