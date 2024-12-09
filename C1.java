import java.util.Calendar;

public class C1 {
	public static void main(String[] args) throws Exception{
		
		while(true) {
			Thread.sleep(1000);
			
			Calendar now = Calendar.getInstance();
			System.out.println(now);
			System.out.print(now.get(Calendar.YEAR) + "-");
			System.out.print(now.get(Calendar.MONTH) + 1 +"-");
			System.out.print(now.get(Calendar.DATE) + " ");
			System.out.print(now.get(Calendar.HOUR) + ":");
			System.out.print(now.get(Calendar.MINUTE) + ":");
			System.out.print(now.get(Calendar.SECOND) + " ");
			
			int t = now.get(Calendar.AM_PM);
			
			if(t == Calendar.AM)
				System.out.print("AM");
			else if(t == Calendar.PM)
				System.out.print("PM");
		}
	}
}
