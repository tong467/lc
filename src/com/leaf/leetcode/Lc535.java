package com.leaf.leetcode;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import sun.security.provider.MD5;

/**
 * @author tongshujian
 * @date 2022/6/29
 */
public class Lc535 {

    public static void main(String[] args) {

    }


}

class Codec {

    private ConcurrentHashMap<String, String> urlMap = new ConcurrentHashMap();


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String uuid = UUID.randomUUID().toString();
        while (urlMap.contains(uuid)) {
            uuid = UUID.randomUUID().toString();
        }
        urlMap.put(uuid, longUrl);
        return "http://tinyurl.com/" + uuid;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl.replace("http://tinyurl.com/",""));
    }
}
