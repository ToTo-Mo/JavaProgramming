package Login;

import java.io.UnsupportedEncodingException;

public class Protocol {
	// 포로토콜 타입 변수
	public static final int PT_UNDEFINED = -1; // 프로토콜이 지정되어 있지 않은 경우
	public static final int PT_EXIT = 0; // 프로그램 종료
	public static final int PT_REQ = 1;
	/*
	 * CODE 1 ID 요청 2 PW 요청
	 */
	public static final int PT_RES = 2;
	/*
	 * CODE 1 ID 응답 2 PW 응답
	 */
	public static final int PT_RESULT = 3;
	/*
	 * CODE 11 ID 인증 성공 12 ID 인증 실패 21 PW 인증 성공 22 PW 인증 실패
	 */

	// 프로토콜 코드 변수
	public static final int PT_REQ_ID = 1;
	public static final int PT_REQ_PW = 2;
	public static final int PT_RES_ID = 1;
	public static final int PT_RES_PW = 2;

	public static final int PT_RESULT_ID_SUCCESS = 11;
	public static final int PT_RESULT_ID_FAIL = 12;
	public static final int PT_RESULT_PW_SUCCESS = 21;
	public static final int PT_RESULT_PW_FAIL = 22;

	// 포로토콜 길이
	public static final int LEN_LOGIN_ID = 10;
	public static final int LEN_LOGIN_PW = 20;
	public static final int LEN_PROTOCOL_TYPE = 1; // 프로토콜 타입 길이
	public static final int LEN_CODE = 1;
	public static final int LEN_MAX = 1000; // 최대 데이터 길이

	protected int protocolType;
	protected int code;
	private byte[] packet; // 프로토콜과 데이터의 저장공간이 되는 바이트 배열

	// 생성자
	public Protocol() {
		this(PT_UNDEFINED);
	}

	public Protocol(int protocolType) {
		this(protocolType, 0);
		getPacket(protocolType, 0);
	}

	public Protocol(int protocolType, int code) {
		this.protocolType = protocolType;
		this.code = code;
		getPacket(protocolType, code);
	}

	public Protocol(int protocolType, int code,String data) {
		this.protocolType = protocolType;
		this.code = code;
		getPacket(protocolType, code);

		if(code == Protocol.PT_RES_ID)
			setId(data);
		else if(code == Protocol.PT_RES_PW)
			setPassword(data);
	}

	// 프로토콜 타입에 따라 바이트 배열 packet의 length가 다름
	public byte[] getPacket(int protocolType, int code) {
		// 패킷이 없으면 새로운 공간을 생성함
		if (packet == null) {
			switch (protocolType) {
			case PT_REQ:
				packet = new byte[LEN_PROTOCOL_TYPE + LEN_CODE];
				packet[1] = (byte) code;
				break;
			case PT_RES:
				if (code == Protocol.PT_RES_ID)
					packet = new byte[LEN_PROTOCOL_TYPE + LEN_CODE + LEN_LOGIN_ID];
				else if (code == Protocol.PT_RES_PW)
					packet = new byte[LEN_PROTOCOL_TYPE + LEN_CODE + LEN_LOGIN_PW];
					packet[1] = (byte)code;
				break;
			case PT_UNDEFINED:
				packet = new byte[LEN_MAX];
				break;
			case PT_RESULT:
				packet = new byte[LEN_PROTOCOL_TYPE + LEN_CODE];
				packet[1] = (byte) code;
				break;
			case PT_EXIT:
				packet = new byte[LEN_PROTOCOL_TYPE];
				break;
			}
		}
		packet[0] = (byte) protocolType; // packet 바이트 배열의 첫 번째 바이트에 프로토콜 타입 설정
		return packet;
	}

	public void setProtocolType(int protocolType) {
		this.protocolType = protocolType;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getProtocolType() {
		return protocolType;
	}

	public int getCode() {
		return code;
	}

	public byte[] getPacket() {
		return packet;
	}

	// Default 생성자로 생성한 후 Protocol 클래스의 packet 데이터를 바꾸기 위한 메서드
	public void setPacket(int pt, int code, byte[] buf) {
		this.packet = null;
		this.packet = getPacket(pt, code);
		this.protocolType = pt;
		this.code = code;
		System.arraycopy(buf, 0, packet, 0, packet.length);
	}

	public String getId() {
		// String(byte[] bytes, int offset, int length)
		return new String(packet, LEN_PROTOCOL_TYPE + LEN_CODE, LEN_LOGIN_ID).trim();
	}

	// byte[] packet에 String ID를 byte[]로 만들어 프로토콜 타입 바로 뒤에 추가
	public void setId(String id) {
		System.arraycopy(id.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE + LEN_CODE, id.trim().getBytes().length);
		packet[LEN_PROTOCOL_TYPE + LEN_CODE + id.trim().getBytes().length] = '\0'; // packet의 끝을 지정
	}

	public String getPassword() {
		return new String(packet, LEN_PROTOCOL_TYPE + LEN_CODE, LEN_LOGIN_PW).trim();
	}

	public void setPassword(String password) {
		System.arraycopy(password.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE + LEN_CODE,
				password.trim().getBytes().length);
		packet[LEN_PROTOCOL_TYPE + LEN_CODE + password.trim().getBytes().length] = '\0';
	}
}