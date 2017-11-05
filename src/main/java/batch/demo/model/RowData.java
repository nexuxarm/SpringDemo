package batch.demo.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RowData extends LinkedHashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	
	public String[] getKeys() {
		List<String> keys = new ArrayList<String>();
		for (String key : this.keySet()) {
			keys.add(key);
		}
		return keys.toArray(new String[0]);
	}
	
	public Object getValue(String key) {
		return this.get(key);
	}
	
	public String getDebugString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		int count = 0;
		for (String key : this.keySet()) {
			count++;
			if (count > 1) sb.append(", ");
			sb.append("\"");
			sb.append(key);
			sb.append("\"");
			sb.append("=");
			sb.append("'");
			sb.append(getValue(key));
			sb.append("'");
		}
		sb.append("}");
		return sb.toString();
	}
}
