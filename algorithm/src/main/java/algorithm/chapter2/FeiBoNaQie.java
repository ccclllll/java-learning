package algorithm.chapter2;

public class FeiBoNaQie {
    public static int getN(int n) {
        int min = 1,max = 1,center,count = 1;
        while (count < n) {
            count++;
            if (count <= 2) { continue; }
            center = max;
            max = min + max;
            min = center;
        }
        return max;
    }
    public static int getN2(int n){
        if(n == 1 || n==2)
            return 1;
        int pre = 1;
        int next = 1;
        int index = 3;
        while(index++<=n){
            int mid = next;
            next = next+pre;
            pre= mid;

        }
        return next;
    }

    public static int getNByRecursion(int n) {
        if (n == 1 || n == 2) { return 1; }
        return getNByRecursion(n - 1) + getNByRecursion(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("n : " + getN(10));
        System.out.println("n : " + getN2(10));

    }
}
