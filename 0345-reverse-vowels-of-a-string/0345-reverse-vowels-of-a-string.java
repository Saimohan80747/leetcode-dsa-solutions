class Solution {
    boolean isVowel(char c){
        return c=='a' || c=='e'|| c=='i' || c=='o' 
                || c=='u' || c=='A' || c=='E' || c=='I'|| c=='O' || c=='U';

    }
    void swap(char[] arr,int i,int j){
        char t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public String reverseVowels(String s) {
        char arr[]=s.toCharArray();
        int n=arr.length;
        int l=0,r=n-1;
        while(l<r){
            while(l<r && !isVowel(arr[l])) l++;
            while(l<r && !isVowel(arr[r])) r--;
            swap(arr,l,r);
            l++;
            r--;
        }
        return new String(arr);
    }
}