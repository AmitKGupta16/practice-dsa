package test;

public class CoinProblem {
//    public static void main(String[] args) {
//        int[] coin = {1,2,5,10,50,100,200,500};
//        int length = coin.length;
//        int amount = 253;
//        int minCoin = 0;
//        for(int i=length-1;i>=0;i--) {
//            while(coin[i] <= amount && amount !=0) {
//                System.out.print(coin[i]);
//                amount = amount -coin[i];
//                minCoin++;
//            }
//        }
//        System.out.println(minCoin);
//    }

    public static void main(String[] args) {
        int minCoin = 1;//2000000000;
        int amt = 42;
        int cnt =0;
        while (minCoin < amt) {
            minCoin *= 5;
        }
        while (amt !=0) {
            if(minCoin <= amt) {
                amt = amt -minCoin;
                cnt = cnt+1;
            } else {
                minCoin = minCoin/5;
            }
        }
        System.out.println(cnt);
    }
}
