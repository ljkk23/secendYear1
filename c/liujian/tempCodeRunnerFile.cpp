int jiao(Slist Le,Slist Ld,Slist &Lg)
{
	int g=0;
	
		for (int i = 0; i < Le.length; i++)
		{
			for (int j = 0; j < Ld.length; j++)
			{
				if (Le.elem[i]==Ld.elem[j])
				{
					Lg.length++;
				}
				
			}
			
		}
		Lg.elem=(int *)malloc((Lg.length)*sizeof(int));
		for (int i = 0; i < Le.length; i++)
		{
			for (int j = 0; j < Ld.length; j++)
			{
				if (Le.elem[i]==Ld.elem[j])
				{
					Lg.elem[g]=Le.elem[i];
					g++;
				}
				
			}
			
		}

}