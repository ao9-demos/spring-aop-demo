package io.ao9.springaopdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.ao9.springaopdemo.dao.AccountDAO;
import io.ao9.springaopdemo.dao.MembershipDAO;
import io.ao9.springaopdemo.entity.Account;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner  {
	@Autowired
	private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
		AccountDAO theAccountDao = applicationContext.getBean(AccountDAO.class);
		MembershipDAO theMembershipDAO = applicationContext.getBean(MembershipDAO.class);
		theAccountDao.addAccount(new Account("Ao","pro"), true); 
		theAccountDao.doWork();
		theAccountDao.getServiceCode();
		theAccountDao.setServiceCode("test");
		theMembershipDAO.addAccount();
		theMembershipDAO.addAMember();  
		theMembershipDAO.goToSleep();    
    }
}
