package com.example.antlrtest;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.MultiAutoCompleteTextView.Tokenizer;

public class SColonTokenizer implements Tokenizer {

	public int findTokenStart(CharSequence text, int cursor) {
		System.out.println("Find token start");
		
		int i = cursor;

		while (i > 0 && text.charAt(i - 1) != ';') {
			i--;
		}
		if ((i+4<cursor) && (text.subSequence(i, i+4).toString().equals("<br>"))) {
			i+=4;
		}
		while (i < cursor && (text.charAt(i) == ' ' || text.charAt(i) == '\n')) {
			i++;
		}

		return i;
	}

	public int findTokenEnd(CharSequence text, int cursor) {
		System.out.println("Find token end");
		int i = cursor;
		int len = text.length();

		while (i < len) {
			if (text.charAt(i) == ';') {
				return i;
			} else {
				i++;
			}
		}

		return len;
	}

	public CharSequence terminateToken(CharSequence text) {
		int i = text.length();

		while (i > 0 && text.charAt(i - 1) == ' ') {
			i--;
		}

		if (i > 0 && text.charAt(i - 1) == ';') {
			return text;
		} else {
			if (text instanceof Spanned) {
				SpannableString sp = new SpannableString(text + "");
				TextUtils.copySpansFrom((Spanned) text, 0, text.length(),
						Object.class, sp, 0);
				return sp;
			} else {
				return text;
			}
		}
	}
}