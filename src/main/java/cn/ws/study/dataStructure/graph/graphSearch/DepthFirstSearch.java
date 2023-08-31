package cn.ws.study.dataStructure.graph.graphSearch;

/**
 * 深度优先遍历
 *
 * @author : Host-424
 * @date Date : 2022-02-25 10:04
 */
public class DepthFirstSearch<T> {


    public void DepthFirstSearch(GraphNode<T> root){
        if(root == null){
            return;
        }

        if(root.isVisited()){
            return;
        }
        System.out.println(root.getData());
        root.setVisited(true);


        for (GraphNode<T> graphNode : root.getNeighborList()) {
            DepthFirstSearch(graphNode);
        }
    }
}
