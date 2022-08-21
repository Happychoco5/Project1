package dev.terry.data;

import dev.terry.entities.AppUser;

public interface AppUserDAO {
    public AppUser getAppUserByUsername(String username);

}
