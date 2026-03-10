class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        int l = 0, r = len-1;
        while(l < r){
            int area = Math.min(height[r],height[l]) * (r - l);
            maxArea = Math.max(maxArea, area);
            if(height[r] < height[l])
                r--;
            else l++;
        }
        return maxArea;
    }
}
