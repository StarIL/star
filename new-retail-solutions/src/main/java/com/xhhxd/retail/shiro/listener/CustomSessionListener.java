package com.xhhxd.retail.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xhhxd.retail.shiro.session.ShiroSessionRepository;


public class CustomSessionListener implements SessionListener {

	private final static Logger logger = LoggerFactory.getLogger(CustomSessionListener.class);

	private ShiroSessionRepository shiroSessionRepository;

	public CustomSessionListener(ShiroSessionRepository shiroSessionRepository) {
		this.shiroSessionRepository = shiroSessionRepository;
	}

	@Override
	public void onStart(Session session) {
		logger.info("session {} on start!", session.getId());
	}

	@Override
	public void onStop(Session session) {
		shiroSessionRepository.deleteSession(session.getId());
		logger.info("session {} on stop!", session.getId());
	}

	@Override
	public void onExpiration(Session session) {
		shiroSessionRepository.deleteSession(session.getId());
	}

	public ShiroSessionRepository getShiroSessionRepository() {
		return shiroSessionRepository;
	}

	public void setShiroSessionRepository(ShiroSessionRepository shiroSessionRepository) {
		this.shiroSessionRepository = shiroSessionRepository;
	}

}
