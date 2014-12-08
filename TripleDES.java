
public class TripleDES {

	DES DES1;
	DES DES2;
	DES DES3;
	
	TripleDES(String key1, String key2, String key3){
		assert (key1.length() == 8
				 && key2.length() == 8
				 && key3.length() == 8);
		DES1 = new DES(key1);
		DES2 = new DES(key2);
		DES3 = new DES(key3);
	}
	
	public String encrypt(String in){
		return DES3.encrypt(DES2.decrypt(DES1.encrypt(in)));
	}
	
	public String decrypt(String in){
		return DES1.decrypt(DES2.encrypt(DES3.decrypt(in)));
	}
}
