package com.gl.dsa.services;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SumPairBST {

	Node root;

	class Node{
		int key;
		Node left;
		Node right;
	}

	Node newNode(int key){
		Node newNode = new Node();
		newNode.key = key;
		newNode.left = null;
		newNode.right = null;
		return newNode;

	}
	void insert(int key){
		root = insertValues(root, key);
	}


	Node insertValues(Node root , int key){
		if(root == null) {
			root = newNode(key);
		}
		else{
			if(key < root.key) {
				root.left = insertValues(root.left, key);
			} else if(key > root.key) {
				root.right = insertValues(root.right, key);	
			}
		}
		return root;
	}

	void InOrderTraversal(Node node){
		if(node == null) {
			return;
		}
		InOrderTraversal(node.left);
		System.out.print(node.key+" ");
		InOrderTraversal(node.right);
	}

	ArrayList<Integer> inOrderList(Node node , ArrayList<Integer> list){


		if(node == null) {
			return list;
		}
		inOrderList(node.left, list);
		list.add(node.key);
		inOrderList(node.right, list);
		return list;

	}


	boolean findSumPair(Node node, int sum){

		ArrayList<Integer> temp = new ArrayList<>();
		ArrayList<Integer> list = inOrderList(node, temp);
		int start = 0;
		int end = list.size() - 1;
		while(start < end) {
			if(list.get(start) + list.get(end) == sum ) {
				System.out.println("Pair Found: "+list.get(start) +" + "+list.get(end)+" = "+sum);
				return true;
			} else if (list.get(start) + list.get(end)  > sum) {
				end--;
			}
			else if (list.get(start) + list.get(end)  < sum) {
				start++;
			}
		}
		System.out.println("no pair found ");
		return false;
	}
	public static void main(String[] args) {
		SumPairBST obj = new SumPairBST();
		obj.insert(40);
		obj.insert(20);
		obj.insert(60);
		obj.insert(10);
		obj.insert(30);
		obj.insert(50);
		obj.insert(70);
		obj.InOrderTraversal(obj.root);
		obj.findSumPair(obj.root, 40);

	}

}
