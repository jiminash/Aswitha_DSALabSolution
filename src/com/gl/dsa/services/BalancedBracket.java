package com.gl.dsa.services;

import java.util.Stack;

public class BalancedBracket {

	boolean checkBalancedBracket(String str){
		int size = str.length();
		boolean flag = true;
		Stack< Character> stack = new Stack<>();

		for(int i = 0 ; i < size ; i++) {
			char x = str.charAt(i);
			if(x == '('  || x == '['   || x == '{'  ) {
				stack.push(x);
			}
			else {
				if(stack.empty()) {
					flag = false;
				}
				else {
					char pop = stack.pop();

					switch(x) {
					case ')':
						if(pop == '{' || pop == '[') {
							flag = false;
						}
						break;
					case '}':
						if(pop == '(' || pop == '[') {
							flag = false;
						}
						break;
					case ']':
						if(pop == '(' || pop == '{') {
							flag = false;
						}
						break;
					}
				}
			}
			if(flag == false) {
				return flag;
			}
		}

		return flag;

	}

	public static void main(String[] args) {
		String str = "({})";
		BalancedBracket blbr = new BalancedBracket();
		if(blbr.checkBalancedBracket(str) == true) {
			System.out.println("Balanced Brackets");
		}
		else {
			System.out.println("Unbalanced Brackets");
		}

	}

}
