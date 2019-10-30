package Task.Login;

public class Protocol{
    //포로토콜 타입 변수
    public static final int PT_UNDEFINED = -1;	// 프로토콜이 지정되어 있지 않은 경우
	public static final int PT_EXIT = 0;		// 프로그램 종료
    public static final int PT_REQ = 1;	        // 로그인 요청
    public static final int PT_REQ_ID = 11;     // ID 요청
    public static final int PT_REQ_PW = 12;     // PW 요청
    public static final int PT_RES = 2;	        // 로그인 응답
    public static final int PT_RES_ID = 21;     // ID 응답
    public static final int PT_RES_PW = 22;     // ID 응답
	public static final int PT_LOGIN_RESULT=3;	// 인증 결과
	public static final int LEN_LOGIN_ID=20;	// ID 길이
	public static final int LEN_LOGIN_PW=20;	// PWD 길이
	public static final int LEN_LOGIN_RESULT=2;	// 로그인 인증 값 길이
	public static final int LEN_PROTOCOL_TYPE=1;	// 프로토콜 타입 길이
	public static final int LEN_MAX = 1000;		//최대 데이터 길이
    public int REQ_ID_LIMIT = 3;                //최대 ID 입력 횟수
	public int REQ_PW_LIMIT = 3;                //최대 PW 입력 횟수

    protected int protocolType;
    private byte[] packet;	// 프로토콜과 데이터의 저장공간이 되는 바이트 배열
    
    public Protocol(){					// 생성자
		this(PT_UNDEFINED);
	}

	public Protocol(int protocolType){	// 생성자
		this.protocolType = protocolType;
		getPacket(protocolType);
    }
    
    // 프로토콜 타입에 따라 바이트 배열 packet의 length가 다름
	public byte[] getPacket(int protocolType){
	    if(packet==null){
			switch(protocolType){
				case PT_REQ_ID :
					packet = new byte[LEN_PROTOCOL_TYPE];
					break;
				case PT_REQ_PW :
					packet = new byte[LEN_PROTOCOL_TYPE];
				case PT_RES_ID:
					packet = new byte[LEN_PROTOCOL_TYPE+LEN_LOGIN_ID];
					break;
				case PT_RES_PW :
					packet = new byte[LEN_PROTOCOL_TYPE+LEN_LOGIN_PW];
				case PT_UNDEFINED : 
					packet = new byte[LEN_MAX];
					break;
				case PT_LOGIN_RESULT :
					packet = new byte[LEN_PROTOCOL_TYPE+LEN_LOGIN_RESULT];
					break;
				case PT_EXIT : 
					packet = new byte[LEN_PROTOCOL_TYPE];
					break;
			} // end switch
	    } // end if
	    packet[0] = (byte)protocolType;	// packet 바이트 배열의 첫 번째 바이트에 프로토콜 타입 설정
	    return packet;
	}

	// 로그인후 성공/실패의 결과 값을 프로토콜로부터 추출하여 문자열로 리턴
	public String getLoginResult(){
		// String의 다음 생성자를 사용 : String(byte[] bytes, int offset, int length)
		return new String(packet, LEN_PROTOCOL_TYPE, LEN_LOGIN_RESULT).trim();
	}

	// String ok를 byte[]로 만들어서 packet의 프로토콜 타입 바로 뒤에 추가
	public void setLoginResult(String ok){
		// arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		System.arraycopy(ok.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE, ok.trim().getBytes().length);
		packet[LEN_PROTOCOL_TYPE + ok.trim().getBytes().length] = '\0';		//packet의 끝을 지정
	}

	public void setProtocolType(int protocolType){
		this.protocolType = protocolType;
	}

	public int getProtocolType(){
		return protocolType;
	}

	public byte[] getPacket(){
		return packet;
	}

	// Default 생성자로 생성한 후 Protocol 클래스의 packet 데이터를 바꾸기 위한 메서드
	public void setPacket(int pt, byte[] buf){
		packet = null;
		packet = getPacket(pt);
		protocolType = pt;
		System.arraycopy(buf, 0, packet, 0, packet.length);
	}

	public String getId(){
		// String(byte[] bytes, int offset, int length) 
		return new String(packet, LEN_PROTOCOL_TYPE, LEN_LOGIN_ID).trim();
	}

	// byte[] packet에 String ID를 byte[]로 만들어 프로토콜 타입 바로 뒤에 추가
	public void setId(String id){
		System.arraycopy(id.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE, id.trim().getBytes().length);
		packet[LEN_PROTOCOL_TYPE + id.trim().getBytes().length] = '\0';		//packet의 끝을 지정
	}

	// 패스워드는 byte[]에서 로그인 아이디 바로 뒤에 있음
	public String getPassword(){
		return new String(packet, LEN_PROTOCOL_TYPE, LEN_LOGIN_PW).trim();
	}

	public void setPassword(String password){
		System.arraycopy(password.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE, password.trim().getBytes().length);
		packet[LEN_PROTOCOL_TYPE + password.trim().getBytes().length] = '\0';
	}
}