
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {	
	public static void main(String[] args)throws Exception  {
		
		int i,j,t,k,verif=0,verif2;
		int numarPremium=0,numarBasic=0;
		String tipMemorie,Operatie="";
		String numeObiect;
		int ePremium,returnVal=1;
		int Min,indexMin;
		int aux = 0,aux2 = 0;

		ArrayList<Subscriptie> Memory = new ArrayList<Subscriptie>(1000);
		
		Free memFree;
		Basic memBasic;
		Premium memPremium;

		Cache cache=null;
		
		PrintWriter writer = new PrintWriter(args[1], "UTF-8");
		
		File f=new File(args[0]);
		Scanner scan = new Scanner(f);
		tipMemorie=scan.nextLine();
		
		
		if(tipMemorie.equals("FIFO")) {
			cache=new FIFOCache();
		}
		if(tipMemorie.equals("LRU")) {
			cache=new LRUCache();
		}
		if(tipMemorie.equals("LFU")) {
			cache=new LFUCache();
		}
		
		int nrObiecte,nrOperatii;
		
		nrObiecte=scan.nextInt();
		nrOperatii=scan.nextInt();
		
		for(i=0;i<nrOperatii;i++) {
			
			Operatie=scan.next();
			if(Operatie.equals("ADD")) 
			{
				
				numeObiect=scan.next();
				verif2=0;
				ePremium=0;
				if(scan.hasNextInt()) 
				{
					numarBasic=scan.nextInt();
				}
				if (scan.hasNextInt()) 
				{
					numarPremium=scan.nextInt();
					ePremium=1;	
				}
				for(j=0;j<Memory.size();j++)
				{
					if(numeObiect.equals(Memory.get(j).getNume())) 
					{
						if(ePremium==1) 
						{
							
							memPremium=new Premium(numeObiect,numarBasic,numarPremium,0);
							Memory.set(j,memPremium);

						}
						else {
							memBasic=new Basic(numeObiect,numarBasic,0);
							Memory.set(j, memBasic);

						}
						verif2=1;
							if(tipMemorie.equals("FIFO"))
								cache.suprascrie(numeObiect);
							
							
							else if(tipMemorie.equals("LFU")) 
								cache.suprascrie(numeObiect);

							
							else if(tipMemorie.equals("LRU")) 
								cache.suprascrie(numeObiect);

							
					}
				
				}
				if(verif2==0) {
					if(ePremium==1) 
					{
						memPremium=new Premium(numeObiect,numarBasic,numarPremium,0);
						Memory.add(memPremium);
					}
					else {
						memBasic=new Basic(numeObiect,numarBasic,0);
						Memory.add(memBasic);
					}
					
						
				}
			}
			else if(tipMemorie.equals("FIFO")) 
			{
				
				numeObiect=scan.next();
				returnVal=1;
				verif=0;
				returnVal=cache.verifica(numeObiect);
					if(returnVal==0)
						writer.println("0"+" "+cache.getClass(numeObiect));

				for(j=0;j<Memory.size();j++)
				{
					if(numeObiect.equals(Memory.get(j).getNume()) && returnVal!=0) 
					{	
						cache.add(Memory.get(j));
						verif=1;
						if(cache.returnSize()>nrObiecte)
							cache.remove();
						writer.println("1"+" "+Memory.get(j).getClasa());
					}
				}
				if(verif!=1 && returnVal!=0) 
				{
					writer.println("2");
				}

			}
			else if(tipMemorie.equals("LFU")) 
			{			
				numeObiect=scan.next();
				returnVal=1;
				verif=0;
				returnVal=cache.verifica(numeObiect);
				t=cache.index(numeObiect);

				if(returnVal==0)
					for(k=0;k<Memory.size();k++)
						if(numeObiect.equals(Memory.get(k).getNume())) 
						{
							writer.println("0"+" "+Memory.get(k).getClasa());
							cache.setTimestamp(t);
						}
				for(j=0;j<Memory.size();j++)
				{
					if(numeObiect.equals(Memory.get(j).getNume()) && returnVal!=0) 
					{
						
						if (cache.returnSize()==nrObiecte) {
							cache.remove();
						}
						cache.add(Memory.get(j));
						verif=1;
						writer.println("1"+" "+Memory.get(j).getClasa());
					

					}
				}
				if(verif!=1 && returnVal!=0) 
				{
					writer.println("2");
				}	
			}
			else if(tipMemorie.equals("LRU")) 
			{
				numeObiect=scan.next();
				returnVal=1;
				verif=0;
				returnVal=cache.verifica(numeObiect);
				aux=cache.index(numeObiect);
				if(returnVal==0)	
					for(k=0;k<Memory.size();k++)
						if(numeObiect.equals(Memory.get(k).getNume()))
						{
							writer.println("0"+" "+Memory.get(k).getClasa());
							aux2=k;
						}

				if(returnVal==0) 
				{
					cache.add(Memory.get(aux2));
					cache.removeObj(aux);
				}
				for(j=0;j<Memory.size();j++)
				{
					if(numeObiect.equals(Memory.get(j).getNume()) && returnVal!=0) 
					{		
						cache.add(Memory.get(j));
						verif=1;
						if (cache.returnSize()>nrObiecte) 
						{
							cache.remove();
						}	
							writer.println("1"+" "+Memory.get(j).getClasa());

					}
				}

				if(verif!=1 && returnVal!=0) 
				{
					writer.println("2");
				}

			}
		}
		writer.close();
	}
}	

