package asm2.com.poly.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import asm2.com.poly.entity.account;
import asm2.com.poly.service.Impl.accountServiceImpl;

public class testAccountService {
	accountService service = new accountServiceImpl();

	@ParameterizedTest
	@CsvSource({ "1", "2", "3", "4" })
	void findById(Integer Id) {
		account account = service.findById(Id);
		Assertions.assertNotNull(account);
	};

	@ParameterizedTest
	@CsvSource({ "hahuytri2K3@gmail.com", "nosir@nosir", "yadsadksahdksahdsad", "email@email.email.com" })
	void findByemail(String email) {
		account account = service.findByemail(email);
		Assertions.assertNotNull(account);
	};

	@ParameterizedTest
	@CsvSource({ "accUser", "accAdmin", "accUser2", "9wrBeWc944Uz" })
	void findByUsername(String username) {
		account account = service.findByUsername(username);
		Assertions.assertNotNull(account);
	};

	@ParameterizedTest
	@CsvSource({ "9wrBeWc944U, abc", "accUser, abc", "abc ,dsadv9wrBeWc944U", "accAdmin, abc" })
	void findByUsernameAndPassword(String username, String password) {
		account account = service.findByUsernameAndPassword(username, password);
		Assertions.assertNotNull(account);
	};

	@Test
	void findAll() {
		List<account> listAccount = service.findAll();
		Assertions.assertNotNull(listAccount);
	};

	@ParameterizedTest
	@CsvSource({ "5, 8", "2, 10", "6 , n", "kaka, 1" })
	void findAll(Integer pageNumber, Integer pageSize) {
		List<account> listAccount = service.findAll(pageNumber, pageSize);
		Assertions.assertNotNull(listAccount);
	};
	
	@ParameterizedTest()
	@CsvFileSource(resources = { "/testAccountService.csv" }, numLinesToSkip = 0)
	void create(Integer id, String username, String email, String password, String avatar, Boolean isadmin,  boolean isactive, String nameChannel) {
		account entity = new account();
		entity.setId(id);
		entity.setAccountusername(username);
		entity.setEmail(email);
		entity.setAccountpassword(password);
		entity.setAvatar(avatar);
		entity.setIsadmin(isadmin);
		entity.setIsactive(isactive);
		entity.setDatecreate(null);
		entity.setDateupdate(null);
		entity.setNameChannel(nameChannel);
		account account = service.create(entity);
		Assertions.assertNotNull(account);
	};

	@ParameterizedTest()
	@CsvFileSource(resources = { "/testAccountService.csv" }, numLinesToSkip = 0)
	void delete(Integer id, String username, String email, String password, String avatar, Boolean isadmin,  boolean isactive, String nameChannel) {
		account entity = new account();
		entity.setId(id);
		entity.setAccountusername(username);
		entity.setEmail(email);
		entity.setAccountpassword(password);
		entity.setAvatar(avatar);
		entity.setIsadmin(isadmin);
		entity.setIsactive(isactive);
		entity.setDatecreate(null);
		entity.setDateupdate(null);
		entity.setNameChannel(nameChannel);
		account account = service.delete(entity);
		Assertions.assertNotNull(account);
	};


	@ParameterizedTest()
	@CsvFileSource(resources = { "/testAccountService.csv" }, numLinesToSkip = 0)
	void update(Integer id, String username, String email, String password, String avatar, Boolean isadmin,  boolean isactive, String nameChannel) {
		account entity = new account();
		entity.setId(id);
		entity.setAccountusername(username);
		entity.setEmail(email);
		entity.setAccountpassword(password);
		entity.setAvatar(avatar);
		entity.setIsadmin(isadmin);
		entity.setIsactive(isactive);
		entity.setDatecreate(null);
		entity.setDateupdate(null);
		entity.setNameChannel(nameChannel);
		account account = service.update(entity);
		Assertions.assertNotNull(account);
	};
}
