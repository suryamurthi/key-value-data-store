import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {
	Map<String, List<String>> dictionary = new HashMap<>();
	
    public void create(String key,Object value,int timeout) {
    	if(dictionary.containsKey(key)) {
    		System.out.println("Error: Key " + key + " already exists");
    	} else {
    		if(isAlpha(key)) {
    			if(dictionary.size()< (1024*1024*1024) && 
    					value.toString().length() <= (16*1024*1024)) {
    				List valueList = new ArrayList();
    				valueList.add(value);
    				if(timeout == 0) {
    					valueList.add(Long.parseLong(String.valueOf(timeout)));
    				} else {
    					valueList.add(Long.parseLong(String.valueOf(new Date().getTime() + timeout)));
    				}
    				if(key.length() < 32) {
    					dictionary.put(key, valueList);
    					System.out.println("" + key + " is successfully added to datastore");
    				}
    			} else {
    				System.out.println("Error: Memory limit exceeded!!");
    			}
    		} else {
    			System.out.println("Error: Invalind key_name!! key_name must "
    					+ "contain only alphabets and no special characters or numbers");
    		}
    	}
    }
    
    public void create(String key, Object value) {
    	if(dictionary.containsKey(key)) {
    		System.out.println("Error: Key " + key + " already exists");
    	} else {
    		if(isAlpha(key)) {
    			if(dictionary.size()< (1024*1024*1024) && 
    					value.toString().length() <= (16*1024*1024)) {
    				List valueList = new ArrayList();
    				valueList.add(value);
    				valueList.add(0L);
    				if(key.length() < 32) {
    					dictionary.put(key, valueList);
    					System.out.println("" + key + " is successfully added to datastore");
    				}
    			} else {
    				System.out.println("Error: Memory limit exceeded!!");
    			}
    		} else {
    			System.out.println("Error: Invalind key_name!! key_name must "
    					+ "contain only alphabets and no special characters or numbers");
    		}
    	}
    }
    
    public static boolean isAlpha(String s) {
        if (s == null)
            return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z'))
                return false;
        }
        return true;
    }
    
    public String read(String key) {
    	if(!dictionary.containsKey(key)) {
    		System.out.println("Error: Given key does not exist in database. Please enter a valid key");
    	} else {
    		List valueList = dictionary.get(key);
    		long timeout = (long)valueList.get(1);
    		if(timeout != 0) {
    			if(new Date().getTime() < timeout) {
        			return key + " : " + valueList.get(0);
        		} else {
        			//System.out.println("Error: time-to-live of " + key + " has expired");
        		}
    		} else {
    			return key + " : " + valueList.get(0);
    		}
    	}
    	return "Error: time-to-live of " + key + " has expired. Thus, read operation not supported";
    }
    
    public void delete(String key) {
    	if(!dictionary.containsKey(key)) {
    		System.out.println("Error: Given key does not exist in database. Please enter a valid key");
    	} else {
    		List valueList = dictionary.get(key);
    		long timeout = (long)valueList.get(1);
    		if(timeout != 0) {
    			if(new Date().getTime() < timeout) {
    				dictionary.remove(key);
    				System.out.println("Key is successfully deleted from datastore");
        		} else {
        			System.out.println("Error: time-to-live of " + key + " has expired. Thus, delete not supported");
        		}
    		} else {
    			dictionary.remove(key);
    			System.out.println("Key is successfully deleted from datastore");
    		}
    	}
    }
    
   
}