import java.util.Scanner;


//吃货联盟订餐系统
public class Version_Alliance1 {
	public static void main(String[] args) {
		String[] names = new String[4];//订餐人
		String[] dishMegs = new String[4];//餐品信息
		int[] times = new int[4];//送餐时间
		String[] addresses = new String[4];//送餐地址
		int[] states = new int[4];//订单状态 0：已预订 1：已完成
		double[] sumPrices = new double[4];//订单金额
		//初始化第一条订餐信息
		names[0] = "张晴";
		dishMegs[0] = "红烧带鱼2份";
		times[0] = 12;
		addresses[0] = "天成路207号";
		sumPrices[0] = 76.0;
		states[0] = 1;
		//初始化第二条订餐信息
		names[1] = "张晴";
		dishMegs[1] = "鱼香肉丝2份";
		times[1] = 18;
		addresses[1] = "天成路207号";
		sumPrices[1] = 45.0;
		states[1] = 0;
		String[] dishNames = {"红烧带鱼","鱼香肉丝","时令蔬菜"};//餐品价格
		double[] prices = {38.0,18.0,10.0};//菜品单价
		int[] praiseNums = new int[3];//点赞数
		
		Scanner input = new Scanner(System.in);
		int num = -1;//用户输入的数字
		boolean isExit = false;//用于判断用户输入的数字是否符合
		System.out.println("欢迎使用“吃货联盟订餐系统”");
		//循环显示菜单
		do{//显示菜单
			System.out.println("*********************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("*********************************");
			System.out.println("请选择：");
			
			int choose = input.nextInt();//记录用户选择的功能编号
			switch(choose){
			case 1:
				System.out.println("***我要订餐***");
				boolean isAdd = false;//记录是否可以订餐
				for(int j=0;j<names.length;j++){
					if(names[j]==null){
						isAdd = true;
						System.out.print("请输入订餐人姓名：");
						String name = input.next();
						System.out.println("序号"+"\t"+"菜名"+"\t"+"\t单价"+"\t"+"点赞数");
						
						for(int i=0;i<dishNames.length;i++){
							String price = prices[i]+"元";
							String priaiseNum = (praiseNums[i])>0?praiseNums[i]+"赞" : "0";
							System.out.println((i+1)+"\t"+dishNames[i]+"\t"+price+"\t"+priaiseNum);
						}
						//用户点餐
						System.out.print("请选择您要点的菜品编号：");
						int chooseDish = input.nextInt();
						System.out.print("请选择您需要的份数：");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish-1]+""+number+"份";
						double sumPrice = prices[chooseDish-1]*number;//餐费满50元，免配送费5元
						double deliCharge = (sumPrice>=50)?0:5;
						
						System.out.print("请输入送餐时间（送餐时间是10点到20点间整点送餐）：");
						int time = input.nextInt();
						while(time<10 || time>20){
							System.out.println("您的输入有误，请输入10~20间的整数！");
							time = input.nextInt();
						}
						System.out.print("请输入送餐地址：");
						String address = input.next();
						
						//无须添加状态，默认算术0；即已预订状态
						System.out.println("订餐成功！");
						System.out.println("您订的是"+dishMeg);
						System.out.println("送餐时间："+time+"点");
						System.out.println("餐费："+sumPrice+"元,送餐费"+deliCharge+"元,总计："+(sumPrice+deliCharge)+"元");
						
						//添加数据
						names[j] = name;
						dishMegs[j] = dishMeg;
						times[j] = time;
						addresses[j] = address;
						sumPrices[j] = sumPrice+deliCharge;
						break;
						}
				}
				if(!isAdd){
					System.out.println("对不起，您的餐袋已满！");
				}
				break;
			case 2:
				System.out.println("***查看餐袋***");
				System.out.println("序号\t订餐人\t餐品信息\t送餐时间"+"\t"+"送餐地址"+"\t"+"总金额\t订单状态");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String state = (states[i]==0)?"已预订" : "已完成";
						String date = times[i]+"点";
						String sumPrice = sumPrices[i]+"元";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+date+"\t\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
					}
				}
				break;
			case 3:
				System.out.println("***签收订单***");
				boolean isSignFind = false;
				System.out.print("请选择要签收的订单序号：");
				int signOrderld = input.nextInt();
				for(int i=0;i<names.length;i++){
					if(names[i]!=null && states[i]==0 && signOrderld==i+1){
						states[i]=1;
						System.out.println("订单签收成功！");
						isSignFind = true;
					}else if(names[i]!=null && states[i]==1 &&signOrderld==i+1){
						System.out.println("您选择的订单已完成签收，不能再次签收！");
						isSignFind = true;
					}
				}
				if(!isSignFind){
					System.out.println("您选择的订单不存在！");
				}
				break;
			case 4:
				System.out.println("***删除订单***");
				boolean isDelFind = false;//标记是否找到要删除的订单
				System.out.print("请输入需要删除的订单编号：");
				int delld = input.nextInt();
				for(int i=0;i<names.length;i++){
					if(names[i]!=null && states[i]==1 && delld==i+1){
						isDelFind = true;
						for(int j=delld-1;j<names.length-1;j++){
							names[j] = names[j+1];
							dishMegs[j] = dishMegs[j+1];
							times[j] = times[j+1];
							addresses[j] = addresses[j+1];
							states[j] = states[j+1];
							sumPrices[j] = sumPrices[j+1];
						}
						int endIndex = names.length-1;
						names[endIndex] = null;
						dishMegs[endIndex] = null;
						times[endIndex] = 0;
						addresses[endIndex] = null;
						states[endIndex] = 0;
						sumPrices[endIndex] = 0;
						System.out.println("删除订单成功！");
						break;
					}else if(names[i]!=null && states[i]==0 && delld==i+1){
						System.out.println("您选择的订单未签收，不能删除！");
						isDelFind = true;
						break;
					}
				}
				if(!isDelFind){
					System.out.println("您要删除的订单不存在！");
				}
				break;
			case 5:
				System.out.println("***我要点赞***");
				System.out.println("序号"+"\t"+"菜名"+"\t"+"\t单价");
				for(int i=0;i<dishNames.length;i++){
					String price = prices[i]+"元";
					String priaiseNum = (praiseNums[i])>0?praiseNums[i]+"赞" : "" ;
					System.out.println((i+1)+"\t"+dishNames[i]+"\t"+price+"\t"+priaiseNum);
				}
				System.out.println("请选择您要点赞的菜品序号：");
				int priaiseNum = input.nextInt();
				praiseNums[priaiseNum-1]++;
				System.out.println("点赞成功！");
				break;
			case 6:
				isExit = true;
				break;
			default :
				isExit = true;
				break;
			}
			if(!isExit){
				System.out.println("输入0返回：");
				num = input.nextInt();
			}else{
				break;
			}
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次光临！");
		}
}
