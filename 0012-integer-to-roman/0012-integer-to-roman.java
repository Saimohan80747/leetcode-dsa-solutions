class Solution {
    void decompose(int d,StringBuilder sb,int zeros){
        if(d==4){
            if(zeros==0) sb.insert(0,"IV");
            else if(zeros==1) sb.insert(0,"XL");
            else if(zeros==2) sb.insert(0,"CD"); 
        }else if(d==9){
            if(zeros==0) sb.insert(0,"IX");
            else if(zeros==1) sb.insert(0,"XC");
            else if(zeros==2) sb.insert(0,"CM"); 
        }else if(d>=5){
            d=d-5;
            if(zeros==0){
               while(d-->0) sb.insert(0,'I');
               sb.insert(0,'V');
            }else if(zeros==1){
               while(d-->0) sb.insert(0,'X');
               sb.insert(0,'L');
            }else if(zeros==2){
               while(d-->0) sb.insert(0,'C');
               sb.insert(0,'D');
            }
        }else{
            if(zeros==0){
               while(d-->0) sb.insert(0,'I');
            }else if(zeros==1){
                while(d-->0) sb.insert(0,'X');
            }else if(zeros==2){
                while(d-->0) sb.insert(0,'C');
            }else{
                while(d-->0) sb.insert(0,'M'); 
            }
        }
    }
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        int digit=0,idx=0;
        while(num!=0){
            digit=num%10;
            decompose(digit,sb,idx);
            idx++;
            num/=10;
        }
        return sb.toString();
    }
}