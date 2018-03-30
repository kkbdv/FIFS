package an;

import java.util.Scanner;

class process{
	public int arrivetime;//开始时间
	public int usetime;//使用时间
	public int finishtime;//完成时间
	public int starttime;//到达时间
	public String pid; //进程id
	public double wholetime;//周转时间
	public double weighwholetime;//带权周转时间
	
	public process(int x,int y,String a){
		arrivetime=x;
		usetime=y;
		pid=a;
	}//进程的数据结构
}

class assemble{
//放排序工具，和输出工具

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
	}//时间越小，排位越前
	
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
			System.out.println("进程id	到达时间	使用时间	完成时间	周转时间	平均周转时间");
			System.out.println(p[i].pid+"      "+p[i].arrivetime+"      "+p[i].usetime+"      "+p[i].finishtime+"      "+p[i].wholetime+"      "+p[i].weighwholetime);
		}
		
	}
}

public class Ex_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入进程个数");
		int in=sc.nextInt();
		process[] pro=new process[in];
		System.out.println("请输入进程到达时间+进程使用时间+进程id");
		for(int i=0;i<in;i++){
			int j=i+1;
			System.out.println("第"+j+"个");
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
