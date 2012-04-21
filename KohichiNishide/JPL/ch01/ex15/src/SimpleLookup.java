
public class SimpleLookup implements Lookup{
	private String[] names;
	private Object[] values;
	
	public Object find(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name))
				return values[i];
		}
		return null; //Œ©‚Â‚©‚ç‚È‚©‚Á‚½
	}
}
