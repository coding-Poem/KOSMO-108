package a.b.c.common;

public abstract class CodeUtil {
	// 성별 라벨
	public static final String[] gender_value= {"여자","남자"};
	
	// 핸드폰 라벨
	public static final String[] hp_value= {"010","011","016","017"};
	
	// 취미 라벨
	public static final String[] hobby_lavel= {"독서","운동","음악감상","여행"};
	
	// 성별
	public static String gender(String s){
		return "01".equals(s.toUpperCase()) ? "여자" : "남자";
		// "01".equals(s.toUpperCase())가 true면 여자, false면 남자
	}
	
	// 핸드폰
	public static String hp(String s){
		String s0="";
		String s1="";
		String s2="";
		String ss="";
		
		if(s!=null && s.length() >0){
			int sLen=s.length();
			if(11==sLen){
				// 010 1234 5678  :: 11글자
				// 문자열의 길이가 11일 때 수행
				s0=s.substring(0,3); // 010
				// 0번쨰 인덱스 값부터 2번째까지 
				s1=s.substring(3,7); // 1234
				// 3번째 인덱스 값부터 6번째 인덱스까지
				s2=s.substring(7); // 5678~
				// 7번째 인덱스 뒤
				ss=s0+"-"+s1+"-"+s2; // 010-1234-5678
			}
		}
		return ss;
	}
	
	// 취미들
	public static String hobbys(String s){
		System.out.println(s);
		String h="";
		String ss[] = s.split(",");
		// 독서, 운동, 여행 이면 배열  0번째에 독서, 배열 1번째에 운동, 배열 2번째에 여행
		for(int i=0; i<ss.length; i++){
			System.out.println(hobby(ss[i]));
			// h += hobby(ss[i]);
			// 독서운동음악감상 (띄어쓰기 없음)
			 h += hobby(ss[i])+" ";
			 // 독서 운동 음악감상  (띄어쓰기 있음)
			// hobby함수에 ss배열의 원소를 입력하여 출력 시킨다음
			// 해당 값을 문자열 h에 대입한다.
		}
		return h;
	}
	
	// 취미
	public static String hobby(String s){
		String h="";
		
		if(s!=null && s.length()>0){
			for(int i=1; i<hobby_lavel.length; i++){
				if(("0"+i).equals(s)){
					// 0+i == ss[i] ??를 확인하여 true면 수행
					h=CodeUtil.hobby_lavel[i-1];
					// {"독서","운동","음악감상","여행"}에서
					// 해당 인덱스의 값을 문자열 h에 저장
					// 인덱스는 0부터 시작하므로, i-1로 대입해야함. (i는 0이 아닌 1로 시작하기 때문)
				}
			}
		}
		
		return h;
	}
	
	
	public static void main(String[] args) {
		// 핸드폰
		String hp=CodeUtil.hp("01012341234");
		System.out.println("hp >>> : "+hp);
		// hp >>> : 010-1234-1234
		
		// 성별
		String g=CodeUtil.gender("F");
		System.out.println("g >>> : "+g);
		// g >>> : 남자
		
		// 취미
		String h=CodeUtil.hobby("02");
		System.out.println("h >>> : "+h);
		// h >>> : 운동
		
		// 취미들
		String hs=CodeUtil.hobbys("01,02,03,");
		System.out.println("hs >>> : "+hs);
		/*
		 * 01,02,03,
                   독서 
    	   운동     
    	   음악감상 
  		  hs  >>>  : 독서 운동 음악감상 
		 * */
	}
}
