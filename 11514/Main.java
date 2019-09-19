/*
* @autor: Andres Giovanne Florez Perez
*
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int P[],V[],AT[],CALORIAS[],DEF[];
	static String PB[];
	static Object ANTIA[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int heroe =Integer.parseInt(st.nextToken());
			int villano =Integer.parseInt(st.nextToken());
			if(heroe==0 && villano==0)break;
			P = new int[heroe];
			V = new int[villano];
			int E =Integer.parseInt(st.nextToken());
			PB= new String[heroe];
			AT= new int[heroe];
			CALORIAS= new int[heroe];
			DEF= new int[villano];
			ANTIA= new Object[villano];
			for(int i=0;i<P.length;i++){
				StringTokenizer vl = new StringTokenizer(in.readLine());
				PB[i]=vl.nextToken();
				AT[i]=Integer.parseInt(vl.nextToken());
				CALORIAS[i]=Integer.parseInt(vl.nextToken());
			}
			for(int j=0;j<V.length;j++){
				StringTokenizer vl2 = new StringTokenizer(in.readLine());
				String pasar = vl2.nextToken();
				DEF[j]=Integer.parseInt(vl2.nextToken());
				String guarda = vl2.nextToken();
				ANTIA[j]=guarda.split(",");
				
			}
			if(E-g(P.length,V.length)<0)System.out.println("No");
			else if(E-g(P.length,V.length)>=0)System.out.println("Yes");
			
			
			
		}

	}
	static int g(int n, int m){
		int M[][]= new int[n+1][m+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				if (j==0)M[i][j]=0;
				else if(i==0 && j>0)M[i][j]=Integer.MAX_VALUE;

				else if(!veri(PB[i-1],(String[])ANTIA[j-1]) || AT[i-1]<DEF[j-1]){
					M[i][j]=M[i-1][j];
					
				}
				else{
					if(M[i-1][j-1]==Integer.MAX_VALUE)M[i][j]=M[i-1][j];
					else{
						M[i][j]=Math.min(M[i-1][j],CALORIAS[i-1]+M[i-1][j-1]);
					}
					
				} 
				
				
			}
			
			
			
		}
		return M[n][m];
		
		
		
	}
	
	static boolean veri(String B,String[] M){
		for(int i=0;i<M.length;i++){
			if (M[i].equals(B)) return true;
			
			
		}
		return false;
		
		
		
	}
}
