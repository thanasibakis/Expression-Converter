/**
 * A BinaryTreeNode that specifically holds a mathematical operator.
 */
public class OperatorNode extends BinaryTreeNode
{
	public OperatorNode(String operator)
	{
		super(operator);
	}
	
	/**
	 * Rather than returning the string form of the operator, like a normal Node,
	 * returns the value of the operation when applied to the Node's children.
	 */
	@Override
	public String getValue()
	{
		String operator = super.getValue();
		double leftChild = Double.parseDouble(getLeftChild().getValue());
		double rightChild = Double.parseDouble(getRightChild().getValue());
		
		switch(operator)
		{
			case "+": return "" + (leftChild + rightChild);
			case "-": return "" + (leftChild - rightChild);
			case "*": return "" + (leftChild * rightChild);
			case "/": return "" + (leftChild / rightChild);
			default: return "0";
		}
	}
}