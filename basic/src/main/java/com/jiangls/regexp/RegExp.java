package com.jiangls.regexp;

import java.util.Arrays;
import java.util.List;

public class RegExp {
    public static void main(String[] args) {
        String source = "</p>4688888888</p>\n" +
                "<figure class=\"image image_resized image-style-align-left\" style=\"width:50%;\"><img src=\"/api/mailTemplate/imgDownload?id=85c0a71187d1427c9af354b96e235a43\"></figure>\n" +
                "<figure class=\"image image_resized image-style-align-right\" style=\"width:50%;\"><img src=\"/api/mailTemplate/imgDownload?id=994bfde9d40f432eb82954bc4cdc4029\"></figure>";
        List<String> idList = Arrays.asList("85c0a71187d1427c9af354b96e235a43", "994bfde9d40f432eb82954bc4cdc4029");

        for(String id : idList) {
            String reg = "<img[\\W]*src=[\'\"][/].+?\\?id=" + id + "[\'\"]>";
            String replacement = "<img src='cid:" + id + "'>";
            source = source.replaceAll(reg, replacement);
        }

        System.out.println(source);
    }
}
