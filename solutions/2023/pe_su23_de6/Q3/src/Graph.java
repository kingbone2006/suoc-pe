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
    RandomAccessFile f;int i,j,x;
        String s;StringTokenizer t;
        a = new int[20][20];
        try{
            f = new RandomAccessFile("data.txt","r");
            for(i = 0; i < k; i++)
                f.readLine();
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for(i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for(j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        }catch(Exception e) {}
    }
    void dispAdj() {
        int i,j;
        for(i = 0; i < n; i++) {
            System.out.println();
            for(j = 0; j < n; j++)
                System.out.printf("%4d",a[i][j]);
        }
    }
    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }
    void fdispAdj(RandomAccessFile f) throws Exception {
        int i,j;
        f.writeBytes("n = "+n+"\r\n");
        for(i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for(j = 0; j < n; j++)
                f.writeBytes("  " + a[i][j]);
        }
        f.writeBytes("\r\n");
    }
    void breadth(int k, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int i,h;
        boolean [] enqueued = new boolean[n];
        for(i = 0; i < n; i++)
            enqueued[i] = false;
        q.enqueue(k);
        enqueued[k] = true;
        while(!q.isEmpty()){
            h = q.dequeue();
            fvisit(h, f);
            for(i = 0; i < n; i++)
                if(!enqueued[i] && a[h][i] > 0) {
                    q.enqueue(i);
                    enqueued[i] = true;
                }
        }
        System.out.println();
    }
    void depth_rec(boolean [] visited,int k, RandomAccessFile f) throws Exception {
        fvisit(k,f);
        visited[k] = true;
        for(int i = 0; i < n; i++) {
            if(!visited[i] && a[k][i]>0)
                depth_rec(visited,i,f);
        }
    }
    void depth(int k, RandomAccessFile f) throws Exception {
        boolean [] visited = new boolean[20];
        int i;
        for(i = 0; i < n; i++)
            visited[i] = false;
        depth_rec(visited,k,f);
        for(i = 0; i < n; i++)
            if(!visited[i])
                depth_rec(visited,i,f);
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
        breadth(2,f);
        f.writeBytes("\r\n");
        f.writeBytes("\r\n");
        f.close();
    }
    void f2() throws Exception {
        loadData(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        f.writeBytes("\r\n");
        f.close();
    }
}