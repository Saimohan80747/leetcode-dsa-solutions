class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();
        
        if (numerator == 0) return "0";
        
        if ((numerator < 0) ^ (denominator < 0)) sb.append('-');
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        long integerPart = num / den;
        sb.append(integerPart);
        
        long rem = num % den;
        if (rem == 0) return sb.toString();
        
        sb.append(".");
        int idx = sb.length();
        
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int repeatIdx = map.get(rem);
                sb.insert(repeatIdx, "(");
                sb.append(")");
                break;
            }
            
            map.put(rem, idx++);
            rem *= 10;
            sb.append(rem / den);
            rem = rem % den;
        }
        
        return sb.toString();
    }
}