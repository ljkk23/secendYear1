import java.util.Scanner;
class BankDemo  
{
	public static void main(String[] args) 
	{
		System.out.println("input the money");
		int money=new Scanner(System.in).nextInt();
	    System.out.println("input the money-year");
		int year=new Scanner(System.in).nextInt(); 
		double outMoney=0;
		if(year==1){
			outMoney=money+money*2.25/100*1;
		}else if(year==2){
			outMoney=money+money*2.7/100*2;
		}else if(year==3){
			outMoney=money+money*3.25/100*3;
		}else{
			System.out.println("the year is wrong");
		}
		System.out.println("存款"+year+"年后的利息是"+outMoney);

		//stem.out.println("Hello World!");
	}
}
