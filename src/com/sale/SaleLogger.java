package com.sale;

import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.sale.consumer.SaleMessageConsumerService;

public class SaleLogger {
	
	public static Logger LOGGER = null;

	static {
	      Logger mainLogger = Logger.getLogger("com.sale");
	      mainLogger.setUseParentHandlers(false);
	      ConsoleHandler handler = new ConsoleHandler();
	      handler.setFormatter(new SimpleFormatter() {
	          private static final String format = "%3$s %n%n";

	          @Override
	          public synchronized String format(LogRecord lr) {
	              return String.format(format,
	                      new Date(lr.getMillis()),
	                      lr.getLevel().getLocalizedName(),
	                      lr.getMessage()
	              );
	          }
	      });
	      mainLogger.addHandler(handler);
	      LOGGER = Logger.getLogger(SaleMessageConsumerService.class.getName());
	  }
}
