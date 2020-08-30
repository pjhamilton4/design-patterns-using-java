package com.philipjhamilton.patterns.behavioral.iterator.social;

import com.philipjhamilton.patterns.behavioral.iterator.ProfileIterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
