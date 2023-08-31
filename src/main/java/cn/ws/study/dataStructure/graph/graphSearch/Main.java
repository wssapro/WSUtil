package cn.ws.study.dataStructure.graph.graphSearch;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-02-25 10:15
 */
public class Main {
    public static void main(String[] args) {

        GraphNode<String> root = greate();


        // new DepthFirstSearch<String>().DepthFirstSearch(root);
        // root.restoreVisited();
        new BreadthFirstSearch<String>().BreadthFirstSearch(root);

    }

    public static GraphNode<String> greate(){
        GraphNode<String> root = new GraphNode<>("root");
        GraphNode<String> q = new GraphNode<>("q");
        GraphNode<String> w = new GraphNode<>("w");
        GraphNode<String> e = new GraphNode<>("e");
        GraphNode<String> r = new GraphNode<>("r");
        GraphNode<String> t = new GraphNode<>("t");
        GraphNode<String> y = new GraphNode<>("y");
        GraphNode<String> u = new GraphNode<>("u");
        GraphNode<String> i = new GraphNode<>("i");
        GraphNode<String> o = new GraphNode<>("o");
        GraphNode<String> p = new GraphNode<>("p");


        root.getNeighborList().add(q);
        root.getNeighborList().add(w);

        q.getNeighborList().add(root);
        q.getNeighborList().add(e);
        q.getNeighborList().add(r);

        w.getNeighborList().add(root);
        w.getNeighborList().add(i);
        w.getNeighborList().add(r);

        e.getNeighborList().add(q);
        e.getNeighborList().add(p);

        r.getNeighborList().add(y);
        r.getNeighborList().add(t);
        r.getNeighborList().add(w);
        r.getNeighborList().add(q);

        t.getNeighborList().add(u);
        t.getNeighborList().add(i);
        t.getNeighborList().add(r);

        y.getNeighborList().add(o);
        y.getNeighborList().add(u);
        y.getNeighborList().add(r);

        u.getNeighborList().add(t);
        u.getNeighborList().add(y);

        i.getNeighborList().add(t);
        i.getNeighborList().add(w);

        o.getNeighborList().add(p);
        o.getNeighborList().add(y);

        p.getNeighborList().add(e);
        p.getNeighborList().add(o);

        return root;
    }
}
