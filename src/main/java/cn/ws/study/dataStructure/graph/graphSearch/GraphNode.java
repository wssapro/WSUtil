package cn.ws.study.dataStructure.graph.graphSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 图 结构体
 *
 * @author : Host-424
 * @date Date : 2022-02-24 17:33
 */
public class GraphNode<T> {

    private T data;

    private List<GraphNode<T>> neighborList;

    private boolean visited;

    public GraphNode(T data){
        this.data = data;
        neighborList = new ArrayList<>();
        visited = false;
    }


    /**
     * 还原图中所有节点为未访问
     */
    public void restoreVisited(){
        restoreVisited(this);
    }

    /**
     * 还原node的图所有节点为未访问
     * @param node
     */
    private void restoreVisited(GraphNode<T> node){
        if(node.visited){
            node.visited = false;
        }

        List<GraphNode<T>> neighbors = node.neighborList;
        for (GraphNode<T> neighbor : neighbors) {
            restoreVisited(neighbor);
        }

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GraphNode<T>> getNeighborList() {
        return neighborList;
    }

    public void setNeighborList(List<GraphNode<T>> neighborList) {
        this.neighborList = neighborList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
