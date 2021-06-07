package com.jiangls.regexp;

import java.util.Arrays;
import java.util.List;

public class RegExp {
    public static void main(String[] args) {
        String source = "<p>123332543234</p>\n" +
                "<figure class=\"image image-style-align-left image_resized\" style=\"width:50%;\"><img src=\"/api/mailTemplate/imgDownload?id=92bb79cc5774481ea3a05eed599b3796\"></figure>\n" +
                "<figure class=\"image image_resized image-style-align-right\" style=\"width:50%;\"><img src=\"/api/mailTemplate/imgDownload?id=a2212328801348459e6144221a705330\"></figure>";
        List<String> idList = Arrays.asList("a2212328801348459e6144221a705330", "92bb79cc5774481ea3a05eed599b3796");

        for(String id : idList) {
            String reg = "<img[\\W]*src=[\'\"][a-zA-Z0-9/]+\\?id=" + id + "[\'\"]>";
            String replacement = "<img src='cid:" + id + "'>";
            source = source.replaceAll(reg, replacement);
        }

        System.out.println(source);
    }
}
