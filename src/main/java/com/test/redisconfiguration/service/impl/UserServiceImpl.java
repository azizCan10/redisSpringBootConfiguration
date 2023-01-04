package com.test.redisconfiguration.service.impl;

import com.test.redisconfiguration.core.result.DataResult;
import com.test.redisconfiguration.core.result.Result;
import com.test.redisconfiguration.core.result.SuccessDataResult;
import com.test.redisconfiguration.core.result.SuccessResult;
import com.test.redisconfiguration.model.User;
import com.test.redisconfiguration.repository.UserRepository;
import com.test.redisconfiguration.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>((List<User>) userRepository.findAll(), "All users listed.");
    }

    @Override
    public Result add(User user) {
        userRepository.save(user);
        return new SuccessResult("User added. Name: " + user.getName());
    }

    @Override
    public Result delete(Long id) {
        userRepository.deleteById(id);
        return new SuccessResult("User deleted. Deleted id: " + id);
    }

    @Override
    public DataResult<Optional<User>> findById(Long id) {
        return new SuccessDataResult<>(userRepository.findById(id), "User listed. Id: " + id);
    }
}
