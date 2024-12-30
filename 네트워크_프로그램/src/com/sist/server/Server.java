package com.sist.server;
import java.util.*; // 데이터가 여러개 => StringTokenizer
//=> 사용자 정보 저장 => Vector ( 동기화)
import com.sist.commons.*;
import java.io.*; // 송수신
// 전송시 => byte단위 전송 , 받을때 => 2byte
// outputStream , BufferedReader
import java.net.*; // 다른 컴퓨터랑 연결
//ServerSocket : 접속 담당 / Socket : 클라이언트 통신
public class Server implements Runnable{
	private ServerSocket ss;
	private final int PORT =5555;//조별 port
	private Vector<Client> waitVc=new Vector<Client>();
	//=> 1024~65535
	// 초기화
	public Server()
	{
		try {
			ss=new ServerSocket(PORT);//bind => IP/PORT연결 => 유심 (개통)
			//listen() => 대기상태
			/*
			 * new ServerSocket(int count, int port);
			 * new ServerSocket(int port);
			 *  // 접속인원이 50명
			 *  웹 : 톰캣 (50명) XE(50명)
			 */
			System.out.println("Server Start...");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// 접속시에 처리 => 접속자 정보를 저장 (ip,port)
	// ---------- 발신자 IP (전화번호)
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				Socket s=ss.accept();
				//접속시에만 호출 => 발신자의 정보 (ip,port)
				// =>  Socket(ip/port)
				// => 사용자는 port => 자동으로 설정
				// => 어떤위치로든 상관없다
				Client client = new Client(s);
				// s=> port (윈도우마다 틀리다)
				waitVc.add(client);
				//=> 통신을 시작해라 명령어
				client.start();//run()호출
			}
		}catch(Exception e) {}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		new Thread(server).start();
	}
	// 클라이언트 정보 => 통신(송수신) => 클라이언트마다 따로 작성해야함
	// 내부 클래스 => 다른 클래스의 데이터를 공유
	class Client extends Thread
	{
		// => 한명하고만 연결
		Socket s;//ip/port
		OutputStream out;//송신
		BufferedReader in ; //수신
		
		// 초기화
		public Client(Socket s)
		{
			try {
				this.s =s;
				out=s.getOutputStream();
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (Exception e) {}
		}
		public void run()
		{
			try
			{
				while(true)
				{
					//사용자가 보내준 데이터를 받는다
					String msg=in.readLine();
					// => 보낼때 \n으로 보내줘야한다
					/*
					 * 용청
					 *     1. 접속자 전체
					 *     2. 한명에게 전송
					 */
					messageAll(msg);
				}
					
			}catch(Exception e) {}
		}
		//전체적으로 전송 => 동기화
		public synchronized void messageAll(String msg)
		{
			try {
				for(Client c: waitVc)
				{
					c.messageTo(msg);
				}
			} catch (Exception e) {}
		}
		//한명에게 전송 => 동기화
		public synchronized void messageTo(String msg)
		{
			try
			{
				out.write((msg+"\n").getBytes());
			}catch(Exception e) {}
		}
	}

	
}
