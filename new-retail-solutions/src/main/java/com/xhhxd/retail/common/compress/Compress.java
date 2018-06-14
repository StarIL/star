package com.xhhxd.retail.common.compress;

import java.io.IOException;

public interface Compress {
	byte[] compress(byte[] array) throws IOException;

	byte[] unCompress(byte[] array) throws IOException;
	
	
	public enum CompressType {

		None(0), GZIP(1);

		private int value;

		CompressType(int value) {
			this.value = value;
		}

		public static Compress getCompressByValue(CompressType type) {
			if (type == CompressType.None) {
				return new NoCompress();
			} else if (type == CompressType.GZIP) {
				return new GZipCompress();
			} else {
				return new NoCompress();
			}
		}

		public int getValue() {
			return value;
		}
	}
}
