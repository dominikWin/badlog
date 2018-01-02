package badlog.lib;

import java.util.Optional;

class SubscribedTopic extends Topic {

	private String name;
	private String unit;
	private DataInferMode inferMode;
	private String[] attrs;

	private String value = BadLog.DEFAULT_DATA;

	public SubscribedTopic(String name, String unit, DataInferMode inferMode, String... attrs) {
		this.name = name;
		this.unit = unit;
		this.inferMode = inferMode;
		this.attrs = attrs;
	}

	public String getUnit() {
		return unit;
	}

	public String[] getAttributes() {
		return attrs;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public void handlePublishedData(Optional<String> data) {
		switch(inferMode) {
		case DEFAULT:
			value = data.orElse(BadLog.DEFAULT_DATA);
			break;
		case LAST:
			if(data.isPresent())
				value = data.get();
			break;
		}
	}
}
