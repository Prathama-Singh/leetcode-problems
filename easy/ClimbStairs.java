class ClimbStairs {
    public int getSteps(int n) {
        if(n == 1)
            return 1;
        int i = 1,j=1;
        int k = i+j;
        for(int x = 2; x < n; x++){
            i = j;
            j = k;
            k = i+j;
        }
        return k;
    }
}
