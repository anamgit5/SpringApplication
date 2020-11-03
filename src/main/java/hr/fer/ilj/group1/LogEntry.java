package hr.fer.ilj.group1;

public class LogEntry {
	private String time; 
	private String level;
	private String message;
	private String thread;
	private int pid; 

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getThread() {
		return thread;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPid() {
		return pid;
	}
}

