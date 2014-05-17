package com.example.antlrtest.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides list of documentation items to documentation.
 */
public class DummyContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

	static {
		// Add 3 sample items.
		addItem(new DummyItem("20", "MoveForward", "moveForward(1);"));
		addItem(new DummyItem("2", "MoveBackward", "moveBackward(1);"));
		addItem(new DummyItem("3", "TurnLeft", "turnLeft(1);"));
		addItem(new DummyItem("4", "TurnRight", "turnRight(1);"));
		addItem(new DummyItem("5", "Shoot", "shoot(1);"));
	}

	private static void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DummyItem {
		public String id;
		public String content;
		public String exampleUse;

		public DummyItem(String id, String content, String exampleUse) {
			this.id = id;
			this.content = content;
			this.exampleUse = exampleUse;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
