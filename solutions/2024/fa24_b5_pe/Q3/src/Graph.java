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
    RandomAccessFile f;
    int i,j,x;
    String s;
    StringTokenizer t;
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
  void fvisit(int i, RandomAccessFile f) throws Exception {
    f.writeBytes("  " + v[i]);
  }
  void depth2(boolean [] visited, int k, RandomAccessFile f, ArrayList<Integer> order) throws Exception {
    fvisit(k, f);
    visited[k] = true;
    order.add(k);
    for(int j=0; j<n; j++) {
      if(!visited[j] && a[k][j]>0) depth2(visited, j, f, order);
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
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    boolean [] visited = new boolean[20];
    for(int i=0; i<n; i++) visited[i] = false;
    ArrayList<Integer> order = new ArrayList<Integer>();
    depth2(visited, 2, f, order);
    f.writeBytes("\r\n");
    for(int i=2; i<6 && i<order.size(); i++) {
      f.writeBytes("  " + v[order.get(i)]);
    }
    f.writeBytes("\r\n");
    f.close();
  }
  class DijkstraResult {
    int[] d;
    int[] p;
    int[] s;
    int count;
    DijkstraResult(int n) {
      d = new int[n];
      p = new int[n];
      s = new int[n];
      count = 0;
    }
  }
  DijkstraResult dijkstra(int from) {
    DijkstraResult res = new DijkstraResult(n);
    boolean[] visited = new boolean[n];
    for(int i=0; i<n; i++) {
      res.d[i] = 99;
      res.p[i] = from;
      visited[i] = false;
    }
    res.d[from] = 0;
    for(int i=0; i<n; i++) {
      int u = -1, min = 99;
      for(int j=0; j<n; j++) {
        if(!visited[j] && res.d[j] < min) {
          min = res.d[j];
          u = j;
        }
      }
      if(u == -1) break;
      visited[u] = true;
      res.s[res.count++] = u;
      for(int vIdx=0; vIdx<n; vIdx++) {
        if(!visited[vIdx] && a[u][vIdx] > 0 && a[u][vIdx] < 99) {
          if(res.d[u] + a[u][vIdx] < res.d[vIdx]) {
            res.d[vIdx] = res.d[u] + a[u][vIdx];
            res.p[vIdx] = u;
          }
        }
      }
    }
    return res;
  }
  ArrayList<Integer> getPath(int[] p, int from, int to) {
    ArrayList<Integer> path = new ArrayList<Integer>();
    int curr = to;
    while(curr != from) {
      path.add(curr);
      curr = p[curr];
    }
    path.add(from);
    Collections.reverse(path);
    return path;
  }
  void f2() throws Exception {
    loadData(12);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    DijkstraResult r1 = dijkstra(2);
    DijkstraResult r2 = dijkstra(0);
    int startIdx = Math.max(0, r2.count - 4);
    for(int i=startIdx; i<r2.count; i++) {
      int u = r2.s[i];
      f.writeBytes(v[u] + ":" + r2.d[u] + " ");
    }
    f.writeBytes("\r\n");
    ArrayList<Integer> path2 = getPath(r2.p, 0, 6);
    for(int node : path2) {
      f.writeBytes(v[node] + " ");
    }
    f.writeBytes("\r\n");
    ArrayList<Integer> path1 = getPath(r1.p, 2, 5);
    for(int node : path1) {
      f.writeBytes(v[node] + " ");
    }
    f.writeBytes("\r\n");
    f.close();
  }
}