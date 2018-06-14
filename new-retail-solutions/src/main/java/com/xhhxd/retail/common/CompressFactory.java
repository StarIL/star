package com.xhhxd.retail.common;

import java.util.concurrent.atomic.AtomicReference;

import com.xhhxd.retail.common.compress.Compress;
import com.xhhxd.retail.common.compress.Compress.CompressType;

public class CompressFactory {
	
	private static AtomicReference<Compress> compressRef = new AtomicReference<Compress>();

	public static Compress build(CompressType compressType) {
		Compress compress = compressRef.get();
		if (compressRef.get() != null) {
			return compress;
		}
		synchronized (CompressFactory.class) {
			compress = CompressType.getCompressByValue(compressType);
			compressRef.set(compress);
			return compress;
		}
	}
}