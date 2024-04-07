package edu.iu.habahram.DinerPancakeHouseMerge.security;

import com.nimbusds.jose.jwk.RSAKey;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.KeyPairGenerator.*;
import java.util.UUID;

public class Jwks {

    private Jwks(){}


    public static com.nimbusds.jose.jwk.RSAKey generateRSA(){
        KeyPair keyPair = edu.iu.habahram.DinerPancakeHouseMerge.security.KeyGeneratorUtils.generateRSAKey();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        return new RSAKey.Builder(publicKey).privateKey(privateKey).keyID(UUID.randomUUID().toString()).build();
    }
}
