package an;

import java.util.Scanner;

class process{
	public int arrivetime;//��ʼʱ��
	public int usetime;//ʹ��ʱ��
	public int finishtime;//���ʱ��
	public int starttime;//����ʱ��
	public String pid; //����id
	public double wholetime;//��תʱ��
	public double weighwholetime;//��Ȩ��תʱ��
	
	public process(int x,int y,String a){
		arrivetime=x;
		usetime=y;
		pid=a;
	}//���̵����ݽṹ
}

class assemble{
//�����򹤾ߣ����������

	public static void sortprocess(process[] p){
		
		for(int i=0;i<p.length;i++){
			
			for(int j=i+1;j<p.length;j++){
				
				if(p[i].arrivetime>p[j].arrivetime&&p[i].arrivetime>0){
					process temp;
					temp=p[i];
					p[i]=p[j];
					p[j]=temp;
				}
			}
		}
	}//ʱ��ԽС����λԽǰ
	
	public static void FIFS(process[] p){
		sortprocess(p);
		
		for(int i=0;i<p.length;i++){
			if(i==0){
				p[i].starttime=p[i].arrivetime;
				p[i].finishtime=p[i].starttime+p[i].usetime;
			}else if(p[i].arrivetime<p[i-1].finishtime){
				p[i].starttime=p[i-1].finishtime;
				p[i].finishtime=p[i].starttime+p[i].usetime;
			}else{
				p[i].starttime=p[i].arrivetime;
				p[i].finishtime=p[i].starttime+p[i].usetime;
			}
		}
		
	}
	
	
	public static void out(process[] p){
		
		for(int i=0;i<p.length;i++){
			p[i].wholetime=p[i].finishtime-p[i].arrivetime;
			p[i].weighwholetime=p[i].wholetime/p[i].finishtime;
			System.out.println("����id	����ʱ��	ʹ��ʱ��	���ʱ��	��תʱ��	ƽ����תʱ��");
			System.out.println(p[i].pid+"      "+p[i].arrivetime+"      "+p[i].usetime+"      "+p[i].finishtime+"      "+p[i].wholetime+"      "+p[i].weighwholetime);
		}
		
	}
}

public class Ex_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��������̸���");
		int in=sc.nextInt();
		process[] pro=new process[in];
		System.out.println("��������̵���ʱ��+����ʹ��ʱ��+����id");
		for(int i=0;i<in;i++){
			int j=i+1;
			System.out.println("��"+j+"��");
			int arr=sc.nextInt();
			int use=sc.nextInt();
			String id=sc.next();
			pro[i]=new process(arr, use, id);
		}
		assemble as=new assemble();
		as.FIFS(pro);
		as.out(pro);

	}

}
