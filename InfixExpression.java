import java.util.*;

/**
 * A class for representing an infix expression.
 */
public class InfixExpression
{
    private BinaryTreeNode rootNode;

    public InfixExpression(String expression)
    {
        List<String> stubs = splitExpression(expression);
        rootNode = createBinaryTree(stubs);
    }

	/**
	 * Returns the value of the expression.
	 */
    public String solve()
    {
        return rootNode.getValue();
    }

	/**
	 * Returns the expression written in prefix notation.
	 */
    public String toPrefixNotation()
    {
        return printPrefixNode(rootNode);
    }

	/**
	 * Returns the expression written in postfix notation.
	 */
    public String toPostfixNotation()
    {
        return printPostfixNode(rootNode);
    }

	/**
	 * Returns the string form of the given node and all its children,
	 * traversing the tree for prefix notation.
	 */
    private String printPrefixNode(BinaryTreeNode node)
    {
        if(node == null)
            return "";
        String answer = node.toString() + " " + printPrefixNode(node.getLeftChild()).trim() + " " + printPrefixNode(node.getRightChild()).trim();
        return answer.trim();
    }

	/**
	 * Returns the string form of the given node and all its children,
	 * traversing the tree for postfix notation.
	 */
    private String printPostfixNode(BinaryTreeNode node)
    {
        if(node == null)
            return "";
        String answer = printPostfixNode(node.getLeftChild()).trim() + " " + printPostfixNode(node.getRightChild()).trim() + " " + node.toString();
        return answer.trim();
    }

	/**
	 * Given a list of operators and digits, returns the root node of the
	 * binary tree that represents the original expression.
	 */
    private BinaryTreeNode createBinaryTree(List<String> stubs)
    {
        if(stubs.size() == 1)
            return new BinaryTreeNode(stubs.get(0));

        int rootIndex = determineRootNodeIndex(stubs);
        List<String> leftStubs = stubs.subList(0, rootIndex);
        List<String> rightStubs = stubs.subList(rootIndex + 1, stubs.size());

        BinaryTreeNode rootNode = new OperatorNode(stubs.get(rootIndex));
        BinaryTreeNode leftChild = createBinaryTree(leftStubs);
        BinaryTreeNode rightChild = createBinaryTree(rightStubs);
        rootNode.setLeftChild(leftChild);
        rootNode.setRightChild(rightChild);

        return rootNode;
    }

	/**
	 * Returns the index of the list element that should be
	 * the root node of the binary tree.
	 */
    private int determineRootNodeIndex(List<String> stubs)
    {
        int indexOfPlus = stubs.lastIndexOf("+");
        int indexOfMinus = stubs.lastIndexOf("-");
        int indexOfTimes = stubs.lastIndexOf("*");
        int indexOfDivided = stubs.lastIndexOf("/");

        if(indexOfPlus == -1 && indexOfMinus == -1)
            return Math.max(indexOfTimes, indexOfDivided);
        else
            return Math.max(indexOfPlus, indexOfMinus);
    }

	/**
	 * Returns a list of operators and digits from the string form
	 * of the expression.
	 */
    private List<String> splitExpression(String expression)
    {
        List<String> stubs = new ArrayList<String>();

        for(String stub : expression.split("\\b"))
        {
            stub = stub.trim();
            if(!stub.equals("") && !stub.equals(" "))
                stubs.add(stub);
        }

        return stubs;
    }

}