package compiler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Utils {

	public static final int MIN_ELEMENTS_FOR_INTERVAL = 3;

	static public Map<String, String> collapse(Map<String, String> transitionMap) {
		final Map<String, List<String>> combinedTransitions = new HashMap<>();

		for (final String terminal : transitionMap.keySet()) {
			final String state = transitionMap.get(terminal);
			combinedTransitions.computeIfAbsent(state, k -> new LinkedList<>()).add(terminal);
		}

		final Map<String, String> collapsedMap = new HashMap<>();
		for (final Map.Entry<String, List<String>> entry : combinedTransitions.entrySet()) {
			final StringBuilder stringBuilder = new StringBuilder();
			final String state = entry.getKey();
			final List<String> terminals = entry.getValue();
			Collections.sort(terminals);
			final List<String> intervals = extendInterval(terminals.iterator());
			for (final String terminal : intervals) {
				stringBuilder.append(terminal).append("|");
			}
			collapsedMap.put(stringBuilder.substring(0, stringBuilder.length() - 1), state);
		}

		return collapsedMap;
	}

	static public List<String> extendInterval(Iterator<String> terminals) {
		final List<String> intervals = new LinkedList<>();
		extendInterval(intervals, terminals);
		return intervals;
	}

	static private void extendInterval(List<String> intervals,
									   char lowestCodepoint,
									   char lastCodepoint,
									   Iterator<String> terminals) {
		if (!terminals.hasNext()) {
			if (lastCodepoint - lowestCodepoint >= MIN_ELEMENTS_FOR_INTERVAL) {
				intervals.add(String.format("[%c-%c]", lowestCodepoint, lastCodepoint));
			} else {
				for (char c = lowestCodepoint; c <= lastCodepoint; ++c) {
					intervals.add(String.valueOf(c));
				}
			}
			return;
		}
		final String terminal = terminals.next();
		if (terminal.length() == 1) {
			char codepoint = terminal.charAt(0);
			if (codepoint == lastCodepoint + 1) {
				extendInterval(intervals, lowestCodepoint, codepoint, terminals);
			} else {
				if (lastCodepoint - lowestCodepoint >= MIN_ELEMENTS_FOR_INTERVAL) {
					intervals.add(String.format("[%c-%c]", lowestCodepoint, lastCodepoint));
				}
				extendInterval(intervals, codepoint, codepoint, terminals);
			}
		} else {
			intervals.add(terminal);
			extendInterval(intervals, lowestCodepoint, lastCodepoint, terminals);
		}
	}

	static private void extendInterval(List<String> intervals, Iterator<String> terminals) {
		if (!terminals.hasNext()) {
			return;
		}
		final String terminal = terminals.next();
		if (terminal.length() == 1) {
			char codepoint = terminal.charAt(0);
			extendInterval(intervals, codepoint, codepoint, terminals);
		} else {
			intervals.add(terminal);
			extendInterval(intervals, terminals);
		}
	}

}
