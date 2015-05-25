package proiect;

import java.io.IOException;

@SuppressWarnings("serial")
public class Exceptions extends IOException {

	public Exceptions(IOException e) {
		super(e);
	}

	public Exceptions(String msg) {
		super(msg);
	}

	public Exceptions(String msg, IOException e) {
		super(msg, e);
	}
}
