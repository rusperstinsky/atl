package core.db;

public class Utils {

	
	public static Boolean isNumeric( String data ){
		try{
			Long.parseLong(data);			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
