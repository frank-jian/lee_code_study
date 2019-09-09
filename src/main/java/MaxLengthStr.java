import java.util.HashSet;
import java.util.Set;

/**
 * @description: <p></p>
 * @author: terui
 * @date: 2019/9/9 6:33 下午
 */
public class MaxLengthStr {

    /**
     * 滑动窗口解决方案
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0;
        int j = 0;

        while (i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 时间复杂度n*n*n
     * 解法1：时间复杂读太高了 O(n*n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        char[] chars = new char[len];
        s.getChars(0, len, chars, 0);
        int maxLen = 0;
        char[] subChars = new char[len];

        for (int i = 0; i < len; i++) {
            int k = 0;
            subChars[k] = chars[i];
            for (int j = i + 1; j < len; j++) {
                char c = chars[j];
                if (isExist(c, subChars)) {
                    break;
                } else {
                    k = k + 1;
                    subChars[k] = c;
                }
            }
            subChars = new char[len];
            if (k + 1 > maxLen) {
                maxLen = k + 1;

            }
        }

        return maxLen;
    }

    private boolean isExist(char b, char[] subChars) {
        for (char b1 : subChars) {
            if (b1 == b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int length = new MaxLengthStr().lengthOfLongestSubstring("aaaaa");
        System.out.println(length);
    }
}
