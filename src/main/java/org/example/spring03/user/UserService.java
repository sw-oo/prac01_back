package org.example.spring03.user;

import lombok.RequiredArgsConstructor;
import org.example.spring03.user.model.AuthUserDetails;
import org.example.spring03.user.model.User;
import org.example.spring03.user.model.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void signup(UserDto.SignupReq dto) {
        User user = dto.toEntity();
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
    }


    // 시큐리티랑 상관 없는 내 서비스
    public UserDetails login(UserDto.LoginReq dto) throws UsernameNotFoundException {
        System.out.println("UserService 실행됨");

        User user = userRepository.findByEmail(dto.getEmail()).orElseThrow();


        if(passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            // 로그인 성공
        }

        if(user.isEnable()) {
            // 활성 상태 확인
        }



        return AuthUserDetails.from(user);
    }



    // TODO : 5번
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserService 실행됨");

        // TODO : 6번
        User user = userRepository.findByEmail(username).orElseThrow();


        // TODO : 7번
        return AuthUserDetails.from(user);
    }
}
