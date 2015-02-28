package easy118.pascalTriangel;
import java.util.*;

public class PascalTriangle {


	//	List<Integer> list; why there is a problem to declare outside the method?

	//Time limit exceeded
	/*	public List<Integer> getRow(int k) {
		List<Integer> list = new LinkedList<Integer>();
		if (k <=0) return null;
		if (k ==1) {
			list.add(1);
			list.add(1);
//			System.out.println(list.get(0));

			return list;
		}
		else {
			list.add(1);
			for(int i =0; i<k-1; i++){
				list.add(getRow(k-1).get(i)+getRow(k-1).get(i+1));
			}
			list.add(1);
			return list;
		}

	}
	
	
	public List<Integer> getRow2(int rowIndex) {
		List<Integer> list = new LinkedList<Integer>();
		if(rowIndex<=0) return null;
		if(rowIndex == 1) {
			list.add(1);
			list.add(1);
			return list;
		}  
		else {
			list.add(1);
			for(int i = 0; i<rowIndex-1 ; i++) {
				list.add(this.getRow2(rowIndex-1).get(i) + this.getRow2(rowIndex-1).get(i+1));
			}
			list.add(1);
			return list;
		}
	}
	*
	*/

	public static void main (String[] args) {
		PascalTriangle p = new PascalTriangle();
//		System.out.println(p.getRow(3));
		System.out.println(p.generate(3));
	}

	public List<Integer> getRow(int rowIndex){
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0 ; i <= rowIndex ; i++ ) {
			list.add(0);
		}
		list.set(0, 1);
		
		// remind that the inner loop is a reverse sequence
		for (int i = 0 ; i < rowIndex ; i++){
			for (int j =i ; j>=0 ; j--) {
				list.set(j+1,((Integer)(list.get(j))+(Integer)(list.get(j+1))));
			}
		}
		
		return list;
		
	}
	
    public List<List<Integer>> generate(int numRows) {
    	// watch out the initialization steps
        List<List<Integer>> totalList = new LinkedList<List<Integer>>();
        
        // remind that this case the row is containing the [1] as first line.
        for(int i = 0; i < numRows; i++){
        	if(numRows == 0) break;
        	List<Integer> list = new LinkedList<Integer>();           
            //watch out the special cases like the = 0
            
            
            for (int k = 0; k<= i; k++) {
            list.add(0);
            }
            list.set(0,1);
            for (int k = 0 ; k< i; k++) {
                for (int j = k; j >= 0; j--) {
                    list.set(j+1, (Integer)(list.get(j))+(Integer)(list.get(j+1)));
                }
            }
            totalList.add(list);
        }
        return totalList;
    }

}


