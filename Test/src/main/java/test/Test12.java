package test;


public class Test12 {
    public static void main(String[] args) {
        String str = "ABC";
        //output  ABC, ACB,BAC,BCA


        for(int i=0;i<str.length();i++) {
            String res = "" + str.charAt(i);
            for(int j=0;j<str.length();j++) {

                if(str.charAt(i) != str.charAt(j)) {
                    res = res + str.charAt(j);
                }

            }

            System.out.println(res);

            for(int k=str.length()-1;k>=0;k--) {
               // String res = "" + str.charAt(i);
                if(str.charAt(i) != str.charAt(k)) {
                    res = res + str.charAt(k);

                }

            }
            System.out.println(res);

        }

//        List<String> output = new ArrayList<>();
//        for(int i=0; i< str.length(); i++) {
//        StringBuilder sb= new StringBuilder();
//        sb.append(str.charAt(i));
//        for(int j =i+1; j<str.length();j++) {
//            sb.append(str.charAt(j));
//        }
//        System.out.println(sb.toString());
//    }
}
}
