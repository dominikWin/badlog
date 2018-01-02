package badlog.lib;

import java.util.Optional;
import java.util.function.Supplier;

class QueriedTopic extends Topic {
	
	private String name;
	private String unit;
	private Supplier<String> supplier;
	private String[] attrs;
	
	private Optional<String> value;

	public QueriedTopic(String name, String unit, Supplier<String> supplier, String... attrs) {
		this.name = name;
		this.unit = unit;
		this.supplier = supplier;
		this.attrs = attrs;
		
	}
	
	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public String[] getAttributes() {
		return attrs;
	}
	
	public void refreshValue() {
		value = Optional.of(supplier.get());
	}

	public String getValue() {
		return value.get();
	}
}
