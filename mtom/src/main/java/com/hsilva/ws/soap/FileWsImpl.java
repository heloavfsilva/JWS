package com.hsilva.ws.soap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {
	InputStream inputStream = null;
	OutputStream outputStream = null;
	
	@Override
	public void upload(DataHandler attachment) {
		try {
			inputStream = attachment.getInputStream();
			outputStream = new FileOutputStream(new File("C:\\Users\\hsilva25\\Desktop\\Personal\\mtom"));
			byte[] b = new byte[100000];
			int bytesRead = 0;
			while((bytesRead=inputStream.read(b))!= -1) {
				outputStream.write(b,0,bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public DataHandler dowload() {
		return new DataHandler(new FileDataSource("C:\\Users\\hsilva25\\Desktop\\Personal\\mtom"));
	}

}
