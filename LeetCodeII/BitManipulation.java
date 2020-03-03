import java.util.Arrays;

class BitManipulation{


    // count bits in O(n)
    public static int[] countBits(int num){
        // dp[i] = number of 1s in i
        int dp[] = new int[num+1];
        for(int i=1; i<num+1; i++){
            dp[i]=dp[i>>1]+ (i&1);
        }
        return dp;
    }

    // implement + 
    // -n = ~n+1 
    public static int getSum(int a, int b){
        while(b!=0){
            int carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }

    // implement -
    public static int getSubstract(int a, int b){
        while(b!=0){
            int borrow = (~a)&b;
            a=a^b;
            b=borrow<<1;
        }
        return a;
    }

    // implement *
    // a * b = a *(b[i]* 2^0 + b[i]* 2^i..)
    public static int getProduct(int a, int b){
        int result=0;
        while(b!=0){
            if((b&1) != 0){
                result=getSum(a, result);
            }
            a<<=1;
            b>>>=1;
        }
        return result;
    }

    // negative 
    public static int getNegate(int x){
        return ~x+1;
    }

    //count 1 / hamming weight
    public static int countOne(int n){
        int count=0;
        while(n>0){
            n=n&(n-1); // remove last bit 1
            count++;
        }
        return count;
    }

    public static int countOne2(int n){
        int count=0, mask=1;
        for(int i=0; i<32; i++){
            if((mask&n)!=0) count++;
            mask<<=1;
        }
        return count;
    }



    public static void main(String[] args) {
        // System.out.println(Arrays.toString(BitManipulation.countBits(5)));
        // System.out.println(BitManipulation.getSum(-1, 3));
        // System.out.println(BitManipulation.getProduct(3, -2));
        // System.out.println(BitManipulation.getSubstract(2, 1));
        System.out.println(BitManipulation.countOne2(5));

        
    }

}