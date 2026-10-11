int searchInsert(int* nums, int numsSize, int target) {
   
    if((nums[numsSize-1]<=target)){
           if(nums[numsSize-1]==target){
            return numsSize-1;
           }
         else{return numsSize;}
    }
    if(nums[0]>=target){
        
        printf("hiii");
return 0;
    }
    for(int i=0;i<numsSize;i++){
    if(nums[i]>=target){
         printf("hii");
                 return i;

    }
    }

    return numsSize;

}
// int searchInsert(int* nums, int numsSize, int target) {
//     // Edge cases for first and last positions
//     if (target <= nums[0]) {
//         return 0;
//     }
//     if (target > nums[numsSize - 1]) {
//         return numsSize;
//     }

//     // Traverse through the array to find the insert position
//     for (int i = 0; i < numsSize; i++) {
//         if (nums[i] >= target) {
//             return i;
//         }
//     }
//     // Default return, should not be reached
//     return numsSize;
// }
