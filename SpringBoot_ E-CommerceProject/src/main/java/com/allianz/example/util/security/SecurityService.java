package com.allianz.example.util.security;

import com.allianz.example.database.entity.UserEntity;
import com.allianz.example.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userEntityRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with email =" + email);
        }

        Set<GrantedAuthority> authorities = user.get().getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet());

        return new User(email, user.get().getPassword(), authorities);

        /*
        return new User(email,
                user.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_user")));

         */
    }
}
