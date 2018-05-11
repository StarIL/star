package com.shiwulian.wechat.context;

import com.shiwulian.wechat.bean.bs.User;

public class UserAuthContext {
	private static final ThreadLocal<User> LOCAL = new ThreadLocal<User>() {
		@Override
		protected User initialValue() {
			return new User();
		}
	};

	public static User getLocal() {
		return LOCAL.get();
	}

	public static void removeLocal() {
		LOCAL.remove();
	}

	public static void setLocal(User user) {
		LOCAL.set(user);
	}
}
