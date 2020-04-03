package com.jackgu.mybatis.resource;

import com.jackgu.mybatis.mapper.UsersMapper;
import com.jackgu.mybatis.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

	@Autowired
	private UsersMapper usersMapper;

	@GetMapping("/all")
	public List<Users> getAll() {
		return usersMapper.findAll();
	}

	@GetMapping("/insert")
	public List<Users> insert() {
		Users users = new Users();
		users.setName("jack");
		users.setSalary(1000L);

		usersMapper.insert(users);

		return usersMapper.findAll();
	}

	@GetMapping("/update/{name}")
	public List<Users> update(@PathVariable("name") final String name) {
		Users users = new Users();
		users.setName(name);
		users.setSalary(3000L);

		usersMapper.update(users);

		return usersMapper.findAll();
	}

	@GetMapping("/delete/{name}")
	public List<Users> delete(@PathVariable("name") final String name) {
		Users users = new Users();
		users.setName(name);

		usersMapper.delete(users);

		return usersMapper.findAll();
	}

}
