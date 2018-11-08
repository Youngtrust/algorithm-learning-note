class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) 
            return 0;
        if(haystack.length()==0 || haystack.length() < needle.length())
            return -1;
        int [] nFreq = new int[needle.length()];
        int [] hFreq = new int[needle.length()];        
        for(int i = 0 ; i < needle.length();i++)
            nFreq[i] = needle.charAt(i)-'a';
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++)
        {
            for(int j = 0; j < needle.length();j++)
                hFreq[j] = (haystack.charAt(j+i)-'a');
            if(count(hFreq,nFreq))
                return i;
        }
        return -1;
    }
    
    boolean count(int [] freq1, int[] freq2)
    {
        for(int i = 0 ; i < freq1.length; i++)
        {
            if(freq1[i]!=freq2[i])
                return false;
        }
        return true;
    }
}