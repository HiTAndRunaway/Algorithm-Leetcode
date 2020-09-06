class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(bank == null || bank.length < 1){
            return -1;
        }
        Set<String> mybank = new HashSet<>();
        for(String s : bank){
            mybank.add(s);
        }
        int count = 0;
        Queue<String> q = new LinkedList<>();
        char[] selection = {'A','G','C','T'};
        Set<String> visited = new HashSet<>();
        q.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i < size;i++){
                String curr = q.poll();
                if(curr.equals(end)) return count;
                char[] currArr = curr.toCharArray();
                for(int j=0;j < currArr.length;j++){
                    char pre = currArr[j];
                    for(char ch : selection){
                        currArr[j] = ch;
                        String newstr = new String(currArr);
                        if(!visited.contains(newstr) && mybank.contains(newstr)){
                            visited.add(newstr);
                            q.add(newstr);
                        }
                    }
                    currArr[j] = pre;
                }

            }
            count++;
        }
        return -1;
    }
}