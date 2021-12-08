package com.amr.project.service.abstracts;

import com.amr.project.model.entity.User;

import javax.persistence.NoResultException;

public interface UserService extends ReadWriteService<User, Long> {
    User findByUsername(String username) throws NoResultException;

    User findByEmail(String email) throws NoResultException;

    User findByPhone(String phone) throws NoResultException;

    @Override
    void persist(User user);
}
