class Solution {
    public static int maxEnvelopes(int[][] envelopes) {
        int result = 1;
        Arrays.sort(envelopes,(i1,i2)->{
            if(i1[0]>i2[0]) {
                return  1;
            } else if(i1[0]<i2[0]) {
                return -1;
            } else {
               if(i1[1]<i2[1]) {
                   return 1;
               } else {
                   return -1;
               }
            }
        });

        int r[] = new int[envelopes.length];
        r[0] = 1;

        for(int i=1;i<envelopes.length;i++) {
            r[i] = 1;
            int j = 0;
            while (j<i) {
                if(envelopes[i][1]>envelopes[j][1]) {
                    r[i] = Math.max(r[i],r[j]+1);
                    result = Math.max(r[i], result);
                }
                j++;
            }
        }
        return result;
    }
}
