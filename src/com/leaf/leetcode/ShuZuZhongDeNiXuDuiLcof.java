package com.leaf.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author tongshujian
 * @date 2020/4/24
 */
public class ShuZuZhongDeNiXuDuiLcof {

    public static void main(String[] args) {

        ShuZuZhongDeNiXuDuiLcof shuZuZhongDeNiXuDuiLcof = new ShuZuZhongDeNiXuDuiLcof();

        String str = shuZuZhongDeNiXuDuiLcof.httpURLGETCase();
        str = str.substring(1, str.length() - 1);
        String[] stringArray = str.split(",");

        int[] ints = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            ints[i] = Integer.parseInt(stringArray[i]);
        }
        Long beginTime =System.currentTimeMillis();
        System.out.println(new ShuZuZhongDeNiXuDuiLcof().reversePairs1(ints));
        System.out.println(System.currentTimeMillis()-beginTime);

    }


    private String httpURLGETCase() {

        String methodUrl = "https://leetcode-cn.com/submissions/detail/65593357/testcase/";
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String line = null;
        try {
            URL url = new URL(methodUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Cookie","csrftoken=dkEUSXbWW5CrHV6Ahwa0ARNHhAvyWPok3o7Ld9A0eb6xKxSdTRSVH3fz4ScKXdaz; _uab_collina=157650094587797802364928; __auc=ef54f0c216f0ec766e5591050ce; gr_user_id=816b240d-aa84-41a2-9848-9da3401daee1; grwng_uid=a0e8721d-1cdb-4d87-a241-e288c9a504f6; a2873925c34ecbd2_gr_last_sent_cs1=tong467; _ga=GA1.2.1714515785.1577418091; LEETCODE_SESSION=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuZXh0X2FmdGVyX29hdXRoIjoiLyIsIl9hdXRoX3VzZXJfaWQiOiIzOTE0MCIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImRqYW5nby5jb250cmliLmF1dGguYmFja2VuZHMuTW9kZWxCYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiYTRhMzRmNWUwOWNkZDkxNjY4ZjUzNWYwY2U5MTkxNjQ3ODYyMmNkZSIsImlkIjozOTE0MCwiZW1haWwiOiIiLCJ1c2VybmFtZSI6InRvbmc0NjciLCJ1c2VyX3NsdWciOiJ0b25nNDY3IiwiYXZhdGFyIjoiaHR0cHM6Ly9hc3NldHMubGVldGNvZGUtY24uY29tL2FsaXl1bi1sYy11cGxvYWQvdXNlcnMvdG9uZzQ2Ny9hdmF0YXJfMTU3MzY2MjMxOS5wbmciLCJwaG9uZV92ZXJpZmllZCI6dHJ1ZSwidGltZXN0YW1wIjoiMjAyMC0wNC0xNCAxNToxMjoyMy42MDM3MzQrMDA6MDAiLCJSRU1PVEVfQUREUiI6IjE3Mi4yMS41LjI0NCIsIklERU5USVRZIjoiNTdiMzVmNzVmZWUzYmQyMzY2NGY2YzA2YjdjMDEwNzIifQ.oZlIOcfXdAsPOigotA3xJ0EGkpXZUujK3ctPnNmO-u0; Hm_lvt_fa218a3ff7179639febdb15e372f411c=1586877106,1586877139; __atuvc=8%7C51%2C9%7C52%2C11%7C16%2C5%7C17; a2873925c34ecbd2_gr_session_id=67259fc2-c747-4bc8-90f0-309e12f34426; a2873925c34ecbd2_gr_last_sent_sid_with_cs1=67259fc2-c747-4bc8-90f0-309e12f34426; a2873925c34ecbd2_gr_session_id_67259fc2-c747-4bc8-90f0-309e12f34426=true; __asc=674b64c7171aaf5bb98decc2f4f; Hm_lpvt_fa218a3ff7179639febdb15e372f411c=1587711359; a2873925c34ecbd2_gr_cs1=tong467");
            connection.setRequestMethod("GET");
            connection.connect();// 建立TCP连接
            StringBuilder result = new StringBuilder();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                // 循环读取流
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }
        return "";
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }








    public int reversePairs1(int[] nums) {
        Map<Integer, List<Integer>> diffMap = new TreeMap<>();

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > nums[i]) {
                result++;
            }
            int diff = nums[i] - nums[0];
            List<Integer> list = diffMap.get(diff);
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                diffMap.put(diff, list);
            } else {
                list.add(i);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[0];
            //找到差值大于 diff 的Map;
            diffMap.get(diff);

            for (Entry<Integer, List<Integer>> entry : diffMap.entrySet()) {
                if (entry.getKey() < diff) {
                    List<Integer> indexList = entry.getValue();
                    for (int j = 0; j < indexList.size(); j++) {
                        if (indexList.get(j) > i) {
                            result = result + indexList.size() - j;
                            break;
                        }
                    }

                }
            }
        }

        return result;
    }
}
