package skinsrestorer.libs.org.json.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ItemList {

	private String sp = ",";
	List<String> items = new ArrayList<String>();

	public ItemList() {
	}

	public ItemList(String s) {
		this.split(s, sp, items);
	}

	public ItemList(String s, String sp) {
		this.sp = s;
		this.split(s, sp, items);
	}

	public ItemList(String s, String sp, boolean isMultiToken) {
		split(s, sp, items, isMultiToken);
	}

	public List<String> getItems() {
		return items;
	}

	public String[] getArray() {
		return items.toArray(new String[0]);
	}

	public void split(String s, String sp, List<String> append, boolean isMultiToken) {
		if ((s == null) || (sp == null)) {
			return;
		}
		if (isMultiToken) {
			StringTokenizer tokens = new StringTokenizer(s, sp);
			while (tokens.hasMoreTokens()) {
				append.add(tokens.nextToken().trim());
			}
		} else {
			this.split(s, sp, append);
		}
	}

	public void split(String s, String sp, List<String> append) {
		if ((s == null) || (sp == null)) {
			return;
		}
		int pos = 0;
		int prevPos = 0;
		do {
			prevPos = pos;
			pos = s.indexOf(sp, pos);
			if (pos == -1) {
				break;
			}
			append.add(s.substring(prevPos, pos).trim());
			pos += sp.length();
		} while (pos != -1);
		append.add(s.substring(prevPos).trim());
	}

	public void setSP(String sp) {
		this.sp = sp;
	}

	public void add(int i, String item) {
		if (item == null) {
			return;
		}
		items.add(i, item.trim());
	}

	public void add(String item) {
		if (item == null) {
			return;
		}
		items.add(item.trim());
	}

	public void addAll(ItemList list) {
		items.addAll(list.items);
	}

	public void addAll(String s) {
		this.split(s, sp, items);
	}

	public void addAll(String s, String sp) {
		this.split(s, sp, items);
	}

	public void addAll(String s, String sp, boolean isMultiToken) {
		this.split(s, sp, items, isMultiToken);
	}

	public String get(int i) {
		return (String) items.get(i);
	}

	public int size() {
		return items.size();
	}

	@Override
	public String toString() {
		return toString(sp);
	}

	public String toString(String sp) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < items.size(); i++) {
			if (i == 0) {
				sb.append(items.get(i));
			} else {
				sb.append(sp);
				sb.append(items.get(i));
			}
		}
		return sb.toString();

	}

	public void clear() {
		items.clear();
	}

	public void reset() {
		sp = ",";
		items.clear();
	}

}