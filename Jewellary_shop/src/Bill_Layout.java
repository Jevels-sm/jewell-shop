import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.time.*;
//import java.time.temporal.*;
//Bug Var%
//Price - where
//Date and time bug
public class Bill_Layout {
	public List<String> box=null;
	String orderno="";
	String Name="";
	String Mobileno="";
	String Adrs="";
	String Metal_Type="";
	String Weight="";
	String Percent="";
	String NetWeight="";
	String Rate="";
	String Price="";
	String Dis="";
	String Var="";
	public void Layout() throws FileNotFoundException {
		StringBuffer bill = new StringBuffer();
		StringBuffer starLine = new StringBuffer();
		for(int i=0;i<80;++i) {
			starLine.append('-');
		}
		//Title Block
		bill.append(starLine);
		bill.append("\n");
		
		//Tax Invoice Line
		bill.append(String.format("|%34s", ""));
		bill.append(String.format("%11.11s", "Tax Invoice"));
		bill.append(String.format("%33s|", ""));
		
		bill.append("\n");
		bill.append(starLine);
		
		// Name of shop
		bill.append("\n");
		bill.append(String.format("|%34s", ""));
		bill.append(String.format("%11.15s", "NANAK JEWELLERS"));
		bill.append(String.format("%29s|", ""));
		
		
		//address of shop
		bill.append("\n");
		bill.append(String.format("|%28s", ""));
		bill.append(String.format("%11.24s", "near sarafa bazar,karnal"));
		bill.append(String.format("%26s|", ""));
		
		//Mobile number
		bill.append("\n");
		bill.append(String.format("|%40s", ""));
		bill.append(String.format("%11.12s", "--9896664407"));
		bill.append(String.format("%26s|", ""));
		
		//Mobile number-2
		bill.append("\n");
		bill.append(String.format("|%40s", ""));
		bill.append(String.format("%11.12s", "--9896664407"));
		bill.append(String.format("%26s|", ""));
		
		//starLine
		bill.append("\n");
		bill.append(starLine);
		
		bill.append("\n");
		bill.append(String.format("|%-10.10s %-26.20s","Order no :",orderno));
		bill.append(String.format("%-10.10s %-30.30s|","Name :",Name));//30 char
		
		//customer detailsLocalTime
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		bill.append("\n");
		bill.append(String.format("|%-10.10s %-26.20s","Date :  :",date));
		bill.append(String.format("%-10.10s %-30.8s|","Time : ",time));
		
		//customer details
		bill.append("\n");
		bill.append(String.format("|%-10.10s %-26.20s","Mobile No :",Mobileno));
		bill.append(String.format("%-10.10s %-30.30s|","Address : ",Adrs));
		
		//starLine
		bill.append("\n");
		bill.append(starLine);
		
		//Box header
		bill.append("\n");	
		bill.append(String.format("|%-2.6s|","Srl no."));
		bill.append(String.format("%5s%-14.11s","","Description"));
		bill.append(String.format("%5s %-8.8s|","","Weight"));
		bill.append(String.format("%2s%-5.5s |","","Rate"));
		bill.append(String.format("%2s%-7.10s |","","Amount"));
		bill.append(String.format("%1s%-6.6s |","","Making"));
		bill.append(String.format("%2s%-5.5s |","","Total"));
		
		
		//starLine
		bill.append("\n");
		bill.append(starLine);
		
		int NetTot=0;
		//box content
			for(int i=0;i<box.size();i=i+7) {
				bill.append("\n");
				bill.append(String.format("|%3s%-3.3s|","",box.get(i)));
				bill.append(String.format("%5s%-20.20s","",box.get(i+1)));
				bill.append(String.format("%-8.8s|",box.get(i+2)));
				bill.append(String.format("%2s%-6.6s|","",box.get(i+3))); //6 digit
				bill.append(String.format("%2s%-8.8s|","",box.get(i+4)));// 8 digit
				bill.append(String.format("%2s%-6.6s|","",box.get(i+5))); //6 char
				bill.append(String.format("%1s%-7.7s|","",box.get(i+6)));// 7 digit
				NetTot+=Integer.valueOf(box.get(i+6));
			}
			
			
			//old metal
			bill.append("\n");
			//blank line
			bill.append(String.format("|%6s|%6s%-25.25s%3s%9s%11s%9s%9s","","","","|","|","|","|","|"));
			
			bill.append("\n"); // 9 char all
			bill.append(String.format("|%6s|%6s%-25.25s%3s%9s%11s%9s%9s","","","Old (Exchange(Cash+Metal))","|","|","|","|","|"));
			bill.append("\n");
			bill.append(String.format("|%6s|%3s%-12.12s%4s%-9.9s%6s%9s%11s%9s%9s","","","Metal Type","",Metal_Type,"|","|","|","|","|"));
			bill.append("\n");
			bill.append(String.format("|%6s|%3s%-12.12s%4s%-9.9s%6s%9s%11s%9s%9s","","","Weight","",Weight,"|","|","|","|","|"));
			bill.append("\n");
			bill.append(String.format("|%6s|%3s%-12.12s%4s%-9.9s%6s%9s%11s%9s%9s","","","Percent","",Percent,"|","|","|","|","|"));
			bill.append("\n");
			bill.append(String.format("|%6s|%3s%-12.12s%4s%-9.9s%6s%9s%11s%9s%9s","","","Net Weight","",NetWeight,"|","|","|","|","|"));
			bill.append("\n");
			bill.append(String.format("|%6s|%3s%-12.12s%4s%-9.9s%6s%9s%11s%9s%9s","","","Rate","",Rate,"|","|","|","|","|"));
			bill.append("\n");
			bill.append(String.format("|%6s|%3s%-12.12s%4s%-9.9s%6s%9s%11s%9s%9.9s","","","Price (-)","",Price,"|","|","|","Total |",NetTot+"|"));
			
			//starLine
			bill.append("\n");
			bill.append(starLine);
			
			//box footer
			int D=NetTot-Integer.valueOf(Dis);
			bill.append("\n");
			bill.append(String.format("|%6s|%6s%-15s%-10s%3s%9s%11s%9s%9.9s","","","Disc (-)",Dis,"|","|","|","|",D+"|"));
			bill.append("\n");
			bill.append(String.format("|%6s|%6s%-15s%-10s%3s%9s%11s%9s%9.9s","","","Var% (+)",Var,"|","|","|","N.Total|","5000"+"|"));
	
			
			
			
			//starLine
			bill.append("\n");
			bill.append(starLine);
			
			
			
			bill.append("\n");
			bill.append(String.format("|%78s|",""));
			
			
			////Terms and condition
			bill.append("\n");
			bill.append(String.format("|%5s%11s%55s","", "TERMS AND CONDITION","|"));
			
			bill.append("\n");
			bill.append(String.format("|%78s|",""));
			
			
			
			bill.append("\n");
			bill.append(String.format("|%7s%11s%33s","", "All Subjects To Lakhisarai Jurisdiction","Authorised signature   |"));
			
			//starLine
			bill.append("\n");
			bill.append(starLine);
			
			PrintWriter out= new PrintWriter("Samplebill.txt");
			out.println(bill);
			out.close();
		
		System.out.println(bill);
	}
	public static void main(String[] args) {
		Bill_Layout bill = new Bill_Layout();
		try {
			bill.Layout();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
