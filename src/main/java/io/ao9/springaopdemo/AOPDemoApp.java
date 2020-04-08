package io.ao9.springaopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.ao9.springaopdemo.dao.AccountDAO;
import io.ao9.springaopdemo.dao.MembershipDAO;
import io.ao9.springaopdemo.entity.Account;
import io.ao9.springaopdemo.service.TrafficFortuneService;

@SpringBootApplication
public class AOPDemoApp implements CommandLineRunner {
	@Autowired
	private ApplicationContext applicationContext;

	private Logger logger = Logger.getLogger(AOPDemoApp.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(AOPDemoApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AccountDAO theAccountDao = applicationContext.getBean(AccountDAO.class);
		MembershipDAO theMembershipDAO = applicationContext.getBean(MembershipDAO.class);
		TrafficFortuneService 	theTrafficFortuneService = applicationContext.getBean(TrafficFortuneService.class);
		
		theAccountDao.doWork();
		theAccountDao.getServiceCode();
		theAccountDao.setServiceCode("test");
		try {
			theAccountDao.addAccount(new Account("Ao", "pro"), true);
		} catch (Throwable e) {
			logger.info("==== " + e.getMessage());
			logger.info("\n");
		}
		try {
			theAccountDao.addAccount(new Account("Ao", "pro"), false);
		} catch (Throwable e) {
			logger.info("==== " + e.getMessage());
			logger.info("\n");
		}
		theMembershipDAO.addAccount();
		theMembershipDAO.addAMember();
		theMembershipDAO.goToSleep();

		List<Account> accounts = theAccountDao.findAccounts();
		logger.info("==== Main programming " + accounts);
		logger.info("\n");
		
		logger.info("==== " + theTrafficFortuneService.getFortune(false));
		logger.info("==== " + theTrafficFortuneService.getFortune(true));
	}
}
