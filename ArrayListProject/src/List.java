import java.util.Arrays;

public class List<T>{
	
	//Liste elemanlarının tutulduğu dize
	private T[] arrayList;
	//Liste oluşturulduğunda dizenin varsayılan olarak büyüklüğü.
	private static int defaultSizeOfArray = 10;
	//Listeye eleman eklendiğinde artan değer 
	//Gerçekte olan liste büyüklüğünü tutar
	private int size = 0;
	
	public List() {
		//Varsayılan değer ile dize oluşturulur.
        arrayList = (T[]) new Object[defaultSizeOfArray];
	}
	//Listenin gerçek büyüklüğü döner.
	public int count() {
		return size;
	}
	//Liste boş ise true döndürür.
	public boolean isEmpty() {
		return size == 0;
	}
	//Listeye ekleme yapmayı sağlar, eğer kapasite aşıldıysa 10 birim daha arttırılır.
	//!10 değeri spesifik bir değer olup keyfidir.
	public void add(T value) {
		if (size == arrayList.length) {
			int newSize = defaultSizeOfArray + 10;
			arrayList = Arrays.copyOf(arrayList,newSize);
		}
		arrayList[size] = value;
		size++;
	}
	//Listenin en üstündeki değeri çıkartır ve döndürür.
	public T pop() {
		if (size > 0) {
            T value = arrayList[size - 1];
            arrayList[size - 1] = null;
            size--;
            return value;
        } else {
            throw new IllegalStateException("Liste boş.");
        }
	}
	//Spesifik bir index değeri için liste elemanını döner.
	public T find(int index) {
		indexChecking(index);
		return arrayList[index];
	}
	//Spesifik bir liste elemanını index değeri ile değiştirir.
	public void set(int index,T value) {
		indexChecking(index);
		arrayList[index] = value;
	}
	//Liste elemanlarını yazdırır.
	public String printedArray() {
		String printedValue = "";
		for (int i = 0;i < size;i++) {
			if (i == size - 1) {
				printedValue += arrayList[i].toString();
			}
			else {
				printedValue += arrayList[i].toString() + ", ";
			}
		}
		return printedValue;
	}
	//Listeyi dizeye dönüştürüp döner.
	public T[] toArray() {
		T[] newArray = Arrays.copyOf(arrayList, size);
		return newArray;
	}
	//Liste içerisindeki nesnelerden verilen tiptekileri dize halinde döndürür.
	public <X> X[] findObjectsWithTypeReturnArray(X type){
		List<X> objects = new List<X>();
		for (int i = 0;i < size;i++) {
			if (arrayList[i].getClass() == type.getClass()) {
				objects.add((X)arrayList[i]);
			}
		}
		return objects.toArray();
	}
	//Liste içerisindeki nesnelerden verilen tiptekileri liste halinde döndürür.
	public <X> List<X> findObjectsWithTypeReturnList(Class<X> type){
		List<X> objects = new List<X>();
		for (int i = 0;i < size;i++) {
			if (arrayList[i].getClass() == type) {
				objects.add((X)arrayList[i]);
			}
		}
		return objects;
	}
	//Verilen indexlerdeki nesnelerin yerlerini birbirleriyle değiştirir.
	public void swap(int index1,int index2) {
		indexChecking(index1);
		indexChecking(index2);
		T temp = arrayList[index1];
		arrayList[index1] = arrayList[index2];
		arrayList[index2] = temp;
	}
	//Index hataları değerlendirilir. Index negatif olmamalı ve liste sınırını aşmamalıdır.
	private void indexChecking(int index) {
		if (index > size - 1) {
			throw new IllegalStateException("Belirtilen index liste sınırını aşıyor.");
		}
		else if (index < 0) {
			throw new IllegalStateException("Belirtilen index değeri negatif olamaz.");
		}
	}
}
