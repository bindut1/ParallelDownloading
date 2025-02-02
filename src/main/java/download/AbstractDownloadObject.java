package download;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractDownloadObject {
	protected volatile boolean runningFlag;
	protected volatile double totalPauseTime;
	protected volatile double lastPauseTime;
	protected volatile double startTime;
	protected volatile boolean completedFlag;
	protected ExecutorService executor;
	protected ReentrantLock lock;
	protected Condition pauseCondition;

	protected String url;
	protected String path;
	protected String fileName;

	protected double progress;
	protected String detailText;

	public abstract void start();

	public abstract void pause();

	public abstract void resume();

	public abstract void cancel();

	public abstract boolean getRunningFlag();

	public abstract boolean getCompletedFlag();

	public abstract double getStartTime();

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public double getProgress() {
		return this.progress;
	}

	public String getDetailText() {
		return this.detailText;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public double getTotalPauseTime() {
		return totalPauseTime;
	}
}
