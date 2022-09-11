package com.webosmotic.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webosmotic.model.Customer;
import com.webosmotic.model.CustomerDto;
import com.webosmotic.model.Role;
import com.webosmotic.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Customer save(CustomerDto customerDto) {
		Customer customer = new Customer(customerDto.getName(), customerDto.getMobile(), customerDto.getEmail(),
				customerDto.getUserName(), bCryptPasswordEncoder.encode(customerDto.getPassword()),
				customerDto.getRoles(), customerDto.getAccount());
		return customerRepository.save(customer);

	}

	public List<CustomerDto> test() {
		return customerRepository.findAll().stream().map(cust -> {
			CustomerDto obj = new CustomerDto();
			obj.setAccount(cust.getAccount());
			obj.setUserName(cust.getUserName());
			obj.setMobile(cust.getMobile());
			obj.setEmail(cust.getEmail());
			return obj;
		}).collect(toList());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByUserName(username);
		if (null == customer) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new User(customer.getUserName(), customer.getPassword(), maRoleAuthorities(customer.getRoles()));
	}

	private Collection<? extends GrantedAuthority> maRoleAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	static int i = 0;

	public static void maintainToAccess() {
		int maintain = 0;
		int i = 7;
		maintainToAccess();
		CustomerServiceImpl.i = i;
	}

	public void main() {
		(int a, int b)->{
			int i=a+b;
			System.out.println("i - "+i);
		}
	}
}
