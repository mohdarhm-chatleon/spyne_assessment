package com.spyne.backend.util;

import com.spyne.backend.exception.BaseException;
import com.spyne.backend.exception.InternalServerException;
import org.springframework.http.HttpStatus;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class PasswordUtils {

    // Configuration parameters
    private static final int SALT_LENGTH = 16; // Length of salt in bytes
    private static final int HASH_LENGTH = 64; // Length of hash in bytes
    private static final int ITERATIONS = 10000; // Number of PBKDF2 iterations
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

    /**
     * Hashes a password using PBKDF2 with a randomly generated salt.
     *
     * @param password The plain text password to be hashed.
     * @return A base64-encoded string containing the salt and hash separated by a colon.
     */
    public static String hashPassword(String password) throws BaseException {
        try {
            byte[] salt = generateSalt();
            byte[] hash = generateHash(password, salt);

            // Combine salt and hash and encode them
            return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new InternalServerException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error while hashing password");
        }
    }

    private static byte[] generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);
        return salt;
    }

    private static byte[] generateHash(String password, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, HASH_LENGTH * 8);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(spec).getEncoded();
    }
}
