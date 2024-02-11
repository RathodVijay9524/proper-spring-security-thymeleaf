package com.vijay;

import com.vijay.model.Role;
import com.vijay.model.User;
import com.vijay.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Value("${normal.role.id}")
	private String normalRoleId;

	@Value("${admin.role.id}")
	private String adminRoleId;

	@Value("${user.role.id}")
	private String userRoleId;


	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*User user = new User();
		user.setEmail("vijayrathod3437@gmail.com");
		user.setFullname("VIJAY RATHOD");
		user.setPassword(passwordEncoder.encode("abcd"));

		User user1 = new User();
		user.setEmail("vijayrathod9524@gmail.com");
		user.setFullname("VIJAY RATHOD");
		user.setPassword(passwordEncoder.encode("abc"));

		User user2 = new User();
		user.setEmail("omvijay44@gmail.com");
		user.setFullname("VIJAY VITTHAL RATHOD");
		user.setPassword(passwordEncoder.encode("asdf"));



		Role role =Role.builder()
				.roleName("ROLE_ADMIN")
				.roleId(adminRoleId)
				.build();
		Set<Role> roles = new HashSet<>();
		roles.add(role);


		Role role1 = new Role();
		role1.setRoleId(userRoleId);
		role1.setRoleName("ROLE_USER");
		// Create a collection of roles
		Set<Role> roles1 = new HashSet<>();
		roles1.add(role1);

		Role role2 = new Role();
		role2.setRoleId(normalRoleId);
		role2.setRoleName("ROLE_NORMAL");
		Set<Role> roles2 = new HashSet<>();
		roles2.add(role2);

		user.setRoles(roles);
		user1.setRoles(roles1);
		user2.setRoles(roles2);

		List<User> list= Arrays.asList(user, user1 ,user2);
		repository.saveAll(list);
*/



	}
}
