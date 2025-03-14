package com.project.Donation.util;

import com.project.Donation.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class AppUtil {
    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
