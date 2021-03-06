package alioune.test;

import java.util.Comparator;

import java.util.*;

/*Write your code here. DO NOT use access modifiers (e.g.: 'public') in your class declarations.*/
class ComparatorValue implements Comparator<Object> {
    
    public boolean compare(int a, int b) {
        if(a==b)
            return true;
        return false;
    }
    
    
     public boolean compare(int[] a, int[] b) {
        if(a.length == b.length)
            return true;
        return false;
    }

    public int compare(Object o1, Object o2) {
        if( o1 instanceof String && o2 instanceof String) {
            
            if(o1.equals(o2))
            return 1;
        }
        return -1;
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ComparatorValue comp = new ComparatorValue();
        
        int testCases = Integer.parseInt(scan.nextLine());
        while(testCases-- > 0){
            int condition = Integer.parseInt(scan.nextLine());
            switch(condition){
                case 1:
                    String s1=scan.nextLine().trim();
                    String s2=scan.nextLine().trim();
                    
                    System.out.println( (comp.compare(s1,s2)) >1 ? "Same" : "Different" );
                    break;
                case 2:
                    int num1 = scan.nextInt();
                    int num2 = scan.nextInt();
                    
                    System.out.println( (comp.compare(num1,num2)) ? "Same" : "Different");
                    if(scan.hasNext()){ // avoid exception if this last test case
                        scan.nextLine(); // eat space until next line
                    }
                    break;
                case 3:
                    // create and fill arrays
                    int[] array1 = new int[scan.nextInt()];
                    int[] array2 = new int[scan.nextInt()];
                    for(int i = 0; i < array1.length; i++){
                        array1[i] = scan.nextInt();
                    }
                    for(int i = 0; i < array2.length; i++){
                        array2[i] = scan.nextInt();
                    }
                    
                    System.out.println( comp.compare(array1, array2) ? "Same" : "Different");
                    if(scan.hasNext()){ // avoid exception if this last test case
                        scan.nextLine(); // eat space until next line
                    }
                    break;
                default:
                    System.err.println("Invalid input.");
            }// end switch
        }// end while
        scan.close();
    }
}