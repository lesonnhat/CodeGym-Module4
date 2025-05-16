package com.codegym.springbootproductmanagement.service.impl;

import com.codegym.springbootproductmanagement.model.security.AppUser;
import com.codegym.springbootproductmanagement.model.security.UserPrinciple;
import com.codegym.springbootproductmanagement.repository.IAppUserRepo;
import com.codegym.springbootproductmanagement.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private IAppUserRepo appUserRepo;

    @Override
    public Iterable<AppUser> findAll() {
        return appUserRepo.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return appUserRepo.findById(id);
    }

    @Override
    public void save(AppUser appUser) {
        appUserRepo.save(appUser);
    }

    @Override
    public void remove(Long id) {
        appUserRepo.deleteById(id);
    }

    public AppUser findByUsername(String name) {
        return appUserRepo.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return UserPrinciple.build(appUserRepo.findByUsername(username));
    }
}
