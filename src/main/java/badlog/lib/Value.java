package badlog.lib;

class Value extends NamespaceObject {
	String name;
	String value;
	
	public Value(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
}
