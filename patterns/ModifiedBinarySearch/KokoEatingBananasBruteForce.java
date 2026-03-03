public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int max = 0 ;
        for(int i = 0; i < len; i++){
            max = Math.max(max, piles[i]);
        }
        int res = max;
        for(int currSpeed = 1; currSpeed <= max; currSpeed++){
            int hours = 0;
            for(int j = 0; j < len; j++){
                hours += (int) Math.ceil(piles[j]/(double)currSpeed);
            }
            if(hours <= h)
                res = Math.min(res, currSpeed);
        }
        return res;
    }
}
