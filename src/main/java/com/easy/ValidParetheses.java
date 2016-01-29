package com.easy;

import java.util.Stack;

/**
 * Created by xhans on 2016/1/28.
 */
public class ValidParetheses {
    public boolean isValid(String s){
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == ')'){
                if (st.isEmpty() || st.pop() != '('){
                    return false;
                }
            }else if (ch == ']'){
                if (st.isEmpty() || st.pop() != '['){
                    return false;
                }
            }else if (ch == '}'){
                if (st.isEmpty() || st.pop() != '{'){
                    return false;
                }
            }else {
                st.push(ch);
            }
        }
        if (st.size() == 0){
            return true;
        }else {
            return false;
        }

    }
}
