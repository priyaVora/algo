class PhoneDirectory {
   
 	  public static  String phone(String strng, String num) {
				String message = "";
				String num2 = "+" + num;
				String[] contacts = strng.split("\n");
				String contact = null;
				int phoneCount = 0;
				loop: for (String string : contacts) {
					phoneCount = phoneCount + countContains(num2, string);
					if(phoneCount == 0) {
						message = "Error => Not found: " + num;
					} else if(phoneCount>1) {
						message = "Error => Too many people: " + num;
						break loop;
					} else {
						if(string.contains(num2)) {
							contact = string;
						}
					}
				}
				if (contact != null && phoneCount == 1) { 
					String name = null;
					String addr = null;
					contact = contact.replaceAll(num, "");
					if(contact.contains("<") && contact.contains(">"))  {
						String rawRegex = "<(.*)>";
						name = contact.substring(contact.indexOf("<", 0)+1, contact.indexOf(">", 0));
						contact = contact.replaceAll("<" + name + ">", "");
					}
					
					addr = contact.replaceAll("[^A-z0-9\\d\\s.-]", "");
					addr = addr.replaceAll("_", " ");
					addr = addr.trim();
		      		addr = addr.replace("  ", " ");
					message = "Phone => " + num + ", Name => " + name + ", Address => " + addr;
				}
	      message = message.replace("+", "");
				return message;
		    }
		 
		 public static int countContains(String needle, String haystack) {
				int count = 0;
				if(haystack.contains(needle)) { 
					count++;
				} 
				return count;
			}
}