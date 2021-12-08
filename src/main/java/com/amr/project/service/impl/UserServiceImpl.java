package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.UserDao;
import com.amr.project.model.entity.Mail;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.UserService;
import com.amr.project.service.email.EmailSenderService;
import com.amr.project.service.email.EmailVerificationService;
import com.amr.project.util.TrackedEmailUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;


@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final EmailVerificationService verificationService;
    private final TrackedEmailUser trackedEmailUser;
    private final EmailSenderService emailSenderService;

    @Autowired
    public UserServiceImpl(EmailSenderService emailSenderService, TrackedEmailUser trackedEmailUser, UserDao userDao, EmailVerificationService verificationService) {
        super(userDao);
        this.userDao = userDao;
        this.emailSenderService = emailSenderService;
        this.trackedEmailUser = trackedEmailUser;
        this.verificationService = verificationService;
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) throws NoResultException {
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) throws NoResultException {
        return userDao.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByPhone(String phone) throws NoResultException {
        return userDao.findByPhone(phone);
    }

    @Override
    @Transactional
    public void persist(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.persist(user);
        verificationService.sendVerificationEmail(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        if (user.getPassword() != null)
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        Mail mail = trackedEmailUser.trackedEmailUserUpdate(user, user.getPassword());
        if (mail != null)
            emailSenderService.sendSimpleEmail(mail);
        userDao.update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        emailSenderService.sendSimpleEmail(trackedEmailUser.trackedEmailUserDelete(user));
        userDao.delete(user);
    }
}
