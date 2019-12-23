

import java.util.LinkedList;

public class FIFOCache implements Cache{

	 private LinkedList<Subscriptie> FIFO ;
	 
	 public FIFOCache() {
		 FIFO=new LinkedList<Subscriptie>();
	 }

	 public void suprascrie(String numeObiect) {
		 int t;
	 
		 for(t=0;t<FIFO.size();t++) {
				if(numeObiect.equals(FIFO.get(t).getNume())) 
					FIFO.remove(t);
		 }
	 }
	 public int verifica(String numeObiect) {
		 int t;
	 	 for(t=0;t<FIFO.size();t++) {
			if(numeObiect.equals(FIFO.get(t).getNume())) {
				return 0;
			}
		 }
		 return 1;
	 }

	 public void getClasa() { 
	 }

	 public void add(Subscriptie obj) {
		 FIFO.add(obj);
	 }

	 public int returnSize() {
		 return FIFO.size();
	 }

	 public void remove() {
		 FIFO.removeFirst();
		 
	 }

	 public String getClass(String numeObiect) {
		 int t;
		 for(t=0;t<FIFO.size();t++) {
				if(numeObiect.equals(FIFO.get(t).getNume())) {
					return FIFO.get(t).getClasa();
				}
		 }
		 return null;
	}

	public int index(String numeObiect) {
		 return 0;
	}

	public void addUltimul(Subscriptie obj) {	
	}

	public void removeObj(int aux) {	
	}

	public void setTimestamp(int t) {	
	}
		 
}
