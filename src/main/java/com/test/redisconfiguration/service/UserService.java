package com.test.redisconfiguration.service;

import com.test.redisconfiguration.core.result.DataResult;
import com.test.redisconfiguration.core.result.Result;
import com.test.redisconfiguration.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    DataResult<List<User>> getAll();
    Result add(User user);
    Result delete(Long id);
    DataResult<Optional<User>> findById(Long id);
}
