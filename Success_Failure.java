package Linear_Search;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * 一维搜索之成功失败法：
 * 算法步骤：
 * 利用“成功-失败”法求函数φ(λ)=λ^3-2λ+1的搜索区间，1 -2 0 1
 * 取初始点λ0=-1/2,步长h0=1/2
 */
public class Success_Failure {
    private Double phi =new Double(0);
    double  lambda=0;
    double a0,a1,a2,a3;
    ArrayList<Double> ar = new ArrayList();
    Scanner in = new Scanner(System.in);

    public ArrayList<Double> method_Suc_Fai(){
        System.out.println("请分别输入零次项：a0，一次项：a1，二次项：a2和三次项a3：");
        //构建函数，以φ(λ)=λ^3-2λ+1为例
        double a0 = in.nextDouble();
        double a1 = in.nextDouble();
        double a2 = in.nextDouble();
        double a3 = in.nextDouble();
        System.out.println("请输入步长h：");
        double h = in.nextDouble();
        System.out.println("请输入下限lambda：");
        double lambda = in.nextDouble();

        ar.add(lambda);      //记录区间下限
    //1、计算φ(λ0)=φ(-1/2)=15/8, k=0
        phi = a3*Math.pow(lambda,3)+a2*Math.pow(lambda,2)+a1*lambda+a0;
        Double phi0 = phi;
    //2、令λ1=λ1+h0，计算φ(λ1)，然后比较φ(λ1)和φ(λ0)，若前者大则步长加倍，否则搜索失败，停止迭代
        lambda = lambda + h;
        ar.add(lambda);
        phi = a3*Math.pow(lambda,3)+a2*Math.pow(lambda,2)+a1*lambda+a0;
        while(phi<phi0){
            phi0 = phi;
            h = 2 * h;
            lambda = lambda + h;
            ar.add(lambda);
            phi = a3*Math.pow(lambda,3)+a2*Math.pow(lambda,2)+a1*lambda+a0;
        }

            System.out.println("迭代成功，区间是："+"["+ar.get(ar.size()-3)+","+lambda+"]");
        return ar;
    //3、确定搜索区间，大小大
    }
}
