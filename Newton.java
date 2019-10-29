package Linear_Search;

/**
 * 牛顿法是一种函数逼近法，基本思想是：
 * 在极小点x*附近用二阶泰勒展开多项式近似f,用二阶泰勒
 * 展开多项式的极小点近似 f 的极小点x*。
 *
 * step1：给定初始点x1，epsilon>0 令k=0
 * step2：计算f`xk f``xk
 * step3：若|f`xk|<epsilon,停止，x*=x，否则转step4
 * step4：计算xk+1=xk-f`(xk)/f``(xk)
 *
 * 计算：fx=x^4-4x^3-6x^2-16x+4
 * 的极小点（x1=6，epsilon=0.01）
 * 一阶导数：f`x=4x^3-12x^2-12x-16
 * 二阶导数：f``=12x^2-24x-12
 * x2=x1-f`(x1)/f``(x1)
 */
public class Newton {

    public void method_Newton(){
        double fx;
        double fxx;
        double x1=6;
        double epsilon = 0.01;

        fx =4*Math.pow(x1,3)-12*Math.pow(x1,2)-12*x1-16; //计算一阶导数
        fxx=12*Math.pow(x1,2)-24*x1-12;                  //计算二阶导数
        int i=0;
        while(fx>epsilon){
            i++;
            x1=x1-fx/fxx;
            fx =4*Math.pow(x1,3)-12*Math.pow(x1,2)-12*x1-16; //计算一阶导数
            fxx=12*Math.pow(x1,2)-24*x1-12;                  //计算二阶导数
            System.out.println("Newton{x1="+x1+
                    "  fx="+fx+
                    "  fxx="+fxx+
                    "   i="+i+
                    "}"
                    );

        }
    }

}
