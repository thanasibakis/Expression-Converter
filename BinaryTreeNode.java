/**
 * A class for representing nodes of a binary tree.
 */
public class BinaryTreeNode
{
	private String value;
	private BinaryTreeNode[] children;
	
	public BinaryTreeNode(String value)
	{
		setValue(value);
		children = new BinaryTreeNode[2];
	}
	
	public String getValue()
	{
		return value;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
	
	public void setLeftChild(BinaryTreeNode child)
	{
		children[0] = child;
	}
	
	public void setRightChild(BinaryTreeNode child)
	{
		children[1] = child;
	}
	
	public BinaryTreeNode getLeftChild()
	{
		return children[0];
	}
	
	public BinaryTreeNode getRightChild()
	{
		return children[1];
	}
	
	public String toString()
	{
		return value;
	}
}