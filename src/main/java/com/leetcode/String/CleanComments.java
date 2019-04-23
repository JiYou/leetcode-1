package com.leetcode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhcxx on 18/10/27.
 */
public class CleanComments {

	/*
	   @param String arrays with every line of the code
	   @return cleaned code by removing the comments
	 */
	public static List<String> cleanComments(String[] inputs) {
		List<String> res = new ArrayList<>();  // return result of list cleaned comments strings
		StringBuilder sb = new StringBuilder(); //
		int line = 0, column = 0;  // line means every line of the String arrays,  column means every column index of the line
		boolean isBlockComment = false;  // means the block comment;
		while (line < inputs.length) {
			// /*
			//int indexOfColon = inputs[line].indexOf("\"");
			int index1, index2, indexOfColon;

				if (isBlockComment) {
					int index = inputs[line].indexOf("*/", column);
					if (index == -1) {
						line++;
						column = 0;
					} else {
						isBlockComment = false;
						column = index + 2;
					}
				} else {
					 index1 = inputs[line].indexOf("/*", column);
					 index2 = inputs[line].indexOf("//", column);
					 indexOfColon = inputs[line].indexOf("\"");

					if (indexOfColon == -1) {
						if (index1 == -1)
							index1 = inputs[line].length();
						if (index2 == -1)
							index2 = inputs[line].length();

						for (int i = column; i < Math.min(index1, index2); i++) {
							sb.append(inputs[line].charAt(i));
						}

						if (index2 <= index1) {
							if (sb.length() > 0) {
								res.add(new String(sb));
								sb.setLength(0);
							}
							line++;
							column = 0;
						} else {
							isBlockComment = true;
							column = index1 + 2;
						}
					} else {
						if (indexOfColon <= index2) {
							sb.append(inputs[line]);
						}
					}
				}
			}
			return res;
		}

		public static void main(String[] args) {
			String[] test = new String[] {"int main()", "{ ", "// dedwdww  " , "int a, b, c;", "/* This is a test", " multiline ", "comment for ", "testing */", "String a = \"http://www.com\"", "}"};
			List<String> res = cleanComments(test);
			System.out.println(res);
		}


}


