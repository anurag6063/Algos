class RemoveDuplicatesFromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII_80 solution = new RemoveDuplicatesFromSortedArrayII_80();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int len = solution.removeDuplicates(nums);
        System.out.println(len); // 5
    }
}