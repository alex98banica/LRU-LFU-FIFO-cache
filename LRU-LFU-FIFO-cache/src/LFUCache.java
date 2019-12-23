

import java.util.LinkedList;

public class LFUCache implements Cache {

	private LinkedList<Subscriptie> LFU = new LinkedList<Subscriptie>();
	
	public void add(Subscriptie obj) {
		LFU.add(obj);
	}

	public void remove() {
		int Min,indexMin,t;
		Min=LFU.get(0).getTimestamp();
		indexMin=0;
		for(t=0;t<LFU.size();t++)
			if(LFU.get(t).getTimestamp()<Min) {
				Min=LFU.get(t).getTimestamp();
				indexMin=t;
			}
		LFU.get(indexMin).setTimestamp(0);
		LFU.remove(indexMin);
	}

	public void suprascrie(String numeObiect) {
		int t;
		for(t=0;t<LFU.size();t++) {
			if(numeObiect.equals(LFU.get(t).getNume())) {
				LFU.remove(t);
			}
		}
	}

	public int verifica(String numeObiect) {
		int t;
		for(t=0;t<LFU.size();t++) {
			if(numeObiect.equals(LFU.get(t).getNume())) {
				return 0;
			}
		}
		return 1;
	}

	public int returnSize() {
		 return LFU.size();
	}

	public String getClass(String numeObiect) {
		return null;
	}
	
	 public int index(String numeObiect) {
		int t;
		for(t=0;t<LFU.size();t++) {
			if(numeObiect.equals(LFU.get(t).getNume())) {
				return t;
			}
		}
		return 0;
	}

	public void addUltimul(Subscriptie obj) {	
	}

	public void removeObj(int aux) {
	}

	public void setTimestamp(int t) {
		int aux=LFU.get(t).getTimestamp()+1;
		LFU.get(t).setTimestamp(aux);
	}

}
