public class Poly1
{
	Node head;
	Node tail;
	public Poly1()
	{
		head = null;
		tail = null;
	}

	public String toString()
	{
		Node temp = head;
		String res = "";
		while(temp != null)
		{
			res = res + temp + " ";
			temp = temp.link;
		}
		return res;
	}
	public void make(int[] coeff, int[] expo)
	{
		int n = coeff.length;
		Node temp;
		Term term;
		for(int i = 0; i < n; ++i)
		{
			term = new Term(coeff[i], expo[i]);
			temp = new Node(term);
			append(temp);
		}
	}
	void insert(Node temp)
	{
		if(head == null)
		{
			temp.link = null;
			head = temp;
			tail = head;
		}
		else
		{
			Node prev = null; Node pres = head;
			while(pres != null && pres.key.expo > temp.key.expo)
			{
				prev = pres;
				pres = pres.link;
			}
			if(pres != null && pres.key.expo == temp.key.expo)
			{
				pres.key.coeff += temp.key.coeff;
			
				
			}
			else if(prev == null)
			{
				temp.link = head;
				head = temp;
			}
			else
			{
				prev.link = temp;
				temp.link = pres;
				if(pres == null)
				tail = temp;
			}
		}
	}

	void append(Node temp)
	{
		if(tail == null)
		{
			head = tail = temp;
		}
		else
		{
			tail = tail.link = temp;
		}
		temp.link = null;
	}

	Poly1 add(Poly1 that)
	{
		Poly1 res = new Poly1();
		Node pres1 = this.head;
		Node pres2 = that.head;
		Term term; Node temp;
		while(pres1 != null && pres2 != null)
		{
			if(pres1.key.expo > pres2.key.expo)
			{
				term = new Term(pres1.key.coeff, pres1.key.expo);
				pres1 = pres1.link;
			}
			else if(pres1.key.expo == pres2.key.expo)
			{
				term = new Term(pres1.key.coeff + pres2.key.coeff, 
						pres1.key.expo);
				pres1 = pres1.link;
				pres2 = pres2.link;
			}
			else
			{
				term = new Term(pres2.key.coeff, pres2.key.expo);
				pres2 = pres2.link;
			}
			temp = new Node(term);
			res.insert(temp);
		}

		while(pres1 != null)
		{
			term = new Term(pres1.key.coeff, pres1.key.expo);
			temp = new Node(term);
			res.insert(temp);
			pres1 = pres1.link;
		}

		while(pres2 != null)
		{
			term = new Term(pres2.key.coeff, pres2.key.expo);
			temp = new Node(term);
			res.insert(temp);
			pres2 = pres2.link;
		}
		return res;
	}

	Poly1 sub(Poly1 that)
	{
		Poly1 res = new Poly1();
		Node pres1 = this.head;
		Node pres2 = that.head;
		Term term; Node temp;
		while(pres1 != null && pres2 != null)
		{
			if(pres1.key.expo > pres2.key.expo)
			{
				term = new Term(pres1.key.coeff, pres1.key.expo);
				pres1 = pres1.link;
			}
			else if(pres1.key.expo == pres2.key.expo)
			{
				term = new Term(pres1.key.coeff - pres2.key.coeff, 
						pres1.key.expo);
				pres1 = pres1.link;
				pres2 = pres2.link;
			}
			else
			{
				term = new Term(-(pres2.key.coeff), pres2.key.expo);
				pres2 = pres2.link;
			}
			temp = new Node(term);
			res.insert(temp);
		}

		while(pres1 != null)
		{
			term = new Term(pres1.key.coeff, pres1.key.expo);
			temp = new Node(term);
			res.insert(temp);
			pres1 = pres1.link;
		}
		
		while(pres2 != null)
		{
			term = new Term(-(pres2.key.coeff), pres2.key.expo);
			temp = new Node(term);
			res.insert(temp);
			pres2 = pres2.link;
		}
		return res;
	}

	Poly1 mul(Poly1 that)
	{
		Poly1 res[] = new Poly1[10];
		Node pres1 = this.head;
		Node pres2 = that.head;
		Term term; Node temp;
		int coeff,expo,i=0;
		while(pres2 != null)
		{
			res[i] = new Poly1();
			while(pres1 != null&& pres2 !=null)
			{
				expo =0 ;
				coeff = 0;
				expo = pres1.key.expo + pres2.key.expo;
				coeff = pres1.key.coeff * pres2.key.coeff;
				term = new Term(coeff, expo);
				temp = new Node(term);
				res[i].insert(temp);
				pres1 = pres1.link;
			}
			i++;
			pres2 = pres2.link;
			pres1 = this.head;
		}
		return res[0].add(res[1].add(res[2].add(res[3])));
	}

	Poly1 diff(Poly1 that)
	{
		Poly1 res = new Poly1();
		Node pres = that.head;
		Term term; Node temp;
		int coeff,expo;
		while(pres != null)
		{
			expo =0 ;
			coeff = 0;
			coeff = pres.key.expo * pres.key.coeff;
			expo = pres.key.expo -1;
			term = new Term(coeff, expo);
			temp = new Node(term);
			res.insert(temp);
			pres = pres.link;
		}
		return res;
	}
}
