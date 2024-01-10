package com.practice.firstms.service.profiles;

import com.practice.firstms.service.ProfilesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class DefaultProfileService implements ProfilesService {
    @Override
    public String getProfiles() {
        return "Default Profile Data";
    }
}
