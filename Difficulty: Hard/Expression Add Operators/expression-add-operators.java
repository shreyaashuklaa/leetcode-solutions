import java.util.*;
class Solution {
    ArrayList<String> ans = new ArrayList<>();
    private void solve(String num, int target,int index,String path, long currentValue,long prevOperand) {
        // Base Case
        if (index == num.length()) {
            if (currentValue == target) {
                ans.add(path);
            }
            return;
        }
        // Generate all possible numbers
        for (int i = index; i < num.length(); i++) {
            // Handle leading zeros
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            String currStr = num.substring(index, i + 1);
            long currNum = Long.parseLong(currStr);
            // First number in expression
            if (index == 0) {
                solve(num, target,i + 1,currStr,currNum,currNum);
            }
            else {
                // +
                solve(num, target,i + 1, path + "+" + currStr,currentValue + currNum,currNum);
                // -
                solve(num,target,i + 1, path + "-" + currStr,currentValue - currNum,-currNum);
                // *
                solve(num, target, i + 1,path + "*" + currStr,currentValue - prevOperand + (prevOperand * currNum),prevOperand * currNum);
            }
        }
    }
    ArrayList<String> findExpr(String S, int target) {
        ans.clear();
        solve(S,target,0,"",0,0);
        return ans;
    }
}