class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int total = n+m;

        int[] numsSet = new int[total];

        for(int i = 0 ; i < n ; i++) numsSet[i] = nums1[i];
        for(int i = n ; i < total ; i++) numsSet[i] = nums2[i-n];

        Arrays.sort(numsSet);

        if(total%2 == 0) return (numsSet[total/2] + numsSet[(total/2)-1])/2.0;

        else return numsSet[total/2];
        
    }
}
