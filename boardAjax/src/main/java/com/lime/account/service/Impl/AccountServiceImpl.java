package com.lime.account.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lime.account.service.AccountService;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Resource(name="accountDAO")
	private AccountDAO accountDAO;






}
