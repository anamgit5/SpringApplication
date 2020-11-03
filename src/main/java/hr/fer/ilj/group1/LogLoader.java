package hr.fer.ilj.group1;


import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;


public class LogLoader {
	LogParser parser;
	
	public LogLoader() {
		parser = new LogParser();
	}
	
	public void setParser(LogParser parser) {
		this.parser = parser;
	}

	public Collection<LogEntry> load(ReadLineReader readlineReader) throws IOException {
		LinkedList<LogEntry> logs = new LinkedList<>();
		int row = 1;
		
		try {
			String line = readlineReader.readLine();
			row++;
			LogEntry entry = null;
			StringBuilder sb = new StringBuilder();
	
			while(line != null) {
				Optional<LogEntry> optional = parser.parse(line);
				
				if(optional.isPresent()) {
					if(sb.length() != 0) {
						entry.setMessage(sb.toString());
						sb.setLength(0);
					}	
					entry = optional.get();
					logs.add(entry);
				} else {
					if(entry != null) {
						if(sb.length() == 0) {
							sb.append(entry.getMessage());
						}
						sb.append("\n");
						sb.append(line);
					}
				}
				
				line = readlineReader.readLine();
				row++;
			}
		} catch (IOException e) {
			throw new RuntimeException("Can not read log entry in row " + row + ".", e);
		}
		
		return logs;
	}

}

