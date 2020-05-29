package com.leaf.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tongshujian
 * @date 2020/5/26
 */
public class Lc287 {

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int i : nums ){
            if(set.contains(i)){
                return i;
            }else{
                set.add(i);
            }
        }
        return 0;
    }

}
