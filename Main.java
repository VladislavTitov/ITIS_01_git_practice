import java.util.*;
import java.lang.*;

class Main {

	private List<Item> items;
	private Comparator<Item> comparator;

	Main(List<Item> items) {
		this.items = items;
	}

	public void setComparator(Comparator<Item> comp) {
		comparator = comp;
	}

	private List<Item> copy() {
		List<Item> newItems = new ArrayList();
		for (Item item: this.items) {
			newItems.add(item);
		}
		return newItems;
	}

	public List<Item> getSortedItems() {
		List<Item> sorted = copy();
		Collections.sort(sorted, this.comparator);
		return sorted;
	}

	static class Item {

		private String content;
		private Date timestamp;

		Item(String content, Date timestamp) {
			this.content = content;
			this.timestamp = timestamp;
		}

		public String getContent() {
			return content;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public String toString() {
			return "{" + content + ", " + timestamp + "}";
		}
	}

	public static void main(String... args) {
		List<Main.Item> items = new ArrayList(){{
			add(new Item("2", new Date(System.currentTimeMillis())));
			add(new Item("1", new Date(System.currentTimeMillis() - 1000L)));
			add(new Item("3", new Date(System.currentTimeMillis() + 1000L)));
		}};
		Main main = new Main(items);
		main.setComparator(new Comparator<Main.Item>() {
			public int compare(Main.Item i1, Main.Item i2) {
				return i1.getTimestamp().compareTo(i2.getTimestamp());
			}
		});
		List<Main.Item> sortedItems = main.getSortedItems();
		System.out.println(sortedItems);
	}
}
