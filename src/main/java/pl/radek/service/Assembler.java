package pl.radek.service;

import org.springframework.security.core.userdetails.User;

import pl.radek.model.UserEntity;

public interface Assembler {

	User buildUserFromUserEntity(UserEntity userEntity);

}
