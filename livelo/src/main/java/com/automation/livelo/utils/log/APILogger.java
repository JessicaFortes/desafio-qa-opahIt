package com.automation.livelo.utils.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.commons.lang3.StringUtils;

public class APILogger {
	
	 static Log log = LogFactory.getLog(APILogger.class);
	
	public static void debug(String mensagem, Object... args) {
		String msgFormatada = String.format(mensagem, args);
		log.debug(msgFormatada);
	}

	public static void info(String mensagem, Object... args) {
		String msgFormatada = String.format(mensagem, args);
		log.info(msgFormatada);
	}

	public static void warn(String mensagem, Object... args) {
		String msgFormatada = String.format(mensagem, args);
		log.warn(msgFormatada);
	}

	public static void error(String mensagem, Object... args) {
		String msgFormatada = String.format(mensagem, args);
		log.error(msgFormatada);
	}

	public static void logMethod(Object... args) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement currentMethod = stackTrace[2];
		StackTraceElement currentLocation = stackTrace[3];
		String className = currentMethod.getClassName();
		String methodName = currentMethod.getMethodName();
		String fileName = currentLocation.getFileName();
		int lineNumber = currentLocation.getLineNumber();

		APILogger.debug("(%s:%d) %s.%s(%s)", fileName, lineNumber, className, methodName, StringUtils.join(args, ", "));
	}

	
}
