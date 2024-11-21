import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class 기타_예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("검색어: ");
			String fd = scan.nextLine();
			int a = 61;
			String b = new String("하이");
			double c = 20.2;
			
			System.out.printf("정수: %d, 실수: %.2f, 문자열: %s", a, c, b);
			
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
					Elements title = doc.select("td.info a.title");
					for(int i=0; i < title.size(); i++) {
						if(title.get(i).text().contains(fd)) {
							System.out.println(title.get(i).text());
						}
					}
			
		} catch(Exception ex) {
			System.out.println(ex);
		}

}
}