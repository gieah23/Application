package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs extends AppCompatActivity {

    TextView keluaran;

    String cok ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bfs);
        keluaran = (TextView)findViewById(R.id.keluaran);
        cok = "";
        this.run();

    }
    protected void run()
    {
        Node G[] = new Node[25];
        G[0].gejala="TERDAPAT BERCAK PADA BAGIAN TANAMAN";
        G[0].nilaiGj= (float) 0.2;
        G[1].gejala="BUAH BUSUK";
        G[1].nilaiGj= (float) 0.2;
        G[2].gejala="BIJI BUAH SALING MELEKAT";
        G[2].nilaiGj= (float) 0.5;
        G[3].gejala="TERDAPAT LUBANG – LUBANG KECIL PADA BUAH";
        G[3].nilaiGj= (float) 0.8;
        G[4].gejala="KONDISI BATANG BASAH ATAU TERDAPAT BUIH";
        G[4].nilaiGj= (float) 0.2;
        G[5].gejala="TERDAPAT LUBANG BEKAS GEREKAN";
        G[5].nilaiGj= (float) 0.8;
        G[6].gejala="TERDAPAT BERCAK BERWANA COKLAT DAN CEKUNG";
        G[6].nilaiGj= (float) 0.2;
        G[7].gejala="TERDAPAT BERCAK/TITIK KEHITAMAN PADA BUAH TUA";
        G[7].nilaiGj= (float) 0.8;
        G[8].gejala="TIMBUL LAPISAN PUTIH SEPERTI TEPUNG";
        G[8].nilaiGj= (float) 0.8;
        G[9].gejala="TERDAPAT CAIRAN KEMERAHAN SEPERTI KARAT";
        G[9].nilaiGj= (float) 0.8;
        G[10].gejala="DAUN MENGUNING";
        G[10].nilaiGj= (float) 0.2;
        G[11].gejala="RANTING TANPA DAUN (OMPONG)";
        G[11].nilaiGj= (float) 0.8;
        G[12].gejala="DAUN MOZAIK (BERCORAK BANYAK)";
        G[12].nilaiGj= (float) 0.8;
        G[13].gejala="BERCAK COKLAT DILIPUTI JAMUR BERWARNAH PUTIH KOTOR PADA BUAH";
        G[13].nilaiGj= (float) 0.8;
        G[14].gejala="BUAH MUDA BERBINTIK COKLAT BERLEKUK";
        G[14].nilaiGj= (float) 0.8;
        G[15].gejala="PADA RANTING/CABANG TERDAPAT BENANG – BENANG TIPIS SEPERTI SARANG LABA – LABA";
        G[15].nilaiGj= (float) 0.8;
        G[16].gejala="TERDAPAT KERAK BERWARNA SALMON";
        G[16].nilaiGj= (float) 1.0;
        G[17].gejala="DAUN RONTOK";
        G[17].nilaiGj= (float) 1.0;
        G[18].gejala="BIJI BUSUK DAN HANCUR BIJI MENJADI MASSA DAN BERLENDIR";
        G[18].nilaiGj= (float) 1.0;
        G[19].gejala="PERMUKAAN KULIT KASAR DAN BELANG";
        G[19].nilaiGj= (float) 1.0;
        G[20].gejala="BATANG BERWARNA GELAP KEHITAMAN";
        G[20].nilaiGj= (float) 1.0;
        G[21].gejala="BUAH BERWARNA KEHITAMAN";
        G[21].nilaiGj= (float) 1.0;
        G[22].gejala="PERMUKAAN KULIT BUAH MUDA RETAK";
        G[22].nilaiGj= (float) 1.0;
        G[23].gejala="TERDAPAT LUBANG DAN BEKAS KOTORAN DENGAN SERPIHAN";
        G[23].nilaiGj= (float) 1.0;
        G[24].gejala="BUAH TUA TIDAK BERBUNYI JIKA DI GOYANGKAN";
        G[24].nilaiGj= (float) 1.0;


        Graph graph = new Graph(26);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 11);
        graph.addEdge(1, 5);
        graph.addEdge(1, 7);
        graph.addEdge(2, 3);
        graph.addEdge(2, 9);
        graph.addEdge(11, 12);
        graph.addEdge(11, 13);
        graph.addEdge(11, 16);
        graph.addEdge(5, 6);
        graph.addEdge(5, 10);
        graph.addEdge(7, 8);
        graph.addEdge(7, 15);
        graph.addEdge(3, 4);
        graph.addEdge(3, 14);
        graph.addEdge(9, 22);
        graph.addEdge(12, 20);
        graph.addEdge(16, 17);
        graph.addEdge(6, 24);
        graph.addEdge(10, 21);
        graph.addEdge(8, 23);
        graph.addEdge(15, 18);
        graph.addEdge(4, 25);
        graph.addEdge(14, 19);

        System.out.println("The Breadth First Traversal of the graph is as follows :");
        keluaran.setText(graph.BFS(0));
//        graph.BFS(0);
    }

    static class Graph
    {

        private int V;                              //number of nodes in the graph
        private LinkedList<Integer> adj[];              //adjacency list
        private Queue<Integer> queue;                   //maintaining a queue
        String anjing;

        Graph(int v)
        {

            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; i++)
            {
                adj[i] = new LinkedList<>();
            }
            queue = new LinkedList<Integer>();
        }


        void addEdge(int v,int w)
        {
            adj[v].add(w);                          //adding an edge to the adjacency list (edges are bidirectional in this example)
        }

        String BFS(int n)
        {
            anjing = "";

            boolean nodes[] = new boolean[V];       //initialize boolean array for holding the data
            int a = 0;

            nodes[n]=true;
            queue.add(n);                   //root node is added to the top of the queue

            while (queue.size() != 0)
            {
                n = queue.poll();             //remove the top element of the queue
                System.out.print(n+" ");           //print the top element of the queue
                anjing += (n+" ");

                for (int i = 0; i < adj[n].size(); i++)  //iterate through the linked list and push all neighbors into queue
                {
                    a = adj[n].get(i);
                    if (!nodes[a])                    //only insert nodes into queue if they have not been explored already
                    {
                        nodes[a] = true;
                        queue.add(a);
                    }
                }
            }
            return anjing;
        }

    }

    class Node {
        String gejala;
        float nilaiGj;
    }
}