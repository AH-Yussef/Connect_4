package com.connect_4.connect4_UI.Controllers;

import com.connect_4.connect4_UI.Static.Settings;
import com.connect_4.connect4_UI.mutual.Node;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphController implements Initializable {
    private final AnchorPane graphContainer;
    private final int maxBranchingFactor = 7;
    private final int nodeWidth = 70;
    private final int nodeHeight = 40;
    private int currLvl = 0;
    private int nodesNum = 0;

    public GraphController(AnchorPane graphContainer) {
        this.graphContainer = graphContainer;
    }

    public void constructGraph(Node root) {
        nodesNum = -1;
        currLvl = 0;
        graphContainer.getChildren().clear();

        for (int i = 0; i <= Settings.maxSearchDepth; i++) {
            currLvl = i;
            nodesNum = -1;
            constructLevel(root, i);
        }
    }

    private void constructLevel(Node root, int level)
    {
        if (root == null) {
            nodesNum ++;
            return;
        }
        if (level == 0) {
            nodesNum ++;
            drawNode(root);
        }
        else if (level > 0) {
            for(Node node: root.children) constructLevel(node, level -1);
        }
    }

    private void drawNode(Node nodeToDraw) {
        StackPane nodeContainer = new StackPane();
        double space = Math.pow(maxBranchingFactor, (Settings.maxSearchDepth - currLvl)) * 50;
        double nodeIndex = nodesNum % Math.pow(maxBranchingFactor, currLvl);
        double layout_x = space + nodeIndex*2*space;
        double layout_y = (currLvl+1) * 300;
        nodeContainer.setLayoutX(layout_x);
        nodeContainer.setLayoutY(layout_y);

        Rectangle node = new Rectangle();
        node.setWidth(nodeWidth);
        node.setHeight(nodeHeight);
        node.getStyleClass().add("graph-node");
        if(isCompLvl()) node.getStyleClass().add("comp-graph-node");
        else node.getStyleClass().add("human-graph-node");

        Text valLabel = new Text(Integer.toString(nodeToDraw.utility));
        valLabel.getStyleClass().add("graph-node-label");

        int nextLvl = currLvl + 1;
        double firstChildIndex = nodeIndex * maxBranchingFactor;
        double nextLvlSpace = Math.pow(maxBranchingFactor, (Settings.maxSearchDepth - nextLvl)) * 50;
        for(int i = 0; i < nodeToDraw.children.length; i++) {
            Node child = nodeToDraw.children[i];
            double currChildIndex = firstChildIndex + i;
            if(child == null) break;
            Line connection = new Line();
            double start_x = layout_x + 0.5*nodeWidth;
            double start_y = layout_y + nodeHeight;
            double end_y = layout_y + 300;
            double childLayout_x = nextLvlSpace + currChildIndex*2*nextLvlSpace;
            double end_x = childLayout_x + 0.5*nodeWidth;

            connection.setStartX(start_x);
            connection.setStartY(start_y);
            connection.setEndX(end_x);
            connection.setEndY(end_y);
            connection.setStrokeWidth(2);

            graphContainer.getChildren().add(connection);
        }
        nodeContainer.getChildren().add(node);
        nodeContainer.getChildren().add(valLabel);
        graphContainer.getChildren().add(nodeContainer);
    }

    private boolean isCompLvl() {
        return currLvl %2 == 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double bottomLvlNodesNum = Math.pow(Settings.maxSearchDepth -1, maxBranchingFactor);
        double width = bottomLvlNodesNum * 100 + 100;
        double height = (Settings.maxSearchDepth - 1) * 300;
        graphContainer.setPrefHeight(width);
        graphContainer.setPrefWidth(height);
    }
}
