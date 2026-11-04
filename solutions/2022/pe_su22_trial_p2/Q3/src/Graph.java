/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
public class Graph {
  int [][] a;
  int n;
  char v[];
  int deg[];
  Graph() {
    v = "ABCDEFGHIJKLMNOP".toCharArray();
    deg = new int[20];
    a = new int[20][20];
    n = 0;
  }
  void loadData(int k) {
    RandomAccessFile f; int i,j,x; String s; StringTokenizer t;
    a = new int[20][20];
    try {
      f = new RandomAccessFile("data.txt","r");
      for(i=0;i<k;i++) f.readLine();
      s = f.readLine();s = s.trim(); n = Integer.parseInt(s);
      for(i=0;i<n;i++) {
        s = f.readLine();s = s.trim(); t = new StringTokenizer(s);
        for(j=0;j<n;j++) { x = Integer.parseInt(t.nextToken().trim()); a[i][j] = x; }
      }
      f.close();
    } catch(Exception e) {}
  }
  void fvisit(int i, RandomAccessFile f) throws Exception { f.writeBytes("  " + v[i]); }
  void breadth(boolean [] enqueued, int k, RandomAccessFile f) throws Exception {
    Queue q = new Queue(); int r,i;
    q.enqueue(k); enqueued[k]=true;
    while(!q.isEmpty()) {
      r = q.dequeue(); fvisit(r,f);
      for(i=0;i<n;i++) {
        if(!enqueued[i] && a[r][i]>0) { q.enqueue(i); enqueued[i]=true; }
      }
    }
  }
//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void f1() throws Exception {
    loadData(1);
    String fname = "f1.txt"; File g123 = new File(fname); if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    boolean [] enqueued = new boolean[20];
    for(int i=0;i<n;i++) enqueued[i] = false;
    breadth(enqueued, 1, f); f.writeBytes("\r\n"); f.close();
  }
  void f2() throws Exception {
    loadData(10);
    String fname = "f2.txt"; File g123 = new File(fname); if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    int[] d = new int[n]; int[] p = new int[n]; boolean[] visited = new boolean[n];
    for(int i=0; i<n; i++) { d[i] = 99; p[i] = 0; visited[i] = false; }
    d[0] = 0;
    for(int i=0; i<n; i++) {
      int u = -1, min = 99;
      for(int j=0; j<n; j++) { if(!visited[j] && d[j] < min) { min = d[j]; u = j; } }
      if(u == -1) break;
      visited[u] = true;
      for(int k=0; k<n; k++) {
        if(!visited[k] && a[u][k] > 0 && a[u][k] < 99) {
          if(d[u] + a[u][k] < d[k]) { d[k] = d[u] + a[u][k]; p[k] = u; }
        }
      }
    }
    ArrayList<Integer> path = new ArrayList<Integer>(); int curr = 4;
    while(curr != 0) { path.add(curr); curr = p[curr]; }
    path.add(0); Collections.reverse(path);
    for(int node : path) f.writeBytes(v[node] + " ");
    f.writeBytes("\r\n"); f.writeBytes("" + d[4]); f.writeBytes("\r\n"); f.close();
  }
}