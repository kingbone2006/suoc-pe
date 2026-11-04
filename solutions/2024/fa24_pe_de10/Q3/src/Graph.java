/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------
public class Graph {
  int [][] a; int n;
  char v[];
  int deg[];
  Graph() {
    v = "ABCDEFGHIJKLMNOP".toCharArray();
    deg = new int[20];
    a = new int[20][20];
    n = 0;
   }

  void loadData(int k) {  //do not edit this function
    RandomAccessFile f;int i,j,x;
    String s;StringTokenizer t;
    a = new int[20][20];
    try {
     f = new RandomAccessFile("data.txt","r");
     for(i=0;i<k;i++) f.readLine();
     s = f.readLine();s = s.trim();
     n = Integer.parseInt(s);
     for(i=0;i<n;i++) {
       s = f.readLine();s = s.trim();
       t = new StringTokenizer(s);
       for(j=0;j<n;j++) { 
         x = Integer.parseInt(t.nextToken().trim());
         a[i][j] = x;
        }
       }
     f.close();
     }
    catch(Exception e) {}

   }

  void dispAdj() {
    int i,j;
    for(i=0;i<n;i++) {
      System.out.println();
      for(j=0;j<n;j++)
        System.out.printf("%4d",a[i][j]);
     }
   }

  void fvisit(int i, RandomAccessFile f) throws Exception {
    f.writeBytes("  "+v[i]);
   }
  
  /* There is an array int deg[] already declared in the class Graph 
     You should write a funcion to calculate d[i] = degree of the vertex i
  */
  void fvisitDeg(int i, RandomAccessFile f) throws Exception {
    f.writeBytes("  "+v[i]+"("+deg[i]+")"); // d[i] = degree of the vertex i
   }
  
 void fdispAdj(RandomAccessFile f) throws Exception { 
    int i,j;
    f.writeBytes("n = "+n+"\r\n");
    for(i=0;i<n;i++) {
      f.writeBytes("\r\n");
      for(j=0;j<n;j++)  f.writeBytes("  " + a[i][j]);
     }
    f.writeBytes("\r\n");
   }

  void breadth(boolean [] en, int i, RandomAccessFile f) throws Exception {
    Queue q = new Queue();
    int r,j;
    q.enqueue(i); en[i]=true;
    while(!q.isEmpty()) {
      r = q.dequeue();
      fvisit(r,f);
      for(j=0;j<n;j++) {
        if(!en[j] && a[r][j]>0) {
         q.enqueue(j);en[j]=true;
        }
       }
     }
   }

  void breadth(int  k, RandomAccessFile f) throws Exception {
    boolean [] en = new boolean[20];
    int i;
    for(i=0;i<n;i++) en[i]=false;
    breadth(en,k,f);
    for(i=0;i<n;i++) 
      if(!en[i]) breadth(en,i,f);
   }

 void depth(boolean [] visited,int k, RandomAccessFile f) throws Exception {
    fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++) {
      if(!visited[i] && a[k][i]>0) depth(visited,i,f);
     }
   }
  void depth(int k, RandomAccessFile f) throws Exception {
    boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth(visited,i,f);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void f1() throws Exception {
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
    
    for(int i = 0; i < n; i++) {
        deg[i] = 0;
        for(int j = 0; j < n; j++)
            if(a[i][j] > 0) deg[i]++;
    }
    
    depth(4,f);
    f.writeBytes("\r\n");
    
    boolean [] visited = new boolean[20];
    for(int i = 0; i < n; i++) visited[i] = false;
    depth2(visited, 4, f);
    
    f.writeBytes("\r\n");
    f.close();
  }

  void depth2(boolean [] visited, int k, RandomAccessFile f) throws Exception {
    int count = 0;
    int[] path = new int[20];
    int psize = 0;
    Stack s = new Stack();
    s.push(k);
    
    while(!s.isEmpty()) {
        k = s.pop();
        if(!visited[k]) {
            path[psize++] = k;
            visited[k] = true;
        }
        for(int i = n-1; i >= 0; i--) {
            if(!visited[i] && a[k][i] > 0) {
                s.push(i);
            }
        }
    }
    
    for(int i = 1; i < 7 && i < psize; i++) {
        fvisitDeg(path[i], f);
    }
  }

//=================================================================================================
  void f2() throws Exception {
    loadData(12);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
    
    int[] dist = new int[n];
    int[] path = new int[n];
    boolean[] visited = new boolean[n];
    int[] selected = new int[n];
    int sel = 0;
    
    for(int i = 0; i < n; i++) {
        dist[i] = 99999;
        path[i] = -1;
        visited[i] = false;
    }
    dist[0] = 0;
    
    for(int i = 0; i < n; i++) {
        int u = -1;
        int min = 99999;
        for(int j = 0; j < n; j++) {
            if(!visited[j] && dist[j] < min) {
                min = dist[j];
                u = j;
            }
        }
        if(u == -1) break;
        visited[u] = true;
        selected[sel++] = u;
        
        for(int v = 0; v < n; v++) {
            if(!visited[v] && a[u][v] != 99 && dist[u] + a[u][v] < dist[v]) {
                dist[v] = dist[u] + a[u][v];
                path[v] = u;
            }
        }
    }
    
    for(int i = sel-4; i < sel; i++) {
        f.writeBytes(v[selected[i]] + " ");
    }
    f.writeBytes("\r\n");
    
    for(int i = sel-4; i < sel; i++) {
        f.writeBytes(dist[selected[i]] + " ");
    }
    f.writeBytes("\r\n");
    
    f.writeBytes(dist[6] + " " + v[0] + " " + v[4] + " " + v[6]);
    
    f.writeBytes("\r\n");
    f.close();
  }

}