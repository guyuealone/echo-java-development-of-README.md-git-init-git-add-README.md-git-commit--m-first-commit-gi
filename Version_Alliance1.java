import java.util.Scanner;


//�Ի����˶���ϵͳ
public class Version_Alliance1 {
	public static void main(String[] args) {
		String[] names = new String[4];//������
		String[] dishMegs = new String[4];//��Ʒ��Ϣ
		int[] times = new int[4];//�Ͳ�ʱ��
		String[] addresses = new String[4];//�Ͳ͵�ַ
		int[] states = new int[4];//����״̬ 0����Ԥ�� 1�������
		double[] sumPrices = new double[4];//�������
		//��ʼ����һ��������Ϣ
		names[0] = "����";
		dishMegs[0] = "���մ���2��";
		times[0] = 12;
		addresses[0] = "���·207��";
		sumPrices[0] = 76.0;
		states[0] = 1;
		//��ʼ���ڶ���������Ϣ
		names[1] = "����";
		dishMegs[1] = "������˿2��";
		times[1] = 18;
		addresses[1] = "���·207��";
		sumPrices[1] = 45.0;
		states[1] = 0;
		String[] dishNames = {"���մ���","������˿","ʱ���߲�"};//��Ʒ�۸�
		double[] prices = {38.0,18.0,10.0};//��Ʒ����
		int[] praiseNums = new int[3];//������
		
		Scanner input = new Scanner(System.in);
		int num = -1;//�û����������
		boolean isExit = false;//�����ж��û�����������Ƿ����
		System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
		//ѭ����ʾ�˵�
		do{//��ʾ�˵�
			System.out.println("*********************************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("*********************************");
			System.out.println("��ѡ��");
			
			int choose = input.nextInt();//��¼�û�ѡ��Ĺ��ܱ��
			switch(choose){
			case 1:
				System.out.println("***��Ҫ����***");
				boolean isAdd = false;//��¼�Ƿ���Զ���
				for(int j=0;j<names.length;j++){
					if(names[j]==null){
						isAdd = true;
						System.out.print("�����붩����������");
						String name = input.next();
						System.out.println("���"+"\t"+"����"+"\t"+"\t����"+"\t"+"������");
						
						for(int i=0;i<dishNames.length;i++){
							String price = prices[i]+"Ԫ";
							String priaiseNum = (praiseNums[i])>0?praiseNums[i]+"��" : "0";
							System.out.println((i+1)+"\t"+dishNames[i]+"\t"+price+"\t"+priaiseNum);
						}
						//�û����
						System.out.print("��ѡ����Ҫ��Ĳ�Ʒ��ţ�");
						int chooseDish = input.nextInt();
						System.out.print("��ѡ������Ҫ�ķ�����");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish-1]+""+number+"��";
						double sumPrice = prices[chooseDish-1]*number;//�ͷ���50Ԫ�������ͷ�5Ԫ
						double deliCharge = (sumPrice>=50)?0:5;
						
						System.out.print("�������Ͳ�ʱ�䣨�Ͳ�ʱ����10�㵽20��������Ͳͣ���");
						int time = input.nextInt();
						while(time<10 || time>20){
							System.out.println("������������������10~20���������");
							time = input.nextInt();
						}
						System.out.print("�������Ͳ͵�ַ��");
						String address = input.next();
						
						//�������״̬��Ĭ������0������Ԥ��״̬
						System.out.println("���ͳɹ���");
						System.out.println("��������"+dishMeg);
						System.out.println("�Ͳ�ʱ�䣺"+time+"��");
						System.out.println("�ͷѣ�"+sumPrice+"Ԫ,�Ͳͷ�"+deliCharge+"Ԫ,�ܼƣ�"+(sumPrice+deliCharge)+"Ԫ");
						
						//�������
						names[j] = name;
						dishMegs[j] = dishMeg;
						times[j] = time;
						addresses[j] = address;
						sumPrices[j] = sumPrice+deliCharge;
						break;
						}
				}
				if(!isAdd){
					System.out.println("�Բ������Ĳʹ�������");
				}
				break;
			case 2:
				System.out.println("***�鿴�ʹ�***");
				System.out.println("���\t������\t��Ʒ��Ϣ\t�Ͳ�ʱ��"+"\t"+"�Ͳ͵�ַ"+"\t"+"�ܽ��\t����״̬");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String state = (states[i]==0)?"��Ԥ��" : "�����";
						String date = times[i]+"��";
						String sumPrice = sumPrices[i]+"Ԫ";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+date+"\t\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
					}
				}
				break;
			case 3:
				System.out.println("***ǩ�ն���***");
				boolean isSignFind = false;
				System.out.print("��ѡ��Ҫǩ�յĶ�����ţ�");
				int signOrderld = input.nextInt();
				for(int i=0;i<names.length;i++){
					if(names[i]!=null && states[i]==0 && signOrderld==i+1){
						states[i]=1;
						System.out.println("����ǩ�ճɹ���");
						isSignFind = true;
					}else if(names[i]!=null && states[i]==1 &&signOrderld==i+1){
						System.out.println("��ѡ��Ķ��������ǩ�գ������ٴ�ǩ�գ�");
						isSignFind = true;
					}
				}
				if(!isSignFind){
					System.out.println("��ѡ��Ķ��������ڣ�");
				}
				break;
			case 4:
				System.out.println("***ɾ������***");
				boolean isDelFind = false;//����Ƿ��ҵ�Ҫɾ���Ķ���
				System.out.print("��������Ҫɾ���Ķ�����ţ�");
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
						System.out.println("ɾ�������ɹ���");
						break;
					}else if(names[i]!=null && states[i]==0 && delld==i+1){
						System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ����");
						isDelFind = true;
						break;
					}
				}
				if(!isDelFind){
					System.out.println("��Ҫɾ���Ķ��������ڣ�");
				}
				break;
			case 5:
				System.out.println("***��Ҫ����***");
				System.out.println("���"+"\t"+"����"+"\t"+"\t����");
				for(int i=0;i<dishNames.length;i++){
					String price = prices[i]+"Ԫ";
					String priaiseNum = (praiseNums[i])>0?praiseNums[i]+"��" : "" ;
					System.out.println((i+1)+"\t"+dishNames[i]+"\t"+price+"\t"+priaiseNum);
				}
				System.out.println("��ѡ����Ҫ���޵Ĳ�Ʒ��ţ�");
				int priaiseNum = input.nextInt();
				praiseNums[priaiseNum-1]++;
				System.out.println("���޳ɹ���");
				break;
			case 6:
				isExit = true;
				break;
			default :
				isExit = true;
				break;
			}
			if(!isExit){
				System.out.println("����0���أ�");
				num = input.nextInt();
			}else{
				break;
			}
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
		}
}
