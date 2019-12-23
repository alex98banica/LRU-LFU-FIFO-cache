

import java.util.LinkedList;


public class LRUCache implements Cache{
		
	private LinkedList<Subscriptie> LRU = new LinkedList<Subscriptie>();

	public LRUCache() {
	}

	public void remove(){
		LRU.removeFirst();
	}

	public void removeObj(int aux) {
		LRU.remove(aux);
	}

	public void suprascrie(String numeObiect) {
		int t;
		for(t=0;t<LRU.size();t++) {
			if(numeObiect.equals(LRU.get(t).getNume())) {
				LRU.remove(t);
			}
		}

	}

	public int verifica(String numeObiect) 
	{
		int t;
		for(t=0;t<LRU.size();t++) {
			if(numeObiect.equals(LRU.get(t).getNume())) {
				return 0;
			}
		}
		return 1;
	}

	public int index(String numeObiect) {
		int t;
		for(t=0;t<LRU.size();t++) {
			if(numeObiect.equals(LRU.get(t).getNume())) {
				return t;
			}
		}
		return 0;
	}

	public int returnSize() {
		 return LRU.size();
	}

	public void removePrimul() {}

	public void add(Subscriptie obj) {
		LRU.addLast(obj);
	}

	public String getClass(String numeObiect) {
		return null;
	}

	public void addUltimul(Subscriptie obj) {	
	}

	public void setTimestamp(int t) {	
	}
}

