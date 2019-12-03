package com.vapeordie.vapeordie.security;

public interface SecureParam {
    public static final String HEADER_NAME = "Authorization";
    public static final String SECRET = "azizBourguiba" ;
    public static final long EXPIRATION = (10*24*3600) ;
    public static final String HEADER_PREFIX = "bearer " ;
}
