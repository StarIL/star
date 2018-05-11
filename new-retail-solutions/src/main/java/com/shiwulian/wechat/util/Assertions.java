package com.shiwulian.wechat.util;

public final class Assertions {

	public static <T> T notNull(final String name, final T value) {
		if (value == null) {
			throw new IllegalArgumentException(name + " can not be null");
		}
		return value;
	}

	public static void isTrue(final String name, final boolean condition) {
		if (!condition) {
			throw new IllegalStateException("state should be: " + name);
		}
	}

	public static void isTrueArgument(final String name, final boolean condition) {
		if (!condition) {
			throw new IllegalArgumentException("state should be: " + name);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T convertToType(final Class<T> clazz, final Object value, final String errorMessage) {
		if (!clazz.isAssignableFrom(value.getClass())) {
			throw new IllegalArgumentException(errorMessage);
		}
		return (T) value;
	}

	private Assertions() {
	}
}