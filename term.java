class Term
{
	int coeff;
	int expo;
	public Term(int coeff, int expo)
	{
		this.coeff = coeff;
		this.expo = expo;
	}
	public String toString()
	{
		String sign;
		if(coeff>0)
		{
			 sign = "+";
			return sign+ coeff + "x^" + expo+" " ;
		}
		else
		{	
			sign ="-";
			return " "+coeff+"x^"+expo+" ";
		}
	}
}
