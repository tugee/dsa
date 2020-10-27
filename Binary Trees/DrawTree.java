import java.awt.*;
import javax.swing.*;

public class DrawTree extends JFrame {
    int width = 800;
    int height = 500;

    public DrawTree() {
         setSize(width,height);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setResizable(false);
         setLocationRelativeTo(null);
         setVisible(true);
    }

    public static void main(String[] args) {
        new DrawTree();
    }

    int count(Node node) {
        if (node == null) return 0;
        return count(node.left)+count(node.right)+1;
    }

    void drawTree(Node node, int x, int y, Graphics g) {
        if (node == null) return;
        g.fillOval(x-5,y-5,10,10);
        int space, newX, newY;
        if (node.left != null) {
            space = count(node.left.right);
            newX = x-(space+1)*30; newY = y+40;
            g.drawLine(x,y,newX,newY);
            drawTree(node.left,newX,newY,g);
        }
        if (node.right != null) {
            space = count(node.right.left);
            newX = x+(space+1)*30; newY = y+40;
            g.drawLine(x,y,newX,newY);
            drawTree(node.right,newX,newY,g);
        }
    }

    public void paint(Graphics g) {
        // tässä on binääripuu, joka halutaan piirtää
        Node tree = new Node(
            new Node(new Node(null,null),new Node(null,null)),
            new Node(new Node(null,null),new Node(null,null))
        );
        Node kakka = new Node(new Node(null, null), new Node(new Node(new Node(null, new Node(null, new Node(null, null))), new Node(null, null)), new Node(null, null)));

        g.setColor(Color.BLACK);
        drawTree(kakka,width/2,50,g);
    }
}