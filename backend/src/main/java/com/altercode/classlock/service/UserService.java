package com.altercode.classlock.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.classlock.dto.ConquestDTO;
import com.altercode.classlock.dto.UserDTO;
import com.altercode.classlock.entity.Conquest;
import com.altercode.classlock.entity.User;
import com.altercode.classlock.repository.ConquestRepository;
import com.altercode.classlock.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ConquestRepository conquestRepository;

	public List<UserDTO> findAll() {
		List<User> result = repository.findAll();
		return result.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable) {
		Page<User> result = repository.findAll(pageable);
		Page<UserDTO> page = result.map(x -> new UserDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		User result = repository.findById(id).get();
		UserDTO dto = new UserDTO(result);
		return dto;
	}
	
	@Transactional
	public List<ConquestDTO> findByUser(User user) {
		return conquestRepository.findByUser(user);
	}

	public Page<ConquestDTO> findAllConquests(Pageable pageable) {
		Page<Conquest> result = conquestRepository.findAll(pageable);
		Page<ConquestDTO> page = result.map(x -> new ConquestDTO(x));
		return page;
	}

	@Transactional
	public ConquestDTO findConquestById(Long id) {
		return conquestRepository.findConquestById(id);
	}
	
	@Transactional
	public List<UserDTO> getByName(String prefix) {
		List<User> result = repository.getByName(prefix);
		return result.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
}
