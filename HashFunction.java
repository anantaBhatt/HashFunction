/**
 * 
 */

/**
 * @author Ananta Bhatt
 *
 */
public class HashFunction {

    public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' ,' '};
    public static char elements[]  = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
    public static char[][] matrix1 = new char[5][5];
    public static int[][] matrix2 = new int[5][5];
    static String input="abcdefghi jklmnopqrstuvwx";
    public static char[][] input_string_Matrix()
    {
    	for (int i = 0; i < 5; i++) {
    	    for (int j = 0; j < 5; j++) {
    	        matrix1[i][j] = input.charAt(5 * i + j);
    	    }
    	}
    	System.out.println("");
    	for (int i = 0; i < 5; i++) {
    	    for (int j = 0; j < 5; j++) {
    	      System.out.print(" " + matrix1[i][j]);
    	    }
    	    System.out.println("");
    	    }
		return matrix1;
    	
    }
    public static int[] map_numbers(String input)
    {
        int i=0;
        int[] a=new int[input.length()];
    	   //Mapping correspondence elements with the plaintext and alphabets
        for (i = 0; i < input.length(); i++)
        {
                for (int j = 0; j < 28; j++)
                {
                    if (p[j] == input.charAt(i))
                    {
                        a[i] = elements[j];
                        break;
                    }
                }
        }
        return a;
    }
    public static char[] map_elements(int[] e)
    {
        int i=0;
        char[] a=new char[e.length];
    	   //Mapping correspondence elements with the plaintext and alphabets
        for (i = 0; i < e.length; i++)
        {
                for (int j = 0; j < 28; j++)
                {
                    if (elements[j] == e[i])
                    {
                        a[i] = p[j];
                        break;
                    }
                }
        }
        return a;
    }

    public static int[][] map_Matrix()
    {
    	int[] a=new int[input.length()];
    	a=map_numbers(input);
        
    	//System.out.println(number);
    	for (int i = 0; i < 5; i++) {
    	    for (int j = 0; j < 5; j++) {
    	    	
    	        matrix2[i][j] =  a[5 * i + j];
    	    }
    	}
    	for (int i = 0; i < 5; i++) {
    	    for (int j = 0; j < 5; j++) {
    	      System.out.print(" " + matrix2[i][j]);
    	    }
    	    System.out.println();
    	    }
		return matrix2;
    	
    }
    public static int[] round1(int[][] matrix2)
    {
    	int[] out= {0,0,0,0,0};
    	for(int j=0;j<5;j++)
    	{
    	for (int i = 0; i < 5; i++) {
    	     
    	    	out[j]+=matrix2[i][j];
    	    }  
    	}
    	for (int i = 0; i < 5; i++) {
    	out[i]=out[i]%27;}
    
		return out;
    	
    }
    public static int[] sum_row_out(int[][] matrix2)
    {
    	int[] out= {0,0,0,0,0};
    	for(int j=0;j<5;j++)
    	{
    	for (int i = 0; i < 5; i++) {
    	     
    	    	out[j]+=matrix2[j][i];
    	    }  
    	}
    	for (int i = 0; i < 5; i++) {
    	out[i]=out[i]%27;}
    
		return out;
    	
    }
    public static int[][] round2(int[][] mtx1)
    {
    	int [][] myInt = new int[5][5];
        for(int i = 0; i< mtx1.length; i++){
            for (int j = 0; j < mtx1[i].length; j++){
                myInt[i][j] = mtx1[i][j];
            }
        }
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			if(i==0)
    			{
    				if(j==0)
                     mtx1[i][j+4]=myInt[i][j];
    				else
    			mtx1[i][j-1]=myInt[i][j];
    			}
    		
    		else if(i==1)
    		{
			 if(j==2||j==3||j==4)
                	 mtx1[i][j-2]=myInt[i][j]; 
			 else
			      mtx1[i][j+3]=myInt[i][j];
				}
    		else if(i==2)
    		{
    			if(j==3||j==4)
    				 mtx1[i][j-3]=myInt[i][j]; 
    			else
    			mtx1[i][j+2]=myInt[i][j];	
    		}
    		else if(i==3)
    		{
    			if(j==4)
    				 mtx1[i][j-4]=myInt[i][j]; 
    			else
    			mtx1[i][j+1]=myInt[i][j];	
    		}
    		else if(i==4)
    			mtx1[i][j]=myInt[i][j];
		}
    		}

    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			System.out.print(" "+mtx1[i][j]);
    		}System.out.println("");}
		return mtx1;
    
    }
    public static int[][] round3(int[][] mtx1,int[][] mtx2)
    {
		int n=5;
		int d=1;
		int[] [] block4= new int[5][5];
		//Matrix column shifting
		for(int i=0;i<5;i++)
		{
			int[] temp = new int[5];
			for(int j=0;j<5;j++)
			{
			  temp[(j-d+n)%n] =mtx1[j][i] ;
			}
			
			int t1=0;
			int swap=3;
			for(int j=0;j<2;j++)
			{
				
				t1=temp[j];
				temp[j]=temp[j+swap];
				temp[j+swap]=t1;
				swap= swap-2;
			}
			for(int j=0;j<5;j++)
			{
				block4[i][j]= temp[j];
			}
			d++;
		}
		int i=4;
		for(int j=0;j<5;j++)
		{
			block4[j][i]= mtx2[j][i];
		}
		for(int k=0;k<5;k++)
    	{
    		for(int l=0;l<5;l++)
    		{
    			System.out.print(" "+block4[k][l]);
    		}System.out.println("");}
    return block4;
    }
    public static void main(String arg[])
	{
    	 int[][] mtx1 = new int[5][5];
    	 int[][] mtx3 = new int[5][5];
    	 int[][] mtx4 = new int[5][5];
    	 char[][] mtx2 = new char[5][5];
    	
    	 mtx1= map_Matrix();
    	 int [][] myInt = new int[5][5];
         for(int i = 0; i< mtx1.length; i++){
             for (int j = 0; j < mtx1[i].length; j++){
                 myInt[i][j] = mtx1[i][j];
             }}
    	 mtx2=input_string_Matrix();
    	 int[] a;
    	 a=round1(mtx1);
    		for (int k = 0; k < 5; k++) {
            	System.out.println("The Out Array afrer round 1 is:"+a[k]);}
    	 mtx3=round2(mtx1);
    	 int[] b;
    	 b=round1(mtx3);
    	 int[] c= new int[5];
    	 for (int l = 0; l < 5; l++) {
    	    	c[l]=(a[l]+b[l])%27;}
    	 for (int m = 0; m < 5; m++) {
         	System.out.println("The Out Array after round 2 is:"+c[m]);}
    	 mtx4=round3(myInt,mtx3);
    	 int[] d;
    	 d=sum_row_out(mtx4);
    	 int[] e= new int[5];
    	 for (int l = 0; l < 5; l++) {
    	    	e[l]=(c[l]+d[l])%27;}
    	 for (int m = 0; m < 5; m++) {
          	System.out.println("The Out Array after round 3 is:"+e[m]);}
    	 char[] hashed_output;
    	 hashed_output=map_elements(e);
    	 System.out.print("The Hashed Output is:");
    	 for (int m = 0; m < hashed_output.length; m++) {
           	System.out.print(""
           			+ ""+hashed_output[m]);}
	}
}
