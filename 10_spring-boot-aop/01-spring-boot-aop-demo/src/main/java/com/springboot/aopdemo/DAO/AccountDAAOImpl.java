package com.springboot.aopdemo.DAO;

import com.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;



@Repository
public class AccountDAAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account theAccount,boolean flag) {

        System.out.println(getClass()+"Adding an Account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + "doWork()");
        return true;
    }
}
