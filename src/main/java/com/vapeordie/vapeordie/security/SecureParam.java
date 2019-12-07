package com.vapeordie.vapeordie.security;

public interface SecureParam {
    public static final String HEADER_NAME = "Authorization";
    public static final String SECRET = "azizBourguiba" ;
    public static final long EXPIRATION = 14400000 ;
    public static final String HEADER_PREFIX = "bearer " ;
}
