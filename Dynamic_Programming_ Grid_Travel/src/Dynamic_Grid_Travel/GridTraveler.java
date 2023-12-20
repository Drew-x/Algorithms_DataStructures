package Dynamic_Grid_Travel;

public class GridTraveler {

	
	
	public int grid(int m, int n) {
		
		if (m == 1 && n == 1) {
			
			return 1;
		}
		
		if (m == 0 || n == 0) {
			return 0;
		}
		
		return grid(m-1, n) + grid(m, n-1);
	}
	
	static long[][] z = new long[100][100];
	
	public long grid2(long[][] x, int m, int n) {
		
		//x = new long[m][n];
		//System.out.println("h"+  x.length);
		//System.out.println("b"+ x.length);
		
		if (x[m][n] != 0) {
			return  x[m][n];
		}
		
		System.out.println("pas1");
		if (m == 1 & n == 1) {
			
			return 1;
		}
		
		System.out.println("pas2");
		if (m <= 0 || n <= 0) {
			return 0;
		}
		
		System.out.println("pas3");
		x[m][n] = grid2(x, m -1 ,n) + grid2(x, m, n-1);
		z = x; 
		return x[m][n];
	}
	
}
