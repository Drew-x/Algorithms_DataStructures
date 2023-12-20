package Dynamic_Grid_Travel;

import java.util.Iterator;

public class Grid_Travel_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		GridTraveler gridTraveler = new GridTraveler();
		
		long[][] x = new long[100][100];
		long[][] z = new long[100][100];
		
		System.out.println(gridTraveler.grid2(x,18, 18));
		
		z = gridTraveler.z;
		
		
		
//		for (int i = 0; i < z.length; i++) {
//			for (int j = 0; j < z.length; j++) {
//				
//				System.out.print(z[i][j] );
//			}
//			System.out.println();
//		}
		
		
		//System.out.println(gridTraveler.grid2(x, 1, 1 ));
		//System.out.println(gridTraveler.grid2(x,2, 3));
		//System.out.println(gridTraveler.grid2(x,3, 2));
		
		//System.out.println(gridTraveler.grid2(x,18, 18));
		

	}

}
