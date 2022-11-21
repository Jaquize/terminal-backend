package mou.terminal.service;

import lombok.extern.slf4j.Slf4j;
import mou.terminal.rdbmsDomain.user.GoogleUserInfo;
import mou.terminal.rdbmsDomain.user.User;
import mou.terminal.rdbmsDomain.user.UserPrincipal;
import mou.terminal.rdbmsRepository.UserInfoRepo;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class OauthUserInfoService extends DefaultOAuth2UserService {

    private UserInfoRepo userInfoRepo;

    OauthUserInfoService(UserInfoRepo userInfoRepo){
        this.userInfoRepo = userInfoRepo;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(request);

        GoogleUserInfo googleUserInfo = new GoogleUserInfo(oAuth2User.getAttributes());

        User user = null;

        if(!this.userInfoRepo.findByUserId(googleUserInfo.getId()).equals(googleUserInfo.getId())){
            user = this.createUser(googleUserInfo);
        }
        return UserPrincipal.create(user,oAuth2User.getAttributes());
    }


    private User createUser(GoogleUserInfo googleUserInfo){

            User user = User.builder()
                    .userId(googleUserInfo.getId())
                    .email(googleUserInfo.getEmail())
                    .emamilVerified("Y")
                    .profileImageURL(googleUserInfo.getPicture())
                    .roleType("ROLE_USER")
                    .createDate(LocalDateTime.now())
                    .modifyDate(LocalDateTime.now())
                    .build();

            this.userInfoRepo.saveAndFlush(user);

            return user;

    }


}
