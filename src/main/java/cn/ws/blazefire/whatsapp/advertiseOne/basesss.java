package cn.ws.blazefire.whatsapp.advertiseOne;

import cn.ws.blazefire.whatsapp.EmojiUtil;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-06-14 14:41
 */
public class basesss {
    public static void main(String[] args) {
        String s = "\uD83D\uDE00\uD83D\uDE01\uD83D\uDE02\uD83D\uDE03\uD83D\uDE04123，OK~~~！！！ hello,你好~";

        String s1 = EmojiUtil.emojiConverterToAlias(s);
        System.out.println(s1);
        System.out.println(EmojiUtil.emojiConverterUnicodeStr("\uD83D\uDE00\uD83D\uDE01\uD83D\uDE02\uD83D\uDE03\uD83D\uDE04123，OK~~~！！！ hello,你好~"));
    }
}
