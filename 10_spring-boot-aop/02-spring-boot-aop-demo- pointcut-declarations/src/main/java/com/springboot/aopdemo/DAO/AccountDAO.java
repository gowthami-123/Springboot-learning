package com.springboot.aopdemo.DAO;

import com.springboot.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();
    void addAccount(Account theAccount,boolean flag);
    boolean doWork();
    public String getName() ;



    public void setName(String name) ;

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    List<Account> findAccounts(boolean flag);
}
