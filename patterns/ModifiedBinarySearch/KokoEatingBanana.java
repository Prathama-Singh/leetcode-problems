public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int maxSpeed = 0 ; 
        for(int i = 0; i < len; i++){
            maxSpeed = Math.max(maxSpeed, piles[i]);
        }
        int minSpeed = maxSpeed;
        int left = 1; int right = maxSpeed;
        while(left <= right){
            int k = (left+right)/2;
            int hours = 0;
            for(int j = 0; j < len; j++){
                hours += Math.ceil(piles[j]/(double)k);
            }
            if(hours <= h){
                minSpeed = Math.min(minSpeed, k);
                right = k-1;
            }else
                left = k+1;   
        }
        return minSpeed;
    }
}
