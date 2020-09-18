class Solution {
    //(a+bi)(c+di) = ac + adi + bci + bdi^2
    public String complexNumberMultiply(String a, String b) {
        String[] str1 = a.split("\\+");
        String[] str2 = b.split("\\+");
        int A = Integer.parseInt(str1[0]);
        int B = Integer.parseInt(str1[1].split("i")[0]);
        int C = Integer.parseInt(str2[0]);
        int D = Integer.parseInt(str2[1].split("i")[0]);

        return (A * C - B * D) + "+" + (A * D + B * C) + "i";


    }
}