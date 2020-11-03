package hr.fer.ilj.group1;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
	private static final String regex = "^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"
			+ "\\.\\d{3})\\s+(\\S+)\\s+(\\d+)\\s+---\\s+\\[([^\\]]+)\\]\\s+(.+)$";
	private static final Pattern pattern = Pattern.compile(regex);

	public Optional<LogEntry> parse(String line) {
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
		  if(matcher.groupCount() == 5) {
			  LogEntry entry = new LogEntry();
			  entry.setTime(matcher.group(1));
			  entry.setLevel(matcher.group(2));
			  entry.setPid(Integer.parseInt(matcher.group(3)));
			  entry.setThread(matcher.group(4));
			  entry.setMessage(matcher.group(5));
			  return Optional.of(entry);
		  }
		}
		
		return Optional.empty();
	}

}

