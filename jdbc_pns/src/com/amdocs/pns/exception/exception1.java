package com.amdocs.pns.exception;

public class exception1 extends Exception{
	String alert;
	public exception1(String str) {
		alert = str;
	}
	public String toString() {
		return("Something went wrong " + alert);
	}
}
