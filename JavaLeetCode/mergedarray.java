public class mergedarray {
    public static void main (String[]args){
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};;
        int j = 0;
            for (int i = 0; i < nums1.length ;i++){
                if (nums1[i] == 0 && j < nums2.length){
                    nums1[i] = nums2[j];
                    j++;
                }
            }
        int temp = 0;
        for (int i =0; i < nums1.length; i++){
            for (int x = 0; x < nums1.length ; x++){
                if (nums1[x] > nums1[i]){
                    temp = nums1[x];
                    nums1[x] = nums1[i];
                    nums1[i] = temp;
                }
            }
        }
        for (int i = 0; i < nums1.length;i++){
                System.out.print(nums1[i] + " ");
        }   
        
    }
}