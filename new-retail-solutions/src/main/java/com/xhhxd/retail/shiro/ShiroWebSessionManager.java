package com.xhhxd.retail.shiro;

import java.io.Serializable;
import java.util.Collection;
import javax.servlet.ServletRequest;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.apache.shiro.web.session.mgt.WebSessionManager;

public class ShiroWebSessionManager extends DefaultWebSessionManager implements WebSessionManager {

	public ShiroWebSessionManager() {
		super();
	}

	protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
		Serializable sessionId = getSessionId(sessionKey);

		ServletRequest request = null;
		if (sessionKey instanceof WebSessionKey) {
			request = ((WebSessionKey) sessionKey).getServletRequest();
		}
		if (request != null && null != sessionId) {
			Object sessionObj = request.getAttribute(sessionId.toString());
			if (sessionObj != null) {
				return (Session) sessionObj;
			}
		}
		Session session = null;
		try {
			session = super.retrieveSession(sessionKey);
			if (request != null && null != sessionId) {
				request.setAttribute(sessionId.toString(), session);
			}
		} catch (InvalidSessionException e) {
			
		}
		return session;
	}

	public void validateSessions() {
		Collection<Session> activeSessions = getActiveSessions();
		if (activeSessions != null && !activeSessions.isEmpty()) {
			for (Session session : activeSessions) {
				try {
					SessionKey key = new DefaultSessionKey(session.getId());
					this.validate(session, key);
				} catch (InvalidSessionException e) {
				}
			}
		}
	}
}