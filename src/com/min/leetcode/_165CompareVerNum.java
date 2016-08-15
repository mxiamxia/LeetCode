package com.min.leetcode;

public class _165CompareVerNum {

	/**
	 * Compare two version numbers version1 and version2.
		If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
		
		You may assume that the version strings are non-empty and contain only digits and the . character.
		The . character does not represent a decimal point and is used to separate number sequences.
		For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
		
		Here is an example of version numbers ordering:
		
		0.1 < 1.1 < 1.2 < 13.37
		
		从两个string最左边开始比较，
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compareVersion("1.0.1", "1");

	}
	
	public static int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int i = 0;
        while(i < len1 && i < len2) {
            if ( Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]) ) {
                return 1;
            } else if ( Integer.parseInt(v1[i]) < Integer.parseInt(v2[i]) ) {
                return -1;
            } else {
                i++;
                continue;
            }
        } 
        while (i < len1) {
            if (Integer.parseInt(v1[i]) != 0) {
                return 1;
            }
            i++;
        }
        while (i < len2) {
            if (Integer.parseInt(v2[i]) != 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }

}
