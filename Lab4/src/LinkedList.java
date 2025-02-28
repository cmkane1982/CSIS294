public class LinkedList
{
    private Node headNode;

    public void addNode(int x, int y)
    {
        Node oNode = new Node();
        oNode.xPosition = x;
        oNode.yPosition = y;

        oNode.nextNode = headNode;

        headNode = oNode;
    }

    public Node removeNode()
    {
        Node oNode = headNode;

        headNode = headNode.nextNode;

        return oNode;
    }

    public Node getHeadNode()
    {
        return this.headNode;
    }
}
