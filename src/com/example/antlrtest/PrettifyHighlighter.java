package com.example.antlrtest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import prettify.PrettifyParser;
import syntaxhighlight.ParseResult;
import syntaxhighlight.Parser;
/**
 * Highlight class used in syntax highlighting
 * @author cbreathnach
 *
 */
public class PrettifyHighlighter {
    private static final Map<String, String> COLORS = buildColorsMap();

    private static final String FONT_PATTERN = "<font color=\"#%s\">%s</font>";

    private final Parser parser = new PrettifyParser();

    public String highlight(String fileExtension, String sourceCode) {
        StringBuilder highlighted = new StringBuilder();
        List<ParseResult> results = parser.parse(fileExtension, sourceCode);
        System.out.println(results);
        for(ParseResult result : results){
            String type = result.getStyleKeys().get(0);
            String content = sourceCode.substring(result.getOffset(), result.getOffset() + result.getLength());
            highlighted.append(String.format(FONT_PATTERN, getColor(type), content));
        }
        return highlighted.toString();
    }

    private String getColor(String type){
        return COLORS.containsKey(type) ? COLORS.get(type) : COLORS.get("pln");
    }

    private static Map<String, String> buildColorsMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("typ", "87cefa");
        map.put("kwd", "87cefa");//function names
        map.put("lit", "78AB46");//variables
        map.put("com", "ff0000");
        map.put("str", "ff4500");
        map.put("pun", "ff9900");//brackets
        map.put("pln", "ff0000");
        return map;
    }
}