

public abstract class Subscriptie {
	

	protected String nume;
	protected int nrBasic,nrPremium;
	protected int timestamp=0;
	
	public void setTimestamp(int timestamp) {
		this.timestamp=timestamp;
	}
	
	public void incTimestamp(int timestamp) {
		timestamp++;
	}
	
	public int getTimestamp() {
		return timestamp;
	}
	public void setNume(String nume) {
		this.nume=nume;
	}
	
	public String getNume() {
		return nume;
	}
	
	public Subscriptie(String nume,int timestamp) {
		this.nume=nume;
		this.timestamp=timestamp;
	}
	public Subscriptie()
	{
	}
	public abstract void setNrBasic();
	public abstract int getNrBasic();
	public abstract int getNrPremium();
	public abstract void setNrPremium();
	public abstract String getClasa();
	
}

class Free extends Subscriptie{
	

	
	public Free(String nume,int timestamp) {
		super(nume, timestamp);
	}
	
	public Free()
	{
		super();
	}

	public void setNrBasic() {
	}
	public int getNrBasic() {
		return 0;
	}

	public int getNrPremium() {
		return 0;
	}

	public void setNrPremium() {
		
	}
	public String getClasa() {
		return "Free";
	}
	
}

class Basic extends Free{
	
	protected int nrBasic;
	
	public void setNrBasic(int nrBasic) {
		this.nrBasic = nrBasic;
	}
	
	public int getNrBasic() {
		return nrBasic;
	}
	
	public Basic(String nume,int nrBasic,int timestamp) {
		super(nume,timestamp);
		this.nrBasic=nrBasic;
	}
	
	public String getClasa() {
		if(nrBasic>0) {
			nrBasic--;
			return "Basic";
		}
		else 
			return "Free";
	}
	
}
class Premium extends Basic{
	
	protected int nrPremium;
	
	public void setNrPremium(int nrPremium) {
		this.nrPremium = nrPremium;
	}
	
	public int getNrPremium() {
		return nrPremium;
	}
	
	public Premium(String nume,int nrBasic,int nrPremium,int timestamp) {
		super(nume,nrBasic,timestamp);
		this.nrPremium=nrPremium;
	}
	
	public String getClasa() {
		if(nrPremium>0) {
			nrPremium--;
			return "Premium";
			}
		else
			if(nrBasic>0) {
				nrBasic--;
				return "Basic";
			}
			else
				return "Free";
	}
	
}
