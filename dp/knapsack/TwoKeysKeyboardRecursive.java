class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        return (1 + helper(1, 1, n));
    }

    int helper(int count, int clipboard, int n){
        if(count == n)
            return 0;
        if(count > n )
            return 1000;

        //paste      
        int paste = 1 + helper(count + clipboard, clipboard, n);
        
        //copy + paste
        int copyallPaste = 2 + helper (count + count, count, n);
        return Math.min (paste, copyallPaste);
    }
    
}
