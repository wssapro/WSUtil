package cn.ws.study.dataStructure.graph.graphSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历
 *
 * @author : Host-424
 * @date Date : 2022-02-25 10:05
 */
public class BreadthFirstSearch<T> {

    Queue<GraphNode<T>> queue = new LinkedList<>();

    public void BreadthFirstSearch(GraphNode<T> root){
        if(root == null){
            return;
        }
        queue.add(root);

        while (!queue.isEmpty()){

            GraphNode<T> poll = queue.poll();
            if(!poll.isVisited()){

                System.out.println(poll.getData());
                poll.setVisited(true);
            }
            for (GraphNode<T> graphNode : poll.getNeighborList()) {
                if(!graphNode.isVisited()){
                    queue.add(graphNode);
                }
            }
        }
    }
}
