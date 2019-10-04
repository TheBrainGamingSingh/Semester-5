import java.util.*;

public class q3{
  public static int MAX_VALUE=999;
	public static void printPath(int parent[], int v)
	{
		if (v < 1)
			return;

		printPath(parent, parent[v]);
		System.out.print(v + " ");
	}

    public static void Path(int source, int matrix[][],int v){
		int parent[]=new int[v+1];
		int dist[]=new int[v+1];
        for (int k=1; k<= v; k++)
            dist[k] = MAX_VALUE;

        dist[source] = 0;
        for (int k=1; k<=v-1; k++){
            for (int i=1; i<=v; i++){
                for (int j=1; j<=v; j++){
                    if (matrix[i][j]!=MAX_VALUE){
                        if (dist[j]>dist[i]+matrix[i][j]){
                            dist[j]=dist[i]+matrix[i][j];
							parent[j]=i;
						}
                    }
                }
            }
        }

        for (int i=1; i<=v; i++){
            for (int j=1; j<=v; j++){
                if (matrix[i][j]!=MAX_VALUE){
                    if (dist[j]>dist[i]+matrix[i][j])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }

        for (int i=1; i<=v; i++){
			System.out.print("Distance of vertex " + i + " from the source is " + dist[i] + ".\nPath of vertex " + i + "from source vertex is [ ");
			printPath(parent, i);
			System.out.println("]");
		}
    }

    public static void main(String[] args){
        int v = 0;
        int source;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        v = scanner.nextInt();

        int matrix[][] = new int[v + 1][v + 1];
        System.out.println("Enter the adjacency matrix");
        for (int i=1; i<=v; i++){
            for (int j=1; j<=v; j++){
                matrix[i][j]=scanner.nextInt();
				if (i==j){
                    matrix[i][j]=0;
                    continue;
                }
                if (matrix[i][j]==0){
                    matrix[i][j]=MAX_VALUE;
                }
            }
        }

        System.out.println("Enter the source vertex(indexing starts from 1)");
        source = scanner.nextInt();

		Path(source,matrix,v);
        return;
    }
}
