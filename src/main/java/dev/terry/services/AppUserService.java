package dev.terry.services;

import dev.terry.entities.AppUser;
import dev.terry.entities.enums.Role;

public interface AppUserService {
    public AppUser createAccount(AppUser appUser);

    public AppUser getUserByUsername(String username);

    public AppUser updateRole(AppUser appUser, Role role);
}
