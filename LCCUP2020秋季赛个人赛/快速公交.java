/*
小扣打算去秋日市集，由于游客较多，小扣的移动速度受到了人流影响：

小扣从 x 号站点移动至 x + 1 号站点需要花费的时间为 inc；
小扣从 x 号站点移动至 x - 1 号站点需要花费的时间为 dec。
现有 m 辆公交车，编号为 0 到 m-1。小扣也可以通过搭乘编号为 i 的公交车，从 x 号站点移动至 jump[i]*x 号站点，耗时仅为 cost[i]。小扣可以搭乘任意编号的公交车且搭乘公交次数不限。

假定小扣起始站点记作 0，秋日市集站点记作 target，请返回小扣抵达秋日市集最少需要花费多少时间。由于数字较大，最终答案需要对 1000000007 (1e9 + 7) 取模。

注意：小扣可在移动过程中到达编号大于 target 的站点。
*/

class Solution {
    
            public long dis(long pt){
            if(mp.containsKey(pt)){
                return mp.get(pt);
            }
            return 100000000000000000L;
        }

        Map<Long,Long> mp= new HashMap<>();
        Set<Long> in  = new HashSet<>();
        public int busRapidTransit(int tt, int inc, int dec, int[] jump, int[] cost) {

            long q[] = new long[10000000];
            int e  = 0;
            q[e++] = (long)tt;

            mp.put((long)tt,0L);
            in.add((long)tt);



            int s = 0;
            while(s<e){

                long cur = q[s++];

                in.remove(cur);
                if(cur==0) continue;

                if(dis(cur)+inc*cur<dis(0L)){

                    mp.put(0L,dis(cur)+inc*cur);

                }


                for(int jj=0;jj<jump.length;++jj){

                    long g = cur/jump[jj];



                    long to = g;

                    if(dis(cur)+inc*(cur-jump[jj]*g) + cost[jj]< dis(to)){

                        mp.put(to,dis(cur)+inc*(cur-jump[jj]*g)+cost[jj]) ;


                        if(!in.contains(to)){
                            q[e++] = to;
                            in.add(to);
                        }
                    }

                    if(dis(cur)+inc*(cur-to)< dis(to)){

                        mp.put(to,dis(cur)+inc*(cur-to)) ;


                        if(!in.contains(to)){
                            q[e++] = to;
                            in.add(to);
                        }
                    }

                    if(g*jump[jj]<cur){

                        to  = g+1;


                        if(dis(cur)+dec*(jump[jj]*to-cur) + cost[jj]< dis(to)){

                            mp.put(to,dis(cur)+dec*(jump[jj]*to-cur)+cost[jj]) ;


                            if(!in.contains(to)){
                                q[e++] = to;
                                in.add(to);
                            }
                        }


                        if(dis(cur)+inc*(cur-to)< dis(to)){

                            mp.put(to,dis(cur)+inc*(cur-to)) ;


                            if(!in.contains(to)){
                                q[e++] = to;
                                in.add(to);
                            }
                        }







                    }






                }



            }

            return (int)(mp.get(0L)%1000000007L);

        }
}