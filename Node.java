class Node
{
	Term key;
	Node link;
	public Node(Term key)
	{
		this.key = key;
		this.link = null;
	}
	public String toString()
	{
		return key + "";
	}
}
