package com.shobhit.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.shobhit.entity.User;

@Repository
public class UserRepository {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public void saveUser(User user) {
		redisTemplate.opsForHash().put(User.HASH, user.getUserId(), user);
	}

	public List<User> findAllUsers() {
		/*return redisTemplate.opsForHash().entries(User.HASH).values()
				.stream()
				.map(value -> (User) value)
				.collect(Collectors.toList());*/

		return redisTemplate.opsForHash().values(User.HASH)
				.stream()
				.map(value -> (User) value)
				.collect(Collectors.toList());
	}

	public User findUser(int userId) {
		return (User) redisTemplate.opsForHash().get(User.HASH, userId);
	}

	public void deleteUser(int userId) {
		redisTemplate.opsForHash().delete(User.HASH, userId);
	}
}