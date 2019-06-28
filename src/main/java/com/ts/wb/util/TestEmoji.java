package com.ts.wb.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.json.JSONObject;

import com.google.common.collect.Maps;
import com.vdurmont.emoji.EmojiParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestEmoji {
	
	public static void main(String[] args) {
		String name = "😄";
        System.out.println("带有emoji表情的字符串打印效果: " + name);
        System.out.println("去掉emoji表情的字符串打印效果: " + EmojiParser.removeAllEmojis(name));
        System.out.println("将emoji表情转换成别名的形式: " + EmojiParser.parseToAliases(name));
        System.out.println("将emoji表情转换成html十进制表示: " + EmojiParser.parseToHtmlDecimal(name));
        System.out.println("将emoji表情转换成html十进制表示: " + EmojiParser.parseToUnicode(name));
        
        
        
        Pattern p = Pattern.compile("[^\\u0000-\\uFFFF]");
        Matcher m = p.matcher(name);
        System.out.println(m.find());
	}
	
}
