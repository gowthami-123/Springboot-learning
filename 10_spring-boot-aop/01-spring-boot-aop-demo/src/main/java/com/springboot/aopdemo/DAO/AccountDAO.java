package com.springboot.aopdemo.DAO;

import com.springboot.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount,boolean flag);
    boolean doWork();
}
