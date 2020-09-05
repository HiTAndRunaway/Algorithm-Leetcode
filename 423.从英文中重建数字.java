class Solution {
    public String originalDigits(String s) {
        int[] book = new int[10];
        for(int i=0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == 'z')book[0]++;
            else if(c == 'w') book[2]++;
            else if(c == 'x') book[6]++;
            else if(c == 's') book[7]++; //s_cnt=six+seven
            else if(c == 'g') book[8]++;
            else if(c == 'u') book[4]++;
            else if(c == 'f') book[5]++; //f_cnt=four+five
            else if(c == 'h') book[3]++; //h_cnt=three+eight
            else if(c == 'i') book[9]++; //i_cnt=five+six+eight+nine
            else if(c == 'o') book[1]++; //o_cnt=zero+one+two+four
        }
        book[7] -= book[6];
        book[5] -= book[4];
        book[3] -= book[8];
        book[9] -= book[5] + book[6] + book[8];
        book[1] -= book[0] + book[2] + book[4];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i < 10;i++){
            for(int j=0;j < book[i];j++){
                sb.append(i);
            }
        }
        return sb.toString();
        

    }
}