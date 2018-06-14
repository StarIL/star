package com.xhhxd.retail.common.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterInputStream;
import java.util.zip.DeflaterOutputStream;

public class DeflateCompress implements Compress {

	private static final int BUFFER_SIZE = 256;

	@Override
	public byte[] compress(byte[] array) throws IOException {
		if (array == null || array.length <= 0) return null;
		
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DeflaterOutputStream deflate = new DeflaterOutputStream(out);
		deflate.write(array);
		deflate.close();
		return out.toByteArray();
	}

	@Override
	public byte[] unCompress(byte[] array) throws IOException {
		if (array == null || array.length <= 0) return null;

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(array);
		DeflaterInputStream gunzip = new DeflaterInputStream(in);
		byte[] buffer = new byte[BUFFER_SIZE];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		return out.toByteArray();
	}

}
