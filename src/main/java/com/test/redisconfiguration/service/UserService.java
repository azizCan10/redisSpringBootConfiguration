package com.test.redisconfiguration.service;

import com.test.redisconfiguration.core.result.DataResult;
import com.test.redisconfiguration.core.result.Result;
import com.test.redisconfiguration.core.result.SuccessDataResult;
import com.test.redisconfiguration.core.result.SuccessResult;
import com.test.redisconfiguration.exception.UserNotFoundException;
import com.test.redisconfiguration.model.User;
import com.test.redisconfiguration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>((List<User>) userRepository.findAll(), "All users listed.");
    }

    public Result add(User user) {
        userRepository.save(user);
        return new SuccessResult("User added. Name: " + user.getName());
    }

    public Result delete(Long id) {
        findUserById(id);

        userRepository.deleteById(id);
        return new SuccessResult("User deleted. Deleted id: " + id);
    }

    public DataResult<User> findById(Long id) {
        return new SuccessDataResult<>(findUserById(id), "User listed. Id: " + id);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User couldn't find by id: " + id));
    }
}
