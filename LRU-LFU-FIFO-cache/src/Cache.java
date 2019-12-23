

public interface Cache {

	public abstract void add(Subscriptie obj);
	public abstract void remove();
	public abstract void suprascrie(String nume);
	public abstract int verifica(String nume2);
	public abstract int returnSize();
	public abstract String getClass(String numeObiect);
	public abstract int index(String nume);
	public abstract void addUltimul(Subscriptie obj);
	public abstract void removeObj(int aux);
	public abstract void setTimestamp(int t);
}


