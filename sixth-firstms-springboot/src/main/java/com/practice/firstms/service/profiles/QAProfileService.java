package com.practice.firstms.service.profiles;

import com.practice.firstms.service.ProfilesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("qa")
public class QAProfileService implements ProfilesService {
    @Override
    public String getProfiles() {
        return "QA Profile Data";
    }
}
